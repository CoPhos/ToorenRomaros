package com.ToorenRomaros.api;

import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.repositories.user.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ApiApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserFollowerRepository userFollowerRepository;
	private static final Logger log = LoggerFactory.getLogger(ApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			// save a couple of customers
			UserEntity user1 = new UserEntity(
					"montelukas",
					LocalDate.of(1990, 5, 8),
					LocalDate.of(2050, 9, 16),
					"I love coding", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());
			UserEntity user2 = new UserEntity(
					"Enapril",
					LocalDate.of(1990, 5, 8),
					LocalDate.of(2050, 9, 16),
					"I love pot", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());
			UserEntity user3 = new UserEntity(
					"Benzafibrato",
					LocalDate.of(1990, 5, 8),
					LocalDate.of(2050, 9, 16),
					"I love EDM Music", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());

			UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now() ,user1, user3);
			UserFollowerEntity userFollowerEntity2 = new UserFollowerEntity(LocalDate.now() ,user1, user2);
			UserFollowerEntity userFollowerEntity3 = new UserFollowerEntity(LocalDate.now() ,user3, user1);

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
//			userFollowerRepository.save(userFollowerEntity);
//			userFollowerRepository.save(userFollowerEntity2);
//			userFollowerRepository.save(userFollowerEntity3);
//
//			user1.setFollowers(List.of(userFollowerEntity, userFollowerEntity2));
//			user1.setFollowings(List.of(userFollowerEntity3));
//			userRepository.save(user1);

		};
	}
}


