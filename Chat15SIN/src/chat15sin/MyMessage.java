/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat15sin;

import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Dell
 */
public class MyMessage {
    public String sender;
    public String receiver;
    public String type;
    public String content;
    
    public static void main(String[] argv){
        //user1 gui user2 doan chat noi dung hello. Mi khoe ko?
        MyMessage m1 = new MyMessage();
        m1.sender = "user1";
        m1.receiver = "user2";
        m1.type = "chat";
        m1.content = "Hello. Mi khoe ko?";
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonString = mapper.writeValueAsString(m1);
            System.out.println(jsonString);
            MyMessage m1r = mapper.readValue(jsonString, MyMessage.class);
            System.out.println("sender: " + m1r.sender);
            System.out.println("receiver: " + m1r.receiver);
            System.out.println("type: " + m1r.type);
            System.out.println("content: " + m1r.content);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        //user1 gui den server doan login co password: 123456
        MyMessage m2 = new MyMessage();
        m2.sender = "user1";
        m2.receiver = "server";
        m2.type = "login";
        m2.content = "123456";
    }
}
