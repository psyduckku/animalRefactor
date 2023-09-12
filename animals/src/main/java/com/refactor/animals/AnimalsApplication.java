package com.refactor.animals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //단순 암호화를 위해 인증/인가 off
public class AnimalsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnimalsApplication.class, args);
		//bean으로 등록하지 않을시 사용자의 요청에 따라 반복횟수를 4~12까지 설정할 수 있다고함.
		//높을수록 암호화 강도가 높다고하는데, 사용자의 요청은 뭐지?
		//일반적으로 고정해놓고 사용한다는데. -0-..

	}

}
