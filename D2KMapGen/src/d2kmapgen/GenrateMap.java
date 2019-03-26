package d2kmapgen;

import static d2kmapgen.BlockData.getBlockData;
import static d2kmapgen.BlockData.getBlockDataSpecial;
import static d2kmapgen.BlockData.getSize;
import static d2kmapgen.Tiles.isAnEntranceEdge;
import java.io.IOException;
import java.util.Random;

public class GenrateMap {
    public static int[][] autoSpaceSpawns(int[][] mainBoard, int boardR, int boardC, int numberOfSpawnsToAdd){
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = (boardR - 1) - 6;
        int maxC = (boardC - 1) - 6;
        int min = (0) + 6;
        int counter = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 8);
        
        counter = 0;
        attempts = 0;
        do{
            for(int i = (int)Math.ceil(Math.sqrt(boardR * boardC)); i > 1; i-=4){
                
                for(int ii = 0; ii != (int)Math.ceil(Math.sqrt(boardR * boardC) * 4); ii++){
                    randR = rand.nextInt((maxR - min) + 1) + min;
                    randC = rand.nextInt((maxC - min) + 1) + min;
                    attempts++;

                    try{
                        if(roomForSpawn(mainBoard, boardR, boardC, randR, randC, i) == true){
                            if(counter < numberOfSpawnsToAdd){
                                mainBoard[randR][randC] = 54349;
                                counter++;
                                
                            }

                        }else{

                        }
                    }catch(IndexOutOfBoundsException e){

                    }
                    
                    if(attempts >= attemptsLimit){
                        counter = 999999999;
                        numberOfSpawnsToAdd = 0;

                    }
                }
            }
            
        }while(counter < numberOfSpawnsToAdd);
        
