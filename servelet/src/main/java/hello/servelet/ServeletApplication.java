package hello.servelet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 서블릿 자동 등록
public class ServeletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeletApplication.class, args);
	}

}
