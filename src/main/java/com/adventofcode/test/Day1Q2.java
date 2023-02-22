package com.adventofcode.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day1Q2 {
	
	final static String inputFile = "2022/day1.txt";
	
	public static void main(String... args) throws IOException {
		Day1Q2 solution = new Day1Q2();
        solution.run();
    }

    void run() throws IOException {
        var lines = Resources.readLines(ClassLoader.getSystemResource(inputFile), Charsets.UTF_8);
        int result = mostCalories(lines);
        log.warn("Sum of top three calories", result);
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
        List<Integer> top3CaloriesList = caloriesOfElfs.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        Integer sumOf3Calories = top3CaloriesList.stream().mapToInt(Integer::intValue).sum();
        log.info("sumOf3Calories: "+sumOf3Calories);
        return sumOf3Calories.intValue();
    }

}
