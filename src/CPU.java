import java.util.Arrays;

public class CPU implements ICpu {

    public static int[] Memory = new int[1024];

    public static Register[] AllReg = {new Register("a"), new Register("b"),
            new Register("c"), new Register("d")};


    @Override
    public void exec(Command c) {
        switch (c.arg1) {
            case "init":
                Memory[Integer.parseInt(c.arg2)] = Integer.parseInt(c.arg3);
                break;
            case "ld":
                for (int i = 0; i < AllReg.length; i++) {
                    if (c.arg2 == AllReg[i].NameRegister) {
                        AllReg[i].valueRegister = Memory[Integer.parseInt(c.arg3)];
                    }
                }
                break;
            case "add":
                AllReg[3].valueRegister = AllReg[0].valueRegister + AllReg[1].valueRegister;
                break;
            case "print":
                String s="";
                for (int i = 0; i < AllReg.length; i++) {
                    s += Integer.toString(AllReg[i].valueRegister)+" ";
                }
                System.out.println(s);
                break;
            case "mv":
                int t=0;
                for (int i = 0; i < AllReg.length; i++) {
                    if (c.arg3==AllReg[i].NameRegister){
                        t = AllReg[i].valueRegister;
                    }
                }
                for (int i = 0; i < AllReg.length; i++) {
                    if (c.arg2==AllReg[i].NameRegister){
                        AllReg[i].valueRegister=t;
                    }
                }
                break;
            case "div":
                AllReg[3].valueRegister = AllReg[0].valueRegister / AllReg[1].valueRegister;
                break;
            case "sub":
                AllReg[3].valueRegister = AllReg[0].valueRegister - AllReg[1].valueRegister;
                break;
            case "mult":
                AllReg[3].valueRegister = AllReg[0].valueRegister * AllReg[1].valueRegister;
                break;

        }

    }
}
