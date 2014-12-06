package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class QuizCatalogusView extends JFrame {
	private JFrame frame;
	private JTextField txtOnderwerp;
	private JComboBox cmbCategorie;
	private JLabel lblCounter;
	private JComboBox cmbSorteer;
	private JButton btnMoveUp;
	private JButton btnToevoegen;
	private JButton btnVerwijder;
	private JList listOpdrachten;
	private JList listQuizOpdrachten;
	private JComboBox cmbKlas;
	private JComboBox cmbAuteur;
	private JButton btnRegistreer;
	
	public QuizCatalogusView(){
		initialize();
	}
	 
	 private void initialize() {
		 frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(100, 100, 863, 527);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel pnlTop = new JPanel();
			
			JPanel pnlBottom = new JPanel();
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(pnlTop, GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
							.addComponent(pnlBottom, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(pnlBottom, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE))
			);
			GridBagLayout gbl_pnlBottom = new GridBagLayout();
			gbl_pnlBottom.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlBottom.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_pnlBottom.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnlBottom.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			pnlBottom.setLayout(gbl_pnlBottom);
			
			JLabel lblCategorie = new JLabel("Toon opdrachten van categorie:");
			GridBagConstraints gbc_lblCategorie = new GridBagConstraints();
			gbc_lblCategorie.anchor = GridBagConstraints.WEST;
			gbc_lblCategorie.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategorie.gridx = 1;
			gbc_lblCategorie.gridy = 1;
			pnlBottom.add(lblCategorie, gbc_lblCategorie);
			
			cmbCategorie = new JComboBox();
			GridBagConstraints gbc_cmbCategorie = new GridBagConstraints();
			gbc_cmbCategorie.gridwidth = 4;
			gbc_cmbCategorie.insets = new Insets(0, 0, 5, 5);
			gbc_cmbCategorie.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbCategorie.gridx = 2;
			gbc_cmbCategorie.gridy = 1;
			pnlBottom.add(cmbCategorie, gbc_cmbCategorie);
			
			JLabel lblAantalToegevoegdeOpdrachten = new JLabel("Aantal toegevoegde opdrachten: ");
			GridBagConstraints gbc_lblAantalToegevoegdeOpdrachten = new GridBagConstraints();
			gbc_lblAantalToegevoegdeOpdrachten.anchor = GridBagConstraints.WEST;
			gbc_lblAantalToegevoegdeOpdrachten.insets = new Insets(0, 0, 5, 5);
			gbc_lblAantalToegevoegdeOpdrachten.gridx = 8;
			gbc_lblAantalToegevoegdeOpdrachten.gridy = 1;
			pnlBottom.add(lblAantalToegevoegdeOpdrachten, gbc_lblAantalToegevoegdeOpdrachten);
			
			lblCounter = new JLabel("0");
			GridBagConstraints gbc_lblCounter = new GridBagConstraints();
			gbc_lblCounter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCounter.gridx = 10;
			gbc_lblCounter.gridy = 1;
			pnlBottom.add(lblCounter, gbc_lblCounter);
			
			JLabel lblSorteerOpdrachten = new JLabel("Sorteer opdrachten op:");
			lblSorteerOpdrachten.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblSorteerOpdrachten = new GridBagConstraints();
			gbc_lblSorteerOpdrachten.insets = new Insets(0, 0, 5, 5);
			gbc_lblSorteerOpdrachten.anchor = GridBagConstraints.WEST;
			gbc_lblSorteerOpdrachten.gridx = 1;
			gbc_lblSorteerOpdrachten.gridy = 2;
			pnlBottom.add(lblSorteerOpdrachten, gbc_lblSorteerOpdrachten);
			
			cmbSorteer = new JComboBox();
			GridBagConstraints gbc_cmbSorteer = new GridBagConstraints();
			gbc_cmbSorteer.gridwidth = 4;
			gbc_cmbSorteer.insets = new Insets(0, 0, 5, 5);
			gbc_cmbSorteer.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbSorteer.gridx = 2;
			gbc_cmbSorteer.gridy = 2;
			pnlBottom.add(cmbSorteer, gbc_cmbSorteer);
			
			btnMoveUp = new JButton("^^^");
			GridBagConstraints gbc_btnMoveUp = new GridBagConstraints();
			gbc_btnMoveUp.gridwidth = 8;
			gbc_btnMoveUp.insets = new Insets(0, 0, 5, 5);
			gbc_btnMoveUp.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnMoveUp.gridx = 8;
			gbc_btnMoveUp.gridy = 2;
			pnlBottom.add(btnMoveUp, gbc_btnMoveUp);
			
			btnToevoegen = new JButton(">>>");
			GridBagConstraints gbc_btnToevoegen = new GridBagConstraints();
			gbc_btnToevoegen.insets = new Insets(0, 0, 5, 5);
			gbc_btnToevoegen.gridx = 7;
			gbc_btnToevoegen.gridy = 3;
			pnlBottom.add(btnToevoegen, gbc_btnToevoegen);
			
			btnVerwijder = new JButton("<<<");
			GridBagConstraints gbc_btnVerwijder = new GridBagConstraints();
			gbc_btnVerwijder.insets = new Insets(0, 0, 5, 5);
			gbc_btnVerwijder.gridx = 7;
			gbc_btnVerwijder.gridy = 4;
			pnlBottom.add(btnVerwijder, gbc_btnVerwijder);
			
			listOpdrachten = new JList();
			GridBagConstraints gbc_listOpdrachten = new GridBagConstraints();
			gbc_listOpdrachten.gridheight = 3;
			gbc_listOpdrachten.gridwidth = 6;
			gbc_listOpdrachten.insets = new Insets(0, 0, 0, 5);
			gbc_listOpdrachten.fill = GridBagConstraints.BOTH;
			gbc_listOpdrachten.gridx = 1;
			gbc_listOpdrachten.gridy = 3;
			pnlBottom.add(listOpdrachten, gbc_listOpdrachten);
			
			listQuizOpdrachten = new JList();
			GridBagConstraints gbc_listQuizOpdrachten = new GridBagConstraints();
			gbc_listQuizOpdrachten.gridheight = 3;
			gbc_listQuizOpdrachten.gridwidth = 8;
			gbc_listQuizOpdrachten.insets = new Insets(0, 0, 0, 5);
			gbc_listQuizOpdrachten.fill = GridBagConstraints.BOTH;
			gbc_listQuizOpdrachten.gridx = 8;
			gbc_listQuizOpdrachten.gridy = 3;
			pnlBottom.add(listQuizOpdrachten, gbc_listQuizOpdrachten);
			pnlTop.setLayout(new GridLayout(2, 0, 0, 0));
			
			JPanel pnlTopUpper = new JPanel();
			pnlTop.add(pnlTopUpper);
			
			JLabel lblOnderwerp = new JLabel("Onderwerp:");
			
			txtOnderwerp = new JTextField();
			txtOnderwerp.setColumns(10);
			
			JLabel lblKlas = new JLabel("Klas:");
			
			cmbKlas = new JComboBox();
			
			JLabel lblAuteur = new JLabel("Auteur:");
			
			cmbAuteur = new JComboBox();
			
			
			GroupLayout gl_pnlTopUpper = new GroupLayout(pnlTopUpper);
			gl_pnlTopUpper.setHorizontalGroup(
				gl_pnlTopUpper.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlTopUpper.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblOnderwerp)
						.addGap(18)
						.addComponent(txtOnderwerp, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblKlas)
						.addGap(18)
						.addComponent(cmbKlas, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblAuteur)
						.addGap(18)
						.addComponent(cmbAuteur, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(126, Short.MAX_VALUE))
			);
			gl_pnlTopUpper.setVerticalGroup(
				gl_pnlTopUpper.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlTopUpper.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnlTopUpper.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblOnderwerp)
							.addComponent(txtOnderwerp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblKlas)
							.addComponent(cmbKlas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAuteur)
							.addComponent(cmbAuteur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
			);
						
						
			
			pnlTopUpper.setLayout(gl_pnlTopUpper);
			
			JPanel pnlTopLower = new JPanel();
			pnlTop.add(pnlTopLower);
			pnlTopLower.setLayout(new BorderLayout(0, 0));
			
			btnRegistreer = new JButton("Registreer nieuwe quiz");
			pnlTopLower.add(btnRegistreer, BorderLayout.CENTER);
			frame.getContentPane().setLayout(groupLayout);
			frame.setVisible(true);
	    }
	
	 // Open a popup that contains the error message passed
	 public void displayErrorMessage(String errorMessage){
		 JOptionPane.showMessageDialog(this, errorMessage);	 
	 }
	 public void registreerQuizListener(ActionListener listenForRegistreerButton){
		 btnRegistreer.addActionListener(listenForRegistreerButton);
	 }
	 /**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						QuizCatalogusView frame = new QuizCatalogusView();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
}
