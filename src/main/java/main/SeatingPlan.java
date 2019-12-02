package main;

import java.util.Random;

public class SeatingPlan {
	
	public static String[][] names = {
			{"AM","AR","AT","AW","CA","CJ"},
			{"ER","ED","HH","JB","JK","JL"},
			{"JG","LM","LC","LP","LC","LH"},
			{"MF","NV","RR","TK","ZZ","XX"}};

	public static String[][] shuffle(String[][] names) {
	    Random random = new Random();

	    for (int row = names.length - 1; row > 0; row--) {
	        for (int seat = names[row].length - 1; seat > 0; seat--) {
	            int newRow = random.nextInt(row + 1);
	            int newSeat = random.nextInt(seat + 1);

	            String temp = names[row][seat];
	            names[row][seat] = names[newRow][newSeat];
	            names[newRow][newSeat] = temp;
	        }
	    }	    
	    return names;
	}
}
