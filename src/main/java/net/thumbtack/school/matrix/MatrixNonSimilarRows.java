package net.thumbtack.school.matrix;

import java.util.*;


public class MatrixNonSimilarRows {
    private final Map<Set<Integer>, int[]> matrixNotSim;

    public MatrixNonSimilarRows(int[][] matrix) {
        matrixNotSim = new HashMap<>();
        for (int[] array : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int value : array) {
                set.add(value);
            }
            matrixNotSim.put(set, array);
        }
    }

    public List<int[]> getNonSimilarRows() {
        return new LinkedList<>(matrixNotSim.values());
    }

}
