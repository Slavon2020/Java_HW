public enum Animal {
    DOG("собака"), CAT("кот");
    private String type;

    Animal(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
