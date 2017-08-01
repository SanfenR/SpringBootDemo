package com.sanfen.repository;

import com.sanfen.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fensan on 2017/7/12.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findByAge(Integer age);
    Girl findById(Integer id);
}
