package com.study.collections.arraylist.practice;

import com.study.collections.arraylist.impl.MyArrayList;

/**
 * 10만건을 이미 추가해놓고
 * 이후 1만건은 앞쪽에다 삽입해서 사이즈 이동 시간 체험하기
 */
public class ArrayListAddFrontPractice {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        // 왜 이렇게 했냐면 이미 size는 10만개고
        // 거기에 1만개를 더 더할건데 0번째 index에 -1라는 값을 명시적으로 넣어서
        // ex) size 100001개일때 0번째 index에 -1,
        //     size 100002개일때 0번째 index -1, 1번째 index -1 ~~ 이렇게 다 뒤로 밀어내려고 최악의 속도를 보기위함
        for (int i = 0; i < 100_00; i++) {
            list.add(0, -1);
        }

        long end = System.currentTimeMillis();

        System.out.println("앞쪽 삽입 시간(ms):" + (end - start));
        // 1474면 1.47초
    }
}