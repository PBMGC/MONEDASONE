import API.API_CONVERSOR;
import Calculos.CalculoConversor;
import RecordsConversor.Moneda;
import modelos.opciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion,cantidad;
        List<opciones> opciones = new ArrayList<>();
        opciones.add(new opciones("USD","PEN"));
        opciones.add(new opciones("PEN","USD"));
        opciones.add(new opciones("USD","ARS"));
        opciones.add(new opciones("ARS","USD"));
        opciones.add(new opciones("USD","BRL"));
        opciones.add(new opciones("BRL","USD"));

        Scanner s = new Scanner(System.in);

        API_CONVERSOR api = new API_CONVERSOR();

        CalculoConversor cl = new CalculoConversor();


        while(true){
            System.out.println("------------------------------------");
            System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS");
            System.out.println("----------------------------------");

            System.out.println("1)Dolares => Soles Peruanos");
            System.out.println("2)Soles Peruanos => Dolares");
            System.out.println("3)Dolares => Pesos Argentinos");
            System.out.println("4)Pesos Argentinos => Dolares");
            System.out.println("5)Dolares => Real Brasileño");
            System.out.println("6)Real Brasileño => Dolares");
            System.out.println("7)SALIR DEL SISTEMA");

            System.out.println("SELECCIONES UNA OPCION");
            opcion=s.nextInt();

            if(opcion==7){
                break;
            }

            System.out.println("CANTIDAD A CONVERTIR");
            cantidad=s.nextInt();

            try {
                Moneda moneda = api.buscarTasas(opciones.get(opcion-1).getOrigen(),opciones.get(opcion-1).getDestino());
                cl.calculo(moneda.conversion_rate(),cantidad);
                System.out.println("TOTAL:"+cl.convertido());
                Thread.sleep(2000);
            }catch (Exception e){
                throw  new RuntimeException(e);
            }

        }
    }
}
