package geekbrains.java_level2;

import java.util.*;

public class FirstExcercise {


    public static void main(String[] args) {


	String[] wordArray  = {"banana", "apple", "apple", "orange", "strawberry", "carrot",
            "leak", "leak", "potato", "potato"};

	Set<String> wordSet = new HashSet<>(Arrays.asList(wordArray));
	System.out.println(wordSet);

	HashMap<String, Integer> hashMap = new HashMap<>();
	for (String word : wordArray){
		Integer count = hashMap.get(word);
		if (count == null) hashMap.put(word, 1);
		else {
			hashMap.put(word, count + 1);
		}
	}

	System.out.println(hashMap);

    }
}
