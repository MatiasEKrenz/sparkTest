public class IntegranteException extends Exception {

    public IntegranteException() {
        super(); // Llama al constructor por defecto de Exception, esto lo hace por defecto pero lo hago para poder escribir algo abajo.
    }

    public IntegranteException(String mensaje) {
        super(mensaje);
    }
}
