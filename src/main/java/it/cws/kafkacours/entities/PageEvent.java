package it.cws.kafkacours.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageEvent {
    private String name;
    private String use;
    private Date date;
    private long duretion;

}
