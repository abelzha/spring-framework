package springextends_applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationLister implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("received event is " + event);
	}
}
