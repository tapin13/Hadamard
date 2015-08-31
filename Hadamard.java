
public class Hadamard {
	public static void main(String[] args) {
		int n = (int)Math.pow(2, 3);
		int[][] mat = new int[n][n];
		fillHadamard(mat);	
		
		printA(mat);
	}
	
	public static void fillHadamard(int mat[][]) {
		fillHadamard(mat, mat.length / 2);
	}
	
	public static void fillHadamard(int mat[][], int index) {
		if(index == 0) {
			mat[0][0] = 1;
			return;
		}
		
		fillHadamard(mat, index / 2);
		
		copy(mat, 0, 0, index, index, 0, 1);
		copy(mat, 0, 0, index, 0, index, 1);
		copy(mat, 0, 0, index, index, index, -1);
	}
	
	public static void copy(int m[][], int i, int j, int max, int shifti, int shiftj, int invert) {
		if(j == max) {
			j = 0;
			i = i + 1;
		}

		if(i == max) {
			return;
		}
		
		m[i + shifti][j + shiftj] = m[i][j] * invert;  
		
		copy(m, i, j + 1, max, shifti, shiftj, invert);
	}
	
	public static void printA(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print("[" + i + ", " + j + "]: " + mat[i][j] + "\t");
			}
			System.out.println("");
		}
	}	
}

