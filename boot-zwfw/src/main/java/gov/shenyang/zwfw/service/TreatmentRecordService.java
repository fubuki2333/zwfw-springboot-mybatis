package gov.shenyang.zwfw.service;

import gov.shenyang.zwfw.dto.AdminTreatmentDTO;
import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.enums.ApplyStatusEnum;
import gov.shenyang.zwfw.mapper.TreatmentRecordMapper;
import gov.shenyang.zwfw.mapper.UserMapper;
import gov.shenyang.zwfw.model.TreatmentRecord;
import gov.shenyang.zwfw.model.TreatmentRecordExample;
import gov.shenyang.zwfw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:TreatmentRecordService
 * Package:gov.shenyang.zwfw.service
 * Description:
 *
 * @Date:2020/3/22 上午 10:00
 * @Author:gaochenyu2020@163.com
 */
@Service
public class TreatmentRecordService {

    @Autowired
    private TreatmentRecordMapper treatmentRecordMapper;

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(TreatmentRecord treatmentRecord){
        if (treatmentRecord.getId() == null){
            treatmentRecord.setGmtCreate(System.currentTimeMillis());
            treatmentRecord.setGmtModified(System.currentTimeMillis());
            treatmentRecordMapper.insertSelective(treatmentRecord);
        } else {

        }

    }

    public PaginationDTO list(){
        PaginationDTO<AdminTreatmentDTO> paginationDTO = new PaginationDTO<>();
        TreatmentRecordExample treatmentExample = new TreatmentRecordExample();
        treatmentExample.createCriteria();
        treatmentExample.setOrderByClause("gmt_create");
        List<TreatmentRecord> treatmentRecords = treatmentRecordMapper.selectByExample(treatmentExample);
        ArrayList<AdminTreatmentDTO> adminTreatmentDTOS = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (TreatmentRecord treatmentRecord : treatmentRecords) {
            User user = userMapper.selectByPrimaryKey(treatmentRecord.getUserId());
            AdminTreatmentDTO adminTreatmentDTO = new AdminTreatmentDTO();
            adminTreatmentDTO.setId(treatmentRecord.getId());
            adminTreatmentDTO.setUserName(user.getRealName());
            adminTreatmentDTO.setIdCard(user.getIdCard());
            adminTreatmentDTO.setHospital(treatmentRecord.getHospital());
            adminTreatmentDTO.setTreatmentDate(treatmentRecord.getTreatmentDate());
            adminTreatmentDTO.setGmtCreate(dateFormat.format(treatmentRecord.getGmtCreate()));
            adminTreatmentDTO.setStateMessage(ApplyStatusEnum.messageOfStatus(treatmentRecord.getState()));
            adminTreatmentDTOS.add(adminTreatmentDTO);
        }
        paginationDTO.setCount(adminTreatmentDTOS.size());
        paginationDTO.setData(adminTreatmentDTOS);
        return paginationDTO;
    }


    public TreatmentRecord get(Long userId, String treatmentDate) {
        TreatmentRecordExample treatmentRecordExample = new TreatmentRecordExample();
        treatmentRecordExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andTreatmentDateEqualTo(treatmentDate);
        treatmentRecordExample.setOrderByClause("gmt_create desc");
        List<TreatmentRecord> treatmentRecords = treatmentRecordMapper.selectByExample(treatmentRecordExample);
        if (treatmentRecords.size() < 1){
            return null;
        } else {
            TreatmentRecord treatmentRecord = treatmentRecords.get(0);
            return treatmentRecord;
        }
    }

    public void updateState(Long id, String status) {
        TreatmentRecordExample recordExample = new TreatmentRecordExample();
        recordExample.createCriteria()
                .andIdEqualTo(id);
        List<TreatmentRecord> treatmentRecords = treatmentRecordMapper.selectByExample(recordExample);
        TreatmentRecord treatmentRecord = treatmentRecords.get(0);
        treatmentRecord.setState(status);
        treatmentRecordMapper.updateByPrimaryKey(treatmentRecord);
    }
}
