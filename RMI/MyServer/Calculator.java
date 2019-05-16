import java.rmi.Remote;
import java.rmi.RemoteException;


public class Calculator
    extends java.rmi.server.UnicastRemoteObject
    implements CalculatorInterface {

    private double result;

    public Calculator() throws RemoteException {
	this(0);
    }

    public Calculator(double value) throws RemoteException {
	this.result = value;
    }
    public double add(double b) throws RemoteException {
        result += b;
	return result;
    }
    public double substract(double b) throws RemoteException {
        result -= b;
	return result;
    }
    public double multiply(double b) throws RemoteException {
        result *= b;
	return result;
    }
    public double divide(double b) throws RemoteException {
	result = (b == 0) ? 0 : (result / b); 
	return result;
    }
}
