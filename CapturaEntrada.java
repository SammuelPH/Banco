import java.util.Scanner;
public class CapturaEntrada

    {
    public static int capturarEntero(String msg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextInt());
    }
    public static double capturarDoble(String msg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextDouble());
    }
    public static String capturarCadena(String msg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextLine());
    }
}