import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class SearchableMaze extends Maze{

	private Tracker tracker;
	
	public SearchableMaze(File lbr) throws Exception {
		super(lbr);
	}
	
	public SearchableMaze(File lbr, Tracker tr) throws Exception {
		super(lbr);
		tracker=tr;
	}

	public MazePosition entrance(){
		return super.arrl.get(0);
	}

	public boolean atExit(MazePosition mp){
		return mp.equals(super.arrl.get(super.arrl.size()-1));
	}
		
	public MazePosition[] next(MazePosition from){
		ArrayList<MazePosition> mpa=new ArrayList<MazePosition>();
		Iterator<MazePosition> it=super.arrl.listIterator();
		while(it.hasNext()) {
			MazePosition check = it.next();
			if((check.getColumn()==from.getColumn() && (check.getRow()-1==from.getRow() || check.getRow()+1==from.getRow())) || (check.getRow()==from.getRow() && (check.getColumn()-1==from.getColumn() || check.getColumn()+1==from.getColumn()))){
				mpa.add(check);
			}
		}
		return mpa.toArray(new MazePosition[mpa.size()]);
	}
	
}
