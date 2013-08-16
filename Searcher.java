public class Searcher extends Thread {

	public Searcher (SearchableMaze m, MazePosition from, Trail following, Tracker tr) {
	super("Searcher Thread");
    myMaze = m;
    currentPosition = from;
    onTrail = following.clone();
    tr.newSearcher();
    terminationControl = tr;
    previous=new MazePosition();
    previous.setColumn(-1);
    previous.setRow(-1);
	} 

	private SearchableMaze myMaze;
	private MazePosition currentPosition, previous;
	private Trail onTrail;
	private Tracker terminationControl;

	public void run () {

		MazePosition[] moves;
		int count;
		Searcher s;
		do { // Loop until no more moves.
			count = -1;
		    // Get the next valid moves.
		    moves = onTrail.mark(currentPosition);
		    for (int index = 0; index < moves.length; index++) {
		      // For each valid move.
		    	if(moves[index] != null)
		        if(!moves[index].equals(previous))
		        	if(!onTrail.visited(moves[index] )) {
		             // Have not visited here before.
		        		if(count == -1) count = index;
		        		else {
		              // More than one path, so create a new thread.
		        			s = new Searcher(myMaze, moves[index],
		                       onTrail, terminationControl);
		        			s.start ();
		        		}
		        	}
		    }
		    if(count != -1) {
		    	previous = currentPosition;
		    	currentPosition = moves [count];
		    }
		} while(count != -1);
		if(myMaze.atExit(currentPosition))
			terminationControl.trailFound(onTrail);
		else
			terminationControl.searcherFinished();
		} // end run
	
}