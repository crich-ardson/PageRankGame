
public class gameMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the PageRank Guesser\n");
		System.out.println("Play through 10 rounds guessing what page you would most likely click on!\n");
		
		play();
		
		gameRoundBuilder.finalScreen();
		gameRoundBuilder.correctDisplay();
	}
	
	public static void play() throws Exception{
		for(int i = 0; i < 10; i++) {
			System.out.println("Round " + Integer.toString(i+1) + "\n");
			gameRoundBuilder.round();
		}	
	}

}
