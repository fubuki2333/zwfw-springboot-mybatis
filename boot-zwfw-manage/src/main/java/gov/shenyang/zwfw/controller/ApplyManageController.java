package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.enums.ApplyStatusEnum;
import gov.shenyang.zwfw.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ApplyManagerController
 * Package:gov.shenyang.zwfw.controller.admin
 * Description:
 *
 * @Date:2020/3/13 下午 4:17
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class ApplyManageController {

    @Autowired
    private ApplyService applyService;

    @GetMapping("/admin/apply/manage")
    public String applyManager(){
        return "apply_manage";
    }

    /**
     * 获取所有申报信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/apply/all",method = RequestMethod.GET)
    public PaginationDTO getAllApply(){
        PaginationDTO paginationDTO = applyService.list("3");
        return paginationDTO;
    }

    /**
     * 用户申报通过
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/admin/apply/accept",method = RequestMethod.PUT)
    public void acceptApply(@RequestParam Long id) {
        applyService.updateState(id, ApplyStatusEnum.APPLY_IS_SUCCESS.getStatus());
    }

    /**
     * 用户申报驳回
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/admin/apply/reject",method = RequestMethod.PUT)
    public void rejectApply(@RequestParam Long id) {
        applyService.updateState(id, ApplyStatusEnum.APPLY_IS_FAIL.getStatus());
    }

}
