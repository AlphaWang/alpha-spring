package com.alphawang.spring.mvc.model;

import com.alphawang.spring.mvc.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@RestController
@SessionAttributes("user") // value = {"user"}, types = {User.class}
public class SessionAttributesController {

    @RequestMapping("/model/session")
    public Object handle1(ModelMap modelMap) {
        User user = (User) modelMap.get("user");
        user.setName(user.getName() + "-Step_1");
        
        return "redirect:model/session2";
    }

    @RequestMapping("/model/session2")
    public Object handle2(ModelMap modelMap) {
        User user = (User) modelMap.get("user");
        return user.getName();
    }



    @ModelAttribute
    public User getUser() {
        User user = User.builder()
            .id(1000L)
            .name("Alpha-SessionUser")
            .build();

        return user;
    }
}
