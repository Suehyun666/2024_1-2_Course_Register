package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import service.IGangjwa;
import valueObject.VGangjwa;

public class CGangjwa extends CContorl implements IGangjwa{
	private IGangjwa iGangjwa; 
	public CGangjwa() throws RemoteException, NotBoundException{
		this.iGangjwa=(IGangjwa) this.registry.lookup(iGangjwa.OBJECT_NAME);
	}
	
	public Vector<VGangjwa> getData(String fileName) {
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		
		return vGangjwas;
	}

}
