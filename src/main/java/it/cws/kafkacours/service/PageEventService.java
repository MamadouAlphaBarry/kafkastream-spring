package it.cws.kafkacours.service;

import it.cws.kafkacours.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {
  @Bean
    Consumer<PageEvent> pageEventConsumer(){
        return (input)->{
           System.out.println("*********Consumer*********");
           System.out.println(input.toString());
           System.out.println("***********fin consumer**********");
        };
    }
    @Bean
    public Supplier<PageEvent> producer(){
      return ()-> PageEvent.builder().duretion(new Date().getTime()).date(new Date()).name("Alpha").build();
    }
    @Bean
    public Function<PageEvent, HashMap<String,PageEvent>> index(){
      return (input)->{
          PageEvent pageEvent= PageEvent.builder().name("Bloc Page").date(new Date()).use("Alpha Barry").build();
          HashMap map= new HashMap<>();
          map.put("event :",pageEvent);
          map.put("code: ", "success");
          return  null;
      };
    }
}
