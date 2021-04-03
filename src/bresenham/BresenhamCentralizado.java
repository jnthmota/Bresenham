package bresenham;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class BresenhamCentralizado  extends JFrame  {
	double largura = 800, altura = 600;
	public BresenhamCentralizado(){
		setSize((int)largura, (int)altura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Circulo 90 graus");
		setVisible(true);
	}
	
	public void desenha() {
		Graphics g = getGraphics();
		g.setColor(new Color(0, 0, 255));
		int raio = 100;
		int x = 0;
        int y = raio;
        double d = 1 - raio; // int d = 1 - raio
        tempo(30);
		g.fillOval((int) x, (int) y, 1, 1);

        while (y > x) // Octante escolhido
        {
            if(d < 0) // Escolhe e
                d = d + 2.0 * x + 3.0;
            else{
                    d = d + 2.0 * (x - y) + 5.0;
                    y--;
            }
            
            tempo(30);
			circlePoints(x, y);
    		x++;
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
		 g.setColor(new Color(0, 0, 255));
		x = x + (largura/2);
		y = y + (altura/2);
		g.fillOval((int)x, (int)y , 5, 5);
	}
	
	
	public void tempo(int x) {
		try {
			Thread.sleep(x);
		}catch(Exception e) {}
	}
	
	public static void main(String args []) {
		BresenhamCentralizado cir = new BresenhamCentralizado();
		cir.desenha();
	}
}
