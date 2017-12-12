/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat15sin;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Dell
 */
public class ChatClient {
    public String address;
    public int port;
    
    public ChatClient(){
        this.address = "localhost";
        this.port = 1511;
    }
    
    public MyMessage sendMessage(MyMessage m) throws Exception{
        try{
            Socket clientSocket = new Socket(this.address, this.port);
            
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(m);
            oos.writeObject(s);
            oos.flush();
            
            InputStream is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String s1 = (String)ois.readObject();
            MyMessage mr = mapper.readValue(s1, MyMessage.class);
            return mr;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello. This is client.");
        String address = "localhost";
        int port = 1511;
        try{
            Socket clientSocket = new Socket(address, port);
            
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            String s = "afsafq1dfsafsfa";
            oos.writeObject(s);
            oos.flush();
            
            InputStream is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String s1 = (String)ois.readObject();
            System.out.println("Receive from server: " + s1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
