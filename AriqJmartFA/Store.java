package AriqJmartFA;



public class Store extends Recognizable implements FileParser{

    public String name;
    public String address;
    public String phoneNumber;

    public Store(int accountId, String name, String address, String phoneNumber) {

        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public Store(Account account, String name, String address, String phoneNumber) {

        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
    }

    public String toString() {

        String nama = "Name: " + this.name;
        String jalan = "Address: " + this.address;
        String notelp = "PhoneNumber: " + this.phoneNumber;

        StringBuilder strbld = new StringBuilder(nama)
        .append(jalan)
        .append(notelp);

        String str = strbld.toString();
        return str;

        // return "name: PT Madju Merdeka\naddress: Jl. Kukusan]nphoneNumber: 628777xxxx";

    }
    
    @Override
    public boolean read(String content) {
        
        return false;
    }
}
