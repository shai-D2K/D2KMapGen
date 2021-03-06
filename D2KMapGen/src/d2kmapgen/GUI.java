/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d2kmapgen;

import static d2kmapgen.FileHandling.convertStringHextoHex;
import static d2kmapgen.FileHandling.writeFile;
import static d2kmapgen.Main.setSettingsState1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ini4j.Ini;

/**
 *
 * @author Nigel2
 */
public class GUI extends javax.swing.JFrame {
    public static int guiBoardRDefault = 0;
    public static int guiBoardCDefault = 0;
    public static String guiTilesetDefault;
    public static boolean guiAddTimeStampDefault;
    public static boolean guiAutoSpaceSpawnsDefault;
    public static String guiExportNameDefault;
    public static boolean guiAddMisDefault;
    public static String[] settings = new String[7];
    public static String fileName = "temp";
    
    public static int listOfTilesetsLength;
    public static String[] listOfTilesets = null;
    public static boolean done = false;
    
    public static String[] received;
    public static long startTime;
    public static String endTime;
    
    public static String errorMsg = "Something happened: ";
    public static String lastMap = "";
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        boardRTF = new javax.swing.JTextField();
        boardRL = new javax.swing.JLabel();
        boardCL = new javax.swing.JLabel();
        boardCTF = new javax.swing.JTextField();
        tilesetL = new javax.swing.JLabel();
        tilesetTF = new javax.swing.JTextField();
        addTimeStampL = new javax.swing.JLabel();
        addTimeStampTrue = new javax.swing.JRadioButton();
        addTimeStampFalse = new javax.swing.JRadioButton();
        exportNameL = new javax.swing.JLabel();
        exportNameTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTA = new javax.swing.JTextArea();
        startButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        quitAndButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        autoSpaceSpawnsL = new javax.swing.JLabel();
        autoSpaceSpawnsTrue = new javax.swing.JRadioButton();
        autoSpaceSpawnsFalse = new javax.swing.JRadioButton();
        addMisL = new javax.swing.JLabel();
        addMisTrue = new javax.swing.JRadioButton();
        addMisFalse = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 195));
        setResizable(false);

        boardRTF.setText("128");

        boardRL.setText("Width");

        boardCL.setText("Height");

        boardCTF.setText("128");

        tilesetL.setText("Tileset");

        tilesetTF.setText("BLOXBGBS");

        addTimeStampL.setText("Add time stamp?");

        buttonGroup1.add(addTimeStampTrue);
        addTimeStampTrue.setSelected(true);
        addTimeStampTrue.setText("Yes");

        buttonGroup1.add(addTimeStampFalse);
        addTimeStampFalse.setText("No");
        addTimeStampFalse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTimeStampFalseActionPerformed(evt);
            }
        });

        exportNameL.setText("Map Name");

        exportNameTF.setText("outputName");

        outputTA.setEditable(false);
        outputTA.setColumns(20);
        outputTA.setLineWrap(true);
        outputTA.setRows(5);
        outputTA.setWrapStyleWord(true);
        jScrollPane1.setViewportView(outputTA);

        startButton.setText("Start");
        startButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                startButtonItemStateChanged(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load Defaults");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        quitAndButton.setText("Quit and Save Defaults");
        quitAndButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitAndButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        autoSpaceSpawnsL.setText("Automatically space spawns?");

        buttonGroup2.add(autoSpaceSpawnsTrue);
        autoSpaceSpawnsTrue.setSelected(true);
        autoSpaceSpawnsTrue.setText("Yes");

        buttonGroup2.add(autoSpaceSpawnsFalse);
        autoSpaceSpawnsFalse.setText("No");

        addMisL.setText("Create .mis file?");

        buttonGroup3.add(addMisTrue);
        addMisTrue.setSelected(true);
        addMisTrue.setText("Yes");

        buttonGroup3.add(addMisFalse);
        addMisFalse.setText("No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boardRL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boardRTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boardCL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boardCTF, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tilesetL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tilesetTF, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exportNameL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exportNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(autoSpaceSpawnsL)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(autoSpaceSpawnsTrue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoSpaceSpawnsFalse))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addTimeStampTrue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTimeStampFalse))
                    .addComponent(addMisL)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addMisTrue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addMisFalse))
                    .addComponent(quitAndButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTimeStampL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boardRL)
                            .addComponent(boardCL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boardRTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boardCTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tilesetL)
                            .addComponent(exportNameL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tilesetTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exportNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTimeStampL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addTimeStampTrue)
                            .addComponent(addTimeStampFalse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoSpaceSpawnsL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autoSpaceSpawnsTrue)
                            .addComponent(autoSpaceSpawnsFalse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addMisL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addMisTrue)
                            .addComponent(addMisFalse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitAndButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        done = false;
        int guiBoardR = 0;
        int guiBoardC = 0;
        String guiTileset;
        boolean guiAddTimeStamp;
        boolean guiAutoSpaceSpawns;
        boolean guiAddMis;
        String guiExportName;
        fileName = "temp";
        startTime = System.currentTimeMillis();
        
        
        boolean allIsGood = true;
//        int listOfTilesetsLength = 7;
//        String[] listOfTilesets = new String[listOfTilesetsLength];
        boolean foundMatch = false;
        
        
        
        //Get boardR
        try{
            guiBoardR = Integer.parseInt(boardRTF.getText());
            
        }catch(NumberFormatException e){
            allIsGood = false;
            outputTA.append("'Width' must be a number. \n");
            
        }catch(NullPointerException e){
            allIsGood = false;
            outputTA.append("'Width' can't be null. \n");
            
        }
        
        if(guiBoardR > 128){
            allIsGood = false;
            outputTA.append("'Width' must be a lower than or equal to '128'. \n");
            
        }else if(guiBoardR < 16){
            allIsGood = false;
            outputTA.append("'Width' must be bigger than or equal to '16'. \n");
            
        }else{
            
        }
        
        if(guiBoardR % 2 == 1){
            allIsGood = false;
            outputTA.append("'Width' must be a multiple of '2'. \n");

        }
        
        //Get boardC
        try{
            guiBoardC = Integer.parseInt(boardCTF.getText());
            
        }catch(NumberFormatException e){
            allIsGood = false;
            outputTA.append("'Height' must be a number. \n");
            
        }catch(NullPointerException e){
            allIsGood = false;
            outputTA.append("'Height' can't be null. \n");
            
        }
        
        if(guiBoardC > 128){
            allIsGood = false;
            outputTA.append("'Height' must be a lower than or equal to '128'. \n");
            
        }else if(guiBoardC < 16){
            allIsGood = false;
            outputTA.append("'Height' must be bigger than or equal to '16'. \n");
            
        }else{
            
        }
        
        if(guiBoardC % 2 == 1){
            allIsGood = false;
            outputTA.append("'Height' must be a multiple of '2'. \n");

        }
        
        //Get tileset
        guiTileset = tilesetTF.getText().toUpperCase();
        
        for(int i = 0; i != listOfTilesetsLength; i++){
            if(guiTileset.matches(listOfTilesets[i]) == true){
                foundMatch = true;
                
            }
        }
        
        if(foundMatch == true){
            
        }else{
            allIsGood = false;
            outputTA.append("'Tileset' must be a valid tileset. \n");
            
        }
        
        //Get addTimeStamp
        if(addTimeStampTrue.isSelected() == true){
           guiAddTimeStamp = true;
            
        }else{
            guiAddTimeStamp = false;
            
        }
        
        //Get autoSpaceSpawns
        if(autoSpaceSpawnsTrue.isSelected() == true){
           guiAutoSpaceSpawns = true;
            
        }else{
            guiAutoSpaceSpawns = false;
            
        }
        
        //Get autoSpaceSpawns
        if(addMisTrue.isSelected() == true){
           guiAddMis = true;
            
        }else{
            guiAddMis = false;
            
        }
        
        //Get exportName
        guiExportName = exportNameTF.getText();
        if(guiExportName.length() <= 0){
            allIsGood = false;
            outputTA.append("'Map Name' must be longer. \n");
            
        }else if(guiExportName.length() >= 64){
            allIsGood = false;
            outputTA.append("'Map Name' must be shorter. \n");
            
        }else{
            
        }
        
        for(int i = 0; i != guiExportName.length(); i++){
            if(guiExportName.charAt(i) == '\\' || guiExportName.charAt(i) == '/' 
                    || guiExportName.charAt(i) == ':' || guiExportName.charAt(i) == '*' 
                    || guiExportName.charAt(i) == '?' || guiExportName.charAt(i) == '"' 
                    || guiExportName.charAt(i) == '<' || guiExportName.charAt(i) == '>'
                    || guiExportName.charAt(i) == '|'){
                allIsGood = false;
                outputTA.append("'Map Name' must not contain '" + guiExportName.charAt(i) + "'. \n");
                
            }
        }
        
        if(allIsGood == true){
            settings[0] = String.valueOf(guiBoardR);
            settings[1] = String.valueOf(guiBoardC);
            settings[2] = guiTileset;
            settings[3] = String.valueOf(guiAddTimeStamp);
            settings[4] = guiExportName;
            settings[5] = String.valueOf(guiAutoSpaceSpawns);
            settings[6] = String.valueOf(guiAddMis);

            
            outputTA.append("Map is being made... \n");
//                add("Map is being made... \n", outputTA);
//                System.out.println("going");
//                timeAtStart = System.currentTimeMillis();
//                do{
//                    timeToExit = System.currentTimeMillis();
//                    
//                }while(timeAtStart > (timeToExit - 2000));
//                System.out.println("going");
            //Thread.sleep(1000);
            //fileName = setSettingsState1(1, settings);
            //new Thread().start();
            startButton.setEnabled(false);
            execute();
//            if(check() == true){
//                System.out.println("gud");
//                
//            }
            //printEnd(fileName);

            
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        Ini guiSettingsIni = null;
        String guiSettingsFileName = "ini\\guiSettings.ini";
        boolean foundFile;
        String toWrite = "";
        
        try{
            guiSettingsIni = new Ini(new File(guiSettingsFileName));
            foundFile = true;

        }catch(FileNotFoundException e){
            //outputTA.append("'" + guiSettingsFileName + "' not found. Using defaults\n");
            foundFile = false;
            
        }catch(IOException e){
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
            outputTA.append(errorMsg + e + " \n");
            foundFile = false;
            
        }
        
        if(foundFile == true){
            insert();
            
        }else{
            toWrite = "[general]" + convertStringHextoHex("0D0A") +
            "guiBoardRDefault = " + 128  + convertStringHextoHex("0D0A") +
            "guiBoardCDefault = " + 128  + convertStringHextoHex("0D0A") +
            "guiTilesetDefault = " + "BLOXBGBS"  + convertStringHextoHex("0D0A") +
            "guiExportNameDefault = " + "outputName"  + convertStringHextoHex("0D0A") +
            "guiAddTimeStampDefault = " + true  + convertStringHextoHex("0D0A") +
            "guiAutoSpaceSpawnsDefault = "  + true + convertStringHextoHex("0D0A") +
            "guiAddMisDefault = "  + true + convertStringHextoHex("0D0A");
            
            try{
                writeFile(guiSettingsFileName, toWrite);
                
                boardRTF.setText(String.valueOf(128));
                boardCTF.setText(String.valueOf(128));
                tilesetTF.setText("BLOXBGBS");
                addTimeStampTrue.setSelected(true);
                autoSpaceSpawnsTrue.setSelected(true);
                exportNameTF.setText("outputName");
                addMisTrue.setSelected(true);
                
            }catch(IOException e){
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
                outputTA.append(errorMsg + e + " \n");
                
            }
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void quitAndButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitAndButtonActionPerformed
        guiBoardRDefault = Integer.parseInt(boardRTF.getText());
        guiBoardCDefault = Integer.parseInt(boardCTF.getText());
        guiTilesetDefault = tilesetTF.getText();
        
        if(addTimeStampTrue.isSelected() == true){
            guiAddTimeStampDefault = true;
            
        }else{
            guiAddTimeStampDefault = false;
            
        }
        
        if(autoSpaceSpawnsTrue.isSelected() == true){
            guiAutoSpaceSpawnsDefault = true;
            
        }else{
            guiAutoSpaceSpawnsDefault = false;
            
        }
        
        if(addMisTrue.isSelected() == true){
            guiAddMisDefault = true;
            
        }else{
            guiAddMisDefault = false;
            
        }
        
        guiExportNameDefault = exportNameTF.getText();
        
        try{
            save();
            
        }catch(IOException e){
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
            outputTA.append(errorMsg + e + " \n");
            
        }
        
        System.exit(0);
    }//GEN-LAST:event_quitAndButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void addTimeStampFalseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTimeStampFalseActionPerformed
    }//GEN-LAST:event_addTimeStampFalseActionPerformed

    private void startButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_startButtonItemStateChanged
    }//GEN-LAST:event_startButtonItemStateChanged

    public void delete(){
        
    }
    
    public void setEnd(String[] receivedRec){
        DecimalFormat format = new DecimalFormat("0.000");
        fileName = receivedRec[0];
        endTime = receivedRec[1];//((Long.parseLong(receivedRec[1]) - startTime)  / 1000f);
        lastMap = receivedRec[2];
        done = true;
        outputTA.append("'" + fileName + "' has been made sucessfully in " + endTime + " second(s)! \n\n");
        startButton.setEnabled(true);
        
    }
    
    public void save() throws IOException{
        String guiSettingsFileName = "ini\\guiSettings.ini";
        boolean foundFile;
        String toWrite = "";
        
        toWrite = "[general]" + convertStringHextoHex("0D0A") +
        "guiBoardRDefault = " + guiBoardRDefault  + convertStringHextoHex("0D0A") +
        "guiBoardCDefault = " + guiBoardCDefault  + convertStringHextoHex("0D0A") +
        "guiTilesetDefault = " + guiTilesetDefault  + convertStringHextoHex("0D0A") +
        "guiExportNameDefault = " + guiExportNameDefault  + convertStringHextoHex("0D0A") +
        "guiAddTimeStampDefault = " + guiAddTimeStampDefault  + convertStringHextoHex("0D0A") +
        "guiAutoSpaceSpawnsDefault = "  + guiAutoSpaceSpawnsDefault + convertStringHextoHex("0D0A") +
        "guiAddMisDefault = "  + guiAddMisDefault + convertStringHextoHex("0D0A");
            
        writeFile(guiSettingsFileName, toWrite);
    }
    
    public void insert(){
        boardRTF.setText(String.valueOf(guiBoardRDefault));
        boardCTF.setText(String.valueOf(guiBoardCDefault));
        tilesetTF.setText(guiTilesetDefault);
        
        if(guiAddTimeStampDefault == true){
            addTimeStampTrue.setSelected(true);
            
        }else{
            addTimeStampFalse.setSelected(true);
            
        }
        
        if(guiAutoSpaceSpawnsDefault == true){
            autoSpaceSpawnsTrue.setSelected(true);
            
        }else{
            autoSpaceSpawnsFalse.setSelected(true);
            
        }
        
        if(guiAddMisDefault == true){
            addMisTrue.setSelected(true);
            
        }else{
            addMisFalse.setSelected(true);
            
        }
        
        exportNameTF.setText(guiExportNameDefault);
    }
    
    public static void startUp() throws IOException{
        Ini guiSettingsIni = null;
        String guiSettingsFileName = "ini\\guiSettings.ini";
        boolean foundFile;
        
        try{
            guiSettingsIni = new Ini(new File(guiSettingsFileName));
            foundFile = true;

        }catch(FileNotFoundException e){
            foundFile = false;
            
        }
        
        if(foundFile == true){
            try{
                guiBoardRDefault = guiSettingsIni.get("general", "guiBoardRDefault", int.class);

            }catch(IllegalArgumentException e){

            }
            try{
                guiBoardCDefault = guiSettingsIni.get("general", "guiBoardCDefault", int.class);

            }catch(IllegalArgumentException e){

            }
            try{
                guiTilesetDefault = guiSettingsIni.get("general", "guiTilesetDefault");

            }catch(IllegalArgumentException e){

            }
            try{
                guiAddTimeStampDefault = guiSettingsIni.get("general", "guiAddTimeStampDefault", boolean.class);

            }catch(IllegalArgumentException e){

            }
            try{
                guiAutoSpaceSpawnsDefault = guiSettingsIni.get("general", "guiAutoSpaceSpawnsDefault", boolean.class);

            }catch(IllegalArgumentException e){

            }
            try{
                guiAddMisDefault = guiSettingsIni.get("general", "guiAddMisDefault", boolean.class);

            }catch(IllegalArgumentException e){

            }
            try{
                guiExportNameDefault = guiSettingsIni.get("general", "guiExportNameDefault");

            }catch(IllegalArgumentException e){

            }
            
            //boardRTF.setText(guiBoardRDefault);
            
        }
    }
    
    public static void readTilesets() throws IOException{
        Ini tilesetListIni = null;
        String tilesetListFileName = "ini\\tilesets.ini";
        boolean foundFile = true;
        String temp;
        
        try{
            tilesetListIni = new Ini(new File(tilesetListFileName));
            foundFile = true;

        }catch(FileNotFoundException e){
            foundFile = false;
            
        }
        
        if(foundFile == true){
            for(int i = 0; i < 99; i++){
                temp = tilesetListIni.get("tilesets", String.valueOf(i + 1));
                
                if(temp == null){
                    i = 999;

                }else{
                    listOfTilesetsLength++;
                    
                }
            }
            
            listOfTilesets = new String[listOfTilesetsLength];
            for(int i = 0; i != listOfTilesetsLength; i++){
                try{
                    listOfTilesets[i] = tilesetListIni.get("tilesets", String.valueOf(i + 1)).toUpperCase();

                }catch(IllegalArgumentException e){

                }
                
            }
            
        }else{
            listOfTilesetsLength = 7;
            listOfTilesets = new String[listOfTilesetsLength];
            
            listOfTilesets[0] = "BLOXBASE";
            listOfTilesets[1] = "BLOXBAT";
            listOfTilesets[2] = "BLOXBGBS";
            listOfTilesets[3] = "BLOXICE";
            listOfTilesets[4] = "BLOXTREE";
            listOfTilesets[5] = "BLOXWAST";
            listOfTilesets[6] = "BLOXXMAS";
        
        }
    }
    
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
        
        startUp();
        readTilesets();
        
    }
    
    public void execute(){
        new Thread(){
            public void run(){
                try{
                    setEnd(setSettingsState1(settings));
                    
                }catch (IOException ex){
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
            
        }.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addMisFalse;
    private javax.swing.JLabel addMisL;
    private javax.swing.JRadioButton addMisTrue;
    private javax.swing.JRadioButton addTimeStampFalse;
    private javax.swing.JLabel addTimeStampL;
    private javax.swing.JRadioButton addTimeStampTrue;
    private javax.swing.JRadioButton autoSpaceSpawnsFalse;
    private javax.swing.JLabel autoSpaceSpawnsL;
    private javax.swing.JRadioButton autoSpaceSpawnsTrue;
    private javax.swing.JLabel boardCL;
    private javax.swing.JTextField boardCTF;
    private javax.swing.JLabel boardRL;
    private javax.swing.JTextField boardRTF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel exportNameL;
    private javax.swing.JTextField exportNameTF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextArea outputTA;
    private javax.swing.JButton quitAndButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel tilesetL;
    private javax.swing.JTextField tilesetTF;
    // End of variables declaration//GEN-END:variables
}
