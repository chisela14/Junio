package com.jacaranda.baraja;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class JuegoGUI implements ActionListener {

	private JButton[] cartasJugador;
	private int numCartasJugador;
	private double puntosJugador;
	private JButton[] cartasBanca;
	private int numCartasBanca;
	private double puntosBanca;
	private JButton otraCarta;
	private JButton mePlanto;

	private JFrame ventana;
	private JPanel panelJugador;
	private JPanel panelBanca;
	private JPanel panelBoton;
	
	private Baraja baraja;
	

	public JuegoGUI(int tipoBaraja) throws BarajaException  {
		
		if (tipoBaraja == 1) {
			baraja = new BarajaEspannola();	
		}else {
			baraja = new BarajaInglesa();
		}
		
		this.numCartasBanca =0;
		this.numCartasJugador=0;
		this.puntosBanca=0;
		this.puntosJugador=0;
		// Crea el JFrame que es la ventana. Le pongo el nombre y el botón de cerrar
		ventana = new JFrame("Jaca y media");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Botón vacio para que guarde la relacion del tamaño
		
		ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/vacio.jpg");

		// Crea una matriz para guardar los botones que se añaden
		cartasJugador = new JButton[10];
		// Crea el panel del juego

		panelJugador = new JPanel();

		// Crea un GridLayout para organizar los botones en forma de matriz
		panelJugador.setLayout(new GridLayout(1, 10));

		for (int j = 0; j < 10; j++) {
			JButton button1 = new JButton();
			button1.setMaximumSize(new Dimension(50, 50));
			button1.setIcon(imageIcon);

			panelJugador.add(button1);
			cartasJugador[j] = button1;

		}

		ventana.add(panelJugador, BorderLayout.NORTH);

		// Cartas de la banca

		panelBanca = new JPanel();
		cartasBanca = new JButton[10];

		// Crea un GridLayout para organizar los botones en forma de matriz
		panelBanca.setLayout(new GridLayout(1, 10));

		for (int j = 0; j < 10; j++) {
			JButton button1 = new JButton();
			button1.setMaximumSize(new Dimension(50, 50));
			button1.setIcon(imageIcon);


			panelBanca.add(button1);
			cartasBanca[j] = button1;

		}

		ventana.add(panelBanca, BorderLayout.CENTER);

		// Crea el panel del juego

		panelBoton = new JPanel();
		panelBoton.setSize(100,100);

		// Crea un GridLayout para organizar los botones en forma de matriz
		panelBoton.setLayout(new GridLayout(1, 2));

		otraCarta = new JButton();
		otraCarta.setText("Carta");
		otraCarta.addActionListener((ActionListener) this);
		panelBoton.add(otraCarta);

		mePlanto = new JButton();
		mePlanto.setText("Me planto");

		mePlanto.addActionListener((ActionListener) this);
		mePlanto.setMaximumSize(new Dimension(50, 50));

		panelBoton.add(mePlanto);

		ventana.add(panelBoton, BorderLayout.SOUTH);

		ventana.pack();
		ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton bx = (JButton) e.getSource();

		if (bx == mePlanto) {
			JOptionPane.showMessageDialog(ventana, "Perfecto ahora le toca la banca");
			do {
				Carta carta = baraja.getSiguiente();
				ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/"+ carta.getPalo().toLowerCase() + "_" + carta.getNumber() + "s.jpg");
				
				this.cartasBanca[this.numCartasBanca++].setIcon(imageIcon);
				this.puntosBanca+=carta.getValor();
				if (this.puntosBanca > 7.5) {
					JOptionPane.showMessageDialog(ventana, "La banca se ha pasado. Pierde la banca");
			    	System.exit(0);
				}	
			}while (this.puntosBanca < this.puntosJugador);
			JOptionPane.showMessageDialog(ventana, "Gana la banca");
	    	System.exit(0);
			
		}
		if (bx == otraCarta) {
			Carta carta = baraja.getSiguiente();
	
			ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/"+ carta.getPalo().toLowerCase() + "_" + carta.getNumber() + "s.jpg");
			
			cartasJugador[this.numCartasJugador++].setIcon(imageIcon);
			this.puntosJugador+=carta.getValor();
			if (this.puntosJugador > 7.5) {
				JOptionPane.showMessageDialog(ventana, "Te has pasado. Gana la banca");
		    	System.exit(0);
			}
			
		}
	}

}
