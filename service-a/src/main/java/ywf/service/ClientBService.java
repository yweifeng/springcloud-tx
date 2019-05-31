package ywf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-b")
@Repository
public interface ClientBService {

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    String save(@RequestParam("name") String name);
}
