import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CalculatorInterface extends Remote{
	
    double add(double b) throws RemoteException;
    double substract(double b) throws RemoteException;
    double multiply(double b) throws RemoteException;
    double divide(double b) throws RemoteException;
}
