package AriqJmartFA;

public abstract class Recognizable {

    public final int id;

    protected Recognizable(int id) {

        this.id = id;

    }

    public boolean equals(Object object) {

        if(object instanceof Recognizable && ((Recognizable)object).id == this.id) {

            return true;

        } else {

            return false;

        }
    }
    
    public boolean equals(Recognizable recog) {

        return (recog.id == this.id);

    }
}
