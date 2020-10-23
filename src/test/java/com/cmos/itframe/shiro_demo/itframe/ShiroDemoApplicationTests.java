package com.cmos.itframe.shiro_demo.itframe;

import com.cmos.itframe.shiro_demo.itframe.beans.Book;
import com.cmos.itframe.shiro_demo.itframe.beans.User;
import com.cmos.itframe.shiro_demo.itframe.dao.UserDao;
import com.cmos.itframe.shiro_demo.itframe.iservice.BookSV;
import com.cmos.itframe.shiro_demo.itframe.iservice.UserSV;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShiroDemoApplicationTests {

	@Autowired
	private UserSV userSV;
	@Test
	void contextLoads() {
		userSV.addUser(new User("admin","admin",1," "));
	}

	@Autowired
	private BookSV bookSV;
	@Test
	void test(){
		//List<Book> books = bookSV.selectAll(2, 5);
		//System.out.println(books);
	}

}
