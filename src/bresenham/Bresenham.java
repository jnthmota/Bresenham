package bresenham;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Bresenham extends JFrame {
	public Bresenham(){
		setSize(800, 600);
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
        g.setColor(new Color(0, 0, 255));
        tempo(30);
		g.drawOval((int) x, (int) y, 1, 1);

        while (y > x) // Octante escolhido
        {
            if(d < 0) // Escolhe e
                d = d + 2.0 * x + 3.0;
            else{
                    d = d + 2.0 * (x - y) + 5.0;
                    y--;
            }
            g.setColor(new Color(0, 0, 255));
            tempo(30);
    		g.drawOval((int) x, (int) y, 1, 1);
    		x++;
        }

		
	}
	
	
	public void tempo(int x) {
		try {
			Thread.sleep(x);
		}catch(Exception e) {}
	}
	
	public static void main(String args []) {
		Bresenham cir = new Bresenham();
		cir.desenha();
	}
}
