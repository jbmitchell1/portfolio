
package recipemanagementsystem;
import java.util.Comparator;


//Overides the comparator and allows sorting of recipe names alphabetically.
public class RecipeNameComparator implements Comparator<Recipe> {
 
    @Override
    public int compare(Recipe o1, Recipe o2) {           
       return o1.getName().compareTo(o2.getName());
    }
}