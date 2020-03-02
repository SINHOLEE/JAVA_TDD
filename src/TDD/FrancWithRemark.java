
// 20. 프랑 클래스 구현
// 21. 그렇다면, 달러 클라스와 겹치는 부분이 상당하다. 하지만 일단은 그 부분을 무시하고, 진행해 보도록 하자.
// 22. 테스트를 돌리면 문제없이 실행이 된다. 하지만 중복된 부분이 많다. Money라는 클래스를 만들어서 이를 해결해 보자.
//     -> money class라는 상위 클래스를 만들고 프랑과 달러가 상속하는 구조로 바꿔보자.
class FrancWithRemark extends Money{
	
	FrancWithRemark(int amount, String currency){
		super(amount, currency);
	}
		
	public Money times(int multiplier) {
		return Money.franc(amount * multiplier); 
	}
}
