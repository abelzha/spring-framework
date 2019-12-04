package initbean;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	private String name;

	public Dog(){
		System.out.println("====Dog()====");
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void initCar(){
		System.out.println("initDog");
		this.name = "burtin";
	}

	//Multiple instances will not call
	public void destroyCar(){
		System.out.println("destoryDog");
	}
}
