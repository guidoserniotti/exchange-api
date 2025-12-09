import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Helper helper = new Helper();
        Conversor conversor = new Conversor();

        System.out.println("""
                
                Sea bienvenido al Conversor de Monedas! Seleccione una opción para continuar:""");
        String opcionMenu = "0";
        try{
            while (Integer.valueOf(opcionMenu) != 8) {
                System.out.println("""
                    **********************************************************************
                    1) Dólar -> Peso Argentino
                    2) Peso Argentino -> Dólar
                    3) Dólar -> Real Brasileño
                    4) Real Brasileño -> Dólar
                    5) Dólar -> Peso Colombiano
                    6) Peso Colombiano -> Dólar
                    7) Mostrar ejemplo de solicitud API
                    8) Salir
                    **********************************************************************
                    """);

                Scanner lectura = new Scanner(System.in);
                opcionMenu = lectura.nextLine();

                switch (Integer.valueOf(opcionMenu)) {
                    case 1:
                        System.out.println(conversor.convertir("usd", "ars"));
                        break;
                    case 2:
                        System.out.println(conversor.convertir("ars", "usd"));
                        break;
                    case 3:
                        System.out.println(conversor.convertir("usd", "brl"));
                        break;
                    case 4:
                        System.out.println(conversor.convertir("brl", "usd"));
                        break;
                    case 5:
                        System.out.println(conversor.convertir("usd", "cop"));
                        break;
                    case 6:
                        System.out.println(conversor.convertir("cop", "usd"));
                        break;
                    case 7:
                        helper.showApiReqExample();
                        break;
                    case 8:
                        System.out.println("Gracias por usar el Conversor de Monedas!");
                        break;
                    default:
                        if (Integer.valueOf(opcionMenu) < 1 || Integer.valueOf(opcionMenu) > 8 || opcionMenu.isEmpty()){
                            System.out.println("Opción inválida.");
                        }
                }
            }
        }catch (Exception e){
            System.out.println("Error. "+e.getMessage());
        }
    }
}
