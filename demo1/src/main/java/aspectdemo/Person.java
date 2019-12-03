package aspectdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Person{
	private String name;
	public String getPersonName(){
		System.out.println("-------getPersonName-------:"+ name);
		return name;
	}

	public boolean setPersonName(String name){
		System.out.println("--------setPersonName------:"+name);
		this.name = name;
		return true;
	}
}
