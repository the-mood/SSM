package com.classdesign.utils;


/**
 * @Author yang97
 * @Date 2020/6/23 14:28
 */
public class compute1 {
    //          甲      乙       丙
    //  part1
    //  part2
    //  part3
    //01
    private static int min = 1<<30;//用来比较费用，挑出最小费用，数值一定要大，否则进不去一开始的判断语句
    private static int [] sumArr = new int[6];//一共有3*2*1=6种情况
    private static int m=0;
    public static int[][] computers(int [][]price, int number1, int number2, int number3) {
        int k = 0;//放结果数组的下标，把六种情况的花费存放在数组里
        int pr1[][]=new int[3][3];
        int rs[][]=new int[3][3];
        for(int i=0;i<3;i++) {
            pr1[0][i] = price[0][i]*number1;//
        }//第一行的价格乘以CPU的数量
        for(int i=0;i<3;i++) {
            pr1[1][i] = price[1][i]*number2;
        }//第二行的价格乘以显卡的数量
        for(int i=0;i<3;i++) {
            pr1[2][i] = price[2][i]*number3;
        }//第三行的价格乘以硬盘的数量
        back(pr1,0,0,0);//调用back（）函数
        for(int j=0;j<6;j++) {//循环六次，在结果数组里面找到和min值相等的元素，并输出下标，这样就知道是第几种情况了
            if(min==sumArr[j]){
                k = j;//把第几种情况的下标传给k，k会在switch函数中用到
                break;//这个不能删除，结果数组可能会出现价格一样的情况，删除就会，进入两次if判断
            }
        }
        //可能的六种情况，根据坐标得出实际情况
        switch (k){
            case 0:rs= new int[][]{{price[0][0],        0,              0},
                                    {0,             price[1][1],        0},
                                    {0,                 0,          price[2][2]}};break;

            case 1:rs= new int[][]{{price[0][0],        0,              0},
                                    {0,                 0,          price[1][2]},
                                    {0,             price[2][1],        0}};break;

            case 2:rs= new int[][]{{0,              price[0][1],        0},
                                    {price[1][0],       0,              0},
                                     {0,                  0,          price[2][2]}};break;

            case 3:rs= new int[][]{{0,              price[0][1],          0},
                                     {0,                 0,              price[1][2]},
                                    {price[2][0],       0,                0}};break;


            case 4:rs= new int[][]{{0,                  0,              price[0][2]},
                                    {price[1][0],       0,                  0},
                                    {0,             price[2][1],              0}};break;

            case 5:rs= new int[][]{{0,                  0,          price[0][2]},
                                    {0,             price[1][1],         0},
                                    {price[2][0],       0,              0}};break;
            default:break;
        }
        return rs;
    }//main函数的括号

    //使用递归的方法得出最优解和最优方案
    public static void back(int pr[][], int x, int sum, int info) {
        //当x==3时，就代表循环已经找出来一种情况了，找到三个元素，代表一次for循环结束，
        // 然后把结果存在结果数组里，并进入If判断花费是否比之前的花费少
        if(x == 3) {
            sumArr[m] = sum;//用来存放六次结果的花费
            m++;
            if(min>sum) {
                min = sum;//Min用来记录最小花费
            }
        }
        else//不满足x==n（n是3），就代表循环才找到一个或者两个元素，只有找到三个元素才算完整的一次结果
        {
            //y代表价格数组的列标，也就是，0代表cpu，1代表显卡，2代表硬盘，
            // 搜索顺序：第一行 第一列（之前没取过，满足条件，然后加到sum数组里，跳转到第二行，
            // 从第一列开始取）    第二行第一列（不满足，继续循环） 第二行第二列（满足，）
            // 然后继续跳转第三行，从第一列开始取进行判断 ，每跳转到下一行，都是从第一列开始进行判断
            for(int y =0;y<3;y++) {
                //info记录着取过元素的特征值，Info和（1<<y）进行与运算，
                // 结果等于0，就表示y下标现在所在的这个元素没被取过
                //01 10==0  01 11=1
                if((info & (1<<y)) == 0) {
                    //递归调用自身，info记录这个元素是否取过，并把信息传给下一次的调用
                    back(pr,x+1,sum+pr[x][y],info+(1<<y));
                }
            }
        }
    }
//输出min,再输出sumArr数组的下标，就知道第一种情况了

}
