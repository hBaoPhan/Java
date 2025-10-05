package stt02_PhanHoaiBao_lt8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest04 {

	public static void main(String[] args) {
		String regex="((a)(bb))";
		String input="HabbGaHbJbb";
		
		Pattern pattern= Pattern.compile(regex);
		Matcher matcher=pattern.matcher(input);
		System.out.println("\nPattern"+ regex);
		
		while (matcher.find()) {
			for (int i = 1; i <= matcher.groupCount(); i++) {
				int s = matcher.start(i);
				int e = matcher.end(i);
				System.out.println("\nGroup "+ i + ": \"" + matcher.group(i) + "\"");
				System.out.println("find test \"" + input.substring(s,e)+"\"");
				System.out.println("start "+ s + " end " + e);
				
			}
		}

	}

}
