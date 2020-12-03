package com.luhach.MyWebApp.dao;

import com.luhach.MyWebApp.model.Dev;

import org.springframework.data.repository.CrudRepository;

// CrudRepository<Class_name, Type_of_primary_key>
public interface DevRepo extends CrudRepository<Dev, Integer>{

}