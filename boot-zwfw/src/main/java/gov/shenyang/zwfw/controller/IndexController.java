package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:IndexController
 * Package:gov.shengyang.zwfw.controller
 * Description:
 *
 * @Date:2020/2/23 下午 4:07
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class IndexController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String index(Model model) {
        PaginationDTO paginationDTO = newsService.list(6);
        model.addAttribute("news",paginationDTO);
        return "index";
    }

}
