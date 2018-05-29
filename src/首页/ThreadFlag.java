package 首页;

import java.util.Scanner;

public class ThreadFlag extends Thread
{
    public volatile boolean exit = false;

    public void run()
    {
        while (!exit){
            int a[] = new int[]{1,2,3,4,5,6,7,8,9};
//for(int j=0;j<3;j++){
            for(int i=0;i<9;i++){
                System.out.println(a[i]);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                exit = true;
        }

        }
//    }
    public static void main(String[] args) throws Exception
    {
        ThreadFlag thread = new ThreadFlag();
        thread.exit = false;
        thread.start();
        sleep(1000); // 主线程延迟
//      // 终止线程thread
        thread.join();
        System.out.println("线程退出!");
//        Scanner s = new Scanner(System.in);
    }
}