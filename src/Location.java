public class Location {
    private String name;
    private String description ;

    Location(){
        name = "Location name";
        description = "Description of level";
    }

    void setName(String name){
        this.name = name;
    }
    void setDescription(String description){
        this.description = description;
    }


    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Description: " + description + "\n";
    }


}
