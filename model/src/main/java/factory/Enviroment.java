package factory;

public class Enviroment {
    public static Browsers getEnv(){
        return Browsers.valueOf(System.getenv("browser").trim().toUpperCase());
    }
}