        return mainBoard;
    }
    
    public static boolean roomForCountedSpawn(int[][] mainBoard, int boardR, int boardC, int randR, int randC){
        boolean foundNonRock = false;
        
        for(int ic = -2; ic != 3; ic++){
            for(int ir = -2; ir != 3; ir++){
                try{
                    if(mainBoard[randR + ir][randC + ic] != 1){
                        foundNonRock = true;
                        
                    }else{
                        
                        
                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        if(foundNonRock == false){
            return true;
            
        }else{
            return false;
            
        }
    }
    
    public static int[][] countSpawns(int[][] mainBoard, int boardR, int boardC){
        int counter = 0;
        Random rand = new Random();
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int randR = 0;
        int randC = 0;
        int numberOfSpawns = 0;
        int exceptionCounter = 0;
        int exceptionLimit = (boardR * boardC * 32);
        
            for(int c = 0; c != boardC; c++){
                for(int r = 0; r != boardR; r++){
                    if(mainBoard[r][c] == 54349){
                        numberOfSpawns++;

                    }
                }
            }

            if(numberOfSpawns < 8){
                do{
                    if(exceptionCounter >= exceptionLimit){

                        randR = rand.nextInt((maxR - min) + 1) + min;
                        randC = rand.nextInt((maxC - min) + 1) + min;

                        if(mainBoard[randR][randC] == 54341 ){
                            mainBoard[randR][randC] = 54349;
                            counter++;

                        }
                    }else{
                        randR = rand.nextInt((maxR - min) + 1) + min;
                        randC = rand.nextInt((maxC - min) + 1) + min;

                        if(mainBoard[randR][randC] == 54341 && roomForCountedSpawn(mainBoard, boardR, boardC, randR, randC) == true){ //&& checkForEntrancesBoolean(mainBoard, boardR, boardC, 2, randR, randC) == true){
                            mainBoard[randR][randC] = 54349;
                            counter++;

                        }else{
                            exceptionCounter++;

                        }
                    }

                }while(counter < (8 - numberOfSpawns));

            }else if(numberOfSpawns == 8){

            }else if(numberOfSpawns > 8){
                do{
                    randR = rand.nextInt((maxR - min) + 1) + min;
                    randC = rand.nextInt((maxC - min) + 1) + min;

                    if(mainBoard[randR][randC] == 54349){
                        mainBoard[randR][randC] = 54341;
                        counter++;

                    }

                }while(counter < (numberOfSpawns - 8));

            }
        
        return mainBoard;
    }
    
    public static int[][] addIslands(int[][] mainBoard, int boardR, int boardC, 
            int numberOfIslandsToAdd, int numberOfIslandSquares, int islandSquareTop, int islandSquareRight, int islandSquareBottom, int islandSquareLeft, 
            int numberOfIslandSquaresAtATime){
        int count = 0;
        Random rand = new Random();
        int max = 1;
        int randVar = 0;
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        boolean room = true;
        int counter = 0;
        int counterInner = -1;
        int[] edges = new int[2];
        int[][] mainBoardTemp = mainBoard;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        
        int[] values = new int[4];
        int[] valuesToUse = new int[4];
        
        values[0] = islandSquareTop;
        values[1] = islandSquareRight;
        values[2] = islandSquareBottom;
        values[3] = islandSquareLeft;
        
        attempts = 0;
        do{
            room = true;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            for(int ic = -2; ic != 3; ic++){
                for(int ir = -2; ir != 3; ir++){
                    try{
                        if(mainBoard[randR + ir][randC + ic] == 54340 ){


                        }else{
                            room = false;

                        }
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                    
                }
            }
            
            if(room == true){
                for(int ic = -1; ic != 2; ic++){
                    for(int ir = -1; ir != 2; ir++){
                        try{
                            mainBoard[randR + ir][randC + ic] = 5434151;
                            
                        }catch(IndexOutOfBoundsException e){
                        
                        }
                    }
                }
                
                mainBoard[randR][randC] = 5434151;
                count++;
            
            }else{
                
            }
            
            if(attempts >= attemptsLimit){
                count = 999999999;
                numberOfIslandsToAdd = 0;

            }
            
        }while(count < numberOfIslandsToAdd);
        
        counter = 0;
        do{
            edges = findAnEdgeSquare(mainBoard, boardR, boardC, 4);
            
            if(edges[0] == -1){
                counter = 999999999;
                numberOfIslandSquares = 0;
                
            }
            
            counterInner++;
            counter++;
            
            valuesToUse[0] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[1] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[2] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[3] = values[rand.nextInt((3 - 0) + 1) + 0];
            
            for(int newC = (edges[1] - valuesToUse[0]); newC != (edges[1] + valuesToUse[1] + 1); newC++){
                for(int newR = (edges[0] - valuesToUse[2]); newR != (edges[0] + valuesToUse[3] + 1); newR++){
                    try{
                        if(mainBoardTemp[newR][newC] == 54340 ){
                            mainBoardTemp[newR][newC] = 5434151;
                            
                        }
                        
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                }
            }
            
            if(counterInner >= numberOfIslandSquaresAtATime){
                mainBoard = mainBoardTemp;
                counterInner = -1;
                
            }
            
        }while(counter < numberOfIslandSquares);
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r][c + 1] == 54340 && mainBoard[r][c + 2] == 5434151){
                        mainBoard[r][c + 1] = 5434151;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 5434151){
                        mainBoard[r + 1][c] = 5434151;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 && mainBoard[r][c + 3] == 5434151){
                        mainBoard[r][c + 1] = 5434151;
                        mainBoard[r][c + 2] = 5434151;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 && mainBoard[r + 3][c] == 5434151){
                        mainBoard[r + 1][c] = 5434151;
                        mainBoard[r + 2][c] = 5434151;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && 
                            mainBoard[r][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 && mainBoard[r][c + 3] == 54340 
                            && mainBoard[r][c + 4] == 5434151){
                        mainBoard[r][c + 1] = 5434151;
                        mainBoard[r][c + 2] = 5434151;
                        mainBoard[r][c + 3] = 5434151;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && 
                            mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 && mainBoard[r + 3][c] == 54340 
                            && mainBoard[r + 4][c] == 5434151){
                        mainBoard[r + 1][c] = 5434151;
                        mainBoard[r + 2][c] = 5434151;
                        mainBoard[r + 3][c] = 5434151;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 5434151){
                        if(mainBoard[r][c - 1] != 5434151 && mainBoard[r][c - 1] != 5434152
                                || mainBoard[r + 1][c] != 5434151 && mainBoard[r + 1][c] != 5434152
                                || mainBoard[r][c + 1] != 5434151 && mainBoard[r][c + 1] != 5434152
                                || mainBoard[r - 1][c] != 5434151 && mainBoard[r - 1][c] != 5434152
                                
                                || mainBoard[r - 1][c - 1] != 5434151 && mainBoard[r - 1][c - 1] != 5434152
                                || mainBoard[r + 1][c - 1] != 5434151 && mainBoard[r + 1][c - 1] != 5434152
                                || mainBoard[r + 1][c + 1] != 5434151 && mainBoard[r + 1][c + 1] != 5434152
                                || mainBoard[r - 1][c + 1] != 5434151 && mainBoard[r - 1][c + 1] != 5434152){
                            if(outOfBounds(mainBoard, (r), (c - 1)) == true
                                    || outOfBounds(mainBoard, (r + 1), (c)) == true
                                    || outOfBounds(mainBoard, (r), (c + 1)) == true
                                    || outOfBounds(mainBoard, (r - 1), (c)) == true
                                    
                                    || outOfBounds(mainBoard, (r - 1), (c - 1)) == true
                                    || outOfBounds(mainBoard, (r + 1), (c - 1)) == true
                                    || outOfBounds(mainBoard, (r + 1), (c + 1)) == true
                                    || outOfBounds(mainBoard, (r - 1), (c + 1)) == true){
                                
                            }else{
                                mainBoard[r][c] = 5434152;
                                
                            }
                            
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 5434152 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c] == 54340 && mainBoard[r][c + 1] == 54340 && mainBoard[r - 1][c] == 5434152){
                        mainBoard[r][c] = 54340;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434152 
                            && mainBoard[r][c - 1] == 5434152 && mainBoard[r + 1][c] == 54340 && mainBoard[r][c + 1] == 54340 && mainBoard[r - 1][c] == 54340 ){
                        mainBoard[r][c] = 54340;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434152 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c] == 5434152 && mainBoard[r][c + 1] == 54340 && mainBoard[r - 1][c] == 54340 ){
                        mainBoard[r][c] = 54340;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434152 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c] == 54340 && mainBoard[r][c + 1] == 5434152 && mainBoard[r - 1][c] == 54340 ){
                        mainBoard[r][c] = 54340;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r][c - 1] == 54340 ){
                        mainBoard[r][c] = 5434152;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r + 1][c] == 54340 ){
                        mainBoard[r][c] = 5434152;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r][c + 1] == 54340 ){
                        mainBoard[r][c] = 5434152;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 5434151 && mainBoard[r - 1][c] == 54340 ){
                        mainBoard[r][c] = 5434152;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 5434152){
                    mainBoard[r][c] = 543438;
                    
                }
                
                if(mainBoard[r][c] == 5434151){
                    mainBoard[r][c] = 54341;
                    
                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] removeDuplicates(int[][] mainBoard, int boardR, int boardC){
        int[] smallList = new int[40];
        
        
        for(int i = 0; i != 4; i++){
            for(int c = 0; c != boardC; c++){
                for(int r = 0; r != boardR; r++){
                    
                    
                }
            }
        }
        
        return mainBoard;
    }
    
    public static boolean checkForEntrancesBoolean(int[][] mainBoard, int boardR, int boardC, int entranceSize, int r, int c){
        Random rand = new Random();//0 - up, 1 - right, 2 - down, 3 - left, corner directios too
        int max = 3;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int maxDirections = 3;
        int min = 0;
        int counter = 0;
        int timesCounter = 0;
        boolean foundSpot = false;
        int corR = 0;
        int corC = 0;
        int[][] mainBoardTemp = mainBoard;
        boolean foundEntrance = false;
        int newR = 0;
        int newC = 0;
        int newRSpawn = 0;
        int newCSpawn = 0;
        boolean foundRock = false;
        boolean isASpawn = false;
        
//        if(mainBoard[r][c] == 54349){
            foundEntrance = false;
            foundRock = false;
            isASpawn = false;

            for(int direction = 0; direction != 4; direction++){
                foundSpot = false;
                counter = 0;

                if(direction == 0){
                    do{
                        counter++;
                        try{
                            if(mainBoard[r][c - counter] == 543438){
                                foundSpot = true;
                                foundEntrance = true;
//                                        System.out.println(" ent " + r + " " + (c - counter) + " " + mainBoard[r][c - counter]);

                            }

                            if(mainBoard[r][c - counter] == 54340 ){// stop, no entrance
                                foundSpot = true;//and ignore

                            }
                        }catch(IndexOutOfBoundsException e){
                            foundSpot = true;//and ignore

                        }
                    }while(foundSpot == false);

                }else if(direction == 1){
                    do{
                        counter++;
                        try{
                            if(mainBoard[r + counter][c] == 543438){
                                foundSpot = true;
                                foundEntrance = true;
//                                        System.out.println(" ent " + (r + counter) + " " + c + " " + mainBoard[r + counter][c]);

                            }

                            if(mainBoard[r + counter][c] == 54340 ){// stop, no entrance
                                foundSpot = true;//and ignore

                            }
                        }catch(IndexOutOfBoundsException e){
                            foundSpot = true;//and ignore

                        }
                    }while(foundSpot == false);

                }else if(direction == 2){
                    do{
                        counter++;
                        try{
                            if(mainBoard[r][c + counter] == 543438){
                                foundSpot = true;
                                foundEntrance = true;
//                                        System.out.println(" ent " + r + " " + (c + counter) + " " + mainBoard[r][c + counter]);

                            }

                            if(mainBoard[r][c + counter] == 54340 ){// stop, no entrance
                                foundSpot = true;//and ignore

                            }
                        }catch(IndexOutOfBoundsException e){
                            foundSpot = true;//and ignore

                        }
                    }while(foundSpot == false);

                }else if(direction == 3){
                    do{
                        counter++;
                        try{
                            if(mainBoard[r - counter][c] == 543438){
                                foundSpot = true;
                                foundEntrance = true;
//                                        System.out.println(" ent " + (r - counter) + " " + c + " " + mainBoard[r - counter][c]);

                            }

                            if(mainBoard[r - counter][c] == 54340 ){// stop, no entrance
                                foundSpot = true;//and ignore

                            }
                        }catch(IndexOutOfBoundsException e){
                            foundSpot = true;//and ignore

                        }
                    }while(foundSpot == false);
                }
            }

            
//        }
     
        return foundEntrance;
    }
    
    public static int[][] checkForEntrances(int[][] mainBoard, int boardR, int boardC, int entranceSize){
        int counter = 0;
        boolean foundSpot = false;
        boolean foundEntrance = false;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 54349){
                    foundEntrance = false;
                    
                    for(int direction = 0; direction != 4; direction++){
                        foundSpot = false;
                        counter = 0;

                        if(direction == 0){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r][c - counter] == 543438){
                                        foundSpot = true;
                                        foundEntrance = true;

                                    }
                                    
                                    if(mainBoard[r][c - counter] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }
                            }while(foundSpot == false);

                        }else if(direction == 1){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r + counter][c] == 543438){
                                        foundSpot = true;
                                        foundEntrance = true;

                                    }
                                    
                                    if(mainBoard[r + counter][c] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }
                            }while(foundSpot == false);

                        }else if(direction == 2){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r][c + counter] == 543438){
                                        foundSpot = true;
                                        foundEntrance = true;

                                    }
                                    
                                    if(mainBoard[r][c + counter] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }
                            }while(foundSpot == false);

                        }else if(direction == 3){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r - counter][c] == 543438){
                                        foundSpot = true;
                                        foundEntrance = true;

                                    }
                                    
                                    if(mainBoard[r - counter][c] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }
                            }while(foundSpot == false);
                        }
                    }
                    
                    if(foundEntrance == true){

                    }else{
                        mainBoard[r][c] = 54341;

                    }
                }
            }
        }
     
        return mainBoard;
    }
    
    public static int[][] reapplyEntranceEdgesSimple(int[][] mainBoard, int boardR, int boardC) throws IOException{
        int[] tempCliff = new int[4];
        int[] tempCliff2 = new int[2];
	int[] anticipatedSize = new int[2];
        int[][] list = new int[8][4];
        boolean reapplyed = false;
        int counter = 0;
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, '9', anticipatedSize);
        list[0][0] = tempCliff[0];
        list[0][1] = tempCliff[1];
        list[0][2] = tempCliff[2];
        list[0][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, '6', anticipatedSize);
        list[1][0] = tempCliff[0];
        list[1][1] = tempCliff[1];
        list[1][2] = tempCliff[2];
        list[1][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'L', anticipatedSize);
        list[2][0] = tempCliff[0];
        list[2][1] = tempCliff[1];
        list[2][2] = tempCliff[2];
        list[2][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 1;
        tempCliff = getBlockData("BLOXBGBS", 1, 'O', anticipatedSize);
        tempCliff2 = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
        list[3][0] = tempCliff[0];
        list[3][1] = tempCliff[1];
        list[3][2] = tempCliff2[0];
        list[3][3] = tempCliff2[1];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, '>', anticipatedSize);
        list[4][0] = tempCliff[0];
        list[4][1] = tempCliff[1];
        list[4][2] = tempCliff[2];
        list[4][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'N', anticipatedSize);
        list[5][0] = tempCliff[0];
        list[5][1] = tempCliff[1];
        list[5][2] = tempCliff[2];
        list[5][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'H', anticipatedSize);
        list[6][0] = tempCliff[0];
        list[6][1] = tempCliff[1];
        list[6][2] = tempCliff[2];
        list[6][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'Y', anticipatedSize);
        list[7][0] = tempCliff[0];
        list[7][1] = tempCliff[1];
        list[7][2] = tempCliff[2];
        list[7][3] = tempCliff[3];
        
        for(int c = 0; c < boardC; c++){
            for(int r = 0; r < boardR; r++){
                reapplyed = false;
                counter = 0;
                
                do{
                    counter++;
                    
                    //top left
                    if(reapplyed == false && mainBoard[r][c] == list[counter][0]){
                        try{
                            if(mainBoard[r][c] == list[counter][0]){
                                mainBoard[r][c] = list[counter][0];
                                mainBoard[r + 1][c] = list[counter][1];
                                mainBoard[r][c + 1] = list[counter][2];
                                mainBoard[r + 1][c + 1] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }else if(reapplyed == false && mainBoard[r][c] == list[counter][1]){//top right
                        try{
                            if(mainBoard[r][c] == list[counter][1]){
                                mainBoard[r - 1][c] = list[counter][0];
                                mainBoard[r][c] = list[counter][1];
                                mainBoard[r - 1][c + 1] = list[counter][2];
                                mainBoard[r][c + 1] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }else if(reapplyed == false && mainBoard[r][c] == list[counter][3]){//bottom right
                        try{
                            if(mainBoard[r][c] == list[counter][3]){
                                mainBoard[r - 1][c - 1] = list[counter][0];
                                mainBoard[r][c - 1] = list[counter][1];
                                mainBoard[r - 1][c] = list[counter][2];
                                mainBoard[r][c] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }else if(reapplyed == false && mainBoard[r][c] == list[counter][3]){//bottom left
                        try{
                            if(mainBoard[r][c] == list[counter][3]){
                                mainBoard[r][c - 1] = list[counter][0];
                                mainBoard[r + 1][c - 1] = list[counter][1];
                                mainBoard[r][c] = list[counter][2];
                                mainBoard[r + 1][c] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }
                    
                    if(counter > 6){
                        reapplyed = true; 
                        
                    }
                }while(reapplyed == false);
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] reapplyEntranceEdges(int[][] mainBoard, int boardR, int boardC) throws IOException{
        int[] tempCliff = new int[4];
        int[] tempCliff2 = new int[2];
	int[] anticipatedSize = new int[2];
        int[][] list = new int[8][4];
        boolean reapplyed = false;
        int counter = 0;
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, '9', anticipatedSize);
        list[0][0] = tempCliff[0];
        list[0][1] = tempCliff[1];
        list[0][2] = tempCliff[2];
        list[0][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, '6', anticipatedSize);
        list[1][0] = tempCliff[0];
        list[1][1] = tempCliff[1];
        list[1][2] = tempCliff[2];
        list[1][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'L', anticipatedSize);
        list[2][0] = tempCliff[0];
        list[2][1] = tempCliff[1];
        list[2][2] = tempCliff[2];
        list[2][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 1;
        tempCliff = getBlockData("BLOXBGBS", 1, 'O', anticipatedSize);
        tempCliff2 = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
        list[3][0] = tempCliff[0];
        list[3][1] = tempCliff[1];
        list[3][2] = tempCliff2[0];
        list[3][3] = tempCliff2[1];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, '>', anticipatedSize);
        list[4][0] = tempCliff[0];
        list[4][1] = tempCliff[1];
        list[4][2] = tempCliff[2];
        list[4][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'N', anticipatedSize);
        list[5][0] = tempCliff[0];
        list[5][1] = tempCliff[1];
        list[5][2] = tempCliff[2];
        list[5][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'H', anticipatedSize);
        list[6][0] = tempCliff[0];
        list[6][1] = tempCliff[1];
        list[6][2] = tempCliff[2];
        list[6][3] = tempCliff[3];
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'Y', anticipatedSize);
        list[7][0] = tempCliff[0];
        list[7][1] = tempCliff[1];
        list[7][2] = tempCliff[2];
        list[7][3] = tempCliff[3];
        
        for(int c = 0; c < boardC; c++){
            for(int r = 0; r < boardR; r++){
                reapplyed = false;
                counter = 0;
                
                do{
                    counter++;
                    
                    //top left
                    if(reapplyed == false && mainBoard[r][c] == list[counter][0]){
                        try{
                            if(mainBoard[r][c] == list[counter][0]){
                                mainBoard[r][c] = list[counter][0];
                                mainBoard[r + 1][c] = list[counter][1];
                                mainBoard[r][c + 1] = list[counter][2];
                                mainBoard[r + 1][c + 1] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }else if(reapplyed == false && mainBoard[r][c] == list[counter][1]){//top right
                        try{
                            if(mainBoard[r][c] == list[counter][1]){
                                mainBoard[r - 1][c] = list[counter][0];
                                mainBoard[r][c] = list[counter][1];
                                mainBoard[r - 1][c + 1] = list[counter][2];
                                mainBoard[r][c + 1] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }else if(reapplyed == false && mainBoard[r][c] == list[counter][3]){//bottom right
                        try{
                            if(mainBoard[r][c] == list[counter][3]){
                                mainBoard[r - 1][c - 1] = list[counter][0];
                                mainBoard[r][c - 1] = list[counter][1];
                                mainBoard[r - 1][c] = list[counter][2];
                                mainBoard[r][c] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }else if(reapplyed == false && mainBoard[r][c] == list[counter][3]){//bottom left
                        try{
                            if(mainBoard[r][c] == list[counter][3]){
                                mainBoard[r][c - 1] = list[counter][0];
                                mainBoard[r + 1][c - 1] = list[counter][1];
                                mainBoard[r][c] = list[counter][2];
                                mainBoard[r + 1][c] = list[counter][3];
                                reapplyed = true;

                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                    }
                    
                    if(counter > 6){
                        reapplyed = true; 
                        
                    }
                }while(reapplyed == false);
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == list[0][3]){
                        
                        try{
                        mainBoard[r - 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r - 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == list[1][2]){
                        
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == list[2][2]){
                        
                        try{
                        mainBoard[r + 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == list[3][0]){
                        
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == list[4][1]){
                        
                        try{
                        mainBoard[r - 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == list[5][0]){
                        
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == list[6][3]){
                        
                        try{
                        mainBoard[r - 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == list[7][1]){
                        
                        try{
                        mainBoard[r - 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addSandCliffs(int[][] mainBoard, int boardR, int boardC, int sandCliffsToAdd){//, int chunkLength){//, int chanceToEnd){
        Random rand = new Random();
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int randR = 0;
        int direction = 0; 
        int directionFavourability = 0; // 0 left up right, 1 up right down, 2 right down left, 3 down left up
        int maxDirection = 3;
        int timesToUseDirection = 0;
        int maxTimesToUseDirection = 8;
        int minTimesToUseDirection = 5;
        int chooser = 0;
        int lastChooser = -1;
        boolean chooserIsDifferent = false;
        int randC = 0;
        int type = 0;
        int counter = 0; 
        int counterInner = 0; 
        boolean thereisRoom = true;
        boolean continueVar = true;
        int[] offset = new int[2];
        
        do{
            thereisRoom = true;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            //attempts++;
            
            if(mainBoard[randR][randC] != 0){
                
            }else{
                
                mainBoard[randR][randC] = 99;
                counter++;
                counterInner = 0;
                offset[0] = 54340;
                offset[1] = 54340;

                directionFavourability = rand.nextInt((maxDirection - min) + 1) + min;
                lastChooser = -1;


                do{

    //                direction = rand.nextInt((maxDirection - min) + 1) + min;
                    chooserIsDifferent = false;

                    do{
                        chooser = rand.nextInt((2 - 0) + 1) + 0;

                        if(lastChooser == chooser){
                            chooserIsDifferent = false;

                        }else{
                            chooserIsDifferent = true;

                        }

                        System.out.println(chooser + " " + lastChooser + " " + chooserIsDifferent);
                    }while(chooserIsDifferent == false);

                    lastChooser = chooser;



                    timesToUseDirection = rand.nextInt((maxTimesToUseDirection - minTimesToUseDirection) + 1) + minTimesToUseDirection;

                    for(int i = 0; i != timesToUseDirection; i++){// 0 left up right, 1 up right down, 2 right down left, 3 down left up
                        if(directionFavourability == 0){
                            if(chooser == 0){
                                offset[0] -= 1;

                            }else if(chooser == 1){
                               offset[1] -= 1;

                            }else{
                               offset[0] += 1;

                            }

                        }else if(directionFavourability == 1){
                            if(chooser == 0){
                                offset[1] -= 1;

                            }else if(chooser == 1){
                               offset[0] += 1;

                            }else{
                               offset[1] += 1;

                            }

                        }else if(directionFavourability == 2){
                            if(chooser == 0){
                                offset[0] += 1;

                            }else if(chooser == 1){
                               offset[1] += 1;

                            }else{
                               offset[0] -= 1;

                            }

                        }else if(directionFavourability == 3){
                            if(chooser == 0){
                                offset[1] += 1;

                            }else if(chooser == 1){
                               offset[0] -= 1;

                            }else{
                               offset[1] -= 1;

                            }

                        }
    //                    if(direction == 0){
    //                        offset[1] -= 1;
    //
    //                    }else if(direction == 1){
    //                        offset[0] += 1;
    //
    //                    }else if(direction == 2){
    //                        offset[1] += 1;
    //
    //                    }else if(direction == 3){
    //                        offset[0] -= 1;
    //
    //                    }

        //                for(int ic = -3; ic != 4; ic++){
        //                    for(int ir = -3; ir != 4; ir++){
        //                        try{
        //                            if(mainBoard[randR + offset[0] + ir][randC + offset[1] + ic] != 0 || outOfBounds(mainBoard, (randR + offset[0] + ir), (randC + offset[1] + ic)) == true){
        //                                thereisRoom = false;
        //
        //                            }
        //                        }catch(IndexOutOfBoundsException e){
        //
        //                        }
        //
        //                    }
        //                }

                        try{
                            if(mainBoard[randR + offset[0]][randC + offset[0]] != 54340){
                                counterInner++;
                                
                            }else{
                                mainBoard[randR + offset[0]][randC + offset[1]] = 99;
                                counterInner++;
                            
                            }

                        }catch(IndexOutOfBoundsException e){
                            counterInner = 999999;

                        }
                    }
                }while(counterInner < 100);

            }
        }while(counter < sandCliffsToAdd);
        
        return mainBoard;
    }
    
    public static int[][] addSandCliffsOld(int[][] mainBoard, int boardR, int boardC, int sandCliffsToAdd){//, int chanceToEnd){
        Random rand = new Random();
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int randR = 0;
        int direction = 0; //0 - up/right 1 - down/left //check if piece can fit, if not, end
        int maxDirection = 1;
        int randC = 0;
        int type = 0;
        int counter = 0; 
        int nextPiece = 0; // 0 - straight, 1 - corner, 2 - diagonal
        boolean thereisRoom = true;
        boolean continueVar = true;
        
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            direction = rand.nextInt((maxDirection - min) + 1) + min;
            
            for(int ic = -5; ic != 6; ic++){
                for(int ir = -5; ir != 6; ir++){
                    try{
                        if(mainBoard[randR + ir][randC + ic] != 0){
                            thereisRoom = false;

                        }
                    }catch(IndexOutOfBoundsException e){

                    }
                    
                }
            }
            
            if(direction == 0){
                mainBoard[randR][randC] = 100;
                counter++;
                
            }else if(direction == 1){
                mainBoard[randR][randC] = 101;
                counter++;
                
            }
            
//            if(thereisRoom == true){
//                do{
//                    
//                    
//                }while(continueVar == true);
//                
//            }
            
            
        }while(counter < sandCliffsToAdd);
        
        return mainBoard;
    }
    
    public static int[][] paintEntranceEdges(int[][] mainBoard, int boardR, int boardC, String tileset) throws IOException{
        boolean foundNotGoodSpot = false;
        int[] tempCliff = new int[4];
        int[] tempCliff2 = new int[4];
        int[] tempCliff3 = new int[4];
        int[] tempCliff4 = new int[1];
        int[] tempCliff5 = new int[1];
        int[] tempCliff6 = new int[2];
        int[] tempCliffa1 = new int[1];
        int[] tempCliffa2 = new int[1];
        int[] tempCliffa3 = new int[1];
        int[] tempCliffa4 = new int[1];
        int[] tempCliffb1 = new int[1];
        int[] tempCliffb2 = new int[1];
        int[] tempCliffb3 = new int[1];
        int[] tempCliffb4 = new int[1];
	int[] anticipatedSize = new int[2];

        Random rand = new Random();
        int max = 1;
        int min = 0;
        int randVar = 0;
        int counter = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int randR = 0;
        int randC = 0;
        int maxSpecial = 0;
        int maxSpecialCounter = 0;
        int[] last = {-1, -1, -1, -1};
        boolean isDifferent = false;
        
        //merge islands and entrances
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                foundNotGoodSpot = false;

                if(mainBoard[r][c] == 543438){
                    for(int ic = -1; ic != 2; ic++){
                        for(int ir = -1; ir != 2; ir++){
                            try{
                                if(mainBoard[r + ir][c + ic] != 543438 && mainBoard[r + ir][c + ic] != 54341){
                                    foundNotGoodSpot = true;

                                }
                            }catch(IndexOutOfBoundsException e){

                            }
                        }
                    }

                    if(foundNotGoodSpot == false){
                        mainBoard[r][c] = 54341;
                        
                    }
                }
            }
        }
        
        //remove any tiles surounded by rock
        for(int i = 0; i != 2; i++){
            for(int c = 0; c != boardC; c++){
                for(int r = 0; r != boardR; r++){
                    try{
                        if(mainBoard[r][c] == 543438 
                                && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c] == 54341 && mainBoard[r][c + 1] == 54341 && mainBoard[r - 1][c] == 54341 
                                || mainBoard[r][c] == 543438 
                                && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r + 1][c + 1] == 54341 && mainBoard[r - 1][c + 1] == 54341 ){
                            mainBoard[r][c] = 54341;

                        }
                    }catch(IndexOutOfBoundsException e){

                    }
                }
            }
        }
        
        if(tileset.matches("BLOXBAT")){
            maxSpecial = rand.nextInt((3 - 1) + 1) + 1;
            counter = 0;
            do{
                counter++;
                randR = rand.nextInt((maxR - min) + 1) + min;
                randC = rand.nextInt((maxC - min) + 1) + min;

                if(maxSpecialCounter < maxSpecial){
                    try{
                        if(mainBoard[randR - 1][randC] == 543438 && mainBoard[randR + 4][randC + 1] == 543438
                                && mainBoard[randR - 1][randC + 1] == 54341 && mainBoard[randR - 1][randC + 2] == 54341
                                && mainBoard[randR][randC + 2] == 54341 && mainBoard[randR + 1][randC + 2] == 54341
                                && mainBoard[randR + 2][randC + 2] == 54341 && mainBoard[randR + 3][randC + 2] == 54341 
                                && mainBoard[randR + 4][randC + 2] == 54341
                                && mainBoard[randR + 1][randC] == 54340 
                                && mainBoard[randR + 2][randC] == 54340
                                && mainBoard[randR + 3][randC] == 54340){
                            anticipatedSize[0] = 4;
                            anticipatedSize[1] = 2;
                            tempCliff = getBlockData("BLOXBAT", 7, 'G', anticipatedSize);
                            maxSpecialCounter++;

                            mainBoard[randR][randC] = tempCliff[0];
                            mainBoard[randR + 1][randC] = tempCliff[1];
                            mainBoard[randR + 2][randC] = tempCliff[2];
                            mainBoard[randR + 3][randC] = tempCliff[3];

                            mainBoard[randR][randC + 1] = tempCliff[4];
                            mainBoard[randR + 1][randC + 1] = tempCliff[5];
                            mainBoard[randR + 2][randC + 1] = tempCliff[6];
                            mainBoard[randR + 3][randC + 1] = tempCliff[7];


                        }

                    }catch(IndexOutOfBoundsException e){

                    }
                }

            }while(counter < (boardR * boardC * 0.90));
        }
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r - 2][c] == 543438 && mainBoard[r - 1][c] == 543438 && mainBoard[r][c - 1] == 543438 && mainBoard[r + 1][c - 1] == 543438
                            && mainBoard[r - 1][c + 1] == 54341 && mainBoard[r][c + 1] == 54341 && mainBoard[r + 1][c + 1] == 54341 && mainBoard[r + 1][c] == 54341
                            && mainBoard[r - 1][c - 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, '2', anticipatedSize);
                        
                        mainBoard[r - 1][c - 1] = tempCliff[0];
                        mainBoard[r][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c] = tempCliff[2];
                        mainBoard[r][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r - 1][c - 1] == 543438 && mainBoard[r][c - 1] == 543438 && mainBoard[r + 1][c] == 543438 && mainBoard[r + 2][c] == 543438
                            && mainBoard[r - 1][c] == 54341 && mainBoard[r - 1][c + 1] == 54341 && mainBoard[r][c + 1] == 54341 && mainBoard[r + 1][c + 1] == 54341
                            && mainBoard[r + 1][c - 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, '4', anticipatedSize);
                        
                        mainBoard[r][c - 1] = tempCliff[0];
                        mainBoard[r + 1][c - 1] = tempCliff[1];
                        mainBoard[r][c] = tempCliff[2];
                        mainBoard[r + 1][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 2] == 543438 && mainBoard[r][c - 1] == 543438 && mainBoard[r + 1][c] == 543438 && mainBoard[r + 1][c + 1] == 543438
                            && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r - 1][c] == 54341 && mainBoard[r - 1][c + 1] == 54341 && mainBoard[r][c + 1] == 54341
                            && mainBoard[r + 1][c - 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'T', anticipatedSize);
                        
                        mainBoard[r][c - 1] = tempCliff[0];
                        mainBoard[r + 1][c - 1] = tempCliff[1];
                        mainBoard[r][c] = tempCliff[2];
                        mainBoard[r + 1][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r + 1][c - 1] == 543438 && mainBoard[r + 1][c] == 543438 && mainBoard[r][c + 1] == 543438 && mainBoard[r][c + 2] == 543438
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r - 1][c] == 54341 && mainBoard[r - 1][c + 1] == 54341
                            && mainBoard[r + 1][c + 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'G', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        mainBoard[r + 1][c] = tempCliff[1];
                        mainBoard[r][c + 1] = tempCliff[2];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r - 1][c + 1] == 543438 && mainBoard[r][c + 1] == 543438 && mainBoard[r + 1][c] == 543438 && mainBoard[r + 2][c] == 543438
                            && mainBoard[r - 1][c] == 54341 && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c - 1] == 54341
                            && mainBoard[r + 1][c + 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'V', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        mainBoard[r + 1][c] = tempCliff[1];
                        mainBoard[r][c + 1] = tempCliff[2];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r - 2][c] == 543438 && mainBoard[r - 1][c] == 543438 && mainBoard[r][c + 1] == 543438 && mainBoard[r + 1][c + 1] == 543438
                            && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r + 1][c] == 54341
                            && mainBoard[r - 1][c + 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'X', anticipatedSize);
                        
                        mainBoard[r - 1][c] = tempCliff[0];
                        mainBoard[r][c] = tempCliff[1];
                        mainBoard[r - 1][c + 1] = tempCliff[2];
                        mainBoard[r][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r - 1][c - 1] == 543438 && mainBoard[r - 1][c] == 543438 && mainBoard[r][c + 1] == 543438 && mainBoard[r][c + 2] == 543438
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r + 1][c] == 54341 && mainBoard[r + 1][c + 1] == 54341
                            && mainBoard[r - 1][c + 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'A', anticipatedSize);
                        
                        mainBoard[r - 1][c] = tempCliff[0];
                        mainBoard[r][c] = tempCliff[1];
                        mainBoard[r - 1][c + 1] = tempCliff[2];
                        mainBoard[r][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 2] == 543438 && mainBoard[r][c - 1] == 543438 && mainBoard[r - 1][c] == 543438 && mainBoard[r - 1][c + 1] == 543438
                            && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r + 1][c] == 54341 && mainBoard[r + 1][c + 1] == 54341 && mainBoard[r][c + 1] == 54341
                            && mainBoard[r - 1][c - 1] == 54340){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'Q', anticipatedSize);
                        
                        mainBoard[r - 1][c - 1] = tempCliff[0];
                        mainBoard[r][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c] = tempCliff[2];
                        mainBoard[r][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        //removing flat areas
        counter = 0;
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
                    
            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR + 1][randC] == 543438 && mainBoard[randR + 2][randC] == 543438 && mainBoard[randR + 3][randC] == 543438
                        && mainBoard[randR][randC - 1] == 54340 && mainBoard[randR + 1][randC - 1] == 54340 && mainBoard[randR + 2][randC - 1] == 54340 && mainBoard[randR + 3][randC - 1] == 54340 
                        && mainBoard[randR][randC + 1] == 54341 && mainBoard[randR + 1][randC + 1] == 54341 && mainBoard[randR + 2][randC + 1] == 54341 && mainBoard[randR + 3][randC + 1] == 54341 
                        && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR - 1][randC] == 543438 && mainBoard[randR - 1][randC + 1] == 54341 
                        && mainBoard[randR + 4][randC - 1] == 54340 && mainBoard[randR + 4][randC] == 543438 && mainBoard[randR + 4][randC + 1] == 54341 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - out, 1 - in
                    tempCliff = getBlockData("BLOXBGBS", 3, '2', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, '4', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR][randC - 1] = tempCliff[0];
                        mainBoard[randR + 1][randC - 1] = tempCliff[1];
                        mainBoard[randR + 2][randC - 1] = tempCliff2[0];
                        mainBoard[randR + 3][randC - 1] = tempCliff2[1];
                        mainBoard[randR][randC] = tempCliff[2];
                        mainBoard[randR + 1][randC] = tempCliff[3];
                        mainBoard[randR + 2][randC] = tempCliff2[2];
                        mainBoard[randR + 3][randC] = tempCliff2[3];

                    }else if(randVar == 1){
                        mainBoard[randR][randC] = tempCliff2[0];
                        mainBoard[randR + 1][randC] = tempCliff2[1];
                        mainBoard[randR + 2][randC] = tempCliff[0];
                        mainBoard[randR + 3][randC] = tempCliff[1];
                        mainBoard[randR][randC + 1] = tempCliff2[2];
                        mainBoard[randR + 1][randC + 1] = tempCliff2[3];
                        mainBoard[randR + 2][randC + 1] = tempCliff[2];
                        mainBoard[randR + 3][randC + 1] = tempCliff[3];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR][randC + 1] == 543438 && mainBoard[randR][randC + 2] == 543438 && mainBoard[randR][randC + 3] == 543438
                        && mainBoard[randR + 1][randC] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 && mainBoard[randR + 1][randC + 2] == 54340 && mainBoard[randR + 1][randC + 3] == 54340 
                        && mainBoard[randR - 1][randC] == 54341 && mainBoard[randR - 1][randC + 1] == 54341 && mainBoard[randR - 1][randC + 2] == 54341 && mainBoard[randR - 1][randC + 3] == 54341 
                        && mainBoard[randR + 1][randC - 1] == 54340 && mainBoard[randR][randC - 1] == 543438 && mainBoard[randR - 1][randC - 1] == 54341 
                        && mainBoard[randR + 1][randC + 4] == 54340 && mainBoard[randR][randC + 4] == 543438 && mainBoard[randR - 1][randC + 4] == 54341 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - in, 1 - out
                    tempCliff = getBlockData("BLOXBGBS", 3, 'T', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, 'G', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR][randC] = tempCliff[0];
                        mainBoard[randR][randC + 1] = tempCliff[2];
                        mainBoard[randR][randC + 2] = tempCliff2[0];
                        mainBoard[randR][randC + 3] = tempCliff2[2];
                        mainBoard[randR + 1][randC] = tempCliff[1];
                        mainBoard[randR + 1][randC + 1] = tempCliff[3];
                        mainBoard[randR + 1][randC + 2] = tempCliff2[1];
                        mainBoard[randR + 1][randC + 3] = tempCliff2[3];

                    }else if(randVar == 1){
                        mainBoard[randR - 1][randC] = tempCliff2[0];
                        mainBoard[randR - 1][randC + 1] = tempCliff2[2];
                        mainBoard[randR - 1][randC + 2] = tempCliff[0];
                        mainBoard[randR - 1][randC + 3] = tempCliff[2];
                        mainBoard[randR][randC] = tempCliff2[1];
                        mainBoard[randR][randC + 1] = tempCliff2[3];
                        mainBoard[randR][randC + 2] = tempCliff[1];
                        mainBoard[randR][randC + 3] = tempCliff[3];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR - 1][randC] == 543438 && mainBoard[randR - 2][randC] == 543438 && mainBoard[randR - 3][randC] == 543438
                        && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR - 2][randC + 1] == 54340 && mainBoard[randR - 3][randC + 1] == 54340 
                        && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR - 2][randC - 1] == 54341 && mainBoard[randR - 3][randC - 1] == 54341 
                        && mainBoard[randR - 4][randC + 1] == 54340 && mainBoard[randR - 4][randC] == 543438 && mainBoard[randR - 4][randC - 1] == 54341 
                        && mainBoard[randR + 1][randC + 1] == 54340 && mainBoard[randR + 1][randC] == 543438 && mainBoard[randR + 1][randC - 1] == 54341 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - in, 1 - out
                    tempCliff = getBlockData("BLOXBGBS", 3, 'V', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, 'X', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR - 3][randC] = tempCliff2[0];
                        mainBoard[randR - 2][randC] = tempCliff2[1];
                        mainBoard[randR - 1][randC] = tempCliff[0];
                        mainBoard[randR][randC] = tempCliff[1];
                        mainBoard[randR - 3][randC + 1] = tempCliff2[2];
                        mainBoard[randR - 2][randC + 1] = tempCliff2[3];
                        mainBoard[randR - 1][randC + 1] = tempCliff[2];
                        mainBoard[randR][randC + 1] = tempCliff[3];

                    }else if(randVar == 1){
                        mainBoard[randR - 3][randC - 1] = tempCliff[0];
                        mainBoard[randR - 2][randC - 1] = tempCliff[1];
                        mainBoard[randR - 1][randC - 1] = tempCliff2[0];
                        mainBoard[randR][randC - 1] = tempCliff2[1];
                        mainBoard[randR - 3][randC] = tempCliff[2];
                        mainBoard[randR - 2][randC] = tempCliff[3];
                        mainBoard[randR - 1][randC] = tempCliff2[2];
                        mainBoard[randR][randC] = tempCliff2[3];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR][randC - 1] == 543438 && mainBoard[randR][randC - 2] == 543438 && mainBoard[randR][randC - 3] == 543438
                        && mainBoard[randR - 1][randC] == 54340 && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR - 1][randC - 2] == 54340 && mainBoard[randR - 1][randC - 3] == 54340 
                        && mainBoard[randR + 1][randC] == 54341 && mainBoard[randR + 1][randC - 1] == 54341 && mainBoard[randR + 1][randC - 2] == 54341 && mainBoard[randR + 1][randC - 3] == 54341 
                        && mainBoard[randR - 1][randC - 4] == 54340 && mainBoard[randR][randC - 4] == 543438 && mainBoard[randR + 1][randC - 4] == 54341 
                        && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR][randC + 1] == 543438 && mainBoard[randR + 1][randC + 1] == 54341 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - in, 1 - out
                    tempCliff = getBlockData("BLOXBGBS", 3, 'A', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, 'Q', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR][randC - 3] = tempCliff2[1];
                        mainBoard[randR][randC - 2] = tempCliff2[3];
                        mainBoard[randR][randC - 1] = tempCliff[1];
                        mainBoard[randR][randC] = tempCliff[3];
                        mainBoard[randR - 1][randC - 3] = tempCliff2[0];
                        mainBoard[randR - 1][randC - 2] = tempCliff2[2];
                        mainBoard[randR - 1][randC - 1] = tempCliff[0];
                        mainBoard[randR - 1][randC] = tempCliff[2];

                    }else if(randVar == 1){
                        mainBoard[randR + 1][randC - 3] = tempCliff[1];
                        mainBoard[randR + 1][randC - 2] = tempCliff[3];
                        mainBoard[randR + 1][randC - 1] = tempCliff2[1];
                        mainBoard[randR + 1][randC] = tempCliff2[3];
                        mainBoard[randR][randC - 3] = tempCliff[0];
                        mainBoard[randR][randC - 2] = tempCliff[2];
                        mainBoard[randR][randC - 1] = tempCliff2[0];
                        mainBoard[randR][randC] = tempCliff2[2];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }
            
        }while(counter < (boardR * boardC * 2));
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        counter = 0;
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
                    
            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR + 1][randC] == 543438 && mainBoard[randR + 2][randC] == 543438 && mainBoard[randR + 3][randC] == 543438
                        && mainBoard[randR][randC + 1] == 54341 && mainBoard[randR + 1][randC + 1] == 54341 && mainBoard[randR + 2][randC + 1] == 54341 && mainBoard[randR + 3][randC + 1] == 54341 
                        && mainBoard[randR - 1][randC] == 543438 && mainBoard[randR - 1][randC + 1] == 54341 
                        && mainBoard[randR + 4][randC] == 543438 && mainBoard[randR + 4][randC + 1] == 54341 ){
                    tempCliff = getBlockData("BLOXBGBS", 3, '2', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, '4', anticipatedSize);
                    
                    mainBoard[randR][randC] = tempCliff2[0];
                    mainBoard[randR + 1][randC] = tempCliff2[1];
                    mainBoard[randR + 2][randC] = tempCliff[0];
                    mainBoard[randR + 3][randC] = tempCliff[1];
                    mainBoard[randR][randC + 1] = tempCliff2[2];
                    mainBoard[randR + 1][randC + 1] = tempCliff2[3];
                    mainBoard[randR + 2][randC + 1] = tempCliff[2];
                    mainBoard[randR + 3][randC + 1] = tempCliff[3];
                    
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR][randC + 1] == 543438 && mainBoard[randR][randC + 2] == 543438 && mainBoard[randR][randC + 3] == 543438
                        && mainBoard[randR - 1][randC] == 54341 && mainBoard[randR - 1][randC + 1] == 54341 && mainBoard[randR - 1][randC + 2] == 54341 && mainBoard[randR - 1][randC + 3] == 54341 
                        && mainBoard[randR][randC - 1] == 543438 && mainBoard[randR - 1][randC - 1] == 54341 
                        && mainBoard[randR][randC + 4] == 543438 && mainBoard[randR - 1][randC + 4] == 54341 ){
                    tempCliff = getBlockData("BLOXBGBS", 3, 'T', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, 'G', anticipatedSize);
                    
                    mainBoard[randR - 1][randC] = tempCliff2[0];
                    mainBoard[randR - 1][randC + 1] = tempCliff2[2];
                    mainBoard[randR - 1][randC + 2] = tempCliff[0];
                    mainBoard[randR - 1][randC + 3] = tempCliff[2];
                    mainBoard[randR][randC] = tempCliff2[1];
                    mainBoard[randR][randC + 1] = tempCliff2[3];
                    mainBoard[randR][randC + 2] = tempCliff[1];
                    mainBoard[randR][randC + 3] = tempCliff[3];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR - 1][randC] == 543438 && mainBoard[randR - 2][randC] == 543438 && mainBoard[randR - 3][randC] == 543438
                        && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR - 2][randC - 1] == 54341 && mainBoard[randR - 3][randC - 1] == 54341 
                        && mainBoard[randR - 4][randC] == 543438 && mainBoard[randR - 4][randC - 1] == 54341 
                        && mainBoard[randR + 1][randC] == 543438 && mainBoard[randR + 1][randC - 1] == 54341 ){
                    tempCliff = getBlockData("BLOXBGBS", 3, 'V', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, 'X', anticipatedSize);

                    mainBoard[randR - 3][randC - 1] = tempCliff[0];
                    mainBoard[randR - 2][randC - 1] = tempCliff[1];
                    mainBoard[randR - 1][randC - 1] = tempCliff2[0];
                    mainBoard[randR][randC - 1] = tempCliff2[1];
                    mainBoard[randR - 3][randC] = tempCliff[2];
                    mainBoard[randR - 2][randC] = tempCliff[3];
                    mainBoard[randR - 1][randC] = tempCliff2[2];
                    mainBoard[randR][randC] = tempCliff2[3];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR][randC - 1] == 543438 && mainBoard[randR][randC - 2] == 543438 && mainBoard[randR][randC - 3] == 543438
                        && mainBoard[randR + 1][randC] == 54341 && mainBoard[randR + 1][randC - 1] == 54341 && mainBoard[randR + 1][randC - 2] == 54341 && mainBoard[randR + 1][randC - 3] == 54341 
                        && mainBoard[randR][randC - 4] == 543438 && mainBoard[randR + 1][randC - 4] == 54341 
                        && mainBoard[randR][randC + 1] == 543438 && mainBoard[randR + 1][randC + 1] == 54341 ){
                    tempCliff = getBlockData("BLOXBGBS", 3, 'A', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 3, 'Q', anticipatedSize);

                    mainBoard[randR + 1][randC - 3] = tempCliff[1];
                    mainBoard[randR + 1][randC - 2] = tempCliff[3];
                    mainBoard[randR + 1][randC - 1] = tempCliff2[1];
                    mainBoard[randR + 1][randC] = tempCliff2[3];
                    mainBoard[randR][randC - 3] = tempCliff[0];
                    mainBoard[randR][randC - 2] = tempCliff[2];
                    mainBoard[randR][randC - 1] = tempCliff2[0];
                    mainBoard[randR][randC] = tempCliff2[2];
                    
                }

            }catch(IndexOutOfBoundsException e){

            }
                
            
        }while(counter < (boardR * boardC * 2));
        
        counter = 0;
        anticipatedSize[0] = 1;
        anticipatedSize[1] = 1;
        tempCliffa1 = getBlockData("BLOXBGBS", 3, '1', anticipatedSize);
        tempCliffa2 = getBlockData("BLOXBGBS", 3, '5', anticipatedSize);
        tempCliffa3 = getBlockData("BLOXBGBS", 3, 'B', anticipatedSize);
        tempCliffa4 = getBlockData("BLOXBGBS", 3, 'Z', anticipatedSize);
        tempCliffb1 = getBlockData("BLOXBGBS", 3, 'W', anticipatedSize);
        tempCliffb2 = getBlockData("BLOXBGBS", 3, 'R', anticipatedSize);
        tempCliffb3 = getBlockData("BLOXBGBS", 3, 'F', anticipatedSize);
        tempCliffb4 = getBlockData("BLOXBGBS", 3, 'S', anticipatedSize);
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
                    
            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR + 1][randC] == 543438 && mainBoard[randR + 2][randC] == 543438 
                        && mainBoard[randR][randC + 1] == 54341 && mainBoard[randR + 1][randC + 1] == 54341 && mainBoard[randR + 2][randC + 1] == 54341 
                        && mainBoard[randR - 1][randC] == 543438 && mainBoard[randR - 1][randC + 1] == 54341 
                        && mainBoard[randR + 3][randC] == 543438 && mainBoard[randR + 3][randC + 1] == 54341 ){
                    randVar = rand.nextInt((max - min) + 1) + min;
                        
                    tempCliffa2 = getBlockData("BLOXBGBS", 3, '5', anticipatedSize);
                    mainBoard[randR][randC] = tempCliffa2[0];

                    mainBoard[randR + 1][randC] = 54340;
                    mainBoard[randR + 2][randC] = tempCliffa1[0];
                    mainBoard[randR][randC + 1] = tempCliffb4[0];
                    
                    tempCliff = getBlockData("BLOXBGBS", 3, '3', anticipatedSize);
                    mainBoard[randR + 1][randC + 1] = tempCliff[0];
                    mainBoard[randR + 2][randC + 1] = tempCliffb3[0];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR][randC + 1] == 543438 && mainBoard[randR][randC + 2] == 543438 
                        && mainBoard[randR - 1][randC] == 54341 && mainBoard[randR - 1][randC + 1] == 54341 && mainBoard[randR - 1][randC + 2] == 54341 
                        && mainBoard[randR][randC - 1] == 543438 && mainBoard[randR - 1][randC - 1] == 54341 
                        && mainBoard[randR][randC + 3] == 543438 && mainBoard[randR - 1][randC + 3] == 54341 ){
                    randVar = rand.nextInt((max - min) + 1) + min;
                    
                    mainBoard[randR - 1][randC] = tempCliffb1[0];
                    mainBoard[randR][randC] = tempCliffa3[0];
                    
                    tempCliff = getBlockData("BLOXBGBS", 3, 'D', anticipatedSize);
                    mainBoard[randR - 1][randC + 1] = tempCliff[0];
                    mainBoard[randR][randC + 1] = 54340;
                    mainBoard[randR - 1][randC + 2] = tempCliffb4[0];
                    
                    tempCliffa2 = getBlockData("BLOXBGBS", 3, '5', anticipatedSize);
                    mainBoard[randR][randC + 2] = tempCliffa2[0];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR - 1][randC] == 543438 && mainBoard[randR - 2][randC] == 543438 
                        && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR - 2][randC - 1] == 54341 
                        && mainBoard[randR - 3][randC] == 543438 && mainBoard[randR - 3][randC - 1] == 54341 
                        && mainBoard[randR + 1][randC] == 543438 && mainBoard[randR + 1][randC - 1] == 54341 ){

                    mainBoard[randR - 2][randC - 1] = tempCliffb1[0];
                    
                    tempCliff = getBlockData("BLOXBGBS", 3, 'C', anticipatedSize);
                    mainBoard[randR - 1][randC - 1] = tempCliff[0];
                    mainBoard[randR][randC - 1] = tempCliffb2[0];
                    mainBoard[randR - 2][randC] = tempCliffa3[0];
                    mainBoard[randR - 1][randC] = 54340;
                    mainBoard[randR][randC] = tempCliffa4[0];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 543438
                        && mainBoard[randR][randC - 1] == 543438 && mainBoard[randR][randC - 2] == 543438 
                        && mainBoard[randR + 1][randC] == 54341 && mainBoard[randR + 1][randC - 1] == 54341 && mainBoard[randR + 1][randC - 2] == 54341 
                        && mainBoard[randR][randC - 3] == 543438 && mainBoard[randR + 1][randC - 3] == 54341 
                        && mainBoard[randR][randC + 1] == 543438 && mainBoard[randR + 1][randC + 1] == 54341 ){

                    mainBoard[randR][randC - 2] = tempCliffa4[0];
                    mainBoard[randR + 1][randC - 2] = tempCliffb2[0];
                    mainBoard[randR][randC - 1] = 54340;
                    
                    tempCliff = getBlockData("BLOXBGBS", 3, 'E', anticipatedSize);
                    mainBoard[randR + 1][randC - 1] = tempCliff[0];
                    mainBoard[randR][randC] = tempCliffa1[0];
                    mainBoard[randR + 1][randC] = tempCliffb3[0];

                }

            }catch(IndexOutOfBoundsException e){

            }
                
            
        }while(counter < (boardR * boardC * 2));
        
        anticipatedSize[0] = 1;
        anticipatedSize[1] = 1;
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r][c + 1] == 54341 && mainBoard[r + 1][c] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'F', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r - 1][c] == 54341 && mainBoard[r][c + 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'S', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r - 1][c] == 54341 && mainBoard[r][c - 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'W', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'R', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        anticipatedSize[0] = 1;
        anticipatedSize[1] = 1;
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r][c + 1] == 54341 ){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 3, '3', anticipatedSize);
                        
                            if(last[0] != tempCliff[0]){
                                last[0] = tempCliff[0];
                                isDifferent = true;
                        
                                mainBoard[r][c] = tempCliff[0];
                        
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r][c - 1] == 54341 ){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 3, 'C', anticipatedSize);
                        
                            if(last[1] != tempCliff[0]){
                                last[1] = tempCliff[0];
                                isDifferent = true;
                        
                                mainBoard[r][c] = tempCliff[0];
                        
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
            }
        }
        for(int r = 0; r != boardR; r++){
            for(int c = 0; c != boardC; c++){
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r - 1][c] == 54341 ){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 3, 'D', anticipatedSize);
                        
                            if(last[2] != tempCliff[0]){
                                last[2] = tempCliff[0];
                                isDifferent = true;
                        
                                mainBoard[r][c] = tempCliff[0];
                        
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r + 1][c] == 54341 ){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 3, 'E', anticipatedSize);
                        
                            if(last[3] != tempCliff[0]){
                                last[3] = tempCliff[0];
                                isDifferent = true;
                        
                                mainBoard[r][c] = tempCliff[0];
                        
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        anticipatedSize[0] = 1;
        anticipatedSize[1] = 1;
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r - 1][c - 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'B', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r + 1][c - 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, 'Z', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r + 1][c + 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, '1', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 && mainBoard[r - 1][c + 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 3, '5', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
            }
        }
        
        //remove left overs
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438){
                        if(mainBoard[r][c - 1] == 54341 || mainBoard[r + 1][c] == 54341 || mainBoard[r][c + 1] == 54341 || mainBoard[r - 1][c] == 54341 ){
                            mainBoard[r][c] = 54341;

                        }

                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 543438){
                        if(mainBoard[r][c - 1] == 54340 || mainBoard[r + 1][c] == 54340 || mainBoard[r][c + 1] == 54340 || mainBoard[r - 1][c] == 54340 ){
                            mainBoard[r][c] = 54340;

                        }

                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
//        //sand cliff starts
//        counter = 0;
//        do{
//            counter++;
//            randR = rand.nextInt((maxR - min) + 1) + min;
//            randC = rand.nextInt((maxC - min) + 1) + min;
//            
//            try{
//                if(mainBoard[randR][randC] == 497 && mainBoard[randR][randC - 1] == 495 
//                        && mainBoard[randR + 1][randC - 1] == 54340 && mainBoard[randR + 1][randC] == 54340 
//                        && mainBoard[randR + 2][randC - 1] == 54340 && mainBoard[randR + 2][randC] == 54340 
//                        && mainBoard[randR + 3][randC - 1] == 54340 && mainBoard[randR + 3][randC] == 54340 ){
//                    mainBoard[randR][randC - 1] = 7777;
//                    mainBoard[randR + 1][randC - 1] = 7777;
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR + 1][randC] = 7777;
//                    mainBoard[randR - 1][randC - 1] = 54340;
//                    mainBoard[randR - 1][randC] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            try{
//                if(mainBoard[randR][randC] == 492 && mainBoard[randR][randC - 1] == 490 
//                        && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR - 1][randC] == 54340 
//                        && mainBoard[randR - 2][randC - 1] == 54340 && mainBoard[randR - 2][randC] == 54340 
//                        && mainBoard[randR - 3][randC - 1] == 54340 && mainBoard[randR - 3][randC] == 54340 ){
//                    mainBoard[randR - 1][randC - 1] = 7777;
//                    mainBoard[randR][randC - 1] = 7777;
//                    mainBoard[randR - 1][randC] = 7777;
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR + 1][randC - 1] = 54340;
//                    mainBoard[randR + 1][randC] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            
//            try{
//                if(mainBoard[randR][randC] == 506 && mainBoard[randR + 1][randC] == 507 
//                        && mainBoard[randR][randC + 3] == 54340 && mainBoard[randR + 1][randC + 3] == 54340 
//                        && mainBoard[randR][randC + 2] == 54340 && mainBoard[randR + 1][randC + 2] == 54340 
//                        && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 ){
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR + 1][randC] = 7777;
//                    mainBoard[randR][randC + 1] = 7777;
//                    mainBoard[randR + 1][randC + 1] = 7777;
//                    mainBoard[randR][randC - 1] = 54340;
//                    mainBoard[randR + 1][randC - 1] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            try{
//                if(mainBoard[randR][randC] == 500 && mainBoard[randR + 1][randC] == 501 
//                        && mainBoard[randR][randC - 3] == 54340 && mainBoard[randR + 1][randC - 3] == 54340 
//                        && mainBoard[randR][randC - 2] == 54340 && mainBoard[randR + 1][randC - 2] == 54340 
//                        && mainBoard[randR][randC - 1] == 54340 && mainBoard[randR + 1][randC - 1] == 54340 ){
//                    mainBoard[randR][randC - 1] = 7777;
//                    mainBoard[randR + 1][randC - 1] = 7777;
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR + 1][randC] = 7777;
//                    mainBoard[randR][randC + 1] = 54340;
//                    mainBoard[randR + 1][randC + 1] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            
//            try{
//                if(mainBoard[randR][randC] == 510 && mainBoard[randR][randC + 1] == 512
//                        && mainBoard[randR - 1][randC] == 54340 && mainBoard[randR - 1][randC + 1] == 54340 
//                        && mainBoard[randR - 2][randC] == 54340 && mainBoard[randR - 2][randC + 1] == 54340 
//                        && mainBoard[randR - 3][randC] == 54340 && mainBoard[randR - 3][randC + 1] == 54340 ){
//                    mainBoard[randR - 1][randC] = 7777;
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR - 1][randC + 1] = 7777;
//                    mainBoard[randR][randC + 1] = 7777;
//                    mainBoard[randR + 1][randC] = 54340;
//                    mainBoard[randR + 1][randC + 1] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            try{
//                if(mainBoard[randR][randC] == 515 && mainBoard[randR][randC + 1] == 517 
//                        && mainBoard[randR + 1][randC] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 
//                        && mainBoard[randR + 2][randC] == 54340 && mainBoard[randR + 2][randC + 1] == 54340 
//                        && mainBoard[randR + 3][randC] == 54340 && mainBoard[randR + 3][randC + 1] == 54340 ){
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR + 1][randC] = 7777;
//                    mainBoard[randR][randC + 1] = 7777;
//                    mainBoard[randR + 1][randC + 1] = 7777;
//                    mainBoard[randR - 1][randC] = 54340;
//                    mainBoard[randR - 1][randC + 1] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            
//            try{
//                if(mainBoard[randR][randC] == 521 && mainBoard[randR - 1][randC] == 520
//                        && mainBoard[randR - 1][randC - 3] == 54340 && mainBoard[randR][randC - 3] == 54340 
//                        && mainBoard[randR - 1][randC - 2] == 54340 && mainBoard[randR][randC - 2] == 54340 
//                        && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR][randC - 1] == 54340 ){
//                    mainBoard[randR - 1][randC - 1] = 7777;
//                    mainBoard[randR][randC - 1] = 7777;
//                    mainBoard[randR - 1][randC] = 7777;
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR][randC + 1] = 54340;
//                    mainBoard[randR - 1][randC + 1] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//            try{
//                if(mainBoard[randR][randC] == 527 && mainBoard[randR - 1][randC] == 526
//                        && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR][randC + 1] == 54340 
//                        && mainBoard[randR - 1][randC + 2] == 54340 && mainBoard[randR][randC + 2] == 54340 
//                        && mainBoard[randR - 1][randC + 3] == 54340 && mainBoard[randR][randC + 3] == 54340 ){
//                    mainBoard[randR - 1][randC] = 7777;
//                    mainBoard[randR][randC] = 7777;
//                    mainBoard[randR - 1][randC + 1] = 7777;
//                    mainBoard[randR][randC + 1] = 7777;
//                    mainBoard[randR][randC - 1] = 54340;
//                    mainBoard[randR - 1][randC - 1] = 54340;
//                    
//                }
//            }catch(IndexOutOfBoundsException e){
//                    
//            }
//            
//        }while(counter < (boardR * boardC * 77.15));
        
        //varying south facing cliff openings 
        counter = 0;
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            
            anticipatedSize[0] = 3;
            anticipatedSize[1] = 3;
            tempCliff = getBlockData("BLOXBGBS", 1, '0', anticipatedSize);
            
            anticipatedSize[0] = 2;
            anticipatedSize[1] = 2;
            tempCliff2 = getBlockData("BLOXBGBS", 1, '>', anticipatedSize);
            tempCliff3 = getBlockData("BLOXBGBS", 1, 'N', anticipatedSize);
            
            anticipatedSize[0] = 1;
            anticipatedSize[1] = 1;
            tempCliff4 = getBlockData("BLOXBGBS", 3, 'W', anticipatedSize);
            tempCliff5 = getBlockData("BLOXBGBS", 3, 'R', anticipatedSize);
            
            anticipatedSize[0] = 1;
            anticipatedSize[1] = 2;
            tempCliff6 = getBlockData("BLOXBGBS", 1, 'C', anticipatedSize);

            try{
                if(mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR][randC - 1] == tempCliff4[0] 
                        && mainBoard[randR - 1][randC] == tempCliff2[0] && mainBoard[randR][randC] == tempCliff2[1]
                        && mainBoard[randR - 1][randC + 1] == tempCliff2[2] && mainBoard[randR][randC + 1] == tempCliff2[3]){
                    mainBoard[randR - 1][randC - 1] = tempCliff[0];
                    mainBoard[randR][randC - 1] = tempCliff[1];
                    mainBoard[randR - 1][randC] = tempCliff[3];
                    mainBoard[randR][randC] = tempCliff[4];
                    mainBoard[randR - 1][randC + 1] = tempCliff[6];
                    mainBoard[randR][randC + 1] = tempCliff[7];
                }
            }catch(IndexOutOfBoundsException e){
                    
            }
            
            try{
                if(mainBoard[randR][randC - 1] == tempCliff5[0] && mainBoard[randR + 1][randC - 1] == 54341 
                        && mainBoard[randR][randC] == tempCliff3[0] && mainBoard[randR + 1][randC] == tempCliff3[1]
                        && mainBoard[randR][randC + 1] == tempCliff3[2] && mainBoard[randR + 1][randC + 1] == tempCliff3[3]){
                    mainBoard[randR][randC - 1] = tempCliff[2];
                    mainBoard[randR][randC] = tempCliff[5];
                    mainBoard[randR + 1][randC] = 54340;
                    mainBoard[randR][randC + 1] = tempCliff[8];
                    mainBoard[randR + 1][randC + 1] = 54340;
                    mainBoard[randR + 1][randC] = tempCliff6[0];
                    mainBoard[randR + 1][randC + 1] = tempCliff6[1];
   
                }
            }catch(IndexOutOfBoundsException e){
                    
            }
            
        }while(counter < (boardR * boardC * 0.15));
        
        anticipatedSize[0] = 1;
        anticipatedSize[1] = 2;
        tempCliff = getBlockData("BLOXBGBS", 1, 'C', anticipatedSize);
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == tempCliff[0] && mainBoard[r + 1][c] == tempCliff[0] 
                            && mainBoard[r][c + 1] == tempCliff[1] && mainBoard[r + 1][c + 1] == tempCliff[1]){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff2 = getBlockData("BLOXBGBS", 1, 'C', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff2[0];
                        mainBoard[r + 1][c] = tempCliff2[1];
                        mainBoard[r][c + 1] = tempCliff2[2];
                        mainBoard[r + 1][c + 1] = tempCliff2[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 543438){
                    mainBoard[r][c] = 0;
                    
                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addInfantryClimbs(int[][] mainBoard, int boardR, int boardC, int infantryClimbsToAdd, String tileset) throws IOException{
        int[] tempCliff = new int[9];
	int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int randR = 0;
        int randC = 0;
        int typeLimit = 1;
        int type = 0;
        int counter = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 4);
        int rando = 0;
        
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            type = rand.nextInt((typeLimit - min) + 1) + min;
            attempts++;
            
            if(type == 0){
                try{
                    if(mainBoard[randR - 3][randC - 1] == 54341 && mainBoard[randR - 2][randC - 1] == 54341 && mainBoard[randR + 2][randC - 1] == 54341 && mainBoard[randR + 3][randC - 1] == 54341 
                            && mainBoard[randR - 3][randC] == 54340 && mainBoard[randR - 2][randC] == 54340 && mainBoard[randR + 2][randC] == 54340 && mainBoard[randR + 3][randC] == 54340 
                            && mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR + 1][randC - 1] == 54341 
                            && mainBoard[randR - 1][randC] == 54340 && mainBoard[randR][randC] == 54340 && mainBoard[randR + 1][randC] == 54340 
                            && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 
                            && mainBoard[randR][randC + 2] == 54340 ){
                        anticipatedSize[0] = 3;
                        anticipatedSize[1] = 3;
                        tempCliff = getBlockData("BLOXBGBS", 1, '0', anticipatedSize);
                        
                        rando = rand.nextInt((1000 - 0) + 1) + 0;
                        if(rando >= 0 && rando <= 600 && tileset.matches("BLOXBGBS")){
                            tempCliff = getBlockData("BLOXBGBS", 7, 'F', anticipatedSize);
                            rando = rand.nextInt((1 - 0) + 1) + 0;
                            if(rando == 0){
                                counter--;
                                
                            }
                            
                        }
                        
                        mainBoard[randR - 1][randC - 1] = tempCliff[0]; 
                        mainBoard[randR][randC - 1] = tempCliff[1];
                        mainBoard[randR + 1][randC - 1] = tempCliff[2];
                        mainBoard[randR - 1][randC] = tempCliff[3];
                        mainBoard[randR][randC] = tempCliff[4];
                        mainBoard[randR + 1][randC] = tempCliff[5];
                        mainBoard[randR - 1][randC + 1] = tempCliff[6];
                        mainBoard[randR][randC + 1] = tempCliff[7];
                        mainBoard[randR + 1][randC + 1] = tempCliff[8];
                        counter++;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
            }else if(type == 1){
                try{
                    if(mainBoard[randR - 3][randC - 1] == 54341 && mainBoard[randR - 2][randC - 1] == 54341 && mainBoard[randR + 2][randC - 1] == 54341 && mainBoard[randR + 3][randC - 1] == 54341 
                            && mainBoard[randR - 3][randC] == 54340 && mainBoard[randR - 2][randC] == 54340 && mainBoard[randR + 2][randC] == 54340 && mainBoard[randR + 3][randC] == 54340 
                            && mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR + 1][randC - 1] == 54341 
                            && mainBoard[randR - 1][randC] == 54340 && mainBoard[randR][randC] == 54340 && mainBoard[randR + 1][randC] == 54340 
                            && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 
                            && mainBoard[randR][randC + 2] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'P', anticipatedSize);
                        
                        mainBoard[randR][randC] = tempCliff[0];
                        mainBoard[randR][randC + 1] = tempCliff[1];
                        counter++;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                infantryClimbsToAdd = 0;
                
            }
        }while(counter < infantryClimbsToAdd);
        
        return mainBoard;
    }
    
    public static int[][] scrambleSpawns(int[][] mainBoard, int boardR, int boardC, int scrambleSpawnRange){
        Random rand = new Random();
        int max = scrambleSpawnRange;
        int min = -scrambleSpawnRange;
        int randR = 0;
        int randC = 0;
        boolean movedSpawn = false;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        
        attempts = 0;
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 54349){
                    movedSpawn = false;
                    
                    do{
                        randR = rand.nextInt((max - min) + 1) + min;
                        randC = rand.nextInt((max - min) + 1) + min;
                        attempts++;
                        
                        try{
                            if(mainBoard[r + randR][c + randC] == 54341 ){
                                mainBoard[r + randR][c + randC] = 9991;
                                mainBoard[r][c] = 54341;
                                movedSpawn = true;
                                
                            }
                        }catch(IndexOutOfBoundsException e){

                        }
                        
                        if(attempts >= attemptsLimit){
                            movedSpawn = true;

                        }
                    }while(movedSpawn == false);
                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 9991){
                    mainBoard[r][c] = 54349;
                    
                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addSpecials(int[][] mainBoard, int boardR, int boardC, 
            double sandSpecialFreq, double rockSpecialFreq, String tileset) throws IOException{
        int counter = 0;
        int innerCounter = 0;
        Random rand = new Random();
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int randR = 0;
        int randC = 0;
        int[] tempHolder = new int[32];
        char[] charList = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 
                            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 
                            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', '@', //'', 
                            'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'};
        int i = 0;
        int[] size = new int[2];
        boolean doesFit = true;
        int maxSpecial = 0;
        int maxSpecialCounter = 0;
        boolean isOk = true;
        int temp = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        int[] anticipatedSize = new int[2];
        int[] tempCliff = new int[32];
        int sandTiles = 0;
        int rockTiles = 0;
        int rockToPlace = 0;
        int sandToPlace = 0;
        //0 1 2 3 4 5 6 7 8 9 
        //___________________
        //1 2 3 4 5 6 7 8 9 0|10
        //Q W E R T Y U I O P|20
        //A S D F G H J K L -|30
        //Z X C V B N M < > -|40
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 54340){
                    sandTiles++;
                    
                }if(mainBoard[r][c] == 54341){
                    rockTiles++;
                    
                }
                
            }
        }
        
        sandToPlace = (int)Math.ceil(sandSpecialFreq * sandTiles);
        rockToPlace = (int)Math.ceil(rockSpecialFreq * rockTiles);
        //System.out.println("sandTiles = " + sandTiles + " rockTiles + " + rockTiles);
        //System.out.println("sandToPlace = " + sandToPlace + " rockToPlace + " + rockToPlace);
        
        counter = 0;
        attempts = 0;
        do{
            i = rand.nextInt((39 - 0) + 1) + 0;
            //System.out.println("charList[i] = " + charList[i]);
            size = getSize(tileset, 5, charList[i]);
            //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
            doesFit = true;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            if(size[0] != -1){
                for(int ic = 0; ic != size[1]; ic++){
                    for(int ir = 0; ir != size[0]; ir++){
                        try{
                            if(mainBoard[randR + ir][randC + ic] == 54340){

                            }else{
                                doesFit = false;

                            }
                        }catch(IndexOutOfBoundsException e){
                            doesFit = false;
                            
                        }

                    }
                }

                //System.out.println("doesFit = " + doesFit);
                if(doesFit == true){
                    innerCounter = 0;
                    //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
                    tempHolder = getBlockDataSpecial(tileset, 5, charList[i], size);
                    counter++;

                    for(int ic = 0; ic != size[1]; ic++){
                        for(int ir = 0; ir != size[0]; ir++){
                            try{
                                mainBoard[randR + ir][randC + ic] = tempHolder[innerCounter];
                                innerCounter++;

                            }catch(IndexOutOfBoundsException e){

                            }

                        }
                    }
                }
            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                sandToPlace = 0;

            }
            
        }while(counter < sandToPlace);
        
        counter = 0;
        attempts = 0;
        do{
            i = rand.nextInt((39 - 0) + 1) + 0;
            //System.out.println("charList[i] = " + charList[i]);
            size = getSize(tileset, 6, charList[i]);
            //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
            doesFit = true;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            if(size[0] != -1){
                for(int ic = 0; ic != size[1]; ic++){
                    for(int ir = 0; ir != size[0]; ir++){
                        try{
                            if(mainBoard[randR + ir][randC + ic] == 54341){

                            }else{
                                doesFit = false;

                            }
                        }catch(IndexOutOfBoundsException e){
                            doesFit = false;
                            
                        }

                    }
                }

                //System.out.println("doesFit = " + doesFit);
                if(doesFit == true){
                    innerCounter = 0;
                    //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
                    tempHolder = getBlockDataSpecial(tileset, 6, charList[i], size);
                    counter++;

                    for(int ic = 0; ic != size[1]; ic++){
                        for(int ir = 0; ir != size[0]; ir++){
                            try{
                                mainBoard[randR + ir][randC + ic] = tempHolder[innerCounter];
                                innerCounter++;

                            }catch(IndexOutOfBoundsException e){

                            }

                        }
                    }
                }
            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                rockToPlace = 0;

            }
            
        }while(counter < rockToPlace);
        
        if(tileset.matches("BLOXWAST")){
            maxSpecial = rand.nextInt((2 - 0) + 1) + 0;
            counter = 0;
            do{
                counter++;
                randR = rand.nextInt((maxR - min) + 1) + min;
                randC = rand.nextInt((maxC - min) + 1) + min;

                if(maxSpecialCounter < maxSpecial){
                    try{
                        temp = mainBoard[randR][randC - 1];

                    }catch(IndexOutOfBoundsException e){
                        try{
                            if(mainBoard[randR][randC] == 54340 && mainBoard[randR + 1][randC] == 54340 && mainBoard[randR + 2][randC] == 54340
                                    && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 && mainBoard[randR + 2][randC + 1] == 54340 
                                    && mainBoard[randR][randC + 2] == 54340 && mainBoard[randR + 1][randC + 2] == 54340 && mainBoard[randR + 2][randC + 2] == 54340
                                    && mainBoard[randR][randC + 3] == 54340 && mainBoard[randR + 1][randC + 3] == 54340 && mainBoard[randR + 2][randC + 3] == 54340
                                    && mainBoard[randR][randC + 4] == 54340 && mainBoard[randR + 1][randC + 4] == 54340 && mainBoard[randR + 2][randC + 4] == 54340){
                                
                                anticipatedSize[0] = 3;
                                anticipatedSize[1] = 5;
                                tempCliff = getBlockDataSpecial("BLOXWAST", 5, '&', anticipatedSize);
                                maxSpecialCounter++;

                                mainBoard[randR][randC] = tempCliff[0];
                                mainBoard[randR + 1][randC] = tempCliff[1];
                                mainBoard[randR + 2][randC] = tempCliff[2];
                                
                                mainBoard[randR][randC + 1] = tempCliff[3];
                                mainBoard[randR + 1][randC + 1] = tempCliff[4];
                                mainBoard[randR + 2][randC + 1] = tempCliff[5];
                                
                                mainBoard[randR][randC + 2] = tempCliff[6];
                                mainBoard[randR + 1][randC + 2] = tempCliff[7];
                                mainBoard[randR + 2][randC + 2] = tempCliff[8];
                                
                                mainBoard[randR][randC + 3] = tempCliff[9];
                                mainBoard[randR + 1][randC + 3] = tempCliff[10];
                                mainBoard[randR + 2][randC + 3] = tempCliff[11];
                                
                                mainBoard[randR][randC + 4] = tempCliff[12];
                                mainBoard[randR + 1][randC + 4] = tempCliff[13];
                                mainBoard[randR + 2][randC + 4] = tempCliff[14];
                                
                            }
                        }catch(IndexOutOfBoundsException ee){
                            
                        }
                        
                    }
                }

            }while(counter < (boardR * boardC * 0.75));
        }
        
        return mainBoard;
    }
    
    public static int[][] addSpecialsOld(int[][] mainBoard, int boardR, int boardC, 
            int numberOfSandSpecialsToAdd, int numberOfRockSpecialsToAdd, String tileset) throws IOException{
        int counter = 0;
        int innerCounter = 0;
        Random rand = new Random();
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int randR = 0;
        int randC = 0;
        int[] tempHolder = new int[32];
        char[] charList = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 
                            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 
                            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', '@', //'', 
                            'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'};
        int i = 0;
        int[] size = new int[2];
        boolean doesFit = true;
        int maxSpecial = 0;
        int maxSpecialCounter = 0;
        boolean isOk = true;
        int temp = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        int[] anticipatedSize = new int[2];
        int[] tempCliff = new int[32];
        int sandTiles = 0;
        int rockTiles = 0;
        //0 1 2 3 4 5 6 7 8 9 
        //___________________
        //1 2 3 4 5 6 7 8 9 0|10
        //Q W E R T Y U I O P|20
        //A S D F G H J K L -|30
        //Z X C V B N M < > -|40
        
