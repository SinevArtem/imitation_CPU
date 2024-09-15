package CPU;

public class CPU {

    public int[] memory = new int[4096];

    public Register r1 = new Register();
    public Register r2 = new Register();
    public Register r3 = new Register();
    public Register r4 = new Register();

    public void LOAD(Register r, int address){
        r.valueRegister = memory[address];
    }
    public void STORE(Register r, int address){
        memory[address] = r.valueRegister;
    }

    public void ADD(Register r1,Register r2, Register r3){
        r3.valueRegister = r1.valueRegister+r2.valueRegister;
    }

    public void INIT(int addr,int value){
        memory[addr] = value;
    }



}
