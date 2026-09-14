import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // Skip empty cells represented by '.'
                if (val != '.') {
                    // Formulate unique keys for row, column, and 3x3 sub-box
                    String rowKey = val + " in row " + r;
                    String colKey = val + " in col " + c;
                    String boxKey = val + " in block " + (r / 3) + "-" + (c / 3);
                    
                    // If add() returns false, the value already exists in that row, col, or box
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
