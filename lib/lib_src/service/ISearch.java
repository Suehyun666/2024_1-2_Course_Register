package service;

import valueObject.VLecture;

import java.rmi.Remote;
import java.util.Vector;


public interface ISearch extends Remote {
	public final static String OBJECT_NAME	= "CSEARCH";
	public Vector<VLecture> search(String keyword) throws Exception;
}
