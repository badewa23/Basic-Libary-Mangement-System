/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Oluwatobi
 */
public class SystemManager {
    private final Connection Sql_Connection = ConectionProvider.getConnection();
    private final Control Instuction = new Control();
    private final String [] User_Table = {"users", "Username", "Password", "Role"};
    private final String [] Book_Table = {"book", "Title","Author", "Publisher", 
        "PublicationDate", "DateCreated", "DeweyDecNum"};
    private final String [] Genre_Table = {"genres","Name"};
    private final String [] Genre_Has_Book_Table = {"genres_has_book","GenreID", 
        "BookID"};
    private final String [] Role = {"Admin","User","Staff"};
    private final String [] Frame = {"User","Book", "Genre"};
    int i;
    
    public SystemManager (){
        
    }
    
    public String [] getRole(){
        return Role;
    }
    
    public String getGenreNamefromForeignKeyBook(String data){
        String [] temp2 =  new String [2];
        temp2[0] = Genre_Has_Book_Table[0];
        temp2[1] = Genre_Has_Book_Table[2];
        String query = createQuery(2,temp2);
        String result = "";
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(data));
            ResultSet rst = pst.executeQuery();
            String bookTitle;
            if(!rst.next())
                return" ";
            else{
                String temp = rst.getString(2);
                bookTitle = retrieveGenreUsingForeignBookID(temp);
                if(bookTitle == null)
                    return null;
                result += bookTitle +" ";
                while(rst.next()){
                     temp = rst.getString(2);
                     bookTitle = retrieveGenreUsingForeignBookID(temp);
                     result += bookTitle +" ";
                }
            }
            return result;
        }
        catch (SQLException ex) {
            return null;
        }
        
    }
    
    public String getBookIDfromForeignKeyGenre(String data){
        String query = createQuery(2,Genre_Has_Book_Table);
        String result = "";
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(data));
            ResultSet rst = pst.executeQuery();
            if(!rst.next())
                return" ";
            else{
                result += rst.getString(3) +" ";
                while(rst.next()){
                     result += rst.getString(3) +" ";
                }
            }
            return result;
        }
        catch (SQLException ex) {
            return null;
        }
        
    }
    
    public void runLogin() {
        new Login().setVisible(true);
    }
    
    public void runFramePanel(String addFrame, String role){
        if(addFrame.equals(this.Frame[0])){
            new UserChangePanel(role).setVisible(true);
        }
        else if(addFrame.equals(this.Frame[1])){
            new BookChangePanel(role).setVisible(true);
        }
        else if(addFrame.equals(this.Frame[2])){
            new GenreChangePanel(role).setVisible(true);
        }
    }
    
    public void runRoleFrame(String role){
        if(role.equals(this.Role[0])){
            new AdminFrame(role).setVisible(true);
        }
        if(role.equals(this.Role[1])){
            new UserPanel().setVisible(true);
        }
        if(role.equals(this.Role[2])){
            new StaffFrame(role).setVisible(true);
        }
    }
    
    public ResultSet createTableGenre(){
        ResultSet rst;
        String query = Instuction.queryTable(Genre_Table);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            rst = pst.executeQuery();   
        }
        catch (SQLException ex) {
            return null;
        }
        return rst;
    }
    
    public ResultSet createTableBook(){
        ResultSet rst;
        String query = Instuction.queryTable(Book_Table);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            rst = pst.executeQuery();   
        }
        catch (SQLException ex) {
            return null;
        }
        return rst;
    }
    
    public ResultSet createTableUser(){
        ResultSet rst;
        String query = Instuction.queryTable(User_Table);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            rst = pst.executeQuery();   
        }
        catch (SQLException ex) {
            return null;
        }
        return rst;
    }
    
    private String createDelete(String [] delete){
        return Instuction.deleteSpecifyColumn(delete);
    }
    
    private String createQuery(int num, String [] query){
        String [] queryTerm = new String [num];
        for(i = 0; i < queryTerm.length; i++){
            queryTerm[i] = query[i];
        }
        return Instuction.query(queryTerm);
    }
     
    private String createInsert(int num, String [] insert){
        String [] insertTerm = new String [num];
        for(i = 0; i < insertTerm.length; i++){
            insertTerm[i] = insert[i];
        }
        return Instuction.insertToSpecificTable(insertTerm);
    }
    
    private boolean checkGenreName(String genreName){
        String query = createQuery(2,Genre_Table);
         try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setString(1, genreName);
            ResultSet rst = pst.executeQuery();
            return rst.next();    
        }
        catch (SQLException ex) {
            return true;
        }
    }
    
    private boolean checkTitle(String Title){
        String query = createQuery(2,Book_Table);
         try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setString(1, Title);
            ResultSet rst = pst.executeQuery();
            return rst.next();    
        }
        catch (SQLException ex) {
            return true;
        }
    }
    
    private boolean checkUserName (String userName){
        String query = createQuery(2,User_Table);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setString(1, userName);
            ResultSet rst = pst.executeQuery();
            return rst.next();    
        }
        catch (SQLException ex) {
            return true;
        }
    }
    
    private boolean checkGenreHasBook (String genreID, String bookID){
        String query = createQuery(Genre_Has_Book_Table.length,Genre_Has_Book_Table);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(genreID));
            pst.setInt(2, Integer.valueOf(bookID));
            ResultSet rst = pst.executeQuery();
            return rst.next();    
        }
        catch (SQLException ex) {
            return true;
        }
    }
    
    private boolean checkBookIDInGenreHasBook(String BookID){
        String [] temp = new String[2];
        temp[0] = Genre_Has_Book_Table[0];
        temp[1] = Genre_Has_Book_Table[2];
        String query = createQuery(2,temp);
         try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setString(1, BookID);
            ResultSet rst = pst.executeQuery();
            return rst.next();    
        }
        catch (SQLException ex) {
            return true;
        }
    } 
    
    private boolean checkGenreIDInGenreHasBook(String genreID){
        String query = createQuery(2,Genre_Has_Book_Table);
         try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setString(1, genreID);
            ResultSet rst = pst.executeQuery();
            return rst.next();    
        }
        catch (SQLException ex) {
            return true;
        }
    } 
    
    public ResultSet authenticlogin(String userName, String passWord){
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(createQuery(3, 
                    User_Table));
            pst.setString(1, userName);
            pst.setString(2, passWord);
            ResultSet rst = pst.executeQuery();
            return rst;      
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet retriveGenre(String genreID){
        String []genreTabled = new String[2];
        genreTabled[0] = this.Genre_Table[0];
        genreTabled[1] = "GenreID";
        String retrive = createQuery(2,genreTabled);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(retrive);
            pst.setInt(1, Integer.valueOf(genreID));
            ResultSet rst = pst.executeQuery();
            return rst;
        }
        catch (SQLException ex) {
                return null;
        }
    }
    
    public ResultSet retrivBookInfo(String BookID){
        String [] temp = new String [2];
        temp[0] = Book_Table[0];
        temp[1] = "BookID";
        String query = createQuery(2,temp);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(BookID));
            ResultSet rst = pst.executeQuery();
            return rst;
        }
        catch (SQLException ex) {
                return null;
        }
    }
    
    private String retrieveGenreUsingForeignBookID(String GenreID){
        String [] temp = new String[2];
        temp[0] = Genre_Table[0];
        temp[1] = "GenreID";
        String query = createQuery(2,temp);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(GenreID));
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                String temp2 =rst.getString(2);
                return temp2;
            }
            return " ";    
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList <String> retriveGenreUsingBookID(String bookID){
        ArrayList <String> temp = new ArrayList <>();
        String [] temp2 =  new String [2];
        temp2[0] = Genre_Has_Book_Table[0];
        temp2[1] = Genre_Has_Book_Table[2];
        String query = createQuery(2,temp2);
        try {
            PreparedStatement pst = Sql_Connection.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(bookID));
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                temp.add(rst.getString(2));
                while(rst.next()){
                    temp.add(rst.getString(2));
                }
                return temp;
            }
            return null;
        }
        catch (SQLException ex) {
                return null;
        }
    }
    
    public String newGenre(String genreName){
        if(genreName.trim().isEmpty())
            return "Need to Input Genre Name";
        boolean flag = checkGenreName(genreName);
        String insert = createInsert(Genre_Table.length,Genre_Table);
        if (!flag){
            try {
                PreparedStatement pst = Sql_Connection.prepareStatement(insert);
                pst.setString(1, genreName);
                int x = pst.executeUpdate();
                if(x>0)
                    return null;
                else
                    return "Did Not Update";
            }
            catch (SQLException ex) {
                return "Error Porgam Code dose not Work as intended";
            }
        }
        return "Existing User Name Try Diffrent One";
    }
    
    public String newBook(String title, String author, String publisher, 
            String publicationDate,String dateCreated,String DeweyDecNum){
        if(title.trim().isEmpty()){
            return"Need to Input Title";
        }
        String insert = createInsert(Book_Table.length,Book_Table);
        boolean flag = checkTitle(title);
        if (!flag){
            try {
                PreparedStatement pst = Sql_Connection.prepareStatement(insert);
                pst.setString(1, title);
                if(author.trim().isEmpty())
                      pst.setString(2, " ");
                else
                    pst.setString(2, author);
                if(publisher.trim().isEmpty())
                      pst.setString(3, " ");
                else
                    pst.setString(3, publisher);
                pst.setString(4, publicationDate);
                pst.setString(5,dateCreated);
                if(DeweyDecNum.trim().isEmpty())
                      pst.setNull(6, Types.INTEGER);
                else
                    pst.setInt(6, Integer.valueOf(DeweyDecNum));
                int x = pst.executeUpdate();
                if(x>0)
                    return null;
                else
                    return "Did Not Update";
            }
            catch (SQLException ex) {
                return "Error Porgam Code dose not Work as intended";
            }
        }
        return "Existing Title Name Try Diffrent One";
    }
    
    public String newUser(String userName, String passWord, String role){
        if(userName.trim().isEmpty()&& passWord.trim().isEmpty())
            return "Need to Input Useranme and Password";
        else if(userName.trim().isEmpty())
            return "Need to Input Useranme";
        else if(passWord.trim().isEmpty())
            return "Need to Input Password";
        boolean flag = checkUserName(userName);
        String insert = createInsert(User_Table.length,User_Table);
        if (!flag){
            try {
                PreparedStatement pst = Sql_Connection.prepareStatement(insert);
                pst.setString(1, userName);
                pst.setString(2, passWord);
                pst.setString(3, role);
                int x = pst.executeUpdate();
                if(x>0)
                    return null;
                else
                    return "Did Not Update";
            }
            catch (SQLException ex) {
                return "Error Porgam Code dose not Work as intended";
            }
        }
        return "Existing User Name Try Diffrent One";
    }   
    
    public String newGenreHasBook(String genreID, String bookID){
        boolean flag = checkGenreHasBook(genreID, bookID);
        String insert = createInsert(Genre_Has_Book_Table.length,Genre_Has_Book_Table);
        if (!flag){
            try {
                PreparedStatement pst = Sql_Connection.prepareStatement(insert);
                pst.setInt(1, Integer.valueOf(genreID));
                pst.setInt(2, Integer.valueOf(bookID));
                int x = pst.executeUpdate();
                if(x>0)
                    return null;
                else
                    return "Did Not Add";
            }
            catch (SQLException ex) {
                return "Error Porgam Code dose not Work as intended";
            }
        }
        return "The genre includes that book";
    }
   
    private boolean deleteBookIDFromGenreHasBook(String bookID){
        boolean flag = checkBookIDInGenreHasBook(bookID);
        if (!flag)
            return true;
        String []genreTabled = new String[2];
        genreTabled[0] = this.Genre_Has_Book_Table[0];
        genreTabled[1] = "BookID";
        String delete = createDelete(genreTabled);
        try{
            PreparedStatement pst = Sql_Connection.prepareStatement(delete);
            pst.setInt(1, Integer.valueOf(bookID));
            int x = pst.executeUpdate();
            return x>0;
        }
        catch (SQLException ex) {
                return false;
        }
    }
   
    private boolean deleteGenreIDFromGenreHasBook(String genreID){
        boolean flag = checkGenreIDInGenreHasBook(genreID);
        if (!flag)
            return true;
        String []genreTabled = new String[2];
        genreTabled[0] = this.Genre_Has_Book_Table[0];
        genreTabled[1] = "GenreID";
        String delete = createDelete(genreTabled);
        try{
            PreparedStatement pst = Sql_Connection.prepareStatement(delete);
            pst.setInt(1, Integer.valueOf(genreID));
            int x = pst.executeUpdate();
            return x>0;
        }
        catch (SQLException ex) {
                return false;
        }
    }
    
    public String deleteGenre(String data){
        String []genreTabled = new String[2];
        genreTabled[0] = this.Genre_Table[0];
        genreTabled[1] = "GenreID";
        if (!deleteGenreIDFromGenreHasBook(data)){
            return "Error Program Did not work as Planed Genre ID was Not "
                    + "Deleted from genre_has_book  table";
        }
        String delete = createDelete(genreTabled);
        try{
            PreparedStatement pst = Sql_Connection.prepareStatement(delete);
            pst.setString(1, data);
            int x = pst.executeUpdate();
            if(x>0)
                return null;
            else
                return "Did not Delete";
        }
        catch (SQLException ex) {
                return "Error Program Did not work as Planed Genre Was Not "
                        + "Deleted";
        }
    }
    
    public String deleteBook(String data){
        String []bookTabled = new String[2];
        bookTabled[0] = this.Book_Table[0];
        bookTabled[1] = "BookID";
        if (!deleteBookIDFromGenreHasBook(data)){
            return "Error Program Did not work as Planed Genre ID was Not "
                    + "Deleted from genre_has_book  table";
        }
        String delete = createDelete(bookTabled);
        try{
            PreparedStatement pst = Sql_Connection.prepareStatement(delete);
            pst.setString(1, data);
            int x = pst.executeUpdate();
            if(x>0)
                return null;
            else
                return "Did not Delete";
        }
        catch (SQLException ex) {
                return "Error Program Did not work as Planed";
        }
    }
    
    public String deleteUser(String data){
        String []userTabled = new String[2];
        userTabled[0] = this.User_Table[0];
        userTabled[1] = "UserID";
        String delete = createDelete(userTabled);
        try{
            PreparedStatement pst = Sql_Connection.prepareStatement(delete);
            pst.setString(1, data);
            int x = pst.executeUpdate();
            if(x>0)
                return null;
            else
                return "Did not Delete";
        }
        catch (SQLException ex) {
                return "Error Program Did not work as Planed";
        }
    }
    
    public String deleteGenreHasBook(String genreID, String bookID){
        boolean flag = checkGenreHasBook(genreID, bookID);
        if(!flag)
            return "Genre and book are not paired can't delete";
        String delete = "delete from genres_has_book where GenreID=? "
                + "and BookID =?";
        try{
            PreparedStatement pst = Sql_Connection.prepareStatement(delete);
            pst.setInt(1, Integer.valueOf(genreID));
            pst.setInt(2, Integer.valueOf(bookID));
            int x = pst.executeUpdate();
            if(x>0)
                return null;
            else
                return "Did not Delete";
        }
        catch (SQLException ex) {
                return "Error Program Did not work as Planed Genre Was Not "
                        + "Deleted";
        }
    }
         
}
