import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;


class Controller implements ActionListener {
                                           
	Model model;
        Viewer viewer;

	Controller(Viewer viewer){
		
		this.model = new Model(viewer);
		this.viewer = viewer;
	}

        public void actionPerformed(ActionEvent event) {
        	
		String command = event.getActionCommand();

        	if(command.equals("Exit")){
            		System.out.println("GoodBye!");
            		System.exit(1);
        
		} else if(command.equals("Open")) {

			String textFromFile = readFromFile();

			if(!textFromFile.equals("")) {
				viewer.update(textFromFile);
			}
        	
		} else if(command.equals("Save")) {


		} else if(command.equals("Print")) {

		//String textToFile
		}
	}
	

	private String readFromFile() {
		String text = "";
		JFileChooser fc = new JFileChooser();

		int returnVal = fc.showOpenDialog(viewer.getMainFrame());

		if(returnVal == 0) {

			File fileName = fc.getSelectedFile();
			FileInputStream in = null;
	
	                try {
	                	in = new FileInputStream(fileName);
	        		int c;

				while((c = in.read()) != -1) {

					char symbol = (char)c;

					text = text + symbol;

				}
		
				in.close();
			} catch(IOException e) {
				System.out.println("err" + e);

			}
		}

		return text;
	}

	public void saveToFile() {

				
	}
}



