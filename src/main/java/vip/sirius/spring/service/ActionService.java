package vip.sirius.spring.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    private final static Logger logger = LoggerFactory.getLogger(ActionService.class);

    public void getNextAction() {
        logger.info("getNextAction");
    }
}
