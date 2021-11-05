package com.Revature.ToDoTwo;

import com.Revature.ToDoTwo.OtherBeans.TestBean;
import com.Revature.ToDoTwo.beans.entities.TestEntity;
import com.Revature.ToDoTwo.beans.services.APIClientService;
import com.Revature.ToDoTwo.beans.services.TestEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.Revature.ToDoTwo.beans", "com.Revature.ToDoTwo.OtherBeans"})
@EntityScan("com.revature.ToDoTwo.beans.entities")
@EnableTransactionManagement
public class ToDoTwoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ToDoTwoApplication.class, args);

		TestBean bean = context.getBean(TestBean.class);
		System.out.println(bean.getOtherBean().getTest());

		TestEntityService service = context.getBean(TestEntityService.class);

		TestBean testBean = context.getBean(TestBean.class);
		System.out.println("TestBean: " + testBean.getOtherBean().getTest());

		TestEntity entity = new TestEntity((int)(100 * Math.random()), "test");
		service.save(entity);

		TestEntity entity2 = service.getById(1);
		System.out.println("\nEntity retrieved from datasource: [" + entity2.getId() + "] " + entity2.getString());

		List<TestEntity> entities = service.getAll();
		System.out.println("\nList of all entities: ");
		for(TestEntity temp : entities) {
			System.out.println("[" + temp.getId() + "] " + temp.getString());
		}

		System.out.println("\nList of SOME entities: ");
		for(TestEntity temp : service.getSome()) {
			System.out.println("[" + temp.getId() + "] " + temp.getString());
		}


		/*
		 * Example of using the OKHttp client, see APIClientService class
		 */
		String url = "https://pokeapi.co/api/v2/pokemon/ditto";
		String json = APIClientService.get(url);
		System.out.println("PokeAPI ditto: \n" + json);


	}
}
