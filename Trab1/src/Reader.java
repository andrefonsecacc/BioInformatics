
/**
 * 
 * @author andre
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

	private String path;
	private File file;
	String st = null;
	String seq = "";

	/**
	 * Constructor
	 * 
	 * @param path
	 */
	Reader(String path) {
		this.path = path;
	}

	/**
	 * Method for returning a String with a sequence of a protein
	 * 
	 * @return
	 * @throws IOException
	 */
	public String getSequence() throws IOException {

		file = new File(path);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine(); // This will read the fist line;

			while ((st = br.readLine()) != null) {
				seq += st + "\n";
				// System.out.println(st);
			}
			// System.out.println(seq.equals(st));
			br.close();

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
		}
		// System.out.println("Começar aqui");
		// System.out.println(seq);
		return seq;
	}

}
