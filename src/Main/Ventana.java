package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import ClientSide.*;

import javax.swing.*;

public class Ventana {

	public Ventana() {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1, 2));
		JPanel panelizq = new JPanel();
		JPanel panelder = new JPanel();
		JFileChooser fc = new JFileChooser();
		panelizq.add(fc, BorderLayout.NORTH);
		DefaultListModel<File> model = new DefaultListModel<File>();
		JList<File> list = new JList<File>(model);
		panelizq.add(list, BorderLayout.CENTER);
		JButton send = new JButton("enviar");
		panelizq.add(send, BorderLayout.SOUTH);
		JLabel host = new JLabel("HOST: ");
		JLabel port = new JLabel("PORT: ");
		JTextField HOST = new JTextField();
		JTextField PORT = new JTextField();
		panelder.setLayout(new GridLayout(18, 1));
		panelder.add(host);
		panelder.add(HOST);
		panelder.add(port);
		panelder.add(PORT);
		frame.add(panelizq);
		frame.add(panelder);

		fc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addElement(fc.getSelectedFile());
			}
		});
		
		
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = (File) list.getSelectedValue();
				try {
					
					new SocketsCS().ClientSide(HOST.getText(), Integer.valueOf(PORT.getText()), f);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		frame.setTitle("Servicio de impresión a distancia");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(1);
		frame.setVisible(true);
	}

}
