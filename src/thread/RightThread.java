package thread;

import model.BoolDie;
import model.Player;
import model.Player2;
import view.MyFrame;
import view.MyLable;
import view.MyPanel;

public class RightThread implements Runnable {


    public RightThread() {

    }

    @Override
    public void run() {
        while (true) {


//            if(BoolDie.isDie)
//            {
//                break;
//            }

            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            MyFrame.panel.label.repaint();
            boolean first_left=Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,622,460,25,68);
            boolean second_left=Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,786,460,25,68);
            boolean first_right=Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,622,460,15,68);
            boolean first_to_bool=Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,630,460,15,68);
            boolean second_right=Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,786,460,15,68);
            boolean second_to_bool=Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,796,460,15,68);


            boolean first_left_play2=Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,622,460,25,68);
            boolean second_left_play2=Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,786,460,25,68);
            boolean first_right_play2=Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,622,460,15,68);
            boolean first_to_bool_play2=Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,630,460,15,68);
            boolean second_right_play2=Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,786,460,15,68);
            boolean second_to_bool_play2=Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,796,460,15,68);
            if (MyPanel.aBoolean_right) {

                if (first_right == false && second_right == false && Player.x >= -10 && Player.x <= 915&&PaintThread.kkkk!=1) {
                    Player.x += 2;//一号柱子

                }
                if (first_right == true && (Player.y <= 415)) {
                    Player.x += 2;

                }

                if (second_right == true && (Player.y <= 415)) {
                    Player.x += 2;

                }
                if(PaintThread.kkkk!=1)
                MyLable.zhuanTou = 0;
                if(Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,0,530,985,34)){

                    if (PaintThread.run % 2 == 0&&PaintThread.kkkk!=1) {
                        MyLable.zhuanTou = 2;

                    }
                }
                else {

                }

            }
            if (MyPanel.getaBoolean_left) {
                if(first_to_bool==false&&second_to_bool==false&&Player.x>=0&&Player.x<=920&&PaintThread.kkkk!=1){
                    Player.x-=2;//一号柱子
                }
                if(first_left==true&&Player.y<=415){
                    Player.x-=2;
                }
                if(second_left==true&&Player.y<=415){
                    Player.x-=2;
                }//为了让狗在障碍物上走
                if (PaintThread.kkkk!=1)
                MyLable.zhuanTou=1;
                if(PaintThread.run % 2==0&&PaintThread.kkkk!=1){
                    MyLable.zhuanTou=4;
                }

            }
//            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (MyPanel.aBoolean_right_play2) {

                if (first_right_play2 == false && second_right_play2 == false && Player2.x >= -10 && Player2.x <= 915&&PaintThread.kkkk_play2!=1) {
                    Player2.x += 2;//一号柱子

                }
                if (first_right_play2 == true && (Player2.y <= 415)) {
                    Player2.x += 2;

                }

                if (second_right_play2 == true && (Player2.y <= 415)) {
                    Player2.x += 2;

                }
                if(PaintThread.kkkk_play2!=1)
                MyLable.zhuanTou2 = 0;
                if(Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,0,530,985,34)||Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,0,287,576,22)&&PaintThread.kkkk_play2!=1){
                    MyLable.zhuanTou2 = 0;
                    if (PaintThread.run % 2 == 0&&PaintThread.kkkk_play2!=1) {
                        MyLable.zhuanTou2 = 2;

                    }

                }
                else if (PaintThread.kkkk_play2!=1){
                    MyLable.zhuanTou2 = 6;
                }
            }
            if (MyPanel.getaBoolean_left_play2) {
                if(first_to_bool_play2==false&&second_to_bool_play2==false&&Player2.x>=0&&Player2.x<=920&&PaintThread.kkkk_play2!=1){
                    Player2.x-=2;//一号柱子
                }
                if(first_left_play2==true&&Player2.y<=415){
                    Player2.x-=2;
                }
                if(second_left_play2==true&&Player2.y<=415){
                    Player2.x-=2;
                }//为了让狗在障碍物上走
                if(PaintThread.kkkk_play2!=1)
                MyLable.zhuanTou2=1;
                if(Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,0,530,985,34)||Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,0,287,576,22)&&PaintThread.kkkk_play2!=1){
                    MyLable.zhuanTou2 = 1;
                    if (MyLable.player.x%10 == 0&&PaintThread.kkkk_play2!=1) {
                        MyLable.zhuanTou2 = 4;

                    }

                }
                else if(PaintThread.kkkk_play2!=1){
                    MyLable.zhuanTou2 = 5;
                }

            }

        }

    }

}
