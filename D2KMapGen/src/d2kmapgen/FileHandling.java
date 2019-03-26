package d2kmapgen;

import static d2kmapgen.GUI.listOfTilesets;
import static d2kmapgen.GUI.listOfTilesetsLength;
import static d2kmapgen.Tiles.getBloomSpawnHexAsNonSpecial;
import static d2kmapgen.Tiles.getBloomSpawnHexAsSpecial;
import static d2kmapgen.Tiles.getDuneHex;
import static d2kmapgen.Tiles.getRandomDuneHex;
import static d2kmapgen.Tiles.getRandomRockHex;
import static d2kmapgen.Tiles.getRandomSandHex;
import static d2kmapgen.Tiles.getRockHex;
import static d2kmapgen.Tiles.getSandHex;
import static d2kmapgen.Tiles.getSpawnHexAsNonSpecial;
import static d2kmapgen.Tiles.getSpawnHexAsSpecial;
import static d2kmapgen.Tiles.getSpiceHardHexAsNonSpecial;
import static d2kmapgen.Tiles.getSpiceHardHexAsSpecial;
import static d2kmapgen.Tiles.getSpiceLightHexAsNonSpecial;
import static d2kmapgen.Tiles.getSpiceLightHexAsSpecial;
import static d2kmapgen.Tiles.getWormSpawnHexAsNonSpecial;
import static d2kmapgen.Tiles.getWormSpawnHexAsSpecial;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import org.ini4j.Ini;

public class FileHandling {
    public static void createFile(){
        //if a file is not found, make a new one for later
    }
    
