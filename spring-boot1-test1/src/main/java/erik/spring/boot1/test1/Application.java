package erik.spring.boot1.test1;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Although it is possible to package this service as a traditional WAR file for
 * deployment to an external application server, the simpler approach
 * demonstrated below creates a standalone application. You package everything
 * in a single, executable JAR file, driven by a good old Java main() method.
 * Along the way, you use Spring’s support for embedding the Tomcat servlet
 * container as the HTTP runtime, instead of deploying to an external instance.
 * 
 * 
 * {@code @}{@link SpringBootApplication} is a convenience annotation that adds
 * all of the following:
 * <p>
 * {@code @}{@link Configuration} tags the class as a source of bean definitions
 * for the application context.
 * <p>
 * {@code @}{@link EnableAutoConfiguration} tells Spring Boot to start adding
 * beans based on classpath settings, other beans, and various property
 * settings.
 * <p>
 * Normally you would add {@code @}{@link EnableWebMvc} for a Spring MVC app,
 * but Spring Boot adds it automatically when it sees spring-webmvc on the
 * classpath. This flags the application as a web application and activates key
 * behaviors such as setting up a DispatcherServlet.
 * <p>
 * {@code @}{@link ComponentScan} tells Spring to look for other components,
 * configurations, and services in the the hello package, allowing it to find
 * the controllers.
 * <p>
 * The main() method uses Spring Boot’s {@link SpringApplication#run(String...)}
 * method to launch an application. Did you notice that there wasn’t a single
 * line of XML? No web.xml file either. This web application is 100% pure Java
 * and you didn’t have to deal with configuring any plumbing or infrastructure.
 * 
 * <p>
 * https://spring.io/guides/gs/rest-service
 * </p>
 * 
 * <p>
 * <ul><li>{@link SpringBootApplication}
 * 		<ul>
 * 		<li>{@link SpringBootConfiguration}
 * 			<ul><li>{@link Configuration}</li></ul></li>
 * 		<li>{@link EnableAutoConfiguration}
 * 			<ul><li>{@link AutoConfigurationPackage}</li>
 * 			<li>{@link Import}({@link EnableAutoConfigurationImportSelector}.class)</li></ul></li>
 * 		<li>{@link ComponentScan}(excludeFilters = {@link ComponentScan.Filter}
 * 				(type = {@link FilterType#CUSTOM}, classes = {@link TypeExcludeFilter}.class))
 * 			<ul><li>{@link Repeatable}({@link ComponentScans}.class)</li></ul></li>
 * 		</ul>
 * </ul>
 * </p>
 */
@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx)
//	{
//		return args -> {
//
//			System.out.println(
//					"Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for(String beanName : beanNames)
//			{
//				System.out.println(beanName);
//			}
//
//		};
//	}
}
