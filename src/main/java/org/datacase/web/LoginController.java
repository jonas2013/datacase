package org.datacase.web;

import org.datacase.model.City;
import org.datacase.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月10日
 * @Version v1.0
 */
@Controller
public class LoginController {

    @GetMapping(value = {"/"})
    public String index() {
        return "index";
    }
}
