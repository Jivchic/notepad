import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

class Viewer{

	JFrame frame;
	JTextArea textArea;

	Viewer(){

		Controller controller = new Controller(this);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);

		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("File");
			JMenuItem menuItemNew = new JMenuItem("New");
				menuItemNew.addActionListener(controller);
				menuItemNew.setActionCommand("New");
			
			JMenuItem menuItemOpen = new JMenuItem("Open");
				menuItemOpen.addActionListener(controller);
				menuItemOpen.setActionCommand("Open");

		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);

	
		JMenu menuEdit = new JMenu("Edit");
			JMenuItem menuItemUndo = new JMenuItem("Undo");
				menuItemUndo.addActionListener(controller);
				menuItemUndo.setActionCommand("Undo");

		menuEdit.add(menuItemUndo);

		
		jMenuBar.add(menuFile);
		jMenuBar.add(menuEdit);


		frame = new JFrame("Notepad");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.add("Center", scroll);
		frame.setJMenuBar(jMenuBar);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public JFrame getMainFrame() {
		return frame;
	}	

	public void update(String text) {
		textArea.setText(text);	
	}	

}