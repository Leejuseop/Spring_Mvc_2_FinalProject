package hello.item_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
		// PRG 그거부터 보면됨
		/*
		상품 수정페이지에서 데이터 입력하고 저장 누르면 redirect되서 그 경로로 가야된단 말이야 그리고 실제로 데이터도 잘 넘어가지는데 
		문제는 이게 코드스페이스라서 경로가 그지같아 넘어가서 없는 페이지url을 넘겨줘 이거 어케 할지 모르게따 항상 redirect만 쓰면 이러는데
		구글링해봐도 안나옴 어카지 ;;; 그래서 일단 원래 저장 누르면 그 수정된 상태의 상품 상세페이지로 넘어가야되는데
		그냥 목록으로 넘어가게 해놨음 ㅇㅋ?

		하 상품등록할때 새로고침을 누르면 그대로 전에 했던 post데이터가 계속 넘어가서 계속 새로 등록 된단말이야? 그래서 
		redirect해서 post가 아니라 그 새로운 url로 이동시켜줘야하는데, 이게 코드스페이스 redirect하 이거 url값 잘못된걸 넘겨줘서 안됨 그래서 그냥 이것도 리스트로 넘어가게 만들었음.
		*/ 



	}

}
