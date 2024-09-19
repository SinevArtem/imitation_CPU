package CPU;

public interface Instruction_Interface {
    String name(String n);
    void realizationRemory(Register r, int address);
    void realizetion_on2_register(Register r1,Register r2);
    void realization_addr_znach(int address,int value);
    void realizationCalc();


}
