import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
final class ValidSudoku {
    // look at every integer on the board
    // encode the information about the current integer using three values
    // each value has three digits: <type><index><num>
    //
    // type is in [1, 3]
    // 1 => row, 2 => column, 3 => box
    //
    // index is in [0, 8]
    // rows go from top to bottom
    // columns go from left to right
    // boxes go from left to right, top to bottom
    //
    // num is just the current integer in [1, 9]
    //
    // store these encoded values in a set
    // if the set contains these any of these values already, return false
    // if we make it through the entire board, return true
    //
    // notes:
    // every time the row index goes up by three, the box index increases by three
    // every time the column index goes up by three, the box index increases by one
    public boolean isValidSudoku(final char[][] board) {
        final Set<Integer> vals = new HashSet<>();
        for (int rowIdx = 0; rowIdx < board.length; rowIdx++)
            for (int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
                final char c = board[rowIdx][colIdx];
                if (c == '.') continue;
                final int num = c - '0';
                final int rowVal = 100 + (rowIdx * 10) + num;
                final int colVal = 200 + (colIdx * 10) + num;
                final int boxIdx = rowIdx / 3 * 3 + colIdx / 3;
                final int boxVal = 300 + (boxIdx * 10) + num;
                if (!vals.add(rowVal) || !vals.add(colVal) || !vals.add(boxVal))
                    return false;
            }
        return true;
    }
}