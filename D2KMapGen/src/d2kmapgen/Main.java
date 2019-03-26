package d2kmapgen;

import static d2kmapgen.GenrateMap.*;
import static d2kmapgen.FileHandling.checkPath;
import static d2kmapgen.FileHandling.convertStringHextoHex;
import static d2kmapgen.FileHandling.exportMap;
import static d2kmapgen.FileHandling.readFile;
import static d2kmapgen.FileHandling.writeFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import org.ini4j.Ini;

public class Main {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static final int boardRDefault = 128;
    public static final int boardCDefault = 128;
    public static final String tilesetDefault = "BLOXBGBS";

    public static final int spaceBetweenPointsDefault = 32;
    public static final boolean autoSpaceSpawnsDefault = true;
    public static final boolean addMisDefault = true;
    public static final int broadSizeDefault = 8;
    public static final double rockFreqDefault = 0.35;
    public static final int numberAtATimeDivisorDefault = 2;
    public static final int squareTopDefault = 2;
    public static final int squareRightDefault = 1;
    public static final int squareBottomDefault = 1;
    public static final int squareLeftDefault = 1;
    
    public static final int numberOfBloomsDefault = 30;
    public static final int numberOfEmptyBloomsDefault = 72;
    public static final double spiceFreqDefault = 0.60;
    public static final int numberOfSpiceSquaresAtATimeDivisorDefault = 2;
    public static final int spiceSquareTopDefault = 1;
    public static final int spiceSquareRightDefault = 0;
    public static final int spiceSquareBottomDefault = 0;
    public static final int spiceSquareLeftDefault = 1;

    public static final int numberOfWormsDefault = 4;

    public static final int numberOfDuneStartsDefault = 16;
    public static final double duneFreqDefault = 0.20;
    public static final int numberOfDuneSquaresAtATimeDivisorDefault = 2;
    public static final int duneSquareTopDefault = 1;
    public static final int duneSquareRightDefault = 0;
    public static final int duneSquareBottomDefault = 0;
    public static final int duneSquareLeftDefault = 1;

    public static final int numberOfSpawnsToAddDefault = 10;
    public static final int scrambleSpawnRangeDefault = 6;

    public static final double sandSpecialFreqDefault = 0.004;
    public static final double rockSpecialFreqDefault = 0.004;
    public static final int infantryClimbsToAddDefault = 4;

    public static final int sandCliffsToAddDefault = 4;
    public static final int entranceSizeDefault = 5;

    public static final int numberOfIslandsToAddDefault = 12;
    public static final double islandFreqDefault = 0.20;
    public static final int numberOfIslandSquaresAtATimeDivisorDefault = 2;
    public static final int islandSquareTopDefault = 1;
    public static final int islandSquareRightDefault = 0;
    public static final int islandSquareBottomDefault = 0;
    public static final int islandSquareLeftDefault = 0;

    public static int boardR = boardRDefault;
    public static int boardC = boardCDefault;
    public static String tileset = tilesetDefault;

    public static int spaceBetweenPoints = spaceBetweenPointsDefault;
    public static boolean autoSpaceSpawns = autoSpaceSpawnsDefault;
    public static boolean addMis = addMisDefault;
    public static int broadSize = broadSizeDefault;
    public static int squareTop = squareTopDefault;
    public static int squareRight = squareRightDefault;
    public static int squareBottom = squareBottomDefault;
    public static int squareLeft = squareLeftDefault;
    public static double rockFreq = rockFreqDefault;
    public static int numberToAdd = (int)Math.ceil(((boardR * boardC) * rockFreq) / ((squareTop + 1 + squareBottom) * (squareLeft + 1 + squareRight)));
    public static int numberAtATimeDivisor = numberAtATimeDivisorDefault;
    public static int numberAtATime = (numberToAdd / numberAtATimeDivisor);
    
    public static int numberOfBlooms = numberOfBloomsDefault;
    public static int numberOfEmptyBlooms = numberOfEmptyBloomsDefault;
    public static int spiceSquareTop = spiceSquareTopDefault;
    public static int spiceSquareRight = spiceSquareRightDefault;
    public static int spiceSquareBottom = spiceSquareBottomDefault;
    public static int spiceSquareLeft = spiceSquareLeftDefault;
    public static double spiceFreq = spiceFreqDefault;
    public static int numberOfSpiceSquares = (int)Math.ceil(((boardR * boardC) * spiceFreq) / ((spiceSquareTop + 1 + spiceSquareBottom) * (spiceSquareLeft + 1 + spiceSquareRight)));
    public static int numberOfSpiceSquaresAtATimeDivisor = numberOfSpiceSquaresAtATimeDivisorDefault;
    public static int numberOfSpiceSquaresAtATime = (numberOfSpiceSquares / numberOfSpiceSquaresAtATimeDivisor);

    public static int numberOfWorms = numberOfWormsDefault;

    public static int numberOfDuneStarts = numberOfDuneStartsDefault;
    public static int duneSquareTop = duneSquareTopDefault;
    public static int duneSquareRight = duneSquareRightDefault;
    public static int duneSquareBottom = duneSquareBottomDefault;
    public static int duneSquareLeft = duneSquareLeftDefault;
    public static double duneFreq = duneFreqDefault;
    public static int numberOfDuneSquares = (int)Math.ceil(((boardR * boardC) * duneFreq) / ((duneSquareTop + 1 + duneSquareBottom) * (duneSquareLeft + 1 + duneSquareRight)));
    public static int numberOfDuneSquaresAtATimeDivisor = numberOfDuneSquaresAtATimeDivisorDefault;
    public static int numberOfDuneSquaresAtATime = (numberOfDuneSquares / numberOfDuneSquaresAtATimeDivisor);

