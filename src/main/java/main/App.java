package main;

public class App {

	public static void main(String[] args) {
		
		SeatingPlan.shuffle(SeatingPlan.names);
		ExcelExport.createExcel();
		
	}

}
