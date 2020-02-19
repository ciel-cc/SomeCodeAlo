package someCode;

public class InitClass {

}

class Fu{
    private static int i = getNum("(1)i");
    public static void print(String str){
        System.out.println();
    }
    public static int getNum(String str){
        print(str);
        return ++i;
    }
}