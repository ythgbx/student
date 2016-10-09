package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.NewsDetail;
import net.bus.web.controller.dto.NewsItem;
import net.bus.web.controller.dto.NewsList;
import net.bus.web.model.News;
import net.bus.web.service.INewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-09.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService _newsService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部新闻", httpMethod = "GET", response = NewsList.class, notes = "获取全部新闻")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("news all query");
        NewsList newsList = new NewsList();
        newsList.setNews(getDisplayList(_newsService.getAllNews(page,limit)));
        newsList.setPage(page);
        newsList.setTotal_count(_newsService.getAllNewsCount());
        return newsList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取新闻详细", httpMethod = "GET", response = NewsDetail.class, notes = "获取新闻详细")
    public IResult detail(@ApiParam(required = true, name = "id", value = "id")@RequestParam(value = "id", required = true, defaultValue = "0")long id)
    {
        logger.info("news detail");
        NewsDetail newsDetail = new NewsDetail();
        News news = _newsService.getNewsDetails(id);
        newsDetail.setId(news.getId());
        newsDetail.setTitle(news.getTitle());
        newsDetail.setAuthor(news.getAuthor());
        newsDetail.setType(news.getType());
        newsDetail.setContent(news.getContent());
        newsDetail.setImg(news.getImage());
        newsDetail.setTime(news.getTime().getTime());
        return newsDetail;
    }

    private List<NewsItem> getDisplayList(List<News> newsList)
    {
        List<NewsItem> displayList = new ArrayList<NewsItem>();
        for (News news : newsList) {
            NewsItem disItem = new NewsItem();
            disItem.setId(news.getId());
            disItem.setImg(news.getImage());
            disItem.setTitle(news.getTitle());
            disItem.setType(news.getType());
            displayList.add(disItem);
        }
        return displayList;
    }
}
