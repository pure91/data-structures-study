package com.study.collections.arraylist.practice;

import java.util.LinkedList;

/**
 * 10만개 add하고
 * 앞쪽에 1만개 삽입하고
 * 앞쪽에 1만개 삭제하고
 * 5만개 조회해보기
 */
public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // 10만개 add
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }

        long startAdd = System.currentTimeMillis();
        // 1만개 앞쪽에 add
        for (int i = 0; i < 10_000; i++) {
            list.addFirst(-1);
        }
        long endAdd = System.currentTimeMillis();
        System.out.println("LinkedList 앞쪽 추가(ms):" + (endAdd - startAdd));

        // 1만개 앞쪽에서 remove
        long startRemove = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            list.removeFirst();
        }
        long endRemove = System.currentTimeMillis();
        System.out.println("LinkedList 앞쪽 제거(ms):" + (endRemove - startRemove));

        // 5만개 조회

        long startGet = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            list.get(50_000);
        }
        long endGet = System.currentTimeMillis();
        System.out.println("LinkedList 중간 조회(ms):" + (endGet - startGet));

        // 삽입 삭제 빠르지만 조회가 느리네
        // LinkedList는 Node 체인 구조라서 {
        //     prev | value | next
        // }

        // 위에서 get(50_000)의 실제 동작이
        // Node current = first; 처음 넣어놓고
        // for(int i = 0; i < 50_000; i++) {
        //     current = current.next; 다음 주소를 넣어줌
        // }
        // return current.value;
        // 매번 다음 주소 포인터를 따라가야해서 cpu가 캐시, 메모리 지역성, 예측이 안됨

        /**
         *  실무에서 왜 안쓰냐?
         *  1. ArrayList보다 3~4배 메모리를 사용한다 Node 객체라서
         *  2. CPU 캐시를 못탄다. 연속적인 메모리가 아니고 여기저기 흩어져있어서
         *  3. 순회 자체도 느리다. 내부적으로 포인터의 next를 따라가기에
         *  4. 시제로 앞/뒤에만 삽입 삭제하는 시스템도 거의 없다. 조회가 중간에 꼭 섞인다.
         */

    }
}
