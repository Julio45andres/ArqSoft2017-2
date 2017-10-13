package com.udea.cliente;

// Importes necesarios para la clase
import com.edu.rmi.IFiguras;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente
{
    // Variable para referenciar el objeto remoto que tiene los procedimientos que calculan las caracteristicas de las figuras geometricas
    private static IFiguras clienteFiguras = null;
    
    // Metodo que realiza la conexion con el servidor e inicializa clienteFiguras con la direccion o referencia de donde esta el servidor
    // Si la conexion fue exitosa devuelve verdadero, de lo contrario falso
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
        
        new Thread (new VentanaBienvenida()).start(); // Aqui se inicia la ventana de bienvenida (o presentacion), esta solo aparece 5 segundos y despues se muestra la ventana principal
//        VentanaPrincipal v = new VentanaPrincipal();
//        v.setVisible(true);
        
//        if (conectarAlServidor())
//        {
//            System.out.println("Prueba 1 -> Area de un rectangulo de lados a=4 y b=3 :");
//            System.out.println(clienteFiguras.areaRectangulo(4D, 3D));
//            
//            System.out.println("Prueba 2 -> Perimetro de un rectangulo de lados a=4 y b=3 :");
//            System.out.println(clienteFiguras.permitroRectangulo(4D, 3D));
//        }
//        else
//        {
//            System.out.println("No se pudo establecer conexion con el servidor!");
//        }
    }
}
