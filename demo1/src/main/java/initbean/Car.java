package initbean;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String name;

	public Car(){
		System.out.println("====Car()====");
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void initCar(){
		System.out.println("initCar");
		this.name = "Audi";
	}

	//Multiple instances will not call
	public void destroyCar(){
		System.out.println("destoryCar");
	}
}
