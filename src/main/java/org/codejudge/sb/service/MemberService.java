package org.codejudge.sb.service;

import java.util.HashMap;
import java.util.Map;

import org.codejudge.sb.Dao.MembersDao;
import org.codejudge.sb.entities.Members;

public class MemberService implements MembersDao {

    private Map<Integer, Members> members = new HashMap<>();

    @Override
    public boolean addMember(int id, Members member) {
        
        if(!this.members.containsKey(id)){
            this.members.put(id, member);
            return true;
        }
        return false;
    }
    
}
