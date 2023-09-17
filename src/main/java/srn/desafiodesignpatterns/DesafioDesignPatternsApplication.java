package srn.desafiodesignpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioDesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDesignPatternsApplication.class, args);
	}

}
