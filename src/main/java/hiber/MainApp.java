package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
       AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(AppConfig.class);

       UserService userService = context.getBean(UserService.class);

       User user1 = new User("John", "Doe", "john@example.com", new Car("BMW", 5));
       User user2 = new User("Alice", "Smith", "alice@example.com", new Car("Audi", 3));

       userService.add(user1);
       userService.add(user2);

       List<User> users = userService.listUsers();
       for (User user : users) {
           System.out.println(user + " owns " + user.getCar());
       }

       User owner = userService.getUserByCar("BMW", 5);
       System.out.println("Owner of BMW 5: " + owner.getFirstName());

       context.close();
   }
}
