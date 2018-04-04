
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IHM {

	private JFrame frame;
	private JTextField textFieldScoreJ1;
	private JTextField textFieldScoreJ2;
	private JTextField textFieldScoreDe1;
	private JTextField textFieldScoreDe2;
	private JLabel lblNbTour;
	private JButton btnJoueur1;
	private JButton btnJoueur2;
	private JButton btnRestart;
	private JCheckBox chckbxCheat1;
	private JCheckBox chckbxCheat2;
	private Partie partie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					IHM window = new IHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IHM() {
		partie = new Partie("Nono", "Camille");
		initialize();

	}

	private void refreshScreen() {
		// Player 1
		textFieldScoreJ1.setText("" + partie.getJ1().getScorePartie());
		textFieldScoreJ2.setText("" + partie.getJ2().getScorePartie());
		textFieldScoreDe1.setText("" + partie.getJoueurActif().getGobelet().getDe1().getValeur());
		textFieldScoreDe2.setText("" + partie.getJoueurActif().getGobelet().getDe2().getValeur());

		// Player 2

		// ALTERNANCE DES TOURS
		if (partie.getJoueurActif() == partie.getJ1()) {
			btnJoueur1.setEnabled(true);
			btnJoueur2.setEnabled(false);
		} else if (partie.getJoueurActif() == partie.getJ2()) {
			btnJoueur1.setEnabled(false);
			btnJoueur2.setEnabled(true);

		}

		// Tour EN COURS
		lblNbTour.setText("Tour :" + partie.getTourEncours());
		btnRestart.setVisible(false);
		if (partie.getTourEncours() == 10) {
			btnJoueur1.setVisible(false);
			btnJoueur2.setVisible(false);
			btnRestart.setVisible(true);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// SCORE JOUEUR 1
		JLabel lblScorePlayer1 = new JLabel("Score :");
		lblScorePlayer1.setBounds(22, 80, 46, 14);
		frame.getContentPane().add(lblScorePlayer1);
		// SCORE JOUEUR 2
		JLabel lblScorePlayer2 = new JLabel("Score :");
		lblScorePlayer2.setBounds(316, 80, 46, 14);
		frame.getContentPane().add(lblScorePlayer2);

		JLabel lblD = new JLabel("D\u00E9  1");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(136, 80, 46, 14);
		frame.getContentPane().add(lblD);

		JLabel lblD_1 = new JLabel("D\u00E9 2");
		lblD_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblD_1.setBounds(231, 80, 46, 14);
		frame.getContentPane().add(lblD_1);

		// BOUTON JOUEUR1
		btnJoueur1 = new JButton("Play");
		btnJoueur1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				partie.setJoueurActif(partie.getJ1());
				partie.getJ1().jouer();
				if (partie.getJ1().getGobelet().getScoreDe() >= Partie.SCORE_A_ATTEINDRE) {
					partie.getJ1().ajouterPoint();
				}
				partie.changerJoueurActif();
				refreshScreen();
			}
		});
		btnJoueur1.setBounds(22, 165, 89, 23);
		frame.getContentPane().add(btnJoueur1);

		// BOUTON JOUEUR2
		btnJoueur2 = new JButton("Play");
		btnJoueur2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				partie.setJoueurActif(partie.getJ2());
				partie.getJ2().jouer();
				if (partie.getJ2().getGobelet().getScoreDe() >= Partie.SCORE_A_ATTEINDRE) {
					partie.getJ2().ajouterPoint();
				}
				partie.ajouterTour();
				partie.changerJoueurActif();
				refreshScreen();

			}
		});
		btnJoueur2.setBounds(316, 165, 89, 23);
		frame.getContentPane().add(btnJoueur2);

		// BOUTON RESTART
		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				partie = new Partie("Nono", "Camille");
				refreshScreen();
			}
		});
		btnRestart.setBounds(157, 216, 129, 23);
		frame.getContentPane().add(btnRestart);

		JLabel lblPlayer = new JLabel(partie.getJ1().getPrenom());
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(48, 38, 46, 14);
		frame.getContentPane().add(lblPlayer);

		JLabel lblPlayer_1 = new JLabel(partie.getJ2().getPrenom());
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setBounds(343, 38, 46, 14);
		frame.getContentPane().add(lblPlayer_1);
		// SCORE JOUEUR1
		textFieldScoreJ1 = new JTextField();
		textFieldScoreJ1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreJ1.setBounds(62, 77, 47, 20);
		frame.getContentPane().add(textFieldScoreJ1);
		textFieldScoreJ1.setColumns(10);
		// SCORE JOUEUR2
		textFieldScoreJ2 = new JTextField();
		textFieldScoreJ2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreJ2.setBounds(356, 77, 53, 20);
		frame.getContentPane().add(textFieldScoreJ2);
		textFieldScoreJ2.setColumns(10);
		// VALEUR DE1
		textFieldScoreDe1 = new JTextField();
		textFieldScoreDe1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreDe1.setBounds(136, 107, 46, 37);
		frame.getContentPane().add(textFieldScoreDe1);
		textFieldScoreDe1.setColumns(10);
		// VALEUR DE2
		textFieldScoreDe2 = new JTextField();
		textFieldScoreDe2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreDe2.setBounds(231, 105, 46, 37);
		frame.getContentPane().add(textFieldScoreDe2);
		textFieldScoreDe2.setColumns(10);
		// NOMBRE TOURS
		lblNbTour = new JLabel();
		lblNbTour.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbTour.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNbTour.setBounds(145, 11, 120, 41);
		frame.getContentPane().add(lblNbTour);

		// CHECKBOX JOUEUR1
		chckbxCheat1 = new JCheckBox("Cheat ");
		chckbxCheat1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxCheat1.isSelected()) {
					partie.getJ1().setTricheur(true);
				} else {
					partie.getJ1().setTricheur(false);
				}
			}
		});
		chckbxCheat1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCheat1.setBounds(14, 216, 97, 23);
		frame.getContentPane().add(chckbxCheat1);

		// CHECKBOX JOUEUR2
		chckbxCheat2 = new JCheckBox("Cheat");
		chckbxCheat2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxCheat2.isSelected()) {
					partie.getJ2().setTricheur(true);
				} else {
					partie.getJ2().setTricheur(false);
				}
			}
		});
		chckbxCheat2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCheat2.setBounds(316, 216, 97, 23);
		frame.getContentPane().add(chckbxCheat2);
	}

}
