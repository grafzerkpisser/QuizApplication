package utils;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class QuizTest {
	private UUID quizId;
	@Test
	public void testQuiz() {
		this.quizId = UUID.randomUUID();
		System.out.println("quiz id = " + quizId);
	}

}
