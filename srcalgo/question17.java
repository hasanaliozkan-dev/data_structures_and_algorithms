public class question17 {
    static int getLargest(int[][] matrix, int row, int column) {
    if(row<0||column<0||row>=matrix.length||column>=matrix[row].length)
        return 0;
    if (matrix[row][column] == 0)
        return 0;
    matrix[row][column] = 0;
    int large = 1;
    for (int i = row-1; i <=row+1 ; i++) {
        for (int j = column-1; j <=column +1 ; j++) {
            if(i != row || j != column){
                large += getLargest(matrix,i,j);
            }
        }
    }
    return large;
}
    static int connectedCell(int[][] matrix) {
        //Depth first search(Derin öncelikli arama) önemli.
        //Bitbucket find sequence.
        int largest =0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if (matrix[i][j]==1){
                    int size = getLargest(matrix,i,j);
                    largest = Math.max(size,largest);
                }
            }
        }

        return largest;
    }


}
