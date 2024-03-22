import static org.junit.Assert.*;
import org.junit.Test;

public class TennisGameTest {
  
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test  
    public void testPlayer1WinsPointAfterGameEnded_ShouldThrowException() throws TennisGameException {  
        // Arrange  
        TennisGame game = new TennisGame();  
        game.player1Scored();  
        game.player1Scored();  
        game.player1Scored();  
        game.player1Scored();   
  
        assertThrows(TennisGameException.class, () -> game.player1Scored());  
    }  
  
    @Test  
    public void testPlayer2WinsPointAfterGameEnded_ShouldThrowException() throws TennisGameException {  
        // Arrange  
        TennisGame game = new TennisGame();  
        game.player2Scored();  
        game.player2Scored();  
        game.player2Scored();  
        game.player2Scored();  
    
        assertThrows(TennisGameException.class, () -> game.player2Scored());  
    }  
    
	@Test 
	public void testTennisGame_GameResults_p1_wins() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		assertEquals("player1 wins", game.getScore());
	}
	
	@Test
	public void testTennisGame_GameResults_p2_wins() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		assertEquals("player2 wins", game.getScore());
	}
	
	@Test
	public void testTennisGame_player1_has_advantage_4_3() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		assertEquals("player1 has advantage", game.getScore());
	}
	
	@Test
	public void testTennisGame_player2_has_advantage_4_3() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		assertEquals("player2 has advantage", game.getScore());
	}
	
	@Test
	public void testTennisGame_score0() throws TennisGameException{
		TennisGame game = new TennisGame();
		assertEquals("love - love", game.getScore());
	}
	
	@Test
	public void testTennisGame_score1() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		assertEquals("love - 15", game.getScore());
	}
	
	@Test
	public void testTennisGame_score2() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		assertEquals("love - 30", game.getScore());
	}
	
	@Test
	public void testTennisGame_score3() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("love - 40", game.getScore());
	}
}
