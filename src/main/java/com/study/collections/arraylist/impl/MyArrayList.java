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

    // overloading 추가 뒤에서부터 한칸씩 이동
    public void add(int index, E e) {
        rangeCheckForAdd(index);

        if (size == elementData.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = e;
        size++;
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

        // *** java 8버전 이후로는 ArrayList를 기본 생성자로 생성할 때 최초 capacity를 즉시 10으로 할당하지 않고 0이다.
        // 이걸 지연초기화라고 하는데 메모리 효율성을 위해 변경된것
        // EMPTY_ELEMENTDATA라는 빈 배열 {}로 초기화해놓고
        // 개발자가 list.add()를 호출하는 순간 비로소 기본값 10으로 확장함!
        // 이후 용량이 부족하면 1.5배씩 증가시킴
    }

    public E remove(int index) {
        rangeCheck(index);

        E oldValue = (E) elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData[size - 1] = null; // null을 넣어서 참조를 제거한다 -> GC처리, 메모리 누수 방지를 위함
        size--;

        return oldValue;
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

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

}
