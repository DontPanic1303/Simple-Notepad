

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class View {
	
	private JFrame frame;
	private JMenuBar jmb;
	private JMenu file;
	private JMenu edit;
	private JMenu adresy;
	private JMenu options;
	private JMenu foreg;
	private JMenu backg;
	private JMenu fonts;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem saveas;
	private JMenuItem exit;
	private JMenuItem praca;
	private JMenuItem dom;
	private JMenuItem szkola;
	private JSeparator jSeparator;
	private JTextArea jtk;
	private JScrollPane jsp;
	private ButtonGroup bgf;
	private ButtonGroup bgb;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;

	View() {
		frame = new JFrame("Prosty edytor - bez tytułu");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//====menu=======

		jmb = new JMenuBar();
		frame.setJMenuBar(jmb);
		file = new JMenu("File");
		edit = new JMenu("Edit");
		adresy = new JMenu("Adresy");
		options = new JMenu("Options");
		foreg = new JMenu("Foreground");
		backg = new JMenu("Background");
		fonts = new JMenu("Fonts");

		jmb.add(file);
		jmb.add(edit);
		jmb.add(options);

		edit.add(adresy);
		options.add(foreg);
		options.add(backg);
		options.add(fonts);

		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		saveas = new JMenuItem("Save as");
		exit = new JMenuItem("Exit");

		file.add(open);
		file.add(save);
		file.add(saveas);
		jSeparator = new JSeparator();
		jSeparator.setBackground(Color.RED);
		file.add(jSeparator);
		file.add(exit);


		praca = new JMenuItem("Praca");
		praca.setName("Ul. Kokosowa 23, Warszawa");
		dom = new JMenuItem("Dom");
		dom.setName("Al. Kazimierza 424, Warszawa");
		szkola = new JMenuItem("Szkoła");
		szkola.setName("Ul. Maślana 3, Warszawa");

		adresy.add(praca);
		adresy.add(dom);
		adresy.add(szkola);

		for (int i = 8; i < 26; i+=2) {
			JMenuItem jm = new JMenuItem(i+" pts");
			jm.setFont(new Font("Dialog",Font.PLAIN,i));
			jm.setName(i+"");
			fonts.add(jm);
		}

		Color[] colors = {Color.GREEN,Color.ORANGE,Color.RED,Color.BLACK,Color.WHITE,Color.YELLOW,Color.BLUE};
		String[] kolory ={"Green","Orange","Red","Black","White","Yellow","Blue"};

		bgf = new ButtonGroup();
		bgb = new ButtonGroup();


		for (int i = 0; i < colors.length; i++) {
			int finalI = i;
			Icon icon = new Icon() {
				@Override
				public void paintIcon(Component c, Graphics g, int x, int y) {
					g.setColor(colors[finalI]);
					g.fillOval(20,4,10,10);
				}

				@Override
				public int getIconWidth() {
					return 0;
				}

				@Override
				public int getIconHeight() {
					return 0;
				}
			};
			JRadioButtonMenuItem jm = new JRadioButtonMenuItem("    "+kolory[i]);
			jm.setIcon(icon);
			jm.setForeground(colors[i]);
			jm.setName(kolory[i]);
			foreg.add(jm);
			bgf.add(jm);
			JRadioButtonMenuItem jm2 = new JRadioButtonMenuItem("    "+kolory[i]);
			jm2.setIcon(icon);
			jm2.setForeground(colors[i]);
			jm2.setName(kolory[i]);
			backg.add(jm2);
			bgb.add(jm2);
		}



		//====text area=======

		jtk = new JTextArea();
		jsp = new JScrollPane(jtk);
		frame.add(jsp);


		//=====panel dolny===========

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jLabel = new JLabel("new");
		jLabel2 = new JLabel(" fg");
		jLabel3 = new JLabel(" bg");
		jLabel4 = new JLabel(" size");


		jp1.setLayout(new GridLayout(1,2));
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));

		jp2.add(jLabel2);
		jp2.add(jLabel3);
		jp2.add(jLabel4);

		jp3.add(jLabel);

		jp1.add(jp2);
		jp1.add(jp3);

		frame.add(jp1, BorderLayout.PAGE_END);
		
		frame.setSize(500,500);
		frame.setVisible(true);
	}

	//======getery========


	public JFrame getFrame() {
		return frame;
	}

	public JTextArea getJtk() {
		return jtk;
	}

	public JMenu getAdresy() {
		return adresy;
	}

	public JMenu getFonts() {
		return fonts;
	}

	public JMenu getForeg() {
		return foreg;
	}

	public JMenu getBackg() {
		return backg;
	}

	public JMenuItem getOpen() {
		return open;
	}

	public JMenuItem getSave() {
		return save;
	}

	public JMenuItem getSaveas() {
		return saveas;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public JMenuItem getPraca() {
		return praca;
	}

	public JMenuItem getDom() {
		return dom;
	}

	public JMenuItem getSzkola() {
		return szkola;
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JLabel getjLabel2() {
		return jLabel2;
	}

	public JLabel getjLabel3() {
		return jLabel3;
	}

	public JLabel getjLabel4() {
		return jLabel4;
	}

}