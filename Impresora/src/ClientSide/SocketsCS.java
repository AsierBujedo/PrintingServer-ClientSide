package ClientSide;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketsCS {
	public void ClientSide(String HOST, int PORT, File file) throws UnknownHostException, IOException {
		Socket socket = null;
		try {
        socket = new Socket(HOST, PORT);
        long length = file.length();
        System.out.println("Tamaño: "+ length);
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();
        
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
            System.out.println(count);
            System.out.println(bytes);
        }
        System.out.println("¡Enviado!");
        
        out.close();
        in.close();
        socket.close();
        
		} catch (Exception e) {
			System.out.println("Imposible enviar el archivo");
			e.printStackTrace();
		}
        
	}
}
