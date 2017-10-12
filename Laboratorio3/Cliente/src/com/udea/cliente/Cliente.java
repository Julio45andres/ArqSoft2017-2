package com.udea.cliente;

// Importes necesarios para la clase
import com.edu.rmi.IFiguras;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente
{
    private static IFiguras clienteFiguras = null;
    
    private static boolean conectarAlServidor()
    {
        try
        {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1099);
        
            clienteFiguras = (IFiguras) registro.lookup("ServidorFiguras");
        }
        catch (Exception e)
        {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws Exception
    {
        if (conectarAlServidor())
        {
            System.out.println("Prueba 1 -> Area de un rectangulo de lados a=4 y b=3 :");
            System.out.println(clienteFiguras.areaRectangulo(4D, 3D));
            
            System.out.println("Prueba 2 -> Perimetro de un rectangulo de lados a=4 y b=3 :");
            System.out.println(clienteFiguras.permitroRectangulo(4D, 3D));
        }
        else
        {
            System.out.println("No se pudo establecer conexion con el servidor!");
        }
    }
}
