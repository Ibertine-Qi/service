package com.example.goodsui.controller;

import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;
import com.example.goodsui.service.GoodsUiService;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

import java.util.List;


@RestController
@RequestMapping("/ui")
public class GoodsUiController {
   @Resource
    private GoodsUiService goodsUiService;

   @RequestMapping("/test")
    public String test(){
        goodsUiService.testGoodsProvider();
        return "success";
   }
   @RequestMapping("/list")
    public List<Book> list(){
       List<Book> bookList = goodsUiService.getBookList();
       return bookList;
   }
   @RequestMapping("queryById/{id}")

    public ResultVo queryById(@PathVariable("id") Integer id) throws InterruptedException {
        Thread.sleep(3000);
       ResultVo resultVo = goodsUiService.queryById(id);
           return resultVo;
       }
}
