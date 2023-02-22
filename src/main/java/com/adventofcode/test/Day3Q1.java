package com.adventofcode.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day3Q1 {

	final static String inputFile = "2022/day3.txt";

	public static void main(String... args) throws IOException {
		Day3Q1 solution = new Day3Q1();
		solution.run();
	}

	void run() throws IOException {
		var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
		int result = getSumOfPriorities(lines);
		log.warn("Sum Of Priorities : " + result);
	}

	private int getSumOfPriorities(List<String> lines) {
		Map<Character, Integer> map = addAllAlphabetInHashMap();
		int totalPriority = 0;
		for (String s : lines) {
			Character ch = getCommonCharacter(s);
			int priority = map.get(ch);
			totalPriority+=priority;
		}
		return totalPriority;
	}

	private Character getCommonCharacter(String str) {
		final int mid = str.length() / 2;
		String s1 = str.substring(0, mid);
		String s2 = str.substring(mid);
		Character commonChar = null;
		Set<Character> s1Set = new HashSet<>();
		for (Character c1 : s1.toCharArray()) {
			s1Set.add(c1);
		}
		for (Character c2 : s2.toCharArray()) {
			if(s1Set.contains(c2)) {
				commonChar = c2;
				break;
			}
		}
		
		return commonChar;
	}

	private Map<Character, Integer> addAllAlphabetInHashMap() {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int priorityNum = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			map.put(c, ++priorityNum);
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			map.put(c, ++priorityNum);
		}

		map.forEach((K, V) -> System.out.println("Key: " + K + ", Value : " + V));
		return map;

	}

}
