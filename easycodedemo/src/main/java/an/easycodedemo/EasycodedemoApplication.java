package an.easycodedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("an.easycodedemo.dao")
public class EasycodedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasycodedemoApplication.class, args);
	}

}
