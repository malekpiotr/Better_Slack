package commands;

public enum SupportedCommands {
    UNKNOWN(""),
    ADD_CHANNEL("/addchannel"),
    JOIN_CHANNEL("/joinchannel"),
    LOGIN("/login"),
    REGISTER("/register"),
    CHANGE_USERNAME("/changeusername");

    private String stringValue;

    SupportedCommands(String val) {
        stringValue = val;
    }

    public static SupportedCommands fromString(String string) {
        String trimmedString = string.trim();

        switch (trimmedString.toLowerCase()) {
            case "/addchannel":
                return ADD_CHANNEL;
            case "/joinchannel":
                return JOIN_CHANNEL;
            case "/login":
                return LOGIN;
            case "/register":
                return REGISTER;
            case "/changeusername":
                return CHANGE_USERNAME;
            default:
                return UNKNOWN;
        }
    }
}