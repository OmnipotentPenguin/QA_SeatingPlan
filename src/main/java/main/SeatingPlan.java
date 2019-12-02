package main;

import java.util.Random;

public class SeatingPlan {
	
	static String[][] names = {
			{"AM","AR","AT","AW","CA","CJ"},
			{"ER","ED","HH","JB","JK","JL"},
			{"JG","LM","LC","LP","LC","LH"},
			{"MF","NV","RR","TK","ZZ","XX"}};


	static String[][] shuffle(String[][] names) {
	    Random random = new Random();

	    for (int i = names.length - 1; i > 0; i--) {
	        for (int j = names[i].length - 1; j > 0; j--) {
	            int m = random.nextInt(i + 1);
	            int n = random.nextInt(j + 1);

	            String temp = names[i][j];
	            names[i][j] = names[m][n];
	            names[m][n] = temp;
	        }
	    }	   
	    
	    return names;
	}
}
