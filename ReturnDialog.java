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

// Okno zwrotu
class ReturnDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
    public ReturnDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Wypożyczenia:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox selectComboBox = new JComboBox(bib.getWypozyczenia().toArray());
        selectComboBox.setSelectedIndex(-1);
        selectComboBox.setPreferredSize(new Dimension(450, 22));
        selectComboBox.setMaximumSize(new Dimension(450, 22));
        add(selectComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 6)));


        JButton returnButton = new JButton("Zwróć");
        
        // Akcja podpieta pod przycisk "Show"
      returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.usunWypozyczenie(bib.getWypozyczenia().get(selectComboBox.getSelectedIndex()));
                dispose();
            }
        });

        returnButton.setAlignmentX(0.5f);
        add(returnButton);
        
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

        setTitle("Zwróć książkę");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
