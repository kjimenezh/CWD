
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


/**
 * @author kjime
 */
public class GestionArchivo {
    private String ruta;

    public GestionArchivo(String ruta) {
        this.ruta = ruta;
    }
    
    //El formato de guardado por linea es: true,Nombre,ValorenCuenta,InversionRequerida,
    public boolean savePromotor(Promotor persona)throws FileNotFoundException, IOException{
        BufferedWriter salida = null;
        FileWriter fw = null;

        File file = new File(this.ruta);
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

        File file = new File(this.ruta);
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
    
    public ArrayList<Persona> loadUsers(){
        ArrayList<Persona> users = new ArrayList<Persona>();
        Scanner sc;
        
        try {
            sc = new Scanner(new File(this.ruta));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                boolean promotor = Boolean.parseBoolean(sc.next().trim());
                int cedula = Integer.parseInt(sc.next().trim());
		String nombre = sc.next().trim();
                int telefono = Integer.parseInt(sc.next().trim());
                String email = sc.next().trim();
                double valorEnCuenta = Double.parseDouble(sc.next().trim());
                Persona user = null;
                if (promotor) {
                    double inversionRequerida = Double.parseDouble(sc.next().trim());
                    user = new Promotor(cedula,nombre,telefono,email,valorEnCuenta,inversionRequerida);
                }else{
                    user = new Aportante(cedula,nombre,telefono,email,valorEnCuenta);
                }
                users.add(user);
            }
	}catch (FileNotFoundException e) {
            System.out.println("File not found -- " + this.ruta);
            e.printStackTrace();
	}
	return users;
    }
}


