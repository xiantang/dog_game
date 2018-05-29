package 登录界面;

import db.Sqlserver;
import 首页.First;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

public class Denglu extends JFrame{
    public static int fwhite = 1003;//宽度
    public static int fheight = 600;//高度
    public JLabel id;
    private static final String a = "请输入用户名";
    public TextField beitai;



    public Denglu(){


        JLabel bg=new JLabel();
        Icon iconbg=new ImageIcon("src/登录界面/image/首页的副本.png");     //在此直接创建对象
        bg.setIcon(iconbg);
        bg.setBounds(0, 0, 1003,600);
        id = new JLabel("用户名：");
        id.setFont(new Font("微软雅黑",Font.BOLD,60));
        id.setBounds(180,258,240,150);


        final JTextField sr = new JTextField(a);
        sr.setFont(new Font("微软雅黑",Font.BOLD,64));
        sr.setBounds(400,268,400,130);
        sr.setForeground(Color.gray);

        sr.setPreferredSize(new Dimension(150, 28));
        sr.setBorder(new MyTextFieldBorder());
        sr.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(sr.getText().equals(a)){
                    sr.setText("");
                    sr.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (sr.getText().equals("")){
                    sr.setText(a);
                    sr.setForeground(Color.gray);
                }
            }
        });

        beitai = new TextField(null,16);
        beitai.setFont(new Font("微软雅黑",Font.BOLD,64));
        beitai.setBounds(400,0,400,130);
        beitai.setForeground(Color.gray);


        JLabel tuijian = new JLabel();
        ImageIcon icontuijian = new ImageIcon("src/登录界面/image/开始的副本.png");
        icontuijian.setImage(icontuijian.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
        tuijian.setIcon(icontuijian);
        tuijian.setSize(125,125);
        tuijian.setLocation(427,424);
        tuijian.requestFocus();


//        ImageIcon icontuijian = new ImageIcon("src/登录界面/image/开始的副本.png");
//        icontuijian.setImage(icontuijian.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
//        tuijian.setIcon(icontuijian);
//        tuijian.setSize(125,125);
//        tuijian.setLocation(427,424);



//        tuijian.setBorder(BorderFactory.createTitledBorder("你好")); 边框线条可以添加文字

        tuijian.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String s = sr.getText();
                Sqlserver sqlserver=new Sqlserver();
                if(!s.equals("")&&!s.equals("请输入用户名")){
                    try {
                        new First(sr.getText());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    dispose();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                tuijian.setSize(150,150);
                icontuijian.setImage(icontuijian.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
                tuijian.setLocation(415,410);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tuijian.setSize(125,125);
                icontuijian.setImage(icontuijian.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
                tuijian.setLocation(427,424);
                setCursor(Cursor.getDefaultCursor());//鼠标原始
            }
        });



        add(tuijian);
        add(sr);
        add(id);
        add(bg);
        add(beitai);

        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//计算电脑尺寸居中
        setBounds(point.x - fwhite / 2, point.y - fheight / 2, fwhite, fheight);//计算电脑尺寸居中
        setTitle("小狗抢红包");
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
