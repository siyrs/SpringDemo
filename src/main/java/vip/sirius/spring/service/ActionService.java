package vip.sirius.spring.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ActionService {

    public void getNextAction() {
        log.info("getNextAction");
    }

}
