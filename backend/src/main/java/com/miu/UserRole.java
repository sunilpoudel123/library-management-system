package com.miu;

public abstract class UserRole{
    private String roleName;
    public UserRole(String roleName){
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }
}
