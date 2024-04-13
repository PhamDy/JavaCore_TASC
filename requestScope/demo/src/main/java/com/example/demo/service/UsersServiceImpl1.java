package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.Impl.UsersService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Service
@Slf4j
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestScope
//@SessionScope
//@ApplicationScope
//@Lazy
public class UsersServiceImpl1 {

//    private static UsersServiceImpl1 instance;
//    private UsersServiceImpl1() {}

    public static int i = 1;

//    @PostConstruct
//    public void init(){
//       instance = this;
//    }

    @Autowired
    private UserRepo userRepo;

    public String sayHi() {
        return "I am Groot";
    }

    public UsersServiceImpl1() {
        System.out.println("Đã có " + i + " đối tượng được tạo");
        i++;
    }

    public void save(Integer id, String name) {
        var user = new Users();
        user.setId(id);
        user.setName(name);
        log.info(user.toString());
        userRepo.save(user);
    }

}
