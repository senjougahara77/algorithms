class Solution {
    String word;
    int m;
    int n;
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        m = board.length;
        n = board[0].length;
        this.word = word;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (res) return true;
                if (board[i][j] == word.charAt(0)){
                    dfs(board, i, j, 0);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] board, int a, int b, int l) {
        if (l == word.length()) {
            res = true;
            return;
        }
        if (a < 0 || a >= m || b < 0 || b >= n || word.charAt(l) != board[a][b]) {
            return;
        }
        char temp = board[a][b];
        board[a][b] = '0';
        dfs(board, a, b - 1, l + 1);
        dfs(board, a - 1, b, l + 1);
        dfs(board, a + 1, b, l + 1);
        dfs(board, a, b + 1, l + 1);
        board[a][b] = temp;
    }
}
