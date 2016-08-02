package com.goit.gojavaonline.corefinalproject.write;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Danil-MAC on 7/30/16.
 */
public interface IOutput {

    void write(List<String> list) throws IOException;
}
