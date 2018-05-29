package model;

import javax.swing.*;
import java.awt.*;

//+++++++++++++++++++++++++++++++++++++++++++++++++
//       这个类在  paintThrad中实现的
//++++++++++++++++++++++++++++++++++++++++++++++++++++++
public class GameOver {
//    游戏借宿的那张图的基础位置  把图片放在jframe外面
    public static  int gameover_x=1003;
    public static  int gameover_y=100;

    public static Image image_gameover;

//    游戏结束的从右往左的那张图
    public GameOver() {
        image_gameover= new ImageIcon("imges/lose.png").getImage();
    }


    public void drawself_gameover (Graphics g) {

        g.drawImage(image_gameover,gameover_x,gameover_y,406,364,null);

    }
}
