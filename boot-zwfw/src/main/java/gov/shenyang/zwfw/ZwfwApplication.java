package gov.shenyang.zwfw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("gov.shenyang.zwfw.mapper")
@EnableScheduling
public class ZwfwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZwfwApplication.class, args);
	}

}
