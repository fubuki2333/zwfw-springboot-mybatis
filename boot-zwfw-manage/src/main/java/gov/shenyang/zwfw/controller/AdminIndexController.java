package gov.shenyang.zwfw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:AdminIndexController
 * Package:gov.shenyang.zwfw.controller
 * Description:
 *
 * @Date:2020/3/6 上午 10:52
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class AdminIndexController {

    @GetMapping("/admin")
    public String index(){
        return "index";
    }
}
