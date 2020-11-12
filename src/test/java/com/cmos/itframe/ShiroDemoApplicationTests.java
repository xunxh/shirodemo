package com.cmos.itframe;

import com.cmos.itframe.beans.User;
import com.cmos.itframe.iservice.BookSV;
import com.cmos.itframe.iservice.PermissionSV;
import com.cmos.itframe.iservice.UserSV;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroDemoApplicationTests {

	@Autowired
	private UserSV userSV;

	@Autowired
	private PermissionSV permissionSV;
	@Test
	void contextLoads() {
		//userSV.updateUser(new User(2,"admin","admin",1,"admin@123.com","123456789",""));
		permissionSV.getUserPerms();
	}

	@Autowired
	private BookSV bookSV;
	@Test
	void test(){
		//List<Book> books = bookSV.selectAll(2, 5);
		//System.out.println(books);
	}

}
