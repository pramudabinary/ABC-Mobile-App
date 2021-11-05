package lk.abc.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */
@Configuration
@ComponentScan
@Import({JPAConfig.class})
public class WebRootConfig {
}
