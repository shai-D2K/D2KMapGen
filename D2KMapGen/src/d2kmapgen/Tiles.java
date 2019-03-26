package d2kmapgen;

import java.util.Random;

public class Tiles {
    
    public static String getSpawnHexAsSpecial(){
        return "1700";
    }
    
    public static String getSpawnHexAsNonSpecial(){
        return "00AA";
    }
    
    public static String getWormSpawnHexAsSpecial(){
        return "1400";
    }
    
    public static String getWormSpawnHexAsNonSpecial(){
        return "00AB";
    }
    
    public static String getBloomSpawnHexAsSpecial(){
        return "2D00";
    }
    
    public static String getBloomSpawnHexAsNonSpecial(){
        return "00AC";
    }
    
    public static String getSpiceLightHexAsSpecial(){
        return "0100";
    }
    
    public static String getSpiceLightHexAsNonSpecial(){
        return "00AD";
    }
    
    public static String getSpiceHardHexAsSpecial(){
        return "0200";
    }
    
    public static String getSpiceHardHexAsNonSpecial(){
        return "00AE";
    }
    
    public static boolean isAnEntranceEdge(int n){
        if(n == 490
                || n == 491
                || n == 492
                || n == 493
                
                || n == 494
                || n == 495
                || n == 496
                || n == 497
                
                || n == 500
                || n == 501
                || n == 502
                || n == 503
                
                || n == 504
                || n == 505
                || n == 506
                || n == 507
                
                || n == 510
                || n == 511
                || n == 512
                || n == 513
                
                || n == 514
                || n == 515
                || n == 516
                || n == 517
                
                || n == 520
                || n == 521
                || n == 522
                || n == 523
                
                || n == 524
                || n == 525
                || n == 526
                || n == 527){
            return true;
            
        }else{
            return false;
            
        }
        
    }
    
    public static boolean isAnyCliffNumber(int n){
        if(n == 290
                || n == 291
                || n == 292
                || n == 293
                || n == 294
                || n == 295
                || n == 296
                || n == 297
                || n == 300
                || n == 301
                || n == 302
                || n == 303
                || n == 310
                || n == 311
                || n == 312
                || n == 313
                || n == 314
                || n == 315
                || n == 316
                || n == 317
                || n == 320
                || n == 321
                || n == 322
                || n == 323
                || n == 330
                || n == 331
                || n == 332
                || n == 333
                || n == 334
                || n == 335
                || n == 336
                || n == 337
                || n == 340
                || n == 341
                || n == 342
                || n == 343
                || n == 350
                || n == 351
                || n == 352
                || n == 353
                || n == 354
                || n == 355
                || n == 356
                || n == 357
                || n == 360
                || n == 361
                || n == 362
                || n == 363
                || n == 304
                || n == 305
                || n == 324
                || n == 325
                || n == 344
                || n == 345
                || n == 364
                || n == 365
                || n == 470
                || n == 471
                || n == 472
                || n == 473
                || n == 474
                || n == 475
                || n == 476
                || n == 477
                || n == 480
                || n == 481
                || n == 482
                || n == 483
                || n == 484
                || n == 485
                || n == 486
                || n == 487){
            return true;
            
        }else{
            return false;
            
        }
        
    }
    
    public static boolean isASmallCliffNumber(int n){
        if(n == 304
                || n == 305
                || n == 324
                || n == 325
                || n == 344
                || n == 345
                || n == 364
                || n == 365){
            return true;
            
        }else{
            return false;
            
        }
        
    }
    
    public static boolean isACliffCornerNumber(int n){
        if(n == 470
                || n == 471
                || n == 472
                || n == 473
                || n == 474
                || n == 475
                || n == 476
                || n == 477
                || n == 480
                || n == 481
                || n == 482
                || n == 483
                || n == 484
                || n == 485
                || n == 486
                || n == 487){
            
            return true;
            
        }else{
            return false;
            
        }
        
    }
    
