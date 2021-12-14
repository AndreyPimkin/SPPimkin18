package packageObfuscator;

public class ListName {
    public static void getNameClass(String classOldName){ //Перезагрузку метода использовать не стал.
        Main.classNames.add(classOldName);
    }
    public static void getNameMethod(String methodOldName){
        Main.methodNames.add(methodOldName);
    }
    public static void getNameVar(String varOldName){
        Main.varNames.add(varOldName);
    }
}
