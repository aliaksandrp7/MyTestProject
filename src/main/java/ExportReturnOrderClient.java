import myExeption.RemoteException;

public class ExportReturnOrderClient {
    public boolean methodOne (int i) throws RemoteException {
        if (i<0){
            throw new RuntimeException("ошибка в ExportReturnOrderClient");
        }
        return true;
    }

}
