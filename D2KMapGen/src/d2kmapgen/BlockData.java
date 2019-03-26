package d2kmapgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import org.ini4j.Ini;

public class BlockData {
    public static int[] corConverterCustom(String string){//convert to numarical value ex 34, 678, 799//2.2.09.26  ////// 20x40 grid //= convertToHex(boardR, true);
        String[] stringCut = null;
        int[] intFinal = null;
        int counter = 0;
        String temp = "";
        int[] toReturn = null;
        int[][] board = new int[20][40];
        int[] boardNew = new int[800];
        
        for(int c = 0; c != 40; c++){
            for(int r = 0; r != 20; r++){
                board[r][c] = 0;
                
            }
        }
        
        string += ".";
        
        counter = 0;
        for(int i = 0; i < string.length(); i++){
           if(string.charAt(i) == '.'){
               counter++;
               
           } 
        }
        
        stringCut = new String[counter + 1];
        toReturn = new int[32];
        
        counter = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '.'){
                counter++;
                stringCut[counter] = temp;
                temp = "";
                
                
                
            }else{
                temp += string.charAt(i);
                
            }
        }
        
        for(int i = 3; i != (32); i++){
            try{
                try{
                    toReturn[i - 3] = Integer.parseInt(stringCut[i]);
                    
                }catch(NumberFormatException e){
                    
                }
            }catch(ArrayIndexOutOfBoundsException e){
                
            }
        }
        
        return toReturn;
    }
    
    public static int[] getBlockDataSpecial(String tileset, int groupNumber, char var, int[] anticipatedSize) throws IOException{
        String tileFileName = "ini\\" + tileset + ".ini";
        Ini tileIni = null;
        boolean foundFile = true;
        String string = "";
        boolean foundSemi = false;
        int semiCount = 0;
        String[] stringCut = null;
        String temp = "";
        int counter = 0;
        String stringFinal = "";
        boolean foundOne = false;
        Random rand = new Random();
        int min = 0;
        int randVar = 0;
        int[] toReturn = null;
        String customSize = "";
        //anticipatedSize ex 2x2 or 2x1 or 4x2 etc. useful for getting the correct cliff
        
        try{
            tileIni = new Ini(new File(tileFileName));
            foundFile = true;
            
        }catch(FileNotFoundException e){
            System.out.println("'" + tileFileName + "' not found!");
            foundFile = false;
            
        }
        
        if(foundFile == true){
            string = tileIni.get(("Block_Preset_Group_" + groupNumber), String.valueOf(var));

            if(string.length() > 3){
                return corConverter(string); 
                
            }else if(string.length() == 1){
                customSize = tileIni.get("Custom_Blocks", String.valueOf(string.charAt(0)));
                
                return corConverterCustom(customSize);
                
            }else{
                toReturn[0] = -1;
                toReturn[1] = -1;
                return toReturn;
                
            }
            
        }else{
            toReturn = new int[anticipatedSize[0] * anticipatedSize[1]];
            
            for(int i = 0; i != (anticipatedSize[0] * anticipatedSize[1]); i++){
                toReturn[i] = 0;
                
            }
            
            return toReturn;
            
        }
    }
    
    public static int[] getSize(String tileset, int groupNumber, char var) throws IOException{
        String tileFileName = "ini\\" + tileset + ".ini";
        Ini tileIni = null;
        boolean foundFile = true;
        String string = "";
        boolean foundSemi = false;
        int semiCount = 0;
        String[] stringCut = null;
        String temp = "";
        int counter = 0;
        String stringFinal = "";
        boolean foundOne = false;
        Random rand = new Random();
        int min = 0;
        int randVar = 0;
        int[] toReturn = new int[2];
        String customSize = "";
        
        try{
            tileIni = new Ini(new File(tileFileName));
            foundFile = true;
            
        }catch(FileNotFoundException e){
            System.out.println("'" + tileFileName + "' not found!");
            foundFile = false;
            
        }
        
        if(foundFile == true){
            string = tileIni.get(("Block_Preset_Group_" + groupNumber), String.valueOf(var));
            string += ";";
            
            if(string.length() > 3){
            
                if(string.charAt(0) != 'n'){
                    toReturn[0] = Integer.parseInt(String.valueOf(string.charAt(0)));
                    toReturn[1] = Integer.parseInt(String.valueOf(string.charAt(2)));
                    return toReturn;

                }else{
                    toReturn[0] = -1;
                    toReturn[1] = -1;
                    return toReturn;

                }
            }else if(string.length() == 2){
                customSize = tileIni.get("Custom_Blocks", String.valueOf(string.charAt(0)));
                toReturn[0] = Integer.parseInt(String.valueOf(customSize.charAt(0)));
                toReturn[1] = Integer.parseInt(String.valueOf(customSize.charAt(2)));
                
                return toReturn;
                
            }else{
                toReturn[0] = -1;
                toReturn[1] = -1;
                return toReturn;
                
            }
            
        }else{
            System.out.println("nullllllllllllllllllllllll no file");
            toReturn[0] = -1;
            toReturn[1] = -1;
            return toReturn;
            
        }
    }
    
    public static int[] corConverter(String string){//convert to numarical value ex 34, 678, 799//2.2.09.26  ////// 20x40 grid //= convertToHex(boardR, true);
        String[] stringCut = new String[4];
        int[] intFinal = null;
        int counter = 0;
        String temp = "";
        int[] toReturn = null;
        int[][] board = new int[20][40];
        
        for(int c = 0; c != 40; c++){
            for(int r = 0; r != 20; r++){
                board[r][c] = 0;
                
            }
        }
        
        string += ".";
        
        counter = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '.'){
                stringCut[counter] = temp;
                temp = "";
                counter++;
                
            }else{
                temp += string.charAt(i);
                
            }
        }
        
        toReturn = new int[Integer.parseInt(stringCut[0]) * Integer.parseInt(stringCut[1])];
        
        for(int c = 0; c != Integer.parseInt(stringCut[1]); c++){
            for(int r = 0; r != Integer.parseInt(stringCut[0]); r++){
                board[Integer.parseInt(stringCut[2]) + r][Integer.parseInt(stringCut[3]) + c] = 1;
                
            }
        }
        
        counter = 0;
        for(int c = 0; c != 40; c++){
            for(int r = 0; r != 20; r++){
                if(board[r][c] == 1){
                    toReturn[counter] = (20 * c) + r;
                    counter++;
                    
                }
                
            }
        }
        
        return toReturn;
    }
    
    public static int[] getBlockData(String tileset, int groupNumber, char var, int[] anticipatedSize) throws IOException{
        String tileFileName = "ini\\" + tileset + ".ini";
        Ini tileIni = null;
        boolean foundFile = true;
        String string = "";
        boolean foundSemi = false;
        int semiCount = 0;
        String[] stringCut = null;
        String temp = "";
        int counter = 0;
        String stringFinal = "";
        boolean foundOne = false;
        Random rand = new Random();
        int min = 0;
        int randVar = 0;
        int[] toReturn = null;
        //anticipatedSize ex 2x2 or 2x1 or 4x2 etc. useful for getting the correct cliff
        
        try{
            tileIni = new Ini(new File(tileFileName));
            foundFile = true;
            
        }catch(FileNotFoundException e){
            System.out.println("'" + tileFileName + "' not found!");
            foundFile = false;
            
        }
        
        if(foundFile == true){
            string = tileIni.get(("Block_Preset_Group_" + groupNumber), String.valueOf(var));
            string += ";";

            for(int i = 0; i != string.length(); i++){
                if(string.charAt(i) == ';'){
                    foundSemi = true;
                    semiCount++;

                }
            }

            stringCut = new String[semiCount];

            for(int i = 0; i < string.length(); i++){
                if(string.charAt(i) == ';'){
                    stringCut[counter] = temp;
                    temp = "";
                    counter++;

                }else{
                    temp += string.charAt(i);

                }
            }

            do{
                randVar = rand.nextInt(((semiCount - 1) - min) + 1) + min;

                if(anticipatedSize[0] == Integer.parseInt(String.valueOf(stringCut[randVar].charAt(0))) && anticipatedSize[1] == Integer.parseInt(String.valueOf(stringCut[randVar].charAt(2)))){
                    foundOne = true;
                    stringFinal = stringCut[randVar];

                }

            }while(foundOne == false);

            return corConverter(stringFinal);
            
        }else{
            toReturn = new int[anticipatedSize[0] * anticipatedSize[1]];
            
            for(int i = 0; i != (anticipatedSize[0] * anticipatedSize[1]); i++){
                toReturn[i] = 0;
                
            }
            
            return toReturn;
            
        }
    }
    
//    public static void main(String[] args) throws IOException {
//        int[] anticipatedSize = new int[2];
//        anticipatedSize[0] = 2;
//        anticipatedSize[1] = 2;
//        
////        System.out.println(getBlockData("BLOXBGBS", 1, '3', anticipatedSize));
//        System.out.println(getSize("BLOXBGBS", 5, '3'));
//        System.out.println(getBlockDataSpecial("BLOXBGBS", 5, '3', anticipatedSize));
//        
//    }
}
