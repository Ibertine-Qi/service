package com.example.goodsprovider.dao;

import com.example.goodscommons.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface GoodsProviderDao {

    List<Book> getBookList();

    Book queryById(Integer id);
}
