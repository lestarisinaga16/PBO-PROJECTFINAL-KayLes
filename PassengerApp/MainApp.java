package PassengerApp;

import PassengerApp.config.Database;
import PassengerApp.view.TerminalView;
import com.sun.tools.javac.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "PassengerApp")
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TerminalView terminalView = context.getBean(TerminalView.class);
        terminalView.run();
    }

    @Bean
    Database database() {
        Database database = new Database("flightdb", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }
}