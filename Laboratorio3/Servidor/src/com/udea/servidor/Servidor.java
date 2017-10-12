package com.udea.servidor;

// Importes necesarios para la clase
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Paginas que nos ayudaron con el desarrollo de este proyecto:
// 
// Sencillo ejemplo de JAVA RMI
// http://jcesarmoreno.blogspot.com.co/2016/04/sencillo-ejemplo-de-java-rmi.html
// 
// New Easy Tutorial for Java RMI using Eclipse
// http://www.ejbtutorial.com/java-rmi/new-easy-tutorial-for-java-rmi-using-eclipse
//
// How to Create Java RMI using Netbeans IDE Part1 [El mejor - Sencillo y efectivo]
// https://youtu.be/el2PHj-XD4o
//
// How to Create Java RMI using Netbeans Part2
// https://youtu.be/9sUn6WVXgmM

// Clase que registrara los procedimientos a ser invocados y atendera a los clientes
// NOTA: Esta clase tambien hereda de UnicastRemoteObject con el fin de que se puedan
//       generar de forma automatizada los stubs, ahorrandonos el esfuerzo de compilar
//       las clases por consola y permitiendonos ejecutar el servidor desde el mismo
//       NetBeans sin requerir el uso de rmiregistry para reservar los puertos.
public class Servidor extends UnicastRemoteObject
{
    // Constructor de la clase. No tiene un proposito especial
    public Servidor() throws RemoteException
    {
        super();
    }
    
    // Metodo principal del servidor
    public static void main(String[] args)
    {
        try
        {
            // En primer lugar, se crea el objeto remoto con los procedimientos que invocaran los clientes
            CalculadoraFiguras ServidorFiguras = new CalculadoraFiguras();
            
            // Luego, se registra este objeto bajo el puerto 1099 y con el nombre: ServidorFiguras
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("ServidorFiguras", ServidorFiguras);
            
            // Tambien se emite un mensaje de que el servidor ya es operativo y cuando se desee parar el mismo, el administrador solo debe presionar ENTER
            System.out.println("Servidor listo...\nPara terminar presione enter:\n");
            System.in.read();
            
            // Si se pasa aqui es porque se quiere terminar con la ejecucion del servidor por lo que se desvincula el objeto ServidorFiguras del servicio de nombres y se indica explicitamente que ya no es posible recibir llamadas
            registro.unbind("ServidorFiguras");
            UnicastRemoteObject.unexportObject(ServidorFiguras, true);
        }
        catch(Exception e) // En caso que se tenga problemas para iniciar el servidor ...
        {
            // Muestro un mensaje al respecto e imprimo el error
            System.out.println("Se presento un problema al iniciar el servidor!");
            System.out.println("---");
            e.printStackTrace();
        }
    }
}
