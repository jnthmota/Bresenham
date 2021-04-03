import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Rotacao extends JFrame {

    int p1[] = new int[4];
    int p2[] = new int[4];
    int p3[] = new int[4];
    int p4[] = new int[4];

    double pontoX;
    double pontoY;
    int janela = 600;

    public Rotacao() {
        setSize(janela, janela);
        setTitle("Rotação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void tempo(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }


    void setPs() {

        Integer x1= 50;
        Integer y1= 50;

        Integer x2= 150;
        Integer y2= 50;

        Integer x3= 150;
        Integer y3= 100;

        Integer x4= 50;
        Integer y4= 100;


        p1[0] = x1;
        p1[1] = y1;
        p1[2] = x2;
        p1[3] = y2;

        p2[0] = x2;
        p2[1] = y2;
        p2[2] = x3;
        p2[3] = y3;

        p3[0] = x3;
        p3[1] = y3;
        p3[2] = x4;
        p3[3] = y4;


        p4[0] = x4;
        p4[1] = y4;
        p4[2] = x1;
        p4[3] = y1;

        pontoX = (x1 + x2) / 2;
        pontoY = (y1 + y3) / 2;

    }

    public void paint() {
        Graphics g = getGraphics();
        tempo(100);
        int largura = janela/2;
        int altura = janela/2;

        setPs();

        int newLargura =  (int) (largura - pontoX) ;
        int newAltura =(int) (largura + pontoY);

        for(int i = 0; i <= 360; i = i +5) {

            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 600, 600);
            //Reta Vertical
            g.setColor(new Color(0, 0, 0));
            g.drawLine(largura, 0, largura, 600);

            g.setColor(new Color(0, 0, 0));
            g.drawString("y", largura+1, 50);
            tempo(1);
            //Reta Horizontal
            g.setColor(new Color(0, 0, 0));
            g.drawLine(0, largura, 600, largura);

            g.setColor(new Color(0, 0, 0));
            g.drawString("x", 550, largura+1);

            g.setColor(new Color(255, 0, 40));
            g.drawLine(p1[0] + newLargura,newAltura - p1[1], p1[2] + newLargura,newAltura - p1[3]);
            g.drawLine(p2[0] + newLargura,newAltura - p2[1], p2[2] + newLargura,newAltura - p2[3]);
            g.drawLine(p3[0] + newLargura,newAltura - p3[1], p3[2] + newLargura,newAltura - p3[3]);
            g.drawLine(p4[0] + newLargura,newAltura - p4[1], p4[2] + newLargura,newAltura - p4[3]);

            double anguloRad = Math.toRadians(i);
            double centroX = pontoX *(1- Math.cos(anguloRad)) +  pontoY*Math.sin(anguloRad);
            double centroY = pontoY *(1- Math.cos(anguloRad)) -  pontoX*Math.sin(anguloRad);


            int p1R[] = calPontos(p1,anguloRad,centroX, centroY);
            int p2R[] = calPontos(p2,anguloRad,centroX, centroY);
            int p3R[] = calPontos(p3,anguloRad,centroX, centroY);
            int p4R[] = calPontos(p4,anguloRad,centroX, centroY);

            g.setColor(new Color(255, 0, 247));
            g.drawLine(p1R[0] + newLargura,newAltura - p1R[1], p1R[2] + newLargura,newAltura - p1R[3]);
            g.drawLine(p2R[0] + newLargura,newAltura - p2R[1], p2R[2] + newLargura,newAltura - p2R[3]);
            g.drawLine(p3R[0] + newLargura,newAltura - p3R[1], p3R[2] + newLargura,newAltura - p3R[3]);
            g.drawLine(p4R[0] + newLargura,newAltura - p4R[1], p4R[2] + newLargura,newAltura - p4R[3]);

            if (i == 360){
                i = 0;
            }
            tempo(33);

        }



    }


    public int[] calPontos(int[] p, double anguloRad, double pontoX, double pontoY) {

        int newP[] = new int[4];
        newP[0] = (int) ((Math.cos(anguloRad) * p[0] -Math.sin(anguloRad) * p[1]) + pontoX);
        newP[1] = (int) ((Math.sin(anguloRad) * p[0] +Math.cos(anguloRad) * p[1]) + pontoY);
        newP[2] = (int) ((Math.cos(anguloRad) * p[2] -Math.sin(anguloRad) * p[3]) + pontoX);
        newP[3] = (int) ((Math.sin(anguloRad) * p[2] +Math.cos(anguloRad) * p[3]) + pontoY);

        return newP;
    }




    public static void main(String[] args) {

        Rotacao r = new Rotacao();
        r.paint();

    }

}




