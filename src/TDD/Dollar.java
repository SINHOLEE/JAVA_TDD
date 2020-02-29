class Dollar extends Money{
//	17. 이제 private로 선언하자.
//	18. 무슨말인지는 모르겠지만. 67p에서는  
//		만약 동치성 테스트가 동치성에 대한 코드가 정확히 작동한다는 것을 검증하는데 실패하게 된다면, 
//		곱하기 테스트 역시 곱하기에 대한 코드가 정확하게 작동한다는 것을 검증하는 데 실패하게 된다.?
//		아 즉 equal() 이라는 메소드에 문제가 있다면, times()에 대한 결과도 이상할 수 밖에 없게 된다는 위험에 노출된다.
//		-> testMultiplication에서 TestFrancMuliplicaction 라는 함수를 만들자.
	
	Dollar(int amount, String currency){
		super(amount, currency);
	}
//	4. time이 반환하는 타입을 Dollar로 선언한 뒤 일단 리턴값을 null로 한다. 
	Money times(int multiplier) {
//		amount *= multiplier;
//		5. junit을 실행해보면 nullpointerror가 떳다. 
//		return null;
//		6. 이를 해결하기 위해 새로운 Dollar 인스턴스를 리턴한다.
		return Money.dollar(amount * multiplier); 
	
	}
	
//	12. 일단 이퀄이라는 메소드를 만들고 무조건 트루를 반환하도록 만들어 초록막대기를 보이자.
//	13. 개인적인 의문 : 왜 times() 메소드는 public 접근제어자를 안쓰는가?
//		-> testMultiplicationtest()
//	public boolean equals(Object object) {
////		Dollar dollar = (Dollar) object;
//		
////		24. 임시변수 선언부(좌항)을 Money로 바꿔본다. 바꿔도 문제없이 테스트가 돌아간다.
////		Money dollar = (Dollar) object;
//		
////		25. 이제는 캐스트 부분(우항)을 Money로 바꿔본다.
////		Money dollar = (Money) object;
////		return amount == dollar.amount;
//		
////		26. 임시변수의 이름과 리턴값도  money로 바꾼다.
////		27. 이 메소드는 이제 Money 클래스에 옮길 수 있게 되었다.
//		Money money = (Money) object;
//		return amount == money.amount;
// 
//	}
}
