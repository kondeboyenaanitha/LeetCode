class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        def solveSudoku(board):
            empty_cell = findEmptyCell(board)
            if not empty_cell:

                return True

            else:

                row = empty_cell[0]

                col = empty_cell[1]

            for num in range(1, 10):

                if isValidMove(board, row, col, str(num)):

                 

                    board[row][col] = str(num)

                    if solveSudoku(board):

                        return True

                    board[row][col] = "."

            return False
        def findEmptyCell(board):

            for i in range(9):

                for j in range(9):

                    if board[i][j] == ".":

                        return (i, j)

            return None
        def isValidMove(board, row, col, num):

            if num in board[row]:

                return False

            for i in range(9):

                if board[i][col] == num:

                    return False

            start_row, start_col = 3 * (row // 3), 3 * (col // 3)

            for i in range(start_row, start_row + 3):

                for j in range(start_col, start_col + 3):

                    if board[i][j] == num:

                        return False

        

            return True

        

        def printBoard(board):

            for row in board:

                print(" ".join(row))
        if solveSudoku(board):

            print("Solution:")

            printBoard(board)

        else:

            print("No solution exists.")    


        