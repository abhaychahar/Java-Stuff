package com.chess.engine.board;

import java.util.Map;
import java.util.HashMap;
import com.chess.engine.pieces.Piece;

public abstract class Tile {

	protected final int tileCoordinate;
	private static final Map<Integer, EmptyTile> emptyTilesCache=createAllPossibleEmptyTiles();
	
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap=new HashMap<>();
		
		for(int i=0; i<BoardUtils.numTiles; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		
		return emptyTileMap;
	}
	
	public static Tile createTile(final int tileCoordinate, final Piece piece) {
		return piece!=null ? new OccupiedTile(tileCoordinate, piece) : emptyTilesCache.get(tileCoordinate);
	}
	
	private Tile(final int tileCoordinate) {
		this.tileCoordinate=tileCoordinate;
	}
	
	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {
		
		private EmptyTile(int tileCoordinate) {
			super(tileCoordinate);
		}
		
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
		
	}
	
	public static final class OccupiedTile extends Tile {
		
		private final Piece pieceOnTile;
		
		private OccupiedTile(int tileCoordinate, final Piece pieceOnTile) {
			super(tileCoordinate);
			this.pieceOnTile=pieceOnTile;
		}
		
		@Override
		public boolean isTileOccupied() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return pieceOnTile;
		}
		
	}
}
