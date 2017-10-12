package com.udea.servidor;

// Importes necesarios para la clase
import com.edu.rmi.IFiguras;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Paginas que ayudaron con el desarrollo de este proyecto:
// 
// Sencillo ejemplo de JAVA RMI
// http://jcesarmoreno.blogspot.com.co/2016/04/sencillo-ejemplo-de-java-rmi.html
// 
// 
// 

public class Servidor
{
    
    public static void main(String[] args)
    {
        try
        {
            CalculadoraFiguras ServidorFiguras = new CalculadoraFiguras();
            
            IFiguras FigurasRemotas = (IFiguras) UnicastRemoteObject.exportObject(ServidorFiguras, 1099);
            
            LocateRegistry.createRegistry(0);
            
            Registry registro = LocateRegistry.getRegistry();
            registro.rebind("ServidorFiguras", FigurasRemotas);
            
            System.out.println("Servidor listo...\nPara terminar presione enter:\n");
            System.in.read();
            
            registro.unbind("ServidorFiguras");
            UnicastRemoteObject.unexportObject(ServidorFiguras, true);
        }
        catch(Exception e) // En caso que se tenga problemas para iniciar el servidor ...
        {
            // Muestro un mensaje al respecto e imprimo el error
            System.out.println("Se presento un problema la iniciar el servidor!");
            System.out.println("---");
            System.out.println(e);
        }
    }
}
