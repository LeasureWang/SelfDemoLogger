package cn.leasure.logger.customdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/loopPrint")
    public void print() {

        int i = 0;

        while (true) {

            if(logger.isDebugEnabled()){
                logger.debug("--> debug level number:[{}]", i);
            }



            i++;
            logger.info("--> info level number:[{}]", i);
            logger.error("--> error level number:[{}]", i);
        }

    }

}
