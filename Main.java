import java.util.ArrayList;
public class Main {
    public static void main(String[] args)
    {
        ArrayList <CuentaBancaria> MC = new ArrayList<>();
        String PDS;
        int BM;
        int IDB;
        do{
            BM = CapturaEntrada.capturarEntero
                    ("--------------------------------\n1.-Nueva cuenta\n" +
                    "--------------------------------\n2.-Acceder a una cuenta\n" +
                            "--------------------------------\n3.-Salir\n--------------------------------\n");
            switch(BM) {
            case 1:
                MC.add(new CuentaBancaria(CapturaEntrada.capturarCadena
                        ("--------------------------------\nEscriba su nombre/s y apellidos: \n--------------------------------\n"),
                        0, CapturaEntrada.capturarCadena
                        ("--------------------------------\nElija su propio NIP de 4 digitos: \n--------------------------------\n"))
                        );System.out.println("--------------------------------\nEl numero de usuario brinda es: \n--------------------------------\n"+ Banco.i);
            break;
            case 2:
                IDB = CapturaEntrada.capturarEntero
                        ("--------------------------------\n" +
                                "Escriba su numero de usuario \n" +
                                "--------------------------------\n");
                PDS = CapturaEntrada.capturarCadena
                        ("--------------------------------\n" +
                                "Ingrese su NIP: \n" +
                                "--------------------------------\n");
            for(int i = 0; i < MC.size(); i++)
            {
            Banco.VerificarNIP(MC.get(i), PDS, IDB);
            }
            break;
            }
        }while(BM != 3);
    }
}

//Aqui colocaremos las transacciones que se hacen en el banco
class Banco {
    static double DineroEnPosesion = 99999;
    static int i = 548628795;
    protected Banco()
    {
        i=i+1;
    }
    public static void VerificarNIP(CuentaBancaria cuentab, String PDS, int IDB)
    {
        if(cuentab.getNIP().equals(PDS) && cuentab.getIdentificacion() == IDB){MovimientosDeCuenta(cuentab);}
    }
    private static void DatosDeCuenta(CuentaBancaria cuentab)
    {
        System.out.println("--------------------------------\n" +
                "Cantidad de dinero que usted lleva guardando es de: " +
                "\n--------------------------------\n"+ cuentab.getDineroEnPosesion());
    }
    private static void RetiroDeDinero(CuentaBancaria cuentab)
    {
        double retirodedinero = CapturaEntrada.capturarDoble("--------------------------------\n" +
                "¿Cuanto retirara? " +
                "\n--------------------------------\n");
        if(cuentab.getDineroEnPosesion() < retirodedinero)
        {
            System.out.println("--------------------------------\n" +
                    "ERROR *No tiene la cantidad suficiente* ERROR" +
                    "\n--------------------------------\n");
        }
        else
        {
            cuentab.setDineroEnPosesion(cuentab.getDineroEnPosesion() - retirodedinero);
            DineroEnPosesion = DineroEnPosesion - retirodedinero;
        }
    }
    private static void DepositarDinero(CuentaBancaria cuentab)
    {
        double entrada = CapturaEntrada.capturarDoble
                ("--------------------------------\n" +
                "Escriba la cantidad que quiera depositar " +
                "\n--------------------------------\n");
        cuentab.setDineroEnPosesion(entrada + cuentab.getDineroEnPosesion());
        DineroEnPosesion =DineroEnPosesion + entrada;
    }
    private static void MovimientosDeCuenta(CuentaBancaria CBS)
    {
        int MenuDeAyuda;
        System.out.println("--------------------------------\n" +
                "Bienvenido , que transaccion desea realizar? " +
                "\n--------------------------------\n");
        do {
            MenuDeAyuda =
                    CapturaEntrada.capturarEntero
                              ("--------------------------------\n1.-Deposito \n--------------------------------\n" +
                                      "--------------------------------\n2.-Retiro \n--------------------------------\n" +
                                      "--------------------------------\n3.-Estado de cuenta \n--------------------------------\n");
            switch (MenuDeAyuda)
            {
                case 1: DepositarDinero(CBS);
                break;
                case 2: RetiroDeDinero(CBS);
                break;
                case 3: DatosDeCuenta(CBS);
                break;
            }
            MenuDeAyuda = CapturaEntrada.capturarEntero("--------------------------------\n" +
                    "Quisiera realizar otra operacion (Si=4 , Salir=0)" +
                    "\n--------------------------------\n");
        }while(MenuDeAyuda==4);
        System.out.println("--------------------------------\n" +
                "Vuelva pronto :)" +
                "\n--------------------------------\n");
    }
}

//Creamos la subclase
class CuentaBancaria extends Banco
{
    //Variables de usuarios
    private String NombredelUsuario;
    private double DineroEnPosesion;
    private String NIP;
    private int Identificacion;

    public CuentaBancaria(String NombredelUsuario, double DineroEnPosesion, String NIP)
    {
        setNombredelUsuario(NombredelUsuario);
        setDineroEnPosesion(DineroEnPosesion);
        setNIP(NIP);
        setIdentificacion(Banco.i);
    }

    //Getters
    protected String getNombredelUsuario() {
        return NombredelUsuario;
    }
    protected double getDineroEnPosesion() {
        return DineroEnPosesion;
    }
    protected String getNIP() {
        return NIP;
    }
    protected int getIdentificacion() {
        return Identificacion;
    }

    //Setters
    protected void setNombredelUsuario(String NombredelUsuario) {
    this.NombredelUsuario = NombredelUsuario;
    }
    protected void setDineroEnPosesion(double DineroEnPosesion) {
    this.DineroEnPosesion = DineroEnPosesion;
    }
    protected void setNIP(String NIP) {
        do {
            if (NIP.length() == 4) {this.NIP = NIP;} else
            {
            NIP = CapturaEntrada.capturarCadena
                    ("--------------------------------\n " +
                            "Ingrese su NIP de 4 digitos y/o caracteres:" +
                            "\n--------------------------------\n");
            }
           }while(NIP.length()!=4);
    }
    protected void setIdentificacion(int Identificacion) {
    this.Identificacion = Identificacion;
    }
}