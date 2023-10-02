package com.chess.engine.board;

public class BoardUtils {
	
	public static final boolean[] firstColumn=null;
	public static final boolean[] secondColumn=null;
	public static final boolean[] seventhColumn=null;
	public static final boolean[] eighthColumn=null;
	
	private BoardUtils() {
		throw new RuntimeException("You cannot instantiate me");
	}
	
	public static boolean isValidCoordinate(int coordinate) {
		return coordinate>=0 && coordinate<64;
	}

}
