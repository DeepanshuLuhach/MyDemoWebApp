package com.luhach.MyWebApp.dao;

import java.util.List;

import com.luhach.MyWebApp.model.Dev;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// CrudRepository<Class_name, Type_of_primary_key>
public interface DevRepo extends JpaRepository<Dev, Integer>{

    List<Dev> findByTech(String tech);

    @Query("from Dev order by name")
    List<Dev> findAllSorted();

}