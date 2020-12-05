package silab.nst.dan9.problemioc.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import silab.nst.dan9.problemioc.repository.Repository;
import silab.nst.dan9.problemioc.config.Config;
import silab.nst.dan9.problemioc.repository.impl.TXTRepository;
import silab.nst.dan9.problemioc.repository.impl.XMLRepository;
import silab.nst.dan9.problemioc.service.DateService;
import silab.nst.dan9.problemioc.service.MessageService;
import silab.nst.dan9.problemioc.service.impl.MessageServiceImpl;

import java.util.Date;

@Component
public class Main {
    public static void main_1() throws Exception {
        Repository repository = new XMLRepository();
        repository.saveMessage("andrija");
        repository = new TXTRepository();
        repository.saveMessage("andrija");


        BeanFactory context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println(context.getBean("currentDateTimeBean", Date.class));

        Repository repositoryBean = (Repository) context.getBean("xml");
        repositoryBean.saveMessage("my message with bean");

        repositoryBean = context.getBean("txt", TXTRepository.class);
        repositoryBean.saveMessage("my message with bean");

        Thread.currentThread().sleep(3000);
        System.out.println(context.getBean("currentDateTimeBean", Date.class));
        //Bean is only once created hence we get the same time
    }

    public static void main_2() {
        BeanFactory context = new AnnotationConfigApplicationContext(Config.class);

        MessageService messageService = context.getBean("messageService", MessageServiceImpl.class);
        messageService.save("My message");

        DateService dateService = context.getBean(DateService.class);
        System.out.println(dateService.currentDateTime());
    }

    public static void main_3() {
        BeanFactory context = new AnnotationConfigApplicationContext(Config.class);

        MessageService messageService = context.getBean("messageService", MessageServiceImpl.class);
        messageService.save("My message");
    }


    @Autowired
    private MessageService messageService;

    private void saveMessage(String message) {
        messageService.save(message);
    }

    public static void main_4() {
        BeanFactory context = new AnnotationConfigApplicationContext(Config.class);
        Main main = context.getBean(Main.class);
        main.saveMessage("my message from class -> " + Main.class.getName());
    }

    public static void main(String[] args) throws Exception {
//        Main.main_1();
//        Main.main_2();
//        Main.main_3();
        Main.main_4();


    }

}
