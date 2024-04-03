BASES DE DATOS ORIENTADAS A OBJETOS

Crea una base de datos con DB40 llamada DBJefeHijo con la siguiente información:

public static void main(String[] args)
{
File fichero=new File("BDJefeHijo");
fichero.delete();
/*Este código anterior lo ponemos por si la base de datos ya existiera y quisiéramos empezar desde el principio.*/
ObjectContainer baseDatos=Db4oEmbedded.openFile("BDJefeHijo");
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
}
Realizar las siguientes consultas:

Visualiza los jefes que tengan más de 55 años.
Modifica la edad de Miguel incrementando su edad un año más.
Borra los jefes que llevan más de 6 años en la empresa.
Visualiza todos los jefes que quedan, incluidos sus hijos, que no han sido borrados anteriormente.
