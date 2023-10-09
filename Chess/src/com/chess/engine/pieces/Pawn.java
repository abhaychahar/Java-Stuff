package com.chess.engine.pieces;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Move.MajorMove;

public class Pawn extends Piece {
	
	private final int[] candidateMoveCoordinates={7, 8, 9, 16};
	
	Pawn(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {
		final List<Move> legalMoves=new ArrayList<>();
		
		for(final int currentCandidateOffset: candidateMoveCoordinates) {
			final int candidateDestinationCoordinate=this.piecePosition+(this.pieceAlliance.getDirection()*currentCandidateOffset);
			
			if(!BoardUtils.isValidCoordinate(candidateDestinationCoordinate)) {
				continue;
			}
			
			if(currentCandidateOffset==8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
				legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
			}
			else if(currentCandidateOffset==16 && this.isFirstMove() && (BoardUtils.secondRow[this.piecePosition] && this.getPieceAlliance().isBlack()) || (BoardUtils.seventhRow[this.piecePosition] && this.getPieceAlliance().isWhite())) {
				final int behindCandidateDestinationCoordinate=this.piecePosition+this.pieceAlliance.getDirection()+8;
				if(!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied() && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
				}
			}
			else if(currentCandidateOffset==7 && !((BoardUtils.eighthColumn[this.piecePosition] && this.pieceAlliance.isWhite()) || (BoardUtils.firstColumn[this.piecePosition] && this.pieceAlliance.isBlack()))) {
				if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					final Piece pieceOnCandidate=board.getTile(candidateDestinationCoordinate).getPiece();
					if(this.pieceAlliance!=pieceOnCandidate.getPieceAlliance()) {
						legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
					}
				}
			}
			else if(currentCandidateOffset==9 && !((BoardUtils.firstColumn[this.piecePosition] && this.pieceAlliance.isWhite()) || (BoardUtils.eighthColumn[this.piecePosition] && this.pieceAlliance.isBlack()))) {
				if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					final Piece pieceOnCandidate=board.getTile(candidateDestinationCoordinate).getPiece();
					if(this.pieceAlliance!=pieceOnCandidate.getPieceAlliance()) {
						legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
					}
				}
			}
		}
		
		return legalMoves;
	}

}