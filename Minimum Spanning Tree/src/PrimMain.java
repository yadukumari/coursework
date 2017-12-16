import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

//Program merge by Xanthia and yadukumari
//Xanthia Victuelles
public class PrimMain {
	public static Scanner userScanner = new Scanner(System.in);

	public static void main(String[] args) {

		MinimumSpanningTree<CellTower> primGraph = new MinimumSpanningTree<>(); // MST
																				// instantiated
		if (readFile(primGraph)) { // if the file is read successfully then
									// menus will appear
			mainMenus(primGraph);
		}

	}

	public static boolean readFile(MinimumSpanningTree<CellTower> m1) {

		/*
		 * Reading the file, calling the openInputFile, and populating the graph
		 */
		try {
			Scanner console = openInputFile();
			CellTower cell1 = null;
			CellTower cell2;
			while (console.hasNext()) {
				String c1 = console.next();
				String c2 = console.next();
				double weight = console.nextDouble();

				cell1 = new CellTower(c1);
				cell2 = new CellTower(c2);
				m1.addEdge(cell1, cell2, weight);
			}

			return true;
		} catch (Exception e) {
			System.out.println("\n\nUnable to read file.");
		}
		return false;

	}

	@SuppressWarnings("resource")
	public static void mainMenus(MinimumSpanningTree<CellTower> m1) {

		/*
		 * Menus for the graph NOTE: The traversals are needed in order to
		 * preview BOTH the graph and the minimum spanning tree. RIGHT NOW, we
		 * need menus 2,3,5: The delete celltower menu#(2), the Show Existing
		 * graph menu#(3),and the Show Minimum spanning tree menu#(5).
		 * 
		 **/

		int choice = 7;
		do {
			System.out.println("\n---------------------------------" + "\n| Prim's Algorithms' Main Menu: |"
					+ "\n---------------------------------" + "\n" + "1.Add a New CellTower connection to the Graph\n"
					+ "2.Delete Existing CellTower\n" + "3.Show Existing Graph\n" + "4.Show Adjacency List\n"
					+ "5.Show The Minimum Spanning Tree\n" + "6.Undo remove\n" + "7.Exit");

			System.out.print("\n\nPlease enter your choice:");

			try {
				Scanner input = new Scanner(System.in);
				choice = input.nextInt(); // try catch
			} catch (InputMismatchException e) {
				System.out.println("Not a Number!");
			}

			switch (choice) {
			case 1: // add
				addToGraphMenu(m1);
				break;
			case 2: // delete existing cellTower
				removeFromGraphMenu(m1);
				break;
			case 3:// show graph
				traversal(m1);
				break;
			case 4:// Show adjacency list
				m1.showAdjTable();
				writeFile(m1);
				break;
			case 5:// Show minimum spanning tree
				ArrayList<Edge<CellTower>> results = m1.applyPrim();
				for (int i = 0; i < results.size(); i++) {
					System.out.println(results.get(i));
				}
				break;
			case 6:// exit
				m1.undoRemoval();
				m1.showAdjTable();
				break;
			case 7:
				System.out.println("\n\nProgram ended.");
				break;
			default:
				break;
			}
		} while (choice != 7);

	}

	public static void addToGraphMenu(MinimumSpanningTree<CellTower> m1) {
		@SuppressWarnings("resource")

		Scanner userIn = new Scanner(System.in);
		String city1, city2;
		double distance;
		System.out.println("1. Add a new CellTower connection to the Graph");

		System.out.print("\nEnter CellTower1 Name:");
		city1 = userIn.nextLine();
		CellTower addC1 = new CellTower(city1);

		System.out.print("\nEnter CellTower2 Name:");
		city2 = userIn.nextLine();
		CellTower addC2 = new CellTower(city2);

		System.out.print("\nEnter the distance between CellTowers:");
		distance = userIn.nextDouble();

		m1.addEdge(addC1, addC2, distance);
		System.out.println("Added Successfully! ");
	}

