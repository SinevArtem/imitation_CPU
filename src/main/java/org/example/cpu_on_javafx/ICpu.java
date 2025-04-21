package org.example.cpu_on_javafx;

import java.util.HashMap;

public interface ICpu {
    void exec(Command c);
    HashMap<String,String> getRegisters();
}
