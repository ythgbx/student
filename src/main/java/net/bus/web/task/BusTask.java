package net.bus.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Edifi_000 on 2016-07-02.
 */
public class BusTask {

    private static Logger logger = LoggerFactory.getLogger(BusTask.class);

    /**
     * 定期任务处理
     */
    public void doBiz() {
        logger.info("do task");
    }
}
