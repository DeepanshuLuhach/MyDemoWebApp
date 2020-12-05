package com.luhach.MyWebApp.controller;
import java.util.List;
import java.util.Optional;
import com.luhach.MyWebApp.dao.DevRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.luhach.MyWebApp.model.Dev;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// Switched to REST API: Removed Response Body from Mappings & Now using GetMapping & PostMapping for GET & POST requests
// REST: returns the data to be processed on client side
// JSP : Returns the data in a rendered view format to be displayed on client side
@RestController
public class DevController{

    @Autowired
    DevRepo repo;
    @RequestMapping("/")
    public String home(){

        return "home";
    }

    // @RequestBody is used to tell spring to look for the data in body rather that url
    // With consumre parameter we have restricted the requestbody to be in json format
    @PostMapping(path="/Dev", consumes = {"application/json"}) // Create Method
    public Dev addDev(@RequestBody Dev dev){
        repo.save(dev);
        return dev;
    }
    @PutMapping(path="/Dev", consumes = {"application/json"}) // Update Method
    public Dev saveOrUpdateDev(@RequestBody Dev dev){
        repo.save(dev);
        return dev;
    }

    // We can use the same url path for two functions depending on the type of request: GET & POST
    // It supports both XML & JSON type of response 
    // The response is now restricted to only xml for this path 
    // @GetMapping(path="/Dev",produces = {"application/xml"})
    @GetMapping("/Dev") // Select All Method
    public Iterable<Dev> allDev() {
        
        Iterable<Dev> dev = repo.findAll();
        return dev;
    }

    @DeleteMapping("/Dev/{id}") // Delete Method
    public String delDev(@PathVariable("id") int id) {
        Dev deletedRec = repo.getOne(id);
        String deldata = deletedRec.toString();
        repo.delete(deletedRec);
        return deldata;
    }
    
    @GetMapping("/Dev/{id}") // Select Method
    public Optional<Dev> getDev(@PathVariable("id") int id) {
        
        Optional<Dev> dev = repo.findById(id);
        return dev;
    }

    @GetMapping("/Dev/tech/{tech}")
    public List<Dev> getDevByTech(@PathVariable("tech") String tech) {
        System.out.println("tech : " + tech);
        
        List<Dev> dev = repo.findByTech(tech);
        System.out.println(dev);
        return dev;
    }
    
    @GetMapping("/Dev/nameSorted")    
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