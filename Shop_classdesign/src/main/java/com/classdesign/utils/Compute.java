package com.classdesign.utils;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Test;

/**
 * @Author yang97
 * @Date 2020/6/22 19:58
 */
public class Compute {
    //得出最优解和最优解的方案
    public static int[][] compute(int price[][],int num1,int num2,int num3){
//        int price[][]={{1000,1100,1200},{500,400,600},{900,800,700}};
//        int num1=1,num2=2,num3=3;
        //乘上数量以后的总价，每个商品
        int [][] pr = new int [3][3];
        int [][] rs = new int [3][3];
        int [] sum = new int[6];
        int [] sum1=new int[6];
        int k = 8;
        for(int i=0;i<3;i++) {
            pr[0][i] = price[0][i]*num1;
        }//第一个需求商品：每个供应商的价格*数量
        for(int i=0;i<3;i++) {
            pr[1][i] = price[1][i]*num2;
        }//第二个需求商品：每个供应商的价格*数量
        for(int i=0;i<3;i++) {
            pr[2][i] = price[2][i]*num3;
        }//第三个需求商品：每个供应商的价格*数量
        /**
         *建立价格数组
         *             甲       乙         丙
         * part1    a[0][0]   a[0][1]   a[0][2]
         * part2    a[1][0]   a[1][1]   a[1][2]
         * part3    a[2][0]   a[2][1]   a[2][2]
         *
         */
        //记录保存对应商品乘上需求数量后的六种情况的总价格数组
        sum1[0]=sum[0]=pr[0][0]+pr[1][1]+pr[2][2];
        sum1[1]=sum[1]=pr[0][0]+pr[1][2]+pr[2][1];
        sum1[2]=sum[2]=pr[0][1]+pr[1][0]+pr[2][2];
        sum1[3]=sum[3]=pr[0][1]+pr[1][2]+pr[2][0];
        sum1[4]=sum[4]=pr[0][2]+pr[1][0]+pr[2][1];
        sum1[5]=sum[5]=pr[0][2]+pr[1][1]+pr[2][0];
        //对结果进行排序，得出最小值和最小值的坐标
        QuickSort(sum,0,5);
        for(int i=0;i<6;i++){
            if(sum1[i]==sum[0]){
                k=i;
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
    }
    public static void QuickSort(int a[], int p, int r)
    {
        if (p < r)
        {
            int q = Partition(a, p, r);
            QuickSort(a, p, q - 1);//对左半边排序
            QuickSort(a, q+1, r);//对右半边排序
        }
    }
    public static int Partition(int a[], int p, int r)
    {
        int i = p, j = r + 1;
        int x = a[p];
        //将小于x的元素交换到左边区域
        //将大于x的元素交换到右边区域
        while (true)
        {
            while (a[++i] < x&&i < r);
            while (a[--j] > x);
            if (i >= j) break;
            swap(a,i, j);
        }
        a[p] = a[j];
        a[j] = x;
        return j;
    }
    public static void swap(int a[], int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
