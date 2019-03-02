package demo.controller;

import demo.controller.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetController {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public ResponseEntity<MessageDto> greet(@RequestParam(defaultValue = "Stranger") String person) {
        return ResponseEntity.ok(new MessageDto(person, String.format("Hello, %s!", person)));
    }
}
