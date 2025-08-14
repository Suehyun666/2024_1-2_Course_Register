package control;

import java.rmi.RemoteException;

import model.Dao;

public class CControl {
    protected Dao dao;
    public CControl(Dao dao) throws RemoteException{
        this.dao=dao;
    }
}
