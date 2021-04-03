package bresenham;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Circuferencia extends JFrame {
	public Circuferencia(){
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Circulo 90 graus");
		setVisible(true);
	}
	
	public void desenha() {
		double raio = 100;
		double angulo = 0;
		Graphics g = getGraphics();
		g.setColor(new Color(0, 0, 255));
		double x;
		double y;
		while (angulo <= 90) {
			g.setColor(new Color(255, 0, 0));
			x = calculaX(raio, angulo);
			y = calculaY(raio, angulo);
		
			tempo(30);
			g.drawOval((int) x, (int) y, 1, 1);
			angulo ++;

		}
		
	}
	
	public double calculaX(double raio, double angulo) {
		double x = raio * Math.cos(Math.toRadians(angulo));
		return x;
	}
	
	public double calculaY(double raio, double angulo) {
		double y = raio * Math.sin(Math.toRadians(angulo));
		return y;
	}
	
	public void tempo(int x) {
		try {
			Thread.sleep(x);
		}catch(Exception e) {}
	}
	
	public static void main(String args []) {
		Circuferencia cir = new Circuferencia();
		cir.desenha();
	}
}
