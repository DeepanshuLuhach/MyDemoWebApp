package com.luhach.MyWebApp.dao;

import java.util.List;

import com.luhach.MyWebApp.model.Dev;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// CrudRepository<Class_name, Type_of_primary_key>
public interface DevRepo extends CrudRepository<Dev, Integer>{

    List<Dev> findByTech(String tech);

    @Query("from Dev order by name")
    List<Dev> findAllSorted();

}