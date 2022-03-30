
public class Task {
    private int id;
    private String name;
    private int typeID;//1-4
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    public String typeName(){
        switch(typeID){
            case 1: 
                return "Code";
            case 2: 
                return "Test";
            case 3: 
                return "Design";
            case 4: 
                return "Review";
        }
        return null;
    }
    @Override
    public String toString() {
        return id+"\t"+name+"\t\t"+typeName()+"\t\t"+date+"\t"+(to-from)+"\t\t"+assignee
                +"\t\t"+reviewer;
    }
    
    
}
