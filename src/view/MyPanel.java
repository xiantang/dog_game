package view;

import thread.PaintThread;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Administrator on 2018/4/11.
 */
public class MyPanel extends JPanel  implements KeyListener{
    public int PanelWidth;
    public  int PanelHeight;
    public  static int Tou_fangxiang=0;
    public  static JLabel label;
    public static Boolean aBoolean_right=false;
    public  static Boolean aBoolean_jump=false;
    public  static Boolean getaBoolean_left=false;
    public static Boolean aBoolean_right_play2=false;
    public  static Boolean aBoolean_jump_play2=false;
    public  static Boolean getaBoolean_left_play2=false;
    public String username;


    public MyPanel(int panelWidth, int panelHeight,String username) {
        setLayout(null);
        this.PanelWidth = panelWidth;
        this.PanelHeight = panelHeight;
        this.username=username;
        setBounds(0,0 ,PanelWidth,PanelHeight);
        label=new MyLable(PanelWidth,PanelHeight,username);

        label.setBounds(0,0,PanelWidth,PanelHeight);
        this.addKeyListener(this);

        add(label);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        play1的狗
        if (e.getKeyCode()==KeyEvent.VK_UP) {
            if(PaintThread.kkkk==0)
                aBoolean_jump=true;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(PaintThread.kkkk==0)
            aBoolean_right=true;
            }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            if(PaintThread.kkkk==0)
            getaBoolean_left=true;
        }
//        play2的狗
        if (e.getKeyCode()==KeyEvent.VK_W) {
            if(PaintThread.kkkk_play2==0)
                aBoolean_jump_play2=true;

        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            if(PaintThread.kkkk_play2==0){
                aBoolean_right_play2=true;
                Tou_fangxiang=1;
            }

        }
        if (e.getKeyCode()==KeyEvent.VK_A){

            if(PaintThread.kkkk_play2==0)
                getaBoolean_left_play2=true;
                Tou_fangxiang=2;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){aBoolean_right=false;PaintThread.run=0; }
        if (e.getKeyCode()==KeyEvent.VK_D){aBoolean_right_play2=false;PaintThread.run=0;
            System.out.println("1");}
        if (e.getKeyCode()==KeyEvent.VK_LEFT) {getaBoolean_left=false;PaintThread.run=0;}
        if (e.getKeyCode()==KeyEvent.VK_A) {getaBoolean_left_play2=false;PaintThread.run=0;}
    }

}
