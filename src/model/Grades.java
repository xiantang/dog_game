package model;

import java.awt.*;

public class Grades {


    public Image[] images=new Image[]{
            Toolkit.getDefaultToolkit().getImage("imges/number/0.png"),
            Toolkit.getDefaultToolkit().getImage("imges/number/1.png"),
            Toolkit.getDefaultToolkit().getImage("imges/number/2.png"),
            Toolkit.getDefaultToolkit().getImage("imges/number/3.png"),
            Toolkit.getDefaultToolkit().getImage("imges/number/4.png"),
            Toolkit.getDefaultToolkit().getImage("imges/number/5.png")

    };



    public  void  drawSelf(Graphics g,int grades,int x,int y ){

        if (grades==0){
            g.drawImage(images[0],x,y,25,25,null);
        }else if (grades==1000){
            g.drawImage(images[1],x,y,25,25,null);
            g.drawImage(images[0],x+20,y,25,25,null);
            g.drawImage(images[0],x+40,y,25,25,null);
            g.drawImage(images[0],x+60,y,25,25,null);
        }else if (grades==2000){
            g.drawImage(images[2],x,y,25,25,null);
            g.drawImage(images[0],x+20,y,25,25,null);
            g.drawImage(images[0],x+40,y,25,25,null);
            g.drawImage(images[0],x+60,y,25,25,null);
        }else if (grades==3000){
            g.drawImage(images[3],x,y,25,25,null);
            g.drawImage(images[0],x+20,y,25,25,null);
            g.drawImage(images[0],x+40,y,25,25,null);
            g.drawImage(images[0],x+60,y,25,25,null);
        }
        else if (grades==4000){
            g.drawImage(images[4],x,y,25,25,null);
            g.drawImage(images[0],x+20,y,25,25,null);
            g.drawImage(images[0],x+40,y,25,25,null);
            g.drawImage(images[0],x+60,y,25,25,null);
        }
        else if (grades==5000){
            g.drawImage(images[5],x,y,25,25,null);
            g.drawImage(images[0],x+20,y,25,25,null);
            g.drawImage(images[0],x+40,y,25,25,null);
            g.drawImage(images[0],x+60,y,25,25,null);
        }
    }


}