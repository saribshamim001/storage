package VenuMateEventSolution.VenuMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableAsync
@SpringBootApplication
public class VenuMateApplication {

	@Bean
	public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
		FilterRegistrationBean<HiddenHttpMethodFilter> filterRegistrationBean = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(VenuMateApplication.class, args);
	}

}
