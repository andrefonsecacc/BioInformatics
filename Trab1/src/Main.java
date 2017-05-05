import java.io.IOException;

/**
 * 
 * @author andre , castanheira Eucariote S. Cerevisiae (fermento)
 *         http://www.rcsb.org/pdb/explore/explore.do?structureId=5UL0 bacteria
 *         H. Influenza
 *         http://www.rcsb.org/pdb/explore/explore.do?structureId=4UCO
 */

public class Main {

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

	
	public static void testNWAlignment(String seq1, String seq2){
        
		NeedlemanWunsch.verbose=true;
		          
		System.out.println("\n\nTest Alignments using Needleman-Wunsch Algorithm");
		             
		     
		System.out.println("Original Sequences:");
		System.out.println(seq1);
		System.out.println(seq2);
		          
		long start=System.nanoTime();
		AlignmentResult result=NeedlemanWunsch.computeNWAlignment(seq1,
		                       seq2,
		                       new SimpleAlignmentParameters());
		long stop=System.nanoTime();
		          
		System.out.println( "elapsed time (sec): " + 
		                    String.format("%2.5f",
		                    (float)(stop-start)/Math.pow(10, 9)));
		String[] alignments= result.getAlignments();
		                  
		System.out.println("Alignments:");
		System.out.println(alignments[0] + " size:" + 
		                   alignments[0].length());
		           
		int matches=0;
		int gaps=0;
		for (int k=0; k < alignments[0].length(); k++){
		if (alignments[0].charAt(k)==alignments[1].charAt(k)) {
		    matches++;
		    System.out.print('|');
		} else System.out.print(" ");
		               
		  if ( (alignments[0].charAt(k)=='-') ||
		       (alignments[1].charAt(k)=='-')  ) 
		  gaps++;
		}
		           
		System.out.println();
		           
		System.out.println(alignments[1] + " size:" + 
		                   alignments[1].length());
		System.out.println("Match Score=" + matches + ", " + 
		                   ((float)matches/alignments[0].length())+ 
		                   " gaps:" + gaps);
		           
		System.out.println("Edit Distance="+ result.getTotalCost());
		System.out.println("Alignment Length="+ 
		                    result.getAlignmentLength());
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
		System.out.println("Contagem de nucleotideos no DNA:");
		Count.count_bases_DNA(bases_dna, sequence);
		Count.count_bases_DNA(bases_dna, sequence2);

		/**
		 * totais de nucleotideos no material codificador
		*/
		
		System.out.println("Contagem de nucleotideos no RNA:");
		sequence_rna = Count.DNAtoRNA(bases_dna, sequence);
		Count.count_bases_RNA(bases_rna, sequence_rna);
		sequence_rna_2=Count.DNAtoRNA(bases_dna, sequence2);
		Count.count_bases_RNA(bases_rna, sequence_rna_2);
		 
	
		/**
		 * transitions and probability
		 */
		System.out.println("Contagem do numero de transiçoes e estimação de probabilidades: ");
		Transitions transitions = new Transitions(bases_dna, sequence, sequence2);
		transitions.print_matrix();
		System.out.println();
		transitions.print_matrix_prob();
		System.out.println("-----------------------------------------------------------");
		
		
		
		
		
		testNWAlignment("TATATCGC", "ATCATAT");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}