    public static boolean isACliffNumber(int n){
        if(n == 290
                || n == 291
                || n == 292
                || n == 293
                || n == 294
                || n == 295
                || n == 296
                || n == 297
                || n == 300
                || n == 301
                || n == 302
                || n == 303
                || n == 310
                || n == 311
                || n == 312
                || n == 313
                || n == 314
                || n == 315
                || n == 316
                || n == 317
                || n == 320
                || n == 321
                || n == 322
                || n == 323
                || n == 330
                || n == 331
                || n == 332
                || n == 333
                || n == 334
                || n == 335
                || n == 336
                || n == 337
                || n == 340
                || n == 341
                || n == 342
                || n == 343
                || n == 350
                || n == 351
                || n == 352
                || n == 353
                || n == 354
                || n == 355
                || n == 356
                || n == 357
                || n == 360
                || n == 361
                || n == 362
                || n == 363){
            return true;
            
        }else{
            return false;
            
        }
        
    }
    
    public static int[] getBLOXBGBSSpecialTileNumber(int sandOrRock, int shape, int style){
        int[] toReturn = new int[32];
        int[][] sandShape2 = new int[7][4];
        int[][] sandShape3 = new int[3][2];
        int[][] sandShape5 = new int[7][1];
        
        int[][] rockShape1 = new int[2][8];
        int[][] rockShape2 = new int[9][4];
        int[][] rockShape3 = new int[4][2];
        int[][] rockShape4 = new int[2][2];
        int[][] rockShape5 = new int[8][1];
        
        sandShape2[0][0] = 870;
        sandShape2[0][1] = 871;
        sandShape2[0][2] = 872;
        sandShape2[0][3] = 873;
        
        sandShape2[1][0] = 874;
        sandShape2[1][1] = 875;
        sandShape2[1][2] = 876;
        sandShape2[1][3] = 877;
        
        sandShape2[2][0] = 890;
        sandShape2[2][1] = 891;
        sandShape2[2][2] = 892;
        sandShape2[2][3] = 893;
        
        sandShape2[3][0] = 894;
        sandShape2[3][1] = 895;
        sandShape2[3][2] = 896;
        sandShape2[3][3] = 897;
        
        sandShape2[4][0] = 900;
        sandShape2[4][1] = 901;
        sandShape2[4][2] = 902;
        sandShape2[4][3] = 903;
        
        sandShape2[5][0] = 904;
        sandShape2[5][1] = 905;
        sandShape2[5][2] = 906;
        sandShape2[5][3] = 907;
        
        sandShape2[6][0] = 910;
        sandShape2[6][1] = 911;
        sandShape2[6][2] = 912;
        sandShape2[6][3] = 913;
        
        sandShape3[0][0] = 920;
        sandShape3[0][1] = 921;
        
        sandShape3[1][0] = 922;
        sandShape3[1][1] = 923;
        
        sandShape3[2][0] = 924;
        sandShape3[2][1] = 925;
        
        sandShape5[0][0] = 930;
        
        sandShape5[1][0] = 931;
        
        sandShape5[2][0] = 932;
        
        sandShape5[3][0] = 933;
        
        sandShape5[4][0] = 934;
        
        sandShape5[5][0] = 935;
        
        sandShape5[6][0] = 936;
        
        
        rockShape1[0][0] = 940;
        rockShape1[0][1] = 941;
        rockShape1[0][2] = 942;
        rockShape1[0][3] = 943;
        rockShape1[0][4] = 944;
        rockShape1[0][5] = 945;
        rockShape1[0][6] = 946;
        rockShape1[0][7] = 947;
        
        rockShape1[1][0] = 950;
        rockShape1[1][1] = 951;
        rockShape1[1][2] = 952;
        rockShape1[1][3] = 953;
        rockShape1[1][4] = 954;
        rockShape1[1][5] = 955;
        rockShape1[1][6] = 956;
        rockShape1[1][7] = 957;
        
        rockShape2[0][0] = 960;
        rockShape2[0][1] = 961;
        rockShape2[0][2] = 962;
        rockShape2[0][3] = 963;
        
        rockShape2[1][0] = 964;
        rockShape2[1][1] = 965;
        rockShape2[1][2] = 966;
        rockShape2[1][3] = 967;
        
        rockShape2[2][0] = 970;
        rockShape2[2][1] = 971;
        rockShape2[2][2] = 972;
        rockShape2[2][3] = 973;
        
        rockShape2[3][0] = 974;
        rockShape2[3][1] = 975;
        rockShape2[3][2] = 976;
        rockShape2[3][3] = 977;
        
        rockShape2[4][0] = 980;
        rockShape2[4][1] = 981;
        rockShape2[4][2] = 982;
        rockShape2[4][3] = 983;
        
        rockShape2[5][0] = 984;
        rockShape2[5][1] = 985;
        rockShape2[5][2] = 986;
        rockShape2[5][3] = 987;
        
        rockShape2[6][0] = 990;
        rockShape2[6][1] = 991;
        rockShape2[6][2] = 992;
        rockShape2[6][3] = 993;
        
        rockShape2[7][0] = 994;
        rockShape2[7][1] = 995;
        rockShape2[7][2] = 996;
        rockShape2[7][3] = 997;
        
        rockShape2[8][0] = 1000;
        rockShape2[8][1] = 1001;
        rockShape2[8][2] = 1002;
        rockShape2[8][3] = 1003;
        
        rockShape3[0][0] = 1010;
        rockShape3[0][1] = 1011;
        
        rockShape3[1][0] = 1012;
        rockShape3[1][1] = 1013;
        
        rockShape3[2][0] = 1014;
        rockShape3[2][1] = 1015;
        
        rockShape3[3][0] = 1016;
        rockShape3[3][1] = 1017;
        
        rockShape4[0][0] = 1020;
        rockShape4[0][1] = 1021;
        
        rockShape4[1][0] = 1022;
        rockShape4[1][1] = 1023;
        
        rockShape5[0][0] = 1030;
        
        rockShape5[1][0] = 1031;
        
        rockShape5[2][0] = 1032;
        
        rockShape5[3][0] = 1033;
        
        rockShape5[4][0] = 1034;
        
        rockShape5[5][0] = 1035;
        
        rockShape5[6][0] = 1036;
        
        rockShape5[7][0] = 1037;
        
        if(sandOrRock == 0){
            if(shape == 0){
                toReturn[0] = 860;
                toReturn[1] = 861;
                toReturn[2] = 862;
                toReturn[3] = 863;
                toReturn[4] = 864;
                toReturn[5] = 865;
                
            }else if(shape == 1){
                toReturn[0] = sandShape2[style][0];
                toReturn[1] = sandShape2[style][1];
                toReturn[2] = sandShape2[style][2];
                toReturn[3] = sandShape2[style][3];
                
            }else if(shape == 2){
                toReturn[0] = sandShape3[style][0];
                toReturn[1] = sandShape3[style][1];
                
            }else if(shape == 3){
                toReturn[0] = 926;
                toReturn[1] = 927;
                
            }else if(shape == 4){
                toReturn[0] = sandShape5[style][0];
                
            }
            
        }else if(sandOrRock == 1){
            if(shape == 0){
                toReturn[0] = rockShape1[style][0];
                toReturn[1] = rockShape1[style][1];
                toReturn[2] = rockShape1[style][2];
                toReturn[3] = rockShape1[style][3];
                toReturn[4] = rockShape1[style][4];
                toReturn[5] = rockShape1[style][5];
                toReturn[6] = rockShape1[style][6];
                toReturn[7] = rockShape1[style][7];
                
            }else if(shape == 1){
                toReturn[0] = rockShape2[style][0];
                toReturn[1] = rockShape2[style][1];
                toReturn[2] = rockShape2[style][2];
                toReturn[3] = rockShape2[style][3];
                
            }else if(shape == 2){
                toReturn[0] = rockShape3[style][0];
                toReturn[1] = rockShape3[style][1];
                
            }else if(shape == 3){
                toReturn[0] = rockShape4[style][0];
                toReturn[1] = rockShape4[style][1];
                
            }else if(shape == 4){
                toReturn[0] = rockShape5[style][0];
                
            }
        }
        
        return toReturn;
    }
    
