package MainMenu;

import java.util.Scanner;
import ChooseProduct.ToBill;
import ShowEditMenu.mainmenu;
import Total.ShowTotal;

public class Menu {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		boolean cont = true;

		do {
			//menu
			System.out.println("***********************************************************************************************");
			System.out.println("*                                      -------- MENU ---------                                *");
			System.out.println("*                                      |  1  |      Edit     |                                *");
			System.out.println("*                                      |  2  |      Order    |                                *");
			System.out.println("*                                      |  3  |      Total    |                                *");
			System.out.println("*                                      |  4  |      Exit     |                                *");
			System.out.println("*                                      -----------------------                                *");
			System.out.println("***********************************************************************************************");
			System.out.print("Select: ");
			int chon = input.nextInt();
			System.out.println("");

			if(chon == 1) {
				mainmenu nw = new mainmenu(); nw.run();
			}else if(chon == 2) {
				ToBill.ToBill();
			}else if(chon == 3) {
				ShowTotal.show_total();
			}else if(chon == 4) {
				System.out.println("Bye");
				break;

			}else {
				continue;
			}
		}
		while (cont);



	}
}
