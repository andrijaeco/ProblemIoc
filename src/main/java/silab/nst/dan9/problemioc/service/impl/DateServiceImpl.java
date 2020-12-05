package silab.nst.dan9.problemioc.service.impl;

import org.springframework.stereotype.Service;
import silab.nst.dan9.problemioc.service.DateService;

import java.util.Date;

@Service(value = "dateService")
public class DateServiceImpl implements DateService {

    @Override
    public Date currentDateTime() {
        return new Date();
    }
}
