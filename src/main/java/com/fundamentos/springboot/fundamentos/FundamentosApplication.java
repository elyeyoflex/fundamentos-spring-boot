package com.fundamentos.springboot.fundamentos;



import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.fundamentos.springboot.fundamentos.bean.BeanTestDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;

@SpringBootApplication()
public class FundamentosApplication implements CommandLineRunner {
	
	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	private final ComponentDependency componentDependency;
	private final MyBean myBean;
	private final MyBeanWithDependency myBeanWithDependency;
	private final BeanTestDependency beanTestDependency;
	private final MyBeanWithProperties myBeanWithProperties; 
	private final UserPojo userPojo;
	private final UserRepository userRepository;
	
	@Autowired
	public FundamentosApplication (UserPojo userPojo ,@Qualifier("componentImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, BeanTestDependency beanTestDependency, MyBeanWithProperties myBeanWithProperties, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.beanTestDependency = beanTestDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosPlatzi();
		saveUserInDataBase();
		getInformationJpqlFromUser();
			
	}
	
	private void getInformationJpqlFromUser(){
		LOGGER.info("Usuario con el metodo findByUserEmail " + 
				userRepository.findByUserEmail("user3@gmail.com")
				.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));
		
		userRepository.findAndSort("user", Sort.by("id").ascending())
			.stream().forEach(user-> LOGGER.info("Usuario con metodo sort " + user));
		
		userRepository.findByName("user")
			.stream()
			.forEach(user-> LOGGER.info("Usuario con query metod -> " + user));
		
		LOGGER.info("Usuario con el metodo findByNameAndEmail " + 
				userRepository.findByNameAndEmail("user", "user@gmail.com"));
	}
	private void saveUserInDataBase() {
		User user1 = new User("user", "user1@gmail.com", LocalDate.of(2022,1,1));
		User user2 = new User("user", "user2@gmail.com", LocalDate.of(2022,2,2));
		User user3 = new User("user", "user3@gmail.com", LocalDate.of(2022,3,3));
		User user4 = new User("user4", "user4@gmail.com", LocalDate.of(2022,4,4));
		User user5 = new User("user5", "user5@gmail.com", LocalDate.of(2022,5,5));
		User user6 = new User("user6", "user6@gmail.com", LocalDate.of(2022,6,6));
		User user7 = new User("user7", "user7@gmail.com", LocalDate.of(2022,7,7));
		User user8 = new User("user8", "user8@gmail.com", LocalDate.of(2022,8,8));
		User user9 = new User("user9", "user9@gmail.com", LocalDate.of(2022,9,9));
		User user10 = new User("user10", "user10@gmail.com", LocalDate.of(2022,10,10));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);
	}
	
	private void ejemplosPlatzi() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		beanTestDependency.testDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getAge() +" "+ userPojo.getEmail()+ " "+userPojo.getPassword());
		try {
			int value = 10/0;
			LOGGER.debug("Mi valor= " + value );
		} catch (Exception e) {
			LOGGER.error("esto es un error " + e.getLocalizedMessage());
		}
	}

}
