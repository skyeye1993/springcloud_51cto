package com.example.gateway.filter;

import com.example.common.R;
import com.example.gateway.httpClient.AuthServiceByHttp;
import com.example.gateway.restTemplate.AuthServiceByTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/checkToken")
public class CheckTokenFilter {

    @Autowired
    AuthServiceByHttp authServiceByHttp;

    @Autowired
    AuthServiceByTemplate authServiceByTemplate;

    @GetMapping("/byHttpGet")
    public R byHttpGet(@RequestParam Map<String, Object> params){
        return authServiceByHttp.byHttpGet(params);
    }

    @GetMapping("/byHttpPost")
    public R byHttpPost(@RequestParam Map<String, Object> params) {
        return authServiceByHttp.byHttpPost(params);
    }

    @GetMapping("/byTemplate")
    public R byTemplate(@RequestParam Map<String, Object> params){
        return authServiceByTemplate.byTemplate(params);
    }

    @GetMapping("/byBalancer")
    public R byBalancer(@RequestParam Map<String, Object> params){
        return authServiceByTemplate.byBalancer(params);
    }

    @GetMapping("/byBalancerBetter")
    public R byBalancerBetter(@RequestParam Map<String, Object> params){
        return authServiceByTemplate.byBalancerBetter(params);
    }
}
