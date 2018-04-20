package com.cxq.observer.service;

import com.cxq.observer.listen.ObserverListener;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObserverServiceImpl implements ObserverService {

    @Autowired
    private EventBus eventBus;

    @Override
    public String observerEvent(String data) {
        eventBus.register(new ObserverListener());
        eventBus.post(data);
        return "被观察者事件";
    }
}
