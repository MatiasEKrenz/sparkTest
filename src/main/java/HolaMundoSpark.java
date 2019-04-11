import static spark.Spark.*;


public class HolaMundoSpark {

    public static void main(String[] args) {

        get("/hola", (reg, res) -> "Hola Mundo");

        get("/hola/:nombre", (reg, res) -> {
           return "Hola " + reg.params(":nombre");
        });

    }
}
