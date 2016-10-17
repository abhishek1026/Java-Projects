import java.util.Scanner;
public class Garage {
	
	Scanner s = new Scanner(System.in);
	
	private int totalSpots;
	
	private int numFloors;
	
	private int[] pSpots;
	
	private String name;
	
	public Garage(String name, int a){
		numFloors = a;
		pSpots = new int[numFloors];
		setName(name);
		
		for(int i=0; i<pSpots.length; i++){
			pSpots[i] = 10;
		}
		
		totalSpots = 10*numFloors;
	}
	
	public void setName(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
	public int getTotalSpots(){
		return totalSpots;
	}
	public int[] getArr(){
		return pSpots;
	}
	public boolean takeSpot(int a){
		if(pSpots[a-1] >= 1){
			pSpots[a-1] -= 1;
			totalSpots-= 1;
			return true;
		}
		return false;	
	}
	public boolean leaveSpot(int a){
		if(pSpots[a-1] <=9){
			pSpots[a-1] += 1;
			totalSpots+= 1;
			return true;
		}
		return false;
	}
	public int getFloors(){
		return numFloors;
	}
	public String toSummary(){
		String result = "";
		
		result += name + "( " + this.getTotalSpots() + " spots available)\n";
		
		return result;
	}
	public String toString(){
		String result = "";
		
		result += name + "( " + this.getFloors() + " floors total)\n";
		
		result += "Total spots available: " + this.getTotalSpots() + "\n";
		
		for(int i =1; i<= this.getFloors(); i++){
			result += "Floor " + i + ": " + pSpots[i-1] + " spots available.\n";
		}
		
		return result;
		
	}
	public boolean getFeedRemove(Garage x, int a){
		System.out.print("Type '1' to confirm and leave app: ");
		if(s.nextInt() == 1)
			return false;
		else
			x.takeSpot(a);
		return true;	
	}
	public boolean getFeedAdd(Garage x, int a){
		System.out.print("Type '1' to confirm and leave app: ");
		if(s.nextInt() == 1)
			return false;
		else
			x.leaveSpot(a);
		return true;	
	}

}
