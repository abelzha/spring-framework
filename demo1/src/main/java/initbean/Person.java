package initbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person  {
	private String name;

	public Person(){
		System.out.println("====Person()====");
	}

	@Autowired
	public Person(Car car){
		System.out.println("====Person(Car car)====");
	}

//	@Autowired
//	public Person(Dog dog){
//		System.out.println("====Person(Dog dog)====");
//	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void initPerson(){
		System.out.println("initPerson");
		this.name = "kobe";
	}

	//Multiple instances will not call
	public void destroyPerson(){
		System.out.println("destoryPerson");
	}
}
