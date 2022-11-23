import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Controller {

    private View view;
    private Model model;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            view.getFonts().getItem(i).addActionListener(
                    (e) -> {
                        String t = view.getFonts().getItem(finalI).getName();
                        int k = Integer.parseInt(t);
                        view.getjLabel4().setText(k + "");
                        view.getJtk().setFont(new Font("Dialog", Font.PLAIN, k));
                    }
            );
        }

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            view.getBackg().getItem(i).addActionListener(
                    (e) -> {
                        Color tmp = view.getBackg().getItem(finalI).getForeground();
                        if (model.getCi1() != null) {
                            view.getjLabel3().setText("   bg");
                            model.setIcon1();
                            view.getjLabel3().setIcon(model.getIcon1());
                        }
                        model.setCi1(tmp);
                        view.getJtk().setBackground(tmp);
                    }
            );
        }

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            view.getForeg().getItem(i).addActionListener(
                    (e) -> {
                        Color tmp = view.getForeg().getItem(finalI).getForeground();
                        if (model.getCi2() != null) {
                            view.getjLabel2().setText("   bg");
                            model.setIcon2();
                            view.getjLabel2().setIcon(model.getIcon2());
                        }
                        model.setCi2(tmp);
                        view.getJtk().setForeground(tmp);
                    }
            );
        }

        for (int i = 0; i < 3; i++) {
            int filanI = i;
            view.getAdresy().getItem(i).addActionListener(
                    (e) -> {
                        view.getJtk().insert(view.getAdresy().getItem(filanI).getName(), view.getJtk().getCaretPosition());
                    }
            );
        }

        view.getExit().addActionListener(
                (e) -> {
                    System.exit(0);
                }
        );

        view.getOpen().addActionListener(
                (e) -> {
                    JFileChooser jFileChooser;
                    if (model.getPlik() == null) {
                        jFileChooser = new JFileChooser(System.getProperty("user.dir"));
                    } else {
                        jFileChooser = new JFileChooser(model.getPlik());
                    }
                    if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        view.getJtk().setText("");
                        model.setPlik(jFileChooser.getSelectedFile());
                        view.getFrame().setTitle("Prosty edytor - " + model.getPlik().getAbsolutePath());
                        try {
                            Scanner scanner = new Scanner(model.getPlik());
                            while (scanner.hasNext()) {
                                view.getJtk().append(scanner.nextLine() + "\n");
                            }
                            scanner.close();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );

        view.getSave().addActionListener(
                (e) -> {
                    File plik = model.getPlik();
                    if (plik != null) {
                        try {
                            PrintWriter printWriter = new PrintWriter(plik);
                            Scanner scanner = new Scanner(view.getJtk().getText());
                            while (scanner.hasNext()) {
                                printWriter.println(scanner.nextLine() + "\n");
                            }
                            printWriter.close();
                            scanner.close();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        view.getjLabel().setText(model.getStan()[2]);
                        view.getFrame().setTitle("Prosty edytor - " + model.getPlik().getAbsolutePath());
                    } else
                        saveas();
                }
        );

        view.getSaveas().addActionListener(
                (e) -> {
                    saveas();
                }
        );

        view.getJtk().addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        view.getjLabel().setText(model.getStan()[1]);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        //==mnemonic
        view.getOpen().setMnemonic(KeyEvent.VK_O);
        view.getOpen().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)
        );
        view.getSave().setMnemonic(KeyEvent.VK_S);
        view.getSave().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)
        );
        view.getSaveas().setMnemonic(KeyEvent.VK_A);
        view.getSaveas().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)
        );
        view.getExit().setMnemonic(KeyEvent.VK_X);
        view.getExit().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)
        );

        view.getPraca().setMnemonic(KeyEvent.VK_P);
        view.getPraca().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK)
        );
        view.getDom().setMnemonic(KeyEvent.VK_D);
        view.getDom().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK)
        );
        view.getSzkola().setMnemonic(KeyEvent.VK_S);
        view.getSzkola().setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK)
        );


    }

    private void saveas() {
        JFileChooser jFileChooser;
        if (model.getPlik() == null) {
            jFileChooser = new JFileChooser(System.getProperty("user.dir"));
        } else {
            jFileChooser = new JFileChooser(model.getPlik());
        }
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            model.setPlik(jFileChooser.getSelectedFile());
            try {
                PrintWriter printWriter = new PrintWriter(model.getPlik());
                Scanner scanner = new Scanner(view.getJtk().getText());
                while (scanner.hasNext()) {
                    printWriter.println(scanner.nextLine() + "\n");
                }
                printWriter.close();
                scanner.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            view.getjLabel().setText(model.getStan()[2]);
            view.getFrame().setTitle("Prosty edytor - " + model.getPlik().getAbsolutePath());
        }
    }


}
