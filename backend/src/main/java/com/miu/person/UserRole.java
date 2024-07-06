package com.miu.person;

import java.io.Serializable;

public abstract class UserRole implements Serializable {
    private String roleName;

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
