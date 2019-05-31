package ywf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ywf.service.DemoServiceImpl;

@Controller
@RestController
public class DemoController {

    @Autowired
    private DemoServiceImpl demoServiceImpl;

    @RequestMapping("/testTx")
    public String testTx(@RequestParam String name, @RequestParam(required = false) String errorFlag) {
        return demoServiceImpl.testTx(name, errorFlag);
    }
}
