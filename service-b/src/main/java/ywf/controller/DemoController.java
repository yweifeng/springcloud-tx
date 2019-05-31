package ywf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ywf.service.DemoServiceImpl;

@Controller
@RestController
public class DemoController {

    @Autowired
    private DemoServiceImpl demoServiceImpl;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(@RequestParam String name) {
        return demoServiceImpl.save(name);
    }
}
