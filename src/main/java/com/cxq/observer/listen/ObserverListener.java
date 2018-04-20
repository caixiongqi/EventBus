package com.cxq.observer.listen;

import com.cxq.observer.utils.DataSourceUtils;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ObserverListener {

    private static Logger logger = LoggerFactory.getLogger(ObserverListener.class);

    @Subscribe
    public void onGetEvent(String data) {
        logger.info("观察者观察到的数据为：{}", data);
        DataSourceUtils.getDataSource();
    }

}
