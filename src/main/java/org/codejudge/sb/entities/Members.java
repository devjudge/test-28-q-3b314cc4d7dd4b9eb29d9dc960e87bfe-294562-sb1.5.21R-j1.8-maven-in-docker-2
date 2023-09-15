package org.codejudge.sb.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Members {
    
    private long id;
    private String name;
    private int wallet;

    public Members(long id, String name, int wallet) {
        this.id = id;
        this.name = name;
        this.wallet = wallet;
    }

    public Members() {
    }

}
