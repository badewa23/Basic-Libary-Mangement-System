/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author Oluwatobi
 */
public class Control {
   
   public Control(){
       
   }
   
   public String retrieveAny(String[] arg, int num){
       String query = String.format("select %s from %s",arg[num], arg[0]);
       return query;
   }
   
   public String deleteSpecifyColumn (String[] arg){
       String delete = String.format("delete from %s where %s = ?",arg[0],
               arg[1]);
       return delete;
   }
   
   public String queryTable(String[] arg){
       String query = String.format("select * from %s", arg[0]);
       return query;
   }
   
   public String query(String[] arg){
       String query = "select * from";
       for(int i=0; i < arg.length; i++){
           if(i == arg.length-1){
               query+= String.format(" %s",arg[i] + "=?");
           }
           else if (i ==0){
               query+= String.format(" %s",arg[i] + " where");
           }
           else
             query+= String.format(" %s",arg[i] + "=? and");       
       }
       return query;
   }
   
   // Insert Data into specific table
    public String insertToSpecificTable(String[] arg){
       String insert = "insert into";
       for(int i=0; i < arg.length; i++){
           if(i == arg.length-1){
               insert+= String.format(" %s",arg[i] + ")");
               insert+= "values (";
               for(int j =0; j< arg.length-1; j++){
                   if(j == arg.length-2){
                       insert+="?)";
                   }
                   else
                       insert+="?, ";
               }
           }
           else if (i ==0){
               insert+= String.format(" %s",arg[i] + " (");
           }
           else
             insert+= String.format(" %s",arg[i] + ", ");       
       }
       return insert;
   }
}
