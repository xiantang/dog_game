package model;

import view.MyLable;

import javax.swing.*;
import java.awt.*;

public class Player2 {
    public  static int x;
    public  static int y;
    public  static int width=70;
    public  static int height=50;
    public  static int score=0;
    //    Boolean aBoolean_player_death=false ;
//    public  static Image bg=new ImageIcon("src/imges/地图.png").getImage();
    public  Image[] image ;

    //一定要写对路径  而且要用image icon

    public Player2(int x, int y) {
        this.x = x;
        this.y = y;
        image =new Image[7];
        image[0] =new ImageIcon("Player2/dogstand.png").getImage();
        image[1]=new ImageIcon("Player2/dogstandleft.png").getImage();
        image[2]=new ImageIcon("Player2/yellodog.png").getImage();
        image[3]=new ImageIcon("imges/黄狗死亡.png").getImage();
        image[4]=new ImageIcon("Player2/yelloleft.png").getImage();
        image[5]=new ImageIcon("Player2/dogleft.png").getImage();
        image[6]=new ImageIcon("Player2/dogrihght.png").getImage();


    }
    public  void  drawSelf(Graphics g){
        g.drawImage(image[MyLable.zhuanTou2 ],x,y,width,height,null);


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
