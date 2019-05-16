import java.rmi.registry.*;

public class Client {
	public static void main (String [] args)throws Exception{
		
		String host = "localhost";
		int port = 12345;
		
		Registry registry = LocateRegistry.getRegistry(host,port);
		
		String [] registers = registry.list();
		
		for(String a :registers)
				System.out.println(a);
		System.out.println("--");
		CalculatorInterface calculator = 
			(CalculatorInterface)(registry.lookup("Calculator1"));
			
		CalculatorInterface calculator2 = 
			(CalculatorInterface)(registry.lookup("Calculator2"));
	        double result = calculator.add(3);
		double result2 = calculator2.add(3);
		System.out.println("Adding 3 to calculator with default constructor: " + result);
		System.out.println("Adding 3 to calculator with initial value 5: " + result2);

	}
	
}
