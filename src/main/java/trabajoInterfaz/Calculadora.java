package trabajoInterfaz;

//Esta clase sirve para hacer las operaciones, el input son dos String
// y el output es una String con el resultado de operar el valor de los inputs
public interface Calculadora {
    public static String sumar(String num1, String num2){
        return String.valueOf((Double.parseDouble(num1)+Double.parseDouble(num2)));
    }
    public static String restar(String num1, String num2){
        return String.valueOf((Double.parseDouble(num1)-Double.parseDouble(num2)));
    }
    public static String multiplicar(String num1, String num2){
        return String.valueOf((Double.valueOf(num1)*Double.valueOf(num2)));
    }
    public static String dividir(String num1, String num2){
        return String.valueOf((Double.valueOf(num1)/Double.valueOf(num2)));
    }

    //Este metodo recibe 3 String, y devuelve el resultado de la operacion correspondiente
    public static String operar(String func, String num1, String num2){
        return switch (func) {
            case "+" -> sumar(num1, num2);
            case "-" -> restar(num1, num2);
            case "*" -> multiplicar(num1, num2);
            case "/" -> dividir(num1, num2);
            default -> "-1";
        };


    }
}