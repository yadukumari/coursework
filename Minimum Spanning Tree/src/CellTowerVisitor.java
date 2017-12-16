
public class CellTowerVisitor implements Visitor<CellTower> {

	@Override
	public void visit(CellTower cellTower) {
		System.out.println("cellTower = " + cellTower.getCellCityName() + " was visited");
	}

}
