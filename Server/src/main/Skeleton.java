package main;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import configuration.Configuration;
import control.*;
import model.Dao;
import model.DataAccessObject;
import service.*;

public class Skeleton {

    Registry registry;

    private CLogin cLogin;
    private CUser cUser;
    private CDirectory cDirectory;
    private CResult cResult;
    private CLecture cLecture;
    private CSearch cSearch;
    private CBasket cMiri;
    private CEnrollment cEnrollment;

    protected Skeleton() throws RemoteException {
        this.registry = LocateRegistry.createRegistry(Configuration.PORT_NUM);
    }

    private void register(String objectName, Remote object) throws AccessException, RemoteException, AlreadyBoundException {
        Remote remote = UnicastRemoteObject.exportObject(object, 0);
        registry.rebind(objectName, remote);
        System.out.println(objectName + "을 바인딩했습니다.");
    }

    public void initialize() throws Exception {
        Dao dao = new DataAccessObject();
        try {
            this.cLogin = new CLogin(dao);
            this.register(ILogin.OBJECT_NAME, this.cLogin);

            this.cUser = new CUser(dao);
            this.register(IUser.OBJECT_NAME, this.cUser);

            this.cDirectory = new CDirectory(dao);
            this.register(IDirectory.OBJECT_NAME, this.cDirectory);

            this.cResult = new CResult(dao);
            this.register(IResult.OBJECT_NAME, this.cResult);

            this.cLecture = new CLecture(dao);
            this.register(ILecture.OBJECT_NAME, this.cLecture);

            this.cSearch = new CSearch(dao);
            this.register(ISearch.OBJECT_NAME, this.cSearch);

            this.cMiri = new CBasket(dao);
            this.register(IBasket.OBJECT_NAME, this.cMiri);

            this.cEnrollment = new CEnrollment(dao);
            this.register(IEnrollment.OBJECT_NAME, this.cEnrollment);

            System.out.println("레지스트리에 바인딩된 객체들:");
            String[] names = registry.list();
            for (String name : names) {
                System.out.println("  - " + name);
            }
        } catch (Exception e) {
            System.err.println("바인딩 실패");
            e.printStackTrace();
            throw e;
        }
    }
}