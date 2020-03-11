package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling       // <-- 스케줄러
public class StudyApplication {

	public static void main(String[] args) {
		/**
		 * - 서버 기동시 콘솔에 배너를 출력한다.
		 *     배너기본경로 : /study/src/main/resources/banner.txt
		 */
		SpringApplication.run(StudyApplication.class, args);
		
//		ConfigurableApplicationContext ac = SpringApplication.run(StudyApplication.class, args);

//		1. 이벤트 설정
//		ac.addApplicationListener(new ApplicationListener<MyEvent>() {
//			@Override
//			public void onApplicationEvent(MyEvent myEvent) {
//				System.out.println("Hello onApplicationEvent : " + myEvent.getMessage());
//			}
//		});
		
//		1.1 (1)을 람다로 변경한 코드
//		ac.addApplicationListener((ApplicationListener<MyEvent>) myEvent -> System.out.println("Hello onApplicationEvent : " + myEvent.getMessage()));
		
//		2. 이벤트 발생
//		ac.publishEvent(new MyEvent(ac, "message"));
	}

//	1.2. 이벤트 설정을 애노테이션으로 설정
//	@EventListener(MyEvent.class)
//	public void onMyEvent() {
//		System.out.println("Hello onApplicationEvent");
//	}
	
//	static class MyEvent extends ApplicationEvent {
//		
//		private final String message;
//		
//		public MyEvent(Object source, String message) {
//			super(source);
//			this.message = message;
//		}
//		
//		public String getMessage() {
//			return message;
//		}
//	}
	
//	1.3 이벤트 설정을 애노테이션으로 설정
//	@EventListener(ApplicationReadyEvent.class)
//	public void onMyEvent() {
//		System.out.println("Hello onApplicationEvent");
//	}
}
