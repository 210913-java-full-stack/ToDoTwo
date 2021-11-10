package com.Revature.ToDoTwo;

import com.Revature.ToDoTwo.beans.servicebeans.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication(scanBasePackages = {"com.Revature.ToDoTwo.beans", "com.Revature.ToDoTwo.OtherBeans"})
@EntityScan("com.revature.ToDoTwo.beans.entities")
@EnableTransactionManagement
public class ToDoTwoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ToDoTwoApplication.class, args);

		Logger logger = context.getBean(Logger.class);
		logger.writeLog("Server started.", 1);




	}
}
