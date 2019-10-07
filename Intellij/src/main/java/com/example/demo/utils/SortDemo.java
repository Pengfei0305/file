package com.example.demo.utils;

import com.example.demo.RestTemplateMain;
import com.example.demo.domain.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Point {

    private int x;
    private int y;

    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ","+  y + ")";
    }
}

public class SortDemo {

    private static List<Point> list = new ArrayList<>();
    private static List<Money> moneyList = new ArrayList<>();


    public static void main(String[] args) {

        //随机生成10个点
        for (int i = 0; i < 10; i++) {
            //点的坐标取值在[1,20]之间
            int x = (int) (Math.random() * 20) + 1;
            int y = (int) (Math.random() * 20) + 1;
            int moneyNum = (int) (Math.random() * 200) + 1;
            Money m = new Money();
            m.setBigDecimal(BigDecimal.valueOf(moneyNum));
            m.setGetter("hh"+moneyNum);
            moneyList.add(m);
            list.add(new Point(x, y));
        }



        System.out.print("排序前：");
        System.out.println(list);

        //降序排序
        Collections.sort(list, new Comparator<Point>() {

            @Override
            //当 o1 < o2 时返回正数
            public int compare(Point o1, Point o2) {
                int distance1 = (o1.getX()) * (o1.getX()) + (o1.getY()) * (o1.getY());
                int distance2 = (o2.getX()) * (o2.getX()) + (o2.getY()) * (o2.getY());

                return (distance1 < distance2) ? 1 : ((distance1 == distance2) ? 0 : -1);
            }

        });

        System.out.print("排序后：");
        System.out.println(list);


        System.out.print("排序前：");
        System.out.println(moneyList);
        //降序排序
        RestTemplateMain.coll(moneyList);

        System.out.print("排序后：");
        System.out.println(moneyList);

    }
}