    public static int[] getRandomBLOXBGBSSpecialTileNumber(int sandOrRock, int shape){
        Random rand = new Random();
        int style = 0;
        int randVar = 0;
        int max = 0;
        int min = 0;
        
        if(sandOrRock == 0){
            if(shape == 0){
                max = 0;//
                
            }else if(shape == 1){
                max = 6;
                
            }else if(shape == 2){
                max = 2;
                
            }else if(shape == 3){
                max = 0;//
                
            }else if(shape == 4){
                max = 6;
                
            }
            
        }else if(sandOrRock == 1){
            if(shape == 0){
                max = 1;
                
            }else if(shape == 1){
                max = 8;
                
            }else if(shape == 2){
                max = 3;
                
            }else if(shape == 3){
                max = 1;
                
            }else if(shape == 4){
                max = 7;
                
            }
            
        }
        
        
        style = rand.nextInt((max - min) + 1) + min;
        
        if(sandOrRock == 0 && shape == 0 || sandOrRock == 0 && shape == 3){
            style = 0;
            
        }
        
        return getBLOXBGBSSpecialTileNumber(sandOrRock, shape, style);
    } 
    
    public static String getRandomDuneHex(){
        Random rand = new Random();
        int randVar = 0;
        int max = 0;
        int min = 0;
        
        max = 8;
        randVar = rand.nextInt((max - min) + 1) + min;
        
        return getDuneHex(randVar);
    }
    