//        for(int c = 0; c != boardC; c++){
//            for(int r = 0; r != boardR; r++){
//                if(mainBoard[r][c] == 54340){
//                    sandTiles++;
//                    
//                }if(mainBoard[r][c] == 54341){
//                    rockTiles++;
//                    
//                }
//                
//            }
//        }
        
        System.out.println("sandTiles = " + sandTiles + " rockTiles + " + rockTiles);
        
        counter = 0;
        attempts = 0;
        do{
            i = rand.nextInt((39 - 0) + 1) + 0;
            //System.out.println("charList[i] = " + charList[i]);
            size = getSize(tileset, 5, charList[i]);
            //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
            doesFit = true;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            if(size[0] != -1){
                for(int ic = 0; ic != size[1]; ic++){
                    for(int ir = 0; ir != size[0]; ir++){
                        try{
                            if(mainBoard[randR + ir][randC + ic] == 54340){

                            }else{
                                doesFit = false;

                            }
                        }catch(IndexOutOfBoundsException e){
                            doesFit = false;
                            
                        }

                    }
                }

                //System.out.println("doesFit = " + doesFit);
                if(doesFit == true){
                    innerCounter = 0;
                    //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
                    tempHolder = getBlockDataSpecial(tileset, 5, charList[i], size);
                    counter++;

                    for(int ic = 0; ic != size[1]; ic++){
                        for(int ir = 0; ir != size[0]; ir++){
                            try{
                                mainBoard[randR + ir][randC + ic] = tempHolder[innerCounter];
                                innerCounter++;

                            }catch(IndexOutOfBoundsException e){

                            }

                        }
                    }
                }
            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                numberOfSandSpecialsToAdd = 0;

            }
            
        }while(counter < numberOfSandSpecialsToAdd);
        
        counter = 0;
        attempts = 0;
        do{
            i = rand.nextInt((39 - 0) + 1) + 0;
            //System.out.println("charList[i] = " + charList[i]);
            size = getSize(tileset, 6, charList[i]);
            //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
            doesFit = true;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            if(size[0] != -1){
                for(int ic = 0; ic != size[1]; ic++){
                    for(int ir = 0; ir != size[0]; ir++){
                        try{
                            if(mainBoard[randR + ir][randC + ic] == 54341){

                            }else{
                                doesFit = false;

                            }
                        }catch(IndexOutOfBoundsException e){
                            doesFit = false;
                            
                        }

                    }
                }

                //System.out.println("doesFit = " + doesFit);
                if(doesFit == true){
                    innerCounter = 0;
                    //System.out.println("size[0] = " + size[0] + " size[1] = " + size[1]);
                    tempHolder = getBlockDataSpecial(tileset, 6, charList[i], size);
                    counter++;

                    for(int ic = 0; ic != size[1]; ic++){
                        for(int ir = 0; ir != size[0]; ir++){
                            try{
                                mainBoard[randR + ir][randC + ic] = tempHolder[innerCounter];
                                innerCounter++;

                            }catch(IndexOutOfBoundsException e){

                            }

                        }
                    }
                }
            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                numberOfRockSpecialsToAdd = 0;

            }
            
        }while(counter < numberOfRockSpecialsToAdd);
        
        if(tileset.matches("BLOXWAST")){
            maxSpecial = rand.nextInt((2 - 0) + 1) + 0;
            counter = 0;
            do{
                counter++;
                randR = rand.nextInt((maxR - min) + 1) + min;
                randC = rand.nextInt((maxC - min) + 1) + min;

                if(maxSpecialCounter < maxSpecial){
                    try{
                        temp = mainBoard[randR][randC - 1];

                    }catch(IndexOutOfBoundsException e){
                        try{
                            if(mainBoard[randR][randC] == 54340 && mainBoard[randR + 1][randC] == 54340 && mainBoard[randR + 2][randC] == 54340
                                    && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 && mainBoard[randR + 2][randC + 1] == 54340 
                                    && mainBoard[randR][randC + 2] == 54340 && mainBoard[randR + 1][randC + 2] == 54340 && mainBoard[randR + 2][randC + 2] == 54340
                                    && mainBoard[randR][randC + 3] == 54340 && mainBoard[randR + 1][randC + 3] == 54340 && mainBoard[randR + 2][randC + 3] == 54340
                                    && mainBoard[randR][randC + 4] == 54340 && mainBoard[randR + 1][randC + 4] == 54340 && mainBoard[randR + 2][randC + 4] == 54340){
                                
                                anticipatedSize[0] = 3;
                                anticipatedSize[1] = 5;
                                tempCliff = getBlockDataSpecial("BLOXWAST", 5, '&', anticipatedSize);
                                maxSpecialCounter++;

                                mainBoard[randR][randC] = tempCliff[0];
                                mainBoard[randR + 1][randC] = tempCliff[1];
                                mainBoard[randR + 2][randC] = tempCliff[2];
                                
                                mainBoard[randR][randC + 1] = tempCliff[3];
                                mainBoard[randR + 1][randC + 1] = tempCliff[4];
                                mainBoard[randR + 2][randC + 1] = tempCliff[5];
                                
                                mainBoard[randR][randC + 2] = tempCliff[6];
                                mainBoard[randR + 1][randC + 2] = tempCliff[7];
                                mainBoard[randR + 2][randC + 2] = tempCliff[8];
                                
                                mainBoard[randR][randC + 3] = tempCliff[9];
                                mainBoard[randR + 1][randC + 3] = tempCliff[10];
                                mainBoard[randR + 2][randC + 3] = tempCliff[11];
                                
                                mainBoard[randR][randC + 4] = tempCliff[12];
                                mainBoard[randR + 1][randC + 4] = tempCliff[13];
                                mainBoard[randR + 2][randC + 4] = tempCliff[14];
                                
                            }
                        }catch(IndexOutOfBoundsException ee){
                            
                        }
                        
                    }
                }

            }while(counter < (boardR * boardC * 0.75));
        }
        
        return mainBoard;
    }
    
    public static boolean areaOutOfBounds(int[][] mainBoard, int boardR, int boardC, int r, int c){
        int temp = 0;
        
        try{
            for(int c2 = -3; c2 != 4; c2++){
                for(int r2 = -3; r2 != 4; r2++){
                    temp = mainBoard[r + r2][c + c2];
                    
                }
            }
            return false;
            
        }catch(IndexOutOfBoundsException e){
            return true;
            
        }
    }
    
    public static boolean outOfBounds(int[][] mainBoard, int r, int c){
        int temp = 0;
        
        try{
            temp = mainBoard[r][c];
            return false;
            
        }catch(IndexOutOfBoundsException e){
            return true;
            
        }
    }
    
    public static int[][] removeEdgeGaps(int[][] mainBoard, int boardR, int boardC){
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r][c - 1] == 54340 && outOfBounds(mainBoard, (r), (c - 2)) == true){
                        mainBoard[r][c - 1] = 54341;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r + 1][c] == 54340 && outOfBounds(mainBoard, (r + 2), (c)) == true){
                        mainBoard[r + 1][c] = 54341;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54340 && outOfBounds(mainBoard, (r), (c + 2)) == true){
                        mainBoard[r][c + 1] = 54341;

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r - 1][c] == 54340 && outOfBounds(mainBoard, (r - 2), (c)) == true){
                        mainBoard[r - 1][c] = 54341;

                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static boolean roomForEntrances(int[][] mainBoard, int boardR, int boardC, int r, int c, int entranceSize){
        boolean room = true;
        
        for(int cRange = -(entranceSize + 3); cRange != (entranceSize + 4); cRange++){
            for(int rRange = -(entranceSize + 3); rRange != (entranceSize + 4); rRange++){
                try{
                    if(mainBoard[r + rRange][c + cRange] == 543438){
                        room = false;
                        
                    }else{
                        
                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        return room;
    }
    
    public static boolean roomForDunes(int[][] mainBoard, int boardR, int boardC, int r, int c){
        boolean room = true;
        
        for(int cRange = -2; cRange != 3; cRange++){
            for(int rRange = -2; rRange != 3; rRange++){
                try{
                    if(mainBoard[r + rRange][c + cRange] == 54340 ){


                    }else{
                        room = false;

                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return room;
    }
    
    public static int[][] addDunes(int[][] mainBoard, int boardR, int boardC, 
            int numberOfDuneStarts, int numberOfDuneSquares, int duneSquareTop, int duneSquareRight, int duneSquareBottom, int duneSquareLeft, 
            int numberOfDuneSquaresAtATime) throws IOException{
        int[] tempCliff = new int[4];
        int[] tempCliff2 = new int[4];
        int[] tempCliffa1 = new int[1];
        int[] tempCliffa2 = new int[1];
        int[] tempCliffa3 = new int[1];
        int[] tempCliffa4 = new int[1];
        int[] tempCliffb1 = new int[1];
        int[] tempCliffb2 = new int[1];
        int[] tempCliffb3 = new int[1];
        int[] tempCliffb4 = new int[1];
	int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int counter = 0;
        int counterInner = -1;
        int[] edges = new int[2];
        int[][] mainBoardTemp = mainBoard;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        int max = 1;
        int randVar = 0;
        
        int[] values = new int[4];
        int[] valuesToUse = new int[4];
        
        values[0] = duneSquareTop;
        values[1] = duneSquareRight;
        values[2] = duneSquareBottom;
        values[3] = duneSquareLeft;

        attempts = 0;
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            try{
                if(mainBoard[randR][randC] == 54340 && roomForDunes(mainBoard, boardR, boardC, randR, randC) == true){
                    mainBoard[randR][randC] = 9997;//9998;
                    mainBoard[randR - 1][randC - 1] = 9997;
                    mainBoard[randR][randC - 1] = 9997;
                    mainBoard[randR + 1][randC - 1] = 9997;
                    mainBoard[randR + 1][randC] = 9997;
                    mainBoard[randR + 1][randC + 1] = 9997;
                    mainBoard[randR][randC + 1] = 9997;
                    mainBoard[randR - 1][randC + 1] = 9997;
                    mainBoard[randR - 1][randC] = 9997;
                    counter++;
                    
                }
                
            }catch(IndexOutOfBoundsException e){

            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                numberOfDuneStarts = 0;

            }
            
        }while(counter < numberOfDuneStarts);

        counter = 0;
        do{
            edges = findAnEdgeSquare(mainBoard, boardR, boardC, 3);
            
            if(edges[0] == -1){
                counter = 999999999;
                numberOfDuneSquares = 0;
                
            }
            
            counterInner++;
            counter++;
            
            valuesToUse[0] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[1] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[2] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[3] = values[rand.nextInt((3 - 0) + 1) + 0];
            
            for(int newC = (edges[1] - valuesToUse[0]); newC != (edges[1] + valuesToUse[1] + 1); newC++){
                for(int newR = (edges[0] - valuesToUse[2]); newR != (edges[0] + valuesToUse[3] + 1); newR++){
                    try{
                        if(mainBoardTemp[newR][newC] == 54340 ){
                            mainBoardTemp[newR][newC] = 9997;
                            
                        }
                        
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                }
            }
            
            if(counterInner >= numberOfDuneSquaresAtATime){
                mainBoard = mainBoardTemp;
                counterInner = -1;
                
            }
            
        }while(counter < numberOfDuneSquares);
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 9997){
                    try{
                        if(mainBoard[r][c - 1] != 9997 && mainBoard[r][c - 1] != 9998 
                                || mainBoard[r + 1][c] != 9997 && mainBoard[r + 1][c] != 9998 
                                || mainBoard[r][c + 1] != 9997 && mainBoard[r][c + 1] != 9998 
                                || mainBoard[r - 1][c] != 9997 && mainBoard[r - 1][c] != 9998
                                || mainBoard[r - 1][c - 1] != 9997 && mainBoard[r - 1][c - 1] != 9998
                                || mainBoard[r + 1][c - 1] != 9997 && mainBoard[r + 1][c - 1] != 9998
                                || mainBoard[r + 1][c + 1] != 9997 && mainBoard[r + 1][c + 1] != 9998
                                || mainBoard[r - 1][c + 1] != 9997 && mainBoard[r - 1][c + 1] != 9998){
                            mainBoard[r][c] = 9998;

                        }
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r - 2][c] == 9998 && mainBoard[r - 1][c] == 9998 && mainBoard[r][c - 1] == 9998 && mainBoard[r + 1][c - 1] == 9998
                            && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r + 1][c + 1] == 9997 && mainBoard[r + 1][c] == 9997
                            && mainBoard[r - 1][c - 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, '2', anticipatedSize);
                        
                        mainBoard[r - 1][c - 1] = tempCliff[0];
                        mainBoard[r][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c] = tempCliff[2];
                        mainBoard[r][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r - 1][c - 1] == 9998 && mainBoard[r][c - 1] == 9998 && mainBoard[r + 1][c] == 9998 && mainBoard[r + 2][c] == 9998
                            && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r + 1][c + 1] == 9997
                            && mainBoard[r + 1][c - 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, '4', anticipatedSize);
                        
                        mainBoard[r][c - 1] = tempCliff[0];
                        mainBoard[r + 1][c - 1] = tempCliff[1];
                        mainBoard[r][c] = tempCliff[2];
                        mainBoard[r + 1][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r][c - 2] == 9998 && mainBoard[r][c - 1] == 9998 && mainBoard[r + 1][c] == 9998 && mainBoard[r + 1][c + 1] == 9998
                            && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997
                            && mainBoard[r + 1][c - 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'T', anticipatedSize);
                        
                        mainBoard[r][c - 1] = tempCliff[0];
                        mainBoard[r + 1][c - 1] = tempCliff[1];
                        mainBoard[r][c] = tempCliff[2];
                        mainBoard[r + 1][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r + 1][c - 1] == 9998 && mainBoard[r + 1][c] == 9998 && mainBoard[r][c + 1] == 9998 && mainBoard[r][c + 2] == 9998
                            && mainBoard[r][c - 1] == 9997 && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997
                            && mainBoard[r + 1][c + 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'G', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        mainBoard[r + 1][c] = tempCliff[1];
                        mainBoard[r][c + 1] = tempCliff[2];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r - 1][c + 1] == 9998 && mainBoard[r][c + 1] == 9998 && mainBoard[r + 1][c] == 9998 && mainBoard[r + 2][c] == 9998
                            && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997
                            && mainBoard[r + 1][c + 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'V', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        mainBoard[r + 1][c] = tempCliff[1];
                        mainBoard[r][c + 1] = tempCliff[2];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r - 2][c] == 9998 && mainBoard[r - 1][c] == 9998 && mainBoard[r][c + 1] == 9998 && mainBoard[r + 1][c + 1] == 9998
                            && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997
                            && mainBoard[r - 1][c + 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'X', anticipatedSize);
                        
                        mainBoard[r - 1][c] = tempCliff[0];
                        mainBoard[r][c] = tempCliff[1];
                        mainBoard[r - 1][c + 1] = tempCliff[2];
                        mainBoard[r][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r - 1][c - 1] == 9998 && mainBoard[r - 1][c] == 9998 && mainBoard[r][c + 1] == 9998 && mainBoard[r][c + 2] == 9998
                            && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 1][c + 1] == 9997
                            && mainBoard[r - 1][c + 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'A', anticipatedSize);
                        
                        mainBoard[r - 1][c] = tempCliff[0];
                        mainBoard[r][c] = tempCliff[1];
                        mainBoard[r - 1][c + 1] = tempCliff[2];
                        mainBoard[r][c + 1] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
                try{
                    if(mainBoard[r][c] == 9998 
                            && mainBoard[r][c - 2] == 9998 && mainBoard[r][c - 1] == 9998 && mainBoard[r - 1][c] == 9998 && mainBoard[r - 1][c + 1] == 9998
                            && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997
                            && mainBoard[r - 1][c - 1] == 54340){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'Q', anticipatedSize);
                        
                        mainBoard[r - 1][c - 1] = tempCliff[0];
                        mainBoard[r][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c] = tempCliff[2];
                        mainBoard[r][c] = tempCliff[3];
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        //removing flat areas
        counter = 0;
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
                    
            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR + 1][randC] == 9998 && mainBoard[randR + 2][randC] == 9998 && mainBoard[randR + 3][randC] == 9998
                        && mainBoard[randR][randC - 1] == 54340 && mainBoard[randR + 1][randC - 1] == 54340 && mainBoard[randR + 2][randC - 1] == 54340 && mainBoard[randR + 3][randC - 1] == 54340 
                        && mainBoard[randR][randC + 1] == 9997 && mainBoard[randR + 1][randC + 1] == 9997 && mainBoard[randR + 2][randC + 1] == 9997 && mainBoard[randR + 3][randC + 1] == 9997 
                        && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR - 1][randC] == 9998 && mainBoard[randR - 1][randC + 1] == 9997 
                        && mainBoard[randR + 4][randC - 1] == 54340 && mainBoard[randR + 4][randC] == 9998 && mainBoard[randR + 4][randC + 1] == 9997 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - out, 1 - in
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, '2', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, '4', anticipatedSize);
                    

                    if(randVar == 0){
                        mainBoard[randR][randC - 1] = tempCliff[0];
                        mainBoard[randR + 1][randC - 1] = tempCliff[1];
                        mainBoard[randR + 2][randC - 1] = tempCliff2[0];
                        mainBoard[randR + 3][randC - 1] = tempCliff2[1];
                        mainBoard[randR][randC] = tempCliff[2];
                        mainBoard[randR + 1][randC] = tempCliff[3];
                        mainBoard[randR + 2][randC] = tempCliff2[2];
                        mainBoard[randR + 3][randC] = tempCliff2[3];

                    }else if(randVar == 1){
                        mainBoard[randR][randC] = tempCliff2[0];
                        mainBoard[randR + 1][randC] = tempCliff2[1];
                        mainBoard[randR + 2][randC] = tempCliff[0];
                        mainBoard[randR + 3][randC] = tempCliff[1];
                        mainBoard[randR][randC + 1] = tempCliff2[2];
                        mainBoard[randR + 1][randC + 1] = tempCliff2[3];
                        mainBoard[randR + 2][randC + 1] = tempCliff[2];
                        mainBoard[randR + 3][randC + 1] = tempCliff[3];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR][randC + 1] == 9998 && mainBoard[randR][randC + 2] == 9998 && mainBoard[randR][randC + 3] == 9998
                        && mainBoard[randR + 1][randC] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 && mainBoard[randR + 1][randC + 2] == 54340 && mainBoard[randR + 1][randC + 3] == 54340 
                        && mainBoard[randR - 1][randC] == 9997 && mainBoard[randR - 1][randC + 1] == 9997 && mainBoard[randR - 1][randC + 2] == 9997 && mainBoard[randR - 1][randC + 3] == 9997 
                        && mainBoard[randR + 1][randC - 1] == 54340 && mainBoard[randR][randC - 1] == 9998 && mainBoard[randR - 1][randC - 1] == 9997 
                        && mainBoard[randR + 1][randC + 4] == 54340 && mainBoard[randR][randC + 4] == 9998 && mainBoard[randR - 1][randC + 4] == 9997 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - in, 1 - out
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, 'T', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, 'G', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR][randC] = tempCliff[0];
                        mainBoard[randR][randC + 1] = tempCliff[2];
                        mainBoard[randR][randC + 2] = tempCliff2[0];
                        mainBoard[randR][randC + 3] = tempCliff2[2];
                        mainBoard[randR + 1][randC] = tempCliff[1];
                        mainBoard[randR + 1][randC + 1] = tempCliff[3];
                        mainBoard[randR + 1][randC + 2] = tempCliff2[1];
                        mainBoard[randR + 1][randC + 3] = tempCliff2[3];

                    }else if(randVar == 1){
                        mainBoard[randR - 1][randC] = tempCliff2[0];
                        mainBoard[randR - 1][randC + 1] = tempCliff2[2];
                        mainBoard[randR - 1][randC + 2] = tempCliff[0];
                        mainBoard[randR - 1][randC + 3] = tempCliff[2];
                        mainBoard[randR][randC] = tempCliff2[1];
                        mainBoard[randR][randC + 1] = tempCliff2[3];
                        mainBoard[randR][randC + 2] = tempCliff[1];
                        mainBoard[randR][randC + 3] = tempCliff[3];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR - 1][randC] == 9998 && mainBoard[randR - 2][randC] == 9998 && mainBoard[randR - 3][randC] == 9998
                        && mainBoard[randR][randC + 1] == 54340 && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR - 2][randC + 1] == 54340 && mainBoard[randR - 3][randC + 1] == 54340 
                        && mainBoard[randR][randC - 1] == 9997 && mainBoard[randR - 1][randC - 1] == 9997 && mainBoard[randR - 2][randC - 1] == 9997 && mainBoard[randR - 3][randC - 1] == 9997 
                        && mainBoard[randR - 4][randC + 1] == 54340 && mainBoard[randR - 4][randC] == 9998 && mainBoard[randR - 4][randC - 1] == 9997 
                        && mainBoard[randR + 1][randC + 1] == 54340 && mainBoard[randR + 1][randC] == 9998 && mainBoard[randR + 1][randC - 1] == 9997 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - in, 1 - out
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, 'V', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, 'X', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR - 3][randC] = tempCliff2[0];
                        mainBoard[randR - 2][randC] = tempCliff2[1];
                        mainBoard[randR - 1][randC] = tempCliff[0];
                        mainBoard[randR][randC] = tempCliff[1];
                        mainBoard[randR - 3][randC + 1] = tempCliff2[2];
                        mainBoard[randR - 2][randC + 1] = tempCliff2[3];
                        mainBoard[randR - 1][randC + 1] = tempCliff[2];
                        mainBoard[randR][randC + 1] = tempCliff[3];

                    }else if(randVar == 1){
                        mainBoard[randR - 3][randC - 1] = tempCliff[0];
                        mainBoard[randR - 2][randC - 1] = tempCliff[1];
                        mainBoard[randR - 1][randC - 1] = tempCliff2[0];
                        mainBoard[randR][randC - 1] = tempCliff2[1];
                        mainBoard[randR - 3][randC] = tempCliff[2];
                        mainBoard[randR - 2][randC] = tempCliff[3];
                        mainBoard[randR - 1][randC] = tempCliff2[2];
                        mainBoard[randR][randC] = tempCliff2[3];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR][randC - 1] == 9998 && mainBoard[randR][randC - 2] == 9998 && mainBoard[randR][randC - 3] == 9998
                        && mainBoard[randR - 1][randC] == 54340 && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR - 1][randC - 2] == 54340 && mainBoard[randR - 1][randC - 3] == 54340 
                        && mainBoard[randR + 1][randC] == 9997 && mainBoard[randR + 1][randC - 1] == 9997 && mainBoard[randR + 1][randC - 2] == 9997 && mainBoard[randR + 1][randC - 3] == 9997 
                        && mainBoard[randR - 1][randC - 4] == 54340 && mainBoard[randR][randC - 4] == 9998 && mainBoard[randR + 1][randC - 4] == 9997 
                        && mainBoard[randR - 1][randC + 1] == 54340 && mainBoard[randR][randC + 1] == 9998 && mainBoard[randR + 1][randC + 1] == 9997 ){
                    randVar = rand.nextInt((max - min) + 1) + min;//0 - in, 1 - out
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, 'A', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, 'Q', anticipatedSize);

                    if(randVar == 0){
                        mainBoard[randR][randC - 3] = tempCliff2[1];
                        mainBoard[randR][randC - 2] = tempCliff2[3];
                        mainBoard[randR][randC - 1] = tempCliff[1];
                        mainBoard[randR][randC] = tempCliff[3];
                        mainBoard[randR - 1][randC - 3] = tempCliff2[0];
                        mainBoard[randR - 1][randC - 2] = tempCliff2[2];
                        mainBoard[randR - 1][randC - 1] = tempCliff[0];
                        mainBoard[randR - 1][randC] = tempCliff[2];

                    }else if(randVar == 1){
                        mainBoard[randR + 1][randC - 3] = tempCliff[1];
                        mainBoard[randR + 1][randC - 2] = tempCliff[3];
                        mainBoard[randR + 1][randC - 1] = tempCliff2[1];
                        mainBoard[randR + 1][randC] = tempCliff2[3];
                        mainBoard[randR][randC - 3] = tempCliff[0];
                        mainBoard[randR][randC - 2] = tempCliff[2];
                        mainBoard[randR][randC - 1] = tempCliff2[0];
                        mainBoard[randR][randC] = tempCliff2[2];

                    }
                }

            }catch(IndexOutOfBoundsException e){

            }
                
            
        }while(counter < (boardR * boardC * 2));
        
        counter = 0;
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
                    
            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR + 1][randC] == 9998 && mainBoard[randR + 2][randC] == 9998 && mainBoard[randR + 3][randC] == 9998
                        && mainBoard[randR][randC + 1] == 9997 && mainBoard[randR + 1][randC + 1] == 9997 && mainBoard[randR + 2][randC + 1] == 9997 && mainBoard[randR + 3][randC + 1] == 9997 
                        && mainBoard[randR - 1][randC] == 9998 && mainBoard[randR - 1][randC + 1] == 9997 
                        && mainBoard[randR + 4][randC] == 9998 && mainBoard[randR + 4][randC + 1] == 9997 ){
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, '2', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, '4', anticipatedSize);
                    
                    mainBoard[randR][randC] = tempCliff2[0];
                    mainBoard[randR + 1][randC] = tempCliff2[1];
                    mainBoard[randR + 2][randC] = tempCliff[0];
                    mainBoard[randR + 3][randC] = tempCliff[1];
                    mainBoard[randR][randC + 1] = tempCliff2[2];
                    mainBoard[randR + 1][randC + 1] = tempCliff2[3];
                    mainBoard[randR + 2][randC + 1] = tempCliff[2];
                    mainBoard[randR + 3][randC + 1] = tempCliff[3];
                    
                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR][randC + 1] == 9998 && mainBoard[randR][randC + 2] == 9998 && mainBoard[randR][randC + 3] == 9998
                        && mainBoard[randR - 1][randC] == 9997 && mainBoard[randR - 1][randC + 1] == 9997 && mainBoard[randR - 1][randC + 2] == 9997 && mainBoard[randR - 1][randC + 3] == 9997 
                        && mainBoard[randR][randC - 1] == 9998 && mainBoard[randR - 1][randC - 1] == 9997 
                        && mainBoard[randR][randC + 4] == 9998 && mainBoard[randR - 1][randC + 4] == 9997 ){
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, 'T', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, 'G', anticipatedSize);
                    
                    mainBoard[randR - 1][randC] = tempCliff2[0];
                    mainBoard[randR - 1][randC + 1] = tempCliff2[2];
                    mainBoard[randR - 1][randC + 2] = tempCliff[0];
                    mainBoard[randR - 1][randC + 3] = tempCliff[2];
                    mainBoard[randR][randC] = tempCliff2[1];
                    mainBoard[randR][randC + 1] = tempCliff2[3];
                    mainBoard[randR][randC + 2] = tempCliff[1];
                    mainBoard[randR][randC + 3] = tempCliff[3];
                    

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR - 1][randC] == 9998 && mainBoard[randR - 2][randC] == 9998 && mainBoard[randR - 3][randC] == 9998
                        && mainBoard[randR][randC - 1] == 9997 && mainBoard[randR - 1][randC - 1] == 9997 && mainBoard[randR - 2][randC - 1] == 9997 && mainBoard[randR - 3][randC - 1] == 9997 
                        && mainBoard[randR - 4][randC] == 9998 && mainBoard[randR - 4][randC - 1] == 9997 
                        && mainBoard[randR + 1][randC] == 9998 && mainBoard[randR + 1][randC - 1] == 9997 ){
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, 'V', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, 'X', anticipatedSize);

                    mainBoard[randR - 3][randC - 1] = tempCliff[0];
                    mainBoard[randR - 2][randC - 1] = tempCliff[1];
                    mainBoard[randR - 1][randC - 1] = tempCliff2[0];
                    mainBoard[randR][randC - 1] = tempCliff2[1];
                    mainBoard[randR - 3][randC] = tempCliff[2];
                    mainBoard[randR - 2][randC] = tempCliff[3];
                    mainBoard[randR - 1][randC] = tempCliff2[2];
                    mainBoard[randR][randC] = tempCliff2[3];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR][randC - 1] == 9998 && mainBoard[randR][randC - 2] == 9998 && mainBoard[randR][randC - 3] == 9998
                        && mainBoard[randR + 1][randC] == 9997 && mainBoard[randR + 1][randC - 1] == 9997 && mainBoard[randR + 1][randC - 2] == 9997 && mainBoard[randR + 1][randC - 3] == 9997 
                        && mainBoard[randR][randC - 4] == 9998 && mainBoard[randR + 1][randC - 4] == 9997 
                        && mainBoard[randR][randC + 1] == 9998 && mainBoard[randR + 1][randC + 1] == 9997 ){
                    anticipatedSize[0] = 2;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 4, 'A', anticipatedSize);
                    tempCliff2 = getBlockData("BLOXBGBS", 4, 'Q', anticipatedSize);

                    mainBoard[randR + 1][randC - 3] = tempCliff[1];
                    mainBoard[randR + 1][randC - 2] = tempCliff[3];
                    mainBoard[randR + 1][randC - 1] = tempCliff2[1];
                    mainBoard[randR + 1][randC] = tempCliff2[3];
                    mainBoard[randR][randC - 3] = tempCliff[0];
                    mainBoard[randR][randC - 2] = tempCliff[2];
                    mainBoard[randR][randC - 1] = tempCliff2[0];
                    mainBoard[randR][randC] = tempCliff2[2];
                    
                }

            }catch(IndexOutOfBoundsException e){

            }
                
            
        }while(counter < (boardR * boardC * 2));
        
        counter = 0;
        anticipatedSize[0] = 1;
        anticipatedSize[1] = 1;
        tempCliffa1 = getBlockData("BLOXBGBS", 4, '1', anticipatedSize);
        tempCliffa2 = getBlockData("BLOXBGBS", 4, '5', anticipatedSize);
        tempCliffa3 = getBlockData("BLOXBGBS", 4, 'B', anticipatedSize);
        tempCliffa4 = getBlockData("BLOXBGBS", 4, 'Z', anticipatedSize);
        tempCliffb1 = getBlockData("BLOXBGBS", 4, 'W', anticipatedSize);
        tempCliffb2 = getBlockData("BLOXBGBS", 4, 'R', anticipatedSize);
        tempCliffb3 = getBlockData("BLOXBGBS", 4, 'F', anticipatedSize);
        tempCliffb4 = getBlockData("BLOXBGBS", 4, 'S', anticipatedSize);
        do{
            counter++;
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
                    
            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR + 1][randC] == 9998 && mainBoard[randR + 2][randC] == 9998 
                        && mainBoard[randR][randC + 1] == 9997 && mainBoard[randR + 1][randC + 1] == 9997 && mainBoard[randR + 2][randC + 1] == 9997 
                        && mainBoard[randR - 1][randC] == 9998 && mainBoard[randR - 1][randC + 1] == 9997 
                        && mainBoard[randR + 3][randC] == 9998 && mainBoard[randR + 3][randC + 1] == 9997 ){
                    randVar = rand.nextInt((max - min) + 1) + min;
                        
                    mainBoard[randR][randC] = tempCliffa2[0];

                    mainBoard[randR + 1][randC] = 54340;
                    mainBoard[randR + 2][randC] = tempCliffa1[0];
                    mainBoard[randR][randC + 1] = tempCliffb4[0];
                    
                    tempCliff = getBlockData("BLOXBGBS", 4, '3', anticipatedSize);
                    mainBoard[randR + 1][randC + 1] = tempCliff[0];
                    mainBoard[randR + 2][randC + 1] = tempCliffb3[0];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR][randC + 1] == 9998 && mainBoard[randR][randC + 2] == 9998 
                        && mainBoard[randR - 1][randC] == 9997 && mainBoard[randR - 1][randC + 1] == 9997 && mainBoard[randR - 1][randC + 2] == 9997 
                        && mainBoard[randR][randC - 1] == 9998 && mainBoard[randR - 1][randC - 1] == 9997 
                        && mainBoard[randR][randC + 3] == 9998 && mainBoard[randR - 1][randC + 3] == 9997 ){
                    randVar = rand.nextInt((max - min) + 1) + min;
                        
                    
                    mainBoard[randR - 1][randC] = tempCliffb1[0];
                    mainBoard[randR][randC] = tempCliffa3[0];
                    
                    tempCliff = getBlockData("BLOXBGBS", 4, 'D', anticipatedSize);
                    mainBoard[randR - 1][randC + 1] = tempCliff[0];
                    mainBoard[randR][randC + 1] = 54340;
                    mainBoard[randR - 1][randC + 2] = tempCliffb4[0];
                    
                    mainBoard[randR][randC + 2] = tempCliffa2[0];


                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR - 1][randC] == 9998 && mainBoard[randR - 2][randC] == 9998 
                        && mainBoard[randR][randC - 1] == 9997 && mainBoard[randR - 1][randC - 1] == 9997 && mainBoard[randR - 2][randC - 1] == 9997 
                        && mainBoard[randR - 3][randC] == 9998 && mainBoard[randR - 3][randC - 1] == 9997 
                        && mainBoard[randR + 1][randC] == 9998 && mainBoard[randR + 1][randC - 1] == 9997 ){

                    mainBoard[randR - 2][randC - 1] = tempCliffb1[0];
                    
                    tempCliff = getBlockData("BLOXBGBS", 4, 'C', anticipatedSize);
                    mainBoard[randR - 1][randC - 1] = tempCliff[0];
                    mainBoard[randR][randC - 1] = tempCliffb2[0];
                    mainBoard[randR - 2][randC] = tempCliffa3[0];
                    mainBoard[randR - 1][randC] = 54340;
                    mainBoard[randR][randC] = tempCliffa4[0];

                }

            }catch(IndexOutOfBoundsException e){

            }

            try{
                if(mainBoard[randR][randC] == 9998
                        && mainBoard[randR][randC - 1] == 9998 && mainBoard[randR][randC - 2] == 9998 
                        && mainBoard[randR + 1][randC] == 9997 && mainBoard[randR + 1][randC - 1] == 9997 && mainBoard[randR + 1][randC - 2] == 9997 
                        && mainBoard[randR][randC - 3] == 9998 && mainBoard[randR + 1][randC - 3] == 9997 
                        && mainBoard[randR][randC + 1] == 9998 && mainBoard[randR + 1][randC + 1] == 9997 ){

                    mainBoard[randR][randC - 2] = tempCliffa4[0];
                    mainBoard[randR + 1][randC - 2] = tempCliffb2[0];
                    mainBoard[randR][randC - 1] = 54340;
                    
                    tempCliff = getBlockData("BLOXBGBS", 4, 'E', anticipatedSize);
                    mainBoard[randR + 1][randC - 1] = tempCliff[0];
                    mainBoard[randR][randC] = tempCliffa1[0];
                    mainBoard[randR + 1][randC] = tempCliffb3[0];

                }

            }catch(IndexOutOfBoundsException e){

            }
                
            
        }while(counter < (boardR * boardC * 2));
        
        
        
        
        
        
        
        
        
        
        
