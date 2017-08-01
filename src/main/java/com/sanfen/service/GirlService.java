package com.sanfen.service;

import com.sanfen.repository.GirlRepository;
import com.sanfen.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sanfen on 2017/7/12.
 */
@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;


    @Transactional
    public void insertTwo(){

        Girl one = new Girl();
        one.setAge(18);
        one.setCupSize("F");

        girlRepository.save(one);

        Girl two = new Girl();
        two.setAge(19);
        two.setCupSize("A");
        girlRepository.save(two);
    }
}
