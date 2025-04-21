package org.example.cpu_on_javafx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CPU implements ICpu {

    public static int[] Memory = new int[50];


    public HashMap<String,String> mapRegisters = new HashMap<>(){
        {
            put("a","*");
            put("b","*");
            put("c","*");
            put("d","*");
        }
    };
    public HashMap<String,String> getRegisters(){
        return mapRegisters;
    }

    //    init 10 20
//    init 11 25
//    ld a 10
//    ld b 11
//    ld c 11
//    add
//    mv a d
//    add
//    print
//    mostPopularInstruction: ld=3
//    [10, 11]
//    ListInstructions: ld-3, add-2, init-2, print-1, mv-1,
//     45 25 25 70
    @Override
    public void exec(Command c) {
        int result;
        switch (c.arg1) {

            case "init":
                Memory[Integer.parseInt(c.arg2)] = Integer.parseInt(c.arg3);
                break;

            case "ld":
                mapRegisters.put(c.arg2, String.valueOf(Memory[Integer.parseInt(c.arg3)]));
                break;

            case "add":
                result = Integer.parseInt(mapRegisters.get("a"))+Integer.parseInt(mapRegisters.get("b"));
                mapRegisters.put("d",String.valueOf(result));
                break;

            case "print":
                String s="";
                for (Map.Entry<String,String> entry: mapRegisters.entrySet())
                {
                    s += entry.getValue()+" ";
                }
                System.out.println(s);
                break;

            case "mv":
                String t = "";
                t = mapRegisters.get(c.arg2);
                mapRegisters.put(c.arg2, mapRegisters.get(c.arg3));
                mapRegisters.put(c.arg3, t);
                break;

            case "div":
                result = Integer.parseInt(mapRegisters.get("a"))/Integer.parseInt(mapRegisters.get("b"));
                mapRegisters.put("d",String.valueOf(result));
                break;

            case "sub":
                result = Integer.parseInt(mapRegisters.get("a"))-Integer.parseInt(mapRegisters.get("b"));
                mapRegisters.put("d",String.valueOf(result));
                break;

            case "mult":
                result = Integer.parseInt(mapRegisters.get("a"))*Integer.parseInt(mapRegisters.get("b"));
                mapRegisters.put("d",String.valueOf(result));

                break;
            case "st":
                Memory[Integer.parseInt(c.arg3)] = Integer.parseInt(mapRegisters.get(c.arg2));
                break;


        }

    }
}
