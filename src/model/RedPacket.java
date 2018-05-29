package model;

import javax.swing.*;
import java.awt.*;

public class RedPacket extends Rectangle{
    public  boolean visible=true;
    public  Image image =new ImageIcon("imges/red.png").getImage();
//    public model.RedPacket(int x, int y, int width, int height) {

    public RedPacket(int x, int y, int width, int height) {
        super(x, y, width, height);

    }
    public  void  drawSelf(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    }
}