    public static int numberOfSpawnsToAdd = numberOfSpawnsToAddDefault;
    public static int scrambleSpawnRange = scrambleSpawnRangeDefault;

    public static double sandSpecialFreq = sandSpecialFreqDefault;
    public static double rockSpecialFreq = rockSpecialFreqDefault;
    public static int infantryClimbsToAdd = infantryClimbsToAddDefault;

    public static int sandCliffsToAdd = sandCliffsToAddDefault;
    public static int entranceSize = entranceSizeDefault;

    public static int numberOfIslandsToAdd = numberOfIslandsToAddDefault;
    public static double islandFreq = islandFreqDefault;
    public static int islandSquareTop = islandSquareTopDefault;
    public static int islandSquareRight = islandSquareRightDefault;
    public static int islandSquareBottom = islandSquareBottomDefault;
    public static int islandSquareLeft = islandSquareLeftDefault;
    public static int numberOfIslandSquares = (int)Math.ceil(((boardR * boardC) * islandFreq) / ((islandSquareTop + 1 + islandSquareBottom) * (islandSquareLeft + 1 + islandSquareRight)));
    public static int numberOfIslandSquaresAtATimeDivisor = numberOfIslandSquaresAtATimeDivisorDefault;
    public static int numberOfIslandSquaresAtATime = (numberOfIslandSquares / numberOfIslandSquaresAtATimeDivisor);

    public static int[][] mainBoard = null;
    public static String[][] mainBoardAsHex = null;
    public static int[][] mainBoardSpecial = null;
    public static String[][] mainBoardSpecialAsHex = null;
    public static String exportName = "outputName";

    public static boolean exportAll = false;
    public static String logsPath = "logs";
    public static boolean exitImediatly = false;
    public static boolean useSettings = true;
    public static boolean addTimeStamp = true;

    public static String settingsFileName = "settings.ini";
    public static Ini settingsIni = null;
    public static boolean foundFile = true;
    
    public static String version = "170407";
    
    public static void header(){
        System.out.println("\n***************************");
        System.out.println("*D2K Map Generator v" + version + "*");
        System.out.println("***************************\n");
        
    }
    
    public static void refreshSettings(){
        boardR = boardRDefault;
        boardC = boardCDefault;
        tileset = tilesetDefault;

        spaceBetweenPoints = spaceBetweenPointsDefault;
        autoSpaceSpawns = autoSpaceSpawnsDefault;
        addMis = addMisDefault;
        broadSize = broadSizeDefault;
        rockFreq = rockFreqDefault;
        squareTop = squareTopDefault;
        squareRight = squareRightDefault;
        squareBottom = squareBottomDefault;
        squareLeft = squareLeftDefault;
        numberToAdd = (int)Math.ceil(((boardR * boardC) * rockFreq) / ((squareTop + 1 + squareBottom) * (squareLeft + 1 + squareRight)));
        numberAtATimeDivisor = numberAtATimeDivisorDefault;
        numberAtATime = (numberToAdd / numberAtATimeDivisor);
        
        numberOfBlooms = numberOfBloomsDefault;
        numberOfEmptyBlooms = numberOfEmptyBloomsDefault;
        spiceFreq = spiceFreqDefault;
        spiceSquareTop = spiceSquareTopDefault;
        spiceSquareRight = spiceSquareRightDefault;
        spiceSquareBottom = spiceSquareBottomDefault;
        spiceSquareLeft = spiceSquareLeftDefault;
        numberOfSpiceSquares = (int)Math.ceil(((boardR * boardC) * spiceFreq) / ((spiceSquareTop + 1 + spiceSquareBottom) * (spiceSquareLeft + 1 + spiceSquareRight)));
        numberOfSpiceSquaresAtATimeDivisor = numberOfSpiceSquaresAtATimeDivisorDefault;
        numberOfSpiceSquaresAtATime = (numberOfSpiceSquares / numberOfSpiceSquaresAtATimeDivisor);

        numberOfWorms = numberOfWormsDefault;

        numberOfDuneStarts = numberOfDuneStartsDefault;
        duneFreq = duneFreqDefault;
        duneSquareTop = duneSquareTopDefault;
        duneSquareRight = duneSquareRightDefault;
        duneSquareBottom = duneSquareBottomDefault;
        duneSquareLeft = duneSquareLeftDefault;
        numberOfDuneSquares = (int)Math.ceil(((boardR * boardC) * duneFreq) / ((duneSquareTop + 1 + duneSquareBottom) * (duneSquareLeft + 1 + duneSquareRight)));
        numberOfDuneSquaresAtATimeDivisor = numberOfDuneSquaresAtATimeDivisorDefault;
        numberOfDuneSquaresAtATime = (numberOfDuneSquares / numberOfDuneSquaresAtATimeDivisor);

        numberOfSpawnsToAdd = numberOfSpawnsToAddDefault;
        scrambleSpawnRange = scrambleSpawnRangeDefault;

        sandSpecialFreq = sandSpecialFreqDefault;
        rockSpecialFreq = rockSpecialFreqDefault;
        infantryClimbsToAdd = infantryClimbsToAddDefault;

        sandCliffsToAdd = sandCliffsToAddDefault;
        entranceSize = entranceSizeDefault;

        numberOfIslandsToAdd = numberOfIslandsToAddDefault;
        islandFreq = islandFreqDefault;
        islandSquareTop = islandSquareTopDefault;
        islandSquareRight = islandSquareRightDefault;
        islandSquareBottom = islandSquareBottomDefault;
        islandSquareLeft = islandSquareLeftDefault;
        numberOfIslandSquares = (int)Math.ceil(((boardR * boardC) * islandFreq) / ((islandSquareTop + 1 + islandSquareBottom) * (islandSquareLeft + 1 + islandSquareRight)));
        numberOfIslandSquaresAtATimeDivisor = numberOfIslandSquaresAtATimeDivisorDefault;
        numberOfIslandSquaresAtATime = (numberOfIslandSquares / numberOfIslandSquaresAtATimeDivisor);

        mainBoard = null;
        mainBoardAsHex = null;
        exportName = "outputName";

        exportAll = false;
        logsPath = "logs";
        exitImediatly = false;
        useSettings = true;
        addTimeStamp = true;

        settingsFileName = "settings.ini";
        settingsIni = null;
        foundFile = true;

    }
    
