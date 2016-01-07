package com.chang.oodp.structural.adapter;

//구모델 인터페이스
interface OldToy {
	public void use();

	public void onPlug(); // 구모델의 충전 타입.

	public String getName();
}

// 구모델 장난감
class OldToyImpl implements OldToy {
	private String myName = "";

	public OldToyImpl(String myName) {
		this.myName = myName;
	}

	@Override
	public void use() {
		System.out.println(myName + " : use plug on");
	}

	// 구모델은 플러그를 통해 충전 함.
	@Override
	public void onPlug() {
		System.out.println(myName + " : plug on");
	}

	@Override
	public String getName() {
		return myName;
	}

}

// 신모델 인터페이스
interface NewToy {
	public void use();

	public void onUSBCharge(); // 신모델의 충전타입.

	public String getName();
}

// 신모델 장난감
class NewToyImpl implements NewToy {
	private String myName = "";

	public NewToyImpl(String myName) {
		this.myName = myName;
	}

	@Override
	public void use() {
		System.out.println(myName + " : use USB");
	}

	// 신모델은 USB를 통해 충전 합니다.
	@Override
	public void onUSBCharge() {
		System.out.println(myName + " : on USB charge");
	}

	@Override
	public String getName() {
		return myName;
	}
}

// 신모델과 똑같은 충전방식을 지원하는 구모델 어댑터
class ToyAdater implements NewToy {
	OldToy oldType;

	// 구모델을 생성자를 통해 받음
	public ToyAdater(OldToy oldType) {
		this.oldType = oldType;
	}

	@Override
	public void use() {
		oldType.use();
	}

	// 구모델 충전 타입을 USB로 전환 후 충전 함.
	@Override
	public void onUSBCharge() {
		System.out.println(oldType.getName() + " adapter change USB MODE and ");
		oldType.onPlug();
	}

	@Override
	public String getName() {
		return oldType.getName();
	}
}

// 프로그램 실행
public class OldAndNewToyTest {
	public static void main(String ar[]) {
		// 구 모델의 장난감
		OldToy oldToy = new OldToyImpl("old");
		// 신 모델의 장난감
		NewToy newToy = new NewToyImpl("new");
		// 구 모델의 장난감을 어댑터를 통해 신모델처럼 사용
		ToyAdater adater = new ToyAdater(oldToy);

		oldToy.use();
		newToy.use();

		oldToy.onPlug();

		// 신모델 충전
		newToy.onUSBCharge();

		// 구모델을 신모델 충전으로 사용하기 위해
		// 어뎁터에 추가했으므로, 어뎁터의 충전을 호출 함
		adater.onUSBCharge();
	}
}