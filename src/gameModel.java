
public class gameModel {
	private double rank;
	private String name;
	private boolean used;
	private double score;
	
	public gameModel(double rank, double score, String name, boolean used) {
		this.rank = rank;
		this.score = score;
		this.name = name;
		this.used = used;
	}
	
	public double getRank() {return rank;}
	public String getName() {return name;}
	public boolean getUsage() {return used;}
	public void setUsage(boolean newUsage) {this.used = newUsage;}
	public void setScore(double newscore) {this.score = newscore;}
}
