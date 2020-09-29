package sg.edu.rp.c346.id_18021531.demophoneforelderly;

public class Contacts {

    private int id;
    private int  Name;
    private int  Numbers;
    private int  relationship;

    public Contacts(int id, int name, int numbers, int relationship) {
        this.id = id;
        Name = name;
        Numbers = numbers;
        this.relationship = relationship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getNumbers() {
        return Numbers;
    }

    public void setNumbers(int numbers) {
        Numbers = numbers;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }
}
