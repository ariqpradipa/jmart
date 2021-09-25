package AriqJmartFA;

public abstract class Recognizeable {

    public final int id;

    protected Recognizeable(int id) {

        this.id = id;

    }

    public boolean equals(Object object) {

        if(object instanceof Recognizeable && ((Recognizeable)object).id == this.id) {

            return true;

        } else {

            return false;

        }
    }
    
    public boolean equals(Recognizeable recog) {

        return (recog.id == this.id);

    }
}