	public static void removeFromGraphMenu(MinimumSpanningTree<CellTower> m1) {

		@SuppressWarnings("resource")
		Scanner userIn = new Scanner(System.in);
		String city1, city2;
		CellTower obj1, obj2;
		Vertex<CellTower> ver1, ver2;
		Iterator<Entry<CellTower, Pair<Vertex<CellTower>, Double>>> edgeIter;
		Pair<Vertex<CellTower>, Double> singleEdge = null;
		double weight = 0;

		System.out.println("1. Enter the CellTower you want to want to remove");

		System.out.print("\nEnter CellTower1 Name:");

		city1 = userIn.nextLine();
		obj1 = new CellTower(city1);
		ver1 = new Vertex<>(obj1);

		System.out.print("\nEnter CellTower2 Name:");
		city2 = userIn.nextLine();
		obj2 = new CellTower(city2);
		ver2 = new Vertex<>(obj2);

		Vertex<CellTower> source = null;
		Iterator<Entry<CellTower, Vertex<CellTower>>> vertexIter;

		// Find starting vertex
		for (vertexIter = m1.vertexSet.entrySet().iterator(); vertexIter.hasNext();) {
			source = vertexIter.next().getValue();
			if (source.equals(ver1)) {
				break;
			}
		}

		for (edgeIter = source.adjList.entrySet().iterator(); edgeIter.hasNext();) {
			singleEdge = edgeIter.next().getValue();
			if (singleEdge.first == null) {
				System.out.println("This path doesn't exists in the graph ");
				System.out.println("Unable to remove");
				return;
			} else if (singleEdge.first.equals(ver2)) {
				weight = singleEdge.second;
				System.out.println(weight);
				break;
			}
		}
		if (m1.remove(ver1.getData(), ver2.getData())) {

			m1.undoAdd(ver1, ver2, weight);
			System.out.println("Removed " + obj1.toString() + " to " + obj2.toString() + " successfully!");

		} else
			System.out.println("Unable to remove");
	}

	public static void traversal(MinimumSpanningTree<CellTower> m1) {
		Vertex<CellTower> startElement = getStartingVertex(m1);
		m1.breadthFirstTraversalHelper(startElement, new CellTowerVisitor());
	}

	private static Vertex<CellTower> getStartingVertex(MinimumSpanningTree<CellTower> m) {
		Vertex<CellTower> source = null;
		Iterator<Entry<CellTower, Vertex<CellTower>>> vertexIter;

		// Find starting vertex
		for (vertexIter = m.vertexSet.entrySet().iterator(); vertexIter.hasNext();) {
			source = vertexIter.next().getValue();
			if (source != null) {
				break;
			}
		}

		return source;
	}

	// opens a text file for input, returns a Scanner:
	public static Scanner openInputFile() {
		String filename;
		Scanner scanner = null;

		// System.out.print("Enter the input filename: ");
		filename = "CellTowers1.txt";// userScanner.nextLine();
		File file = new File(filename);

		try {
			scanner = new Scanner(file);
		} // end try
		catch (FileNotFoundException fe) {
			System.out.println("Can't open input file\n");
			return null; // array of 0 elements
		} // end catch
		return scanner;
	}
	public static void writeFile(MinimumSpanningTree<CellTower> m1){
	          Scanner scan = new Scanner(System.in);
		        String wf;
		        System.out.print("Would you like to write to a file? (Y/y): ");
		        wf = scan.next();
		       
		        if (wf.equals("y") || wf.equals("Y")) {
		            System.out.print("What file would you like to write to? ");
		            String fileName = scan.next();
		            
		            try {
		                 m1.writeToFile(new PrintStream(new FileOutputStream(fileName)));
		                } catch (FileNotFoundException e) {
		                    System.err.println ("Unable to write to file");
		                    }
		        }
	}

	 

}