    public static void printSettings(){
        String screenOutput = "";
        
        screenOutput += "boardR = " + boardR + ", ";
        screenOutput += "boardC = " + boardC + ", ";
        screenOutput += "tileset = " + tileset + ", ";
        screenOutput += "numberOfSpawnsToAdd = " + numberOfSpawnsToAdd + ", ";
        screenOutput += "scrambleSpawnRange = " + scrambleSpawnRange + ", ";
        screenOutput += "spaceBetweenPoints = " + spaceBetweenPoints + ", ";
        screenOutput += "broadSize = " + broadSize + ", ";
        screenOutput += "rockFreq = " + rockFreq + ", ";
        screenOutput += "numberAtATimeDivisor = " + numberAtATimeDivisor + ", ";
        screenOutput += "squareTop = " + squareTop + ", ";
        screenOutput += "squareRight = " + squareRight + ", ";
        screenOutput += "squareBottom = " + squareBottom + ", ";
        screenOutput += "squareLeft = " + squareLeft + ", ";
        screenOutput += "numberOfBlooms = " + numberOfBlooms + ", ";
        screenOutput += "numberOfEmptyBlooms = " + numberOfEmptyBlooms + ", ";
        screenOutput += "spiceFreq = " + spiceFreq + ", ";
        screenOutput += "numberOfSpiceSquaresAtATimeDivisor = " + numberOfSpiceSquaresAtATimeDivisor + ", ";
        screenOutput += "spiceSquareTop = " + spiceSquareTop + ", ";
        screenOutput += "spiceSquareRight = " + spiceSquareRight + ", ";
        screenOutput += "spiceSquareBottom = " + spiceSquareBottom + ", ";
        screenOutput += "spiceSquareLeft = " + spiceSquareLeft + ", ";
        screenOutput += "numberOfWorms = " + numberOfWorms + ", ";
        screenOutput += "numberOfDuneStarts = " + numberOfDuneStarts + ", ";
        screenOutput += "duneFreq = " + duneFreq + ", ";
        screenOutput += "numberOfDuneSquaresAtATimeDivisor = " + numberOfDuneSquaresAtATimeDivisor + ", ";
        screenOutput += "duneSquareTop = " + duneSquareTop + ", ";
        screenOutput += "duneSquareRight = " + duneSquareRight + ", ";
        screenOutput += "duneSquareBottom = " + duneSquareBottom + ", ";
        screenOutput += "duneSquareLeft = " + duneSquareLeft + ", ";
        screenOutput += "numberOfIslandsToAdd = " + numberOfIslandsToAdd + ", ";
        screenOutput += "islandFreq = " + islandFreq + ", ";
        screenOutput += "numberOfIslandSquaresAtATimeDivisor = " + numberOfIslandSquaresAtATimeDivisor + ", ";
        screenOutput += "islandSquareTop = " + islandSquareTop + ", ";
        screenOutput += "islandSquareRight = " + islandSquareRight + ", ";
        screenOutput += "islandSquareBottom = " + islandSquareBottom + ", ";
        screenOutput += "islandSquareLeft = " + islandSquareLeft + ", ";
        screenOutput += "sandSpecialFreq = " + sandSpecialFreq + ", ";
        screenOutput += "rockSpecialFreq = " + rockSpecialFreq + ", ";
        screenOutput += "infantryClimbsToAdd = " + infantryClimbsToAdd + ", ";
        screenOutput += "exportName = " + exportName + ", ";
        screenOutput += "exportAll = " + exportAll + ", ";
        screenOutput += "exitImediatly = " + exitImediatly + ", ";
        screenOutput += "useSettings = " + useSettings + ", ";
        screenOutput += "addTimeStamp = " + addTimeStamp + ", ";
        screenOutput += "autoSpaceSpawns = " + autoSpaceSpawns + ", ";
        screenOutput += "addMis = " + addMis;

        System.out.println(screenOutput);
        
    }
    
