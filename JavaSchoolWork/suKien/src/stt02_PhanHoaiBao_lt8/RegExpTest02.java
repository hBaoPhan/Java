package stt2_PhanHoaiBao_lt8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest02 {

	public static void main(String[] args) {
		String input="Now is the time";
		String pattern = "[a-z]+";
		Pattern p=Pattern.compile(pattern);
		Matcher matcher=p.matcher(input);
		while (matcher.find()) {
			System.out.println(input.substring(matcher.start(), matcher.end())+"*");
		}

	}

}
