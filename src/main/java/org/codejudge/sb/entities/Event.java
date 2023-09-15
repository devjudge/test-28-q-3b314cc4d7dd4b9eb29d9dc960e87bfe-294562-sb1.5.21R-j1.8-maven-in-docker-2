package org.codejudge.sb.entities;

import java.time.LocalDate;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    
    private int id;
    private String eventName;
    private String prize;
    private LocalDate date;
    private HashMap<Integer, Bids> registerdMemebers;
    private long winner;
}
