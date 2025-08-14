package control;

import java.rmi.RemoteException;
import java.util.Vector;
import model.MDirectory;
import model.Dao;
import model.MModel;
import service.IDirectory;
import valueObject.VDirectory;

public class CDirectory extends CControl implements IDirectory {
    public CDirectory(Dao dao) throws RemoteException {
        super(dao);
    }
    @Override
    public Vector<VDirectory> getData(String fileName) throws Exception {
        try {
            Vector<MModel> mModels = dao.getDirectory(fileName, MDirectory.class);
            Vector<VDirectory> vDrectories = new Vector<VDirectory>();
            for (MModel mModel: mModels) {
                MDirectory mDirectory = (MDirectory) mModel;
                VDirectory vDirectory = new VDirectory(
                    mDirectory.getName(),
                    mDirectory.getFileName()
                );
                vDrectories.add(vDirectory);
            }
            return vDrectories;
        } catch (Exception e) {
            System.err.println("**SERVER: CDirectory.getData() 예외 발생: " + e.getMessage());
            throw new RemoteException("CDirectory.getData failed", e);
        }
    }

}
