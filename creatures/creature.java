import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class creature extends statBlock{
    String name;
    private size creatureSize;
    private type creatureType;
    private ArrayList<tag> creatureTags = new ArrayList<>();
    private List<Object> alignment = Arrays.asList(new Object[2]); //list with fixed size of 2

    private int hitPointTotal;
    private int speed;
    private int armorClass;
    private Map<sense, Integer> senses;
    private double challengeRating;
    private String description;

    public creature(){


    }


}
