package com.pika.boot.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.pika.boot.biz.BookBiz;
import com.pika.boot.entity.Apple;
import com.pika.boot.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guyuqiang
 * @since 2021-03-12
 */
@Api("book控制器")
@RestController
@RequestMapping("/boot/book")
public class BookController {

    @Resource
    private BookBiz bookBiz;

    @GetMapping("/{id}")
    @ApiOperation("根据id获取book")
    @DS("db1")
    public String getBook(@PathVariable("id") Integer id) {
        Book book = bookBiz.getById(id);
        return book.toString();
    }
}
