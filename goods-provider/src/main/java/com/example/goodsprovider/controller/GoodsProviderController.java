package com.example.goodsprovider.controller;

import com.example.goodscommons.entity.Book;
import com.example.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;

    @RequestMapping("/test")
    public String test() {
        System.out.println("成功进入goods-provider");
        return "调用成功";
    }

    @RequestMapping("/list")
    public List<Book> list() {
        List<Book> bookList = goodsProviderService.list();
        return bookList;
    }
    @RequestMapping("/queryById/{id}")
    public Book queryById(@PathVariable("id") Integer id){
        Book book = goodsProviderService.queryById(id);
        return book;
    }
    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回:"+n+"/"+num+"="+result;
    }
    public String fallback(@RequestParam("num") Integer num){
        return "服务降级响应：num为0";
    }
}
