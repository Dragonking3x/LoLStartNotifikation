

import java.io.IOException;

/**
 * Created by Dragonking3x on 07.04.2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {




        String lolLogfolder = "C:\\Riot Games\\League of Legends\\Logs\\Game - R3d Logs";
        String txtTextFolder = "";
        int startGame = 0;
        ReadTxT rtxt = new ReadTxT();
        String lastTxt = "";



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
                cliendSend.setStartGame("Loading Screen");
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
    }



}
