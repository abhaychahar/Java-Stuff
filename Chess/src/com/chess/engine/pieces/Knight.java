package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import static com.chess.engine.board.Move.*;
import com.chess.engine.board.Tile;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection; 

public class Knight extends Piece {
	
	private final static int[] candidateMoveCoordinates= {-17, -15, -10, -6, 6, 10, 15, 17};
	
	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}
	
	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {
		final List<Move> legalMoves=new ArrayList<>();
		
		for(final int currentCandidateOffset: candidateMoveCoordinates) {
			final int candidateDestinationCoordinate=this.piecePosition+currentCandidateOffset;
			
			if(BoardUtils.isValidCoordinate(candidateDestinationCoordinate)) {
				if(isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) || isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) || isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset) || isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)) {
					continue;
				}
				
				final Tile candidateDestinationTile=board.getTile(candidateDestinationCoordinate);
				
				if(!candidateDestinationTile.isTileOccupied()) {
					legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
				}
				else {
					final Piece pieceAtDestination=candidateDestinationTile.getPiece();
					final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
					if(this.pieceAlliance!=pieceAlliance) {
						legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
					}
				}
			}
		}
		
		return legalMoves;
	}
	
	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.firstColumn[currentPosition] && (candidateOffset==-17 || candidateOffset==-10 || candidateOffset==6 || candidateOffset==15);
	}
	
	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.secondColumn[currentPosition] && (candidateOffset==-10 || candidateOffset==6);
	}
	
	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.seventhColumn[currentPosition] && (candidateOffset==-10 || candidateOffset==6);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.eighthColumn[currentPosition] && (candidateOffset==-17 || candidateOffset==-10 || candidateOffset==6 || candidateOffset==15);
	}
	
}