//        for(int c = 0; c != boardC; c++){
//            for(int r = 0; r != boardR; r++){
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r - 2][c] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997
//                            && mainBoard[r - 2][c + 1] == 9997 && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r + 1][c + 1] == 9997 && mainBoard[r + 1][c] == 9997
//                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, '2', anticipatedSize);
//                        
//                        mainBoard[r - 1][c - 1] = tempCliff[0];
//                        mainBoard[r][c - 1] = tempCliff[1];
//                        mainBoard[r - 1][c] = tempCliff[2];
//                        mainBoard[r][c] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 2][c] == 9997
//                            && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r + 1][c + 1] == 9997 && mainBoard[r + 2][c + 1] == 9997
//                            && mainBoard[r - 1][c - 2] == 54340 && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, '4', anticipatedSize);
//                        
//                        mainBoard[r][c - 1] = tempCliff[0];
//                        mainBoard[r + 1][c - 1] = tempCliff[1];
//                        mainBoard[r][c] = tempCliff[2];
//                        mainBoard[r + 1][c] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r][c - 2] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 1][c + 1] == 9997
//                            && mainBoard[r - 1][c - 2] == 9997 && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997
//                            && mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c] == 54340 && mainBoard[r + 2][c + 1] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, 'T', anticipatedSize);
//                        
//                        mainBoard[r][c - 1] = tempCliff[0];
//                        mainBoard[r + 1][c - 1] = tempCliff[1];
//                        mainBoard[r][c] = tempCliff[2];
//                        mainBoard[r + 1][c] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r][c + 2] == 9997
//                            && mainBoard[r][c - 1] == 9997 && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r - 1][c + 2] == 9997
//                            && mainBoard[r + 2][c - 1] == 54340 && mainBoard[r + 2][c] == 54340 && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 1][c + 2] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, 'G', anticipatedSize);
//                        
//                        mainBoard[r][c] = tempCliff[0];
//                        mainBoard[r + 1][c] = tempCliff[1];
//                        mainBoard[r][c + 1] = tempCliff[2];
//                        mainBoard[r + 1][c + 1] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r - 1][c + 1] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 2][c] == 9997
//                            && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 2][c - 1] == 9997
//                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r][c + 2] == 54340 && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, 'V', anticipatedSize);
//                        
//                        mainBoard[r][c] = tempCliff[0];
//                        mainBoard[r + 1][c] = tempCliff[1];
//                        mainBoard[r][c + 1] = tempCliff[2];
//                        mainBoard[r + 1][c + 1] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r - 2][c] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r + 1][c + 1] == 9997
//                            && mainBoard[r - 2][c - 1] == 9997 && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997
//                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 && mainBoard[r + 1][c + 2] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, 'X', anticipatedSize);
//                        
//                        mainBoard[r - 1][c] = tempCliff[0];
//                        mainBoard[r][c] = tempCliff[1];
//                        mainBoard[r - 1][c + 1] = tempCliff[2];
//                        mainBoard[r][c + 1] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r - 1][c - 1] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r][c + 1] == 9997 && mainBoard[r][c + 2] == 9997
//                            && mainBoard[r][c - 1] == 9997 && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 1][c + 1] == 9997 && mainBoard[r + 1][c + 2] == 9997
//                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r - 1][c + 2] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, 'A', anticipatedSize);
//                        
//                        mainBoard[r - 1][c] = tempCliff[0];
//                        mainBoard[r][c] = tempCliff[1];
//                        mainBoard[r - 1][c + 1] = tempCliff[2];
//                        mainBoard[r][c + 1] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                try{
//                    if(mainBoard[r][c] == 9997 
//                            && mainBoard[r][c - 2] == 9997 && mainBoard[r][c - 1] == 9997 && mainBoard[r - 1][c] == 9997 && mainBoard[r - 1][c + 1] == 9997
//                            && mainBoard[r + 1][c - 2] == 9997 && mainBoard[r + 1][c - 1] == 9997 && mainBoard[r + 1][c] == 9997 && mainBoard[r + 1][c + 1] == 9997 && mainBoard[r + 1][c] == 9997
//                            && mainBoard[r - 1][c - 2] == 54340 && mainBoard[r - 1][c - 1] == 54340 && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 2][c + 1] == 54340 ){
//                        anticipatedSize[0] = 2;
//                        anticipatedSize[1] = 2;
//                        tempCliff = getBlockData("BLOXBGBS", 4, 'Q', anticipatedSize);
//                        
//                        mainBoard[r - 1][c - 1] = tempCliff[0];
//                        mainBoard[r][c - 1] = tempCliff[1];
//                        mainBoard[r - 1][c] = tempCliff[2];
//                        mainBoard[r][c] = tempCliff[3];
//                        
//                    }
//                    
//                }catch(IndexOutOfBoundsException e){
//                    
//                }
//                
//            }
//        }
        
        //placing corners, straight edges, and now inner corners
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r - 1][c] == 54340 && mainBoard[r][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, '1', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c] == 54340 && mainBoard[r + 1][c - 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, '5', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r + 1][c] == 54340 && mainBoard[r][c + 1] == 54340 && mainBoard[r + 1][c + 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'B', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r - 1][c] == 54340 && mainBoard[r][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'Z', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r][c - 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, '3', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r + 1][c] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'D', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r][c + 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'C', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r - 1][c] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'E', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }

                
                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r][c + 1] != 54340 && mainBoard[r + 1][c] != 54340 && mainBoard[r + 1][c + 1] == 54340){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'W', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r - 1][c] != 54340 && mainBoard[r][c + 1] != 54340 && mainBoard[r - 1][c + 1] == 54340){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'R', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r - 1][c] != 54340 && mainBoard[r][c - 1] != 54340 && mainBoard[r - 1][c - 1] == 54340){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'F', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 9998 && mainBoard[r][c - 1] != 54340 && mainBoard[r + 1][c] != 54340 && mainBoard[r + 1][c - 1] == 54340){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 4, 'S', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];

                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }   
        
