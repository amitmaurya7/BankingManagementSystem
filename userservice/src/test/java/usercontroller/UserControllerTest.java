package usercontroller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.banking.userservice.controller.Controller;
import com.banking.userservice.dto.LoginDto;
import com.banking.userservice.entity.Users;
import com.banking.userservice.entity.Users.KYCStatus;
import com.banking.userservice.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@InjectMocks
	private Controller controller;
	
	@Mock
	private UserService userService;
	
	@Test
	public void userRegisterTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");
		
		ResponseEntity<String> response = controller.userRegister(user);
		
		assertNotNull(response);
	}
	
	@Test
	public void userDetailsTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");
		
		ResponseEntity<Users> response = controller.userDetails(1L);
		
		assertNotNull(response);
	}
	
	@Test
	public void userLoginTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");
		LoginDto loginDto = new LoginDto("amit", "amitmaurya@gmail.com");
		
		ResponseEntity<String> response = controller.userLogin(loginDto);
		
		assertNotNull(response);
	}
	
	@Test
	public void userExistTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");
		LoginDto loginDto = new LoginDto("amit", "amitmaurya@gmail.com");
		
		ResponseEntity<Boolean> response = controller.userExist(1L);
		
		assertNotNull(response);
	}
}
