/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserverclient;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author t2adhika
 */
public class SimpleServerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(59090);
            System.out.println("The date server is running...");
            Socket socket = ss.accept();
            Scanner sc = new Scanner(new File("Pocket.txt"));
            //while (true) {
                
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    int count = 0;
                    while (true){
                        String str = sc.nextLine();
                        System.out.println(str);
                        String[] ct = str.split(" ");
                        count +=ct.length;
                        if(!sc.hasNext()) break;
                    }
                    //out.println(new Date.toString());
                    out.println("Server is sending this "+count);
                }
                catch(Exception e){
                    System.out.println(e);
                }
              //  Thread.sleep(1000);
           // }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Work done");
        }
    }
    
}
