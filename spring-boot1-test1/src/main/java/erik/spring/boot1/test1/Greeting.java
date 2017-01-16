package erik.spring.boot1.test1;

/**
 * Resource representation class
 * 
 * Now that you’ve set up the project and build system, you can create your web
 * service.
 * 
 * Begin the process by thinking about service interactions.
 * 
 * The service will handle GET requests for /greeting, optionally with a name
 * parameter in the query string. The GET request should return a 200 OK
 * response with JSON in the body that represents a greeting. It should look
 * something like this:
 * 
 * { "id": 1, "content": "Hello, World!" }
 * 
 * The id field is a unique identifier for the greeting, and content is the
 * textual representation of the greeting.
 * 
 * To model the greeting representation, you create a resource representation
 * class. Provide a plain old java object with fields, constructors, and
 * accessors for the id and content data
 */
public class Greeting
{
	private final long id;
	private final String content;

	public Greeting(long id, String content)
	{
		this.id = id;
		this.content = content;
	}

	public long getId()
	{
		return id;
	}

	public String getContent()
	{
		return content;
	}
}
