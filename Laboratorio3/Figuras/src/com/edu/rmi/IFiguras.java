package com.edu.rmi;

import java.rmi.*;

// Interfaz para definir cuales son las operaciones basicas que se pueden calcular para un cierto conjunto de figuras
public interface IFiguras extends Remote
{
    // --------- Metodos para figuras bidimensionales ---------
    
    public Double areaRectangulo(Double a, Double b) throws RemoteException;
    public Double permitroRectangulo(Double a, Double b) throws RemoteException;
    
    public Double areaElipse(Double r1, Double r2) throws RemoteException;
    public Double permitroElipse(Double r1, Double r2) throws RemoteException;
    
    public Double areaTriangulo(Double b, Double h) throws RemoteException;
    public Double permitroTriangulo(Double a, Double b, Double c) throws RemoteException;
    
    // --------- Metodos para figuras tridimensionales ---------
    
    public Double areaCubo(Double a, Double b, Double c) throws RemoteException;
    public Double volumenCubo(Double a, Double b, Double c) throws RemoteException;
    
    public Double areaCilindro(Double r, Double h) throws RemoteException;
    public Double volumenCilindro(Double r, Double h) throws RemoteException;
    
    // OJO! - Esto es para una piramide cuadrangular regular. https://youtu.be/jZak94en3P4
    public Double areaPiramide(Double l, Double ap) throws RemoteException;
    public Double volumenPiramide(Double l, Double h) throws RemoteException;
    
    public Double areaCono(Double g, Double r) throws RemoteException;
    public Double volumenCono(Double h, Double r) throws RemoteException;
}
