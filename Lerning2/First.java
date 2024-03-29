package Lerning2;

public class First {
	
	First(){
		
	}//
	
public static Integer asdf(int[] mass1) {
	Integer num = null;
	System.out.println("Возвращаем тип числа  " + mass1);
	int lenghtch = mass1.length;
	for(int i: mass1) {
		num = num + i;
	}//
	int num1 = num / lenghtch;
	System.out.println("Возвращаем тип числа  " + mass1);
	return  num;
}//

public static void main(String args[]) {
	int[] mass1 = {1, 2, 4, 6};
	Integer res =  asdf(mass1);
	System.out.println("Возвращаем тип числа  " + res);
}//
	
}//
