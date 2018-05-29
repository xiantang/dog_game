package 登录界面;


import view.MyFrame;
import view.MyLable;

import javax.swing.*;
import java.awt.*;

public class JinduTiao extends JFrame{
    public JProgressBar jProgressBar;
    public static int fwhite = 1003;//宽度
    public static int fheight = 600;//高度
    Thread JDThread;
    public JinduTiao(String a){
        super(a);
        jProgressBar = new JProgressBar();
        jProgressBar.setBounds(250,300,500,100);
        jProgressBar.setStringPainted(true);
//        setPreferredSize(new Dimension(500,100));
        JDThread = new Thread(new Runnable() {
            int countJDT=0;
            public boolean aBoolean = false;
            @Override
            public void run() {
                while (!aBoolean){
                    jProgressBar.setValue(++countJDT);
                    try {
                        JDThread.sleep(1);
                        if(countJDT==50){
                            JDThread.sleep(1);
                        }else if (countJDT==98) {
                            JDThread.sleep(1000);
                        }else if (countJDT==99){
                            dispose();
                            new MyFrame(a);//跳第一关
                            JDThread.stop();


//                            aBoolean = true;
//                            new Denglu();
//                            dispose();
//                            break;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        JDThread.start();

        JLabel Tiaoli1 = new JLabel("抵制不良游戏，拒绝盗版游戏。");
        Tiaoli1.setFont(new Font("微软雅黑",Font.BOLD,45));
        Tiaoli1.setBounds(200,0,800,100);

        JLabel Tiaoli2 = new JLabel("注意自我保护，谨防受骗上当。");
        Tiaoli2.setFont(new Font("微软雅黑",Font.BOLD,45));
        Tiaoli2.setBounds(200,55,800,100);

        JLabel Tiaoli3 = new JLabel("适度游戏益脑，沉迷游戏伤身。");
        Tiaoli3.setFont(new Font("微软雅黑",Font.BOLD,45));
        Tiaoli3.setBounds(200,110,800,100);

        JLabel Tiaoli4 = new JLabel("合理安排时间，享受健康生活。");
        Tiaoli4.setFont(new Font("微软雅黑",Font.BOLD,45));
        Tiaoli4.setBounds(200,165,800,100);

        

        add(Tiaoli4);
        add(Tiaoli3);
        add(Tiaoli2);
        add(Tiaoli1);

        add(jProgressBar);

        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//计算电脑尺寸居中
        setBounds(point.x - fwhite / 2, point.y - fheight / 2, fwhite, fheight);//计算电脑尺寸居中
        setTitle("小狗抢红包     ID: "+a);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}