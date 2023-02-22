package com.adventofcode.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day5Q2 {

	final static String inputFile = "2022/day5.txt";
	List<Stack<Character>> listOfStacks = new ArrayList<Stack<Character>>();
	
	Stack<Character> s1 = new Stack<Character>();
	Stack<Character> s2 = new Stack<Character>();
	Stack<Character> s3 = new Stack<Character>();
	Stack<Character> s4 = new Stack<Character>();
	Stack<Character> s5 = new Stack<Character>();
	Stack<Character> s6 = new Stack<Character>();
	Stack<Character> s7 = new Stack<Character>();
	Stack<Character> s8 = new Stack<Character>();
	Stack<Character> s9 = new Stack<Character>();

	public static void main(String... args) throws IOException {
		Day5Q2 solution = new Day5Q2();
		solution.run();
	}

	void run() throws IOException {
		var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
		String result = getFinalStackResult(lines);
		log.warn("Sum Of Priorities : " + result);
	}

	private String getFinalStackResult(List<String> lines) {
		createStack(lines);
        moveCharactersFromStack(lines);
		return null;
	}

	private void moveCharactersFromStack(List<String> lines) {
		for (int i = 10; i < lines.size(); i++) {
			String s = lines.get(i);
			String[] str = s.split(" ");
			// System.out.println("Split array "+Arrays.toString(str));
			int numberOfMoves = Integer.parseInt(str[1]);
			int fromStack = Integer.parseInt(str[3]);
			int toStack = Integer.parseInt(str[5]);
			// List<Character> toAddInOtherStackList = new ArrayList<Character>();
			Stack<Character> tempStack = new Stack<Character>();
			for(int moves=0;moves<numberOfMoves; moves++ ) {
				Stack<Character> fromStackData = listOfStacks.get(fromStack-1);
				tempStack.push(fromStackData.pop());
				// toAddInOtherStackList.add(fromStackData.pop());
			}
			while(!tempStack.isEmpty()) {
				listOfStacks.get(toStack-1).push(tempStack.pop());
//				Stack<Character> toStackData = listOfStacks.get(toStack+1);
//				toStackData.push(tempStack.pop());
			}
//			for(Character newChar : toAddInOtherStackList) {
//				listOfStacks.get(toStack-1).push(newChar);
//				Stack<Character> toStackData = listOfStacks.get(toStack+1);
//				toStackData.push(newChar);
//			}	
			System.out.println("-----Stack(" + (i-4) +") ----");
			System.out.println("Stack 1" +listOfStacks.get(0));
            System.out.println("Stack 2" +listOfStacks.get(1));
            System.out.println("Stack 3" +listOfStacks.get(2));
            System.out.println("Stack 4" +listOfStacks.get(3));
            System.out.println("Stack 5" +listOfStacks.get(4));
            System.out.println("Stack 6" +listOfStacks.get(5));
            System.out.println("Stack 7" +listOfStacks.get(6));
            System.out.println("Stack 8" +listOfStacks.get(7));
            System.out.println("Stack 9" +listOfStacks.get(8));
            System.out.println("---- ----");
		}
		
	}

	private void createStack(List<String> lines) {
		for (int i = 0; i < lines.size(); i++) {
			if (i < 8) {
				String res = lines.get(i).replaceAll(" ", ",");
				StringBuilder sb = new StringBuilder();
                if(!res.isBlank()) {
                	sb.append(res.charAt(1));
    				sb.append(res.charAt(5));
    				sb.append(res.charAt(9));
    				sb.append(res.charAt(13));
    				sb.append(res.charAt(17));
    				sb.append(res.charAt(21));
    				sb.append(res.charAt(25));
    				sb.append(res.charAt(29));
    				sb.append(res.charAt(33));
    				
    				// sb.append(res.charAt(13));
    				System.out.println(sb.toString());
    				String str = sb.toString();
    				for(int k=0;k<str.length(); k++) {
    					char c = str.charAt(k);
    					if(Character.isLetter(c)) {
    						if(k==0) {
    							s1.push(c);
    						} else if (k==1) {
    							s2.push(c);
    						} else if(k==2) {
    							s3.push(c);
    						} else if(k==3) {
    							s4.push(c);
    						} else if(k==4) {
    							s5.push(c);
    						} else if(k==5) {
    							s6.push(c);
    						} else if(k==6) {
    							s7.push(c);
    						} else if(k==7) {
    							s8.push(c);
    						} else if(k==8) {
    							s9.push(c);
    						}
    					}
    				}	
                } 
			}
		}

        //listOfStacks = new ArrayList<Stack<Character>>();
       // Stack<Character> s1Actual = reverseStack(s1);
		listOfStacks.add(reverseStack(s1));
		listOfStacks.add(reverseStack(s2));
		listOfStacks.add(reverseStack(s3));
		listOfStacks.add(reverseStack(s4));
		listOfStacks.add(reverseStack(s5));
		listOfStacks.add(reverseStack(s6));
		listOfStacks.add(reverseStack(s7));
		listOfStacks.add(reverseStack(s8));
		listOfStacks.add(reverseStack(s9));
		System.out.println("--Initial Stack --------");
		System.out.println(listOfStacks);
		System.out.println("--------------------");
	}
	
	private Stack<Character> reverseStack(Stack<Character> stack) {
		Stack<Character> newStack = new Stack<Character>();
		int stackLength = stack.toString().length();
		for(int l=0;l<stackLength;l++) {
			if(!stack.empty()) {
				newStack.push(stack.pop());
			}		
		}
		return newStack;
		
	}

}
