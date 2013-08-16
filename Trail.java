import java.util.ArrayList;

public class Trail {

	private Maze maze;
	private ArrayList<MazePosition> trailPositions=new ArrayList<MazePosition>();
	
	public Trail(Maze m){
		maze=m;
	}
	
	public Trail(Trail tr){
		maze=tr.maze;
		trailPositions=tr.trailPositions;
	}
	
	public Trail clone(){
		return new Trail(this);
	}

	public boolean visited(MazePosition mp){
		if(trailPositions.contains(mp)){
			return true;
		} else return false;
	}

	public MazePosition [] mark(MazePosition mp){
		trailPositions.add(mp);
		return ((SearchableMaze)maze).next(mp);
	}

}