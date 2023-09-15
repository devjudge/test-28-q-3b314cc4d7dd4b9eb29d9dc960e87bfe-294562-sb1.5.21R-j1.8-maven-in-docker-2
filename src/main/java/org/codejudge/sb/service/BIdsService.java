package org.codejudge.sb.service;

import java.util.ArrayList;
import java.util.Map;

import org.w3c.dom.events.Event;

public class BIdsService {
    
    public String addBids(int eventId, int memberId, ArrayList<Integer> bids, Map<Integer, Event> events) {

        if(!events.containsKey(eventId)){
            return "Invalid Event Id";
        }

        if(!events.get(eventId).getRegisterdMemebers().containsKey(memberId)){
            return "Member not registered";
        }

        



    }
}
