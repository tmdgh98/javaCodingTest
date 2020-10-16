package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		
		String word = "철수랑 영희랑 밥을 먹는다";
		String[] word2 = word.split(" ");
		String a = Arrays.toString(word2);
		System.out.println(a);
		for(String i : word2) {
			System.out.println(i);
		}
		
		//1 2 3 4 5 
		//{"1", "2", "3", "4", "5"}
		//1 = Integer.parseInt("1");
		
	}
}
