package model;

import javax.swing.*;
import java.awt.*;


//飞毯和子弹的类
public class FeiTan {
//    i用来设置状态 判断让毯子和子弹的逻辑真确
public static int i = 0;
//j是子弹的开关
    public static int j=0;
//喷火的来回走动的开关  就是定义了一个逻辑值  可以实现来回走动的逻辑
    public static int penghuo_states=0;

//    飞毯的坐标
    public static int x = 600;
    public static int y = 370;


    public static int n=0;
//    基本数组存放图片
    public static Image [] images;
    public static Image image_zidan ;
    public static int m;
//    子弹的横坐标
    private static int  k=255;
//    子弹的纵坐标；

//    子弹的长宽
    private double widthzidan = 16;
    private double heightzidan = 17;

    public FeiTan() {
        images=new Image[2];
//        实现毯子摆动的两张图
        images[1]=Toolkit.getDefaultToolkit().getImage("imges/fanmian.png");
        images[0]=Toolkit.getDefaultToolkit().getImage("imges/zhenmian.png");
//        子弹
        image_zidan = new ImageIcon("imges/ball.png").getImage();
    }

    public void drawself_feiTan(Graphics g) {

//        画毯子
        g.drawImage(images[n], x, y, 130, 40, null);
//        画子弹
        g.drawImage(image_zidan,m,k,(int)widthzidan,(int)heightzidan,null);




    }
//返回矩形
    public static Rectangle getRectangle(){
        Rectangle skyHook=new Rectangle(x,y,130,40);
        return skyHook;
    }
    public static Rectangle getRectangle_zidan(){
        Rectangle skyHook=new Rectangle(m,k,16,17);
        return skyHook;
    }
}
