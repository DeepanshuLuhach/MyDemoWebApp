package com.luhach.MyWebApp;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{

    @RequestMapping("home")
    public ModelAndView home(Dev dev){
        
        System.out.println("Hi " + dev.getName());
        ModelAndView mv = new ModelAndView();
        mv.addObject("dev", dev);
        mv.setViewName("home");
        return mv;
    }
    // @RequestMapping("home")
    // public ModelAndView home(@RequestParam("name") String myName){
        
    //     System.out.println("Hi " + myName);
    //     ModelAndView mv = new ModelAndView();
    //     mv.addObject("name", myName);
    //     mv.setViewName("home");
    //     return mv;
    // }

}