package silab.nst.dan9.problemioc.repository.impl;

import org.springframework.stereotype.Component;
import silab.nst.dan9.problemioc.repository.Repository;

@Component(value = "xml")
public class XMLRepository implements Repository {
    @Override
    public void saveMessage(String message) {
        System.out.println("My XML message: <xml>" + message + "</xml>");
    }
}
