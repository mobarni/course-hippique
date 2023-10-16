package com.pmu.course.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "course-topic", groupId = "myGroup")
    public void listener(String data){
        System.out.println("Listener reçoit = " + data);
    }
}
