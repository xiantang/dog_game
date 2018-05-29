package view;

import db.Sqlserver;
import model.*;
import thread.JampThread;
import thread.JampThread2;
import thread.PaintThread;
import thread.RightThread;
import 关卡.GuanQia2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Administrator on 2018/4/11.
 */
public class MyFrame extends JFrame{
    public static MyPanel panel;
    public static int width=1003;
    public static int count=0;
    public static int height=600;
    public  static JLabel jLabel;
    public  static int tuijian_x=568 ;
    public static  int tuijian_y=263;
    public  static int gong_9_x=347 ;
    public static  int gong_9_y=263;
    public  static int game_9_x=454 ;
    public static  int game_9_y=263;
    public static JLabel tuijian;
    public  static  boolean aBoolean_tuijian=false;
    public  static  boolean aBoolean_gezi_9=false;
    public  static  boolean aBoolean_game_9=false;
    private final Thread thread;
    public  String userName;
    public  rank rank=new rank();
    public  JLabel thelabel;
    public Thread thread1;
    public Thread thread2;
    public Thread thread1666;



    public MyFrame(String userName) throws HeadlessException {

    BoolDie.isDie=false;
        GameOver_9(tuijian,tuijian_x,tuijian_y);
        GameOver_9_gong(tuijian,gong_9_x,gong_9_y);
        GameOver_9_game(tuijian,game_9_x,game_9_y);
        this.userName=userName;

        jLabel =new JLabel("",JLabel.CENTER);
        jLabel.setForeground(new Color(254,67,101));
        jLabel.setFont(new Font("楷体",Font.BOLD,40));
        jLabel.setBounds(0,0,400,200);
        this.getLayeredPane().add(jLabel,new Integer(200));
        ((JPanel)this.getContentPane()).setOpaque(false);

        setTitle("小狗抢红包     ID: "+userName);
        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//计算电脑尺寸居中
        setBounds(point.x - width / 2, point.y - height / 2, width, height);//计算电脑尺寸居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        panel=new MyPanel(width,height,userName);
        thelabel=new JLabel();
        thelabel.setBounds(250,100,500,500);
        getLayeredPane().add(thelabel,new Integer(600));
        JLabel Chongxin = new JLabel();
        ImageIcon iconChongxin = new ImageIcon("imges/重开.png");
        iconChongxin.setImage(iconChongxin.getImage().getScaledInstance(69,69,Image.SCALE_DEFAULT));
        Chongxin.setIcon(iconChongxin);
        Chongxin.setSize(69,69);
        Chongxin.setLocation(635,3);
        Chongxin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MyLable.player.x=0;
                MyLable.player.y=480;
                MyLable.player2.x=100;
                MyLable.player2.y=480;
                PaintThread.kkkk=0;
                PaintThread.kkkk_play2=0;
                MyLable.gameOver.gameover_x=1003;
                MyLable.gameOver.gameover_y=100;
                MyLable.zhuanTou=0;
                MyLable.zhuanTou2=0;
                PaintThread.jjjj=0;
                MyLable.player.score=0;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MyLable.player.x=0;
                MyLable.player.y=480;
                MyLable.player2.x=100;
                MyLable.player2.y=480;
                PaintThread.kkkk=0;
                PaintThread.kkkk_play2=0;
                MyLable.gameOver.gameover_x=1003;
                MyLable.gameOver.gameover_y=100;
                MyLable.zhuanTou=0;
                MyLable.zhuanTou2=0;
                PaintThread.jjjj=0;
                MyLable.player.score=0;
                clock.minutes.setValue(0);
                clock.seconds.setValue(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Chongxin.setSize(75,75);
                iconChongxin.setImage(iconChongxin.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT));
                Chongxin.setLocation(632,0);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Chongxin.setSize(69,69);
                iconChongxin.setImage(iconChongxin.getImage().getScaledInstance(69,69,Image.SCALE_DEFAULT));
                Chongxin.setLocation(635,3);
                setCursor(Cursor.getDefaultCursor());//鼠标原始
            }
        });

        JLabel ChangeGuanqia = new JLabel();
        ImageIcon iconChangeGuanqia = new ImageIcon("imges/关卡选择.png");
        iconChangeGuanqia.setImage(iconChangeGuanqia.getImage().getScaledInstance(68,69,Image.SCALE_DEFAULT));
        ChangeGuanqia.setIcon(iconChangeGuanqia);
        ChangeGuanqia.setSize(68,69);
        ChangeGuanqia.setLocation(717,3);
        ChangeGuanqia.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                MyLable.player.x=0;
                MyLable.player.y=480;
                MyLable.player2.x=100;
                MyLable.player2.y=480;
                PaintThread.kkkk=0;
                PaintThread.kkkk_play2=0;
                MyLable.gameOver.gameover_x=1003;
                MyLable.gameOver.gameover_y=100;
                MyLable.zhuanTou=0;
                MyLable.zhuanTou2=0;
                PaintThread.jjjj=0;
                MyLable.player.score=0;
                Player2.score=0;
                clock.minutes.setValue(0);
                clock.seconds.setValue(0);
                thread1.stop();
                thread.stop();
                thread2.stop();
                thread1666.stop();
                MyLable.thread.stop();
                new GuanQia2(userName);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ChangeGuanqia.setSize(75,75);
                iconChangeGuanqia.setImage(iconChangeGuanqia.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT));
                ChangeGuanqia.setLocation(714,0);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ChangeGuanqia.setSize(68,69);
                iconChangeGuanqia.setImage(iconChangeGuanqia.getImage().getScaledInstance(68,69,Image.SCALE_DEFAULT));
                ChangeGuanqia.setLocation(717,3);
                setCursor(Cursor.getDefaultCursor());//鼠标原始
            }
        });

        JLabel Shengyin = new JLabel();
        ImageIcon iconShengyin = new ImageIcon("imges/声音开.png");
        iconShengyin.setImage(iconShengyin.getImage().getScaledInstance(68,68,Image.SCALE_DEFAULT));
        Shengyin.setIcon(iconShengyin);
        Shengyin.setSize(68,68);
        Shengyin.setLocation(798,3);

        Shengyin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                count+=1;
                if(count%2!=0){
                    ImageIcon iconShengyin = new ImageIcon("imges/声音关.png");
                    iconShengyin.setImage(iconShengyin.getImage().getScaledInstance(68,68,Image.SCALE_DEFAULT));
                    Shengyin.setIcon(iconShengyin);
                    Shengyin.setSize(68,68);
                    Shengyin.setLocation(798,3);
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
//                    bulletMusicThread.exit = true;
//                    bulletMusicThread.stop();
//                    if(bulletMusicThread.exit = true){
//                        System.out.println("线程中断");
//                    }


                }else{
                    ImageIcon iconShengyin = new ImageIcon("imges/声音开.png");
                    iconShengyin.setImage(iconShengyin.getImage().getScaledInstance(68,68,Image.SCALE_DEFAULT));
                    Shengyin.setIcon(iconShengyin);
                    Shengyin.setSize(68,68);
                    Shengyin.setLocation(798,3);
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
//                    bulletMusicThread.exit = false;
//                    new BulletMusicThread("src/首页/music/中国国家交响乐团 - 春节序曲.wav").start();
//                    System.out.println("线程开启");
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
//                Shengyin.setSize(75,75);
//                iconShengyin.setImage(iconShengyin.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT));
//                Shengyin.setLocation(795,0);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                Shengyin.setSize(68,68);
//                iconShengyin.setImage(iconShengyin.getImage().getScaledInstance(68,69,Image.SCALE_DEFAULT));
//                Shengyin.setLocation(798,3);
                setCursor(Cursor.getDefaultCursor());//鼠标原始
            }
        });

        JLabel YouxiShuju = new JLabel();
        ImageIcon iconYouxiShuju = new ImageIcon("imges/数据.png");
        iconYouxiShuju.setImage(iconYouxiShuju.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
        YouxiShuju.setIcon(iconYouxiShuju);
        YouxiShuju.setSize(70,70);
        YouxiShuju.setLocation(880,3);
        YouxiShuju.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                YouxiShuju.setSize(75,75);
                iconYouxiShuju.setImage(iconYouxiShuju.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT));
                YouxiShuju.setLocation(877,0);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标变成手形状
            }

            @Override
            public void mouseExited(MouseEvent e) {
                YouxiShuju.setSize(70,70);
                iconYouxiShuju.setImage(iconYouxiShuju.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
                YouxiShuju.setLocation(880,3);
                setCursor(Cursor.getDefaultCursor());//鼠标原始
            }
        });

        this.getLayeredPane().add(YouxiShuju,new Integer(800));
        this.getLayeredPane().add(Shengyin,new Integer(500));
        this.getLayeredPane().add(ChangeGuanqia,new Integer(500));
        this.getLayeredPane().add(Chongxin,new Integer(500));

