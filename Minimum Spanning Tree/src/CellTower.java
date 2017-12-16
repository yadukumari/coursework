
public class CellTower {

	private String cellCityName;

	public CellTower() {
		cellCityName = null;
	}

	CellTower(String c1) {
		cellCityName = c1;
	}

	public String getCellCityName() {
		return cellCityName;
	}

	public void setCellCityName(String cellCityName) {
		this.cellCityName = cellCityName;
	}

	public String toString() {
		return cellCityName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellCityName == null) ? 0 : cellCityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellTower other = (CellTower) obj;
		if (cellCityName == null) {
			if (other.cellCityName != null)
				return false;
		} else if (!cellCityName.equals(other.cellCityName))
			return false;
		return true;
	}
	
	

}
