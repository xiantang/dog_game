package thread;

import db.Sqlserver;
import model.PengHuo;
import model.*;
import view.MyLable;

import javax.swing.*;
import java.awt.*;

public class PaintThread extends Thread{
    public JLabel label;
    public static   int timer = 0;
    public  static int kkkk=0;
    public  static int kkkk_play2=0;
    public  static int jjjj=0;
    public  static int run=0;
    public  boolean insertToDb=true;
    public  String  username;
    public PaintThread(JLabel label, String username) {
        this.label = label;
        this.username=username;
    }




    @Override
    public void run() {
        Sqlserver sqlserver =new Sqlserver();

        while (true) {
            if(BoolDie.isDie)
            {
                break;
            }

            boolean die_judge_1dici =Player.isCollsionWithRect(Player.x,Player.y,70,50,220,512,10,2);
            boolean die_judge_2dici =Player.isCollsionWithRect(Player.x,Player.y,70,50,408 ,512,10,2);
            boolean die_judge_zidan=Player.getRectangle().intersects(FeiTan.getRectangle_zidan());
            boolean die_judge_1dici_play2 =Player2.isCollsionWithRect(Player2.x,Player2.y,70,50,220,512,10,2);
            boolean die_judge_2dici_play2 =Player2.isCollsionWithRect(Player2.x,Player2.y,70,50,408,512,10,2);
            boolean die_judge_zidan_play2=Player2.getRectangle().intersects(FeiTan.getRectangle_zidan());
            boolean die_judge_zidan_low_play2=Player2.getRectangle().intersects(PengHuo.getRectangle());
            boolean die_judge_zidan_low=Player.getRectangle().intersects(PengHuo.getRectangle());

//            System.out.println(1);
            run++;
            if(run==10000){
                run=0;
            }
            timer++;
            if(timer==10000){
                timer=0;
            }
//——---------------————改变毯子的翻动的切换
            if (timer % 50 == 0) {

                FeiTan.n++;
                if(FeiTan.n>=FeiTan.images.length){
                    FeiTan.n=0;
                }
            }

            if (FeiTan.i == 0) {
                if (FeiTan.x < 820) {//移动位置
                    {
                        FeiTan.x++;
                        if (Player.getRectangle().intersects(FeiTan.getRectangle())){
                            Player.x++;
                        }
                    }
                } else {
                    FeiTan.i = 1;
                }
            }
            if (FeiTan.i == 1) {
                if (FeiTan.x > 600)//移动位置{
                { FeiTan.x--;
                    if (Player.getRectangle().intersects(FeiTan.getRectangle())){
                        Player.x--;
                    }
                }

                else
                    FeiTan.i = 0;
            }

//    ---------------------------------子弹的设置

            if(FeiTan.j==0){
                if(FeiTan.m<=1003){//移出屏幕前一直运动
                    FeiTan.m++;
                }
                else{
                    FeiTan.j=1;
                }
            }
            if(FeiTan.j==1){ //当x==1003 x重置
                FeiTan.m=0;
                FeiTan.j=0;
            }

//-----------------------喷火的的位置和速度设置
            if (FeiTan.penghuo_states== 0) {
                if (PengHuo.penghuo_y>=200) {//移动位置
                    PengHuo.penghuo_y--;
                } else {
                    FeiTan.penghuo_states= 1;
                }
            }
            if (FeiTan.penghuo_states== 1) {
                if (PengHuo.penghuo_y <510)//移动位置
                    PengHuo.penghuo_y++;
                else
                    FeiTan.penghuo_states= 0;
            }
            if(PengHuo.penghuo_y>=200&PengHuo.penghuo_y<=250){
                PengHuo.penghuo_index=1;
            }
            else {
                PengHuo.penghuo_index=0;
            }




//角色1死亡  gameover跳出
//            1号地刺
            //角色1死亡
            if(die_judge_1dici||die_judge_2dici||die_judge_zidan||die_judge_zidan_low){
                kkkk=1;
                MyLable.zhuanTou=3;
//                view.MyLable.player.x=1000;


            }
//            //角色2死亡
            if(die_judge_1dici_play2||die_judge_2dici_play2||die_judge_zidan_play2||die_judge_zidan_low_play2){
                kkkk_play2=1;
                MyLable.zhuanTou2=3;

//                view.MyLable.player2.x=1000;
            }
            label.repaint();
            try {
                Thread.sleep(10);
//                改毯子飞的速度
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if( kkkk==1&& kkkk_play2==1){
                while (GameOver.gameover_x>=300){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    kkkk=1;
                    GameOver.gameover_x--;
                    if(GameOver.gameover_x==300){
                        jjjj=1;
                        if (insertToDb=true){

                            sqlserver.insertDb(username,clock.s, Player.score+Player2.score,0);

                        }
                        insertToDb=false;
//                        System.out.println(MyLable.grades.getGrades());
//                        System.out.println(clock.s);
                    }

                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            如果胜利了
            if(Player.score+Player2.score==5000){
                while (Win.win_x>=300){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    kkkk=1;
                    Win.win_x--;
                    if(Win.win_x==300){
                        jjjj=1;
                        if (insertToDb=true){

                            sqlserver.insertDb(username,clock.s, Player.score+Player2.score,1);

                        }
                        insertToDb=false;
//                        System.out.println(MyLable.grades.getGrades());
//                        System.out.println(clock.s);
                    }

                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }







        }
    }
}
