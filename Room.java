public class Room
{
	private char specialItem;
    private int row;
    private int column;
    
    
	public Room(int row,int column,char itemLetter) {
		setRow(row);
		setColumn(column);
		if(itemLetter == ' ') {
			specialItem = getRandomChar();
		}
    }

    public char getRandomChar() {
		if(Math.random() <= .68) {
			int choice;

			choice = (int)(Math.random() * 3) + 1;

			switch(choice) {
				case 1: return 'P';

				case 2: return 'L';

				case 3: return 'M';

				default: return 'M';
			}
		}
		else
			return ' ';
	}

    public void setColumn(int columnnumber) {
		this.column = columnnumber;
	}
    
	public void setRow(int rownumber) {
		this.row = rownumber;
	}

	public char getitem() {
		return specialItem;
	}
	public void setItem(char itemLetter) {
		this.specialItem = itemLetter;
	}

    public String toString() {
    	String layOut = " ";
    	if(row == 0 && column == 0) {
    		layOut="***\n*" + specialItem +"|\n*-*";
    	}
    	
    	if(row == 0 && column == 4) {
    		layOut="**\n|" + specialItem + "*\n*-*";
    	}
    	
    	if(row == 4 && column == 4) {
    		layOut="*-*\n|" + specialItem +"*\n**";
    	}
    	
		if(row == 4 && column == 0) {
			layOut="*-*\n*" + specialItem + "|\n**";
		}
		
		if(row == 0 && (column > 0 || column < 4)) {
			layOut="**\n|" + specialItem +"|\n*-*";
		}
		
		if(row == 4 && (column > 0 || column < 4)) {
			layOut="*-*\n|" + specialItem + "|\n**";
		}
		
		if((row > 0 || row < 4)&& column == 0) {
			layOut="*-*\n*" + specialItem + "|\n*-*";
		}
		
		if((row > 0 || row<4) && column == 4) {
			layOut="*-*\n|" + specialItem + "*\n*-*";
		}
		
		if((row > 0 || row < 4) && (column > 0 || column < 4)) {
			layOut="*-*\n|" + specialItem + "|\n*-*";
		}
		return layOut;
    }

	public int getRow() {
		// TODO Auto-generated method stub
		return row;
	}

	public int getColumn() {
		// TODO Auto-generated method stub
		return column;
	}
}
