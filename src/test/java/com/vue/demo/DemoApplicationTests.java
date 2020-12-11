package com.vue.demo;

import com.vue.DemoApplication;
import com.vue.dao.BookDAO;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
class DemoApplicationTests {
	@Autowired
	private BookDAO bookDAO;
	@Test
	void contextLoads() {
		System.out.println(bookDAO.findAll());
	}
}
