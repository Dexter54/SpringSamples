package com.ilgun;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class CustomEventPublisher implements ApplicationEventPublisher {

    private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher (ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    public void publish() {
        CustomEvent ce = new CustomEvent(this);
        publisher.publishEvent(ce);
    }


    @Override
    public void publishEvent(ApplicationEvent event) {

    }

    @Override
    public void publishEvent(Object o) {

    }
}
