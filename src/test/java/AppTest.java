import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    @Test
    public void testHelloWorldSingleton() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean1 = (HelloWorld) context.getBean("helloworld");
        HelloWorld bean2 = (HelloWorld) context.getBean("helloworld");

        // Same reference → true (singleton scope by default)
        Assert.assertTrue(bean1 == bean2);
    }

    @Test
    public void testCatPrototype() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat1 = (Cat) context.getBean("cat");
        Cat cat2 = (Cat) context.getBean("cat");

        // Different reference → false (prototype scope)
        Assert.assertFalse(cat1 == cat2);
    }
}
