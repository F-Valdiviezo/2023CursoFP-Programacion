import java.text.DecimalFormat;
import java.util.Scanner;

public class Trabajo2 {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    //MAIN
    public static void main(String[] args) {
        // Ingreso de datos por consola ó solicitar al usuario
        double peso;
        double altura;
        if (args.length == 2) {
            System.out.println(ANSI_PURPLE);
            System.out.println("***********************************************************");
            System.out.println(" Hola, según los datos ingresados estos son los resultados ");
            System.out.println("***********************************************************");
            peso = Double.parseDouble(args[0]);
            altura = Double.parseDouble(args[1]);
            System.out.println(ANSI_RESET);
        } else {
            System.out.println(ANSI_PURPLE);
            System.out.println("***********************************************************");
            System.out.println("                 Hola, calculemos su IMC                   ");
            System.out.println("***********************************************************");
            peso = obtenerDato("Ingrese su peso en Kg: ");
            altura = obtenerDato("Ingrese su altura en centímetros: ");
            System.out.println(ANSI_RESET);
        } 
        double imc = calcularMasaCorporal(peso, altura);// retorna el valor de la función "calcularMasaCorporal" a la variable imc     
        DecimalFormat df = new DecimalFormat("##.00"); //formatear imc a decimal
        String imcdf = df.format(imc);                         //formatear imc a decimal
        String estado = obtenerEstado(imc);//retorna el valor de la función "obtenerEstado" a la variable estado
        informe(imcdf, estado); //imprime los valores de la función "informe" 
    }
    //END MAIN

    //FUNCION ONBTENER DATO
    public static double obtenerDato(String mensaje) {
        System.out.print(ANSI_WHITE + mensaje);
        System.out.print(ANSI_BLUE);
        double dato = new Scanner(System.in).nextDouble();
        System.out.print(ANSI_RESET);
        return dato;
    }

    //FUNCION CALCULAR MASA CORPORAL
    public static double calcularMasaCorporal(double peso, double altura) {
        return peso / Math.pow(altura / 100, 2); // devuelve el imc calculado
    }

    //FUNCION OBTENER ESTADO
    public static String obtenerEstado(double imc) {
        String estado;
        if (imc <= 15) {
            return "¡Delgadez muy severa!";
        } else if (imc > 15 && imc <= 15.9) {
            return "¡Delgadez severa!";
        } else if (imc < 18.4 && imc > 16) {
            return "Delgadez";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return  "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidad moderada";
        } else if (imc >= 35 && imc < 39.9) {
            return "¡Obesidad severa!";
        } else {
            return "¡Obesidad mórbida!";
        }
    }
  
    //FUNCION INFORME
    public static void informe(String imcdf, String estado) {
        System.out.println(ANSI_WHITE + "Su IMC es: " + obtenerColorEstado(estado) + imcdf);
        System.out.println(ANSI_WHITE + "Estado: " + obtenerColorEstado(estado) + estado); 
        System.out.print(ANSI_PURPLE);
        System.out.println("***********************************************************");
        System.out.println("                    Fin del informe                        ");
        System.out.println("***********************************************************");
        System.out.println(ANSI_RESET);
    }

    //FUNCION COLOR ESTADO
    public static String obtenerColorEstado(String estado) {
        switch (estado) {
            case "Normal":
                return ANSI_GREEN;
            case "¡Delgadez muy severa!":
            case "¡Delgadez severa!":
            case "¡Obesidad severa!":
            case "¡Obesidad mórbida!":
                return ANSI_RED;
            case "Sobrepeso":
            case "Delgadez":
            case "Obesidad moderada":
                return ANSI_YELLOW;
            default:
                return "";
        }
    }
   
}
