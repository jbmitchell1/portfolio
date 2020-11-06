package recipemanagementsystem;

//Main ingredient class
public class Ingredient {
    String name;
    String UnitOfM;
    double pricePerU;
    boolean isUsed;
    
    
//Method to create an ingredient    
public Ingredient(String iName, String unit, double price){
    this.name=iName;
    this.UnitOfM=unit;
    this.pricePerU=price;
    this.isUsed=false;
}    

//Returns unit of measurement
public String getUnitOfM(){
    return this.UnitOfM;
}

//Returns the name of the ingredient
public String getName(){
    return this.name;
}    
    
//Returns the price of the ingredient
public double getPrice(){
    return this.pricePerU;
}    

//Returns if the ingredient is used
public boolean getIsUsed(){
    return this.isUsed;
} 

//Sets if the ingredient is used
public void setIsUsed(boolean newIsUsed){
    this.isUsed=newIsUsed;
}   
}
