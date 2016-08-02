package com.goit.gojavaonline.corefinalproject.read;

import java.io.IOException;
import java.util.List;

/**
 * Created by Danil-MAC on 7/30/16.
 */
public interface IInput {
    List<String> read() throws IOException;
}
