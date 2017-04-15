import java.io.IOException;

/**
 * 
 * @author andre , castanheira Eucariote S. Cerevisiae (fermento)
 *         http://www.rcsb.org/pdb/explore/explore.do?structureId=5UL0 bacteria
 *         H. Influenza
 *         http://www.rcsb.org/pdb/explore/explore.do?structureId=4UCO
 */

public class Nucleo {

	private static String Euca = "/home/andre/GitProjects/BioInformatics/Trab1/src/5ul0.txt";
	private static String Infl = "/home/andre/GitProjects/BioInformatics/Trab1/src/4uco.fasta.txt";

	private static Reader Eucariote = null;;
	private static Reader Influenza = null;;

	private static String[] sequence = null;
	private static String[] sequence2 = null;

	private static String[] bases = { "A", "C", "G", "T" };

	/**
	 * Method for string to string array conversion
	 * 
	 * @param s
	 * @return
	 */
	public static String[] explode(String s) {
		String[] arr = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = String.valueOf(s.charAt(i));
		}
		return arr;
	}

	/**
	 * Method to count nucleotides(A,C,G,T) in a sequence
	 * 
	 * @param bases
	 * @param sequence
	 */
	public static void count_bases(String[] bases, String[] sequence) {

		int count_A = 0, count_C = 0, count_G = 0, count_T = 0;

		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i].equals(bases[0])) {
				count_A++;
			}
			if (sequence[i].equals(bases[1])) {
				count_C++;
			}
			if (sequence[i].equals(bases[2])) {
				count_G++;
			}
			if (sequence[i].equals(bases[3])) {
				count_T++;
			}
		}
		System.out.println("Base A: "+count_A+"\n"
				+"Base C: "+count_C+"\n"
				+"Base G: "+count_G+"\n"
				+"Base T: "+count_T+"\n");

	}

	public static void main(String args[]) throws IOException {

		Eucariote = new Reader(Euca);
		sequence = explode(Eucariote.getSequence());
		count_bases(bases, sequence);
		//System.out.println(sequence);

	}

}
