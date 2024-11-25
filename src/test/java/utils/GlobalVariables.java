package utils;

public class GlobalVariables {
    private final static String URL = "https://api.restful-api.dev";
    private static String idPhone = "";
    public static String getUrl() {
        return URL;
    }

    public static String getIdPhone() {
        return idPhone;
    }

    public static void setIdPhone(String idPhone) {
        GlobalVariables.idPhone = idPhone;
    }
}
