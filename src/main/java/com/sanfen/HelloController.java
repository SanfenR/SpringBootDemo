package com.sanfen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fensan on 2017/7/12.
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;


//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",
            required = false,
            defaultValue = "0") Integer id) {
        return "id: " + id;
    }

}
