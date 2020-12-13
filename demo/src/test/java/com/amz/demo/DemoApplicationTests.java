package com.amz.demo;

import java.util.UUID;

import com.amz.DemoApplication;
import com.amz.entity.User;
import com.amz.service.BookService;
import com.amz.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
	@Autowired
	private BookService bs;
	@Autowired
	private UserService us;
	@Test
	public void testFindAll() {
		System.out.println(bs.findAll());
	}
	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		user.setAdmin(true);
		user.setId(UUID.randomUUID().toString());
		us.save(user);
	}
}
