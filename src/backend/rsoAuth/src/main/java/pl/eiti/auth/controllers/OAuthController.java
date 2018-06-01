package pl.eiti.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.eiti.auth.domain.dto.UserDto;
import pl.eiti.auth.domain.entity.User;
import pl.eiti.auth.domain.entity.UserRole;
import pl.eiti.auth.domain.repositories.HibernateDaoImpl;
import pl.eiti.auth.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OAuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private HibernateDaoImpl hibernateDao;

    @RequestMapping(value = "/")
    public String index() {
        List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(userList::add);
        return userList.toString();
    }

    @RequestMapping(value = "/lol")
    public String index3() {
        return "lol";
    }

    @PreAuthorize("hasRole('ROLE_SERVICE')")
    @RequestMapping(value = "/api/autorization", method = RequestMethod.GET)
    public UserDto autorizationUser(@RequestParam String userName, @RequestParam String password) {
        User userDb = userRepository.findByUserNameAndPassword(userName,"");
        if(userDb == null){
            return null;
        }
        UserDto user = new UserDto(userName,password);
        List<UserRole> userRoles = userDb.getUserRoles();
        user.setUserRolesFromDbList(userRoles);
        return user;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HibernateDaoImpl getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDaoImpl hibernateDao) {
        this.hibernateDao = hibernateDao;
    }
}
