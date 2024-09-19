package CPU;

public class Instructions {

    Instruction_Interface LOAD = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "LOAD";
        }
        @Override
        public void realizationRemory(Register r, int address) {
            r.valueRegister = CPU.Memory[address];
        }
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        public void realizationCalc() {}
    };
    Instruction_Interface STORE = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "STORE";
        }
        @Override
        public void realizationRemory(Register r, int address) {
            CPU.Memory[address] = r.valueRegister;
        }
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        public void realizationCalc() {}
    };
    Instruction_Interface MV = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "MV";
        }
        public void realizationRemory(Register r, int address) {}
        @Override
        public void realizetion_on2_register(Register r1, Register r2) {
            r1.valueRegister=r2.valueRegister;
        }
        public void realization_addr_znach(int address, int value) {}
        public void realizationCalc() {}
    };

    Instruction_Interface INIT = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "INIT";
        }
        public void realizationRemory(Register r, int address) {}
        public void realizetion_on2_register(Register r1, Register r2) {}
        @Override
        public void realization_addr_znach(int address, int value) {
            CPU.Memory[address] = value;
        }
        public void realizationCalc() {}
    };
    Instruction_Interface PRINT = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "PRINT";
        }
        public void realizationRemory(Register r, int address) {}
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        @Override
        public void realizationCalc() {
            System.out.println(CPU.R1.valueRegister+ " "+CPU.R2.valueRegister+" " + CPU.R3.valueRegister+" "+CPU.R4.valueRegister);
        }
    };
    Instruction_Interface ADD = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "ADD";
        }
        public void realizationRemory(Register r, int address) {}
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        @Override
        public void realizationCalc() {
            CPU.R4.valueRegister = CPU.R1.valueRegister+CPU.R2.valueRegister;
        }
    };

    Instruction_Interface SUB = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "SUB";
        }
        public void realizationRemory(Register r, int address) {}
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        @Override
        public void realizationCalc() {
            CPU.R4.valueRegister = CPU.R1.valueRegister-CPU.R2.valueRegister;
        }
    };

    Instruction_Interface MULT = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "MULT";
        }
        public void realizationRemory(Register r, int address) {}
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        @Override
        public void realizationCalc() {
            CPU.R4.valueRegister = CPU.R1.valueRegister*CPU.R2.valueRegister;
        }
    };
    Instruction_Interface DIV = new Instruction_Interface() {
        @Override
        public String name(String n) {
            return "DIV";
        }
        public void realizationRemory(Register r, int address) {}
        public void realizetion_on2_register(Register r1, Register r2) {}
        public void realization_addr_znach(int address, int value) {}
        @Override
        public void realizationCalc() {
            CPU.R4.valueRegister = CPU.R1.valueRegister/CPU.R2.valueRegister;
        }
    };
}
