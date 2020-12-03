package com.luhach.MyWebApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dev {
    
    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dev [id=" + id + ", name=" + name + "]";
    }

}
