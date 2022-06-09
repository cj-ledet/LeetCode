class Solution {

    private HashMap<Integer, String> board = new HashMap();

    public String tictactoe(int[][] moves) {
            
            //board 0-8 is keys 0-8 in our hashmap
            //0,0 = key 0 | 0,1 = 1 | 0,2 = 2 | 1,0 = 3
            //1,1 = 4 | 1,2 = 5 | 2,0 = 6 | 2,1 = 7 | 2,2 = 8
            for (int i = 0; i < moves.length; i++) {
                //boardRow = moves[i][0];
                //boardCol = moves[i][1];
                String tmp = ((i % 2 == 0) ? "A":"B");
                board.put(moves[i][0] * 3 + moves[i][1], tmp);
                
                if(i > 3) { //requires 5th turn before someone can win
                    
                    //8 combinations can win
                    //0,1,2 | 3,4,5 | 6,7,8
                    //0,3,6 | 1,4,7 | 2,5,8
                    //0,4,8 | 6,4,2
                    if (checkSolutions(0,1,2) != null)
                        return board.get(0);
                    else if (checkSolutions(3,4,5) != null)
                        return board.get(3);
                    else if (checkSolutions(6,7,8) != null)
                        return board.get(6);
                    else if (checkSolutions(0,3,6) != null)
                        return board.get(0);
                    else if (checkSolutions(1,4,7) != null)
                        return board.get(1);
                    else if (checkSolutions(2,5,8) != null)
                        return board.get(2);
                    else if (checkSolutions(0,4,8) != null)
                        return board.get(0);
                    else if (checkSolutions(6,4,2) != null)
                        return board.get(6);
                    if(i == 8)
                    return "Draw";
                } 
            }
       return "Pending";
    }
    
    private String checkSolutions(int firstIndex, int secondIndex, int thirdIndex) {
        //Check if any of the solution locations are null first
        if(!(board.get(firstIndex) == null) && 
           !(board.get(secondIndex) == null) && 
           !(board.get(thirdIndex) == null) &&
           board.get(firstIndex).equals(board.get(secondIndex)) &&
           board.get(secondIndex).equals(board.get(thirdIndex)))
             return board.get(firstIndex);
        else
             return null;
    }       
}