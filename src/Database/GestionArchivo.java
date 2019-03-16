
package Database;

import Modelo.Aportante;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Modelo.Persona;
import Modelo.Promotor;
import Modelo.Subasta;


/**
 * @author kjime
 */
public class GestionArchivo {
    private String rutaPersonas;
    private String rutaSubastas;

    public GestionArchivo(String rutaPersonas, String rutaSubastas) {
        this.rutaPersonas = rutaPersonas;
        this.rutaSubastas = rutaSubastas;
    }
    
    //El formato de guardado por linea es: true,Nombre,ValorenCuenta,InversionRequerida,
    public boolean savePromotor(Promotor persona)throws FileNotFoundException, IOException{
        BufferedWriter salida = null;
        FileWriter fw = null;

        File file = new File(this.rutaPersonas);
        if (!file.exists()) {
            file.createNewFile();
        }
            
        //El true permite seguir escribiendo en el archivo sin que s sobreescriba lo ya existente
        fw = new FileWriter(file.getAbsoluteFile(), true);
        salida = new BufferedWriter(fw);
        
        salida.write(String.valueOf(true));
        salida.write(",");
        salida.write(persona.getNombre());
        salida.write(",");
        salida.write(String.valueOf(persona.getCuenta().getValorencuenta()));
        salida.write(",");
        salida.write(String.valueOf(persona.getInversionRequerida()));
        salida.write(",\n");
        salida.flush();
        salida.close();
        return true;
    }
    
    //El formato de guardado por linea es: false,Nombre,ValorEnCuenta,
    public boolean saveAportante(Aportante persona)throws FileNotFoundException, IOException{
        BufferedWriter salida = null;
        FileWriter fw = null;

        File file = new File(this.rutaPersonas);
        if (!file.exists()) {
            file.createNewFile();
        }
            
        //El true permite seguir escribiendo en el archivo sin que s sobreescriba lo ya existente
        fw = new FileWriter(file.getAbsoluteFile(), true);
        salida = new BufferedWriter(fw);
        
        salida.write(String.valueOf(false));
        salida.write(",");
        salida.write(persona.getNombre());
        salida.write(",");
        salida.write(String.valueOf(persona.getCuenta().getValorencuenta()));
        salida.write(",\n");
        salida.flush();
        salida.close();
        return true;
    }
    
    public boolean saveSubasta(double valorSubastado, String nombrePromotor, String nombreGanador, double valorOferta) throws IOException{
        BufferedWriter salida = null;
        FileWriter fw = null;

        File file = new File(this.rutaSubastas);
        if (!file.exists()) {
            file.createNewFile();
        }
            
        //El true permite seguir escribiendo en el archivo sin que s sobreescriba lo ya existente
        fw = new FileWriter(file.getAbsoluteFile(), true);
        salida = new BufferedWriter(fw);
        
        salida.write(String.valueOf(valorSubastado));
        salida.write(",");
        salida.write(nombrePromotor);
        salida.write(",");
        salida.write(nombreGanador);
        salida.write(",");
        salida.write(String.valueOf(valorOferta));
        salida.write(",\n");
        salida.flush();
        salida.close();
        return true;
    }
    
    public ArrayList<Persona> loadPersonas(){
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Scanner sc;
        
        try {
            sc = new Scanner(new File(this.rutaPersonas));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                boolean promotor = Boolean.parseBoolean(sc.next().trim());
                int cedula = Integer.parseInt(sc.next().trim());
		String nombre = sc.next().trim();
                int telefono = Integer.parseInt(sc.next().trim());
                String email = sc.next().trim();
                double valorEnCuenta = Double.parseDouble(sc.next().trim());
                Persona persona = null;
                if (promotor) {
                    double inversionRequerida = Double.parseDouble(sc.next().trim());
                    persona = new Promotor(cedula,nombre,telefono,email,valorEnCuenta,inversionRequerida);
                }else{
                    persona = new Aportante(cedula,nombre,telefono,email,valorEnCuenta);
                }
                personas.add(persona);
            }
	}catch (FileNotFoundException e) {
            System.out.println("File not found -- " + this.rutaPersonas);
            e.printStackTrace();
	}
	return personas;
    }
    
    public ArrayList<Subasta> loadSubastas(){
        ArrayList<Subasta> subastas = new ArrayList<Subasta>();
        ArrayList<Persona> personas = loadPersonas();
        Scanner sc;
        
        try {
            sc = new Scanner(new File(this.rutaSubastas));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                double precioReserva = Double.parseDouble(sc.next().trim());
                String nombrePromotor = sc.next().trim();
                String nombreGanador = sc.next().trim();
                double valorOferta = Double.parseDouble(sc.next().trim());
                Promotor promotor = null;
                Aportante aportante = null;
                for (int i = 0; i < personas.size(); i++) {
                    if (personas.get(i).getNombre().equals(nombrePromotor)) {
                        promotor = (Promotor) personas.get(i);
                    }
                    if (personas.get(i).getNombre().equals(nombreGanador)) {
                        aportante = (Aportante) personas.get(i);
                    }
                }
                Subasta subasta = new Subasta(precioReserva,promotor);
                subasta.setTransaccion(precioReserva, promotor, aportante);
                subastas.add(subasta);
            }
	}catch (FileNotFoundException e) {
            System.out.println("File not found -- " + this.rutaPersonas);
            e.printStackTrace();
	}
	return subastas;
    }
}


