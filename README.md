# BASES DE DATOS ORIENTADAS A OBJETOS

## En este ejemplo, se crea una base de datos utilizando DB4O llamada DBJefeHijo. La base de datos contendrá información sobre jefes y sus hijos. A continuación, se muestra el código en Java para crear y manipular esta base de datos:



import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        // Eliminar la base de datos si ya existe
        File fichero = new File("BDJefeHijo");
        fichero.delete();

        // Abrir la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo");

        // Almacenar información sobre jefes y sus hijos
        baseDatos.store(new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7)));
        baseDatos.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
        baseDatos.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
        baseDatos.store(new Jefe("Dolores", 5, 63, new Hijo("Sergio", 7)));
        baseDatos.store(new Jefe("Vicki", 3, 5, null));
        baseDatos.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
        baseDatos.store(new Jefe("Juan Luís", 3, 5, null));
        baseDatos.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20, 45, new Hijo("Paula", 3)));
        baseDatos.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));

        // Cerrar la base de datos
        baseDatos.close();
    }
}

CONSULTAS A REALIZAR:

1. Visualizar los jefes que tengan más de 55 años.

2. Modificar la edad de Miguel incrementándola en un año.

3. Borrar los jefes que llevan más de 6 años en la empresa.

4. Visualizar todos los jefes que quedan, incluidos sus hijos, que no han sido borrados anteriormente.

