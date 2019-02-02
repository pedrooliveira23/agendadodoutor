package br.com.ad.agendadodoutor;

import br.com.ad.agendadodoutor.configs.WebMvcConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class AppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public AppSecurityInitializer() {
        super(WebMvcConfig.class);
    }
}