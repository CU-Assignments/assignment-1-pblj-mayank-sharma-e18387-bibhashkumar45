import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];
        int[][] diff = new int[rows][cols];
        int[][] product = new int[rows][cols];

        System.out.println("Enter elements of Matrix 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
                diff[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        if (rows == cols) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    product[i][j] = 0;
                    for (int k = 0; k < cols; k++) {
                        product[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        } else {
            System.out.println("Matrix multiplication is not possible for non-square matrices.");
        }

        System.out.println("Addition:");
        printMatrix(sum);
        
        System.out.println("Subtraction:");
        printMatrix(diff);
        
        if (rows == cols) {
            System.out.println("Multiplication:");
            printMatrix(product);
        }

        sc.close();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
