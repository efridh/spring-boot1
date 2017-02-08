package erik.spring.boot1.test1;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest
{

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello()
			throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.get("/greeting")
			.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"content\":\"Hello, World!\"}"));
		
		mvc.perform(MockMvcRequestBuilders.get("/greeting?name=Erik")
			.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andExpect(content().json("{\"id\":2,\"content\":\"Hello, Erik!\"}"));
		
		mvc.perform(MockMvcRequestBuilders.get("/")
			.accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello, World!")));
//			.andExpect(content().json("{\"id\":2,\"content\":\"Hello, Erik!\"}"));
		
		mvc.perform(MockMvcRequestBuilders.get("/greeting2")
			.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andExpect(content().string(equalTo("Hello, World!")));

	}
}
