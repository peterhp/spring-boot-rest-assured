package demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetController {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public ResponseEntity<String> greet(@RequestParam(defaultValue = "Stranger") String person) {
        return ResponseEntity.ok(String.format("Hello, %s!", person));
    }
}
