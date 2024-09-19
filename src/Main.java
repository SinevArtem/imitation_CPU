import CPU.CPU;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        cpu.INIT(0,10);
        cpu.INIT(1,20);
        cpu.INIT(2,30);
        cpu.SHOW();
        cpu.LOAD(cpu.r1, 0);
        cpu.LOAD(cpu.r2, 1);
        cpu.LOAD(cpu.r3, 2);
        cpu.SHOW();
        cpu.SUB(cpu.r1, cpu.r2, cpu.r4);
        cpu.SHOW();
        cpu.ADD(cpu.r4, cpu.r3, cpu.r3);


        cpu.STORE(cpu.r3, 2);

        cpu.SHOW();


    }

}