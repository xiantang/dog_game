package 关卡;

import view.MyLable;
import 登录界面.JinduTiao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuanQia extends JFrame{
    public static int fwhite = 1003;//宽度
    public static int fheight = 600;//高度

    public  GuanQia(String a){

        JLabel bg=new JLabel();
        Icon iconbg=new ImageIcon("src/关卡/image/关卡new.png");     //在此直接创建对象
        bg.setIcon(iconbg);
        bg.setBounds(0, 0, 1003,585);

        JLabel First = new JLabel();
        ImageIcon iconFirst = new ImageIcon("src/关卡/image/第一关标志.png");
        iconFirst.setImage(iconFirst.getImage().getScaledInstance(110,109,Image.SCALE_DEFAULT));
        First.setIcon(iconFirst);
        First.setSize(110,109);
        First.setLocation(13,26);

        First.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new JinduTiao(a);
                MyLable.ditu_index=1;
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());//鼠标原始
            }
        });

        JLabel None = new JLabel();
        ImageIcon iconNone = new ImageIcon("src/关卡/image/没有开启关卡.png");
        iconNone.setImage(iconNone.getImage().getScaledInstance(110,109,Image.SCALE_DEFAULT));
        None.setIcon(iconNone);
        None.setSize(110,109);
        None.setLocation(192,29);





        add(None);
        add(First);
        add(bg);
        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//计算电脑尺寸居中
        setBounds(point.x - fwhite / 2, point.y - fheight / 2, fwhite, fheight);//计算电脑尺寸居中
        setTitle("小狗抢红包     ID: "+a);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
