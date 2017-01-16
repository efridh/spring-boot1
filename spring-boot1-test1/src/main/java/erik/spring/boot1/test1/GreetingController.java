package erik.spring.boot1.test1;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resource controller
 * 
 * In Spring’s approach to building RESTful web services, HTTP requests are
 * handled by a controller. These components are easily identified by the
 * {@code @}{@link RestController} annotation, and the GreetingController below
 * handles GET requests for /greeting by returning a new instance of the
 * Greeting class.
 * 
 *  <p>
 * This controller is concise and simple, but there’s plenty going on under the
 * hood. Let’s break it down step by step.
 * <p>
 * The {@code @}{@link RequestMapping} annotation ensures that HTTP requests to
 * /greeting are mapped to the greeting() method. The above example does not
 * specify GET vs. PUT, POST, and so forth, because {@code @}RequestMapping maps
 * all HTTP operations by default. Use {@code @}RequestMapping(method=GET) to
 * narrow this mapping.
 * <p>
 * {@code @}{@link RequestParam} binds the value of the query string parameter
 * name into the name parameter of the greeting() method. This query string
 * parameter is explicitly marked as optional (required=true by default): if it
 * is absent in the request, the defaultValue of "World" is used.
 * <p>
 * The implementation of the method body creates and returns a new Greeting
 * object with id and content attributes based on the next value from the
 * counter, and formats the given name by using the greeting template.
 * <p>
 * A key difference between a traditional MVC controller and the RESTful web
 * service controller above is the way that the HTTP response body is created.
 * Rather than relying on a view technology to perform server-side rendering of
 * the greeting data to HTML, this RESTful web service controller simply
 * populates and returns a Greeting object. The object data will be written
 * directly to the HTTP response as JSON.
 * <p>
 * This code uses Spring 4’s new {@code @}{@link RestController} annotation,
 * which marks the class as a controller where every method returns a domain
 * object instead of a view. It’s shorthand for {@code @}{@link Controller} and
 * {@code @}{@link ResponseBody} rolled together.
 * <p>
 * The Greeting object must be converted to JSON. Thanks to Spring’s HTTP
 * message converter support, you don’t need to do this conversion manually.
 * Because Jackson 2 is on the classpath, Spring’s
 * MappingJackson2HttpMessageConverter is automatically chosen to convert the
 * Greeting instance to JSON.
 */
@RestController
public class GreetingController
{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name",
		defaultValue = "World") String name)
	{
		return new Greeting(counter.incrementAndGet(), String.format(template,
			name));
	}
	
//	@RequestMapping(value = "/error", name = "error")
//	public Greeting error(@RequestParam(value = "name",
//	defaultValue = "World") String name)
//	{
//		return new Greeting(counter.incrementAndGet(), "Oups... " + name);
//	}
}
