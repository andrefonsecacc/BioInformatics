
public class Count {

	/**
	 * Method to count nucleotides(A,C,G,T) in a sequence
	 * 
	 * @param bases
	 * @param sequence
	 */
	public static void count_bases_DNA(String[] bases, String[] sequence) {

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
		
		int total= count_A+count_C+count_G+count_T;
		System.out.println("Total de bases de DNA: " +total + "\n");

	}

	/**
	 * Method to count nucleotides(A,C,G,U) in a sequence
	 * 
	 * @param bases
	 * @param sequence
	 */
	public static void count_bases_RNA(String[] bases, String[] sequence) {

		int count_A = 0, count_C = 0, count_G = 0, count_U = 0;

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
				count_U++;
			}

			

		}
		System.out.println("Base A: " + count_A + "\n" + "Base C: " + count_C + "\n" + "Base G: " + count_G + "\n"
				+ "Base U: " + count_U + "\n");

		

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
	 * Converts DNA to RNA
	 * 
	 * @param bases
	 * @param sequence
	 *            of DNA
	 */
	public static String[] DNAtoRNA(String[] bases, String[] sequence) {
		
		int k=0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i].equals(bases[0]) || sequence[i].equals(bases[1]) || sequence[i].equals(bases[2])
					|| sequence[i].equals(bases[3])) {
				k++;
				}
			}
		System.out.println(k);
			
		int j = 0;
		String[] arr = new String[k];
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
		return arr;

	}
	
	
}