    public static String getDuneHex(int i){
        String[] listOfDuneHexes = {
            "5400",
            "3F00",
            "4000",
            "6800",
            "4100",
            "4200",
            "5100",
            "5300",
            "6700"
        };
        
        return listOfDuneHexes[i];
    }
    
    public static boolean isARock(String hex){
        if(
                hex.matches(getRockHex(0))
                || hex.matches(getRockHex(1)) 
                || hex.matches(getRockHex(2))
                || hex.matches(getRockHex(3))
                || hex.matches(getRockHex(4))
                || hex.matches(getRockHex(5))
                || hex.matches(getRockHex(6))
                || hex.matches(getRockHex(7))
                || hex.matches(getRockHex(8))
                || hex.matches(getRockHex(9))
                || hex.matches(getRockHex(10))
                || hex.matches(getRockHex(11))
                || hex.matches(getRockHex(12))
                || hex.matches(getRockHex(13))
                || hex.matches(getRockHex(14))
                ){
            return true;

        }else{
            return false;
            
        }
        
    }
    
    public static String getRockHex(int i){
        String[] listOfRockHexes = {
            "2802", 
            "2902", 
            "2A02", 
            "2B02", 
            "2C02", 
            "3C02", 
            "3D02", 
            "3E02", 
            "3F02", 
            "4002", 
            "5002", 
            "5102", 
            "5202", 
            "5302", 
            "5402"
        };
        
        return listOfRockHexes[i];
    }
    
    public static String getRandomRockHex(){
        Random rand = new Random();
        int randVar = 0;
        int max = 0;
        int min = 0;
        
        max = 14;
        randVar = rand.nextInt((max - min) + 1) + min;
        
        return getRockHex(randVar);
    }
    
    public static boolean isASand(String hex){
        if(
                hex.matches(getSandHex(0))
                || hex.matches(getSandHex(1))
                || hex.matches(getSandHex(2))
                || hex.matches(getSandHex(3))
                || hex.matches(getSandHex(4))
                || hex.matches(getSandHex(5))
                || hex.matches(getSandHex(6))
                || hex.matches(getSandHex(7))
                || hex.matches(getSandHex(8))
                || hex.matches(getSandHex(9))
                ){
            return true;

        }else{
            return false;

        }
        
    }
    
    public static String getSandHex(int i){
        String[] listofSandHexes = {
            "3000", 
            "3100", 
            "3200", 
            "3300", 
            "3400", 
            "4400", 
            "4500", 
            "4600", 
            "4700", 
            "4800"
        };
        
        return listofSandHexes[i];
    }
    
    public static String getRandomSandHex(){
        Random rand = new Random();
        int randVar = 0;
        int max = 0;
        int min = 0;
        
        max = 9;
        randVar = rand.nextInt((max - min) + 1) + min;
        
        return getSandHex(randVar);
    }
    
