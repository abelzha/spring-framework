package aspectdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Person implements InitializingBean, DisposableBean {
	private String name;
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet----->");
		this.name = "kobe";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("-----------destroy-------->");
	}

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
