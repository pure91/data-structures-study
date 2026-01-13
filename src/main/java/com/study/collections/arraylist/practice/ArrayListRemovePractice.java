package com.study.collections.arraylist.practice;

import com.study.collections.arraylist.impl.MyArrayList;

/**
 * 10만개 add하고
 * 맨 앞부터 삭제해서 사이즈 체험하기
 */
public class ArrayListRemovePractice {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        // 맨 앞인 0부터 삭제해서 뒤를 다 이동시킴
        // 이거는 단순히 {1,2,3,4,5~100,000} 들어가있는 list를
        // size를 1개씩 줄이면서 맨 앞에꺼를 1만개 만큼 삭제해서 당기는것
        for (int i = 0; i < 100_00; i++) {
            list.remove(0);
        }

        long end = System.currentTimeMillis();

        System.out.println("앞쪽 삭제 시간(ms):" + (end - start));
        // 1141이니까 1.14초
        // list.add해서 자리이동보다 remove가 조금 더 가벼운 이유는
        // list.add는 resize 가능성도 있고, 대입할 연산 수도 많음
        // 반면에 remove는 그냥 지우면되고 null을 대입하여 GC처리도함

    }
}