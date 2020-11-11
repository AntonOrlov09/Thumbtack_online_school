package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            int sum = 0;
            for (int value : array) {
                sum += value;
            }
            return sum;
        }
    }

    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            int mul = 1;
            for (int value : array) {
                mul *= value;
            }
            return mul;
        }
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            float sum = sum(array);
            return sum / array.length;
        }
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int elem : array) {
            if (elem == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            sum += sum(ints);
        }
        return sum;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : matrix) {
            if (max < max(ints)) {
                max = max(ints);
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int diagonalMax = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 0) {
                if (matrix[i][i] > diagonalMax) {
                    diagonalMax = matrix[i][i];
                }
            }
        }
        return diagonalMax;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] ints : matrix) {
            if (!isSortedDescendant(ints)) {
                return false;
            }
        }
        return true;
    }
}
