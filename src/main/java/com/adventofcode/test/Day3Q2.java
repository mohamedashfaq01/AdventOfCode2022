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
public class Day3Q2 {

	final static String inputFile = "2022/day3.txt";

	public static void main(String... args) throws IOException {
		Day3Q2 solution = new Day3Q2();
		solution.run();
	}

	void run() throws IOException {
		var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
		int result = getSumOfPriorities(lines);
		log.warn("Sum Of Priorities : " + result);
	}

	private int getSumOfPriorities(List<String> lines) {
		int totalGroups = lines.size()/3;
		
		Map<Character, Integer> map = addAllAlphabetInHashMap();
		int totalPriority = 0;
		Character c = getCommonCharacterFromGroup(lines.subList(0, 3));
		int priority = map.get(c);
		totalPriority+=priority;
		System.out.println(c);
		for (int i=1; i<totalGroups; i++) {		
			Character ch = getCommonCharacterFromGroup(lines.subList(i*3, (i+1)*3));
			priority = map.get(ch);
			totalPriority+=priority;
			System.out.println(ch);
		}
		return totalPriority;
	}

	private Character getCommonCharacterFromGroup(List<String> subList) {
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		Character commonChar = null;
		
		for (Character c1 : subList.get(0).toCharArray()) {
			set1.add(c1);
		}
		for (Character c2 : subList.get(1).toCharArray()) {
			set2.add(c2);
		}
		for (Character c3 : subList.get(2).toCharArray()) {
			if(set1.contains(c3) && set2.contains(c3)) {
				commonChar = c3;
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