    public static String[][] numberToHexNonSpecial(int[][] board, int boardR, int boardC){
        String[][] boardHex = new String[boardR][boardC];
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                if(board[r][c] == 54340){//SANDHOLD
                    boardHex[r][c] = getRandomSandHex();

                }else if(board[r][c] == 54341){//ROCKHOLD
                    boardHex[r][c] = getRandomRockHex();

                }else if(board[r][c] == 9997){//DUNEHOLD
                    boardHex[r][c] = getRandomDuneHex();

                }else if(board[r][c] == 9998){
                    boardHex[r][c] = getRandomDuneHex();

                }else if(board[r][c] == 9999){
                    boardHex[r][c] = "0000";

                }else if(board[r][c] == 54342){//WORMHOLD
                    boardHex[r][c] = getWormSpawnHexAsNonSpecial();

                }else if(board[r][c] == 54343){//BLOOMHOLD
                    boardHex[r][c] = getBloomSpawnHexAsNonSpecial();

                }else if(board[r][c] == 54344){//LIGHTHOLD
                    boardHex[r][c] = getSpiceLightHexAsNonSpecial();

                }else if(board[r][c] == 54345){//HARDHOLD
                    boardHex[r][c] = getSpiceHardHexAsNonSpecial();

                }else if(board[r][c] == 54349){//SPAWNHOLD
                    boardHex[r][c] = getSpawnHexAsNonSpecial();

                }else if(board[r][c] == 9991){
                    boardHex[r][c] = "0100";

                }else if(board[r][c] == 9992){
                    boardHex[r][c] = "D002";

                }else if(board[r][c] == 9993){
                    boardHex[r][c] = "E702";

                }else if(board[r][c] == 54348){
                    boardHex[r][c] = "6901";

                }else if(board[r][c] == 54347){
                    boardHex[r][c] = "7301";

                }else if(board[r][c] == 54346){
                    boardHex[r][c] = "1201";

                }else if(board[r][c] == 543490){
                    boardHex[r][c] = "D002";

                }else if(board[r][c] == 543491){
                    boardHex[r][c] = "D002";

                }else if(board[r][c] == 543420){//Temp
                    boardHex[r][c] = "BC02";

                }else if(board[r][c] == 543421){//Temp
                    boardHex[r][c] = "D002";

                }else if(board[r][c] == 543422){//Temp
                    boardHex[r][c] = "E702";

                }else if(board[r][c] == 543423){//Temp
                    boardHex[r][c] = "2101";

                }else if(board[r][c] == 543424){//Temp
                    boardHex[r][c] = "6901";
                    
                }else if(board[r][c] == 543430){//Temp
                    boardHex[r][c] = "CC02";

                }else if(board[r][c] == 543431){//Temp
                    boardHex[r][c] = "CD02";

                }else if(board[r][c] == 543432){//Temp
                    boardHex[r][c] = "E002";

                }else if(board[r][c] == 543433){//Temp
                    boardHex[r][c] = "E102";

                }else if(board[r][c] == 543434){//Temp
                    boardHex[r][c] = "CC03";

                }else if(board[r][c] == 543435){//Temp
                    boardHex[r][c] = "CD03";

                }else if(board[r][c] == 543436){//Temp
                    boardHex[r][c] = "E003";

                }else if(board[r][c] == 543437){//Temp
                    boardHex[r][c] = "E103";

                }else if(board[r][c] == 543438){//Entrance temp testing
                    boardHex[r][c] = "CE01";
                    
                }else if(board[r][c] == 543439){//Entrance temp testing
                    boardHex[r][c] = "CF01";
                    
                }else if(board[r][c] == 543440){//Entrance temp testing
                    boardHex[r][c] = "6901";
                    
                }else if(board[r][c] == 543499){//Temp sand cliffs
                    boardHex[r][c] = "CF01";
                    
                }else if(board[r][c] == 5434100){//Temp sand cliffs
                    boardHex[r][c] = "BC02";

                }else if(board[r][c] == 5434101){//Temp sand cliffs
                    boardHex[r][c] = "D002";

                }else if(board[r][c] == 5434102){//Temp sand cliffs
                    boardHex[r][c] = "E702";

                }else if(board[r][c] == 5434103){//Temp sand cliffs
                    boardHex[r][c] = "2101";

                }else if(board[r][c] == 5434150){//Islands
                    boardHex[r][c] = "BC02";

                }else if(board[r][c] == 5434151){//Islands
                    boardHex[r][c] = "D002";

                }else if(board[r][c] == 5434152){//Islands
                    boardHex[r][c] = "E702";

                }else if(board[r][c] == 5434153){//Islands
                    boardHex[r][c] = "2101";
                    
                }else if(board[r][c] >= 0 && board[r][c] <= 799){
                    boardHex[r][c] = convertToHex(board[r][c], true);
                
                }else{
                    boardHex[r][c] = "0100";
                    
                }
            }  
        }
        
        return boardHex;
    }
    
    public static String[][] numberToHexSpecial(int[][] board, int boardR, int boardC){
        String[][] boardHexSpecial = new String[boardR][boardC];
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                boardHexSpecial[r][c] = convertToHex(board[r][c], true);
                
            }  
        }
        
        return boardHexSpecial;
    }
    
    public static void writeFileArray(String file, String[] output, int entries, int len) throws FileNotFoundException, IOException{
        FileOutputStream out = new FileOutputStream(file);
        
        for(int i = 0; i != entries; i++){
            for(int ii = 0; ii != len; ii++){
                out.write(output[i].charAt(ii));
                
            }
        }
        
        out.close();
    }
    
    public static void writeFile(String file, String output) throws FileNotFoundException, IOException{
        FileOutputStream out = new FileOutputStream(file);
        
        for(int i = 0; i != output.length(); i++){
            out.write(output.charAt(i));

        }
        
        out.close();
    }
    
    public static void checkPath(String path){
        File file = null;
        file = new File(path);
            
        if(!file.exists()){
            if(file.mkdir()){
                System.out.println("\n'" + path + "' folder created");

            }else{
                System.out.println("\nFailed to create '" + path + "'");

            }
        }
    }
    
    public static String convertToHex(int num, boolean reverse){
        String temp = "";
        String tempStart = "";
        String tempEnd = "";
        String toReturn = "";
        
        temp = Integer.toHexString(num);
        
        if(temp.length() == 1){
            toReturn = "000";
            toReturn += temp;
            
        }else if(temp.length() == 2){
            toReturn = "00";
            toReturn += temp;
            
        }else if(temp.length() == 3){
            toReturn = "0";
            toReturn += temp;
            
        }else{
            toReturn = temp;
            
        }
        
        if(reverse == true){
            tempStart = "";
            tempStart += toReturn.charAt(0);
            tempStart += toReturn.charAt(1);
            
            tempEnd += toReturn.charAt(2);
            tempEnd += toReturn.charAt(3);
            
            temp = tempEnd;
            temp += tempStart;
            
            toReturn = temp;
            
        }else{
            
        }
        
        return toReturn;
    }
    
    //https://www.mkyong.com/java/how-to-convert-hex-to-ascii-in-java/
    public static String convertStringHextoHex(String hex){
      StringBuilder sb = new StringBuilder();
      StringBuilder temp = new StringBuilder();

      //49204c6f7665204a617661 split into two characters 49, 20, 4c...
      for(int i = 0; i < (hex.length() - 1); i += 2){

          //grab the hex in pairs
          String output = hex.substring(i, (i + 2));
          //convert hex to decimal
          int decimal = Integer.parseInt(output, 16);
          //convert the decimal to character
          sb.append((char)decimal);

          temp.append(decimal);
      }

      return sb.toString();
    }
    
    //http://stackoverflow.com/questions/7250229/reading-a-binary-input-stream-into-a-single-byte-array-in-java
    public static byte[] readAIFile(String filename) throws FileNotFoundException, IOException{
        File file = new File(filename);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        
        dis.readFully(fileData);
        dis.close();
        
        //System.out.println(file.length());
        //System.out.println(fileData[0]);
        //System.out.println(fileData[(int) (file.length() - 1)]);
        return fileData;
    }
    
    //somewhere...
    public static String readFile(String filename) throws FileNotFoundException, IOException{
        InputStream in = new FileInputStream(new File(filename));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        
        String toReturn = "";
        
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        
        toReturn = out.toString();
        
        reader.close();
        
        return toReturn;
    }
    
    public static String exportMap(int[][] mainBoard, int boardR, int boardC, String exportName, String step, String time, String tileset, boolean addMis) throws FileNotFoundException, IOException{
        String[][] boardHex = new String[boardR][boardC];
        String[][] map = new String[boardR][boardC];
        String[][] mapSpecial = new String[boardR][boardC];
        String boardRHex = convertToHex(boardR, true);
        String boardCHex = convertToHex(boardC, true);
        String[] finalOutputArray = new String[((boardR * boardC) + (boardR * boardC)) + 2];
        int counter = 0;
        String iniOutput = "";
        String outputPath = "output";
        String finalOutputName = "";
        String stepToOutput = "";
        String[] misArray = new String[68066];
        String misOutputName = "";
        String tileatr = "";
        String temp = "";
        Ini tilesetListIni = null;
        int numberToUse = 0;
        char[] tilesetImageName = new char[200];
        char[] tilesetDataName = new char[200];
        boolean stopLooping = false;
        byte[] aiMis;
        String twoByte = "";
        String oneByte = "";
        int sandCount = 0;
        int rockCount = 0;
        int duneCount = 0;
        int spiceCount = 0;
        
        checkPath(outputPath);
        
        if(addMis == true && step.length() < 1){
            //get atr file 
            tilesetListIni = new Ini(new File("ini\\tilesets.ini"));
            for(int i = 1; i < 99; i++){
                if(stopLooping == false){
                    try{
                        temp = tilesetListIni.get("tilesets", String.valueOf(i)).toUpperCase();

                    }catch(NullPointerException e){
                        i = 999;
                    }

                    if(temp.matches(tileset)){
                        numberToUse = i;
                        stopLooping = true;

                    }
                }
            }

            tileatr = tilesetListIni.get("tiledata", String.valueOf(numberToUse)).toUpperCase();
            
            for(int i = 0; i != 200; i++){
                try{
                    tilesetImageName[i] = tileset.charAt(i);

                }catch(StringIndexOutOfBoundsException e){
                    tilesetImageName[i] += convertStringHextoHex("00").charAt(0);

                }
            }

            for(int i = 0; i != 200; i++){
                try{
                    tilesetDataName[i] = tileatr.charAt(i);

                }catch(StringIndexOutOfBoundsException e){
                    tilesetDataName[i] += convertStringHextoHex("00").charAt(0);

                }
            }

            aiMis = readAIFile("ini\\_spawn.MIS");

            //construct mis file
            //houseTechLevel
            counter = 0;
            for(int i = 0; i != 8; i++){
                misArray[counter] = convertStringHextoHex("01");
                counter++;

            }

            //startingMoney
            for(int i = 0; i != 8; i++){
                misArray[counter] = convertStringHextoHex("01");
                counter++;
                misArray[counter] = convertStringHextoHex("00");
                counter++;
                misArray[counter] = convertStringHextoHex("00");
                counter++;
                misArray[counter] = convertStringHextoHex("00");
                counter++;

            }

            //unknownRegion1
            for(int i = 0; i != 40; i++){
                misArray[counter] = convertStringHextoHex("00");
                counter++;

            }

            //houseIndexAllocation
            for(int i = 0; i != 8; i++){
                misArray[counter] = convertStringHextoHex("0" + "" + i);
                counter++;

            }

            //aiSections
            for(int i = 88; i != 60952; i++){
                //System.out.println(((int)aiMis[i]) & 0xff);
                //System.out.println( convertToHex(( (int)(aiMis[i]) & 0xff), true) );
                twoByte = convertToHex(((int)(aiMis[i]) & 0xff), true);
                //System.out.println(twoByte.charAt(0) + "" + twoByte.charAt(1));
                oneByte = twoByte.charAt(0) + "" + twoByte.charAt(1);
                misArray[counter] = convertStringHextoHex(oneByte);
                counter++;
                
            }


            //diplomacy
            for(int i = 0; i != 8; i++){
                for(int ii = 0; ii != 8; ii++){
                    if(i == ii){
                        misArray[counter] = convertStringHextoHex("00");
                        counter++;

                    }else{
                        misArray[counter] = convertStringHextoHex("01");
                        counter++;

                    }
                }
            }

            //events
            for(int i = 0; i != 64; i++){
                for(int ii = 0; ii != 72; ii++){
                    misArray[counter] = convertStringHextoHex("00");
                    counter++;

                }
            }

            //conditions
            for(int i = 0; i != 48; i++){
                for(int ii = 0; ii != 28; ii++){
                    misArray[counter] = convertStringHextoHex("00");
                    counter++;

                }
            }

            //tilesetImageName
            for(int i = 0; i != 200; i++){
                misArray[counter] = String.valueOf(tilesetImageName[i]);
                counter++;

            }

            //tilesetDataName
            for(int i = 0; i != 200; i++){
                misArray[counter] = String.valueOf(tilesetDataName[i]);
                counter++;

            }

            //eventCount
            misArray[counter] = convertStringHextoHex("00");
            counter++;
            
            //conditionCount
            misArray[counter] = convertStringHextoHex("00");
            counter++;

            //timeLimit
            misArray[counter] = convertStringHextoHex("FF");
            counter++;
            misArray[counter] = convertStringHextoHex("FF");
            counter++;
            misArray[counter] = convertStringHextoHex("FF");
            counter++;
            misArray[counter] = convertStringHextoHex("FF");
            counter++;

            //unknownRegion4
            for(int i = 0; i != 692; i++){
                misArray[counter] = convertStringHextoHex("00");
                counter++;

            }

            //save!
            if(!time.matches("-1")){
                misOutputName = (outputPath + "\\" + "_" + exportName + "-" + time + "" + step + ".mis");
                writeFileArray(misOutputName, misArray, 68066, 1);

            }else{
                misOutputName = (outputPath + "\\" + "_" +  exportName + "" + step + ".mis");
                writeFileArray(misOutputName, misArray, 68066, 1);

            }
            
            System.out.println("\n.mis file created");
        }
        
        //
        try{
            outputPath = readFile("ini\\dir.ini");
        
        }catch(FileNotFoundException e){
            System.out.println("\n'dir.ini' not found. Using default");
            
        }
        
        boardHex = numberToHexNonSpecial(mainBoard, boardR, boardC);
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                
                if(boardHex[r][c].matches(getSpawnHexAsNonSpecial())){
                    map[r][c] = getRandomRockHex();
                    mapSpecial[r][c] = getSpawnHexAsSpecial();
                    
                }else if(boardHex[r][c].matches(getWormSpawnHexAsNonSpecial())){
                    map[r][c] = getRandomSandHex();
                    mapSpecial[r][c] = getWormSpawnHexAsSpecial();
                    
                }else if(boardHex[r][c].matches(getBloomSpawnHexAsNonSpecial())){
                    map[r][c] = getRandomSandHex();
                    mapSpecial[r][c] = getBloomSpawnHexAsSpecial();
                    
                }else if(boardHex[r][c].matches(getSpiceLightHexAsNonSpecial())){
                    map[r][c] = getRandomSandHex();
                    mapSpecial[r][c] = getSpiceLightHexAsSpecial();
                    spiceCount++;
                    
                }else if(boardHex[r][c].matches(getSpiceHardHexAsNonSpecial())){
                    map[r][c] = getRandomSandHex();
                    mapSpecial[r][c] = getSpiceHardHexAsSpecial();
                    spiceCount++;
                    
                }else if(
                        boardHex[r][c].matches(getRockHex(0))
                        || boardHex[r][c].matches(getRockHex(1)) 
                        || boardHex[r][c].matches(getRockHex(2))
                        || boardHex[r][c].matches(getRockHex(3))
                        || boardHex[r][c].matches(getRockHex(4))
                        || boardHex[r][c].matches(getRockHex(5))
                        || boardHex[r][c].matches(getRockHex(6))
                        || boardHex[r][c].matches(getRockHex(7))
                        || boardHex[r][c].matches(getRockHex(8))
                        || boardHex[r][c].matches(getRockHex(9))
                        || boardHex[r][c].matches(getRockHex(10))
                        || boardHex[r][c].matches(getRockHex(11))
                        || boardHex[r][c].matches(getRockHex(12))
                        || boardHex[r][c].matches(getRockHex(13))
                        || boardHex[r][c].matches(getRockHex(14))
                        ){
                    map[r][c] = boardHex[r][c];
                    mapSpecial[r][c] = "0000";
                    rockCount++;
                    
                }else if(
                        boardHex[r][c].matches(getSandHex(0))
                        || boardHex[r][c].matches(getSandHex(1))
                        || boardHex[r][c].matches(getSandHex(2))
                        || boardHex[r][c].matches(getSandHex(3))
                        || boardHex[r][c].matches(getSandHex(4))
                        || boardHex[r][c].matches(getSandHex(5))
                        || boardHex[r][c].matches(getSandHex(6))
                        || boardHex[r][c].matches(getSandHex(7))
                        || boardHex[r][c].matches(getSandHex(8))
                        || boardHex[r][c].matches(getSandHex(9))
                        ){
                    map[r][c] = boardHex[r][c];
                    mapSpecial[r][c] = "0000";
                    sandCount++;
                    
                }else if(
                        boardHex[r][c].matches(getDuneHex(0))
                        || boardHex[r][c].matches(getDuneHex(1))
                        || boardHex[r][c].matches(getDuneHex(2))
                        || boardHex[r][c].matches(getDuneHex(3))
                        || boardHex[r][c].matches(getDuneHex(4))
                        || boardHex[r][c].matches(getDuneHex(5))
                        || boardHex[r][c].matches(getDuneHex(6))
                        || boardHex[r][c].matches(getDuneHex(7))
                        || boardHex[r][c].matches(getDuneHex(8))
                        ){
                    map[r][c] = boardHex[r][c];
                    mapSpecial[r][c] = "0000";
                    duneCount++;
                    
                }else{
                    map[r][c] = boardHex[r][c];
                    mapSpecial[r][c] = "0000";
                    
                }
            }  
        }
        
        //System.out.println("sandCount " + sandCount);
        //System.out.println("rockCount " + rockCount);
        //System.out.println("duneCount " + duneCount);
        //System.out.println("spiceCount " + spiceCount);
        
        counter = 0;
        
        finalOutputArray[counter] = boardRHex;
        counter++;
        finalOutputArray[counter] = boardCHex;
        counter++;
        
        for(int c = 0; c != boardC; c++){
            for(int r = 0; r != boardR; r++){
                finalOutputArray[counter] = map[r][c];
                counter++;
                finalOutputArray[counter] = mapSpecial[r][c];
                counter++;
                
            }
        }
        
        for(int i = 0; i != (((boardR * boardC) + (boardR * boardC)) + 2); i++){
            finalOutputArray[i] = convertStringHextoHex(finalOutputArray[i]);
                
        }
        
        if(step.length() >= 1){
            for(int i = 1; i != step.length(); i++){
                stepToOutput += step.charAt(i);

            }
            
        }else{
            stepToOutput = "Final";
            
        }
        
        checkPath(outputPath);

        System.out.println("\nExporting step - " + stepToOutput);
        
        
        if(!time.matches("-1")){
            System.out.println("Time = " + time);
            System.out.println(outputPath + "\\" + exportName + "-" + time + "" + step + ".map");
                
            
            finalOutputName = (outputPath + "\\" + exportName + "-" + time + "" + step + ".map");
            writeFileArray(finalOutputName, finalOutputArray, (((boardR * boardC) + (boardR * boardC)) + 2), 2);
            finalOutputName = (exportName + "-" + time + "" + step);
                        
        }else{
            System.out.println(outputPath + "\\" + exportName + "" + step + ".map");
                
            
            finalOutputName = (outputPath + "\\" + exportName + "" + step + ".map");
            writeFileArray(finalOutputName, finalOutputArray, (((boardR * boardC) + (boardR * boardC)) + 2), 2);
            finalOutputName = (exportName + "" + step);
            
        }
        
        iniOutput += ("[Basic]" + convertStringHextoHex("0D0A"));
        iniOutput += "Name=" + finalOutputName;
        writeFile((outputPath + "\\" + (finalOutputName) + ".ini"), iniOutput);
        
        return (outputPath + "\\" + exportName + "-" + time + "" + step + ".map");
    }
}
