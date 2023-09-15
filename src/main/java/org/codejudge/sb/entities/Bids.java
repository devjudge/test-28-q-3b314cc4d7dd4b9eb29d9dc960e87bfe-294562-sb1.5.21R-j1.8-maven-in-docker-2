package org.codejudge.sb.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bids {
    
    private ArrayList<Integer> bids;
    private LocalDateTime date;

}
