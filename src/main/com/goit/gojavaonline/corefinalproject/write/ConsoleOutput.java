package main.com.goit.gojavaonline.corefinalproject.write;

import java.util.List;

public class ConsoleOutput implements IOutput {

    @Override
    public void write(List<String> list) {
        try {
            for (String word : list) {
                System.out.println(word);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
