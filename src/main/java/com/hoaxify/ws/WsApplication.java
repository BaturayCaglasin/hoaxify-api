package com.hoaxify.ws;

import com.hoaxify.ws.user.MyUsers;
import com.hoaxify.ws.user.UserService;
import com.hoaxify.ws.user.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan("com.hoaxify.ws")
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

@Bean //spring'in kullandığı bir obje olmuş oluyor. Çünkü commandLineRunner'da spring'in bir objesi. Uygulama ayağa kalktığında burası da execute edilmiş oluyor.
	CommandLineRunner createInitialUsers(UserService userService){ //dependency injection. parametre olarak bunu istediğimizde spring bize bu parametreyi veriyor.
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				//kullanıcı oluşturup database'e kaydedilir:
				MyUsers user = new MyUsers();
				user.setUsername("user1");
				user.setDisplayName("display1");
				user.setPassword("Password*01");
				userService.save(user);

			}
		};
	}

}
