package springextends;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String color;


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
