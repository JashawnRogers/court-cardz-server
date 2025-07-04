package com.nba_stats.court_cardz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String test(){
        return "This thing works!";
    }
}