    public static void writeLogFile(String time) throws IOException{
        String logOutput = "";
        
        try{
            logsPath = readFile("ini\\dir2.ini");

        }catch(FileNotFoundException e){
            System.out.println("\n'dir2.ini' not found. Using default");

        }

        logOutput += "[general]" + convertStringHextoHex("0D0A");
        logOutput += "exportName = " + exportName + convertStringHextoHex("0D0A");
        logOutput += "exportAll = " + exportAll + convertStringHextoHex("0D0A");
        logOutput += "exitImediatly = " + exitImediatly + convertStringHextoHex("0D0A");
        logOutput += "useSettings = " + useSettings + convertStringHextoHex("0D0A");
        logOutput += "addTimeStamp = " + addTimeStamp + convertStringHextoHex("0D0A");
        logOutput += "addMis = " + addMis + convertStringHextoHex("0D0A");
        logOutput += convertStringHextoHex("0D0A");
        logOutput += "[map]" + convertStringHextoHex("0D0A");
        logOutput += "boardR = " + boardR + convertStringHextoHex("0D0A");
        logOutput += "boardC = " + boardC + convertStringHextoHex("0D0A");
        logOutput += "tileset = " + tileset + convertStringHextoHex("0D0A");
        logOutput += "numberOfSpawnsToAdd = " + numberOfSpawnsToAdd + convertStringHextoHex("0D0A");
        logOutput += "scrambleSpawnRange = " + scrambleSpawnRange + convertStringHextoHex("0D0A");
        logOutput += "spaceBetweenPoints = " + spaceBetweenPoints + convertStringHextoHex("0D0A");
        logOutput += "autoSpaceSpawns = " + autoSpaceSpawns + convertStringHextoHex("0D0A");
        logOutput += convertStringHextoHex("0D0A");
        logOutput += "[rock]" + convertStringHextoHex("0D0A");
        logOutput += "broadSize = " + broadSize + convertStringHextoHex("0D0A");
        logOutput += "rockFreq = " + rockFreq + convertStringHextoHex("0D0A");
        logOutput += "numberAtATimeDivisor = " + numberAtATimeDivisor + convertStringHextoHex("0D0A");
        logOutput += "squareTop = " + squareTop + convertStringHextoHex("0D0A");
        logOutput += "squareRight = " + squareRight + convertStringHextoHex("0D0A");
        logOutput += "squareBottom = " + squareBottom + convertStringHextoHex("0D0A");
        logOutput += "squareLeft = " + squareLeft + convertStringHextoHex("0D0A");
        logOutput += convertStringHextoHex("0D0A");
        logOutput += "[spice]" + convertStringHextoHex("0D0A");
        logOutput += "numberOfBlooms = " + numberOfBlooms + convertStringHextoHex("0D0A");
        logOutput += "numberOfEmptyBlooms = " + numberOfEmptyBlooms + convertStringHextoHex("0D0A");
        logOutput += "spiceFreq = " + spiceFreq + convertStringHextoHex("0D0A");
        logOutput += "numberOfSpiceSquaresAtATimeDivisor = " + numberOfSpiceSquaresAtATimeDivisor + convertStringHextoHex("0D0A");
        logOutput += "spiceSquareTop = " + spiceSquareTop + convertStringHextoHex("0D0A");
        logOutput += "spiceSquareRight = " + spiceSquareRight + convertStringHextoHex("0D0A");
        logOutput += "spiceSquareBottom = " + spiceSquareBottom + convertStringHextoHex("0D0A");
        logOutput += "spiceSquareLeft = " + spiceSquareLeft + convertStringHextoHex("0D0A");
        logOutput += convertStringHextoHex("0D0A");
        logOutput += "[dunes]" + convertStringHextoHex("0D0A");
        logOutput += "numberOfDuneStarts = " + numberOfDuneStarts + convertStringHextoHex("0D0A");
        logOutput += "duneFreq = " + duneFreq + convertStringHextoHex("0D0A");
        logOutput += "numberOfDuneSquaresAtATimeDivisor = " + numberOfDuneSquaresAtATimeDivisor + convertStringHextoHex("0D0A");
        logOutput += "duneSquareTop = " + duneSquareTop + convertStringHextoHex("0D0A");
        logOutput += "duneSquareRight = " + duneSquareRight + convertStringHextoHex("0D0A");
        logOutput += "duneSquareBottom = " + duneSquareBottom + convertStringHextoHex("0D0A");
        logOutput += "duneSquareLeft = " + duneSquareLeft + convertStringHextoHex("0D0A");
        logOutput += convertStringHextoHex("0D0A");
        logOutput += "[rock chunks]" + convertStringHextoHex("0D0A");
        logOutput += "numberOfIslandsToAdd = " + numberOfIslandsToAdd + convertStringHextoHex("0D0A");
        logOutput += "islandFreq = " + islandFreq + convertStringHextoHex("0D0A");
        logOutput += "numberOfIslandSquaresAtATimeDivisor = " + numberOfIslandSquaresAtATimeDivisor + convertStringHextoHex("0D0A");
        logOutput += "islandSquareTop = " + islandSquareTop + convertStringHextoHex("0D0A");
        logOutput += "islandSquareRight = " + islandSquareRight + convertStringHextoHex("0D0A");
        logOutput += "islandSquareBottom = " + islandSquareBottom + convertStringHextoHex("0D0A");
        logOutput += "islandSquareLeft = " + islandSquareLeft + convertStringHextoHex("0D0A");
        logOutput += convertStringHextoHex("0D0A");
        logOutput += "[other]" + convertStringHextoHex("0D0A");
        logOutput += "numberOfWorms = " + numberOfWorms + convertStringHextoHex("0D0A");
        logOutput += "sandSpecialFreq = " + sandSpecialFreq + convertStringHextoHex("0D0A");
        logOutput += "rockSpecialFreq = " + rockSpecialFreq + convertStringHextoHex("0D0A");
        logOutput += "infantryClimbsToAdd = " + infantryClimbsToAdd + convertStringHextoHex("0D0A");

        checkPath(logsPath);
        if(addTimeStamp == true){
            writeFile((logsPath + "\\" + exportName + "-" + time + ".log"), logOutput);

        }else{
            writeFile((logsPath + "\\" + exportName + ".log"), logOutput);

        }
    }
    
