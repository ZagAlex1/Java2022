package Course2.Lessons.Lesson_5.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class Client extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("80");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("Aleksei_Gennadievich");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JList<String> userList = new JList<>();

    private Client() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // посреди экрана
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        log.setEditable(false);
        JScrollPane scLog = new JScrollPane(log);
        JScrollPane spUsers = new JScrollPane(userList);
        String[] users = {"user1", "user2",
                "user3", "user4", "user5", "user6",
                "user7", "user8", "user9",
                "user10", "user11",};
        userList.setListData(users);
        spUsers.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);
        btnSend.addActionListener(this);
        tfMessage.addActionListener(this);

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH);
        add(panelTop, BorderLayout.NORTH);
        add(scLog, BorderLayout.CENTER);
        add(spUsers, BorderLayout.EAST);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (src == tfMessage) {
            addText();
        } else if (src == btnSend) {
            addText();
        } else {
            throw new RuntimeException("Action for component unimplemented:");
        }
    }


    public void addText(){
        log.append(tfLogin.getText() + " : " + tfMessage.getText() + "\n");
        writeTextToLog();
        tfMessage.setText(null);
        tfMessage.grabFocus();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg = "Exception in thread " + t.getName() +
                " " + e.getClass().getCanonicalName() + ": " + e.getMessage() +
                "\n\t" + e.getStackTrace()[0];
        JOptionPane.showMessageDialog(null, msg,
                "Exception", JOptionPane.ERROR_MESSAGE);
    }

    private void writeTextToLog() {
        try {
            FileWriter fileWriter = new FileWriter("textArea.txt", true);
            fileWriter.write(tfLogin.getText() + " : " + tfMessage.getText() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
