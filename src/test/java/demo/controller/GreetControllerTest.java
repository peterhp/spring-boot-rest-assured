package demo.controller;

import demo.controller.dto.MessageDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GreetControllerTest {

    @InjectMocks
    private GreetController controller;

    @Test
    public void shouldSayHelloToPerson() throws Exception {
        ResponseEntity<MessageDto> response = controller.greet("Sora");

        assertThat(response.getStatusCodeValue(), is(200));

        MessageDto message = response.getBody();
        assertThat(message.getPerson(), is("Sora"));
        assertThat(message.getMessage(), is("Hello, Sora!"));
    }
}
