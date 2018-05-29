package model;

import javax.swing.*;
import java.awt.*;

//+++++++++++++++++++++++++++++++++++++++++++++++++
//       这个类在  paintThrad中实现的
//++++++++++++++++++++++++++++++++++++++++++++++++++++++
public class Win {
    //    游戏借宿的那张图的基础位置  把图片放在jframe外面
    public static  int win_x=1003;
    public static  int win_y=100;

    public static Image image_win;

    //    游戏结束的从右往左的那张图
    public Win() {
        image_win= new ImageIcon("imges/成功.png").getImage();
    }


    public void drawself_gameover (Graphics g) {

        g.drawImage(image_win,win_x,win_y,406,346,null);

    }
}
