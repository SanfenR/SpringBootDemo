package com.sanfen.controller;

import com.sanfen.repository.GirlRepository;
import com.sanfen.domain.Girl;
import com.sanfen.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by fensan on 2017/7/12.
 */
@RestController
@RequestMapping(value = "/girls")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }


    @GetMapping(value = "/id/{id}")
    public Girl getGirlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
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

    @GetMapping(value = "/age/{age}")
    public List<Girl> girlsFindByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }



    @PostMapping(value = "/two")
    public void girlsAddTwo(){
        girlService.insertTwo();
    }


}
