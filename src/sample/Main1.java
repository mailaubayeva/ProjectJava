package sample;

import java.io.*;
import java.util.ArrayList;

public class Main1 {

    public static void main (String[] args) throws FileNotFoundException, IOException{

        //ObjectInputStream ins = new ObjectInputStream (new FileInputStream("qwe.txt"));
        //ArrayList<User> UserList = (ArrayList<User>)ins.readObject();
        //ins.close();

        ArrayList<User> UserList = new ArrayList<User>();


        UserList.add(new User("fgh","fgh","cvbn","fghjk","ghj"));


        ObjectOutputStream outs = new ObjectOutputStream (new FileOutputStream("qwe.txt"));
        outs.writeObject(UserList);
        System.out.println(UserList);
       DatabaseHandler databaseHandler=new DatabaseHandler();

    }

}
