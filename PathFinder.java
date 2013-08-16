import java.io.File;
import java.io.FileNotFoundException;


public class PathFinder {

	public static void main(String [] args){
		try{
			Tracker tr = new Tracker();
			SearchableMaze sm = new SearchableMaze(new File(".\\src\\"+args[0]), tr);
			Trail t = new Trail(sm);
			Searcher s = new Searcher(sm, sm.entrance(), t, tr);
			s.start();
			int numberOfSolutions = tr.waitAllFinished();
		// Call user interface classes to display solutions.
		}
		catch(FileNotFoundException e){
			System.out.println("Attach a correct labyrinth file and execute under a folder src. Eg: .\\src> java PathFinder labyrinth.lbr");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
