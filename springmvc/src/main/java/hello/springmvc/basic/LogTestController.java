package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j //private final Logger log = LoggerFactory.getLogger(getClass()); 롬복에서 제공해준다
public class LogTestController {
    //현재 내 클래스를 가져오기


    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name);
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);
        log.info("info log {}", name);
        return "ok";

    }

}
