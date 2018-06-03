package pl.eiti.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.eiti.auth.domain.dto.UserDto;
import pl.eiti.auth.domain.entity.User;
import pl.eiti.auth.domain.entity.UserRole;
import pl.eiti.auth.domain.repositories.HibernateDaoImpl;
import pl.eiti.auth.domain.repositories.UserRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class OAuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private HibernateDaoImpl hibernateDao;

    @Autowired
    UserDetailsService userDetailsService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_SERVICE')")
    @RequestMapping("/getOwnPrincipal")
    public User getOwnPrincipal(@AuthenticationPrincipal Principal user) {
        return User.fromprinicpal(user);
    }

    @PreAuthorize("hasRole('ROLE_SERVICE')")
    @RequestMapping("/userPrinicpal")
    public UserDto getUserPrinicpal(@RequestParam String username) {
        User user = (User) userDetailsService.loadUserByUsername(username);
        return new UserDto(user);
    }

    @RequestMapping(value = "/users")
    public String index() {
        List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(userList::add);
        return userList.toString();
    }

    @PreAuthorize("hasRole('ROLE_SERVICE')")
    @RequestMapping(value = "/lol")
    public String index3() {
        return "lol";
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
