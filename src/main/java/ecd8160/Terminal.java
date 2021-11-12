package ecd8160;

public class Terminal {
    public static void main(String[] args) {
        String user_agent_constant = "GJ_MOBAPP";
        String source = "8 82 ._GJ_MOBAPPPP  872длропадд GJ_MOBAP GJ_MOBAPP";
        String source_true = "GJ_MOBAPP";
        System.out.println(source.contains(user_agent_constant));
        System.out.println(source.indexOf(user_agent_constant));
        System.out.println(source_true.contains(user_agent_constant));
        System.out.println(source_true.indexOf(user_agent_constant));
    }
}
