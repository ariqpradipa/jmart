package AriqJmartFA;

public class Account extends Recognizable implements FileParser {

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

        String nama = "name: " + this.name;
        String em = "\nemail: " + this.email;
        String pass = "\npass: " + this.password;

        StringBuilder strbld = new StringBuilder(nama).append(em).append(pass);
        String str = strbld.toString();

        return str;
        //return "name: Rmadhan\nemail: ramdhangnteng@gmail.com\npassword: gu3G4ntEnG";
        
    }
   
    public boolean read (String content) {
        
        return false;
        
    }
}
