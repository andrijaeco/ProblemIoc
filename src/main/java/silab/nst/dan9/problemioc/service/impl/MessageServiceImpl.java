package silab.nst.dan9.problemioc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import silab.nst.dan9.problemioc.component.MyDate;
import silab.nst.dan9.problemioc.repository.impl.TXTRepository;
import silab.nst.dan9.problemioc.repository.impl.XMLRepository;
import silab.nst.dan9.problemioc.service.MessageService;

@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {


    @Autowired
    @Qualifier(value = "xml")
    private XMLRepository xmlRepository;

    @Autowired
    @Qualifier(value = "txt")
    private TXTRepository txtRepository;

    @Autowired
    @Qualifier(value = "dateService")
    private DateServiceImpl dateService;

    @Autowired
    @Qualifier(value = "myDate")
    private MyDate myDate;


    @Override
    public void save(String message) {
        System.out.println(dateService.currentDateTime());
        System.out.println(myDate.getCurrentDate("dd.MM.yyyy. hh:mm:ss.SSS"));
        System.out.println("Method -> " +
                new Exception().getStackTrace()[0].getMethodName() + " class name -> " + MessageService.class.getName());
        xmlRepository.saveMessage(MessageService.class.getName() + " -> " + message);
        txtRepository.saveMessage(MessageService.class.getName() + " -> " + message);
    }
}
