import CPU.CPU;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        cpu.INIT(0,10);
        cpu.INIT(1,20);
        cpu.INIT(2,0);
        System.out.println(cpu.memory[0]);
        System.out.println(cpu.memory[1]);
        System.out.println(cpu.memory[2]);
        cpu.LOAD(cpu.r1, 0);
        cpu.LOAD(cpu.r2, 1);
        cpu.ADD(cpu.r1, cpu.r2, cpu.r3);
        cpu.STORE(cpu.r3, 2);
        System.out.println(cpu.memory[0]);
        System.out.println(cpu.memory[1]);
        System.out.println(cpu.memory[2]);


        String binary = Integer.toBinaryString(9999);
        System.out.println(binary);
    }

}