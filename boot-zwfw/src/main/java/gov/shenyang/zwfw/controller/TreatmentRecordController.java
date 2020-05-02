package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.model.TreatmentRecord;
import gov.shenyang.zwfw.model.User;
import gov.shenyang.zwfw.service.TreatmentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:TreatmentRecordController
 * Package:gov.shenyang.zwfw.controller
 * Description:
 *
 * @Date:2020/3/22 上午 9:47
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class TreatmentRecordController {

    @Autowired
    private TreatmentRecordService treatmentRecordService;

    @GetMapping("/treatmentRecord")
    public String apply(Model model){
        return "treatment_record";
    }

    @PostMapping("/treatmentRecord")
    public String doApply(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "hospital", required = false) String hospital,
            @RequestParam(value = "date", required = false) String date,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model){

        model.addAttribute("name",name);
        model.addAttribute("hospital",hospital);
        model.addAttribute("date",date);

        User user = (User) request.getSession().getAttribute("user");

        if (name == null){
            model.addAttribute("error","姓名不能为空");
            return "treatment_record";
        }

        if (!name.equals(user.getRealName())){
            model.addAttribute("error","请输入当前账号绑定的姓名");
            return "treatment_record";
        }

        if (hospital == null){
            model.addAttribute("error","医疗机构不能为空");
            return "treatment_record";
        }

        if (date == null){
            model.addAttribute("error","日期不能为空");
            return "treatment_record";
        }

        if (user == null){
            model.addAttribute("error","用户未登录");
            return "treatment_record";
        }

        TreatmentRecord treatmentRecord = new TreatmentRecord();
        treatmentRecord.setUserId(user.getUserId());
        treatmentRecord.setTreatmentDate(date);
        treatmentRecord.setHospital(hospital);
        treatmentRecordService.createOrUpdate(treatmentRecord);

        return "redirect:/";
    }
}
