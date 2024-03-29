package com.team.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SysUser {
    private String id;

    @NotNull(message = "{user.username.notnull}")
    private String username;

    @Size(min = 2,max = 5,message = "{user.password.size}")
    private String password;

    private String locked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }
}