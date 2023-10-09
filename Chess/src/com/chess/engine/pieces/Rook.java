package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.chess.engine.board.Move.AttackMove;
import com.chess.engine.board.Move.MajorMove;

public class Rook extends Piece {
	
	private final static int[] candidateMoveVectorCoordinates={-8, -1, 1, 8};

	Rook(int piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {
		final List<Move> legalMoves=new ArrayList<>();
		
		for(final int currentCandidateOffset: candidateMoveVectorCoordinates) {
			int candidateDestinationCoordinate=this.piecePosition;
			
			while(BoardUtils.isValidCoordinate(candidateDestinationCoordinate)) {
				if(isFirstColumnExclusion(candidateDestinationCoordinate, currentCandidateOffset) || isEighthColumnExclusion(candidateDestinationCoordinate, currentCandidateOffset)) {
					break;
				}
				
				candidateDestinationCoordinate+=currentCandidateOffset;
				
				if(BoardUtils.isValidCoordinate(candidateDestinationCoordinate)) {
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
						break;
					}
				}
			}
		}
		
		return legalMoves;
	}
	
	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.firstColumn[currentPosition] && (candidateOffset==-1);
	}
	
	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.firstColumn[currentPosition] && (candidateOffset==1);
	}
	
}