    public static int getRockBoarderNumber(int i, int direction){
        int[] listOfNorthRockBoarderNumbers = new int[5];
        int[] listOfEastRockBoarderNumbers = new int[4];
        int[] listOfSouthRockBoarderNumbers = new int[3];
        int[] listOfWestRockBoarderNumbers = new int[5];
        int toReturn = 0;
        
        listOfNorthRockBoarderNumbers[0] = 610;
        listOfNorthRockBoarderNumbers[1] = 611;
        listOfNorthRockBoarderNumbers[2] = 612;
        listOfNorthRockBoarderNumbers[3] = 613;
        listOfNorthRockBoarderNumbers[4] = 614;
        
        listOfEastRockBoarderNumbers[0] = 620;
        listOfEastRockBoarderNumbers[1] = 621;
        listOfEastRockBoarderNumbers[2] = 622;
        listOfEastRockBoarderNumbers[3] = 623;
        
        listOfSouthRockBoarderNumbers[0] = 630;
        listOfSouthRockBoarderNumbers[1] = 631;
        listOfSouthRockBoarderNumbers[2] = 632;//
        
        listOfWestRockBoarderNumbers[0] = 640;
        listOfWestRockBoarderNumbers[1] = 641;
        listOfWestRockBoarderNumbers[2] = 642;
        listOfWestRockBoarderNumbers[3] = 643;
        listOfWestRockBoarderNumbers[4] = 644;
        
        if(direction == 0){
            toReturn = listOfNorthRockBoarderNumbers[i];
        
        }else if(direction == 1){
            toReturn = listOfEastRockBoarderNumbers[i];
        
        }else if(direction == 2){
            toReturn = listOfSouthRockBoarderNumbers[i];
        
        }else if(direction == 3){
            toReturn = listOfWestRockBoarderNumbers[i];
        
        }else{
            toReturn = 0000;
            
        }
        
        return toReturn;
    }
    
    public static int getRandomRockBoarderNumber(int direction){
        Random rand = new Random();
        int randVar = 0;
        int max = 0;
        int min = 0;
        
//        max = 2;
        
        if(direction == 0){
            max = 4;
            
        }else if(direction == 1){
            max = 3;
            
        }else if(direction == 2){
            max = 2;
            
        }else if(direction == 3){
            max = 4;
            
        }
        
        randVar = rand.nextInt((max - min) + 1) + min;
        
        return getRockBoarderNumber(randVar, direction);
        
    }
    
