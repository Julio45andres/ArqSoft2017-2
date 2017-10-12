package com.edu.rmi;

import java.rmi.*;

public interface IFiguras extends Remote
{
    // Metodos para figuras bidimensionales
    public Long areaCuadrado(Long a, Long b) throws RemoteException;
    public Long permitroCuadrado(Long a, Long b) throws RemoteException;
    
    public Long areaElipse(Long a, Long b) throws RemoteException;
    public Long permitroElipse(Long a, Long b) throws RemoteException;
    
    public Long areaTriangulo(Long a, Long b) throws RemoteException;
    public Long permitroTriangulo(Long a, Long b) throws RemoteException;
    
    // Metodos para figuras tridimensionales
    public Long areaCubo(Long a, Long b) throws RemoteException;
    public Long volumenCubo(Long a, Long b) throws RemoteException;
    
    public Long areaCilindro(Long a, Long b) throws RemoteException;
    public Long volumenCilindro(Long a, Long b) throws RemoteException;
    
    public Long areaPiramide(Long a, Long b) throws RemoteException;
    public Long volumenPiramide(Long a, Long b) throws RemoteException;
    
    public Long areaCono(Long a, Long b) throws RemoteException;
    public Long volumenCono(Long a, Long b) throws RemoteException;
}
