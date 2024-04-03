package basedatosdb4o;

//paquetes necesarios del API Db4o para Java
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;

public class BaseDatosDb4o {
    
    public static void main(String[] args) {
        
        //Este código lo ponemos por si la base de datos ya existiera y quisiéramos empezar desde el principio
        File fichero=new File("BDJefeHijo");
        fichero.delete();
       
        //Se abre la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
        //Se almacenan los datos en la base de datos
        baseDatos.store(new Jefe("Ángel", 5, 53,new Hijo("Gustavo", 7)));
        baseDatos.store(new Jefe("Nieves", 3, 45,new Hijo("Iván", 3)));
        baseDatos.store(new Jefe("Jesús", 3, 5,new Hijo("Noelia", 3)));
        baseDatos.store(new Jefe("Dolores", 5,63,new Hijo("Sergio", 7)));
        baseDatos.store(new Jefe("Vicki", 3, 5,null));
        baseDatos.store(new Jefe("Fátima", 5,63,new Hijo("Lidia", 27)));
        baseDatos.store(new Jefe("Juan Luís", 3, 5,null));
        baseDatos.store(new Jefe("Elena", 1,42,new Hijo("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20,45,new Hijo("Paula", 3)));
        baseDatos.store(new Jefe("Jesús", 19, 44,new Hijo("Rubén", 12)));
        baseDatos.close();

        jefesMas55();
        incrementarEdadMiguel();
        borraJefesmas6anos();
        verJefeseHijos();
    }

    //Visualiza los jefes que tengan más de 55 años
        public static void jefesMas55() { 
            ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
            Query query = baseDatos.query();
            query.constrain(Jefe.class);
            query.descend("edad").constrain(55).greater();
            ObjectSet<Jefe>jefesMayores = query.execute();
            
            //Se muestra el resultado de la consulta
            System.out.println("Jefes mayores de 55 años:");
            while (jefesMayores.hasNext()) {
                Jefe jefe = jefesMayores.next();
                System.out.println(jefe);
            }

            // Se cierra la base de datos
             baseDatos.close();
        }
        //Modifica a idade de Miguel incrementando a súa idade un ano máis
        public static void incrementarEdadMiguel() { 
            ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
            Query query = baseDatos.query();
            query.constrain(Jefe.class);
            query.descend("nombre").constrain("Miguel");
            ObjectSet<Jefe>resultadoQuery = query.execute();
            System.out.println("Incrementar edad de Miguel en un año:");

            while (resultadoQuery.hasNext()) { 
                Jefe miguel =  resultadoQuery.next();
                miguel.setEdad(miguel.getEdad()+1);
                
                System.out.println(miguel);
                baseDatos.store(miguel);
            }
            baseDatos.close();
        
        }
        //Borra los jefes que llevan más de 6 años en la empresa.
        public static void borraJefesmas6anos() { 
            ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
            Query query = baseDatos.query();
            query.constrain(Jefe.class);
            query.descend("anosEmpresa").constrain(6).greater();
            ObjectSet<Jefe>jefesBorrados = query.execute();
            System.out.println("Jefes borrados:");

            while(jefesBorrados.hasNext()) { 
                Jefe jefeBorrar = jefesBorrados.next();
                baseDatos.delete(jefeBorrar);     
                System.out.println(jefeBorrar);
            }
            baseDatos.close();
        }   

        //Visualiza todos los jefes que quedan, incluidos sus hijos, que no han sido borrados anteriormente.
        public static void verJefeseHijos() { 
            ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
            Query query = baseDatos.query();
            query.constrain(Jefe.class);
            ObjectSet<Jefe>jefesRestantes = query.execute();
            System.out.println("Jefes restantes:");
            
            while(jefesRestantes.hasNext()) { 
                Jefe jefe = jefesRestantes.next();              
                System.out.println(jefe);
                if(jefe.getHijo() != null){ 
                    System.out.println("Hijo: " + jefe.getHijo());
                }  
            }
            baseDatos.close();
        }
        
      
}
