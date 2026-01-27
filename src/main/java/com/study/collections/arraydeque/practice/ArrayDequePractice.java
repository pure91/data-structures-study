package com.study.collections.arraydeque.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack보다는 Deque를 권장
 * 한번 사용해보기
 * 이거는 Head랑 Tail만 움직임
 */
public class ArrayDequePractice {
    
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        // 10만개 add
        for (int i = 0; i < 100_000; i++) {
            deque.addLast(i);
        }
        
        // 앞쪽 삽입
        long startAdd = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            deque.addFirst(i);
        }
        long endAdd = System.nanoTime();
        System.out.println("ArrayDeque 앞쪽 삽입(ns): " + (endAdd - startAdd));
        
        // 앞쪽 삭제
        long startRemove = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            deque.removeFirst();
        }
        long endRemove = System.nanoTime();
        System.out.println("ArrayDeque 앞쪽 삭제(ns): " + (endRemove - startRemove));
    }
}
