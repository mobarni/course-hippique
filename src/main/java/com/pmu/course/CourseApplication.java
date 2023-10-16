package com.pmu.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pmu.course.model.Course;
import com.pmu.course.model.Partant;
import com.pmu.course.repository.CourseRepository;
import com.pmu.course.repository.PartantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@Slf4j
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CourseRepository courseRepo, PartantRepository partantRepository){

		Partant partant1 = new Partant(UUID.randomUUID(),1,"Flash");
		Partant partant2 = new Partant(UUID.randomUUID(),2,"Tornade");
		Partant partant3 = new Partant(UUID.randomUUID(),3,"Speedy");
		Partant partant4 = new Partant(UUID.randomUUID(),4,"Rapidos");
		Partant partant5 = new Partant(UUID.randomUUID(),5,"Eclair");

		Set<Partant> partants1 = new HashSet<>();
		partants1.add(partantRepository.save(partant1));
		partants1.add(partantRepository.save(partant2));
		partants1.add(partantRepository.save(partant3));

		Set<Partant> partants2 = new HashSet<>();
		partants2.add(partantRepository.save(partant1));
		partants2.add(partantRepository.save(partant2));
		partants2.add(partantRepository.save(partant3));
		partants2.add(partantRepository.save(partant4));

		Set<Partant> partants3 = new HashSet<>();
		partants3.add(partantRepository.save(partant1));
		partants3.add(partantRepository.save(partant2));
		partants3.add(partantRepository.save(partant3));
		partants3.add(partantRepository.save(partant4));
		partants3.add(partantRepository.save(partant5));

		log.info(partants1.toString());
		return  args -> {
			Course course1 = new Course(UUID.randomUUID(),1001,"CourseDeVincenne", LocalDate.now(), partants1);

			Course course2 = new Course(UUID.randomUUID(),1002,"CourseDeLongchamp",LocalDate.now().minusDays(1L), partants2);
			Course course3 = new Course(UUID.randomUUID(),1003,"CourseDAuteuil",LocalDate.now().minusDays(2L), partants3);
			log.info(course1.toString());
			courseRepo.save(course1);
			courseRepo.save(course2);
			courseRepo.save(course3);
		};
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins((Arrays.asList("http://localhost:3000","http://localhost:4200")));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept","Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Jwt-Token","Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials","Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PATCH","DELETE","OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
