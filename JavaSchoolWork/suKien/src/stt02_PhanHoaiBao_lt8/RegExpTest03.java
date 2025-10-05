package stt02_PhanHoaiBao_lt8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest03 {
	public static void main(String[] args) {
		String[] regex = {"^dog","dog$"};
		String input = "Love melove my dog";
		System.out.println("Input:"+ input);
		for (int i = 0; i < regex.length; i++) {
			
			
			Pattern pattern=Pattern.compile(regex[i]);
			Matcher matcher=pattern.matcher(input);
			System.out.println("Pattern: "+pattern);
			boolean found=false;
			
			while (matcher.find()) {
				System.out.println("found: \""+ input.substring(matcher.start(),matcher.end())+"\"");
				System.out.println("start " + matcher.start() + " end " +matcher.end() );
				found=true;
				
				
			}
			if(!found) {
				System.out.println("No Match found");
			
			}
			
		}
		
	}

}