    public static int autoEq(int boardR, int boardC, int var){
        final double percentDiff = 1.33;        
    
        return (int)(Math.ceil((((double)(boardR * boardC) / (double)(128 * 128)) * var) * percentDiff) );
        
    }
    
    public static void auto(){
        numberOfSpawnsToAdd = autoEq(boardR, boardC, numberOfSpawnsToAddDefault);
        scrambleSpawnRange = autoEq(boardR, boardC, scrambleSpawnRangeDefault);
        spaceBetweenPoints = autoEq(boardR, boardC, spaceBetweenPointsDefault);
        broadSize = autoEq(boardR, boardC, broadSizeDefault);
        numberToAdd = (int)Math.ceil(((boardR * boardC) * rockFreq) / ((squareTop + 1 + squareBottom) * (squareLeft + 1 + squareRight)));
        numberOfBlooms = autoEq(boardR, boardC, numberOfBloomsDefault);
        numberOfEmptyBlooms = autoEq(boardR, boardC, numberOfEmptyBloomsDefault);
        numberOfSpiceSquares = (int)Math.ceil(((boardR * boardC) * spiceFreq) / ((spiceSquareTop + 1 + spiceSquareBottom) * (spiceSquareLeft + 1 + spiceSquareRight)));
        numberOfWorms = autoEq(boardR, boardC, numberOfWormsDefault);
        numberOfDuneStarts = autoEq(boardR, boardC, numberOfDuneStartsDefault);
        numberOfDuneSquares = (int)Math.ceil(((boardR * boardC) * duneFreq) / ((duneSquareTop + 1 + duneSquareBottom) * (duneSquareLeft + 1 + duneSquareRight)));
        numberOfIslandsToAdd = autoEq(boardR, boardC, numberOfIslandsToAddDefault);
        numberOfIslandSquares = (int)Math.ceil(((boardR * boardC) * islandFreq) / ((islandSquareTop + 1 + islandSquareBottom) * (islandSquareLeft + 1 + islandSquareRight)));
        infantryClimbsToAdd = autoEq(boardR, boardC, infantryClimbsToAddDefault);

        if(numberOfSpawnsToAdd > numberOfSpawnsToAddDefault){
            numberOfSpawnsToAdd = numberOfSpawnsToAddDefault;

        }

        if(scrambleSpawnRange > scrambleSpawnRangeDefault){
            scrambleSpawnRange = scrambleSpawnRangeDefault;

        }

        if(spaceBetweenPoints > spaceBetweenPointsDefault){
            spaceBetweenPoints = spaceBetweenPointsDefault;

        }

        if(broadSize > broadSizeDefault){
            broadSize = broadSizeDefault;

        }

        if(numberOfBlooms > numberOfBloomsDefault){
            numberOfBlooms = numberOfBloomsDefault;

        }

        if(numberOfEmptyBlooms > numberOfEmptyBloomsDefault){
            numberOfEmptyBlooms = numberOfEmptyBloomsDefault;

        }

        if(numberOfWorms > numberOfWormsDefault){
            numberOfWorms = numberOfWormsDefault;

        }

        if(numberOfDuneStarts > numberOfDuneStartsDefault){
            numberOfDuneStarts = numberOfDuneStartsDefault;

        }

        if(numberOfIslandsToAdd > numberOfIslandsToAddDefault){
            numberOfIslandsToAdd = numberOfIslandsToAddDefault;

        }

        if(infantryClimbsToAdd > infantryClimbsToAddDefault){
            infantryClimbsToAdd = infantryClimbsToAddDefault;

        }
    }
    
    public static void autoRefreshBatches(){
        numberAtATime = (numberToAdd / numberAtATimeDivisor);
        numberOfSpiceSquaresAtATime = (numberOfSpiceSquares / numberOfSpiceSquaresAtATimeDivisor);
        numberOfDuneSquaresAtATime = (numberOfDuneSquares / numberOfDuneSquaresAtATimeDivisor);
        numberOfIslandSquaresAtATime = (numberOfIslandSquares / numberOfIslandSquaresAtATimeDivisor);
        
    }
    
