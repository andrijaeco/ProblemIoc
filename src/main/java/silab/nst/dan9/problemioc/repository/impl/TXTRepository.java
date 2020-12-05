package silab.nst.dan9.problemioc.repository.impl;

import org.springframework.stereotype.Component;
import silab.nst.dan9.problemioc.repository.Repository;

@Component(value = "txt")
public class TXTRepository implements Repository {

    @Override
    public void saveMessage(String message) {
        System.out.println("My TEXT message: " + message);
    }
}
