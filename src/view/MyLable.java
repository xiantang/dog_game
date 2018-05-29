package view;

import model.*;
import thread.BulletMusicThread;
import thread.PaintThread;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2018/4/11.
 */
public class MyLable extends JLabel {
    public int width;
    public int height;
    public static Player player;
    public static Player2 player2;
    public FeiTan feiTan;
    public static int zhuanTou=0;
    public static int zhuanTou2=0;
    public RedPacket redPacket1,redPacket2,redPacket3,redPacket5,redPacket4;
    PengHuo pengHuo;
    public static Grades grades;
    public  static GameOver gameOver;
    public  static Win win;
    public static PaintThread thread;
    public static int ditu_index;
    public  static Image bg;
    public String  username;
    public MyLable(int width, int height, String username) {
        bg=new ImageIcon("imges/地图"+ditu_index+".png").getImage();
        this.width = width;
        this.height = height;
        this.username=username;
        player= new Player(0,480);
        player2= new Player2(100,480);
        feiTan=new FeiTan();
        gameOver =new GameOver();
        win =new Win();
        pengHuo=new PengHuo();
        this.grades =new Grades();
        thread =new PaintThread(this,username);
        thread.start();
        Gravity gravity=new Gravity(player);
        gravity.start();
        Gravity2 gravity2=new Gravity2(player2);
        gravity2.start();
        redPacket1 = new RedPacket(330, 480, 26, 31);
        redPacket2 = new RedPacket(540, 480, 26, 31);
        redPacket3 = new RedPacket(695, 460, 26, 31);
        redPacket4 = new RedPacket(243, 251, 26, 31);
        redPacket5 = new RedPacket(445, 251, 26, 31);
//        new thread.BulletMusicThread("imges/02-春风一顾.wav").main.start();


    }

    public void reset() {
        redPacket1 = new RedPacket(330, 480, 26, 31);
        redPacket2 = new RedPacket(540, 480, 26, 31);
        redPacket3 = new RedPacket(695, 460, 26, 31);
        redPacket4 = new RedPacket(243, 251, 26, 31);
        redPacket5 = new RedPacket(445, 251, 26, 31);
    }


    @Override
    public void paint(Graphics g) {

        g.drawImage(bg,0,0,width,height-40,null); //画出背景

        player.drawSelf(g);
        player2.drawSelf(g);
        feiTan.drawself_feiTan(g);
        gameOver.drawself_gameover(g);
        win.drawself_gameover(g);

        if (Player.score == 0&&Player2.score==0) {
            reset();
        }
        if (Player.getRectangle().intersects(redPacket1)) {
            redPacket1.x = 10000; //吃了红包之后直接把红包移到外面
            Player.score += 1000;
//            System.out.println(player.score);
        } else if (Player.getRectangle().intersects(redPacket2)) {
            redPacket2.x = 10000;
            Player.score += 1000;
//            System.out.println(player.score);
        } else if (Player.getRectangle().intersects(redPacket3)) {
            redPacket3.x = 10000;
            Player.score += 1000;

//            System.out.println(player.score);
        }else if (Player.getRectangle().intersects(redPacket3)) {
            redPacket3.x = 10000;
            Player.score += 1000;
//            System.out.println(player.score);
        } else if (Player.getRectangle().intersects(redPacket4)) {
            redPacket4.x = 10000;
            Player.score += 1000;

//            System.out.println(player.score);
        }else if (Player.getRectangle().intersects(redPacket5)) {
            redPacket5.x = 10000;
            Player.score += 1000;

//            System.out.println(player.score);
        }
        else if (Player2.getRectangle().intersects(redPacket1)) {
            redPacket1.x = 10000; //吃了红包之后直接把红包移到外面
            Player2.score += 1000;


        } else if (Player2.getRectangle().intersects(redPacket2)) {
            redPacket2.x = 10000;
            Player2.score += 1000;
//            System.out.println(player.score);
        } else if (Player2.getRectangle().intersects(redPacket3)) {
            redPacket3.x = 10000;
            Player2.score += 1000;

//            System.out.println(player.score);
        }else if (Player2.getRectangle().intersects(redPacket3)) {
            redPacket3.x = 10000;
            Player2.score += 1000;
//            System.out.println(player.score);
        } else if (Player2.getRectangle().intersects(redPacket4)) {
            redPacket4.x = 10000;
            Player2.score += 1000;

//            System.out.println(player.score);
        }else if (Player2.getRectangle().intersects(redPacket5)) {
            redPacket5.x = 10000;
            Player2.score += 1000;

//            System.out.println(player.score);
        }
//        System.out.println(model.Player.score);
        grades.drawSelf(g,Player.score,530,25);
        grades.drawSelf(g,Player2.score,237,25);
        if (PaintThread.jjjj==1){
            grades.drawSelf(g,Player2.score,413,251);
            grades.drawSelf(g,Player.score,587,251);
        }
        //同级的if
       redPacket1.drawSelf(g);
        redPacket2.drawSelf(g);
        redPacket3.drawSelf(g); redPacket4.drawSelf(g);
        redPacket5.drawSelf(g);
        pengHuo.drawself_PengHuo(g);

}



}
