import app.config.AppConfig;
import app.model.AnimalsCage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class MainTest{
    @Test
    public void testAnimalCageBeans(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalsCage cage1 = context.getBean(AnimalsCage.class);
        AnimalsCage cage2 = context.getBean(AnimalsCage.class);

        assertSame(cage1, cage2);

        Long time1 = cage1.getTimer().getTime();
        Long time2 = cage2.getTimer().getTime();

        assertEquals(time1,time2);

        assertTrue(cage1.getAnimal().toString().contains("Dog"));



    }
}