//        for(int c = 0; c != boardC; c++){
//            for(int r = 0; r != boardR; r++){
//                if(mainBoard[r][c] == 9997){
//                    mainBoard[r][c] = 54341;
//                    
//                }
//            }
//        }
        
        return mainBoard;
    }
    
    public static int[][] addDiagonalsB(int[][] mainBoard, int boardR, int boardC, String tileset, int infantryClimbsToAdd) throws IOException{
        int[] tempCliff = new int[6];
	int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int rando = 0;
        int infCount = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        
        if(tileset.matches("BLOXICE")){
            infantryClimbsToAdd = (int)Math.ceil(infantryClimbsToAdd / 2);
            
        }else if(tileset.matches("BLOXTREE")){
            infantryClimbsToAdd = (int)Math.ceil(infantryClimbsToAdd / 2);
            
        }else if(tileset.matches("BLOXWAST")){
            infantryClimbsToAdd = (int)Math.ceil(infantryClimbsToAdd / 3);
            
        }
        
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            try{
                if(mainBoard[randR][randC] == 54341 
                        && mainBoard[randR + 1][randC] == 54340 && mainBoard[randR + 2][randC] == 54340 
                        && mainBoard[randR + 3][randC] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 
                        && mainBoard[randR + 2][randC + 1] == 54340 && mainBoard[randR + 3][randC + 1] == 54340 

                        && mainBoard[randR + 1][randC - 1] == 54341 && mainBoard[randR][randC - 1] == 54341 
                        && mainBoard[randR][randC] == 54341 && mainBoard[randR][randC + 1] == 54341 

                        ||mainBoard[randR][randC] == 54341 
                        && mainBoard[randR + 1][randC] == 54341 && mainBoard[randR + 2][randC] == 54340 
                        && mainBoard[randR + 3][randC] == 54340 && mainBoard[randR + 1][randC + 1] == 54340 
                        && mainBoard[randR + 2][randC + 1] == 54340 && mainBoard[randR + 3][randC + 1] == 54340 

                        && mainBoard[randR + 1][randC - 1] == 54341 && mainBoard[randR][randC - 1] == 54341 
                        && mainBoard[randR][randC] == 54341 && mainBoard[randR][randC + 1] == 54341 ){
                    anticipatedSize[0] = 3;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 1, 'G', anticipatedSize);

                    rando = rand.nextInt((1000 - 0) + 1) + 0;

                    if(rando >= 0 && rando <= 1000 && tileset.matches("BLOXICE")){
                        tempCliff = getBlockDataSpecial("BLOXICE", 7, 'F', anticipatedSize);
                        infCount++;

                    }else if(rando >= 0 && rando <= 1000 && tileset.matches("BLOXTREE")){
                        tempCliff = getBlockData("BLOXTREE", 7, 'F', anticipatedSize);
                        infCount++;

                    }else if(rando >= 0 && rando <= 1000 && tileset.matches("BLOXWAST")){
                        tempCliff = getBlockData("BLOXWAST", 7, 'G', anticipatedSize);
                        infCount++;

                    }

                    mainBoard[randR + 1][randC] = tempCliff[0];
                    mainBoard[randR + 2][randC] = tempCliff[1];
                    mainBoard[randR + 3][randC] = tempCliff[2];
                    mainBoard[randR + 1][randC + 1] = tempCliff[3];
                    mainBoard[randR + 2][randC + 1] = tempCliff[4];
                    mainBoard[randR + 3][randC + 1] = tempCliff[5];

                }
            }catch(IndexOutOfBoundsException e){

            }
            
            if(attempts >= attemptsLimit){
                infCount = 999999999;
                infantryClimbsToAdd = 0;
                
            }
            
        }while(infCount < infantryClimbsToAdd);
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r][c - 3] == 54340 && mainBoard[r + 1][c - 3] == 54340 
                            && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c - 1] == 54340 
                            
                            && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r + 1][c] == 54341 
                            
                            ||mainBoard[r][c] == 54341 
                            && mainBoard[r][c - 3] == 54340 && mainBoard[r + 1][c - 3] == 54340 
                            && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c - 1] == 54340 
                            
                            && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r + 1][c] == 54341 ){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 3;
                        tempCliff = getBlockData("BLOXBGBS", 1, '4', anticipatedSize);
                        
                        mainBoard[r][c - 3] = tempCliff[0];
                        mainBoard[r + 1][c - 3] = tempCliff[1];
                        mainBoard[r][c - 2] = tempCliff[2];
                        mainBoard[r + 1][c - 2] = tempCliff[3];
                        mainBoard[r][c - 1] = tempCliff[4];
                        mainBoard[r + 1][c - 1] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            && mainBoard[r + 3][c] == 54340 && mainBoard[r + 1][c + 1] == 54340 
                            && mainBoard[r + 2][c + 1] == 54340 && mainBoard[r + 3][c + 1] == 54340 
                            
                            && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54341 
                            
                            ||mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54340 
                            && mainBoard[r + 3][c] == 54340 && mainBoard[r + 1][c + 1] == 54340 
                            && mainBoard[r + 2][c + 1] == 54340 && mainBoard[r + 3][c + 1] == 54340 
                            
                            && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54341 ){
                        anticipatedSize[0] = 3;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'G', anticipatedSize);
                        
