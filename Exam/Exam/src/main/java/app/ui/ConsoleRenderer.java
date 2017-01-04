package app.ui;

import org.springframework.stereotype.Component;

@Component
public class ConsoleRenderer implements Renderer {

    @Override
    public void render(String line) {
        System.out.println(line);
    }
}
