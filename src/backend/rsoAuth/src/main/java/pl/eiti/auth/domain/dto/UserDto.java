package pl.eiti.auth.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable{
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

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
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

    public void setUserRolesFromDbList(List<pl.eiti.auth.domain.entity.UserRole> userRolesList) {
        if(userRoles == null){
            userRoles = new ArrayList<UserRoleDto>();

        }
        for (pl.eiti.auth.domain.entity.UserRole userRole: userRolesList) {
            userRoles.add(UserRoleDto.valueOf(userRole.getRoleName()));
        }
        this.userRoles = userRoles;
    }

}
