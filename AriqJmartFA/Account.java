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

    public String toString() {

        return "name: Rmadhan\nemail: ramdhangnteng@gmail.com\npassword: gu3G4ntEnG";
    }
   
    public boolean read (String content) {
        
        return false;
        
    }
}
