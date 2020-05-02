package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:UserManageController
 * Package:gov.shenyang.zwfw.controller.admin
 * Description:
 *
 * @Date:2020/4/1 下午 8:48
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class UserManageController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/user/manage")
    public String applyManager(){
        return "user_manage";
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/user/all",method = RequestMethod.GET)
    public PaginationDTO getAllUsers(){
        PaginationDTO paginationDTO = userService.list();
        return paginationDTO;
    }

    /**
     * 删除指定用户
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/user/del",method = RequestMethod.DELETE)
    public int deleteUser(@RequestParam(value="userId")Long userId){
        boolean res = userService.delete(userId);
        if (res){
            return 0;
        }
        return 1;
    }
}
