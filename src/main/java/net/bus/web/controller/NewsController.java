package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Activity;
import net.bus.web.model.News;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.service.INewsService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Auth(role = Auth.Role.NONE)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value = "新闻列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "新闻列表页面")
    @ResponseBody
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request, Model model)
    {
        logger.info("url:/news/list");
       HttpSession session=request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("news_list");
        List<News> newsList=_newsService.getAllNews(page,limit);
        PagePojo pagePojo = new PagePojo(_newsService.getAllNewsCount(),limit,page);
        mv.addObject("newsList",newsList);
        session.setAttribute("pagePojo",pagePojo);
        return mv;
    }

    @Auth(role = Auth.Role.NONE)
    @RequestMapping(value="/addnews", method = RequestMethod.POST)
    @ApiOperation(value = "添加新闻",httpMethod = "POST",response = ModelAndView.class,notes="添加新闻")
    @ResponseBody
    public BaseResult AddNews (@ApiParam(required = true,name = "addnews",value = "添加新闻")
                                 @RequestBody News news

    )  {
        logger.info("url:/news/addnews");
        BaseResult result=new BaseResult();
        if(_newsService.addNews(news)){
            result.setResult("success");
            result.setContent("添加成功!");
        }else{
            result.setResult("failure");
            result.setContent("添加失败!");
        }
       return result;
    }

    @Auth(role= Auth.Role.USER)
    @RequestMapping(value = "/del" ,method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除新闻",httpMethod = "POST",response = BaseResult.class,notes = "批量删除新闻")
    @ResponseBody
    public BaseResult Del(@ApiParam(required = true, name = "del", value = "批量删除活动") @RequestBody BaseRequest request)
    {
        logger.info("url:/news/del");
        BaseResult result=new BaseResult();
        List<Long> ids =request.getIds();
        if(_newsService.delete(ids)){
            result.setResult("success");
            result.setContent("删除成功!");
        }else{
            result.setResult("failure");
            result.setContent("删除失败!");
        }

        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @RequestMapping(value="/updatenews", method = RequestMethod.POST)
    @ApiOperation(value = "修改新闻",httpMethod = "POST",response = ModelAndView.class,notes="添加新闻")
    @ResponseBody
    public BaseResult UpdateNews (@ApiParam(required = true,name = "updatenews",value = "添加新闻")
                               @RequestBody News news

    )  {
        logger.info("url:/news/updatenews");
        BaseResult result=new BaseResult();
        if(_newsService.update(news)){
            result.setResult("success");
            result.setContent("修改成功!");
        }else{
            result.setResult("failure");
            result.setContent("修改失败!");
        }
        return result;
    }
}