//                        rando = rand.nextInt((1000 - 0) + 1) + 0;
//                        
//                        if(rando >= 0 && rando <= 300 && tileset.matches("BLOXICE") && infCount < infantryClimbsToAdd){
//                            tempCliff = getBlockDataSpecial("BLOXICE", 7, 'F', anticipatedSize);
//                            infCount++;
//                            
//                        }else if(rando >= 0 && rando <= 300 && tileset.matches("BLOXTREE") && infCount < infantryClimbsToAdd){
//                            tempCliff = getBlockData("BLOXTREE", 7, 'F', anticipatedSize);
//                            infCount++;
//                            
//                        }else if(rando >= 0 && rando <= 300 && tileset.matches("BLOXWAST") && infCount < infantryClimbsToAdd){
//                            tempCliff = getBlockData("BLOXWAST", 7, 'G', anticipatedSize);
//                            infCount++;
//                            
//                        }
                        
                        mainBoard[r + 1][c] = tempCliff[0];
                        mainBoard[r + 2][c] = tempCliff[1];
                        mainBoard[r + 3][c] = tempCliff[2];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        mainBoard[r + 2][c + 1] = tempCliff[4];
                        mainBoard[r + 3][c + 1] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r][c + 1] == 54340 
                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r][c + 2] == 54340 
                            && mainBoard[r - 1][c + 3] == 54340 && mainBoard[r][c + 3] == 54340 
                            
                            && mainBoard[r + 1][c + 1] == 54341 && mainBoard[r + 1][c] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            
                            || mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r][c + 1] == 54341 
                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r][c + 2] == 54340 
                            && mainBoard[r - 1][c + 3] == 54340 && mainBoard[r][c + 3] == 54340 
                            
                            && mainBoard[r + 1][c + 1] == 54341 && mainBoard[r + 1][c] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r - 1][c] == 54341 ){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 3;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'X', anticipatedSize);
                        
                        mainBoard[r - 1][c + 1] = tempCliff[0];
                        mainBoard[r][c + 1] = tempCliff[1];
                        mainBoard[r - 1][c + 2] = tempCliff[2];
                        mainBoard[r][c + 2] = tempCliff[3];
                        mainBoard[r - 1][c + 3] = tempCliff[4];
                        mainBoard[r][c + 3] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 3][c - 1] == 54340 && mainBoard[r - 2][c - 1] == 54340 
                            && mainBoard[r - 1][c - 1] == 54340 && mainBoard[r - 3][c] == 54340 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            
                            && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54341 
                            && mainBoard[r - 1][c + 1] == 54341 
                            
                            || mainBoard[r][c] == 54341 
                            && mainBoard[r - 3][c - 1] == 54340 && mainBoard[r - 2][c - 1] == 54340 
                            && mainBoard[r - 1][c - 1] == 54340 && mainBoard[r - 3][c] == 54340 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54341 
                            
                            && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54341 
                            && mainBoard[r - 1][c + 1] == 54341 ){
                        anticipatedSize[0] = 3;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'Q', anticipatedSize);
                        
                        mainBoard[r - 3][c - 1] = tempCliff[0];
                        mainBoard[r - 2][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c - 1] = tempCliff[2];
                        mainBoard[r - 3][c] = tempCliff[3];
                        mainBoard[r - 2][c] = tempCliff[4];
                        mainBoard[r - 1][c] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addSmallCliffs(int[][] mainBoard, int boardR, int boardC) throws IOException{
        int[] tempCliff = new int[2];
        int[] tempCliff2 = new int[4];
        int[] anticipatedSize = new int[2];
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r][c - 2] == 54340 && mainBoard[r][c - 1] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, '3', anticipatedSize);
                        
                        mainBoard[r][c - 2] = tempCliff[0];
                        mainBoard[r][c - 1] = tempCliff[1];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 ){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
                        
                        mainBoard[r + 1][c] = tempCliff[0];
                        mainBoard[r + 2][c] = tempCliff[1];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 ){
                        anticipatedSize[0] = 1;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'C', anticipatedSize);
                        
                        mainBoard[r][c + 1] = tempCliff[0];
                        mainBoard[r][c + 2] = tempCliff[1];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 ){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'E', anticipatedSize);
                        
                        mainBoard[r - 2][c] = tempCliff[0];
                        mainBoard[r - 1][c] = tempCliff[1];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 1;
        tempCliff = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == tempCliff[0] && mainBoard[r + 1][c] == tempCliff[1] 
                            && mainBoard[r][c + 1] == tempCliff[0] && mainBoard[r + 1][c + 1] == tempCliff[1]){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff2 = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff2[0];
                        mainBoard[r + 1][c] = tempCliff2[1];
                        mainBoard[r][c + 1] = tempCliff2[2];
                        mainBoard[r + 1][c + 1] = tempCliff2[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
     public static int[][] addEntrances(int[][] mainBoard, int boardR, int boardC, int entranceSizeOrig) throws IOException{
        int[] tempCliff = new int[4];
        int[] tempCliff2 = new int[2];
	int[] anticipatedSize = new int[2];
        Random rand = new Random();//0 - up, 1 - right, 2 - down, 3 - left, corner directios too
        int direction = 0;
        int maxDirections = 3;
        int min = 0;
        int counter = 0;
        boolean foundSpot = false;
        int amountNeeded = 0;
        boolean[] directionsUsed = new boolean[4];
        boolean allDirectionsUsed = true;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        int extraLimit = 20;
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int entranceSize;
        int entMax = 3;
        int entMin = -1;
       
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 54349){
                    directionsUsed[0] = false;
                    directionsUsed[1] = false;
                    directionsUsed[2] = false;
                    directionsUsed[3] = false;
                    amountNeeded = rand.nextInt((3 - 1) + 1) + 1;
                    //entranceSize = entranceSizeOrig + (rand.nextInt((3 - (-2)) + 1) + (-2));
                    
                    do{
                        direction = rand.nextInt((maxDirections - min) + 1) + min;//0 - up, 1 - right, 2 - down, 3 - left
                        directionsUsed[direction] = true;
                        foundSpot = false;
                        
                        allDirectionsUsed = true;
                        counter = 0;
                        entranceSize = entranceSizeOrig + (rand.nextInt((entMax - entMin) + 1) + entMin);

                        if(direction == 0){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r][c - counter] == 54341 && mainBoard[r][c - (counter + 1)] == 54340 
                                            && roomForEntrances(mainBoard, boardR, boardC, (r), (c - (counter + 1)), entranceSize) == true){
                                        foundSpot = true;

                                        for(int ic = -entranceSize; ic != (entranceSize + 1); ic++){
                                            for(int ir = -entranceSize; ir != (entranceSize + 1); ir++){
                                                if(mainBoard[(r) + ir][(c - counter) + ic] == 54341 ){
                                                    if(mainBoard[((r) + ir)][((c - counter) + ic) - 1] == 54340 
                                                            || mainBoard[((r) + ir) + 1][((c - counter) + ic)] == 54340 
                                                            || mainBoard[((r) + ir)][((c - counter) + ic) + 1] == 54340 
                                                            || mainBoard[((r) + ir) - 1][((c - counter) + ic)] == 54340 

                                                            || mainBoard[((r) + ir) - 1][((c - counter) + ic) - 1] == 54340 
                                                            || mainBoard[((r) + ir) + 1][((c - counter) + ic) + 1] == 54340 
                                                            || mainBoard[((r) + ir) - 1][((c - counter) + ic) + 1] == 54340 
                                                            || mainBoard[((r) + ir) + 1][((c - counter) + ic) - 1] == 54340 ){
                                                        try{
                                                            mainBoard[(r) + ir][(c - counter) + ic] = 543438;//9997;//38;
                                                            
                                                        }catch(IndexOutOfBoundsException e){
                                                            
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if(mainBoard[r][c - counter] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                    
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }

                            }while(foundSpot == false);

                        }else if(direction == 1){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r + counter][c] == 54341 && mainBoard[r + (counter + 1)][c] == 54340 
                                            && roomForEntrances(mainBoard, boardR, boardC, (r + (counter + 1)), (c), entranceSize) == true){
                                        foundSpot = true;

                                        for(int ic = -entranceSize; ic != (entranceSize + 1); ic++){
                                            for(int ir = -entranceSize; ir != (entranceSize + 1); ir++){
                                                if(mainBoard[(r + counter) + ir][(c) + ic] == 54341 ){
                                                    if(mainBoard[((r + counter) + ir)][((c) + ic) - 1] == 54340 
                                                            || mainBoard[((r + counter) + ir) + 1][((c) + ic)] == 54340 
                                                            || mainBoard[((r + counter) + ir)][((c) + ic) + 1] == 54340 
                                                            || mainBoard[((r + counter) + ir) - 1][((c) + ic)] == 54340 

                                                            || mainBoard[((r + counter) + ir) - 1][((c) + ic) - 1] == 54340 
                                                            || mainBoard[((r + counter) + ir) + 1][((c) + ic) + 1] == 54340 
                                                            || mainBoard[((r + counter) + ir) - 1][((c) + ic) + 1] == 54340 
                                                            || mainBoard[((r + counter) + ir) + 1][((c) + ic) - 1] == 54340 ){
                                                        try{
                                                            mainBoard[(r + counter) + ir][(c) + ic] = 543438;//9997;//38;
                                                            
                                                        }catch(IndexOutOfBoundsException e){
                                                            
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if(mainBoard[r + counter][c] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                    
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }

                            }while(foundSpot == false);

                        }else if(direction == 2){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r][c + counter] == 54341 && mainBoard[r][c + (counter + 1)] == 54340 
                                            && roomForEntrances(mainBoard, boardR, boardC, (r), (c + (counter + 1)), entranceSize) == true){
                                        foundSpot = true;

                                        for(int ic = -entranceSize; ic != (entranceSize + 1); ic++){
                                            for(int ir = -entranceSize; ir != (entranceSize + 1); ir++){
                                                if(mainBoard[(r) + ir][(c + counter) + ic] == 54341 ){
                                                    if(mainBoard[((r) + ir)][((c + counter) + ic) - 1] == 54340 
                                                            || mainBoard[((r) + ir) + 1][((c + counter) + ic)] == 54340 
                                                            || mainBoard[((r) + ir)][((c + counter) + ic) + 1] == 54340 
                                                            || mainBoard[((r) + ir) - 1][((c + counter) + ic)] == 54340 

                                                            || mainBoard[((r) + ir) - 1][((c + counter) + ic) - 1] == 54340 
                                                            || mainBoard[((r) + ir) + 1][((c + counter) + ic) + 1] == 54340 
                                                            || mainBoard[((r) + ir) - 1][((c + counter) + ic) + 1] == 54340 
                                                            || mainBoard[((r) + ir) + 1][((c + counter) + ic) - 1] == 54340 ){
                                                        try{
                                                            mainBoard[(r) + ir][(c + counter) + ic] = 543438;//9997;//38;
                                                            
                                                        }catch(IndexOutOfBoundsException e){
                                                            
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if(mainBoard[r][c + counter] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                    
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }

                            }while(foundSpot == false);

                        }else if(direction == 3){
                            do{
                                counter++;
                                try{
                                    if(mainBoard[r - counter][c] == 54341 && mainBoard[r - (counter + 1)][c] == 54340 
                                            && roomForEntrances(mainBoard, boardR, boardC, (r - (counter + 1)), (c), entranceSize) == true){
                                        foundSpot = true;

                                        for(int ic = -entranceSize; ic != (entranceSize + 1); ic++){
                                            for(int ir = -entranceSize; ir != (entranceSize + 1); ir++){
                                                if(mainBoard[(r - counter) + ir][(c) + ic] == 54341 ){
                                                    if(mainBoard[((r - counter) + ir)][((c) + ic) - 1] == 54340 
                                                            || mainBoard[((r - counter) + ir) + 1][((c) + ic)] == 54340 
                                                            || mainBoard[((r - counter) + ir)][((c) + ic) + 1] == 54340 
                                                            || mainBoard[((r - counter) + ir) - 1][((c) + ic)] == 54340 

                                                            || mainBoard[((r - counter) + ir) - 1][((c) + ic) - 1] == 54340 
                                                            || mainBoard[((r - counter) + ir) + 1][((c) + ic) + 1] == 54340 
                                                            || mainBoard[((r - counter) + ir) - 1][((c) + ic) + 1] == 54340 
                                                            || mainBoard[((r - counter) + ir) + 1][((c) + ic) - 1] == 54340 ){
                                                        try{
                                                            mainBoard[(r - counter) + ir][(c) + ic] = 543438;//9997;//38;
                                                            
                                                        }catch(IndexOutOfBoundsException e){
                                                            
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if(mainBoard[r - counter][c] == 54340 ){// stop, no entrance
                                        foundSpot = true;//and ignore
                                        
                                    }
                                    
                                }catch(IndexOutOfBoundsException e){
                                    foundSpot = true;//and ignore

                                }

                            }while(foundSpot == false);

                        }
                        
//                        for(int i = 0; i != 4; i++){
//                            if(directionsUsed[i] == true){
//                                
//                            }else if(directionsUsed[i] == false){
//                                allDirectionsUsed = false;
//                                
//                            }
//                        }
                        if(amountNeeded == 1){
                            if(directionsUsed[0] == true && directionsUsed[1] == true
                                    || directionsUsed[0] == true && directionsUsed[2] == true
                                    || directionsUsed[0] == true && directionsUsed[3] == true
                                    || directionsUsed[1] == true && directionsUsed[0] == true
                                    || directionsUsed[1] == true && directionsUsed[2] == true
                                    || directionsUsed[1] == true && directionsUsed[3] == true
                                    || directionsUsed[2] == true && directionsUsed[0] == true
                                    || directionsUsed[2] == true && directionsUsed[1] == true
                                    || directionsUsed[2] == true && directionsUsed[3] == true
                                    || directionsUsed[3] == true && directionsUsed[0] == true
                                    || directionsUsed[3] == true && directionsUsed[1] == true
                                    || directionsUsed[3] == true && directionsUsed[2] == true){

                            }else{
                                allDirectionsUsed = false;

                            }
                        }else if(amountNeeded == 2){
                            if(directionsUsed[0] == true && directionsUsed[1] == true && directionsUsed[2] == true
                                    || directionsUsed[1] == true && directionsUsed[2] == true && directionsUsed[3] == true
                                    || directionsUsed[2] == true && directionsUsed[3] == true && directionsUsed[1] == true
                                    || directionsUsed[3] == true && directionsUsed[0] == true && directionsUsed[1] == true){

                            }else{
                                allDirectionsUsed = false;

                            }
                        }else if(amountNeeded == 3){
                            if(directionsUsed[0] == true && directionsUsed[1] == true && directionsUsed[2] == true && directionsUsed[3] == true){

                            }else{
                                allDirectionsUsed = false;

                            }
                        }
                    }while(allDirectionsUsed == false);
                }
            }
        }
     
        //adding extra entrances
//        attempts = 0;
//        counter = 0;
//        entranceSize = 2;
//        do{
//            randR = rand.nextInt((maxR - min) + 1) + min;
//            randC = rand.nextInt((maxC - min) + 1) + min;
//            attempts++;
//            
//            if(mainBoard[randR][randC] == 54341){
//                try{
//                    if(mainBoard[randR][randC - 1] == 54340 
//                            || mainBoard[randR + 1][randC] == 54340 
//                            || mainBoard[randR][randC + 1] == 54340 
//                            || mainBoard[randR - 1][randC] == 54340 
//
//                            || mainBoard[randR - 1][randC - 1] == 54340 
//                            || mainBoard[randR + 1][randC + 1] == 54340 
//                            || mainBoard[randR - 1][randC + 1] == 54340 
//                            || mainBoard[randR + 1][randC - 1] == 54340 ){
//                        counter++;
//
//                        for(int ic = -entranceSize; ic != (entranceSize + 1); ic++){
//                            for(int ir = -entranceSize; ir != (entranceSize + 1); ir++){
//                                if(mainBoard[randR + ir][randC - 1 + ic] == 54340 
//                                        || mainBoard[randR + 1 + ir][randC + ic] == 54340 
//                                        || mainBoard[randR + ir][randC + 1 + ic] == 54340 
//                                        || mainBoard[randR - 1 + ir][randC + ic] == 54340 
//
//                                        || mainBoard[randR - 1 + ir][randC - 1 + ic] == 54340 
//                                        || mainBoard[randR + 1 + ir][randC + 1 + ic] == 54340 
//                                        || mainBoard[randR - 1 + ir][randC + 1 + ic] == 54340 
//                                        || mainBoard[randR + 1 + ir][randC - 1 + ic] == 54340 ){
//                                    try{
//                                        mainBoard[randR + ir][randC + ic] = 543438;
//                                        System.out.println("r " + (randR + ir) + " c " + (randC + ic));
//
//                                    }catch(IndexOutOfBoundsException e){
//
//                                    }
//
//                                }
//                            }
//                        }
//                    }
//                }catch(IndexOutOfBoundsException e){
//
//                }
//            }
//            
//            if(attempts >= attemptsLimit){
//                counter = 999999999;
//                extraLimit = 0;
//
//            }
//        }while(counter < extraLimit);
        
        //removing and tiles surpunded by rock
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 1] == 543438 && mainBoard[r + 1][c] == 54341 && mainBoard[r][c + 1] == 54341 && mainBoard[r - 1][c] == 54341 ){
                        mainBoard[r][c] = 54341;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c] == 543438 && mainBoard[r][c + 1] == 54341 && mainBoard[r - 1][c] == 54341 ){
                        mainBoard[r][c] = 54341;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c] == 54341 && mainBoard[r][c + 1] == 543438 && mainBoard[r - 1][c] == 54341 ){
                        mainBoard[r][c] = 54341;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r + 1][c] == 54341 && mainBoard[r][c + 1] == 54341 && mainBoard[r - 1][c] == 543438){
                        mainBoard[r][c] = 54341;
                        
                    }
                    
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r][c + 1] == 543438 && mainBoard[r][c + 2] != 543438 && mainBoard[r - 1][c + 1] != 543438){
//                        for(int ic = -4; ic != 5; ic++){//4534234
//                            for(int ir = -4; ir != 5; ir++){
//                                if(isAnEntranceEdge(mainBoard[r + ir][c + ic]) == true){
//                                    System.out.println("isAnEntranceEdge " + r + " " + c + " ");
//                                    
//                                }
//                                
//                            }
//                        }

                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, '9', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[3];
                        mainBoard[r][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c - 1] = tempCliff[0];
                        mainBoard[r - 1][c] = tempCliff[2];
                        
                        try{
                        mainBoard[r - 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r - 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r - 1][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r][c + 1] == 543438 && mainBoard[r][c + 2] != 543438 && mainBoard[r + 1][c + 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, '6', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[2];
                        mainBoard[r][c - 1] = tempCliff[0];
                        mainBoard[r + 1][c - 1] = tempCliff[1];
                        mainBoard[r + 1][c] = tempCliff[3];
                        
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r + 1][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r - 1][c] == 543438 && mainBoard[r - 2][c] != 543438 && mainBoard[r - 1][c - 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'L', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[2];
                        mainBoard[r][c - 1] = tempCliff[0];
                        mainBoard[r + 1][c - 1] = tempCliff[1];
                        mainBoard[r + 1][c] = tempCliff[3];
                        
                        try{
                        mainBoard[r + 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r - 2][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r - 1][c] == 543438 && mainBoard[r - 2][c] != 543438 && mainBoard[r - 1][c + 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 1;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'O', anticipatedSize);
                        tempCliff2 = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        mainBoard[r + 1][c] = tempCliff[1];
                        mainBoard[r + 1][c + 1] = tempCliff2[1];
                        mainBoard[r][c + 1] = tempCliff2[0];
                        
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r - 2][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r][c - 1] == 543438 && mainBoard[r][c - 2] != 543438 && mainBoard[r - 1][c - 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, '>', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[1];
                        mainBoard[r - 1][c] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[2];
                        mainBoard[r][c + 1] = tempCliff[3];
                        
                        try{
                        mainBoard[r - 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r - 1][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r][c - 1] == 543438 && mainBoard[r][c - 2] != 543438 && mainBoard[r + 1][c - 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'N', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[0];
                        mainBoard[r + 1][c] = tempCliff[1];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        mainBoard[r][c + 1] = tempCliff[2];
                        
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r + 1][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r + 1][c] == 543438 && mainBoard[r + 2][c] != 543438 && mainBoard[r + 1][c - 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'H', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[3];
                        mainBoard[r][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c - 1] = tempCliff[0];
                        mainBoard[r - 1][c] = tempCliff[2];
                        
                        try{
                        mainBoard[r - 3][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c - 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c - 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r + 1][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c - 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                try{
                    if(mainBoard[r][c] == 54340 && mainBoard[r + 1][c] == 543438 && mainBoard[r + 2][c] != 543438 && mainBoard[r + 1][c + 1] != 543438){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'Y', anticipatedSize);
                        
                        mainBoard[r][c] = tempCliff[1];
                        mainBoard[r][c + 1] = tempCliff[3];
                        mainBoard[r - 1][c + 1] = tempCliff[2];
                        mainBoard[r - 1][c] = tempCliff[0];
                        
                        try{
                        mainBoard[r - 3][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 3] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 1][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r][c + 2] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 3][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r - 2][c + 1] = 54340;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        
                        try{
                        mainBoard[r + 1][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 1] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 1][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        } 
                        try{
                        mainBoard[r + 2][c + 2] = 54341;
                        }catch(IndexOutOfBoundsException e){
                             
                        }       
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        //remove any loan entrance ends
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543438 
                            && mainBoard[r][c - 1] != 543438 && mainBoard[r + 1][c] != 543438 && mainBoard[r][c + 1] != 543438 && mainBoard[r - 1][c] != 543438
                            && mainBoard[r - 1][c - 1] != 543438 && mainBoard[r + 1][c - 1] != 543438 && mainBoard[r + 1][c + 1] != 543438 && mainBoard[r - 1][c + 1] != 543438){
                        for(int ic = -2; ic != 3; ic++){
                            for(int ir = -2; ir != 3; ir++){
                                try{
                                    mainBoard[r + ir][c + ic] = 54341;

                                }catch(IndexOutOfBoundsException e){

                                }
                            }
                        }
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
//        counter = 0;
//        do{
//            randR = rand.nextInt((maxR - min) + 1) + min;
//            randC = rand.nextInt((maxC - min) + 1) + min;
//            
//            try{
//                if(mainBoard[randR - 1][randC] == 543438 && mainBoard[randR][randC] == 543438 && mainBoard[randR + 1][randC] == 543438
//                        || mainBoard[randR][randC - 1] == 543438 && mainBoard[randR][randC] == 543438 && mainBoard[randR][randC + 1] == 543438){
//                    choice = rand.nextInt((1 - 0) + 1) + 0;
//                    counter++;
//                    System.out.println("randR " + randR + " " + randC);
//
//                    if(choice == 0){
//                        
//
//                    }else{
//
//                    }
//                }
//            }catch(IndexOutOfBoundsException e){
//
//            }
//            
//        }while(counter < 10);
        
        return mainBoard;
    }
    
     public static int[][] addDiagonalsA(int[][] mainBoard, int boardR, int boardC, String tileset, int infantryClimbsToAdd) throws IOException{
        int[] tempCliff = new int[6];
	int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int rando = 0;
        int infCount = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        
        if(tileset.matches("BLOXWAST")){
            infantryClimbsToAdd = (int)Math.ceil(infantryClimbsToAdd / 3);
            
        }
        
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            try{ 
                if(mainBoard[randR][randC] == 54341 
                        && mainBoard[randR - 3][randC - 1] == 54340 && mainBoard[randR - 2][randC - 1] == 54340 
                        && mainBoard[randR - 1][randC - 1] == 54340 && mainBoard[randR - 3][randC] == 54340 
                        && mainBoard[randR - 2][randC] == 54340 && mainBoard[randR - 1][randC] == 54340 

                        && mainBoard[randR - 1][randC - 2] == 54341 && mainBoard[randR][randC - 2] == 54341 
                        && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR][randC] == 54341 

                        ||mainBoard[randR][randC] == 54341 
                        && mainBoard[randR - 3][randC - 1] == 54340 && mainBoard[randR - 2][randC - 1] == 54340 
                        && mainBoard[randR - 1][randC - 1] == 54341 && mainBoard[randR - 3][randC] == 54340 
                        && mainBoard[randR - 2][randC] == 54340 && mainBoard[randR - 1][randC] == 54340 

                        && mainBoard[randR - 1][randC - 2] == 54341 && mainBoard[randR][randC - 2] == 54341 
                        && mainBoard[randR][randC - 1] == 54341 && mainBoard[randR][randC] == 54341 ){
                    anticipatedSize[0] = 3;
                    anticipatedSize[1] = 2;
                    tempCliff = getBlockData("BLOXBGBS", 1, 'A', anticipatedSize);

                    rando = rand.nextInt((1000 - 0) + 1) + 0;

                    if(rando >= 0 && rando <= 1000 && tileset.matches("BLOXWAST")){
                        tempCliff = getBlockDataSpecial("BLOXWAST", 7, 'H', anticipatedSize);
                        infCount++;

                    }

                    mainBoard[randR - 3][randC - 1] = tempCliff[0];
                    mainBoard[randR - 2][randC - 1] = tempCliff[1];
                    mainBoard[randR - 1][randC - 1] = tempCliff[2];
                    mainBoard[randR - 3][randC] = tempCliff[3];
                    mainBoard[randR - 2][randC] = tempCliff[4];
                    mainBoard[randR - 1][randC] = tempCliff[5];

                }
            }catch(IndexOutOfBoundsException e){

            }
            
            if(attempts >= attemptsLimit){
                infCount = 999999999;
                infantryClimbsToAdd = 0;
                
            }
            
        }while(infCount < infantryClimbsToAdd);

        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r][c - 3] == 54340 && mainBoard[r + 1][c - 3] == 54340 
                            && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c - 1] == 54340 
                            
                            && mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 
                            && mainBoard[r + 2][c - 1] == 54341 
                            
                            || mainBoard[r][c] == 54341 
                            && mainBoard[r][c - 3] == 54340 && mainBoard[r + 1][c - 3] == 54340 
                            && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c - 1] == 54341 
                            
                            && mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 
                            && mainBoard[r + 2][c - 1] == 54341 ){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 3;
                        tempCliff = getBlockData("BLOXBGBS", 1, '2', anticipatedSize);
        
                        mainBoard[r][c - 3] = tempCliff[0];
                        mainBoard[r + 1][c - 3] = tempCliff[1];
                        mainBoard[r][c - 2] = tempCliff[2];
                        mainBoard[r + 1][c - 2] = tempCliff[3];
                        mainBoard[r][c - 1] = tempCliff[4];
                        mainBoard[r + 1][c - 1] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            && mainBoard[r + 3][c] == 54340 && mainBoard[r + 1][c + 1] == 54340 
                            && mainBoard[r + 2][c + 1] == 54340 && mainBoard[r + 3][c + 1] == 54340 
                            
                            && mainBoard[r][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 
                            && mainBoard[r + 1][c + 2] == 54341 
                            
                            || mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            && mainBoard[r + 3][c] == 54340 && mainBoard[r + 1][c + 1] == 54341 
                            && mainBoard[r + 2][c + 1] == 54340 && mainBoard[r + 3][c + 1] == 54340 
                            
                            && mainBoard[r][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 
                            && mainBoard[r + 1][c + 2] == 54341 ){
                        anticipatedSize[0] = 3;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'T', anticipatedSize);
                        
                        mainBoard[r + 1][c] = tempCliff[0];
                        mainBoard[r + 2][c] = tempCliff[1];
                        mainBoard[r + 3][c] = tempCliff[2];
                        mainBoard[r + 1][c + 1] = tempCliff[3];
                        mainBoard[r + 2][c + 1] = tempCliff[4];
                        mainBoard[r + 3][c + 1] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 
                            && mainBoard[r][c + 3] == 54340 && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r - 1][c + 3] == 54340 
                            
                            && mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c] == 54341 && mainBoard[r - 2][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54341 
                            
                            || mainBoard[r][c] == 54341 
                            && mainBoard[r][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 
                            && mainBoard[r][c + 3] == 54340 && mainBoard[r - 1][c + 1] == 54341 
                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r - 1][c + 3] == 54340 
                            
                            && mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c] == 54341 && mainBoard[r - 2][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54341 ){
                        anticipatedSize[0] = 2;
                        anticipatedSize[1] = 3;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'V', anticipatedSize);
                        
                        mainBoard[r][c + 1] = tempCliff[1];
                        mainBoard[r][c + 2] = tempCliff[3];
                        mainBoard[r][c + 3] = tempCliff[5];
                        mainBoard[r - 1][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 3] = tempCliff[4];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{ //different?
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 3][c - 1] == 54340 && mainBoard[r - 2][c - 1] == 54340 
                            && mainBoard[r - 1][c - 1] == 54340 && mainBoard[r - 3][c] == 54340 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            
                            && mainBoard[r - 1][c - 2] == 54341 && mainBoard[r][c - 2] == 54341 
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r][c] == 54341 
                            
                            ||mainBoard[r][c] == 54341 
                            && mainBoard[r - 3][c - 1] == 54340 && mainBoard[r - 2][c - 1] == 54340 
                            && mainBoard[r - 1][c - 1] == 54341 && mainBoard[r - 3][c] == 54340 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            
                            && mainBoard[r - 1][c - 2] == 54341 && mainBoard[r][c - 2] == 54341 
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r][c] == 54341 ){
                        anticipatedSize[0] = 3;
                        anticipatedSize[1] = 2;
                        tempCliff = getBlockData("BLOXBGBS", 1, 'A', anticipatedSize);
                        
//                        rando = rand.nextInt((1000 - 0) + 1) + 0;
//                        
//                        if(rando >= 0 && rando <= 300 && tileset.matches("BLOXWAST") && infCount < infantryClimbsToAdd){
//                            tempCliff = getBlockDataSpecial("BLOXWAST", 7, 'H', anticipatedSize);
//                            infCount++;
//                            
//                        }
                        
                        mainBoard[r - 3][c - 1] = tempCliff[0];
                        mainBoard[r - 2][c - 1] = tempCliff[1];
                        mainBoard[r - 1][c - 1] = tempCliff[2];
                        mainBoard[r - 3][c] = tempCliff[3];
                        mainBoard[r - 2][c] = tempCliff[4];
                        mainBoard[r - 1][c] = tempCliff[5];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addWorms(int[][] mainBoard, int boardR, int boardC, int numberOfWorms){
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int counter = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        
        attempts = 0;
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
        
            if(mainBoard[randR][randC] == 54340 ){
                mainBoard[randR][randC] = 54342;
                counter++;
                
            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                numberOfWorms = 0;

            }
            
        }while(counter < numberOfWorms);
        
        return mainBoard;
    }
    
    public static boolean roomForSandCliffs(int[][] mainBoard, int boardR, int boardC, int r, int c){
        boolean room = true;
        
        for(int cRange = -3; cRange != 4; cRange++){
            for(int rRange = -3; rRange != 4; rRange++){
                try{
                    if(mainBoard[r + rRange][c + cRange] == 54340 || mainBoard[r + rRange][c + cRange] == 99){


                    }else{
                        room = false;

                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return room;
    }
    
    public static boolean roomForSpice(int[][] mainBoard, int boardR, int boardC, int r, int c){
        boolean room = true;
        
        for(int cRange = -2; cRange != 3; cRange++){
            for(int rRange = -2; rRange != 3; rRange++){
                try{
                    if(mainBoard[r + rRange][c + cRange] == 54340 ){


                    }else{
                        room = false;

                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return room;
    }
    
    public static boolean roomForBloom(int[][] mainBoard, int boardR, int boardC, int randR, int randC, int spaceBetweenPoints){
        boolean foundAnotherBloom = false;
        int max = spaceBetweenPoints;
        int min = -spaceBetweenPoints;
        
        for(int c = min; c != max; c++){
            for(int r = min; r != max; r++){
                try{
                    if(mainBoard[r + randR][c + randC] == 54343  && foundAnotherBloom == false){
                        foundAnotherBloom = true;
                        
                    }else{
                        
                        
                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        if(foundAnotherBloom == false){
            return true;
            
        }else{
            return false;
            
        }
    }
    
    public static int[][] addSpice(int[][] mainBoard, int boardR, int boardC, 
            int numberOfBlooms, int numberOfEmptyBlooms, int numberOfSpiceSquares, int spiceSquareTop, int spiceSquareRight, int spiceSquareBottom, int spiceSquareLeft, 
            int numberOfSpiceSquaresAtATime){
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int counter = 0;
        int counterInner = -1;
        int[] edges = new int[2];
        int[][] mainBoardTemp = mainBoard;
        int attempts = 0;
        int attemptsLimit;
        int[] values = new int[4];
        int[] valuesToUse = new int[4];
        
        values[0] = spiceSquareTop;
        values[1] = spiceSquareRight;
        values[2] = spiceSquareBottom;
        values[3] = spiceSquareLeft;
        
        counter = 0;
        attempts = 0;
        attemptsLimit = (boardR * boardC * 8);
        do{
            for(int i = (int)Math.ceil(Math.sqrt(boardR * boardC)); i > 1; i-=4){
//                System.out.println(i + " " + counter);
                
                for(int ii = 0; ii != (int)Math.ceil(Math.sqrt(boardR * boardC) * 4); ii++){
                    randR = rand.nextInt((maxR - min) + 1) + min;
                    randC = rand.nextInt((maxC - min) + 1) + min;
                    attempts++;

                    try{
                        if(roomForBloom(mainBoard, boardR, boardC, randR, randC, i) == true){
                            if(counter < numberOfBlooms){
                               if(mainBoard[randR][randC] == 54340 && roomForSpice(mainBoard, boardR, boardC, randR, randC) == true){
                                   for(int ic = -1; ic != 2; ic++){
                                        for(int ir = -1; ir != 2; ir++){
                                            try{
                                                mainBoard[randR + ir][randC + ic] = 54345;

                                            }catch(IndexOutOfBoundsException e){

                                            }
                                        }
                                    }
                                    mainBoard[randR][randC] = 54343;
                                    counter++;

                                }
                            }

                        }else{

                        }
                    }catch(IndexOutOfBoundsException e){

                    }
                    
                    if(attempts >= attemptsLimit){
                        counter = 999999999;
                        numberOfBlooms = 0;

                    }
                }
            }
            
        }while(counter < numberOfBlooms);
        
        counter = 0;
        attempts = 0;
        attemptsLimit = (boardR * boardC * 2);
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            try{
                if(mainBoard[randR][randC] == 54340 && roomForSpice(mainBoard, boardR, boardC, randR, randC) == true){
                    for(int ic = -1; ic != 2; ic++){
                        for(int ir = -1; ir != 2; ir++){
                            try{
                                mainBoard[randR + ir][randC + ic] = 54345;
                                
                            }catch(IndexOutOfBoundsException e){

                            }
                        }
                    }
                    counter++;
                    
                }
                
            }catch(IndexOutOfBoundsException e){

            }
            
            if(attempts >= attemptsLimit){
                counter = 999999999;
                numberOfEmptyBlooms = 0;

            }
            
        }while(counter < numberOfEmptyBlooms);
        
        counter = 0;
        do{
            edges = findAnEdgeSquare(mainBoard, boardR, boardC, 2);
            
            if(edges[0] == -1){
                counter = 999999999;
                numberOfSpiceSquares = 0;
                
            }
            
            counterInner++;
            counter++;
            
            valuesToUse[0] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[1] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[2] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[3] = values[rand.nextInt((3 - 0) + 1) + 0];
            
            for(int newC = (edges[1] - valuesToUse[0]); newC != (edges[1] + valuesToUse[1] + 1); newC++){
                for(int newR = (edges[0] - valuesToUse[2]); newR != (edges[0] + valuesToUse[3] + 1); newR++){
                    try{
                        if(mainBoardTemp[newR][newC] == 54340 ){
                            mainBoardTemp[newR][newC] = 54345;
                            
                        }
                        
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                }
            }
            
            if(counterInner >= numberOfSpiceSquaresAtATime){
                mainBoard = mainBoardTemp;
                counterInner = -1;
                
            }
            
        }while(counter < numberOfSpiceSquares);
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 54345){
                    try{
                        if(mainBoard[r][c - 1] == 54340 || mainBoard[r + 1][c] == 54340 || mainBoard[r][c + 1] == 54340 || mainBoard[r - 1][c] == 54340 
                                || mainBoard[r - 1][c - 1] == 54340 || mainBoard[r + 1][c + 1] == 54340 
                                || mainBoard[r - 1][c + 1] == 54340 || mainBoard[r + 1][c - 1] == 54340 ){
                            mainBoard[r][c] = 54344;

                        }
                        
                        if(mainBoard[r][c - 1] != 54344 && mainBoard[r][c - 1] != 54345 && mainBoard[r][c - 1] != 54343 
                                || mainBoard[r][c + 1] != 54344 && mainBoard[r][c + 1] != 54345  && mainBoard[r][c + 1] != 54343 
                                || mainBoard[r - 1][c] != 54344 && mainBoard[r - 1][c] != 54345  && mainBoard[r - 1][c] != 54343 
                                || mainBoard[r + 1][c] != 54344 && mainBoard[r + 1][c] != 54345 && mainBoard[r + 1][c] != 54343
                                
                                || mainBoard[r - 1][c - 1] != 54344 && mainBoard[r - 1][c - 1] != 54345 && mainBoard[r - 1][c - 1] != 54343 
                                || mainBoard[r + 1][c + 1] != 54344 && mainBoard[r + 1][c + 1] != 54345  && mainBoard[r + 1][c + 1] != 54343 
                                || mainBoard[r - 1][c + 1] != 54344 && mainBoard[r - 1][c + 1] != 54345  && mainBoard[r - 1][c + 1] != 54343 
                                || mainBoard[r + 1][c - 1] != 54344 && mainBoard[r + 1][c - 1] != 54345 && mainBoard[r + 1][c - 1] != 54343){
                            mainBoard[r][c] = 54344;
                            
                        }
                    }catch(IndexOutOfBoundsException e){
                        mainBoard[r][c] = 54344;
                        
                    }
                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54343){
                        for(int ic = -1; ic != 2; ic++){
                            for(int ir = -1; ir != 2; ir++){
                                try{
                                    mainBoard[r + ir][c + ic] = 54344;

                                }catch(IndexOutOfBoundsException e){

                                }
                            }
                        }
                        
                        mainBoard[r][c] = 54343;
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] paintCliffs(int[][] mainBoard, int boardR, int boardC, String tileset) throws IOException{
        int[] tempCliff = new int[4];
        int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int rando = 0;
        int[] last = {-1, -1, -1, -1};
        boolean isDifferent = false;
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 543434){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 1, '3', anticipatedSize);
                            
                            if(last[0] != tempCliff[0]){
                                last[0] = tempCliff[0];
                                isDifferent = true;
                                
                                mainBoard[r][c] = tempCliff[0];
                                mainBoard[r + 1][c] = tempCliff[1];
                                mainBoard[r][c + 1] = tempCliff[2];
                                mainBoard[r + 1][c + 1] = tempCliff[3];
                                
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
                
                try{
                    if(mainBoard[r][c] == 543436){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 1, 'C', anticipatedSize);
                        
                            if(last[2] != tempCliff[0]){
                                last[2] = tempCliff[0];
                                isDifferent = true;
                                
                                rando = rand.nextInt((1000 - 0) + 1) + 0;

                                if(rando >= 0 && rando <= 150 && tileset.matches("BLOXBAT")){
                                    tempCliff = getBlockData("BLOXBAT", 7, 'F', anticipatedSize);

                                }else if(rando >= 0 && rando <= 150 && tileset.matches("BLOXICE")){
                                    tempCliff = getBlockData("BLOXICE", 7, 'G', anticipatedSize);

                                }else if(rando >= 0 && rando <= 150 && tileset.matches("BLOXWAST")){
                                    tempCliff = getBlockData("BLOXWAST", 7, 'F', anticipatedSize);

                                }

                                mainBoard[r][c] = tempCliff[0];
                                mainBoard[r + 1][c] = tempCliff[1];
                                mainBoard[r][c + 1] = tempCliff[2];
                                mainBoard[r + 1][c + 1] = tempCliff[3];
                            
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        for(int r = 0; r != boardR; r++){
            for(int c = 0; c != boardC; c++){
                try{
                    if(mainBoard[r][c] == 543435){ 
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 1, 'D', anticipatedSize);
                        
                            if(last[1] != tempCliff[0]){
                                last[1] = tempCliff[0];
                                isDifferent = true;
                                
                                mainBoard[r][c] = tempCliff[0];
                                mainBoard[r + 1][c] = tempCliff[1];
                                mainBoard[r][c + 1] = tempCliff[2];
                                mainBoard[r + 1][c + 1] = tempCliff[3];
                            
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 543437){
                        isDifferent = false;
                        
                        do{
                            tempCliff = getBlockData("BLOXBGBS", 1, 'E', anticipatedSize);
                        
                            if(last[3] != tempCliff[0]){
                                last[3] = tempCliff[0];
                                isDifferent = true;
                                
                                mainBoard[r][c] = tempCliff[0];
                                mainBoard[r + 1][c] = tempCliff[1];
                                mainBoard[r][c + 1] = tempCliff[2];
                                mainBoard[r + 1][c + 1] = tempCliff[3];
                            
                            }
                        
                        }while(isDifferent == false);
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addCliffMarkers(int[][] mainBoard, int boardR, int boardC){
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c - 1] == 54340 
                            
                            && mainBoard[r][c] == 54341 && mainBoard[r + 1][c] == 54341 ){
                        
                        mainBoard[r][c - 2] = 543434;
                        mainBoard[r + 1][c - 2] = 543430;
                        mainBoard[r][c - 1] = 543430;
                        mainBoard[r + 1][c - 1] = 543430;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 
                            
                            && mainBoard[r][c] == 54341 && mainBoard[r][c + 1] == 54341 ){
                        
                        mainBoard[r + 1][c] = 543435;
                        mainBoard[r + 2][c] = 543431;
                        mainBoard[r + 1][c + 1] = 543431;
                        mainBoard[r + 2][c + 1] = 543431;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r][c + 1] == 54340 
                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r][c + 2] == 54340 
                            
                            && mainBoard[r - 1][c] == 54341 && mainBoard[r][c] == 54341 ){
                        
                        mainBoard[r - 1][c + 1] = 543436;
                        mainBoard[r][c + 1] = 543432;
                        mainBoard[r - 1][c + 2] = 543432;
                        mainBoard[r][c + 2] = 543432;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            
                            && mainBoard[r][c - 1] == 54341 && mainBoard[r][c] == 54341 ){
                        
                        mainBoard[r - 2][c - 1] = 543437;
                        mainBoard[r - 1][c - 1] = 543433;
                        mainBoard[r - 2][c] = 543433;
                        mainBoard[r - 1][c] = 543433;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addInnerCornersAndReplace(int[][] mainBoard, int boardR, int boardC) throws IOException{
        int[] tempCliff = new int[4];
	int[] anticipatedSize = new int[2];
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c - 2] == 54340 && mainBoard[r - 1][c - 2] == 54340 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54341 
                            
                            && mainBoard[r - 2][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c - 2] == 54341 && mainBoard[r][c - 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'F', anticipatedSize);
                        
                        mainBoard[r - 2][c - 2] = tempCliff[0];
                        mainBoard[r - 1][c - 2] = tempCliff[1];
                        mainBoard[r - 2][c - 1] = tempCliff[2];
                        mainBoard[r - 1][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 2][c - 2] == 54340 
                            && mainBoard[r + 1][c - 1] == 54341 && mainBoard[r + 2][c - 1] == 54340 
                            
                            && mainBoard[r][c - 2] == 54341 && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'S', anticipatedSize);
                        
                        mainBoard[r + 1][c - 2] = tempCliff[0];
                        mainBoard[r + 2][c - 2] = tempCliff[1];
                        mainBoard[r + 1][c - 1] = tempCliff[2];
                        mainBoard[r + 2][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54341 && mainBoard[r + 2][c + 1] == 54340 
                            && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 2] == 54340 
                            
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'W', anticipatedSize);
                        
                        mainBoard[r + 1][c + 1] = tempCliff[0];
                        mainBoard[r + 2][c + 1] = tempCliff[1];
                        mainBoard[r + 1][c + 2] = tempCliff[2];
                        mainBoard[r + 2][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54341 
                            && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 2] == 54340 
                            
                            && mainBoard[r - 2][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'R', anticipatedSize);
                        
                        mainBoard[r - 2][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[1];
                        mainBoard[r - 2][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addInnerCorners(int[][] mainBoard, int boardR, int boardC) throws IOException{
        int[] tempCliff = new int[4];
	int[] anticipatedSize = new int[2];
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c - 2] == 54340 && mainBoard[r - 1][c - 2] == 54340 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 
                            
                            && mainBoard[r - 2][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c - 2] == 54341 && mainBoard[r][c - 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'F', anticipatedSize);
                        
                        mainBoard[r - 2][c - 2] = tempCliff[0];
                        mainBoard[r - 1][c - 2] = tempCliff[1];
                        mainBoard[r - 2][c - 1] = tempCliff[2];
                        mainBoard[r - 1][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 2][c - 2] == 54340 
                            && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 
                            
                            && mainBoard[r][c - 2] == 54341 && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'S', anticipatedSize);
                        
                        mainBoard[r + 1][c - 2] = tempCliff[0];
                        mainBoard[r + 2][c - 2] = tempCliff[1];
                        mainBoard[r + 1][c - 1] = tempCliff[2];
                        mainBoard[r + 2][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 
                            && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 2] == 54340 
                            
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'W', anticipatedSize);
                        
                        mainBoard[r + 1][c + 1] = tempCliff[0];
                        mainBoard[r + 2][c + 1] = tempCliff[1];
                        mainBoard[r + 1][c + 2] = tempCliff[2];
                        mainBoard[r + 2][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 2] == 54340 
                            
                            && mainBoard[r - 2][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'R', anticipatedSize);
                        
                        mainBoard[r - 2][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[1];
                        mainBoard[r - 2][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r - 2][c - 2] == 54340 && mainBoard[r - 1][c - 2] == 54340 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 
                            
                            && mainBoard[r - 2][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c - 2] == 54341 && mainBoard[r][c - 1] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'F', anticipatedSize);
                        
                        mainBoard[r - 2][c - 2] = tempCliff[0];
                        mainBoard[r - 1][c - 2] = tempCliff[1];
                        mainBoard[r - 2][c - 1] = tempCliff[2];
                        mainBoard[r - 1][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 2][c - 2] == 54340 
                            && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 
                            
                            && mainBoard[r][c - 2] == 54341 && mainBoard[r][c - 1] == 54341 
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'S', anticipatedSize);
                        
                        mainBoard[r + 1][c - 2] = tempCliff[0];
                        mainBoard[r + 2][c - 2] = tempCliff[1];
                        mainBoard[r + 1][c - 1] = tempCliff[2];
                        mainBoard[r + 2][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 
                            && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 2] == 54340 
                            
                            && mainBoard[r + 1][c] == 54341 && mainBoard[r + 2][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'W', anticipatedSize);
                        
                        mainBoard[r + 1][c + 1] = tempCliff[0];
                        mainBoard[r + 2][c + 1] = tempCliff[1];
                        mainBoard[r + 1][c + 2] = tempCliff[2];
                        mainBoard[r + 2][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 2] == 54340 
                            
                            && mainBoard[r - 2][c] == 54341 && mainBoard[r - 1][c] == 54341 
                            && mainBoard[r][c + 1] == 54341 && mainBoard[r][c + 2] == 54341 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'R', anticipatedSize);
                        
                        mainBoard[r - 2][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[1];
                        mainBoard[r - 2][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addCornersReducedSimple(int[][] mainBoard, int boardR, int boardC, String tileset) throws IOException{
        int[] tempCliff = new int[4];
        int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int rando = 0;
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c - 2] == 54340 && mainBoard[r - 1][c - 2] == 54340 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, '1', anticipatedSize);
                        
                        mainBoard[r - 2][c - 2] = tempCliff[0];
                        mainBoard[r - 1][c - 2] = tempCliff[1];
                        mainBoard[r - 2][c - 1] = tempCliff[2];
                        mainBoard[r - 1][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 2][c - 2] == 54340 
                            && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, '5', anticipatedSize);
                        
                        rando = rand.nextInt((1000 - 0) + 1) + 0;
                        
                        if(rando >= 0 && rando <= 100 && tileset.matches("BLOXWAST")){
                            tempCliff = getBlockDataSpecial("BLOXWAST", 7, 'J', anticipatedSize);
                            
                        }
                        
                        mainBoard[r + 1][c - 2] = tempCliff[0];
                        mainBoard[r + 2][c - 2] = tempCliff[1];
                        mainBoard[r + 1][c - 1] = tempCliff[2];
                        mainBoard[r + 2][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 
                            && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 2] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'B', anticipatedSize);
                        
                        mainBoard[r + 1][c + 1] = tempCliff[0];
                        mainBoard[r + 2][c + 1] = tempCliff[1];
                        mainBoard[r + 1][c + 2] = tempCliff[2];
                        mainBoard[r + 2][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 2] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'Z', anticipatedSize);
                        
                        mainBoard[r - 2][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[1];
                        mainBoard[r - 2][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addCornersReduced(int[][] mainBoard, int boardR, int boardC, String tileset) throws IOException{
        int[] tempCliff = new int[4];
        int[] anticipatedSize = new int[2];
        Random rand = new Random();
        int rando = 0;
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c - 2] == 54340 && mainBoard[r - 1][c - 2] == 54340 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 
                            
                            && mainBoard[r][c - 2] == 54340  
                            && mainBoard[r][c - 1] == 54340 
                            
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, '1', anticipatedSize);
                        
                        mainBoard[r - 2][c - 2] = tempCliff[0];
                        mainBoard[r - 1][c - 2] = tempCliff[1];
                        mainBoard[r - 2][c - 1] = tempCliff[2];
                        mainBoard[r - 1][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 2][c - 2] == 54340 
                            && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 
                            
                            && mainBoard[r][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54340 
                            
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, '5', anticipatedSize);
                        
                        rando = rand.nextInt((1000 - 0) + 1) + 0;
                        
                        if(rando >= 0 && rando <= 100 && tileset.matches("BLOXWAST")){
                            tempCliff = getBlockDataSpecial("BLOXWAST", 7, 'J', anticipatedSize);
                            
                        }
                        
                        mainBoard[r + 1][c - 2] = tempCliff[0];
                        mainBoard[r + 2][c - 2] = tempCliff[1];
                        mainBoard[r + 1][c - 1] = tempCliff[2];
                        mainBoard[r + 2][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 
                            && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 2] == 54340 
                            
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            
                            && mainBoard[r][c + 1] == 54340 
                            && mainBoard[r][c + 2] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'B', anticipatedSize);
                        
                        mainBoard[r + 1][c + 1] = tempCliff[0];
                        mainBoard[r + 2][c + 1] = tempCliff[1];
                        mainBoard[r + 1][c + 2] = tempCliff[2];
                        mainBoard[r + 2][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 2] == 54340 
                            
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            
                            && mainBoard[r][c + 1] == 54340 
                            && mainBoard[r][c + 2] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'Z', anticipatedSize);
                        
                        mainBoard[r - 2][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[1];
                        mainBoard[r - 2][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] addCorners(int[][] mainBoard, int boardR, int boardC) throws IOException{
        int[] tempCliff = new int[4];
        int[] anticipatedSize = new int[2];
        anticipatedSize[0] = 2;
        anticipatedSize[1] = 2;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c - 2] == 54340 && mainBoard[r - 1][c - 2] == 54340 
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 
                            
                            && mainBoard[r][c - 2] == 54340 && mainBoard[r + 1][c - 2] == 54340 
                            && mainBoard[r][c - 1] == 54340 && mainBoard[r + 1][c - 1] == 54340 
                            
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, '1', anticipatedSize);
                        
                        mainBoard[r - 2][c - 2] = tempCliff[0];
                        mainBoard[r - 1][c - 2] = tempCliff[1];
                        mainBoard[r - 2][c - 1] = tempCliff[2];
                        mainBoard[r - 1][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c - 2] == 54340 && mainBoard[r + 2][c - 2] == 54340 
                            && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 
                            
                            && mainBoard[r - 1][c - 2] == 54340 && mainBoard[r][c - 2] == 54340 
                            && mainBoard[r - 1][c - 1] == 54340 && mainBoard[r][c - 1] == 54340 
                            
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, '5', anticipatedSize);
                        
                        mainBoard[r + 1][c - 2] = tempCliff[0];
                        mainBoard[r + 2][c - 2] = tempCliff[1];
                        mainBoard[r + 1][c - 1] = tempCliff[2];
                        mainBoard[r + 2][c - 1] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 1] == 54340 
                            && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 2] == 54340 
                            
                            && mainBoard[r + 1][c - 1] == 54340 && mainBoard[r + 2][c - 1] == 54340 
                            && mainBoard[r + 1][c] == 54340 && mainBoard[r + 2][c] == 54340 
                            
                            && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r][c + 1] == 54340 
                            && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r][c + 2] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'B', anticipatedSize);
                        
                        mainBoard[r + 1][c + 1] = tempCliff[0];
                        mainBoard[r + 2][c + 1] = tempCliff[1];
                        mainBoard[r + 1][c + 2] = tempCliff[2];
                        mainBoard[r + 2][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 2] == 54340 
                            
                            && mainBoard[r - 2][c - 1] == 54340 && mainBoard[r - 1][c - 1] == 54340 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c] == 54340 
                            
                            && mainBoard[r][c + 1] == 54340 && mainBoard[r + 1][c + 1] == 54340 
                            && mainBoard[r][c + 2] == 54340 && mainBoard[r + 1][c + 2] == 54340 ){
                        tempCliff = getBlockData("BLOXBGBS", 1, 'Z', anticipatedSize);
                        
                        mainBoard[r - 2][c + 1] = tempCliff[0];
                        mainBoard[r - 1][c + 1] = tempCliff[1];
                        mainBoard[r - 2][c + 2] = tempCliff[2];
                        mainBoard[r - 1][c + 2] = tempCliff[3];
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        return mainBoard;
    }
    
    public static int[][] checkSpacingDiagonally(int[][] mainBoard, int boardR, int boardC){
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c + 1] == 54340 
                            && mainBoard[r - 2][c + 2] == 54341 
                            && mainBoard[r - 2][c] == 54340 && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r][c + 2] == 54340 ){
                        mainBoard[r - 2][c] = 90;
                        mainBoard[r - 1][c + 1] = 90;
                        mainBoard[r][c + 2] = 90;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r - 2][c + 2] == 54340 
                            && mainBoard[r - 3][c + 3] == 54341 
                            && mainBoard[r - 3][c] == 54340 && mainBoard[r - 2][c + 1] == 54340 && mainBoard[r - 1][c + 2] == 54340 && mainBoard[r][c + 3] == 54340 ){
                        mainBoard[r - 3][c] = 90;
                        mainBoard[r - 2][c + 1] = 90;
                        mainBoard[r - 1][c + 2] = 90;
                        mainBoard[r][c + 3] = 90;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r - 1][c + 1] == 54340 && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 3][c + 3] == 54340 
                            && mainBoard[r - 4][c + 4] == 54341 
                            && mainBoard[r - 4][c] == 54340 && mainBoard[r - 3][c + 1] == 54340 && mainBoard[r - 2][c + 2] == 54340 && mainBoard[r - 1][c + 3] == 54340 && mainBoard[r][c + 4] == 54340 ){
                        mainBoard[r - 4][c] = 90;
                        mainBoard[r - 3][c + 1] = 90;
                        mainBoard[r - 2][c + 2] = 90;
                        mainBoard[r - 1][c + 3] = 90;
                        mainBoard[r][c + 4] = 90;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 
                            && mainBoard[r + 2][c + 2] == 54341 
                            && mainBoard[r][c + 2] == 54340 && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c] == 54340 ){
                        mainBoard[r][c + 2] = 90;
                        mainBoard[r + 1][c + 1] = 90;
                        mainBoard[r + 2][c] = 90;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 2] == 54340 
                            && mainBoard[r + 3][c + 3] == 54341 
                            && mainBoard[r][c + 3] == 54340 && mainBoard[r + 1][c + 2] == 54340 && mainBoard[r + 2][c + 1] == 54340 && mainBoard[r + 3][c] == 54340 ){
                        mainBoard[r][c + 3] = 90;
                        mainBoard[r + 1][c + 2] = 90;
                        mainBoard[r + 2][c + 1] = 90;
                        mainBoard[r + 3][c] = 90;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r][c] == 54341 
                            && mainBoard[r + 1][c + 1] == 54340 && mainBoard[r + 2][c + 2] == 54340 && mainBoard[r + 3][c + 3] == 54340 
                            && mainBoard[r + 4][c + 4] == 54341 
                            && mainBoard[r][c + 4] == 54340 && mainBoard[r + 1][c + 3] == 54340 && mainBoard[r + 2][c + 2] == 54340 && mainBoard[r + 3][c + 1] == 54340 && mainBoard[r + 4][c] == 54340 ){
                        mainBoard[r][c + 4] = 90;
                        mainBoard[r + 1][c + 3] = 90;
                        mainBoard[r + 2][c + 2] = 90;
                        mainBoard[r + 3][c + 1] = 90;
                        mainBoard[r + 4][c] = 90;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(mainBoard[r][c] == 90){
                    try{
                        for(int cRange = -3; cRange != 4; cRange++){
                            for(int rRange = -3; rRange != 4; rRange++){
                                mainBoard[r + rRange][c + cRange] = 54341;

                            }
                        }
                        
                    }catch(IndexOutOfBoundsException e){

                    }
                }
            }
        }

        return mainBoard;
    }
    
    public static int[][] removeGaps(int[][] mainBoard, int boardR, int boardC){
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                try{
                    if(mainBoard[r + 0][c + 0] == 54341 && mainBoard[r + 0][c + 1] == 54340 && mainBoard[r + 0][c + 2] == 54341 ){
                        mainBoard[r + 0][c + 1] = 54341;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 0][c + 0] == 54341 && mainBoard[r + 1][c + 0] == 54340 && mainBoard[r + 2][c + 0] == 54341 ){
                        mainBoard[r + 1][c + 0] = 54341;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 0][c + 0] == 54341 && mainBoard[r + 0][c + 1] == 54340 && mainBoard[r + 0][c + 2] == 54340 && mainBoard[r + 0][c + 3] == 54341 ){
                        mainBoard[r + 0][c + 1] = 54341;
                        mainBoard[r + 0][c + 2] = 54341;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 0][c + 0] == 54341 && mainBoard[r + 1][c + 0] == 54340 && mainBoard[r + 2][c + 0] == 54340 && mainBoard[r + 3][c + 0] == 54341 ){
                        mainBoard[r + 1][c + 0] = 54341;
                        mainBoard[r + 2][c + 0] = 54341;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 0][c + 0] == 54341 && 
                            mainBoard[r + 0][c + 1] == 54340 && mainBoard[r + 0][c + 2] == 54340 && mainBoard[r + 0][c + 3] == 54340 
                            && mainBoard[r + 0][c + 4] == 54341 ){
                        mainBoard[r + 0][c + 1] = 54341;
                        mainBoard[r + 0][c + 2] = 54341;
                        mainBoard[r + 0][c + 3] = 54341;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
                try{
                    if(mainBoard[r + 0][c + 0] == 54341 && 
                            mainBoard[r + 1][c + 0] == 54340 && mainBoard[r + 2][c + 0] == 54340 && mainBoard[r + 3][c + 0] == 54340 
                            && mainBoard[r + 4][c + 0] == 54341 ){
                        mainBoard[r + 1][c + 0] = 54341;
                        mainBoard[r + 2][c + 0] = 54341;
                        mainBoard[r + 3][c + 0] = 54341;
                        
                    }
                }catch(IndexOutOfBoundsException e){

                }
                
            }
        }
        
        return mainBoard;
    }
    
    public static int[] findAnEdgeSquare(int[][] mainBoard, int boardR, int boardC, int type){
        //type 0 -  sand, 1 - rock, 2 - thick spice...
        int[] toReturn = new int[2];
        boolean foundASquare;
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = boardR - 1;
        int maxC = boardC - 1;
        int min = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 1);
        
        foundASquare = false;
        attempts = 0;
        do{
            try{
                randR = rand.nextInt((maxR - min) + 1) + min;
                randC = rand.nextInt((maxC - min) + 1) + min;
                attempts++;
                
                if(type == 0){
                   if(mainBoard[randR][randC] == 54340 ){
                        if(mainBoard[randR][randC - 1] == 54341 
                                || mainBoard[randR + 1][randC] == 54341 
                                || mainBoard[randR][randC + 1] == 54341 
                                || mainBoard[randR - 1][randC] == 54341 ){

                            foundASquare = true;
                            toReturn[0] = randR;
                            toReturn[1] = randC;

                        }
                    }
                }else if(type == 1){
                    if(mainBoard[randR][randC] == 54341 ){
                        if(mainBoard[randR][randC - 1] == 54340 
                                || mainBoard[randR + 1][randC] == 54340 
                                || mainBoard[randR][randC + 1] == 54340 
                                || mainBoard[randR - 1][randC] == 54340 ){

                            foundASquare = true;
                            toReturn[0] = randR;
                            toReturn[1] = randC;

                        }
                    }
                }else if(type == 2){
                    if(mainBoard[randR][randC] == 54345){
                        if(mainBoard[randR][randC - 1] == 54340 
                                || mainBoard[randR + 1][randC] == 54340 
                                || mainBoard[randR][randC + 1] == 54340 
                                || mainBoard[randR - 1][randC] == 54340 ){

                            foundASquare = true;
                            toReturn[0] = randR;
                            toReturn[1] = randC;

                        }
                    }
                }else if(type == 3){
                    if(mainBoard[randR][randC] == 9997){
                        if(mainBoard[randR][randC - 1] == 54340 
                                || mainBoard[randR + 1][randC] == 54340 
                                || mainBoard[randR][randC + 1] == 54340 
                                || mainBoard[randR - 1][randC] == 54340 ){

                            foundASquare = true;
                            toReturn[0] = randR;
                            toReturn[1] = randC;

                        }
                    }
                }else if(type == 4){
                    if(mainBoard[randR][randC] == 5434151){
                        if(mainBoard[randR][randC - 1] == 54340 
                                || mainBoard[randR + 1][randC] == 54340 
                                || mainBoard[randR][randC + 1] == 54340 
                                || mainBoard[randR - 1][randC] == 54340 ){

                            foundASquare = true;
                            toReturn[0] = randR;
                            toReturn[1] = randC;

                        }
                    }
                }
                
                if(attempts >= attemptsLimit){
                    foundASquare = true;
                    toReturn[0] = -1;
                    toReturn[1] = -1;

                }
                
            }catch(IndexOutOfBoundsException e){
                
            }
        }while(foundASquare == false);
        
        return toReturn;
        
    }
    
    public static int[][] addRockSquares(int[][] mainBoard, int boardR, int boardC, 
            int numberToAdd, int squareTop, int squareRight, int squareBottom, int squareLeft, int numberAtATime){
        int[] edges = new int[2];
        int counter = 0;
        int counterInner = -1;
        int[][] mainBoardTemp = mainBoard;
        int[] values = new int[4];
        int[] valuesToUse = new int[4];
        Random rand = new Random();
        
        values[0] = squareTop;
        values[1] = squareRight;
        values[2] = squareBottom;
        values[3] = squareLeft;
        
        counter = 0;
        do{
            edges = findAnEdgeSquare(mainBoard, boardR, boardC, 1);
            
            if(edges[0] == -1){
                mainBoard = mainBoardTemp;
                counter = 999999999;
                numberToAdd = 0;
                
            }
            
            counterInner++;
            counter++;
            
            valuesToUse[0] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[1] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[2] = values[rand.nextInt((3 - 0) + 1) + 0];
            valuesToUse[3] = values[rand.nextInt((3 - 0) + 1) + 0];
            
            for(int newC = (edges[1] - valuesToUse[0]); newC != (edges[1] + valuesToUse[1] + 1); newC++){
                for(int newR = (edges[0] - valuesToUse[2]); newR != (edges[0] + valuesToUse[3] + 1); newR++){
                    try{
                        if(mainBoardTemp[newR][newC] == 54349){
                            
                        }else{
                            mainBoardTemp[newR][newC] = 54341;
                            
                        }
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                }
            }
            
            if(counterInner >= numberAtATime){
                mainBoard = mainBoardTemp;
                counterInner = -1;
                
            }
        }while(counter < numberToAdd);
        
        mainBoard = mainBoardTemp;
        return mainBoard;
    }
    
    public static int[][] addRockPlains(int[][] mainBoard, int boardR, int boardC, int broadSize){
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                
                if(mainBoard[r][c] == 54349){
                    for(int newC = -broadSize; newC != broadSize; newC++){
                        for(int newR = -broadSize; newR != broadSize; newR++){
                            try{
                                if(newR == 0 && newC == 0){
                                    
                                }else{
                                    mainBoard[r + newR][c + newC] = 54341;
                                    
                                }
                            }catch(IndexOutOfBoundsException e){
                    
                            }
                        }
                    }
                }
            }
        }
        
        return mainBoard;
    }
    
    public static boolean roomForSpawn(int[][] mainBoard, int boardR, int boardC, int randR, int randC, int spaceBetweenPoints){
        boolean foundAnotherSpawn = false;
        int max = spaceBetweenPoints;
        int min = -spaceBetweenPoints;
        
        for(int c = min; c != max; c++){
            for(int r = min; r != max; r++){
                try{
                    if(mainBoard[r + randR][c + randC] == 54349  && foundAnotherSpawn == false){
                        foundAnotherSpawn = true;
                        
                    }else{
                        
                        
                    }
                }catch(IndexOutOfBoundsException e){
                    
                }
            }
        }
        
        if(foundAnotherSpawn == false){
            return true;
            
        }else{
            return false;
            
        }
    }
    
    public static boolean roomForSpawnSafe(int[][] mainBoard, int boardR, int boardC, int randR, int randC, int spaceBetweenPoints){
        boolean foundAnotherSpawn = false;
        int max = spaceBetweenPoints;
        int min = -spaceBetweenPoints;
        
        for(int c = min; c != max; c++){
            for(int r = min; r != max; r++){
                try{
                    if(mainBoard[r + randR][c + randC] == 54349  && foundAnotherSpawn == false){
                        foundAnotherSpawn = true;
                        
                    }else{
                        
                        
                    }
                }catch(IndexOutOfBoundsException e){
                    return false;
                    
                }
            }
        }
        
        if(foundAnotherSpawn == false){
            return true;
            
        }else{
            return false;
            
        }
    }
    
    public static int[][] addSpawnMarkers(int[][] mainBoard, int boardR, int boardC, int spaceBetweenPoints, int numberOfSpawnsToAdd){
        int count = 0;
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = (boardR - 1) - 2;
        int maxC = (boardC - 1) - 2;
        int min = (0) + 2;
        int spawn = 0;
        int attempts = 0;
        int attemptsLimit = (boardR * boardC * 2);
        
        attempts = 0;
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            attempts++;
            
            if(roomForSpawn(mainBoard, boardR, boardC, randR, randC, spaceBetweenPoints) == true){
                mainBoard[randR][randC] = 54349;
                count++;
            
            }else{
                spawn++;
                
            }
            
            if(attempts >= attemptsLimit){
                count = 999999999;
                numberOfSpawnsToAdd = 0;

            }
            
        }while(count < numberOfSpawnsToAdd);
        