//        this.add(panel);
        this.getLayeredPane().add(panel,new Integer(100));
        this.setVisible(true);

        panel.requestFocus();

//        如果人物死了



        JampThread jampThread = new JampThread();
        this.thread = new Thread(jampThread);
        thread.start();


        JampThread2 jampThread2 = new JampThread2();
        thread2 = new Thread(jampThread2);
        thread2.start();

        RightThread rightThread = new RightThread();
        this.thread1 =new Thread(rightThread);
        thread1.start();
        clock c=new clock();
//        c.main.start();
         thread1666 =new Thread(c);
        thread1666.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  requestFocus 一定要放在setVisible后面
    }

//    9999999 regame
    public void GameOver_9(JLabel jLabel,int x,int y){
        jLabel=new JLabel();
        ImageIcon icontuijian = new ImageIcon("src/登录界面/image/开始的副本.png");
        icontuijian.setImage(icontuijian.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
        jLabel.setIcon(icontuijian);
        jLabel.setLocation(x,y);
        jLabel.setSize(125,125);
        this.getLayeredPane().add(jLabel,new Integer(50));

        JLabel finalJLabel = jLabel;
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                MyLable.player.x=0;
                MyLable.player.y=480;
                MyLable.player2.x=100;
                MyLable.player2.y=480;
                PaintThread.kkkk=0;
                PaintThread.kkkk_play2=0;
                MyLable.gameOver.gameover_x=1003;
                MyLable.gameOver.gameover_y=100;
                MyLable.zhuanTou=0;
                MyLable.zhuanTou2=0;
                PaintThread.jjjj=0;
                MyLable.player.score=0;
                MyLable.player2.score=0;
                clock.minutes.setValue(0);
                clock.seconds.setValue(0);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aBoolean_tuijian=true;
                finalJLabel.setSize(150,150);
                if(PaintThread.jjjj==1){setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
                //鼠标变成手形状

            }

            @Override
            public void mouseExited(MouseEvent e) {
                aBoolean_tuijian=false;

            }
        });

    }
    public void GameOver_9_gong(JLabel jLabel,int x,int y){
        jLabel=new JLabel();
        ImageIcon icontuijian = new ImageIcon("src/登录界面/image/开始的副本.png");
        icontuijian.setImage(icontuijian.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
        jLabel.setIcon(icontuijian);
        jLabel.setLocation(x,y);
        jLabel.setSize(125,125);
        this.getLayeredPane().add(jLabel,new Integer(50));

        JLabel finalJLabel = jLabel;
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                dispose();
                MyLable.player.x=0;
                MyLable.player.y=480;
                MyLable.player2.x=100;
                MyLable.player2.y=480;
                PaintThread.kkkk=0;
                PaintThread.kkkk_play2=0;
                MyLable.gameOver.gameover_x=1003;
                MyLable.gameOver.gameover_y=100;
                MyLable.win.win_x=1003;
                MyLable.win.win_y=100;
                MyLable.zhuanTou=0;
                MyLable.zhuanTou2=0;
                PaintThread.jjjj=0;
                MyLable.player.score=0;

                Player2.score=0;
                clock.minutes.setValue(0);
                clock.seconds.setValue(0);
                thread1.stop();
                thread.stop();
                thread2.stop();
                thread1666.stop();
                MyLable.thread.stop();
                new GuanQia2(userName);




            }


            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aBoolean_gezi_9=true;
                finalJLabel.setSize(150,150);
                if(PaintThread.jjjj==1){setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
                //鼠标变成手形状

            }

            @Override
            public void mouseExited(MouseEvent e) {
                aBoolean_gezi_9=false;

            }
        });

    }

    public void GameOver_9_game(JLabel jLabel,int x,int y){
        jLabel=new JLabel();
        ImageIcon icontuijian = new ImageIcon("src/登录界面/image/开始的副本.png");
        icontuijian.setImage(icontuijian.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
        jLabel.setIcon(icontuijian);
        jLabel.setLocation(x,y);
        jLabel.setSize(125,125);
        this.getLayeredPane().add(jLabel,new Integer(50));

        JLabel finalJLabel = jLabel;
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }


            @Override
            public void mousePressed(MouseEvent e) {
                rank.setBounds(100,100,500,500);

                rank.repaint();
                getLayeredPane().add(rank,new Integer(400));
                rank.setVisible(true);
                Sqlserver sqlserver=new Sqlserver();
                ResultSet resultSet=sqlserver.TopTen();
//                List<String> list = new LinkedList<String>();
                String[] name = new String[10];
                String[] time = new String[10];
                String[] score = new String[10];
                int i=0;

                try {
                    while (resultSet.next()){

                        name[i]=resultSet.getString(1);
                        time[i]=resultSet.getString(2);
                        score[i]=resultSet.getString(3);
                        i++;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                String   strMsg = "<html><body><table>\n" +
                        "    <tr>\n" +
                        "        <td>"+name[0]+"</td>\n" +
                        "        <td>" +time[0]+"</td>\n" +
                        "        <td>"+score[0]+"</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td>"+name[1]+"</td>\n" +
                        "        <td>" +time[1]+"</td>\n" +
                        "        <td>"+score[1]+"</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td>"+name[2]+"</td>\n" +
                        "        <td>" +time[2]+"</td>\n" +
                        "        <td>"+score[2]+"</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td>"+name[3]+"</td>\n" +
                        "        <td>" +time[3]+"</td>\n" +
                        "        <td>"+score[3]+"</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td>"+name[4]+"</td>\n" +
                        "        <td>" +time[4]+"</td>\n" +
                        "        <td>"+score[4]+"</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td>"+name[5]+"</td>\n" +
                        "        <td>" +time[5]+"</td>\n" +
                        "        <td>"+score[5]+"</td>\n" +
                        "    </tr>\n" +

                        "\n" +
                        "</table><body></html>";

                thelabel.setText(strMsg);

                Font font = new  Font("宋体",Font.BOLD, 25);
                thelabel.setFont(font);
                thelabel.setForeground(Color.WHITE);
                thelabel.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rank.setVisible(false);
                thelabel.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aBoolean_game_9=true;
                finalJLabel.setSize(150,150);
                if(PaintThread.jjjj==1){setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
                //鼠标变成手形状

            }

            @Override
            public void mouseExited(MouseEvent e) {
                aBoolean_game_9=false;

            }
        });

    }

}
