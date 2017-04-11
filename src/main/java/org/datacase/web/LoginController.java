package org.datacase.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
