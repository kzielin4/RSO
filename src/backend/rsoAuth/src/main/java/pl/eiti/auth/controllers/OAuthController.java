package pl.eiti.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.eiti.auth.domain.entity.User;
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
