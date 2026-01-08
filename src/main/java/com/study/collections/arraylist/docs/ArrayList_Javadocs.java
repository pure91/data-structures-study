package com.study.collections.arraylist.docs;

/**
 * ArrayList JavaDocs 해석
 *
 * "Resizable-array implementation of the List interface."
 * -> List 인터페이스를 구현한, 크기가 변하는 배열 기반 구현체
 * -> array 내부는 배열이다, 하지만 resize 자동으로 크기를 늘려준다.
 *
 * "Implements all optional list operations, and permits all elements, including null."
 * -> List가 제공하는 모든 연산 가능, null 저장 가능
 * -> null 허용 보자마자 방어코드가 없으면 NPE 유발자라는것을 생각하자
 *
 * "Provides constant-time positional access."
 * -> 인덱스 기반 접근 O(1)
 * -> 배열 기반 arr[index] 이것 때문에 조회 많은 경우 ArrayList를 선택하는것이다.
 *
 * "Adding an element has amortized constant time cost."
 * -> 대부분 O(1)지만 가끔씩 O(n)
 * -> 이유는 capacity를 초과하면 더 큰 배열을 생성해야해서 기존 데이터를 복사하기 때문 resize
 *
 * "Not synchronized."
 * -> Thread-safe가 아니다
 * -> 멀티 스레드 환경은 Collections.synchronizedList나 CopyOnWriteArrayList가 있다.
 *
 * ArrayList의 내부 필드를 단순화해보면
 * Object[] elementData;
 * int size;
 * -> size는 실제 저장된 데이터의 개수(실제 사용중인 요소의 수)
 * -> capacity가 배열의 길이다.
 * -> 내가 list의 배열 길이가 size인줄 알고 있었기에 내부를 생각해본것!
 *
 * 실무 포인트
 * - 조회 많을 때 유리
 * - 중간 삽입/삭제는 주의
 */
public class ArrayList_Javadocs {

}
