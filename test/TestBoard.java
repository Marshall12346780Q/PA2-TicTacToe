
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestBoard {

	@Test
	public void winnerX() {
		TicTacToe tic = new TicTacToe();
		assertEquals(true, tic.hasWinner("X"));
	}
	
	@Test
	public void winnerO() {
		TicTacToe tic = new TicTacToe();
		assertEquals(true, tic.hasWinner("O"));
	}
	
	@Test
	public void draw() {
		TicTacToe tic = new TicTacToe();
		assertEquals(true, tic.hasWinner("draw"));
	}
	
}
