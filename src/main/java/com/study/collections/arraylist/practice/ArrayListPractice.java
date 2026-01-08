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
    }
}
