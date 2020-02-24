
// 7. 현재 이 모습이 value object pattern 이라고 한다.
// 8. 값 객체 패턴(value object pattern)의 제약사항 중 하나는 
//    객체의 인스턴스 변수가 생성자를 통해서 일단 설정 된 후에는 결코 변하지 않는다는 것
// 9. 이것의 특징은, 타 행위에 대해 독립적이다. 인스턴스의 변수가 변하지 않는다, 새로운 변수가 필요하면 새로운 인스턴스가 필요하다.

class Dollar {
	int amount;
	Dollar(int amount){
		this.amount = amount;
	}
//	4. time이 반환하는 타입을 Dollar로 선언한 뒤 일단 리턴값을 null로 한다. 
	Dollar times(int multiplier) {
//		amount *= multiplier;
//		5. junit을 실행해보면 nullpointerror가 떳다. 
//		return null;
//		6. 이를 해결하기 위해 새로운 Dollar 인스턴스를 리턴한다.
		return new Dollar(amount * multiplier); 
	
	}
	;
}
