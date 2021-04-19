
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestBoard {

	
	@Test
	public void winnerX() {
		TicTacToe tic = new TicTacToe(4,5,3);
		assertEquals(false, tic.checkForWinner(0,"X"));
	}
	
	@Test
	public void winnerO() {
		TicTacToe tic = new TicTacToe(5,6,4);
		assertEquals(false, tic.checkForWinner(0,"O"));
	}
	
	@Test
	public void isMultipleFalse() {
		TicTacToe tic = new TicTacToe(5,5,2);
		assertEquals(false, tic.isMultiple(15, 15, 4));
	}
	
	@Test 
	public void isMultipleTrue() {
		TicTacToe tic = new TicTacToe(10,10,4);
		assertEquals(true, tic.isMultiple(15, 30, 15));
	}
	
	@Test
	public void testScale() {
		TicTacToe tic = new TicTacToe(3,3,2); 
		assertEquals(120, tic.scaleButton());
		TicTacToe tic1 = new TicTacToe(5,5,3);
		assertEquals(60, tic1.scaleButton());
		TicTacToe tic2 = new TicTacToe(10,9,3);
		assertEquals(12, tic2.scaleButton());
	}
	

}
