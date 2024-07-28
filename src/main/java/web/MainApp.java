package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;
import web.service.UserService;

public class MainApp {
    public static void main(String[] args) {
        // Initialize Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the UserService bean
        UserService userService = context.getBean(UserService.class);

        // Use userService as needed
        // Example usage:
        userService.cleanUsersTable();
        // Further operations with userService
    }
}