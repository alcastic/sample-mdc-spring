package cl.acc.mdc.samplemdcspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/hello")
    public ResponseEntity<?> greeting() {
        log.info("Reached greeting");
        return ResponseEntity.ok("Be original!");
    }

}
