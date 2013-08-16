
public class MazePosition {

	private int row=-1;
	
	private int column=-1;
	
	public int getRow(){
		return row;
	}

	public int getColumn(){
		return column;
	}

	public void setRow(int R){
		row=R;
	}

	public void setColumn(int C){
		column=C;
	}

	public boolean equals(MazePosition mp){
		if(this.getColumn()==mp.getColumn() && this.getRow()==mp.getRow())
			return true;
		else return false;
	}
}
