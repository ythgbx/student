package net.bus.web.teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/9.
 * 分页的辅助类
 */
public class PageUtil {

    /**
     *
     * @param list 查到的结果集
     * @param total 总的数量 easyui 根据总数和每页显示的数量计算页数
     * @return
     */
    public static Map<String,Object> returnMap(List list,int total){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    public static Map<String,Object> pageMap(int page,int rows){
        Map<String,Object> map = new HashMap<String, Object>();
        int start = (page-1)*rows;
        int end = rows;
        map.put("start", start);
        map.put("end", end);
        return map;
    }
}
