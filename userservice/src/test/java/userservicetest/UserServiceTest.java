package userservicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.banking.userservice.entity.Users;
import com.banking.userservice.entity.Users.KYCStatus;
import com.banking.userservice.repository.UserRepository;
import com.banking.userservice.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepository userRepository;

	@Test
	public void registerTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");

		when(userRepository.save(user)).thenReturn(user);

		userServiceImpl.register(user);
	}

	@Test
	public void userDetailsTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		userServiceImpl.userDetails(1L);
	}

	@Test
	public void userExistTest() {
		Users user = new Users(1L, "amit", "maurya", "amitmaurya@gmail.com", "999238472", "afka",
				Date.valueOf("1999-06-07"), "lalpur", KYCStatus.VERIFIED, "2025-03-19 11:59:30");

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		boolean check = userServiceImpl.userExist(1L);
		
		assertNotNull(check);

	}
}
