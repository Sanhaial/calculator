package Lerning2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main{


	public static String calc(String input) throws MyException {
		String result = null;
		ArrayList<String> arr = operend(input);
		Integer operend1 = test_str(arr.get(0));
		Integer operend2 = test_str(arr.get(1));
		result = arethmetic_action(operend1, operend2, arr.get(2), arr.get(3));
		return result;
	}//

public  static ArrayList<String> operend(String str) throws MyException {
	String str1 = "";
	String str2 = "";
	String operator = "";
	ArrayList<String> arr = new ArrayList<String>();
	int i=0;
	char[] mass_c = str.toCharArray();
	for(char c: mass_c) {
		String s = new String(new char[]{c});
		if(s.equals("-")) {
			str2 = str.substring(i+1);
			operator = "-";
			break;
		}
		if(s.equals("+")) {
			str2 = str.substring(i+1);
			operator = "+";
			break;
		}
		if(s.equals("/")) {
			str2 = str.substring(i+1);
			operator = "/";
			break;
		}
		if(s.equals("*")) {
			str2 = str.substring(i+1);
			operator = "*";
			break;
		}
		str1 = str1 + s;
		i++;
	}
	//System.out.println("Строка 1 Длинна" + str1.length());
	//System.out.println("Строка 2 Длинна" + str2.length());
	if(str1.length() == 0) throw new MyException();
	if(str2.length() == 0) throw new MyException();
	str1 = remove_the_space(str1);
	str2 = remove_the_space(str2);
	HashMap<String, String> anc_numerals1 = arabic_numerals_converter(str1);
	HashMap<String, String> anc_numerals2 = arabic_numerals_converter(str2);
	String type_numerals1 = anc_numerals1.get("type_numerals");
	String type_numerals2 = anc_numerals2.get("type_numerals");
	String type_numerals = test_type_numerals(type_numerals1, type_numerals2);
	str1 = anc_numerals1.get("str");
	str2 = anc_numerals2.get("str");
	arr.add(str1); arr.add(str2); arr.add(operator); arr.add(type_numerals);
	return arr;
}
public static String remove_the_space(String inStr) {
	String str = "";
	char[] mass_c = inStr.toCharArray();
	for(char c: mass_c) {
		String s = new String(new char[]{c});
		if(s.equals(" ")) {
			continue;
		}
		str = str + s;
	}//
	return str;
}//
public static HashMap<String, String> arabic_numerals_converter(String str) {
	HashMap<String, String> anc_result = new HashMap<String, String>();
	anc_result.put("str", str);
	anc_result.put("type_numerals", "arabic");
	char[] mass_c = str.toCharArray();
	int length = mass_c.length;
	//System.out.println("В методе arabic_numerals_onverter ");
	//System.out.println("Длинна строки " + length);
	Integer result = roman_numerals(mass_c[length-1]);
	if (result == null) {
		return anc_result;
	}//
	for(int i=length-2;i>=0;i--) {
		Integer num_left = roman_numerals(mass_c[i]);
		if(num_left == null) {
			return anc_result;
		}//
		Integer num_right = roman_numerals(mass_c[i+1]);
		if(num_right == null) {
			return anc_result;
		}//
		if(num_right > num_left) {
			result -= num_left;
		}//
		else {
			result += num_left;
		}//
	}//
	
	
	//System.out.println("В методе arabic_numerals_onverter ");
	//System.out.println("Результат конвертации " + result);
	str = Integer.toString(result);
	anc_result.put("str", str);
	anc_result.put("type_numerals", "roman");
	return anc_result;
	
	//Integer num = roman_numerals(c);
}//
@SuppressWarnings("unlikely-arg-type")
public static Integer roman_numerals(char c) {
	Integer num = null;
	String str_c = new String(new char[]{c});
	HashMap<String, Integer> mapRoman = new HashMap<>();
	mapRoman.put("I", 1);
	mapRoman.put("V", 5);
	mapRoman.put("X", 10);
	mapRoman.put("L", 50);
	mapRoman.put("C", 100);
	num = mapRoman.get(str_c); 
	//System.out.println("В методе roman_numerals ");
	//System.out.println("Число из римских " + str_c + " Число арабское " + num);
	return num;
}//
@SuppressWarnings("finally")
public static String test_type_numerals(String str1, String str2) throws MyException {
	String str_res = str1;
	if(str1.equals(str2) != true) {
		str_res = "no";
		throw new MyException();
	}//
	return str_res;
}//
public static Integer test_str(String str) throws MyException{
	//str  = arabic_numerals_converter(str);
	Integer operend = null;
	Boolean flag_parseInt = true;
	//System.out.println("строка для проверки " + str);
	try{
		operend = Integer.parseInt(str);
	}//try{
	catch(NumberFormatException nfe){
		//System.out.println("Невозможно преобразовать в цифры ");
		flag_parseInt = false;
	}//catch(NumberFormatException nfe){
	finally {
		if(flag_parseInt == false) throw new MyException();
		//throw new MyException();
		return operend;
	}//
	}//
public static String roman_numerals_converter(Integer num, String type_numerals) throws MyException {
	String result = String.valueOf(num);
	
	if(type_numerals.equals("roman") == true) {
		result = roman_numerals(num);
		if(num <=0) throw new MyException();
	}//
	
	return result;
}//
public static String roman_numerals(Integer num) {
	String str_res = "";
	if(num == 0) {
		str_res = str_res + "N";
	}//
	do {
		//System.out.println("Переводим в римский формат  " + num + " Строковое значение " + str_res);
		if(num >= 100) {
			num = num - 100;
			str_res = str_res + "C";
			continue;
		}//
		if(num >= 50) {
			num = num - 50;
			str_res = str_res + "L";
			continue;
		}//
		if(num >= 10) {
			num = num - 10;
			str_res = str_res + "X";
			continue;
		}//
		if(num == 9) {
			num = num - 9;
			str_res = str_res + "IX";
			continue;
		}//
		if(num >= 5) {
			num = num - 5;
			str_res = str_res + "V";
			continue;
		}//
		if(num == 4) {
			num = num - 4;
			str_res = str_res + "IV";
			continue;
		}//
		if(num >= 1) {
			num = num - 1;
			str_res = str_res + "I";
			continue;
		}//
	}while(num > 0);
	//System.out.println("Переводим в римский формат после " + num + " Строковое значение " + str_res);
	return str_res;
	
}//
public static String arethmetic_action(Integer operend1, Integer operend2,  String operator, String type_numerals) throws MyException {
	String result = "Не верный формат ввода";
	if(type_numerals.equals("no")) {
		return result;
	}//
	Integer res = null;
	if (operend1 == null) return result; if(operend2 == null) return result;
	if (operend1 > 10) throw new MyException(); /*return result;*/ if(operend2 > 10) throw new MyException();/*return result;*/
	
	//System.out.println("Выполняем арифметическое действие Оператор " + operator);
	switch (operator) {
	case "-": res = operend1 - operend2;
	
		break;
	case "+": res = operend1 + operend2;
		
		break;
	case "/": res = operend1 / operend2;
		
		break;
	case "*": res = operend1 * operend2;
		
		break;

	default:  
		break;
	}//
	//System.out.println("Результат арифметического действия " + res);
	result = roman_numerals_converter(res, type_numerals);
	//result = String.valueOf(res);
	
	return result;
}//



public static void character_analysis(String str) {
	String str1 = "";
	String str2;
	String oper;
	char[] mass_c = str.toCharArray();
	for(char c: mass_c) {
		String s = new String(new char[]{c});
		if(s.equals("-")) {
			oper = "minus";
			break;
		}//
		str1 = str1 + s;
	}//
	//System.out.println("Строка 1 " + str1);
}//
}
