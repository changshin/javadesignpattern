package com.chang.oodp.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
/*
 * provide a mediator between objects for communication and help in implementing lose-coupling between objects.
 */
public class UserChatsMediatorMain {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        User user1 = new UserImpl(chatMediator, "Chang");
        User user2 = new UserImpl(chatMediator, "Lisa");
        User user3 = new UserImpl(chatMediator, "Linda");
        User user4 = new UserImpl(chatMediator, "David");
        chatMediator.addUser(user2);
        chatMediator.addUser(user1);
        chatMediator.addUser(user3);
        chatMediator.addUser(user4);
         
        user1.send("Hi All, I am Chang");
         
    }

}

class ChatMediatorImpl implements ChatMediator {
    private List<User> users;
    
    public ChatMediatorImpl(){
        this.users=new ArrayList<>();
    }
     
    @Override
    public void addUser(User user){
        this.users.add(user);
    }
     
    @Override
    public void sendMessage(User sender,String msg ) {
        for(User user : this.users){
            //message should not be received by the user sending it
            if	(user != sender){
            	user.receive(msg);
            } else {
            	 //System.out.println(user.name+": Sender Message="+msg);
            }
        }
    }

}


interface  ChatMediator {
    void addUser(User user);
    public void sendMessage(User user,String msg);
}


class UserImpl extends User {
    public UserImpl(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }
 
    @Override
    public void send(String msg){	// going to use one time to send
        //System.out.println(this.name+": Sending Message="+msg);
    	chatMediator.sendMessage(this,msg);
    }
    @Override
    public void receive(String msg) {	// receiving many user
        System.out.println(this.name+": Received Message:"+msg);
    }

}

abstract class User {
    protected ChatMediator chatMediator;
    protected String name;
     
    public User(ChatMediator chatMediator, String name){
        this.chatMediator = chatMediator;
        this.name = name;
    }
     
    public abstract void send(String msg);
    public abstract void receive(String msg);
}