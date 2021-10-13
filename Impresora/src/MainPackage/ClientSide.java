package MainPackage;

import java.io.IOException;

import Sockets.*;

public class ClientSide {
	static Conexion conexion;
	
public static void main(String[] args) {
	try {
		conexion = new Conexion("localhost");
	} catch (IOException e) {
	}
}
}
