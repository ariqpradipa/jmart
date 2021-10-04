package AriqJmartFA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser {

    public String REGEX_EMAIL = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
    public String REGEX_PASSWORD =" ^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$ ";
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

        String nama = "Name: " + this.name;
        String em = "\nEmail: " + this.email;
        String pass = "\nPass: " + this.password;

        StringBuilder strbld = new StringBuilder(nama).append(em).append(pass);
        String str = strbld.toString();

        return str;
        //return "name: Rmadhan\nemail: ramdhangnteng@gmail.com\npassword: gu3G4ntEnG";
        
    }
   
    public boolean read (String content) {
        
        return false;
        
    }
}
