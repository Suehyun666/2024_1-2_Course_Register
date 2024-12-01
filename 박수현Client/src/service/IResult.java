package service;

import java.rmi.Remote;
import java.util.Vector;

import valueObject.VGangjwa;

public interface IResult extends Remote {
	public final static String OBJECT_NAME	= "CRESULT"; 
	public void save(String fileName, Vector<VGangjwa> vGangjwas) throws Exception;
	public Vector<VGangjwa> get(String fileName) throws Exception;

}
