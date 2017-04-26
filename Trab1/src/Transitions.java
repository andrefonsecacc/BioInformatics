
public class Transitions {

	public String[] bases_dna;
	public String[] sequence;
	public String[] sequence2;

	public String[] sequence_dna;
	public String[] sequence_dna_2;

	/* 0->U 1->C 2->A 3->G */
	public int[][] transitionMatrix = new int[4][4];

	/**
	 * 
	 * @param b
	 * @param s
	 * @param s2
	 */
	Transitions(String[] b, String[] s, String[] s2) {
		this.bases_dna = b;
		this.sequence = s;
		this.sequence2 = s2;
		sequence_dna = get_DNA(this.bases_dna, this.sequence);
		sequence_dna_2 = get_DNA(this.bases_dna, this.sequence2);
		fill_Matrix(sequence_dna, sequence_dna_2);
	}

	/**
	 * Just get sequence of DNA
	 * 
	 * @param bases
	 * @param sequence
	 * @return
	 */
	public String[] get_DNA(String[] bases, String[] sequence) {

		int k = 0;
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
				arr[j] = sequence[i];
				j++;

			}
		}

		return arr;

	}

	/**
	 * Fill the transition Matrix, sequence1 transition to sequence2
	 * 
	 * @param sequence
	 * @param sequence2
	 */
	void fill_Matrix(String[] sequence, String[] sequence2) {
		int minLen;
		/* find out first the lowest sequence */
		if (sequence.length <= sequence2.length) {
			minLen = sequence.length;
		} else {
			minLen = sequence2.length;
		}
		/* sequence is rows */
		for (int i = 0; i <= minLen; i++) {
			if (sequence[i].equals("U")) {
				if (sequence2[i].equals("U")) {
					transitionMatrix[0][0]++;
				} else if (sequence2[i].equals("C")) {
					transitionMatrix[0][1]++;
				} else if (sequence2[i].equals("A")) {
					transitionMatrix[0][2]++;
				} else {
					transitionMatrix[0][3]++;
				}
			} else if (sequence[i].equals("C")) {
				if (sequence2[i].equals("U")) {
					transitionMatrix[1][0]++;
				} else if (sequence2[i].equals("C")) {
					transitionMatrix[1][1]++;
				} else if (sequence2[i].equals("A")) {
					transitionMatrix[1][2]++;
				} else {
					transitionMatrix[1][3]++;
				}
			} else if (sequence[i].equals("A")) {
				if (sequence2[i].equals("U")) {
					transitionMatrix[2][0]++;
				} else if (sequence2[i].equals("C")) {
					transitionMatrix[2][1]++;
				} else if (sequence2[i].equals("A")) {
					transitionMatrix[2][2]++;
				} else {
					transitionMatrix[2][3]++;
				}
			} else {
				if (sequence2[i].equals("U")) {
					transitionMatrix[3][0]++;
				} else if (sequence2[i].equals("C")) {
					transitionMatrix[3][1]++;
				} else if (sequence2[i].equals("A")) {
					transitionMatrix[3][2]++;
				} else {
					transitionMatrix[3][3]++;
				}
			}
		}

	}

}
