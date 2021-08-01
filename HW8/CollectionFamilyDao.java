import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> familyDB;

    CollectionFamilyDao() {
        familyDB = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(familyDB);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return (index < familyDB.size() && index >= 0) ? familyDB.get(index) : null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < familyDB.size() && index >= 0) {
            familyDB.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyDB.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if(familyDB.contains(family)) {
            familyDB.set(familyDB.indexOf(family), family);
            return;
        }
        familyDB.add(family);
    }
}
