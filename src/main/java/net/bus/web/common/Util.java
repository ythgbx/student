package net.bus.web.common;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sky on 16/11/1.
 */
public class Util {
    /**
     * 计算两个Date之间的天数
     * @param to 时间（较小值）
     * @param from 时间（较大值）
     * @return 天数（int）
     */
    public static int daysBetween(Date from, Date to) {
        return (int) Math.ceil((double)(to.getTime() - from.getTime())/(1000 * 60 * 60 * 24));
    }
}