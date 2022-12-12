package br.com.ifa.apirest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//Problema autowired nao carregava o repository https://stackoverflow.com/questions/59993124/the-injection-point-has-the-following-annotations-org-springframework-beans
@EnableJpaRepositories(basePackages = "br.com.ifa.apirest.repository")
@SpringBootApplication
public class ApirestApplication {

	@Autowired
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
	}
	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

}
