package br.com.ad.agendadodoutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AgendaDoDoutorApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AgendaDoDoutorApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AgendaDoDoutorApplication.class, args);
    }

}

