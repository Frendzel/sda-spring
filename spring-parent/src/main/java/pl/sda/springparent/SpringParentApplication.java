package pl.sda.springparent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.sda.springparent.polimorphism.A;
import pl.sda.springparent.polimorphism.C;
import pl.sda.springparent.polimorphism.D;

import static java.util.Arrays.asList;

@SpringBootApplication
@ComponentScan(basePackages = "pl.sda")
@EnableScheduling
@EnableCaching
@Slf4j //lombokowy sposob tworzenia loggera
public class SpringParentApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringParentApplication.class, args);
    }

    @Autowired
    ApplicationContext context;

    @Autowired
    @Qualifier("c")
    C test123;

    @Autowired
    A a;

    @Autowired
    C b;

    @Autowired
    D d;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Hello World");
        asList(context.getBeanDefinitionNames()).forEach(log::debug);
        log.debug("Liczba beanow: " + context.getBeanDefinitionCount());
        a.getClassName();
        b.getClassName();
        test123.getClassName();
        d.getClassName();
    }
}
