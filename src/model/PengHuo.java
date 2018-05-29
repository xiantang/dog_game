package model;

import thread.PaintThread;
import view.MyFrame;

import javax.swing.*;
import java.awt.*;

public class PengHuo {
    public Image[] images;
    public Image image_tuijian;
    public Image image_gong_9;
    public Image image_game_9;
    public static int penghuo_index=0;

//    设置喷火的坐标
    public static  int penghuo_x=687;
    public static  int penghuo_y=510;

    public PengHuo() {
        images=new Image[2];
        image_tuijian=new ImageIcon("imges/game_over_9regame.png").getImage();
        image_gong_9=new ImageIcon("imges/game_over_9gong.png").getImage();
        image_game_9=new ImageIcon("imges/game_over_9game.png").getImage();
        images[0]=Toolkit.getDefaultToolkit().getImage("imges/penghuo_up.png");
        images[1]=Toolkit.getDefaultToolkit().getImage("imges/最美瞬间.png");


    }
    public void drawself_PengHuo(Graphics g){
        if( penghuo_index==0)
        g.drawImage(images[penghuo_index],penghuo_x,penghuo_y,70,70,null);
        else{
            g.drawImage(images[penghuo_index],penghuo_x,penghuo_y,100,20,null);
        }
        if(MyFrame.aBoolean_tuijian==true&&PaintThread.jjjj==1){
            g.drawImage(image_tuijian,MyFrame.tuijian_x,MyFrame.tuijian_y+70,125,125,null
            );
        }
        if(MyFrame.aBoolean_gezi_9==true&&PaintThread.jjjj==1){
            g.drawImage(image_gong_9,MyFrame.gong_9_x-20,MyFrame.gong_9_y+70,125,125,null
            );
        }
        if(MyFrame.aBoolean_game_9==true&&PaintThread.jjjj==1){
            g.drawImage(image_game_9,MyFrame.game_9_x-10,MyFrame.game_9_y+70,125,125,null
            );
        }

    }
    public static Rectangle getRectangle(){
        Rectangle skyHook=new Rectangle(penghuo_x,penghuo_y,70,70);
        return skyHook;
    }
}
