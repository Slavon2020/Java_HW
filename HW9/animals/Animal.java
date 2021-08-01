package animals;

public enum Animal {
    DOG("собака"), DOMESTICCAT("кот"), ROBOCAT("кот-робот"), FISH("рыба"), UNKNOWN("неизвестный тип");
    private String type;

    Animal(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
