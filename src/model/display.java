package model;

public class display {
    private  int value=0;
    private  int limit=0;

    public display(int limit) {
        this.limit = limit;
    }
//    加1
    public void increase (){
        value++;
//        秒，和都是60进制  如果添加小时的话  limit 设置为24即可
        if(value==limit){
            value=0;
        }

    }
//    返回值
    public  int getvalue(){
        return  value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
