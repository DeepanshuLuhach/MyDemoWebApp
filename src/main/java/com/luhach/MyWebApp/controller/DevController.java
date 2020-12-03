package com.luhach.MyWebApp.controller;

import com.luhach.MyWebApp.dao.DevRepo;

import org.springframework.beans.factory.annotation.Autowired;

import com.luhach.MyWebApp.model.Dev;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

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
        return "delete";
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