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

// Okno wypozyczania
class SelectReaderDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
    public SelectReaderDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Czytelnicy:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(bib.getCzytelnicy().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);

        JButton selectButton = new JButton("Wybierz");
        
        // Akcja podpieta pod przycisk "Wypozycz"
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              Czytelnik c = bib.getCzytelnicy().get(readersComboBox.getSelectedIndex());
                WypozyczeniaByCzytelnikDialog ad = new WypozyczeniaByCzytelnikDialog(bib, c);
                ad.setVisible(true);
              dispose();
            }
        });

        selectButton.setAlignmentX(0.5f);
        add(selectButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Wybierz czytelnika");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
