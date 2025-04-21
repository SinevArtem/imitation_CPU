package org.example.cpu_on_javafx;

public class BCpu {
    static public ICpu build(){
        return new CPU();
    }
}
