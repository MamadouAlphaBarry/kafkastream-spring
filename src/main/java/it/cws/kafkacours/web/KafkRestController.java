package it.cws.kafkacours.web;

import it.cws.kafkacours.entities.PageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class KafkRestController {
@Autowired
    private StreamBridge bridge;
   @GetMapping("/publish/{topic}/{page}")
    PageEvent publish(@PathVariable(value = "topic") String topic,@PathVariable(value = "page") String page){
       PageEvent event= PageEvent.builder()
               .name("Alpha")
               .date(new Date())
               .duretion(new Date().getTime())
               .build();
       bridge.send(topic,event);
        return event;
    }
}
