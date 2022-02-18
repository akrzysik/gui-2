import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;



// Klasa Notes
public class Notes extends JFrame {
	// Lista stanów
	ListaStanow stany;
	String tekst;
	
	/**
	 * Konstruktor
	 */
	public Notes() {
		String init = "Lorem ipsum dolor sit amet";
    Stan stan = new Stan(init);

    this.stany = new ListaStanow(stan);
    this.tekst = this.stany.toString();
		
		initUI(this);
	}
	// Metoda inicjalizująca GUI
	public final void initUI(final Notes notes) {
		
		// Panel
		JPanel panel = new JPanel();

		// Pole tekstowe
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(true);
        textArea.setText(this.tekst);
        // Dodanie pola tekstowego do panelu
        panel.add(textArea);
        
        // Dodanie panelu do JFrame
        add(panel);
        pack();
        // Pasek menu
        JMenuBar menubar = new JMenuBar();
        
        // Pozycja menu: Cofnij
        JMenuItem cMenuItem = new JMenuItem("Cofnij");
        cMenuItem.setMnemonic(KeyEvent.VK_C);
        cMenuItem.setToolTipText("Cofnij edycję");
        // Podpiecie akcji pod "Cofnij"
        cMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText(stany.undo());
            }
        });

        // Pozycja menu: Ponów
        JMenuItem pMenuItem = new JMenuItem("Ponów");
        pMenuItem.setMnemonic(KeyEvent.VK_P);
        pMenuItem.setToolTipText("Ponów edycję");
        
        pMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText(stany.redo());
            }
        });

        // Pozycja menu: Zapisz stan
        JMenuItem sMenuItem = new JMenuItem("Zapisz");
        sMenuItem.setMnemonic(KeyEvent.VK_P);
        sMenuItem.setToolTipText("Zapisz stan edycji");
        
        sMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              Stan nowy = new Stan(textArea.getText());
            	stany.change(nowy);
              AboutDialog ad = new AboutDialog("stan zapisany");
              ad.setVisible(true);
            }
        });

        JMenu help = new JMenu("Eksport");
        help.setMnemonic(KeyEvent.VK_E);
        
        JMenuItem about = new JMenuItem("Lista stanów");
        about.setMnemonic(KeyEvent.VK_L);
        
        // Podpiecie akcji pod "O programie"
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog(stany.toString());
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji "O programie" do menu "Pomoc"
        help.add(about);
        
        // Dodanie menu "Edycja" i "Pomoc" do paska menu
        menubar.add(help);
        menubar.add(sMenuItem);
        menubar.add(cMenuItem);
        menubar.add(pMenuItem);

        setJMenuBar(menubar);
        
        setTitle("Notes");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
