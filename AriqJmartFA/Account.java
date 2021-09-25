package AriqJmartFA;



public class Account extends Recognizeable implements FileParser {

    public String name;
    public String email;
    public String password;
   
    public Account(int id, String name, String email, String password) {

        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        
    }
   
    public boolean read (String content) {
        
        return false;
        
    }
}
