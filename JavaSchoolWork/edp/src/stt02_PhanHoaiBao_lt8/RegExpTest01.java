package stt02_PhanHoaiBao_lt8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest01 {

	public static void main(String[] args) {
		String input="Abc\ndef";
		String patternString="abc$";
		
		Pattern ptr=Pattern.compile(patternString,Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher matcher=ptr.matcher(input);
		boolean matcherFound=matcher.find();
		System.out.println(matcherFound);

	}

}
