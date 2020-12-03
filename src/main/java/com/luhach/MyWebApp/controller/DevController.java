package com.luhach.MyWebApp.controller;

import java.util.List;
import java.util.Optional;



import com.luhach.MyWebApp.dao.DevRepo;

import org.springframework.beans.factory.annotation.Autowired;

import com.luhach.MyWebApp.model.Dev;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevController{

    @Autowired
    DevRepo repo;
    @RequestMapping("/")
    public String home(){

        return "home";
    }

    @RequestMapping("/addDev")
    public String addDev(Dev dev){

        repo.save(dev);
        return "home";
    }

    @RequestMapping("/delDev")
    public String delDev(Dev dev){
        System.out.println(dev.toString());
        repo.delete(dev);
        return "home";
    }

    @RequestMapping("/Dev/id/{id}")
    @ResponseBody
    public Optional<Dev> getDev(@PathVariable("id") int id) {
        
        Optional<Dev> dev = repo.findById(id);
        return dev;
    }

    
    @RequestMapping("/Dev/tech/{tech}")
    @ResponseBody
    public List<Dev> getDevByTech(@PathVariable("tech") String tech) {
        System.out.println("tech : " + tech);
        
        List<Dev> dev = repo.findByTech(tech);
        System.out.println(dev);
        return dev;
    }
    @RequestMapping("/Devs")
    @ResponseBody
    public Iterable<Dev> allDev() {
        
        Iterable<Dev> dev = repo.findAll();
        return dev;
    }
    @RequestMapping("/Dev/nameSorted")    
    @ResponseBody
    public Iterable<Dev> allDevSortedName(){
        
        Iterable<Dev> dev = repo.findAllSorted();
        return dev;
    }
    
    // @RequestMapping("home")
    // public ModelAndView home(Dev dev){
        
    //     System.out.println("Hi " + dev.getName());
    //     ModelAndView mv = new ModelAndView();
    //     mv.addObject("dev", dev);
    //     mv.setViewName("home");
    //     return mv;
    // }
    // @RequestMapping("home")
    // public ModelAndView home(@RequestParam("name") String myName){
        
    //     System.out.println("Hi " + myName);
    //     ModelAndView mv = new ModelAndView();
    //     mv.addObject("name", myName);
    //     mv.setViewName("home");
    //     return mv;
    // }

}