//        System.out.println("spawn " + spawn);
        return mainBoard;
    }
    
    public static int[][] addSpawnMarkersSafe(int[][] mainBoard, int boardR, int boardC, int spaceBetweenPoints, int numberOfSpawnsToAdd){
        int count = 0;
        Random rand = new Random();
        int randR = 0;
        int randC = 0;
        int maxR = (boardR - 1) - 2;
        int maxC = (boardC - 1) - 2;
        int min = (0) - 2;
        int tryAgainCount = 0; 
        int restarts = 0; 
        int tryAgainTotal = 0;
        
        do{
            randR = rand.nextInt((maxR - min) + 1) + min;
            randC = rand.nextInt((maxC - min) + 1) + min;
            
            if(roomForSpawnSafe(mainBoard, boardR, boardC, randR, randC, spaceBetweenPoints) == true){
                mainBoard[randR][randC] = 54349;
                count++;
            
            }else{
                //System.out.println("trying again 1, no room");
                tryAgainCount++;
                tryAgainTotal++;

            }
            
            if(tryAgainCount == 4194304){
                tryAgainCount = 0;
                count = 0; 
                restarts ++;

                for(int c = 0; c != boardC; c++){
                    for(int r = 0; r != boardR; r++){
                        mainBoard[r][c] = 54340;

                    }
                }

                System.out.println("Starting again"); 
                continue;

            }
            
            if(restarts == 1024){
                for(int i = 0; i != numberOfSpawnsToAdd; i++){
                    randR = rand.nextInt((maxR - min) + 1) + min;
                    randC = rand.nextInt((maxC - min) + 1) + min;
                    mainBoard[randR][randC] = 54349;
                    System.out.println("Fail");
                
                }
                
                return mainBoard;
                
            }
            
        }while(count < numberOfSpawnsToAdd);
        
        System.out.println(tryAgainTotal);
        return mainBoard;
    }
    
    public static int[][] fillWithSand(int[][] mainBoard, int boardR, int boardC){
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                mainBoard[r][c] = 54340;
            
            }
        }
        
        return mainBoard;
    }
}