package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JButton;

public class QuizOverviewView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizOverviewView frame = new QuizOverviewView();
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
	public QuizOverviewView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel pnlLeft = new JPanel();
		
		JPanel pnlRight = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlLeft, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlRight, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlLeft, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlRight, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
		);
		pnlRight.setLayout(new GridLayout(4, 0, 0, 5));
		
		JButton btnToevoegenQuiz = new JButton("Toevoegen Quiz");
		pnlRight.add(btnToevoegenQuiz);
		
		JButton btnWijzigenQuiz = new JButton("Wijzigen Quiz");
		pnlRight.add(btnWijzigenQuiz);
		
		JButton btnVerwijderenQuiz = new JButton("Verwijderen Quiz");
		pnlRight.add(btnVerwijderenQuiz);
		
		JButton btnVorigScherm = new JButton("Terug");
		pnlRight.add(btnVorigScherm);
		pnlLeft.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList list = new JList();
		pnlLeft.add(list);
		contentPane.setLayout(gl_contentPane);
	}

}
