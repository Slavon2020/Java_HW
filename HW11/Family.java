import animals.Pet;

import java.util.*;
import java.util.stream.Collectors;

public class Family {
    final private Human FATHER;
    final private Human MOTHER;

    private List<Human> childs = new ArrayList<>();
    private Set<Pet> pets;

    Family(Human father, Human mother) {
        this.FATHER = father;
        this.MOTHER = mother;
        this.FATHER.setFamily(this);
        this.MOTHER.setFamily(this);
        pets = new HashSet<Pet>();
    }

    public Human getFather() {
        return FATHER;
    }
    public Human getMother() {
        return MOTHER;
    }
    public List<Human> getChilds() {
        return childs;
    }
    public void setChilds(List<Human> childs) {
        this.childs = childs;
    }
    public Set<Pet> getPets() {
        return pets;
    }
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    void addChild(Human child) {
        child.setFamily(this);
        this.childs.add(child);
    }

    boolean deleteChild(int index) {
        if (index > childs.size() - 1) {
            throw new IllegalArgumentException();
        }
        if (childs.get(index) == null) {
            return false;
        }
        this.childs.remove(index);
        return true;
    }

    int countFamily() {
        return this.childs.size() + 2;
    }

    void addPet(Pet pet) {
        this.pets.add(pet);
    }

    @Override
    public String toString() {
        return "Family: " + "\n" + this.FATHER + "\n" + this.MOTHER + "\n" + this.pets +"\n" + this.childs;
    }

    @Override
    public boolean equals(Object objToCompare) {
        if (this == objToCompare) return true;
        if(this.getClass() != objToCompare.getClass()) return false;
        Family familyToCompare = (Family)objToCompare;
        if (this.FATHER != familyToCompare.FATHER) return false;
        if(this.MOTHER != familyToCompare.MOTHER) return false;
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * this.FATHER.hashCode() + 31 * this.MOTHER.hashCode();
    }

    @Override
    public void finalize(){
        System.out.println("Object will be deleted ---- " + this);
    }

    public String prettyFormat() {
        StringBuilder toReturn = new StringBuilder();

        toReturn.append("Family: \n");
        toReturn.append(getMother().prettyFormat() + "\n");
        toReturn.append(getFather().prettyFormat() + "\n");
        getChilds().forEach(child -> {
            toReturn.append(child.prettyFormat());
            toReturn.append("\n");
        });
        getPets().forEach(pet -> {
            toReturn.append(pet.prettyFormat());
            toReturn.append("\n");
        });
        return toReturn.toString();
    };
}
