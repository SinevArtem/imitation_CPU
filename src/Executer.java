public class Executer {
    ICpu cpu;
    public Executer(ICpu cpu) {
        this.cpu=cpu;
    }

    public void run(Command[] prog){
        for (int i=0;i< prog.length;i++){
            cpu.exec(prog[i]);
        }
    }
}
