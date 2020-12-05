package silab.nst.dan9.problemioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import silab.nst.dan9.problemioc.repository.Repository;
import silab.nst.dan9.problemioc.repository.impl.TXTRepository;
import silab.nst.dan9.problemioc.repository.impl.XMLRepository;

import java.util.Date;

@ComponentScan(basePackages = {"silab", "silab.nst.dan9.problemioc.main"})
public class Config {

    public Config() {
        System.out.println("================================================================================================================");
        System.out.println("Constructor of: " + Config.class.getName());
    }

    @Bean(name = "xmlBean")
    public Repository createXML() {
        System.out.println("Method name -> " + new Exception().getStackTrace()[0].getMethodName());
        return new XMLRepository();
    }

    @Bean(name = "txtBean")
    public Repository createTXT() {
        System.out.println("Method name -> " + new Exception().getStackTrace()[0].getMethodName());
        return new TXTRepository();
    }

    @Bean(name = "currentDateTimeBean")
    public Date getCurrentDateTime() {
        return new Date();
    }

}
