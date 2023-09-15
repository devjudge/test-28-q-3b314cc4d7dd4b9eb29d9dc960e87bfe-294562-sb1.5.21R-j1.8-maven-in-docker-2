package org.codejudge.sb.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.codejudge.sb.Dao.EventDao;
import org.codejudge.sb.entities.Bids;
import org.codejudge.sb.entities.Event;

import lombok.Getter;

@Getter
public class EventsService implements EventDao{

    private Map<Integer, Event> events = new HashMap<>();

    @Override
    public boolean addEvent(int id, Event event) {
        if(!this.events.containsKey(id)){
            this.events.put(id, event);
            return true;
        }
        return false;
    }

    @Override
    public String registerMember(int memberId, int eventId) {
        Map<Integer, Bids> registeredMember;
        if(this.events.containsKey(eventId)){
            registeredMember = this.events.get(eventId).getRegisterdMemebers();
        }else{
            return "Invalid Event Id";
        }
        if(registeredMember.containsKey(memberId)){
            return "Member Already Registered";
        }else {
            registeredMember.put(memberId, new Bids());
            return "Registered to the BBD event Successfully";
        }
    }

    @Override
    public int computeWinner(int eventId) {
        Event event;
        if(this.events.containsKey(eventId)){
            event = this.events.get(eventId);
        }else{
            return Integer.MIN_VALUE;
        }   

        Map<Integer, Bids> membersForEvent = event.getRegisterdMemebers();

        int lowestBid = Integer.MAX_VALUE;
        int winner = -1;
        LocalDateTime lowestBidTime = null;
        boolean flag = true;
        for(Map.Entry<Integer,Bids> entry : membersForEvent.entrySet()){
            int currentMemberLowestBid = entry.getValue().getBids().stream().sorted().collect(Collectors.toList()).get(0);
            if(flag){
                lowestBid = currentMemberLowestBid;
                lowestBidTime = entry.getValue().getDate();
                winner = entry.getKey();
                flag = false;
                continue;
            }
            if(currentMemberLowestBid < lowestBid){
                lowestBid = currentMemberLowestBid;
                lowestBidTime = entry.getValue().getDate();
                winner = entry.getKey();
                
            }else if(currentMemberLowestBid == lowestBid){
                if(entry.getValue().getDate().isBefore(lowestBidTime)){
                    lowestBid = currentMemberLowestBid;
                    lowestBidTime = entry.getValue().getDate();
                    winner = entry.getKey();
                }
            }
        }

        return winner;

        
    }
    
}
