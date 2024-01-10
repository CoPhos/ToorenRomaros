package com.ToorenRomaros.api;

import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.repositories.user.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ApiApplication {
	private static final Logger log = LoggerFactory.getLogger(ApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(DataSource dataSource) {
		return args -> {
			ResourceDatabasePopulator triggersPopulator = new ResourceDatabasePopulator(false, false, StandardCharsets.UTF_8.toString(), new ClassPathResource("triggers.sql"));
			triggersPopulator.setSeparator("//");
			triggersPopulator.execute(dataSource);

			ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, StandardCharsets.UTF_8.toString(), new ClassPathResource("/DB_Data/init_user.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_comment.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_film.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_genre.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_rating.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_staff.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_saga.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_social.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_streamSite.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_episode.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_post.sql"));
			resourceDatabasePopulator.execute(dataSource);
		};
	}
}


