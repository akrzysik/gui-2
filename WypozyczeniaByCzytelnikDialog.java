import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.util.ArrayList;


// Okno zwrotu
class WypozyczeniaByCzytelnikDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
  private Czytelnik c;
	
    public WypozyczeniaByCzytelnikDialog(Biblioteka bib, Czytelnik c) {
    	this.bib = bib;	
      this.c = c;

        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Wypożyczenia czytelnika");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));

        
        ArrayList<Wypozyczenie> lista = bib.getWypozyczeniaByCzytelnik(c);
        
        String spis = "";
        for (Wypozyczenie k: lista) { 
           if (k.getCzytelnik() == c) 
            		spis+= (k.toString()+"\n");
            	}		
        
        JTextArea textArea = new JTextArea(spis);
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);

        add(textArea);
        
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Zamknij");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Wypożyczenia czytelnika");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
