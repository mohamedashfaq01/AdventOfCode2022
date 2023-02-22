package com.adventofcode.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day1Q1 {
	
	final static String inputFile = "2022/day1.txt";
	
	public static void main(String... args) throws IOException {
		Day1Q1 solution = new Day1Q1();
        solution.run();
    }

    void run() throws IOException {
        var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
        var result = mostCalories(lines);
        log.warn("How many total Calories is that Elf carrying? {}", result);
    }

    public int mostCalories(List<String> inputs) {
        List<Integer> caloriesOfElfs = new ArrayList<>();
        int sum = 0;
        for (String s : inputs) {
            if ("".equals(s)) {
                caloriesOfElfs.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(s);
            }
        }
        return caloriesOfElfs.stream().mapToInt(v -> v).max().getAsInt();
    }

}
