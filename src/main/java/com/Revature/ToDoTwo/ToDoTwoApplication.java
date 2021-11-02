package com.Revature.ToDoTwo;

import com.Revature.ToDoTwo.beans.TestBean;
import com.Revature.ToDoTwo.beans.entities.TestEntity;
import com.Revature.ToDoTwo.beans.services.TestEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.Revature.ToDoTwo.beans")
@EntityScan("com.revature.ToDoTwo.beans.entities")
public class ToDoTwoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ToDoTwoApplication.class, args);

		TestBean bean = context.getBean(TestBean.class);
		System.out.println(bean.getOtherBean().getTest());

		TestEntityService service = context.getBean(TestEntityService.class);

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

	}
}
