package org.datacase.web;

import org.datacase.model.City;
import org.datacase.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月10日
 * @Version v1.0
 */
@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/list")
    public List<City> list() {
        return cityService.findAll();
    }
}
