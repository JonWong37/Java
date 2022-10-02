package com.example.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController

public class MainController {
    @RequestMapping("/daikichi")
    public String hello(){
        return "Welcome!";
    }

    @RequestMapping("/daikichi/today")
    public String today(){
        return "Today you will find luck in all your endeavors!";
    }

    @RequestMapping("/daikichi/tomorrow")
    public String tomorrow(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

    @RequestMapping("/daikichi/travel/{city}")
    public String place(@PathVariable("city") String city){
        return "Congratulations! you will soon travel to " + city;
    }

    @RequestMapping("/daikichi/lotto/{num}")
    public String lotto(@PathVariable("num") int lotto){
        if (lotto % 2 == 0){
            return "You will take a grand journey in the near future, but be wear of tempting offers.";
        }
        else{
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
        }
    }
}
