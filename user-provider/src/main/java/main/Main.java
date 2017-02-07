package main;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jack-cooper on 2017/2/6.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                "classpath*:spring/application.xml", "classpath*:spring/spring-provider.xml"
        });
        context.start();
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
