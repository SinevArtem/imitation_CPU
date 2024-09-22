public class CPU implements ICpu {

    public static int[] Memory = new int[1024];

    public static Register[] AllReg={ new Register("a"), new Register("b"),
            new Register("c"), new Register("d")};


    @Override
    public void exec(Command c) {

    }
}
