import java.util.Arrays;

public class Command {
    Command(String arg1,String arg2,String arg3){
        if(arg1=="init"){
            CPU.Memory[Integer.parseInt(arg2)] = Integer.parseInt(arg3);
            return;
        }
        if(arg1=="ld"){
            for(int i = 0;i<4;i++){
                if(arg2 == CPU.AllReg[i].NameRegister){
                    CPU.AllReg[i].valueRegister=Integer.parseInt(arg3);
                    return;

                }
            }
        }

    }
    Command(String arg1){
        if(arg1 == "add"){
            CPU.AllReg[3].valueRegister=CPU.AllReg[0].valueRegister+CPU.AllReg[1].valueRegister;
        }
        if(arg1 == "print"){
            System.out.println(Arrays.toString(CPU.AllReg));
        }
    }
}
