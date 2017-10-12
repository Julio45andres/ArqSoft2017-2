package com.udea.servidor;

// Importes necesarios para la clase
import com.edu.rmi.IFiguras;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Clase que implementa las metodos de calculo de las areas, perimetros y volumenes de algunas figuras geometricas
public class CalculadoraFiguras extends UnicastRemoteObject implements IFiguras
{
    // Constructor de la clase
    public CalculadoraFiguras() throws RemoteException
    {
        super();
    }
    
    // Metodos implementados que realizan los calculos de las figuras geometricas
    
    @Override
    public Double areaRectangulo(Double a, Double b) throws RemoteException
    {
        return a*b;
    }

    @Override
    public Double permitroRectangulo(Double a, Double b) throws RemoteException
    {
        return 2*(a+b);
    }

    @Override
    public Double areaElipse(Double r1, Double r2) throws RemoteException
    {
        return Math.PI*(r1*r2);
        // Formula obtenida de: http://www.universoformulas.com/matematicas/geometria/area-elipse/
    }

    @Override
    public Double permitroElipse(Double r1, Double r2) throws RemoteException
    {
        return Math.PI*((3*(r1+r2)) - Math.sqrt((3*r1 + r2)*(r1 + 3*r2)));
        // Formula obtenida de: http://www.universoformulas.com/matematicas/geometria/perimetro-elipse/
    }

    @Override
    public Double areaTriangulo(Double b, Double h) throws RemoteException
    {
        return (b*h)/2;
    }

    @Override
    public Double permitroTriangulo(Double a, Double b, Double c) throws RemoteException
    {
        return a + b + c;
    }

    @Override
    public Double areaCubo(Double a, Double b, Double c) throws RemoteException
    {
        return 2*(a*b + a*c + b*c);
        // Nota:
        // La formula que se usa aqui es la de un paralelepipedo
        // Y fue tomada de: http://www.universoformulas.com/matematicas/geometria/area-paralelepipedo/
    }

    @Override
    public Double volumenCubo(Double a, Double b, Double c) throws RemoteException
    {
        return a*b*c;
    }
    
    // Los siguientes dos formulas del cilindro solo son validas cuando la base es circular
    @Override
    public Double areaCilindro(Double r, Double h) throws RemoteException
    {
        return 2*Math.PI*r*(r+h);
        // Formula obtenida de: http://www.universoformulas.com/matematicas/geometria/area-cilindro/
    }

    @Override
    public Double volumenCilindro(Double r, Double h) throws RemoteException
    {
        return Math.PI*(Math.pow(r, 2))*h;
        // Formula obtenida de: http://www.universoformulas.com/matematicas/geometria/volumen-cilindro/
    }
    
    // Las siguientes dos formulas son solo validas para una pirámide cuadrangular regular
    @Override
    public Double areaPiramide(Double l, Double ap) throws RemoteException
    {
        return l*( (2*ap) + l);
        // Formula obtenida de:
        // http://www.universoformulas.com/matematicas/geometria/piramide-cuadrangular/
        // https://youtu.be/jZak94en3P4
    }

    @Override
    public Double volumenPiramide(Double l, Double h) throws RemoteException
    {
        return (Math.pow(l, 2)*h)/3;
        // Formula obtenida de:
        // http://www.universoformulas.com/matematicas/geometria/volumen-piramide-cuadrangular/
        // https://youtu.be/jZak94en3P4
    }
    
    // Los siguientes dos formulas del cono solo son validas para el cono de base circular
    @Override
    public Double areaCono(Double g, Double r) throws RemoteException
    {
        return Math.PI*r*(r+g);
        // Formula obtenida de: http://www.universoformulas.com/matematicas/geometria/area-cono/
    }

    @Override
    public Double volumenCono(Double h, Double r) throws RemoteException
    {
        return (Math.PI*(Math.pow(r, 2))*h)/3;
        // Formula obtenida de: http://www.universoformulas.com/matematicas/geometria/volumen-cono/
    }
    
}