    public static String[] setSettingsState0() throws IOException{
        String time = String.valueOf(System.currentTimeMillis());
        
        try{
            settingsIni = new Ini(new File(settingsFileName));
            foundFile = true;

        }catch(FileNotFoundException e){
            System.out.println("\n'" + settingsFileName + "' not found. Using defaults");
            foundFile = false;

        }

        if(foundFile == true){
            try{
                boardR = settingsIni.get("map", "boardR", int.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'boardR', using system default");

            }
            try{
                boardC = settingsIni.get("map", "boardC", int.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'boardC', using system default");

            }
            try{
                tileset = settingsIni.get("map", "tileset").toUpperCase();

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'tileset', using system default");

            }
            try{
                useSettings = settingsIni.get("general", "useSettings", boolean.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'useSettings', using system default");

            }
            try{
                addTimeStamp = settingsIni.get("general", "addTimeStamp", boolean.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'addTimeStamp', using system default");

            }
            try{
                exportName = settingsIni.get("general", "exportName");

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'exportName', using system default");

            }
            try{
                exportAll = settingsIni.get("general", "exportAll", boolean.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'exportAll', using system default");

            }
            try{
                exitImediatly = settingsIni.get("general", "exitImediatly", boolean.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'exitImediatly', using system default");

            }
            try{
                autoSpaceSpawns = settingsIni.get("map", "autoSpaceSpawns", boolean.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'autoSpaceSpawns', using system default");

            }

            try{
                addMis = settingsIni.get("general", "addMis", boolean.class);

            }catch(IllegalArgumentException e){
                System.out.println("Invalid setting 'addMis', using system default");

            }

            if(useSettings == true){
                try{
                    numberOfSpawnsToAdd = settingsIni.get("map", "numberOfSpawnsToAdd", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfSpawnsToAdd', using system default");

                }
                try{
                    scrambleSpawnRange = settingsIni.get("map", "scrambleSpawnRange", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'scrambleSpawnRange', using system default");

                }
                try{
                    spaceBetweenPoints = settingsIni.get("map", "spaceBetweenPoints", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'spaceBetweenPoints', using system default");

                }
                try{
                    broadSize = settingsIni.get("rock", "broadSize", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'broadSize', using system default");

                }
                try{
                    squareTop = settingsIni.get("rock", "squareTop", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'squareTop', using system default");

                }
                try{
                    squareRight = settingsIni.get("rock", "squareRight", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'squareRight', using system default");

                }
                try{
                    squareBottom = settingsIni.get("rock", "squareBottom", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'squareBottom', using system default");

                }
                try{
                    squareLeft = settingsIni.get("rock", "squareLeft", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'squareLeft', using system default");

                }
                try{
                    rockFreq = settingsIni.get("rock", "rockFreq", double.class);
                    numberToAdd = (int)Math.ceil(((boardR * boardC) * rockFreq) / ((squareTop + 1 + squareBottom) * (squareLeft + 1 + squareRight)));

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'rockFreq', using system default");
                    numberToAdd = (int)Math.ceil(((boardR * boardC) * rockFreq) / ((squareTop + 1 + squareBottom) * (squareLeft + 1 + squareRight)));
                    
                }
                try{
                    numberAtATimeDivisor = settingsIni.get("rock", "numberAtATimeDivisor", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberAtATimeDivisor', using system default");

                }
                try{
                    numberOfBlooms = settingsIni.get("spice", "numberOfBlooms", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfBlooms', using system default");

                }
                try{
                    numberOfEmptyBlooms = settingsIni.get("spice", "numberOfEmptyBlooms", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfEmptyBlooms', using system default");

                }
                try{
                    spiceSquareTop = settingsIni.get("spice", "spiceSquareTop", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'spiceSquareTop', using system default");

                }
                try{
                    spiceSquareRight = settingsIni.get("spice", "spiceSquareRight", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'spiceSquareRight', using system default");

                }
                try{
                    spiceSquareBottom = settingsIni.get("spice", "spiceSquareBottom", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'spiceSquareBottom', using system default");

                }
                try{
                    spiceSquareLeft = settingsIni.get("spice", "spiceSquareLeft", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'spiceSquareLeft', using system default");

                }
                try{
                    spiceFreq = settingsIni.get("spice", "spiceFreq", double.class);
                    numberOfSpiceSquares = (int)Math.ceil(((boardR * boardC) * spiceFreq) / ((spiceSquareTop + 1 + spiceSquareBottom) * (spiceSquareLeft + 1 + spiceSquareRight)));

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'spiceFreq', using system default");
                    numberOfSpiceSquares = (int)Math.ceil(((boardR * boardC) * spiceFreq) / ((spiceSquareTop + 1 + spiceSquareBottom) * (spiceSquareLeft + 1 + spiceSquareRight)));
                    
                }
                try{
                    numberOfSpiceSquaresAtATimeDivisor = settingsIni.get("spice", "numberOfSpiceSquaresAtATimeDivisor", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfSpiceSquaresAtATimeDivisor', using system default");

                }
                try{
                    numberOfWorms = settingsIni.get("other", "numberOfWorms", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfWorms', using system default");

                }
                try{
                    numberOfDuneStarts = settingsIni.get("dunes", "numberOfDuneStarts", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfDuneStarts', using system default");

                }
                try{
                    duneSquareTop = settingsIni.get("dunes", "duneSquareTop", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'duneSquareTop', using system default");

                }
                try{
                    duneSquareRight = settingsIni.get("dunes", "duneSquareRight", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'duneSquareRight', using system default");

                }
                try{
                    duneSquareBottom = settingsIni.get("dunes", "duneSquareBottom", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'duneSquareBottom', using system default");

                }
                try{
                    duneSquareLeft = settingsIni.get("dunes", "duneSquareLeft", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'duneSquareLeft', using system default");

                }
                try{
                    duneFreq = settingsIni.get("dunes", "duneFreq", double.class);
                    numberOfDuneSquares = (int)Math.ceil(((boardR * boardC) * duneFreq) / ((duneSquareTop + 1 + duneSquareBottom) * (duneSquareLeft + 1 + duneSquareRight)));

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'duneFreq', using system default");
                    numberOfDuneSquares = (int)Math.ceil(((boardR * boardC) * duneFreq) / ((duneSquareTop + 1 + duneSquareBottom) * (duneSquareLeft + 1 + duneSquareRight)));

                }
                try{
                    numberOfDuneSquaresAtATimeDivisor = settingsIni.get("dunes", "numberOfDuneSquaresAtATimeDivisor", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfDuneSquaresAtATimeDivisor', using system default");

                }
                try{
                    numberOfIslandsToAdd = settingsIni.get("rock chunks", "numberOfIslandsToAdd", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfIslandsToAdd', using system default");

                }
                try{
                    islandSquareTop = settingsIni.get("rock chunks", "islandSquareTop", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'islandSquareTop', using system default");

                }
                try{
                    islandSquareRight = settingsIni.get("rock chunks", "islandSquareRight", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'islandSquareRight', using system default");

                }
                try{
                    islandSquareBottom = settingsIni.get("rock chunks", "islandSquareBottom", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'islandSquareBottom', using system default");

                }
                try{
                    islandSquareLeft = settingsIni.get("rock chunks", "islandSquareLeft", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'islandSquareLeft', using system default");

                }
                try{
                    islandFreq = settingsIni.get("rock chunks", "islandFreq", double.class);
                    numberOfIslandSquares = (int)Math.ceil(((boardR * boardC) * islandFreq) / ((islandSquareTop + 1 + islandSquareBottom) * (islandSquareLeft + 1 + islandSquareRight)));

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'islandFreq', using system default");
                    numberOfIslandSquares = (int)Math.ceil(((boardR * boardC) * islandFreq) / ((islandSquareTop + 1 + islandSquareBottom) * (islandSquareLeft + 1 + islandSquareRight)));

                }
                try{
                    numberOfIslandSquaresAtATimeDivisor = settingsIni.get("rock chunks", "numberOfIslandSquaresAtATimeDivisor", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'numberOfIslandSquaresAtATimeDivisor', using system default");

                }
                try{
                    sandSpecialFreq = settingsIni.get("other", "sandSpecialFreq", double.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'sandSpecialFreq', using system default");

                }
                try{
                    rockSpecialFreq = settingsIni.get("other", "rockSpecialFreq", double.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'rockSpecialFreq', using system default");

                }
                try{
                    infantryClimbsToAdd = settingsIni.get("other", "infantryClimbsToAdd", int.class);

                }catch(IllegalArgumentException e){
                    System.out.println("Invalid setting 'infantryClimbsToAdd', using system default");

                }

                autoRefreshBatches();

            }else{
                auto();
                autoRefreshBatches();

            }

            writeLogFile(time);

        }else{
            checkPath(logsPath);
            writeFile((logsPath + "\\" + exportName + "-" + time + ".log"), ("Error reading 'settings.ini'"));

        }
        
        return createBoard(time);
    }
    
    public static String[] setSettingsState1(String[] settings) throws IOException{
        String time = String.valueOf(System.currentTimeMillis());
        boardR = Integer.parseInt(settings[0]);
        boardC = Integer.parseInt(settings[1]);
        tileset = settings[2];
        addTimeStamp = Boolean.parseBoolean(settings[3]);
        exportName = settings[4];
        autoSpaceSpawns = Boolean.parseBoolean(settings[5]);
        addMis = Boolean.parseBoolean(settings[6]);
        exportAll = false;
        exitImediatly = true;

        auto();
        autoRefreshBatches();
        writeLogFile(time);
        
        return createBoard(time);
    }
    
    public static String[] createBoard(String time) throws IOException{
        DecimalFormat format = new DecimalFormat("0.000");
        String endTime;
        String[] toReturn = new String[3];
        String timeEnd;
        String timeToUse = time;
        
        header();
        printSettings();
        
        mainBoard = new int[boardR][boardC];
        mainBoardAsHex = new String[boardR][boardC];
        String string;
        
        if(addTimeStamp == true){
            
        }else{
            time = "-1";
            
        }
        
        mainBoard = fillWithSand(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-1 fillWithSand", time, tileset, addMis);
            
        }
        System.out.println("\nMap prepared");
        
        if(autoSpaceSpawns == true){
            mainBoard = autoSpaceSpawns(mainBoard, boardR, boardC, numberOfSpawnsToAdd);

        }else{
            mainBoard = addSpawnMarkers(mainBoard, boardR, boardC, spaceBetweenPoints, numberOfSpawnsToAdd);
            
        }
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-2 addSpawnMarkers", time, tileset, addMis);
            
        }
        System.out.println("\nPlayer spawns added");

        mainBoard = addRockPlains(mainBoard, boardR, boardC, broadSize);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-3 addRockPlains", time, tileset, addMis);
            
        }
        System.out.println("\nRock plains added");
        
        mainBoard = addRockSquares(mainBoard, boardR, boardC, numberToAdd, squareTop, squareRight, squareBottom, squareLeft, numberAtATime);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-4 addSquares", time, tileset, addMis);
            
        }
        System.out.println("\nRock squares added");
        
        for(int i = 0; i != 4; i++){
            mainBoard = removeGaps(mainBoard, boardR, boardC);
            mainBoard = removeEdgeGaps(mainBoard, boardR, boardC);
            mainBoard = checkSpacingDiagonally(mainBoard, boardR, boardC);
        }
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-5 after_cleaning", time, tileset, addMis);

        }
        System.out.println("\nRock plains cleaned");
        
        mainBoard = addEntrances(mainBoard, boardR, boardC, 5); 
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-6 addEntrances", time, tileset, addMis);
            
        }
        System.out.println("\nEntrances added");
        
        mainBoard = checkForEntrances(mainBoard, boardR, boardC, 2); 
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-7 checkForEntrances", time, tileset, addMis);
            
        }
        System.out.println("\nEntrances checked");
            
        mainBoard = reapplyEntranceEdges(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-8 reapplyEntranceEdges", time, tileset, addMis);
            
        }
        System.out.println("\nEntrances edges reapplyed");
            
        for(int i = 0; i != 4; i++){
            mainBoard = removeGaps(mainBoard, boardR, boardC);
            mainBoard = removeEdgeGaps(mainBoard, boardR, boardC);
            mainBoard = checkSpacingDiagonally(mainBoard, boardR, boardC);
        }
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-9 after_cleaning2", time, tileset, addMis);

        }
        System.out.println("\nRock plains cleaned");
        
        mainBoard = reapplyEntranceEdges(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-10 reapplyEntranceEdges", time, tileset, addMis);
            
        }
        System.out.println("\nEntrances edges reapplyed");
        
        mainBoard = reapplyEntranceEdgesSimple(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-11 reapplyEntranceEdgesSimple", time, tileset, addMis);
            
        }
        System.out.println("\nEntrances edges reapplyed (simple)");
        
        mainBoard = addInfantryClimbs(mainBoard, boardR, boardC, infantryClimbsToAdd, tileset);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-12 addInfantryClimbs", time, tileset, addMis);
            
        }
        System.out.println("\nInfantry climbs added");
        
        mainBoard = addInnerCorners(mainBoard, boardR, boardC);
        mainBoard = addInnerCornersAndReplace(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-14 addInnerCorners", time, tileset, addMis);
            
        }
        System.out.println("\nInner corners added");
        
        mainBoard = addDiagonalsA(mainBoard, boardR, boardC, tileset, infantryClimbsToAdd);
        mainBoard = addDiagonalsB(mainBoard, boardR, boardC, tileset, infantryClimbsToAdd);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-15 addDiagonals", time, tileset, addMis);
            
        }
        System.out.println("\nDiagonals added");
        
        mainBoard = addCornersReduced(mainBoard, boardR, boardC, tileset);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-16 addCornersReduced", time, tileset, addMis);
            
        }
        System.out.println("\nCorners added (reduced)");
        
        mainBoard = addCliffMarkers(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-17 addCliffMarkers", time, tileset, addMis);
            
        }
        System.out.println("\nCliff markers added");
        
        mainBoard = paintCliffs(mainBoard, boardR, boardC, tileset);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-18 paintCliffs", time, tileset, addMis);
            
        }
        System.out.println("\nCliffs added");
        
        mainBoard = addSmallCliffs(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-19 addSmallCliffs", time, tileset, addMis);
            
        }
        System.out.println("\nSmall cliffs added");
        
        mainBoard = addCornersReducedSimple(mainBoard, boardR, boardC, tileset);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-20 addCornersReducedSimple", time, tileset, addMis);
            
        }
        System.out.println("\nCorners added (reduced simple)");
        
        mainBoard = addIslands(mainBoard, boardR, boardC, numberOfIslandsToAdd, numberOfIslandSquares, islandSquareTop, islandSquareRight, islandSquareBottom, islandSquareLeft, numberOfIslandSquaresAtATime);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-21 addIslands", time, tileset, addMis);
            
        }
        System.out.println("\nIslands added");
        
        mainBoard = paintEntranceEdges(mainBoard, boardR, boardC, tileset);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-22 paintEntranceEdges", time, tileset, addMis);
            
        }
        System.out.println("\nRock-to-sand edges added");//System.out.println("\nEntrances edges added");
        
//        mainBoard = addSandCliffs(mainBoard, boardR, boardC, 5);
//        if(exportAll == true){
//            mainBoardAsHex = numberToHexNonSpecial(mainBoard, boardR, boardC);
//            exportMap(mainBoard, boardR, boardC, exportName, "-15 addSpecials", time, randVar);
//            
//        }
        
        mainBoard = addSpecials(mainBoard, boardR, boardC, sandSpecialFreq, rockSpecialFreq, tileset);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-23 addSpecials", time, tileset, addMis);
            
        }
        System.out.println("\nSpecials added");
        
        mainBoard = addDunes(mainBoard, boardR, boardC, numberOfDuneStarts, numberOfDuneSquares, duneSquareTop, duneSquareRight, duneSquareBottom, duneSquareLeft, numberOfDuneSquaresAtATime);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-24 addDunes", time, tileset, addMis);
            
        }
        System.out.println("\nDunes added");
        
        mainBoard = addSpice(mainBoard, boardR, boardC, numberOfBlooms, numberOfEmptyBlooms, numberOfSpiceSquares, spiceSquareTop, spiceSquareRight, spiceSquareBottom, spiceSquareLeft, numberOfSpiceSquaresAtATime);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-25 addSpice", time, tileset, addMis);
            
        }
        System.out.println("\nSpice added");

        mainBoard = addWorms(mainBoard, boardR, boardC, numberOfWorms);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-26 addWorms", time, tileset, addMis);
            
        }
        System.out.println("\nWorm spawns added");
        
        mainBoard = countSpawns(mainBoard, boardR, boardC);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-27 countSpawns", time, tileset, addMis);

        }
        System.out.println("\nPlayer spawns counted");
        
        mainBoard = scrambleSpawns(mainBoard, boardR, boardC, scrambleSpawnRange);
        if(exportAll == true){
            exportMap(mainBoard, boardR, boardC, exportName, "-28 scrambleSpawns", time, tileset, addMis);
            
        }
        System.out.println("\nPlayer spawns scrambled");
        
        toReturn[2] = exportMap(mainBoard, boardR, boardC, exportName, "", time, tileset, addMis);
        System.out.println("\nMap completed");
        
        timeEnd = String.valueOf(System.currentTimeMillis());
        endTime = String.valueOf(((Long.parseLong(timeEnd) - Long.parseLong(timeToUse))  / 1000f));
        System.out.println("\nMap has been made sucessfully in " + endTime + " second(s)!");
        
        if(exitImediatly == false){
            System.out.println("\nPress enter to exit");
            input.readLine();
        
        }
        
        if(addTimeStamp == true){
            string = (exportName + "-" + time + ".map");
            
        }else{
            string = (exportName + ".map");
            
        }
        
        toReturn[0] = string;
        toReturn[1] = endTime;
        refreshSettings();
        return toReturn;
    }
}