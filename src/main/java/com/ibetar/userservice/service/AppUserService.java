package com.ibetar.userservice.service;

import com.ibetar.userservice.entity.AppUser;
import com.ibetar.userservice.entity.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveAppUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
