package com.alphawang.spring.mvc.model;

import com.alphawang.spring.mvc.User;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ModelAttributeController {
    
    @ModelAttribute
    public User getUser() {
        User user = User.builder()
            .id(1000L)
            .name("Alpha")
            .build();
        
        return user;
    }

    @RequestMapping("/model/model")
    public Object handle0(Model model) {
        model.addAttribute("name", "alpha-Map");
        return model;
    }
    
    @RequestMapping("/model/model-map")
    public Object handle1(ModelMap modelMap) {
        modelMap.addAttribute("name", "alpha-ModelMap");
        return modelMap;
    }

    @RequestMapping("/model/map")
    @ResponseBody
    public Object handle2(Map map) {
        map.put("name", "alpha-Map");
        return map.get("user");
    }

    @RequestMapping("/model/extended-map")
    public Object handle3(ExtendedModelMap extendedModelMap) {
        extendedModelMap.addAttribute("name-1", "alpha-ExtendedModelMap1");
        extendedModelMap.put("name", "alpha-ExtendedModelMap");
        return extendedModelMap;
    }
}
