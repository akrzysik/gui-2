import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

// Okno "About"
class AboutDialog extends JDialog {

	public AboutDialog(String tekst) {
        initUI(tekst);
    }

    public final void initUI(String tekst) {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel name = new JLabel("Stany");
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setAlignmentX(0.5f);
        add(name);

        add(Box.createRigidArea(new Dimension(0, 50)));
  

        final JTextArea textArea = new JTextArea(tekst);
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);
        
        JScrollPane scroll = new JScrollPane (textArea, 
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        // Dodanie pola tekstowego 
        add(scroll);
        JButton close = new JButton("Zamknij");

        // Akcja podpieta pod przycisk "Zamknij"
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Lista stanów");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 200);
    }
}
