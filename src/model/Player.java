package model;

import view.MyLable;

import javax.swing.*;
import java.awt.*;

public class Player {
    public  static int x;
    public  static int y;
    public  static int width=70;
    public  static int height=50;
    public  static int score=0;
//    Boolean aBoolean_player_death=false ;
//    public  static Image bg=new ImageIcon("src/imges/地图.png").getImage();
    public  Image [] image ;

    //一定要写对路径  而且要用image icon

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        image =new Image[5];
        image[0] =new ImageIcon("imges/dogx.png").getImage();
        image[1]=new ImageIcon("imges/dogy.png").getImage();
        image[2]=new ImageIcon("imges/dogjamp.png").getImage();
        image[3]=new ImageIcon("imges/dog_die.png").getImage();
        image[4]=new ImageIcon("imges/dogjamp_fan.png").getImage();


    }
    public  void  drawSelf(Graphics g){
            g.drawImage(image[MyLable.zhuanTou],x,y,width,height,null);
    }
    public void Judge() {
        if((Player.x>=120&&Player.x<=260)&&(Player.y>=456&&Player.y<=525)){
            System.out.println("角色死亡");
        }
    }


    public static boolean isCollsionWithRect(int x1, int y1, int w1, int h1,
                                      int x2,int y2, int w2, int h2) {
        if (x1 >= x2 && x1 >= x2 + w2) {
            return false;
        } else if (x1 <= x2 && x1 + w1 <= x2) {
            return false;
        } else if (y1 >= y2 && y1 >= y2 + h2) {
            return false;
        } else if (y1 <= y2 && y1 + h1 <= y2) {
            return false;
        }
        return true;
    }
    public static Rectangle getRectangle(){
        Rectangle playRect=new Rectangle(x,y,width-10,height-10);
        return playRect;
    }
    public static Rectangle getFoot(){
        Rectangle playRect=new Rectangle(x,y+58,width-10,height-10);
        return playRect;
    }

}
