package org.example.cpu_on_javafx;

public class Executer {
    ICpu cpu;
    public Executer(ICpu cpu) {
        this.cpu=cpu;
    }
    int index =0;
    public void run(Program prog){
        for(int i=0;i< prog.commands.size();i++){
            cpu.exec(prog.commands.get(i));
        }


    }
}
