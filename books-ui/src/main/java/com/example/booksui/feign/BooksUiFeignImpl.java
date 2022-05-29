package com.example.booksui.feign;

import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BooksUiFeignImpl implements BooksUiFeign{

    @Override
    public List<Book> queryAll() {
        return null;
    }

    @Override
    public ResultVo queryById(Integer id) {
        return ResultVo.error("服务降级响应");
    }
}
