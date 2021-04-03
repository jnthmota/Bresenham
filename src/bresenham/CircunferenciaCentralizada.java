package bresenham;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class CircunferenciaCentralizada  extends JFrame  {
	double largura = 800, altura = 600;
	
	public CircunferenciaCentralizada(){
		setSize((int)largura, (int)altura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Circulo");
		setVisible(true);
	}
	
	public void desenha() {
		double raio = 100;
		double angulo = 0;
		Graphics g = getGraphics();
		g.setColor(new Color(0, 0, 255));
		double x;
		double y;
		while (angulo <= 45) {
			g.setColor(new Color(255, 0, 0));
			x = calculaX(raio, angulo);
			y = calculaY(raio, angulo);

			tempo(30);
			circlePoints(x, y);
			angulo += 0.50;

		}
		
	}
	
	public void circlePoints(double x, double y) {
		whitePixel(x,y);
		whitePixel(y,x);
		whitePixel(y,-x);
		whitePixel(x,-y);
		whitePixel(-x,-y);
		whitePixel(-y,-x);
		whitePixel(-y,x);
		whitePixel(-x,y);
		
	}
	
	public void whitePixel(double x, double y){
		Graphics g = getGraphics();
		g.setColor(new Color(255, 0, 0));
		x = x + (largura/2);
		y = y + (altura/2);
		g.fillOval((int)x, (int)y , 5, 5);
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
		CircunferenciaCentralizada cir = new CircunferenciaCentralizada();
		cir.desenha();
	}
}