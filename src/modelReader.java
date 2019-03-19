import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class modelReader {

	public static ArrayList<gameModel> buildGameModel() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<gameModel> modelList = new ArrayList<gameModel>();
		gameModel model;
		String lineText = "";
		double in = 0.0;
		String inName = "";
		StringBuilder db = new StringBuilder();
		StringBuilder nb = new StringBuilder();
		File file = 
				new File("C:\\Users\\Cameron\\Documents\\Algorithms\\wikipedia-top-pageranks2.txt");
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			lineText = sc.nextLine();
			for(int i = 0; i <= 6; i++) {
				db.append(lineText.charAt(i));
			}
			for(int i = 7; i <= lineText.length()-1; i++) {
				nb.append(lineText.charAt(i));
			}
			in = Double.parseDouble(db.toString());
			inName = nb.toString();
			model = new gameModel(in, 0.0,inName, false);
			modelList.add(model);
			//System.out.println(Double.toString(in));
			//System.out.println(inName);
			db.setLength(0);
			nb.setLength(0);
		}
		sc.close();
		return modelList;
	}
	

}
