import java.text.DecimalFormat;
import java.util.Scanner;

public class Trabajo1 {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        // INGRESO DE DATOS
        System.out.println(ANSI_PURPLE);
        System.out.println("************************************************");
        System.out.println("            Hola, calculemos su IMC             ");
        System.out.println("************************************************");
        System.out.println(ANSI_WHITE);
        System.out.print("Ingrese su peso en Kg: ");
        System.out.print(ANSI_BLUE);
        double peso = new Scanner(System.in).nextDouble();
        System.out.print(ANSI_WHITE);
        System.out.print("Ingrese su altura en centímetros: ");
        System.out.print(ANSI_BLUE);
        double altura = new Scanner(System.in).nextDouble();
        System.out.println(ANSI_RESET);

        // CÁLCULOS
        // imc
        double imc;
        imc = peso / Math.pow(altura / 100, 2);

        // formatear imc a decimal
        DecimalFormat df = new DecimalFormat("##.00");
        String imcdf = df.format(imc);

        // estado
        String estado;
        if (imc <= 15) {
            estado = "¡Delgadez muy severa!";
        } else if (imc > 15 && imc <= 15.9) {
            estado = "¡Delgadez severa!";
        } else if (imc < 18.4 && imc > 16) {
            estado = "Delgadez";
        } else if (imc >= 18.5 && imc < 24.9) {
            estado = "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            estado = "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            estado = "Obesidad moderada";
        } else if (imc >= 35 && imc < 39.9) {
            estado = "¡Obesidad severa!";
        } else {
            estado = "¡Obesidad mórbida!";
        }

        // INFORME
        if (estado.equals("Normal")) {
            System.out.println(ANSI_WHITE + "Su IMC es: " + ANSI_GREEN + imcdf);
            System.out.println(ANSI_WHITE + "Estado: " + ANSI_GREEN + estado);
            System.out.println(ANSI_RESET);
        } else if (estado.equals("¡Delgadez muy severa!") || estado.equals("¡Delgadez severa!")
                || estado.equals("¡Obesidad severa!") || estado.equals("¡Obesidad mórbida!")) {
            System.out.println(ANSI_WHITE + "Su IMC es: " + ANSI_RED + imcdf);
            System.out.println(ANSI_WHITE + "Estado: " + ANSI_RED + estado + ", consulte con un medico a la brevedad.");
            System.out.println(ANSI_RESET);
        } else if (estado.equals("Sobrepeso") || estado.equals("Delgadez")
                || estado.equals("Obesidad moderada")) {
            System.out.println(ANSI_WHITE + "Su IMC es: " + ANSI_YELLOW + imcdf);
            System.out.println(ANSI_WHITE + "Estado: " + ANSI_YELLOW + estado + ", consulte con un medico.");
            System.out.println(ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Su IMC es: " + imcdf);
            System.out.println("Estado: " + estado);
            System.out.println(ANSI_RESET);
        }

        System.out.println(ANSI_PURPLE);
        System.out.println("************************************************");
        System.out.println("               Fin del informe                  ");
        System.out.println("************************************************");
        System.out.println(ANSI_RESET);

    }
}