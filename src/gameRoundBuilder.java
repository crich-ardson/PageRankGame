import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class gameRoundBuilder {
	static ArrayList<Double> rankList = new ArrayList<Double>();
	static ArrayList<String> nameList = new ArrayList<String>();
	static ArrayList<Double> scores = new ArrayList<Double>();
	static ArrayList<Double> userScore = new ArrayList<Double>();
	static ArrayList<Double> maxScore = new ArrayList<Double>();
	static ArrayList<String> userAnswerL = new ArrayList<String>();
	static ArrayList<String> correctAnswerL = new ArrayList<String>();

	
	public static void round() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<gameModel> game = modelReader.buildGameModel();
		int len = game.size();
		try {
//		ArrayList<gameModel> game = modelReader.buildGameModel();
		buildRound(len, game);
		buildScores();
		displayList(nameList);
		String correctAnswer = findAnswer();
		correctAnswerL.add(correctAnswer);
		String userAnswer = getAnswer();
		userAnswerL.add(userAnswer);
		
		if(checkAnswer(correctAnswer, userAnswer)) {
			System.out.println("You are correct!\n");
		}
		else {
			System.out.println("\nSorry, but the correct answer is "+ correctAnswer +"\n");
		}
		
		userScore.add(scoreAnswer(userAnswer));
		maxScore.add(scoreAnswer(correctAnswer));
		
		rankList.clear();
		nameList.clear();
		
		}
		
		catch (Exception e){
			System.out.println(e);
		}
		

	}
	
	public static void buildRound(int arrayLength, ArrayList<gameModel> options) {
		gameModel holder;
		Random rand = new Random();
		int randPick;
		
		for(int i = 0; i < 5; i++) {
			randPick = rand.nextInt(arrayLength);
			holder = options.get(randPick);
			if(holder.getUsage() == true) {
				holder = options.get(rand.nextInt(arrayLength));
			}
			holder.setUsage(true);
			rankList.add(holder.getRank());
			nameList.add(holder.getName());
		}
	}
	
	public static void displayList(ArrayList<String> stringList) {
		for(String elem : stringList) {
			System.out.println(elem);
		}
	}
	
	public static void displayRanks(ArrayList<Double> rankScore) {
		for(Double elem : rankScore) {
			System.out.println(elem.toString());
		}
	}
	
	public static void displayScores(ArrayList<Double> scores) {
		double sum = 0.0;
		for(Double elem : scores) {
			sum += elem;
		}
		System.out.println(Double.toString(sum));
	}
	
	public static String findAnswer() {
		double max;
		int maxPos;
		String maxName;
		max = Collections.max(rankList);
		maxPos = rankList.indexOf(max);
		maxName = nameList.get(maxPos);
		
		return maxName;
	}
	
	public static String getAnswer() {
		Scanner test = new Scanner(System.in);
		System.out.println("\nYour Answer: ");
		String userAnswer = test.nextLine();
		String nextTry = "";
		if(!nameList.contains(userAnswer)) {
			while (!nameList.contains(nextTry)) {
				System.out.println("Please enter a choice from above: ");
				nextTry = test.nextLine();
			}
			userAnswer = nextTry;
	}	
		//test.reset();
		//test.close();
		return userAnswer;
	}
	
	public static boolean checkAnswer(String correctAnswer,String userAnswer) {
		return (correctAnswer.equals(userAnswer));
	}
	
	public static void buildScores() {
		double tally = 0.0;
		double score = 0.0;
		for (double e : rankList) {
			tally += e;
		}
		for (int i = 0; i < 5; i++) {
			score = 100 * Math.pow(10.0,-((rankList.get(i))/tally));
			scores.add(score);
		}
	}
	
	public static Double scoreAnswer(String answer) {
		int pos = 0;
		double ascore = 0.0;
		pos = nameList.indexOf(answer);
		ascore = scores.get(pos);
		
		return ascore;
		
	}
	
	public static void finalScreen() {
		System.out.println("The game is over!");
		System.out.println("\n");
		System.out.println("Points per Question: ");
		displayRanks(userScore);
		System.out.println("\nTotal Points: ");
		displayScores(userScore);
		System.out.println("\n");
		//System.out.println("User Answers: ");
		//displayList(userAnswerL);
	}
	
	public static void correctDisplay() {
		System.out.println("\nCorrect Answers for this game: ");
		displayList(correctAnswerL);
		System.out.println("\n");
		System.out.println("Max Points per Question: ");
		displayRanks(maxScore);
		//System.out.println("\nMaximum Points: ");
		//displayScores(maxScore);
	}

}
