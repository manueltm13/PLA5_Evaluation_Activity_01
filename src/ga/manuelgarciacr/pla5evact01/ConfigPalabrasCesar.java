package ga.manuelgarciacr.pla5evact01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author manuel
 */
@Configuration
@ComponentScan()
public class ConfigPalabrasCesar {
    
    @Bean
    IProcesar proceso(){
        return new Palabras();
    }
    
    @Bean
    ICodificar codificacion(){
        return new Cesar();
    }
}
