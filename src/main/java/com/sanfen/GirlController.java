package com.sanfen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fensan on 2017/7/12.
 */
@RestController
@RequestMapping(value = "/girls")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;


    @GetMapping(value = "/")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/")
    public Girl girlAdd(@RequestParam(value = "cupSize") String cupSize,
                        @RequestParam(value = "age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }


    @GetMapping(value = "/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }



    @PutMapping(value = "/{id}")
    public Girl putGirlById(@PathVariable("id") Integer id,
                            @RequestParam(value = "cupSize", required = true) String cupSize,
                            @RequestParam(value = "age", required = true) Integer age){

        Girl girl = girlRepository.getOne(id);
        if (cupSize != null) {
            girl.setCupSize(cupSize);
        }
        if (age != null) {
            girl.setAge(age);
        }
        return girlRepository.save(girl);
    }


    @DeleteMapping(value = "/{id}")
    public String deleteGirlById(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        return "success";
    }




}