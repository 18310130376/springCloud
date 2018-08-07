import org.config.ApplicationConfigClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ApplicationConfigClient.class)
public class ConfigClientTest {
	
	@Test
	public void contextLoads() {
		
	}
    
    @Autowired
    private Environment environment;
    
    @Test
    public void loadProperties() {
    	String property = environment.getProperty("spring.data.source.username");
    	System.out.println(property);
    }
    
}
