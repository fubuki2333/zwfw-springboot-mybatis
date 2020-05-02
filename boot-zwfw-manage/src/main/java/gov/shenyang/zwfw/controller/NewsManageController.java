package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.NewsCreateDTO;
import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.model.News;
import gov.shenyang.zwfw.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:NewsController
 * Package:gov.shenyang.zwfw.controller.admin
 * Description:
 *
 * @Date:2020/3/16 下午 10:17
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class NewsManageController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/admin/news/add")
    public String applyAdd(){
        return "news_add";
    }

    /**
     * 添加新闻
     * @param newsCreateDTO
     * @param request
     */
    @ResponseBody
    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    public void post(@RequestBody NewsCreateDTO newsCreateDTO,
                       HttpServletRequest request) {
        News news = new News();
        news.setTitle(newsCreateDTO.getTitle());
        news.setAuthor(newsCreateDTO.getAuthor());
        news.setContent(newsCreateDTO.getContent());
        news.setGmtCreate(System.currentTimeMillis());
        newsService.insert(news);
    }

    @GetMapping("/admin/news/manage")
    public String applyManage(){
        return "news_manage";
    }

    /**
     * 获取所有新闻信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/news/getAll",method = RequestMethod.GET)
    public PaginationDTO getAllApply(){
        PaginationDTO paginationDTO = newsService.list();
        return paginationDTO;
    }
}
