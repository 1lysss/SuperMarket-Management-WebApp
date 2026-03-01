package com.pfe.SuperMarketManager;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuperMarketManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperMarketManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository er) {
		return args->{
			var employee = Employee.builder()
					.fullName("Ilyass")
					.email("irrifiilyass")
					.role(Employee.Role.ADMIN)
					.username("1ly")
					.build();
			er.save(employee);
		};
	}

}
