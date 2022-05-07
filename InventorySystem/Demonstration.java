package InventorySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.*;

    public class Demonstration extends JPanel{

        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(new Color(255, 255, 255));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new Rectangle2D.Double(430, 30, 340, 220));

            g2.setStroke(new BasicStroke(3f));
            g2.setColor(new Color(255, 150, 0));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.draw(new Rectangle2D.Double(30, 30, 340, 220));

            Font font = new Font("Serif", Font.BOLD, 25);
            g2.setFont(font);
            g2.setColor(new Color(220, 255, 255));
            g2.drawString("Brand:", 50, 60);
            g2.drawString("Type:", 50, 100);
            g2.drawString("Name:", 50, 140);
            g2.drawString("ID:", 50, 180);
        }

    /*
       public static void main(String[] args) {
         //  JPanel demo = new Demonstration();
         //  demo.repaint();
           SwingUtilities.invokeLater(Demonstration::init);
           //new Demonstration();
       }
       */
    }
