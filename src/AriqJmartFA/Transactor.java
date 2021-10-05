package AriqJmartFA;

public interface Transactor {

    boolean validate();

    Invoice perform();

}