    public static int[] getCliffNumber(int i, int direction){
        int[][] listOfNorthCliffNumbers = new int[3][4];
        int[][] listOfEastCliffNumbers = new int[3][4];
        int[][] listOfSouthCliffNumbers = new int[3][4];
        int[][] listOfWestCliffNumbers = new int[3][4];
        int[] toReturn = new int[4];
        
        listOfNorthCliffNumbers[0][0] = 290;
        listOfNorthCliffNumbers[0][1] = 291;
        listOfNorthCliffNumbers[0][2] = 292;
        listOfNorthCliffNumbers[0][3] = 293;
        
        listOfNorthCliffNumbers[1][0] = 294;
        listOfNorthCliffNumbers[1][1] = 295;
        listOfNorthCliffNumbers[1][2] = 296;
        listOfNorthCliffNumbers[1][3] = 297;
        
        listOfNorthCliffNumbers[2][0] = 300;
        listOfNorthCliffNumbers[2][1] = 301;
        listOfNorthCliffNumbers[2][2] = 302;
        listOfNorthCliffNumbers[2][3] = 303;
        
        listOfEastCliffNumbers[0][0] = 310;
        listOfEastCliffNumbers[0][1] = 311;
        listOfEastCliffNumbers[0][2] = 312;
        listOfEastCliffNumbers[0][3] = 313;
        
        listOfEastCliffNumbers[1][0] = 314;
        listOfEastCliffNumbers[1][1] = 315;
        listOfEastCliffNumbers[1][2] = 316;
        listOfEastCliffNumbers[1][3] = 317;
        
        listOfEastCliffNumbers[2][0] = 320;
        listOfEastCliffNumbers[2][1] = 321;
        listOfEastCliffNumbers[2][2] = 322;
        listOfEastCliffNumbers[2][3] = 323;
        
        listOfSouthCliffNumbers[0][0] = 330;
        listOfSouthCliffNumbers[0][1] = 331;
        listOfSouthCliffNumbers[0][2] = 332;
        listOfSouthCliffNumbers[0][3] = 333;
        
        listOfSouthCliffNumbers[1][0] = 334;
        listOfSouthCliffNumbers[1][1] = 335;
        listOfSouthCliffNumbers[1][2] = 336;
        listOfSouthCliffNumbers[1][3] = 337;
        
        listOfSouthCliffNumbers[2][0] = 340;
        listOfSouthCliffNumbers[2][1] = 341;
        listOfSouthCliffNumbers[2][2] = 342;
        listOfSouthCliffNumbers[2][3] = 343;
        
        listOfWestCliffNumbers[0][0] = 350;
        listOfWestCliffNumbers[0][1] = 351;
        listOfWestCliffNumbers[0][2] = 352;
        listOfWestCliffNumbers[0][3] = 353;
        
        listOfWestCliffNumbers[1][0] = 354;
        listOfWestCliffNumbers[1][1] = 355;
        listOfWestCliffNumbers[1][2] = 356;
        listOfWestCliffNumbers[1][3] = 357;
        
        listOfWestCliffNumbers[2][0] = 360;
        listOfWestCliffNumbers[2][1] = 361;
        listOfWestCliffNumbers[2][2] = 362;
        listOfWestCliffNumbers[2][3] = 363;
        
        if(direction == 0){
            toReturn[0] = listOfNorthCliffNumbers[i][0];
            toReturn[1] = listOfNorthCliffNumbers[i][1];
            toReturn[2] = listOfNorthCliffNumbers[i][2];
            toReturn[3] = listOfNorthCliffNumbers[i][3];
        
        }else if(direction == 1){
            toReturn[0] = listOfEastCliffNumbers[i][0];
            toReturn[1] = listOfEastCliffNumbers[i][1];
            toReturn[2] = listOfEastCliffNumbers[i][2];
            toReturn[3] = listOfEastCliffNumbers[i][3];
        
        }else if(direction == 2){
            toReturn[0] = listOfSouthCliffNumbers[i][0];
            toReturn[1] = listOfSouthCliffNumbers[i][1];
            toReturn[2] = listOfSouthCliffNumbers[i][2];
            toReturn[3] = listOfSouthCliffNumbers[i][3];
        
        }else if(direction == 3){
            toReturn[0] = listOfWestCliffNumbers[i][0];
            toReturn[1] = listOfWestCliffNumbers[i][1];
            toReturn[2] = listOfWestCliffNumbers[i][2];
            toReturn[3] = listOfWestCliffNumbers[i][3];
        
        }else{
            toReturn[0] = 0000;
            toReturn[1] = 0000;
            toReturn[2] = 0000;
            toReturn[3] = 0000;
            
        }
        
        return toReturn;
    }
    
    public static int[] getRandomCliffNumber(int direction){
        Random rand = new Random();
        int randVar = 0;
        int max = 0;
        int min = 0;
        
        max = 2;
        randVar = rand.nextInt((max - min) + 1) + min;
        
        return getCliffNumber(randVar, direction);
        
    }
    
