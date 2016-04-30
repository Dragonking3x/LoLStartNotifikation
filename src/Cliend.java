import com.sun.corba.se.spi.activation.Server;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Dragonking3x on 07.04.2016.
 */
public class Cliend implements Runnable{
    public Cliend() throws IOException {







    }


    public String getStartGame() {
        return startGame;
    }

    public void setStartGame(String startGame) {
        this.startGame = startGame;
    }

    private String startGame = "";

    public boolean isGetInThreat() {
        return getInThreat;
    }

    public void setGetInThreat(boolean getInThreat) {
        this.getInThreat = getInThreat;
    }

    private boolean getInThreat;


    @Override
    public void run() {



        int port = 20500;
        Socket socked = null;
        while (true) {




            try (ServerSocket serverSocked = new ServerSocket(port)) {





                    try (
                            Socket cliendSocked = serverSocked.accept();
                            PrintWriter out = new PrintWriter(cliendSocked.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(cliendSocked.getInputStream()));
                            //BufferedReader send = new BufferedReader(new InputStreamReader(System.in));



                    ) {
                        java.util.Scanner s = new java.util.Scanner(System.in);

                        final boolean[] exit = {false};
                        setGetInThreat(true);


                        final String[] line = new String[1];
                        Thread thread = new Thread(new Runnable() {
                            public void run() {
                                while (getInThreat) {



                                    try {


                                            if (in.readLine().equalsIgnoreCase("exit")) {
                                                out.println("Disconnected");
                                                exit[0] = true;
                                                setGetInThreat(false);
                                                System.out.println("exit");
                                            }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("ttt");

                                }
                            }
                        });

                        thread.start();











                        while (exit[0] == false) {

                            //out.println(s.nextLine());
                            if (!this.startGame.equalsIgnoreCase("")) {

                                out.println(this.startGame);
                                this.startGame = "";


                            }




                        }





                        in.close();
                        out.close();
                        cliendSocked.close();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }





}
