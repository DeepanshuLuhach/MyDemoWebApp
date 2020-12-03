package com.luhach.MyWebApp.controller;

import java.util.List;
import java.util.Optional;

import com.luhach.MyWebApp.dao.DevRepo;

import org.springframework.beans.factory.annotation.Autowired;

import com.luhach.MyWebApp.model.Dev;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/getDev")
    public ModelAndView getDev(@RequestParam("id") int id){
        
        ModelAndView mv = new ModelAndView();
        Optional<Dev> dev = repo.findById(id);
        mv.addObject("dev", dev);
        mv.setViewName("showDev");
        return mv;
    }

    
    @RequestMapping("/getDevByTech")
    public ModelAndView getDevByTech(@RequestParam("tech") String tech){
        
        ModelAndView mv = new ModelAndView();
        List<Dev> dev = repo.findByTech(tech);
        mv.addObject("dev", dev);
        mv.setViewName("showDev");
        return mv;
    }
    @RequestMapping("/allDev")
    public ModelAndView allDev(){
        
        ModelAndView mv = new ModelAndView();
        Iterable<Dev> dev = repo.findAll();
        mv.addObject("dev", dev);
        mv.setViewName("showDev");
        return mv;
    }
    @RequestMapping("/allDevSortedName")
    public ModelAndView allDevSortedName(){
        
        ModelAndView mv = new ModelAndView();
        Iterable<Dev> dev = repo.findAllSorted();
        mv.addObject("dev", dev);
        mv.setViewName("showDev");
        return mv;
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