package ServerSide;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockets {

	public void ServerInit(int PORT) throws IOException {
		 ServerSocket serverSocket = null;

	        try {
	            serverSocket = new ServerSocket(PORT);
	            System.out.println("Servidor abierto");
	        } catch (IOException ex) {
	            System.out.println("No se pudo abrir el servidor en el puerto: " + PORT);
	        }

	        Socket socket = null;
	        InputStream in = null;
	        OutputStream out = null;
	        
	        try {
	            socket = serverSocket.accept();
	            System.out.println("conexión aceptada");
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        }
	        
	        try {
	            in = socket.getInputStream();
	        } catch (IOException ex) {
	        }

	        try {
	            out = new FileOutputStream("archivo.pdf");
	            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
	            os.writeChars("Recibido!");
	        } catch (FileNotFoundException ex) {
	            System.out.println("File not found. ");
	        }

	        byte[] bytes = new byte[16*1024];

	        int count;
	        while ((count = in.read(bytes)) > 0) {
	            out.write(bytes, 0, count);
	        }

	        //out.close();
	        //in.close();
	        //socket.close();
	        //serverSocket.close();
	    }	
	}
	

