package com.amz.demo;

import com.amz.DemoApplication;
import com.amz.service.BookService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
	@Autowired
	private BookService a;
	@Test
	public void contextLoads() {
		System.out.println(a.findAll());
	}
}
