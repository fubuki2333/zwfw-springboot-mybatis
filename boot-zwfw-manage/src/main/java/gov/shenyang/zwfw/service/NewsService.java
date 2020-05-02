package gov.shenyang.zwfw.service;

import gov.shenyang.zwfw.dto.NewsDTO;
import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.mapper.NewsMapper;
import gov.shenyang.zwfw.model.News;
import gov.shenyang.zwfw.model.NewsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:NewsService
 * Package:gov.shenyang.zwfw.service
 * Description:
 *
 * @Date:2020/3/16 下午 10:54
 * @Author:gaochenyu2020@163.com
 */
@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public void insert(News news){
        newsMapper.insert(news);
    }

    public PaginationDTO list() {
        PaginationDTO<NewsDTO> newsPaginationDTO = new PaginationDTO<>();
        NewsExample newsExample = new NewsExample();
        newsExample.createCriteria();
        newsExample.setOrderByClause("gmt_create");
        List<News> newsList = newsMapper.selectByExample(newsExample);
        ArrayList<NewsDTO> newsDTOS = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (News news : newsList) {
            NewsDTO newsDTO = new NewsDTO();
            newsDTO.setId(news.getId());
            newsDTO.setTitle(news.getTitle());
            newsDTO.setAuthor(news.getAuthor());
            newsDTO.setContent(news.getContent());
            newsDTO.setCreateDate(simpleDateFormat.format(news.getGmtCreate()));
            newsDTOS.add(newsDTO);
        }
        newsPaginationDTO.setCount(newsList.size());
        newsPaginationDTO.setData(newsDTOS);
        return newsPaginationDTO;
    }

    public PaginationDTO list(int size) {
        PaginationDTO<News> newsPaginationDTO = new PaginationDTO<>();
        NewsExample newsExample = new NewsExample();
        newsExample.createCriteria();
        newsExample.setOrderByClause("gmt_create");
        List<News> news = newsMapper.selectByExample(newsExample);
        List<News> newsList = news.subList(0, size);
        newsPaginationDTO.setData(newsList);
        newsPaginationDTO.setCount(size);
        return newsPaginationDTO;
    }
}
