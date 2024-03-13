package com.ToorenRomaros.api;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplateBuilder().build();
	}

	@Bean
	public ApplicationRunner runner(DataSource dataSource) {
		return args -> {
			ResourceDatabasePopulator triggersPopulator = new ResourceDatabasePopulator(false, false, StandardCharsets.UTF_8.toString(), new ClassPathResource("database/schema/triggers/trg_FilmAverageRating.sql"));
			triggersPopulator.addScript(new ClassPathResource("database/schema/triggers/trg_totalLikes.sql"));
			triggersPopulator.setSeparator("//");
			triggersPopulator.execute(dataSource);

			ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, StandardCharsets.UTF_8.toString(), new ClassPathResource("/database/data/seed/init_user.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_film.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_genre.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_staff.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_saga.sql"));
//			resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_social.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_streamSite.sql"));
			//resourceDatabasePopulator.addScript(new ClassPathResource("/DB_Data/init_episode.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_post-tvshows.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_post-movies.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_tag.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_comment.sql"));
			resourceDatabasePopulator.addScript(new ClassPathResource("/database/data/seed/init_image.sql"));
			resourceDatabasePopulator.execute(dataSource);
		};
	}
}


