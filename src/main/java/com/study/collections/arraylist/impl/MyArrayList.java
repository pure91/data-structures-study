package com.study.collections.arraylist.impl;

import java.util.Arrays;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elementData.length) {
            resize();
        }
        elementData[size++] = e;
    }

    private void resize() {
        int newCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
        // 여기서 Arrays.copyOf는 java.util.Arrays 클래스에 포함된 메서드로
        // 기존 배열의 내용을 지정된 길이의 새로운 배열에 복사하는것이다.
        // 깊은 복사로 원본배열을 수정하는게 아니라 새로운 배열을 반환함

        // Arrays.copyOf(원본 배열, 복사할 길이)
        // ex) 지금 elementData가 최초 10개로 생성자에서 할당했으면 elementData = {1,2,3,4,5,6,7,8,9,10} 일텐데
        //     newCapacity에서 길이 * 2를 했으니 {1,2,3,4,5,6,7,8,9,10,0,0,0,0,0,0,0,0,0,0} 이렇게 더 큰 크기로 복사되면서 나머지는 0으로 채워지는 것
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
