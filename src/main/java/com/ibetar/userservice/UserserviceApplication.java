package com.ibetar.userservice;

import com.ibetar.userservice.entity.AppUser;
import com.ibetar.userservice.entity.Role;
import com.ibetar.userservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(AppUserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveAppUser(new AppUser(null,"Perrito Mendez", "perrito", "12345",new ArrayList<>()));
			userService.saveAppUser(new AppUser(null,"aru Betancourt", "aru", "12345",new ArrayList<>()));
			userService.saveAppUser(new AppUser(null,"contempao Rangel", "contempao", "12345",new ArrayList<>()));
			userService.saveAppUser(new AppUser(null,"Pablo Betancourt", "pabluk", "12345",new ArrayList<>()));
			userService.saveAppUser(new AppUser(null,"luk Rangel", "luk", "12345",new ArrayList<>()));

			userService.addRoleToUser("perrito","ROLE_USER");
			userService.addRoleToUser("perrito","ROLE_MANAGER");
			userService.addRoleToUser("aru","ROLE_MANAGER");
			userService.addRoleToUser("contempao","ROLE_ADMIN");
			userService.addRoleToUser("pabluk","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("pabluk","ROLE_ADMIN");
			userService.addRoleToUser("pabluk","ROLE_USER");
			userService.addRoleToUser("luk","ROLE_USER");


		};
	}

}
