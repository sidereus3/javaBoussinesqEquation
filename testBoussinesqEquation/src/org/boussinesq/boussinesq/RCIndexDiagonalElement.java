package org.boussinesq.boussinesq;

public class RCIndexDiagonalElement {

	/**
	 * Compute index of diagonal.
	 * 
	 * @desc this method computes the indices of the diagonal of the adjacency
	 *       matrix; this matrix and all the sparse matrices are stored in Row
	 *       Compressed Form. More information at the web site
	 *       https://en.wikipedia.org/wiki/Sparse_matrix
	 * 
	 * @param mesh
	 *            the object mesh is passed so every field of the mesh class is
	 *            available
	 * 
	 * @return the array that holds the indices of the diagonal entries of the
	 *         sparse adjacency matrix in Row Compressed Form
	 */
	public int[] computeIndexDiag() {

		// declaration of the array that holds the indices of diagonal entries
		int[] indexDiag = new int[Mesh.Np];

		/* for-loop to analyze the matrix cell by cell */
		for (int i = 0; i < Mesh.Np; i++) {
			/*
			 * nested for-loop to analyze diagonal entries, which are identified
			 * by a negative number
			 */
			for (int j = Mesh.Mp[i]; j < Mesh.Mp[i + 1]; j++) {

				if (Mesh.Mi[j] == i) {
					indexDiag[i] = j;
				}

			}
		}

		return indexDiag;
	}
	
}
