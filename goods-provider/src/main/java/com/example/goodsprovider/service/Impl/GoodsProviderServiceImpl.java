package com.example.goodsprovider.service.Impl;

import com.example.goodscommons.entity.Book;
import com.example.goodsprovider.dao.GoodsProviderDao;
import com.example.goodsprovider.service.GoodsProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {

    @Resource
    private GoodsProviderDao goodsProviderDao;

    @Override
    public List<Book> list() {
       List<Book> bookList = goodsProviderDao.getBookList();
       return bookList;
    }

    @Override
    public Book queryById(Integer id) {
        return goodsProviderDao.queryById(id);
    }
}
