
import java.util.ArrayList;

public class ChessPieces {

    public static void main(String[] args){
        String[] pieceValue = new String[]{"knight", "b7", "b5"};
        boolean validMove = false;
        ArrayList<Integer> numericalPosition;

        numericalPosition = findNumericalPosition(pieceValue[1], pieceValue[2]);

        switch (pieceValue[0]){
            case "pawn": validMove = pawnMoves(numericalPosition); break;
            case "knight": validMove = knightMoves(numericalPosition); break;
            case "bishop": validMove = bishopMoves(numericalPosition); break;
            case "rook": validMove = rookMoves(numericalPosition); break;
            case "queen": validMove = queenMoves(numericalPosition); break;
            case "king": validMove = kingMoves(numericalPosition); break;
        }

        if (validMove) System.out.println(pieceValue[0] + " " + pieceValue[1] + " -> " + pieceValue[2] + " is a valid move.");
        else System.out.println(pieceValue[0] + " " + pieceValue[1] + " -> " + pieceValue[2] + " is not a valid move.");
    }

    public static ArrayList<Integer> findNumericalPosition (String a, String b){
        // Converts positions into integer arraylist (startFile, startRow, endFile, endRow) for easier use later.
        char[] start = a.toCharArray();
        char[] end = b.toCharArray();
        ArrayList<Integer> numericalPos = new ArrayList<>();
        numericalPos.add((int) start[0] - 96);
        numericalPos.add((int) start[1] - 48);
        numericalPos.add((int) end[0] - 96);
        numericalPos.add((int) end[1] - 48);
        return  numericalPos;
    }

    public static boolean pawnMoves(ArrayList<Integer> pos){
        for (int i: pos){
            if (i > 8 || i < 1) return false;
        }

        if (!pos.get(0).equals(pos.get(2))) return false;
        else if (pos.get(1) == 2 && Math.abs(pos.get(1) - pos.get(3)) == 2) return true;
        else if (pos.get(1) == 7 && Math.abs(pos.get(1) - pos.get(3)) == 2) return true;
        else return Math.abs(pos.get(1) - pos.get(3)) == 1;
    }

    public static boolean knightMoves(ArrayList<Integer> pos){
        for (int i: pos){
            if (i > 8 || i < 1) return false;
        }

        if (Math.abs(pos.get(0) - pos.get(2)) == 2 && Math.abs(pos.get(1) - pos.get(3)) == 1) return true;
        return Math.abs(pos.get(1) - pos.get(3)) == 2 && Math.abs(pos.get(0) - pos.get(2)) == 1;
    }

    public static boolean bishopMoves(ArrayList<Integer> pos){
        for (int i: pos){
            if (i > 8 || i < 1) return false;
        }

        return Math.abs(pos.get(0) - pos.get(2)) == Math.abs(pos.get(1) - pos.get(3));
    }

    public static boolean rookMoves(ArrayList<Integer> pos){
        for (int i: pos){
            if (i > 8 || i < 1) return false;
        }

        return pos.get(0).equals(pos.get(2)) || pos.get(1).equals(pos.get(3));
    }

    public static boolean queenMoves(ArrayList<Integer> pos){
        for (int i: pos){
            if (i > 8 || i < 1) return false;
        }

        if (Math.abs(pos.get(0) - pos.get(2)) == Math.abs(pos.get(1) - pos.get(3))) return true;
        else if (pos.get(0).equals(pos.get(2)) && !pos.get(1).equals(pos.get(3))) return true;
        else return !pos.get(0).equals(pos.get(2)) && pos.get(1).equals(pos.get(3));
    }

    public static boolean kingMoves(ArrayList<Integer> pos){
        for (int i: pos){
            if (i > 8 || i < 1) return false;
        }

        if (Math.abs(pos.get(0) - pos.get(2)) > 1) return false;
        else return Math.abs(pos.get(1) - pos.get(3)) <= 1;
    }
}
