package com.miuapps.miuschedule;

import static org.assertj.core.api.Assertions.assertThat;

import com.miuapps.miuschedule.controller.AuthController;
import com.miuapps.miuschedule.payload.request.LoginRequest;
import com.miuapps.miuschedule.payload.response.JwtResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest
class MiuScheduleApplicationTests {

	@Autowired
	private AuthController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void signIn() {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("admin");
		loginRequest.setPassword("admin");
		ResponseEntity<JwtResponse> response = controller.authenticateUser(loginRequest);
		assertThat(Objects.requireNonNull(response.getBody()).getToken()).isNotNull();
	}
 }
