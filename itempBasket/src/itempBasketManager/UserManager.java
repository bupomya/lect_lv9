package itempBasketManager;

import java.util.ArrayList;
import java.util.Scanner;

import shop.Shop;
import shop.User;

public class UserManager {
	Scanner sc = new Scanner(System.in);
	Shop s = new Shop();
	int userLog = -1;
	int userCnt;
	ArrayList<String> ids = new ArrayList<>();
	
	public void join() {
		System.out.print("가입할 id입력 : ");
		String id = sc.next();
		User temp = new User(id,0);
		boolean check =false;
		if (this.userCnt !=0) {
			for (int i = 0; i < this.userCnt; i++) {
				if (this.ids.get(i)== id) {
					check = true;
				}
			}
		}
		if (!check) {
			ids.add(id);
		}else {
			System.out.println("중복id");
		}
	}//join
	
}//UserManager
