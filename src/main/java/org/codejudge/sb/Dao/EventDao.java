package org.codejudge.sb.Dao;

import java.util.ArrayList;

import org.codejudge.sb.entities.Event;

public interface EventDao {
    
    public boolean addEvent(int id, Event event);

    public String registerMember(int memberId, int eventId);

    public int computeWinner(int eventId);

}
