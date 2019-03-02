package demo.controller;

import contract.core.Executor;
import contract.utils.ResLoader;
import demo.config.SpringBootTestConfig;
import org.junit.Test;

public class GreetApiTest extends SpringBootTestConfig {

    @Test
    public void shouldSayHelloToPerson() throws Exception {
        Executor.execute(ResLoader.loadString("contract/greet-sora.json"));
    }

    @Test
    public void shouldSayHelloToStranger() throws Exception {
        Executor.execute(ResLoader.loadString("contract/greet-stranger.json"));
    }
}