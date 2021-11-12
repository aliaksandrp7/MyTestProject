package ecd8192;

public class MainClass {
    boolean pole;

    public MainClass(boolean pole) {
        this.pole = pole;
    }

    protected static String shouldUpdateCheckDate(boolean pole) {
        return pole ? "было тру" : "было фолс";
    }

    public static String checkMethod (boolean pole){
        return shouldUpdateCheckDate(pole);
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass(false);
        System.out.println(checkMethod(false));
    }




}
