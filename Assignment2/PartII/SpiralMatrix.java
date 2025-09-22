public class SpiralMatrix {

    // 螺旋遍历：从左上角开始 右→下→左→上
    public static int[] spiral(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) return new int[0];

        int m = a.length, n = a[0].length;
        int[] b = new int[m * n];
        int k = 0;

        int t = 0, d = m - 1, l = 0, r = n - 1; // top, down, left, right

        while (t <= d && l <= r) {
            // 顶行：左->右
            for (int j = l; j <= r; j++) b[k++] = a[t][j];
            // 右列：上->下（从下一行开始，避免重复拐角）
            for (int i = t + 1; i <= d; i++) b[k++] = a[i][r];
            // 底行：右->左（需要至少两行）
            if (t < d) for (int j = r - 1; j >= l; j--) b[k++] = a[d][j];
            // 左列：下->上（需要至少两列）
            if (l < r) for (int i = d - 1; i > t; i--) b[k++] = a[i][l];

            t++; d--; l++; r--; // 收缩一圈
        }
        return b;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                {13, 14, 15, 16 },
                {17, 18, 19, 20 }
        };

        // 你之前用的是 a，这里把它定义出来
        int[][] a = matrix;

        // print out the matrix using loops
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
                if (j < a[i].length - 1) System.out.print(" ");
            }
            System.out.println();
        }

        // call spiralMatrix and print out the result
        int[] b = spiral(a);
        System.out.print("Spiral order: [");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            if (i < b.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
