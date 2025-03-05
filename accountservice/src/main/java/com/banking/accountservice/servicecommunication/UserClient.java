package com.banking.accountservice.servicecommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.banking.accountservice.dto.UserDetailsDto;


@FeignClient(name = "user-service", url = "http://localhost:8081/users/")
public interface UserClient {

	@GetMapping("/exist/{userId}")
	public Boolean userExist(@PathVariable Long userId);
	
	@GetMapping("/{userId}")
	public UserDetailsDto userDetails(@PathVariable Long userId);
}
