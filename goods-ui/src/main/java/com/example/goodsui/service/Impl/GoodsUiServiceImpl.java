package com.example.goodsui.service.Impl;

import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;
import com.example.goodsui.service.GoodsUiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUiServiceImpl implements GoodsUiService {
    @Resource
    private RestTemplate restTemplate;

    @Override
    public void  testGoodsProvider() {
        String object = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider"+object);

    }


    @Override
    public List<Book> getBookList() {
        Book[] bookList = restTemplate.getForObject("http://goods-provider/provider/list", Book[].class);
        return Arrays.asList(bookList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallback_getBook",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1000")
    }//降级响应设置超时时间(比如我这里设置1000毫秒之内拿不到对应的响应，直接返回降级响应)
    )


    public ResultVo queryById(Integer id) {
        ResultVo resultVo = restTemplate.getForObject("http://goods-provider/provider/queryById/"+ id, ResultVo.class);
        return resultVo;
    }
    public ResultVo fallback_getBook(Integer id) {
        return ResultVo.error("服务降级返回的响应内容");
    }
}
