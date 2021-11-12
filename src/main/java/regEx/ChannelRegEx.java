package regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChannelRegEx {
    public static void main(String[] args) {
        String gjMobAppChannelValue = "GJ_MOBAPP";
        String gjTerminalChannelValue = "GJ_TERMINAL";
        String resource = "dfsgdsfgdfgdfgdgdfgfdgfGJ_TERMIALdagfdbvcs654v65vxweb_desktop";

        String channel = (resource.contains(gjTerminalChannelValue)) ? "terminal"
                : (resource.contains(gjMobAppChannelValue)) ? "app_mobile"
                : resource.contains("web_desktop") ? "web_desktop"
                : resource.contains("web_mobile") ? "web_mobile"
                : resource.contains("web_mobile") ? "web_mobile"
                : null;

        System.out.println(channel);
    }


}
