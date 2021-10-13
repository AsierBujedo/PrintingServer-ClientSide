package MainPackage;

import java.io.IOException;

import Sockets.*;

public class ServerSide {
	
public static void main(String[] args) {
	try {
		new Servidor().startServer();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}
