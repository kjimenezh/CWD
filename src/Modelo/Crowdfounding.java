
package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kjime
 */
public class Crowdfounding {
    private double ganancias;
    private ArrayList<Subasta> subastas;

    public Crowdfounding() {
        this.subastas = new ArrayList<>();
    }
    
    public boolean addSubasta(double precioReserva, Promotor demanda){
        return this.subastas.add(new Subasta(precioReserva,demanda));
    }

    public ArrayList<Subasta> getSubastas() {
        return subastas;
    }
    
    public Subasta getSubasta(String nombre){
        Subasta subasta = null;
        for(Subasta s : subastas){
            if(s.getDemanda().getNombre().equals(nombre)){
                subasta = s;
            }
        }
        return subasta;
    }
    /*public static void main(String[] args){
        Crowdfounding crowd = new Crowdfounding();
        Scanner lectura = new Scanner(System.in);
        int a = 0;
        
        do{
        System.out.println("1.Iniciar subasta");
        System.out.println("2.Salir");
        System.out.println("Digite el numero de la opcion");
        
        a = lectura.nextInt();
        int b = 0;
        double c = 0;
        int d = 0;
        double oferta = 0;
        
        switch(a){
            case 1:
                System.out.println("Digite el precio de reserva: ");
                b = lectura.nextInt();
                System.out.println("Digite la inversión a subastar: ");
                c = lectura.nextDouble();
                System.out.println("Iniciando subasta...");
                
                Promotor demanda = new Promotor("Katharine",0,300000);
                
                System.out.println("Cantidad a subastar: "+c);
                do{
                    System.out.println("1.Ingresar oferta: ");
                    System.out.println("Si desea ingresar oferta digite 1");
                    d = lectura.nextInt();
                    System.out.println("Digite el valor de la oferta: ");
                    oferta = lectura.nextDouble();
                    
                    Aportante apor = new Aportante("Daniel",1500000);
                    apor.setValoroferta(oferta);
                }while(d==1);
                break;
            case 2:
                a=4;
                break;         
        }
        }while(a<2);
    }   */
}
