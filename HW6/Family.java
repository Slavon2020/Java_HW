import animals.Pet;

import java.util.Arrays;

public class Family {
    final private Human FATHER;
    final private Human MOTHER;

    private Human[] childs = new Human[0];
    private Pet pet;

    Family(Human father, Human mother) {
        this.FATHER = father;
        this.MOTHER = mother;

        this.FATHER.setFamily(this);
        this.MOTHER.setFamily(this);
    }

    public Human getFather() {
        return FATHER;
    }
    public Human getMother() {
        return MOTHER;
    }
    public Human[] getChilds() {
        return childs;
    }
    public void setChilds(Human[] childs) {
        this.childs = childs;
    }
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    void addChild(Human child) {
        child.setFamily(this);
        Human[] newChilds = new Human[childs.length + 1];
        System.arraycopy(childs, 0, newChilds, 0, childs.length);
        newChilds[newChilds.length - 1] = child;

        setChilds(newChilds);
    }

    boolean deleteChild(int index) {
        if (index > childs.length - 1) {
            throw new IllegalArgumentException();
        }
        if (childs[index] == null) {
            return false;
        }
        Human[] newChilds = new Human[this.childs.length - 1];
        System.arraycopy(this.childs, 0, newChilds, 0, index);
        System.arraycopy(this.childs, index + 1, newChilds, index, newChilds.length - index);
        setChilds(newChilds);
        return true;
    }

    int countFamily() {
        return this.childs.length + 2;
    }

    @Override
    public String toString() {
        return this.FATHER + " " + this.MOTHER + " " + this.pet + " " + Arrays.toString(this.childs);
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
}
