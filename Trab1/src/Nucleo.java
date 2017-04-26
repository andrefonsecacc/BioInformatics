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

	private static String[] sequence_rna = null;
	private static String[] sequence_rna_2=null;

	private static String[] bases_dna = { "A", "C", "G", "T" };

	private static String[] bases_rna = { "A", "C", "G", "U" };

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

	
	public static void main(String [] args) throws IOException {

		Eucariote = new Reader(Euca);
		Influenza = new Reader(Infl);

		sequence = explode(Eucariote.getSequence());
		sequence2 = explode(Influenza.getSequence());

		/**
		 * totais de nucleotideos no genome
		 * 
		 */
		Count.count_bases_DNA(bases_dna, sequence);
		Count.count_bases_DNA(bases_dna, sequence2);

		/**
		 * totais de nucleotideos no material codificador
		
		sequence_rna = Count.DNAtoRNA(bases_dna, sequence);
		Count.count_bases_RNA(bases_rna, sequence_rna);
		sequence_rna_2=Count.DNAtoRNA(bases_dna, sequence2);
		Count.count_bases_RNA(bases_rna, sequence_rna_2);
		 */
	
		/**
		 * transitions and probability
		 */
		Transitions transitions = new Transitions(bases_dna, sequence, sequence2);
		transitions.print_matrix();
	}
}