import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class Maze {
	
	protected ArrayList<MazePosition> arrl=new ArrayList<MazePosition>();

public Maze(File lbr) throws Exception{
	if(lbr==null){
		throw new Exception("File cannot be null");
	}
	if(!lbr.canRead()){
		throw new Exception("File cannot be read");
	}
	else{
		BufferedReader br = new BufferedReader(new FileReader(lbr));
		String str=br.readLine();
		int rowCounter=0;
		MazePosition exit=new MazePosition();
		while (str!=null){
			rowCounter++;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='o'){
					MazePosition mp=new MazePosition();
					mp.setRow(rowCounter);
					mp.setColumn(i+1);
					arrl.add(mp);
				}
				else if(str.charAt(i)=='i'){
					MazePosition mp=new MazePosition();
					mp.setRow(rowCounter);
					mp.setColumn(i+1);
					arrl.add(0, mp);
				}
				else if(str.charAt(i)=='e'){
					exit.setRow(rowCounter);
					exit.setColumn(i+1);
				}
			}
			str=br.readLine();
		}
		arrl.add(arrl.size(),exit);
		br.close();
	}
}

}
