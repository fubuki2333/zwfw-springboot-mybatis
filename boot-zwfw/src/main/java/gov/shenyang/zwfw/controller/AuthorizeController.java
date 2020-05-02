package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.model.User;
import gov.shenyang.zwfw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * ClassName:LoginController
 * Package:gov.shengyang.zwfw.controller
 * Description:
 *
 * @Date:2020/2/23 下午 2:58
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class AuthorizeController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(Model model,
                          @RequestParam(value = "user", required = false) String userName,
                          @RequestParam(value = "pwd", required = false) String pwd,
                          HttpServletResponse response) {
        model.addAttribute("user", userName);
        model.addAttribute("pwd", pwd);

        if (userName == null || userName == "") {
            model.addAttribute("error", "用户名不能为空");
            return "login";
        }

        if (pwd == null || pwd == "") {
            model.addAttribute("error", "密码不能为空");
            return "login";
        }

        User user = userService.findUserByLoginName(userName);
        if (user == null){
            model.addAttribute("error", "用户不存在");
            return "login";
        } else if (user.getLoginPwd().equals(pwd)){
            response.addCookie(new Cookie("token", user.getToken()));
            return "redirect:/";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String doRegister(
            @RequestParam(value = "user", required = false) String userName,
            @RequestParam(value = "pwd", required = false) String pwd,
            @RequestParam(value = "real_name", required = false) String realName,
            @RequestParam(value = "id_card", required = false) String idCard,
            @RequestParam(value = "tel", required = false) String tel,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "address", required = false) String address,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model) {
        if (userName == null || userName == "") {
            model.addAttribute("error", "用户名不能为空");
            return "register";
        }

        if (pwd == null || pwd == "") {
            model.addAttribute("error", "密码不能为空");
            return "register";
        }

        User user = new User();
        user.setLoginName(userName);
        user.setLoginPwd(pwd);
        user.setRealName(realName);
        user.setIdCard(idCard);
        user.setUserTel(tel);
        user.setUserEmail(email);
        user.setAddress(address);
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        userService.createOrUpdate(user);

        response.addCookie(new Cookie("token", token));
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
