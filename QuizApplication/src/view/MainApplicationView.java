package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JButton;

public class MainApplicationView extends JFrame {

	private JPanel contentPane;
	private JButton btnBeherenOpdrachten;
	private JButton btnBeherenQuizzen;
	private JButton btnDeelnemenQuiz;
	private JButton btnOverzichtScores;
	private JButton btnQuizRapport;
	private JButton btnQuizLijsten;
	private JButton btnInstellingen;
	private JButton btnStoppen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplicationView frame = new MainApplicationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApplicationView() {
		setTitle("Quiz applicatie lager onderwijs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 0, 5, 5));
		
		btnBeherenOpdrachten = new JButton("Beheren van opdrachten (leraar)");
		contentPane.add(btnBeherenOpdrachten);
		
		btnBeherenQuizzen = new JButton("Beheren van quizzen/testen (leraar)");
		contentPane.add(btnBeherenQuizzen);
		
		btnDeelnemenQuiz = new JButton("Deelnemen aan quiz (leerling)");
		contentPane.add(btnDeelnemenQuiz);
		
		btnOverzichtScores = new JButton("Overzicht scores (leraar)");
		contentPane.add(btnOverzichtScores);
		
		btnQuizRapport = new JButton("Quiz rapport (deelnemer quiz)");
		contentPane.add(btnQuizRapport);
		
		btnQuizLijsten = new JButton("Quiz lijsten");
		contentPane.add(btnQuizLijsten);
		
		btnInstellingen = new JButton("Instellingen van de quiz applicatie");
		contentPane.add(btnInstellingen);
		
		btnStoppen = new JButton("Stoppen");
		contentPane.add(btnStoppen);
	}

}
