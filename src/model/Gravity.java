package model;

import view.MyPanel;

public class Gravity extends Thread{
    public Player player;

    public Gravity(Player player) {
        this.player = player;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().sleep(10);
                if (Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,0,530,985,34)){
//                    System.out.println("接触地面");
                    //地面碰撞
                }
//
                else if (Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,622,504,132,22)){
                        //红色砖头
                }
                else if (Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,622,460,30,72)){}//一号墙
                else if (Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,786,448,30,72)){}//二 号墙
                else if (Player.getFoot().intersects(FeiTan.getRectangle())){}//云梯
                else if (Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,0,287,576,22)){}//最长的棍子
                else if (Player.isCollsionWithRect(Player.x,Player.y,Player.width,Player.height,941,459,44,22)){}//第二长的棍子
                else if (MyPanel.aBoolean_jump){}
                else if (!MyPanel.aBoolean_jump){
                    Player.y+=4;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}}
