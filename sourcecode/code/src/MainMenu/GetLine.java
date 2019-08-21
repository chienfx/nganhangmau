package MainMenu;

import java.util.Scanner;

public class GetLine {
	private static Scanner input = new Scanner(System.in);
	public static int gInt() {
		return Integer.parseInt(input.nextLine().toString());
	}
	
	public static String gString() {
		return input.nextLine().toString();
	}

}
