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

	private static String[] startCodon = { "A", "U", "G" };
	private static String[] endCodon = { "U", "A", "A" };
	private static String[] endCodon_2 = { "U", "A", "G" };
	private static String[] endCodon_3 = { "U", "G", "A" };

	private static int ReadingFrame = 3;

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
	 * Print some DNA or RNA array sequence
	 * 
	 * @param arr
	 */
	public static void printSequence(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			System.out.print(arr[i]);
		}
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
		System.out.println("Base A: " + count_A + "\n" + "Base C: " + count_C + "\n" + "Base G: " + count_G + "\n"
				+ "Base T: " + count_T + "\n");

	}

	/**
	 * Converts DNA to RNA
	 * 
	 * @param bases
	 * @param sequence
	 *            of DNA
	 */
	private static void DNAtoRNA(String[] bases, String[] sequence) {
		int j = 0;
		String[] arr = new String[sequence.length];
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i].equals(bases[0]) || sequence[i].equals(bases[1]) || sequence[i].equals(bases[2])
					|| sequence[i].equals(bases[3])) {
				if (sequence[i].equals(bases[3])) {
					arr[j] = "U";
					j++;
				} else {
					arr[j] = sequence[i];
					j++;
				}
			}
		}

		System.out.print("DNAtoRNA: ");
		printSequence(arr);
		System.out.println();
	}

	public static void main(String args[]) throws IOException {

		Eucariote = new Reader(Euca);
		Influenza = new Reader(Infl);

		sequence = explode(Eucariote.getSequence());
		sequence2 = explode(Influenza.getSequence());

		count_bases(bases, sequence);
		count_bases(bases, sequence2);

		DNAtoRNA(bases, sequence);
		DNAtoRNA(bases,sequence2);
	}

}
