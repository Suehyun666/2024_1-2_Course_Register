package service;

import valueObject.VLecture;

import java.rmi.Remote;
import java.util.Vector;

public interface ILecture extends Remote {
	public final static String OBJECT_NAME	= "CLECTURE";
	public Vector<VLecture> getData(String fileName) throws Exception;
}
