public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] matrixA = {
                {2, 3, 4},
                {3, 4, 5}
        };

        int[][] matrixB = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println("Matrix B:");
        printMatrix(matrixB);

        if (!canMultiply(matrixA, matrixB)) {
            System.out.println("Matrices A and B cannot be multiplied.");
            return;
        }

        int[][] product = multiply(matrixA, matrixB);
        System.out.println("Product A * B:");
        printMatrix(product);
    }

    public static boolean canMultiply(int[][] matrixA, int[][] matrixB) {
        return isRectangular(matrixA)
                && isRectangular(matrixB)
                && matrixA[0].length == matrixB.length;
    }

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        if (!canMultiply(matrixA, matrixB)) {
            throw new IllegalArgumentException(
                    "The number of columns in A must equal the number of rows in B."
            );
        }

        int rows = matrixA.length;
        int sharedDimension = matrixA[0].length;
        int columns = matrixB[0].length;
        int[][] product = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                for (int index = 0; index < sharedDimension; index++) {
                    product[row][column] +=
                            matrixA[row][index] * matrixB[index][column];
                }
            }
        }

        return product;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[ ");

            for (int value : row) {
                System.out.printf("%4d", value);
            }

            System.out.println(" ]");
        }

        System.out.println();
    }

    private static boolean isRectangular(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int expectedColumns = matrix[0].length;

        for (int[] row : matrix) {
            if (row == null || row.length != expectedColumns) {
                return false;
            }
        }

        return true;
    }
}