    public static String[] getCliffHex(int i, int direction){
        String[][] listOfNorthCliffHexes = new String[3][4];
        String[][] listOfEastCliffHexes = new String[3][4];
        String[][] listOfSouthCliffHexes = new String[3][4];
        String[][] listOfWestCliffHexes = new String[3][4];
        String[] toReturn = new String[4];
        
        listOfNorthCliffHexes[0][0] = "0f02";
        listOfNorthCliffHexes[0][1] = "1002";
        listOfNorthCliffHexes[0][2] = "2302";
        listOfNorthCliffHexes[0][3] = "2402";
        
        listOfNorthCliffHexes[1][0] = "1102";
        listOfNorthCliffHexes[1][1] = "1202";
        listOfNorthCliffHexes[1][2] = "2502";
        listOfNorthCliffHexes[1][3] = "2602";
        
        listOfNorthCliffHexes[2][0] = "3002";
        listOfNorthCliffHexes[2][1] = "3102";
        listOfNorthCliffHexes[2][2] = "4402";
        listOfNorthCliffHexes[2][3] = "4502";
        
        listOfEastCliffHexes[0][0] = "e501";
        listOfEastCliffHexes[0][1] = "e601";
        listOfEastCliffHexes[0][2] = "f901";
        listOfEastCliffHexes[0][3] = "fa01";
        
        listOfEastCliffHexes[1][0] = "e701";
        listOfEastCliffHexes[1][1] = "e801";
        listOfEastCliffHexes[1][2] = "fb01";
        listOfEastCliffHexes[1][3] = "fc01";
        
        listOfEastCliffHexes[2][0] = "e901";
        listOfEastCliffHexes[2][1] = "ea01";
        listOfEastCliffHexes[2][2] = "fd01";
        listOfEastCliffHexes[2][3] = "fe01";
        
        listOfSouthCliffHexes[0][0] = "9401";
        listOfSouthCliffHexes[0][1] = "9501";
        listOfSouthCliffHexes[0][2] = "a801";
        listOfSouthCliffHexes[0][3] = "a901";
        
        listOfSouthCliffHexes[1][0] = "9601";
        listOfSouthCliffHexes[1][1] = "9701";
        listOfSouthCliffHexes[1][2] = "aa01";
        listOfSouthCliffHexes[1][3] = "ab01";
        
        listOfSouthCliffHexes[2][0] = "9801";
        listOfSouthCliffHexes[2][1] = "9901";
        listOfSouthCliffHexes[2][2] = "ac01";
        listOfSouthCliffHexes[2][3] = "ad01";
        
        listOfWestCliffHexes[0][0] = "bc01";
        listOfWestCliffHexes[0][1] = "bd01";
        listOfWestCliffHexes[0][2] = "d001";
        listOfWestCliffHexes[0][3] = "d101";
        
        listOfWestCliffHexes[1][0] = "be01";
        listOfWestCliffHexes[1][1] = "bf01";
        listOfWestCliffHexes[1][2] = "d201";
        listOfWestCliffHexes[1][3] = "d301";
        
        listOfWestCliffHexes[2][0] = "c001";
        listOfWestCliffHexes[2][1] = "c101";
        listOfWestCliffHexes[2][2] = "d401";
        listOfWestCliffHexes[2][3] = "d501";
        
        if(direction == 0){
            toReturn[0] = listOfNorthCliffHexes[i][0];
            toReturn[1] = listOfNorthCliffHexes[i][1];
            toReturn[2] = listOfNorthCliffHexes[i][2];
            toReturn[3] = listOfNorthCliffHexes[i][3];
        
        }else if(direction == 1){
            toReturn[0] = listOfEastCliffHexes[i][0];
            toReturn[1] = listOfEastCliffHexes[i][1];
            toReturn[2] = listOfEastCliffHexes[i][2];
            toReturn[3] = listOfEastCliffHexes[i][3];
        
        }else if(direction == 2){
            toReturn[0] = listOfSouthCliffHexes[i][0];
            toReturn[1] = listOfSouthCliffHexes[i][1];
            toReturn[2] = listOfSouthCliffHexes[i][2];
            toReturn[3] = listOfSouthCliffHexes[i][3];
        
        }else if(direction == 3){
            toReturn[0] = listOfWestCliffHexes[i][0];
            toReturn[1] = listOfWestCliffHexes[i][1];
            toReturn[2] = listOfWestCliffHexes[i][2];
            toReturn[3] = listOfWestCliffHexes[i][3];
        
        }else{
            toReturn[0] = "ab01";
            toReturn[1] = "ab01";
            toReturn[2] = "ab01";
            toReturn[3] = "ab01";
            
        }
        
        return toReturn;
    }
    
    public static String[] getRandomCliffHex(int direction){
        Random rand = new Random();
        int randVar = 0;
        int max = 0;
        int min = 0;
        
        max = 2;
        randVar = rand.nextInt((max - min) + 1) + min;
        
        return getCliffHex(randVar, direction);
        
    }
}
