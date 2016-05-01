import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Created by Dragonking3x on 30.04.2016.
 */
public class UI {



    private JTextField folderTextField;
    private JButton setFolderButton;
    private JButton startButton;
    private JPanel panel;
    private JLabel infoText;

    private static String folder;
    private static String logFolder;




    private static boolean folderButtonBoolean = false;

    public static void main(String[] args) throws IOException, InterruptedException {

        JFrame frame = new JFrame("UI");
        frame.setContentPane(new UI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


      //  TxtFileList FileList = new TxtFileList();
      //  TxTDataList dataList = new TxTDataList();
//
      //  String appdata = System.getenv("APPDATA");
      //  String dataFolder = appdata + "\\LoLAleart\\";
      //  File appdataFileDir = new File(dataFolder);
//
      //  String dataFile = dataFolder + FileList.dataTxt();
//
      //  String folder = "C:\\Riot Games\\League of Legends";
//
      //  if(!appdataFileDir.exists()) {
      //      try {
      //          appdataFileDir.mkdir();
      //      } catch (Exception e) {
//
      //      }
      //  }
//
      //      File dataTxtFile = new File(dataFile);
      //      if(!dataTxtFile.exists()){
//
      //          FileUtils.writeStringToFile(dataTxtFile,
      //                  dataList.lolFolder() + ": -");
//
      //      }
//
      //      folder = new GetLineFromFile().getLineFromFile(dataTxtFile,dataList.lolFolder());
      //
//
//
//
//
//
//
//
//
//
//
//
      //  while (!folderButtonBoolean){
      //      Thread.sleep(500);
//
      //  }
//
//
//
//
//
//
      //  String logFolder = "\\Logs\\Game - R3d Logs";
      //  String lolLogfolder = folder + logFolder;
//
      //  String txtTextFolder = "";
      //  int startGame = 0;
      //  ReadTxT rtxt = new ReadTxT();
//
//
//
      //  String lastTxt = "";
//
//
//
//
//
      //  String lolLogTxt;
      //  int open = 1;
      //  Cliend cliendSend = new Cliend();
      //  Thread t = new Thread(cliendSend);
      //  t.start();
//
//
      //  while (open == 1) {
      //      lolLogTxt = "error";
      //      SearchForNewTxT searchLolLog = new SearchForNewTxT();
      //      while (lolLogTxt.equalsIgnoreCase("error")) {
//
      //          lolLogTxt = searchLolLog.searchForNewTxT(lolLogfolder);
      //          Thread.sleep(1000);
//
      //      }
//
      //      if (!lastTxt.equalsIgnoreCase(lolLogTxt)) {
      //          txtTextFolder = lolLogfolder + "\\" + lolLogTxt;
//
      //          System.out.println("New Game");
        //        cliendSend.setStartGame
        //                ("Loading Screen");
        //        lastTxt = lolLogTxt;
        //        startGame = 0;
        //        while (startGame == 0) {
//
        //            if (rtxt.readTxT(txtTextFolder).contains("Spawning heroes/minions")) {
        //                cliendSend.setStartGame("Game Start");
        //                System.out.println("Game Start");
        //                startGame = 1;
        //                Thread.sleep(5000);
//
        //            }
//
//
        //            Thread.sleep(1000);
        //        }
        //    }
//
        //}




    }

    public UI() {

        startButton.setText("Start");
        infoText.setForeground(Color.white);
        try {
            infoText.setText("Your Network IP: " + Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            infoText.setText("I can get your Network IP Dx");
        }

        setFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                fileChooser.setDialogTitle("League of Legends Folder");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);

                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                    folder = String.valueOf(fileChooser.getSelectedFile());
                    folderTextField.setText(String.valueOf(folder));
                    System.out.println(folder);
                }


            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File tempFile = new File(folder + logFolder);

                if(tempFile.exists()) {
                    folderButtonBoolean = true;
                    startButton.setText("Stop?");
                    folderTextField.setEditable(false);
                    setFolderButton.setEnabled(false);
                    try {
                        infoText.setText("Your Network IP: " + Inet4Address.getLocalHost().getHostAddress());
                    } catch (UnknownHostException ee) {
                        ee.printStackTrace();
                        infoText.setText("I can get your Network IP Dx");
                    }
                    infoText.setForeground(Color.white);
                }
                else {
                    infoText.setForeground(Color.red);
                    infoText.setText("This is not the right Folder");
                }

            }
        });

        final Thread t = new Thread(){
            public void run(){


                TxtFileList FileList = new TxtFileList();
                TxTDataList dataList = new TxTDataList();

                String appdata = System.getenv("APPDATA");
                String dataFolder = appdata + "\\LoLAleart\\";
                File appdataFileDir = new File(dataFolder);

                String dataFile = dataFolder + FileList.dataTxt();

                folder = "C:\\Riot Games\\League of Legends";


                // set Log Folder
                try {
                    if (!appdataFileDir.exists()) {
                        try {
                            appdataFileDir.mkdir();
                        } catch (Exception e) {

                        }
                    }

                    File dataTxtFile = new File(dataFile);
                    if (!dataTxtFile.exists()) {

                        FileUtils.writeStringToFile(dataTxtFile,
                                dataList.lolFolder() + ";" + folder);

                    }

                    folder = new GetLineFromFile().getLineFromFile(dataTxtFile, dataList.lolFolder());

                } catch (IOException e) {
                    e.printStackTrace();
                }

                folderTextField.setText(folder);


                logFolder = "\\Logs\\Game - R3d Logs";
                while (!folderButtonBoolean){

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }







                String lolLogfolder = folder + logFolder;

                String txtTextFolder = "";
                int startGame = 0;
                ReadTxT rtxt = new ReadTxT();



                String lastTxt = "";



                ////// seach game start

                try {

                    String lolLogTxt;
                    int open = 1;
                    Cliend cliendSend = new Cliend();
                    Thread t = new Thread(cliendSend);
                    t.start();


                    while (open == 1) {
                        lolLogTxt = "error";
                        SearchForNewTxT searchLolLog = new SearchForNewTxT();
                        while (lolLogTxt.equalsIgnoreCase("error")) {

                            lolLogTxt = searchLolLog.searchForNewTxT(lolLogfolder);
                            Thread.sleep(1000);

                        }

                        if (!lastTxt.equalsIgnoreCase(lolLogTxt)) {
                            txtTextFolder = lolLogfolder + "\\" + lolLogTxt;

                            System.out.println("New Game");
                            cliendSend.setStartGame
                                    ("Loading Screen");
                            lastTxt = lolLogTxt;
                            startGame = 0;
                            while (startGame == 0) {

                                if (rtxt.readTxT(txtTextFolder).contains("Spawning heroes/minions")) {
                                    cliendSend.setStartGame("Game Start");
                                    System.out.println("Game Start");
                                    startGame = 1;
                                    Thread.sleep(5000);

                                }


                                Thread.sleep(1000);
                            }
                        }

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


        };
        t.start();










    }




}
