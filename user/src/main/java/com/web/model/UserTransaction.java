package com.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("UserTransaction")
public class UserTransaction implements Serializable {
    private String username;
    private int xp;
    private int ot;
    private int id;

    public String getUsername() {
        return username;
    }

    public int getXp() {
        return xp;
    }

    public int getOt() {
        return ot;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setOt(int ot) {
        this.ot = ot;
    }

    public void setId(int id) {
        this.id = id;
    }
}
