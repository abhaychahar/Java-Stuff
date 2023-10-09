package com.chess.engine.board;

public class BoardUtils {
	
	public static final boolean[] firstColumn=iniColumn(0);
	public static final boolean[] secondColumn=iniColumn(1);
	public static final boolean[] seventhColumn=iniColumn(6);
	public static final boolean[] eighthColumn=iniColumn(7);
	
	public static final boolean[] secondRow=null;
	public static final boolean[] seventhRow=null;
	
	public static final int numTiles=64;
	public static final int numTilesPerRow=8;
	
	private static boolean[] iniColumn(int columnNumber) {
		final boolean[] column=new boolean[64];
		
		do {
			column[columnNumber]=true;
			columnNumber+=numTilesPerRow;
		} while(columnNumber<numTiles);
		
		return column;
	}
	
	private BoardUtils() {
		throw new RuntimeException("You cannot instantiate me");
	}
	
	public static boolean isValidCoordinate(final int coordinate) {
		return coordinate>=0 && coordinate<numTiles;
	}

}
