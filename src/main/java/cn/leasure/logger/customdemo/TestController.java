package cn.leasure.logger.customdemo;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

//    private static Logger orderInfoLogger = LoggerFactory.getLogger("orderInfoLogger");
//    private static Logger productInfoLogger = LoggerFactory.getLogger("productInfoLogger");


    @GetMapping("/loopPrint")
    public void print() {

        while (true) {
            new Thread(() -> {
                logger.debug("--> 1 debug level");
                logger.info("--> 1 info level");
                logger.error("--> 1 error level");
            }).start();

            new Thread(() -> {
                logger.debug("--> 2 debug level");
                logger.info("--> 2 info level");
                logger.error("--> 2 error level");
            }).start();

        }

    }


    @GetMapping("/print")
    public void test() {

        for (int i = 0; i < 20; i++) {

            logger.info("userId: {},time: {},orderRef: {}",
                    "22222222",
                    new Date().getTime(),
                    "r00000" + UUID.randomUUID().toString().substring(0, 5));


//            orderInfoLogger.info("userId: {},time: {},orderRef: {}",
//                    "11111111",
//                    new Date().getTime(),
//                    "r00000" + UUID.randomUUID().toString().substring(0, 5));
//
//
//            productInfoLogger.info("userId: {},time: {},productRef: {}",
//                    "33333333",
//                    new Date().getTime(),
//                    "r00000" + UUID.randomUUID().toString().substring(0, 5));
        }

    }

}
