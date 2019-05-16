import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PrinterJob;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

import java.awt.Color;

public class PrintDocument implements Printable {

	private PrinterJob job;
        private Graphics2D g2d;
	private Image imaIma;	

	PrintDocument() {

		System.out.println("Print any doc.");

		File fileIma = new File("wall.png");
                try {
			imaIma = ImageIO.read(fileIma);
		
		} catch (IOException e) {
			System.out.println(e);

		}

		job = PrinterJob.getPrinterJob();
		job.setPrintable(this);

		System.out.println("End action doc.");
		

	}	

	public int print(Graphics g, PageFormat pf, int page) {

		if(page >0) {
			
			return NO_SUCH_PAGE;
		}
		
		g2d = (Graphics2D)g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		
		g2d.setColor(Color.yellow);	
		g2d.drawString("Frolov Dmitrii Petrovich", 100, 100);
		
		g2d.drawImage(imaIma, 200, 200, null);
		
		g2d.setColor(Color.red);
		g2d.drawRect(200, 200, 200, 200);

		g2d.setColor(Color.blue);
		g2d.drawOval(110, 110, 200, 200);
	
		g2d.drawLine(0, 0, 100, 100);

		return PAGE_EXISTS;

	}
	
	public void doAction() {

		System.out.println("Start to print doc.");

		boolean ok = job.printDialog();
		if(ok) {
			try {
				job.print();
			} catch (PrinterException ex) {

			}

		}
		
	}

	public static void main(String args[]) {

		PrintDocument ob = new PrintDocument();
		
		ob.doAction();
	}

}