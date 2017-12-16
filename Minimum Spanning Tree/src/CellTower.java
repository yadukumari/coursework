
public class CellTower {

	private int distance; 
	private int id; 
	private String cityName;
	
	
	public CellTower(int distance, int id, String city) {
		this.distance=distance; 
		this.id=id;
		this.cityName=city;
	}
	
	public int getDistance() {
		return distance;
	}
	public int getId() {
		return id;
	}
	public String getCityName() {
		return cityName;
	}
	public String toString() {
		return "CellTowerID#"+getId()+","+getDistance()+","+getCityName();
		
	}
	
}
