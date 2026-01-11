package com.study.collections.arraylist.practice;

import com.study.collections.arraylist.impl.MyArrayList;

/**
 * [연습 과제]
 * 게시글 ID를 1,000,000만개 add하고
 * get으로 100,000번 조회하고
 * 실행 시간을 측정해보기
 * -> 이후 LinkedList와 비교해보기
 *
 * [사고 훈련하기]
 * 실시간 채팅 메시지 저장할 때
 * 앞쪽 메시지 계속 삭제하고 뒤쪽에 추가할때
 * ArrayList가 적합한지 공부해서 서술해보기
 */
public class ArrayListPractice {

    public static void main(String[] args) {
        MyArrayList<Long> postIds = new MyArrayList<>();

        // 게시글 Id를 100만개 추가하고
        for (long i = 0; i < 1_000_000; i++) {
            postIds.add(i);
        }

        // 조회 시간 측정
        // long start = System.currentTimeMillis(); // 1/1,000초 => 1,000ms가 1초
        long start = System.nanoTime(); // 1/1,000,000,000초

        // 10만번 조회
        for (int i = 0; i < 100_000; i++) {
            postIds.get(i);
        }

        // long end = System.currentTimeMillis();
        long end = System.nanoTime();

        System.out.println("조회시간:" + (end - start));
        //와... 나노초에 848300이 나오면 0.84ms? 이래서 O(1)이구나..
    }
}