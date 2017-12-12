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
public class TriMyMessage {
    public String type;
    public  String sender;
    public String receiver;
    public String content;
    public static void main(String[] args) {
        TriMyMessage m1= new TriMyMessage();
        m1.sender= "user 1";
        m1.receiver= "user 2";
        m1.type= "chat";
        m1.content= "Hello, Mi khoe k ";
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonString =  mapper.writeValueAsString(m1);
            System.out.println(m1);
            TriMyMessage mlr = mapper.readValue(jsonString, TriMyMessage.class);
            System.out.println("sender" + mlr.sender);
            System.out.println("receiver" + mlr.receiver);
            System.out.println("type"+ mlr.type);
            System.out.println("content" + mlr.content);
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}
