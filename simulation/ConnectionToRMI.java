import java.io.*;
public class ConnectionToRMI implements Serializable{
    private String name;
    private int port;
    private String serviceName;

    public ConnectionToRMI(String name, int port, String serviceName) {
	this.name = name;
	this.port = port;
	this.serviceName = serviceName;
    }

    @Override public String toString() {
	return this.name + " " + this.port + " " + this.serviceName;
    }
}

