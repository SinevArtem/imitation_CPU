package org.example.cpu_on_javafx;

import java.util.Arrays;

public class Command{
    public String arg1,arg2,arg3;

    Command(String arg1,String arg2,String arg3){
        this.arg1=arg1;
        this.arg2=arg2;
        this.arg3=arg3;

    }
    Command(String arg1){
        this.arg1=arg1;

    }

    @Override
    public String toString() {
        if (arg2 == null && arg3 == null) return  arg1;
        return arg1+" "+ arg2+ " "+arg3;
    }
}
