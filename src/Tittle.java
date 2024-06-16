// Начало игры, заголовок, отсылка к заставке по изображению

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Tittle extends JPanel implements KeyListener {
//Объекты серийность с теми же парраметрами в окне игры + задаем частоту обновления при объекте Timer
    private static final long serialVersionUID = 1L;
    private BufferedImage instructions;
    private WindowGame window;
    private BufferedImage[] playButton = new BufferedImage[2];
    private Timer timer;

//Частота обновления событий
    public Tittle(WindowGame window){
        instructions = ImageLoader.loadImage("/arrow.png");
        timer = new Timer(1000/60, new ActionListener(){
//
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

        });
        timer.start();
        this.window = window;

    }
//Перерисовка компонента фон
    public void paintComponent(Graphics g){
        super.paintComponent(g);
//Установили цвет
        g.setColor(Color.BLACK);
//Прямоугольник
        g.fillRect(0, 0, WindowGame.WIDTH, WindowGame.HEIGHT);


        g.drawImage(instructions, WindowGame.WIDTH/2 - instructions.getWidth()/2,
                30 - instructions.getHeight()/2 + 150, null);

        g.setColor(Color.WHITE);
        g.drawString("Press space to play!", 150, WindowGame.HEIGHT / 2 + 100);


    }
//Пробел отвечает возврат в начало
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_SPACE) {
            window.startTetris();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
