package ru.churakova.PP312springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class Pp312springbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pp312springbootApplication.class, args);
	}


}
