
package recipemanagementsystem;
import java.util.ArrayList;

//Main recipe class
public class Recipe {
    String name;
    ArrayList<String> ingredients = new ArrayList<>();
    ArrayList<Double> quantities= new ArrayList<>();
    ArrayList<String> unitOfM = new ArrayList<>();
    double price;   
    
public Recipe(){
        ingredients = new ArrayList<>();
        quantities = new ArrayList<>();
        unitOfM = new ArrayList<>();
}
    
public Recipe(String iname){
    this.name=iname;
}

//Return the name of the recipe
public String getName() {
    return this.name;
}

//Return the price of the recipe
public double getPrice(){
    return this.price;
}

//Set price of the recipe
public void setPrice(double newPrice){
    this.price=newPrice;
}

//Return ingredient at i
public String getIngAt(int i)
{
    return this.ingredients.get(i); 
}

//Return the number of ingredients
public int getNumOfIngredients(){
        
    return this.ingredients.size();
}
    
//Return the quantity at i
public double getQuantityAt(int i)
{
    return this.quantities.get(i); 
}    
    
//Return unit of measurement at i
public String getUnitAt(int i)
{
    return this.unitOfM.get(i); 
}
   
//Set the name of the recipe
public void setName(String name) {
    this.name = name;
}  
    
//Add ingredient to the recipe
public void addIngredient(String ing, double howMuch, String unit){     
    this.ingredients.add(ing);
    this.quantities.add(howMuch);
    this.unitOfM.add(unit);           
}
    
    
//Update the ingredient name
public void updateIng(int i, String newName){
    this.ingredients.set(i, newName);
}
    
//Update the ingredient amount 
public void updateIngAmount(int i, double amount){
    this.quantities.set(i, amount);
}
       
//Find the ingredient by name and remove it as well as the coresponding data
public void removeIngredient(String ing){
 
    for(int i=0; i<ingredients.size(); i++){
            
        if(ingredients.get(i).equals(ing)){
            ingredients.remove(i);
            quantities.remove(i);
            unitOfM.remove(i);  
        }
    }
}

//Remove all of the ingredients
public void removeAllIngredients(){
    this.ingredients.clear();
    this.quantities.clear();
    this.unitOfM.clear();
    }  
}
