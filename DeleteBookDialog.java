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

// Okno usuwania ksiazki
class DeleteBookDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
    public DeleteBookDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel name = new JLabel("Ksiazka:");
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setAlignmentX(0.5f);
        add(name);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
        booksComboBox.setSelectedIndex(-1);
        booksComboBox.setPreferredSize(new Dimension(450, 22));
        booksComboBox.setMaximumSize(new Dimension(450, 22));
        add(booksComboBox);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton deleteButton = new JButton("Usuń");
        
        // Akcja podpieta pod przycisk "Usun"
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.usunKsiazke(bib.getKsiazki().get(booksComboBox.getSelectedIndex()));
              
              dispose();
            }
        });

        deleteButton.setAlignmentX(0.5f);
        add(deleteButton);
        
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

        setTitle("Usuń książkę");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
