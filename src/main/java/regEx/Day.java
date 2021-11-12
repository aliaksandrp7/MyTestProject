package regEx;

public class Day {
    public static void main(String[] args) {
        String timesh = "c 10:00 до 22:00";

        System.out.println(new StringBuilder(timesh.replaceAll("[^\\d:]", "")).insert(5, "-").toString());
    }
}
