import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Okno dodawania nowej książki
class BookDialog extends JDialog {

	private static final long serialVersionUID = 9092551044456132035L;
	private Biblioteka bib;
	
    public BookDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel title = new JLabel("Tytuł:");
        title.setFont(new Font("Serif", Font.BOLD, 12));
        title.setAlignmentX(0.5f);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 5)));
        
        final JTextField titleTextField = new JTextField(20);
        add(titleTextField);
        
        add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel aname = new JLabel("Autor:");
        aname.setFont(new Font("Serif", Font.BOLD, 12));
        aname.setAlignmentX(0.5f);
        add(aname);
        
        add(Box.createRigidArea(new Dimension(0, 5)));
        
        final JTextField anameTextField = new JTextField(20);
        add(anameTextField);

        add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel isbn = new JLabel("ISBN:");
        isbn.setFont(new Font("Serif", Font.BOLD, 12));
        isbn.setAlignmentX(0.5f);
        add(isbn);

        add(Box.createRigidArea(new Dimension(0, 5)));
        
        final JTextField isbnTextField = new JTextField(20);
        add(isbnTextField);
        
        add(Box.createRigidArea(new Dimension(0, 8)));

        JButton addButton = new JButton("Dodaj");
        
        
        // Akcja podpieta pod przycisk "Dodaj"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.dodajKsiazke(new Ksiazka(anameTextField.getText(), titleTextField.getText(),
               isbnTextField.getText(),
               1));
                dispose();
            }
        });

        addButton.setAlignmentX(0.5f);
        add(addButton);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Dodaj czytelnika");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 290);
    }
}
