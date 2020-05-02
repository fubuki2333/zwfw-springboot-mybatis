package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.enums.ApplyStatusEnum;
import gov.shenyang.zwfw.model.TreatmentRecord;
import gov.shenyang.zwfw.service.TreatmentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * ClassName:ApplyManagerController
 * Package:gov.shenyang.zwfw.controller.admin
 * Description:
 *
 * @Date:2020/3/13 下午 4:17
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class TreatmentManageController {

    @Autowired
    private TreatmentRecordService treatmentRecordService;

    @GetMapping("/admin/treatment/manage")
    public String treatmentManager(){
        return "treatment_manage";
    }

    /**
     * 获取所有备案信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/treatment/all",method = RequestMethod.GET)
    public PaginationDTO getAllTreatment(){
        PaginationDTO paginationDTO = treatmentRecordService.list();
        return paginationDTO;
    }

    /**
     * 获取指定备案信息
     * @param userId
     * @param treatmentDate
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/treatment/get",method = RequestMethod.GET)
    public PaginationDTO getTreatment(String userId,String treatmentDate){
        TreatmentRecord treatmentRecord = treatmentRecordService.get(Long.parseLong(userId),treatmentDate);
        PaginationDTO<TreatmentRecord> paginationDTO = new PaginationDTO<>();
        if (treatmentRecord == null){
            paginationDTO.setCode(1);
            paginationDTO.setMsg("医疗信息未报备");
        } else {
            String state = treatmentRecord.getState();
            if (state.equals(ApplyStatusEnum.APPLY_NOT_DEAL.getStatus())){
                paginationDTO.setCode(2);
                paginationDTO.setMsg("报备信息未审批");
            } else if (state.equals(ApplyStatusEnum.APPLY_IS_FAIL.getStatus())){
                paginationDTO.setCode(2);
                paginationDTO.setMsg("报备信息被驳回");
            } else {
                ArrayList<TreatmentRecord> treatmentRecords = new ArrayList<>();
                treatmentRecords.add(treatmentRecord);
                paginationDTO.setData(treatmentRecords);
            }
        }
        return paginationDTO;
    }

    /**
     * 备案信息通过
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/admin/treatment/accept",method = RequestMethod.PUT)
    public void acceptTreatment(@RequestParam Long id) {
        treatmentRecordService.updateState(id, ApplyStatusEnum.APPLY_IS_SUCCESS.getStatus());
    }

    /**
     * 备案信息驳回
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/admin/treatment/reject",method = RequestMethod.PUT)
    public void rejectTreatment(@RequestParam Long id) {
        treatmentRecordService.updateState(id, ApplyStatusEnum.APPLY_IS_FAIL.getStatus());
    }
}
