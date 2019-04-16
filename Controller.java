import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class Controller implements ActionListener {
                                           
	Model model;

	Controller(Viewer viewer){
		
		this.model = new Model(viewer);

	}

        public void actionPerformed(ActionEvent event) {
        	
		String command = event.getActionCommand();

        /*if(command.equals("Exit")){
            System.out.println("GoodBye!");
            System.exit(1);
        } else if(command.equals("New")) {
           // viewer.update("");
        }*/
	}
}