import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Gui extends JFrame{
    private JTextField txtField;
    private JButton btn;
    private JTextArea txtArea;
    private JPanel panel;
    private JTable table;
    private File selectedFile;

    public Gui() {
        components();
        menu();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append(txtField.getText()+"\n");
            }
        });
    }
    public void components() {
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Zkouška");
        setBounds(700, 300, 500, 500);
        table.setModel(new SpravceZakazniku());
    }

    public void menu(){
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu jMenu = new JMenu("Akce");
        jMenuBar.add(jMenu);

        JMenuItem copyItem = new JMenuItem("Kopíruj");
        jMenu.add(copyItem);
        copyItem.addActionListener(e -> txtArea.append(txtField.getText()+"\n"));

        JMenuItem uploadItem = new JMenuItem("Načti Soubor");
        jMenu.add(uploadItem);
        uploadItem.addActionListener(e -> chooseFile());
    }

    public void chooseFile() {
        JFileChooser fc = new JFileChooser(".");
        fc.setFileFilter(new FileNameExtensionFilter("Project files", "txt"));
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
            StringBuilder content = new StringBuilder();
            try(Scanner sc = new Scanner(new BufferedReader(new FileReader(selectedFile)))){
                while(sc.hasNextLine()) {
                    content.append(sc.nextLine()).append("\n");
                }
                txtArea.append(txtField.getText()+"\n");
                txtArea.setText(String.valueOf(content));
            }catch (IOException e) {
                JOptionPane.showMessageDialog(this, "File not found: "+e.getLocalizedMessage());
            }
        }
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setVisible(true);
    }
}
