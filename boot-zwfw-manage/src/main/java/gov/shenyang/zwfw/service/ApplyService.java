package gov.shenyang.zwfw.service;

import gov.shenyang.zwfw.dto.AdminApplyDTO;
import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.dto.UserApplyDTO;
import gov.shenyang.zwfw.enums.ApplyStatusEnum;
import gov.shenyang.zwfw.mapper.ApplyMapper;
import gov.shenyang.zwfw.mapper.UserMapper;
import gov.shenyang.zwfw.model.Apply;
import gov.shenyang.zwfw.model.ApplyExample;
import gov.shenyang.zwfw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ApplyService
 * Package:gov.shenyang.zwfw.service
 * Description:
 *
 * @Date:2020/3/11 上午 10:31
 * @Author:gaochenyu2020@163.com
 */
@Service
public class ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(Apply apply){
        if (apply.getId() == null){
            apply.setGmtCreate(System.currentTimeMillis());
            applyMapper.insertSelective(apply);
        } else {

        }

    }

    public PaginationDTO list(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        String realName = user.getRealName();
        PaginationDTO<UserApplyDTO> paginationDTO = new PaginationDTO<>();
        ApplyExample applyExample = new ApplyExample();
        applyExample.createCriteria()
                .andUserIdEqualTo(userId);
        applyExample.setOrderByClause("gmt_create desc");
        List<Apply> applies = applyMapper.selectByExample(applyExample);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<UserApplyDTO> applyDTOList = new ArrayList<>();
        for (Apply apply : applies) {
            UserApplyDTO userApplyDTO = new UserApplyDTO();
            userApplyDTO.setId(apply.getId());
            userApplyDTO.setCreator(realName);
            userApplyDTO.setGmtCreate(dateFormat.format(apply.getGmtCreate()));
            userApplyDTO.setType("异地医疗报销审批");
            String state = apply.getState();
            userApplyDTO.setStateMessage(ApplyStatusEnum.messageOfStatus(state));
            applyDTOList.add(userApplyDTO);
        }
        paginationDTO.setCount(applyDTOList.size());
        paginationDTO.setData(applyDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(String state){
        PaginationDTO<AdminApplyDTO> paginationDTO = new PaginationDTO<>();
        ApplyExample applyExample = new ApplyExample();
        // 如果状态为“3”，则不设置条件，查询出所有记录
        if (!state.equals("3")){
            applyExample.createCriteria()
                    .andStateEqualTo(state);
        }
        applyExample.setOrderByClause("gmt_create");
        List<Apply> applies = applyMapper.selectByExample(applyExample);
        List<AdminApplyDTO> applyDTOList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Apply apply : applies) {
            User user = userMapper.selectByPrimaryKey(apply.getUserId());
            AdminApplyDTO adminApplyDTO = new AdminApplyDTO();
            adminApplyDTO.setId(apply.getId());
            adminApplyDTO.setUserId(apply.getUserId());
            adminApplyDTO.setUserName(user.getRealName());
            adminApplyDTO.setIdCard(user.getIdCard());
            adminApplyDTO.setIdCardPic(apply.getIdCardPic());
            adminApplyDTO.setCareCard(apply.getCareCard());
            adminApplyDTO.setCareCardPic(apply.getCareCardPic());
            adminApplyDTO.setPrescriptionPic(apply.getPrescriptionPic());
            adminApplyDTO.setInvoicePic(apply.getInvoicePic());
            adminApplyDTO.setTreatmentDate(apply.getTreatmentDate());
            adminApplyDTO.setGmtCreate(dateFormat.format(apply.getGmtCreate()));
            String state1 = apply.getState();
            adminApplyDTO.setStateMessage(ApplyStatusEnum.messageOfStatus(state1));
            applyDTOList.add(adminApplyDTO);
        }
        paginationDTO.setCount(applyDTOList.size());
        paginationDTO.setData(applyDTOList);
        return paginationDTO;
    }

    /**
     * 更新申报处理状态
     * @param id
     * @param status
     */
    public void updateState(Long id, String status) {
        ApplyExample applyExample = new ApplyExample();
        applyExample.createCriteria()
                .andIdEqualTo(id);
        List<Apply> applies = applyMapper.selectByExample(applyExample);
        Apply apply = applies.get(0);
        apply.setState(status);
        applyMapper.updateByPrimaryKey(apply);
    }
}
