package main.com.goit.gojavaonline.corefinalproject.read;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Danil-MAC on 7/30/16.
 */
public class ConsoleInput implements IInput {

    @Override
    public List<String> read(){
        Scanner scanner = new Scanner(System.in);
        List<String> text = new ArrayList<>();
        text.add(scanner.next());
        return text;
    }

    public String readString() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        return line;
    }

}
