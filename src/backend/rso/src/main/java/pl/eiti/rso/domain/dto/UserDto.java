package pl.eiti.rso.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    String username;
    String password;
    List<UserRoleDto> userRoles;

    public UserDto() {
        userRoles = new ArrayList<UserRoleDto>();
    }

    public UserDto(String username, String password, List<UserRoleDto> userRoleDtos) {
        this.username = username;
        this.password = password;
        this.userRoles = userRoleDtos;
    }

    public List<UserRoleDto> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleDto> userRoleDtos) {
        this.userRoles = userRoleDtos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
