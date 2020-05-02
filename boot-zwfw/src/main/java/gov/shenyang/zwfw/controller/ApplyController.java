package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.model.Apply;
import gov.shenyang.zwfw.model.User;
import gov.shenyang.zwfw.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:PublishController
 * Package:gov.shenyang.zwfw.controller
 * Description:
 *
 * @Date:2020/3/6 下午 1:42
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @GetMapping("/apply")
    public String apply(Model model){
        return "apply";
    }

    @PostMapping("/apply")
    public String doApply(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "idcard", required = false) String idCard,
            @RequestParam(value = "careid", required = false) String careId,
            @RequestParam(value = "care", required = false) String care,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "prescription", required = false) String prescription,
            @RequestParam(value = "invoice", required = false) String invoice,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model){

        model.addAttribute("name",name);
        model.addAttribute("idcard",idCard);
        model.addAttribute("careid",careId);
        model.addAttribute("care",care);
        model.addAttribute("date",date);
        model.addAttribute("prescription",prescription);
        model.addAttribute("invoice",invoice);

        User user = (User) request.getSession().getAttribute("user");

        if (name == null){
            model.addAttribute("error","姓名不能为空");
            return "apply";
        }

        if (!name.equals(user.getRealName())){
            model.addAttribute("error","请输入当前账号绑定的姓名");
            return "apply";
        }

        if (idCard == null){
            model.addAttribute("error","身份证照片未上传");
            return "apply";
        }

        if (careId == null){
            model.addAttribute("error","医保卡号不能为空");
            return "apply";
        }

        if (care == null){
            model.addAttribute("error","医保卡照片未上传");
            return "apply";
        }

        if (date == null){
            model.addAttribute("error","入院日期不能为空");
            return "apply";
        }

        if (prescription == null){
            model.addAttribute("error","明细清单未上传");
            return "apply";
        }

        if (invoice == null){
            model.addAttribute("error","医药费发票未上传");
            return "apply";
        }

        if (user == null){
            model.addAttribute("error","用户未登录");
            return "apply";
        }

        Apply apply = new Apply();
        apply.setUserId(user.getUserId());
        apply.setIdCardPic(idCard);
        apply.setCareCard(careId);
        apply.setCareCardPic(care);
        apply.setTreatmentDate(date);
        apply.setPrescriptionPic(prescription);
        apply.setInvoicePic(invoice);
        applyService.createOrUpdate(apply);

        return "redirect:/";
    }

    @GetMapping("/apply/{id}")
    public String applyMessage(@PathVariable(name = "id")Long id, Model model){

        return "apply";
    }

    @GetMapping("/mymessage")
    public String showUserMessage(Model model,
                                  HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("userName",user.getLoginName());
        model.addAttribute("realName",user.getRealName());
        model.addAttribute("idcard",user.getIdCard());
        model.addAttribute("email",user.getUserEmail());
        model.addAttribute("tel",user.getUserTel());
        model.addAttribute("address",user.getAddress());
        return "mymessage";
    }

    @GetMapping("/applylog")
    public String showApplyLog(Model model,
                               HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        PaginationDTO paginationDTO = applyService.list(user.getUserId());
        model.addAttribute("pagination",paginationDTO);
        return "applylog";
    }

    @ResponseBody
    @RequestMapping(value = "/user/getapplylog",method = RequestMethod.GET)
    public PaginationDTO getAllApply(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        PaginationDTO paginationDTO = applyService.list(user.getUserId());
        return paginationDTO;
    }

}
