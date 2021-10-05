package AriqJmartFA;

public abstract class Recognizable {

    public final int id;

    protected Recognizable(int id) {

        this.id = id;

    }

    public boolean equals(Object object) {

        return (object instanceof Recognizable && ((Recognizable) object).id == this.id);
    }
    
    public boolean equals(Recognizable recog) {

        return (recog.id == this.id);

    }
}
