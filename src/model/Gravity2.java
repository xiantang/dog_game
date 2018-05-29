package model;

import view.MyPanel;

public class Gravity2 extends Thread{
    public Player2 player2;

    public Gravity2(Player2 player2) {
        this.player2 = player2;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().sleep(10);
                if (Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,0,530,985,34)){
//                    System.out.println("接触地面");
                    //地面碰撞
                }
//
                else if (Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,622,504,132,22)){
                    //红色砖头
                }
                else if (Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,622,460,30,72)){}//一号墙
                else if (Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,786,448,30,72)){}//二 号墙
                else if (Player2.getFoot().intersects(FeiTan.getRectangle())){}//云梯
                else if (Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,0,287,576,22)){}//最长的棍子
                else if (Player2.isCollsionWithRect(Player2.x,Player2.y,Player2.width,Player2.height,941,459,44,22)){}//第二长的棍子
                else if (MyPanel.aBoolean_jump_play2){}
                else if (!MyPanel.aBoolean_jump_play2){
                    Player2.y+=4;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }}
