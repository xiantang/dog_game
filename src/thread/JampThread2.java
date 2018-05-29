package thread;

import model.BoolDie;
import model.FeiTan;
import model.Player;
import model.Player2;
import view.MyFrame;
import view.MyLable;
import view.MyPanel;

//困扰时间巨长的线程
public class JampThread2  implements Runnable{
    private int kkk=1;


    @Override
    public void run() {

        while (true){

            if(BoolDie.isDie){
                break;
            }


            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        aBoolean_jump  是一个bool值开关

            if(MyPanel.aBoolean_jump_play2) {
//
                if(MyPanel.Tou_fangxiang==1)
                    MyLable.zhuanTou2=6;
                else if(MyPanel.Tou_fangxiang==2)
                    MyLable.zhuanTou2=5;



                for (int i = 0; i < 50; i++) {
                    try {

                        MyFrame.panel.label.repaint();
                        Thread.currentThread().sleep(10);
                        Player2.y = Player2.y - 2;
                    } catch (Exception ex) {

                    }
                }
                for (int i = 0; i < 25; i++) {
                    try {
                        MyFrame.panel.label.repaint();
                        Thread.currentThread().sleep(10);

                        Player2.y = Player2.y + 4;
                        if (Player2.isCollsionWithRect(Player2.x, Player2.y, Player2.width, Player2.height, 610, 460, 20, 72)) {
                            //一号墙
                            break;
                        } else if (Player2.isCollsionWithRect(Player2.x, Player2.y, Player2.width, Player2.height, 786, 460, 20, 72)) {
                            //二号墙
                            break;
                        } else if (Player2.isCollsionWithRect(Player2.x, Player2.y, Player2.width, Player2.height, 622, 504, 132, 22)) {
                            //红色砖头
                            break;
                        } else if (Player2.getRectangle().intersects(FeiTan.getRectangle())) {

                            //飞毯
                            break;
                        } else if (Player2.isCollsionWithRect(Player2.x, Player2.y, Player2.width, Player2.height, 0, 287, 576, 22)) {

                            //最长的棍子
                            break;

                        } else if (Player2.isCollsionWithRect(Player2.x, Player2.y, Player2.width, Player2.height, 941, 459, 44, 22)) {

                            //第二长的棍子
                            break;
                        }

                    } catch (Exception ex) {

                    }
                }
                MyPanel.aBoolean_jump_play2 = false;
            }


        }


    }



}
