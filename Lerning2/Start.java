package Lerning2;

import java.util.Scanner;

public class Start {
	public static void main(String args[]) throws MyException {
		//System.out.println("В классе Start в методе main");
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите число");
		String str = scan.nextLine();
		Main objMain = new Main();
		String str_result = objMain.calc(str);
		System.out.println("Результат арифметического выражения " + str_result);
		
	}//
}
