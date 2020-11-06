////////////
//  TO DO //
/////////////////////////////////////////////////////////////////////////
//1. ingredient table check price to make sure it is a double
//2. ingredient panel no dupe names
/////////////////////////////////////////////////////////////////////////

package recipemanagementsystem;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;




public class GUI2 extends javax.swing.JFrame {
    
    //Create ingredient and recipe arrays
    ArrayList<Ingredient> ingredientList = new ArrayList<>();
    ArrayList<Recipe> recipeList = new ArrayList<>();    
 
    public GUI2() {
        this.documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                checkName();
            }
            public void insertUpdate(DocumentEvent documentEvent) {
                checkName();
            }
            public void removeUpdate(DocumentEvent documentEvent) {
                checkName();
            }
            private void checkName() {
                
                int position = tblRecipeNames.getSelectedRow();
                
             
                tfRecipeWarning.setText("");
                //Set to blank
                String UppercasedName="";
                //If not blank uppercase the first letter
                boolean isNameAlreadyUsed=false;
                
                
                
                
                if(!tfEditRecipeName.getText().isEmpty()){
                    
                    UppercasedName = tfEditRecipeName.getText().substring(0, 1).toUpperCase() + tfEditRecipeName.getText().substring(1);
                    
                }
                
                for (int i =0; i < recipeList.size();i++){
                    if(recipeList.get(i).getName().equals(UppercasedName)){
                        isNameAlreadyUsed=true;
                        
                        
                    }
                }
                
                if(isNameAlreadyUsed==true){
                    
                    tfRecipeNameWarning.setForeground(Color.RED);
                    tfRecipeNameWarning.setText("That recipe name already exists.");
                    UppercasedName= UppercasedName.substring(0, UppercasedName.length() - 1);                 
                    
                }
                
                recipeList.get(position).setName(UppercasedName);
                RefreshRecipeNames();
                
                for(int i = 0; i < recipeList.size(); i++){
                    if(recipeList.get(i).getName().equals(UppercasedName)){
                        position = i;
                    }
                }
                
                tblRecipeNames.changeSelection(position,0, false,false);
                
            }
        };
        initComponents();
        

        //Initial ingredient and recipe creation
        ingredientList.add(new Ingredient("Quinoa","Cup(s)",1.96));
        ingredientList.add(new Ingredient("Black Beans","Ounce(s)",.66));
        ingredientList.add(new Ingredient("Garlic","Gram(s)",.06));
        ingredientList.add(new Ingredient("Cumin","Tsp(s)",.12));
        ingredientList.add(new Ingredient("Tomato Paste","Tbsp(s)",.35));
        ingredientList.add(new Ingredient("Salt","Tsp(s)",.05));
        ingredientList.add(new Ingredient("Pepper","Tsp(s)",.19));
        ingredientList.add(new Ingredient("Salmon","Pound(s)",4.19));
        ingredientList.add(new Ingredient("Pineapple","Cup(s)",1.27));
        ingredientList.add(new Ingredient("Red Onion(s)","Medium",.79));
        ingredientList.add(new Ingredient("Bell Pepper(s)","Large",.49));
        ingredientList.add(new Ingredient("Cajun Seasoning","Tsp(s)",.18));
        ingredientList.add(new Ingredient("Garlic Powder","Tsp(s)",.14));
        ingredientList.add(new Ingredient("Chicken","Pound(s)",1.14));
        ingredientList.add(new Ingredient("Taco Seasoning","Tsp(s)",.20));
        ingredientList.add(new Ingredient("Tortilla(s)","Medium",.16));
        ingredientList.add(new Ingredient("Salsa","Ounce(s)",.36));
        ingredientList.add(new Ingredient("Tomato(es)","Large",.23));
        ingredientList.add(new Ingredient("Chedder Cheese","Ounce(s)",.77));     
        ingredientList.add(new Ingredient("Peach(es)","Large",.19));     
        ingredientList.add(new Ingredient("Agave Nectar","Tbsp(s)",.77));     
        ingredientList.add(new Ingredient("Greek Yogurt","Cup(s)",1.64));     
        ingredientList.add(new Ingredient("Lemon Juice","Tbsp(s)",.35));     
        ingredientList.add(new Ingredient("Olive Oil","Tsp(s)",.55));     
        ingredientList.add(new Ingredient("Shrimp","Ounce(s)",.70)); 
        ingredientList.add(new Ingredient("Lime Juice","Tsp(s)",.19)); 
        ingredientList.add(new Ingredient("Mango(s)","Large",1.30)); 
        ingredientList.add(new Ingredient("Head(s) of Lettuce","Medium",.95)); 
        ingredientList.add(new Ingredient("Chopped Green Onion","Cup(s)",1.30));         
        ingredientList.add(new Ingredient("Apple(s)","Large",.30));   
        ingredientList.add(new Ingredient("Banana(s)","Medium",.05));           
        ingredientList.add(new Ingredient("Paprika","Tsp(s)",.11));   
        ingredientList.add(new Ingredient("Ginger","Ounce(s)",.44));  
        ingredientList.add(new Ingredient("Chili Powder","Tsp(s)",.24));  
        ingredientList.add(new Ingredient("Ground Cinnamon","Tsp(s)",.34));  
        ingredientList.add(new Ingredient("Vanilla","Tsp(s)",.14)); 
        ingredientList.add(new Ingredient("Coriander","Tsp(s)",.14)); 
        
        recipeList.add(new Recipe("Baked Quinoa Black Bean Falafel"));
        recipeList.get(0).addIngredient("Quinoa", 1, "Cup(s)");
        recipeList.get(0).addIngredient("Black Beans", 15, "Ounce(s)");
        recipeList.get(0).addIngredient("Coriander", .5, "Tsp(s)");
        recipeList.get(0).addIngredient("Tomato Paste", 1, "Tbsp(s)");
        recipeList.get(0).addIngredient("Garlic", 15, "Gram(s)");
        recipeList.get(0).addIngredient("Salt", 1, "Tsp(s)");
        recipeList.get(0).addIngredient("Pepper", .5, "Tsp(s)");
        
        recipeList.add(new Recipe("Caribbean Grilled Salmon Kabobs"));
        recipeList.get(1).addIngredient("Salmon", 2, "Pound(s)");
        recipeList.get(1).addIngredient("Pineapple", 3, "Cup(s)");
        recipeList.get(1).addIngredient("Red Onion(s)", 1, "Medium");
        recipeList.get(1).addIngredient("Bell Pepper(s)", 2, "Large");
        recipeList.get(1).addIngredient("Cajun Seasoning", 1, "Tbsp(s)");
        recipeList.get(1).addIngredient("Garlic Powder", 1, "Tsp(s)");
        
        recipeList.add(new Recipe("Chicken Tacos"));
        recipeList.get(2).addIngredient("Chicken", 1.5, "Pound(s)");  
        recipeList.get(2).addIngredient("Salsa", 6, "Ounce(s)");
        recipeList.get(2).addIngredient("Tortilla(s)", 2, "Medium");
        recipeList.get(2).addIngredient("Tomato(es)", 1, "Large");
        recipeList.get(2).addIngredient("Chedder Cheese", 3.5, "Ounce(s)");    
        recipeList.get(2).addIngredient("Taco Seasoning", 3, "Tbsp(s)"); 
        
        recipeList.add(new Recipe("Peach Frozen Yogurt"));        
        recipeList.get(3).addIngredient("Peach(es)", 4, "Large");  
        recipeList.get(3).addIngredient("Greek Yogurt", 1.5, "Cup(s)");  
        recipeList.get(3).addIngredient("Lemon Juice", 1, "Tbsp(s)");  
        recipeList.get(3).addIngredient("Vanilla", 1, "Tsp(s)");  
        recipeList.get(3).addIngredient("Agave Nectar", 3, "Tbsp(s)"); 
        
        recipeList.add(new Recipe("Mango and Shrimp Lettuce Wraps"));      
        recipeList.get(4).addIngredient("Olive Oil", 1, "Tbsp(s)"); 
        recipeList.get(4).addIngredient("Garlic", 15, "Gram(s)"); 
        recipeList.get(4).addIngredient("Shrimp", 12, "Ounce(s)"); 
        recipeList.get(4).addIngredient("Mango(s)", 1, "Large"); 
        recipeList.get(4).addIngredient("Lime Juice", 2, "Tsp(s)"); 
        recipeList.get(4).addIngredient("Salt", .25, "Tsp(s)"); 
        recipeList.get(4).addIngredient("Head(s) of Lettuce", 1, "Medium");
        recipeList.get(4).addIngredient("Chopped Green Onion", .25, "Cup(s)"); 
        
        
        //Sorts recipes by names A-Z
        Collections.sort(recipeList, new RecipeNameComparator());      
        
        //Sorts ingredients by names A-Z
        Collections.sort(ingredientList, new IngredientNameComparator());
        
        //Initial population of tables and checks
        RefreshIngredTable();
        RefreshIngredSelection();
        RefreshRecipeNames();
        CalculateRecipePrices();
        IngredientUsedCheck(); 
        tfIngAmount.setText("");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");
        tblRecipeNames.changeSelection(0,0, false,false);
        RefreshRecipeListAndEdit();
        
        //Center header labels in recipe edit and list tables
        TableCellRenderer headerRendererRecipeEdit = tblEditRecipe.getTableHeader().getDefaultRenderer();
        JLabel editRecipeListheaderLabel = (JLabel) headerRendererRecipeEdit;
        editRecipeListheaderLabel.setHorizontalAlignment(JLabel.CENTER);   
        DefaultTableCellRenderer rightAlignText = new DefaultTableCellRenderer();
        rightAlignText.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer centerAlignText = new DefaultTableCellRenderer();
        centerAlignText.setHorizontalAlignment(SwingConstants.CENTER);        
        tblEditRecipe.getColumn("Amount").setCellRenderer(rightAlignText);
        
        TableCellRenderer headerRendererIngredList= tblIngred.getTableHeader().getDefaultRenderer();
        JLabel ingredListheaderLabel = (JLabel) headerRendererIngredList;
        ingredListheaderLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tfEditRecipeName.getDocument().addDocumentListener(documentListener); 
    }
    

    

    

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      System = new javax.swing.JTabbedPane();
      ingredients = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblIngred = new javax.swing.JTable();
      jLabel11 = new javax.swing.JLabel();
      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      tfIngredName = new javax.swing.JTextField();
      cbIngredUnit = new javax.swing.JComboBox<>();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      tfIngredPrice = new javax.swing.JTextField();
      bCreateIng = new javax.swing.JButton();
      bUpdate = new javax.swing.JButton();
      bDeleteIng = new javax.swing.JButton();
      bClearIng = new javax.swing.JButton();
      tfIngredWarning = new javax.swing.JTextField();
      recipes = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      tblRecipeNames = new javax.swing.JTable();
      jTabbedPane2 = new javax.swing.JTabbedPane();
      jPanel2 = new javax.swing.JPanel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      tfListRecipeName = new javax.swing.JTextField();
      tfRecipePrice = new javax.swing.JTextField();
      jScrollPane5 = new javax.swing.JScrollPane();
      lRecipeList = new javax.swing.JList<>();
      jLabel12 = new javax.swing.JLabel();
      jPanel3 = new javax.swing.JPanel();
      tfEditRecipeName = new javax.swing.JTextField();
      jLabel5 = new javax.swing.JLabel();
      cbIngSelection = new javax.swing.JComboBox<>();
      jLabel4 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      tfIngAmount = new javax.swing.JTextField();
      jLabel9 = new javax.swing.JLabel();
      jScrollPane4 = new javax.swing.JScrollPane();
      tblEditRecipe = new javax.swing.JTable();
      bAddIngredToR = new javax.swing.JButton();
      jLabel10 = new javax.swing.JLabel();
      bRemoveIngredFromR = new javax.swing.JButton();
      bUpdateIngInRecipe = new javax.swing.JButton();
      tfIngUnit = new javax.swing.JTextField();
      tfRecipeIngredientWarning = new javax.swing.JTextField();
      tfRecipeNameWarning = new javax.swing.JTextField();
      bDeleteRecipe = new javax.swing.JButton();
      bNewRecipe = new javax.swing.JButton();
      tfRecipeWarning = new javax.swing.JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      ingredients.setForeground(new java.awt.Color(255, 0, 51));

      tblIngred.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Ingredient", "Unit", "Price", "Used?"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      tblIngred.getTableHeader().setReorderingAllowed(false);
      tblIngred.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblIngredMouseClicked(evt);
         }
      });
      tblIngred.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            tblIngredKeyReleased(evt);
         }
      });
      jScrollPane1.setViewportView(tblIngred);
      if (tblIngred.getColumnModel().getColumnCount() > 0) {
         tblIngred.getColumnModel().getColumn(0).setPreferredWidth(140);
         tblIngred.getColumnModel().getColumn(1).setPreferredWidth(50);
         tblIngred.getColumnModel().getColumn(2).setPreferredWidth(20);
         tblIngred.getColumnModel().getColumn(3).setPreferredWidth(30);
      }

      jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
      jLabel11.setText("Ingredient List:");

      jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

      jLabel1.setText("Ingredient:");

      tfIngredName.setToolTipText("Type in the name of the ingredient.");

      cbIngredUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Cup(s)", "Fl. Ounce(s)", "Gallon(s)", "Gram(s)", "Large", "Liter(s)", "Medium", "Ounce(s)", "Pinch(s)", "Pint(s)", "Pound(s)", "Small", "Tbsp(s)", "Tsp(s)" }));
      cbIngredUnit.setSelectedItem("");
      cbIngredUnit.setToolTipText("Select the unit of measurement.");

      jLabel2.setText("Unit of Measurement:");

      jLabel3.setText("Price Per Unit:");

      tfIngredPrice.setToolTipText("Type in the price per unit of measurement");
      tfIngredPrice.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            tfIngredPriceActionPerformed(evt);
         }
      });

      bCreateIng.setText("Create");
      bCreateIng.setToolTipText("Click to create the ingredient.");
      bCreateIng.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bCreateIngActionPerformed(evt);
         }
      });

      bUpdate.setText("Update");
      bUpdate.setToolTipText("Click to update the selected ingredient.");
      bUpdate.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bUpdateActionPerformed(evt);
         }
      });

      bDeleteIng.setText("Delete");
      bDeleteIng.setToolTipText("Click to delete the selected ingredient.");
      bDeleteIng.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bDeleteIngActionPerformed(evt);
         }
      });

      bClearIng.setText("Clear");
      bClearIng.setToolTipText("Click to clear all of the fields.");
      bClearIng.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bClearIngActionPerformed(evt);
         }
      });

      tfIngredWarning.setEditable(false);
      tfIngredWarning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfIngredWarning.setBorder(null);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel2)
                     .addComponent(jLabel3))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(cbIngredUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(tfIngredPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGap(54, 54, 54)
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tfIngredName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(44, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(bClearIng, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(bCreateIng, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(bDeleteIng, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(tfIngredWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(30, 30, 30))))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tfIngredName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel1))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(cbIngredUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tfIngredPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tfIngredWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(bCreateIng)
               .addComponent(bUpdate)
               .addComponent(bDeleteIng)
               .addComponent(bClearIng))
            .addContainerGap(23, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout ingredientsLayout = new javax.swing.GroupLayout(ingredients);
      ingredients.setLayout(ingredientsLayout);
      ingredientsLayout.setHorizontalGroup(
         ingredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ingredientsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingredientsLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11)
            .addGap(129, 129, 129))
      );
      ingredientsLayout.setVerticalGroup(
         ingredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingredientsLayout.createSequentialGroup()
            .addGap(4, 4, 4)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(ingredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );

      System.addTab("Ingredients", ingredients);

      tblRecipeNames.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Recipes"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class
         };
         boolean[] canEdit = new boolean [] {
            false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      tblRecipeNames.setToolTipText("");
      tblRecipeNames.setMinimumSize(new java.awt.Dimension(0, 0));
      tblRecipeNames.getTableHeader().setReorderingAllowed(false);
      tblRecipeNames.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblRecipeNamesMouseClicked(evt);
         }
      });
      tblRecipeNames.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            tblRecipeNamesKeyReleased(evt);
         }
      });
      jScrollPane2.setViewportView(tblRecipeNames);

      jTabbedPane2.setToolTipText("");

      jLabel6.setText("Name:");

      jLabel7.setText("Price:");

      tfListRecipeName.setEditable(false);

      tfRecipePrice.setEditable(false);
      tfRecipePrice.setHorizontalAlignment(tfRecipePrice.CENTER);

      lRecipeList.setBackground(new java.awt.Color(240, 240, 240));
      lRecipeList.setModel(new DefaultListModel());
      jScrollPane5.setViewportView(lRecipeList);

      jLabel12.setText("Ingredients:");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel7)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tfRecipePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                     .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                     .addComponent(tfListRecipeName))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tfListRecipeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel6))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel12))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tfRecipePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel7))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jTabbedPane2.addTab("View", jPanel2);

      jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jPanel3MouseExited(evt);
         }
      });

      tfEditRecipeName.setToolTipText("Type in the name of the recipe.");
      tfEditRecipeName.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            tfEditRecipeNameMouseExited(evt);
         }
      });
      tfEditRecipeName.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            tfEditRecipeNameKeyReleased(evt);
         }
         public void keyTyped(java.awt.event.KeyEvent evt) {
            tfEditRecipeNameKeyTyped(evt);
         }
      });

      jLabel5.setText("Recipe Name:");

      cbIngSelection.setToolTipText("Select an ingredient to add to the recipe.");
      cbIngSelection.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
         public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
         }
         public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            cbIngSelectionPopupMenuWillBecomeInvisible(evt);
         }
         public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
         }
      });
      cbIngSelection.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            cbIngSelectionKeyReleased(evt);
         }
      });

      jLabel4.setText("Ingredient:");

      jLabel8.setText("Amount:");

      tfIngAmount.setToolTipText("Type in the amount of the ingredient.");

      tblEditRecipe.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Amount", " Unit", " Ingredient"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Object.class, java.lang.String.class, java.lang.String.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      tblEditRecipe.getTableHeader().setReorderingAllowed(false);
      tblEditRecipe.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblEditRecipeMouseClicked(evt);
         }
      });
      jScrollPane4.setViewportView(tblEditRecipe);
      if (tblEditRecipe.getColumnModel().getColumnCount() > 0) {
         tblEditRecipe.getColumnModel().getColumn(0).setResizable(false);
         tblEditRecipe.getColumnModel().getColumn(0).setPreferredWidth(4);
         tblEditRecipe.getColumnModel().getColumn(1).setResizable(false);
         tblEditRecipe.getColumnModel().getColumn(1).setPreferredWidth(4);
         tblEditRecipe.getColumnModel().getColumn(2).setResizable(false);
         tblEditRecipe.getColumnModel().getColumn(2).setPreferredWidth(120);
      }

      bAddIngredToR.setText("Add Ing.");
      bAddIngredToR.setToolTipText("Click to add the ingredient.");
      bAddIngredToR.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bAddIngredToRActionPerformed(evt);
         }
      });

      jLabel10.setText("Unit:");

      bRemoveIngredFromR.setText("Remove Ing.");
      bRemoveIngredFromR.setToolTipText("Click to remove the selected ingredient.");
      bRemoveIngredFromR.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bRemoveIngredFromRActionPerformed(evt);
         }
      });

      bUpdateIngInRecipe.setText("Update Ing.");
      bUpdateIngInRecipe.setToolTipText("Click to update the selected ingredient.");
      bUpdateIngInRecipe.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bUpdateIngInRecipeActionPerformed(evt);
         }
      });

      tfIngUnit.setEditable(false);
      tfIngUnit.setToolTipText("This is the unit of measurement for the ingredient.");

      tfRecipeIngredientWarning.setEditable(false);
      tfRecipeIngredientWarning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfRecipeIngredientWarning.setBorder(null);

      tfRecipeNameWarning.setEditable(false);
      tfRecipeNameWarning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfRecipeNameWarning.setBorder(null);

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(80, 80, 80)
                  .addComponent(jLabel8)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tfIngAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(98, 98, 98)
                  .addComponent(jLabel10)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tfIngUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfEditRecipeName, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bAddIngredToR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdateIngInRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bRemoveIngredFromR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(46, 46, 46)
                  .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(67, 67, 67)
                  .addComponent(jLabel4)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cbIngSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addGap(70, 70, 70)
                  .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(tfRecipeNameWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(tfRecipeIngredientWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(0, 0, Short.MAX_VALUE))
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(tfEditRecipeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tfRecipeNameWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(cbIngSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4))
            .addGap(11, 11, 11)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tfIngAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel8))
            .addGap(11, 11, 11)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tfIngUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel10))
            .addGap(17, 17, 17)
            .addComponent(tfRecipeIngredientWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(bAddIngredToR)
               .addComponent(bUpdateIngInRecipe)
               .addComponent(bRemoveIngredFromR))
            .addGap(17, 17, 17)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jTabbedPane2.addTab("Edit", jPanel3);

      bDeleteRecipe.setText("Delete Recipe");
      bDeleteRecipe.setToolTipText("Click to delete the selected recipe.");
      bDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bDeleteRecipeActionPerformed(evt);
         }
      });

      bNewRecipe.setText("New Recipe");
      bNewRecipe.setToolTipText("Click to create a blank recipe.");
      bNewRecipe.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bNewRecipeActionPerformed(evt);
         }
      });

      tfRecipeWarning.setEditable(false);
      tfRecipeWarning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfRecipeWarning.setBorder(null);

      javax.swing.GroupLayout recipesLayout = new javax.swing.GroupLayout(recipes);
      recipes.setLayout(recipesLayout);
      recipesLayout.setHorizontalGroup(
         recipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(recipesLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(recipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(recipesLayout.createSequentialGroup()
                  .addComponent(bNewRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(bDeleteRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(recipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(tfRecipeWarning, javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
            .addGap(10, 10, 10)
            .addComponent(jTabbedPane2)
            .addGap(6, 6, 6))
      );
      recipesLayout.setVerticalGroup(
         recipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(recipesLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(recipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(recipesLayout.createSequentialGroup()
                  .addComponent(jTabbedPane2)
                  .addContainerGap())
               .addGroup(recipesLayout.createSequentialGroup()
                  .addComponent(jScrollPane2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tfRecipeWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(recipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(bDeleteRecipe)
                     .addComponent(bNewRecipe))
                  .addGap(11, 11, 11))))
      );

      System.addTab("Recipes", recipes);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(System)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(System)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents


    
 DocumentListener documentListener;
       

    
    private void CheckRecipeName(){
     if(tfEditRecipeName.getText().equals("") || tfEditRecipeName.getText().equals(" ")){
             
             //Set boolean to false
        boolean alreadyABlankRecipe = false;
        tfRecipeWarning.setText("");
        tfRecipeIngredientWarning.setText("");
                    tfRecipeNameWarning.setForeground(Color.RED);
            tfRecipeNameWarning.setText("Recipe name cannot be blank.");
        //Is there already a recipe named new recipe
        for(int i=0; i<recipeList.size();i++){
            if(recipeList.get(i).getName().equals("(New Recipe)")){
                alreadyABlankRecipe =true;
            }
                
        }
        
        
        
        //If not create one
        if(alreadyABlankRecipe==false){
            tfEditRecipeName.setText("(New Recipe)");
            RefreshRecipeNames();
            
            int position=0;
            //Find the new recipe position
            for(int i =0; i < recipeList.size(); i++)
            {
                if (recipeList.get(i).getName().equals("(New Recipe)")){
                    position=i;
                }         
            }  
            //Select the newly created blank recipe in the list and enable edit screen
            tblRecipeNames.changeSelection(position,0, false,false);

            
            //Refresh the tables to show changes
            RefreshRecipeListAndEdit();    
        }
        else{
            
            boolean addedYet =false;
            int iteration = 1;
            String name = "(New Recipe)_";
            int position =0;
           
            boolean newRecipeOne =false;
            
            
            for(int i=0; i<recipeList.size();i++){
            if(recipeList.get(i).getName().equals(name+iteration)){
                newRecipeOne =true;             
            }

              
            
        }
             
            while(addedYet==false){
               boolean goOn=false;
                for (int i =0; i<recipeList.size();i++){
                    if (recipeList.get(i).getName().equals(name+iteration)){
                        i=0;
                        iteration++;
                        goOn=true;
                    } 
                    }
                    if(goOn==false){
                     addedYet=true; 
                    tfEditRecipeName.setText(name+iteration);
                    
                    }
                            
          
          
            
            }
         
            //if it does exist show warning
           // tfRecipeWarning.setForeground(Color.red);
          //  tfRecipeWarning.setText("A new recipe already exists.");

            //Select the newly created blank recipe in the list and enable edit screen
            RefreshRecipeNames();
            
            
                        for(int i =0; i < recipeList.size(); i++)
            {
                if (recipeList.get(i).getName().equals(name+iteration)){
                    position=i;
                }         
            }  
            
            tblRecipeNames.changeSelection(position,0, false,false);
          RefreshRecipeListAndEdit();
 
        }
         
         }
    }
 
    //Method to round doubles and remove redundant 0's
    private String ConvertAmountToFriendly(double amount){
    
    //Convert double to string and find out how many decimal places there are
        String number = String.valueOf(amount);
        int intPlaces = number.indexOf('.');
        int decPlaces = number.length() - intPlaces -1;
        
        //If X.0 Remove .0 leaving only X
        if (decPlaces == 1){
            if(number.charAt(intPlaces+1) == '0'){   
                number = number.replace(".0","");     
            }
        }
        
        //If more than two decimal places
        if (decPlaces > 2){
            
            //Round to two decimal places
            double rounded = Math.round(amount * 100.0) / 100.0;
            
            //Redo the check for amount of places
            number = String.valueOf(rounded);
            intPlaces = number.indexOf('.');
            decPlaces = number.length() - intPlaces -1;
            
            //If X.0 remove .0 leaving only X 
            if (decPlaces == 1){
                if(number.charAt(intPlaces+1) == '0'){
                    number = number.replace(".0","");     
                }
            }
        }

    //Return the friendly looking number
    return number;
    
    }
    
    
    //Function to calculate all of the recipe prices
    private void CalculateRecipePrices(){
     
        //For every recipe 
        for (int v = 0; v < recipeList.size();v++){
           
            //Reset the price to 0
            recipeList.get(v).setPrice(0);
            double total = 0;
           
            //For every ingredient in the recipe
            for (int i=0; i < recipeList.get(v).getNumOfIngredients(); i++){
               
                //Get the ingredient and quantity data
                String recipeIng =recipeList.get(v).getIngAt(i);
                double recipeIngAmount = recipeList.get(v).getQuantityAt(i);
              
                //Find it in the ingredient list
                for(int h=0; h < ingredientList.size();h++){
                    if (ingredientList.get(h).getName().equals(recipeIng)){
                  
                        //Multiple the quantity and price and add it to the recipe price
                        double ingPrice =ingredientList.get(h).getPrice();
                        total += recipeIngAmount * ingPrice;  
                        
                    }           
                }  
                //Set the price
                recipeList.get(v).setPrice(total);
            }
        }
    }
    
    //Method to calculate only one recipe
    private void CalculateOneRecipePrice(String name){
        
        int position = 0;
        
        //Find the recipe in the array
        for(int m =0;m < recipeList.size();m++){
            if(recipeList.get(m).getName().equals(name)){
                position =m;
            } 
        }
        
        //Reset the recipe price
        recipeList.get(position).setPrice(0);
        double total = 0;
           
        //For every ingredient in the recipe
        for (int i=0; i < recipeList.get(position).getNumOfIngredients(); i++){
               
            //Get the ingredient and quantity data
            String recipeIng =recipeList.get(position).getIngAt(i);
            double recipeIngAmount = recipeList.get(position).getQuantityAt(i);
              
            //Find it in the ingredient list
            for(int h=0; h < ingredientList.size();h++){
                if (ingredientList.get(h).getName().equals(recipeIng)){
                  
                    //Multiple the quantity and price and add it to the recipe price
                    double ingPrice =ingredientList.get(h).getPrice();
                    total += recipeIngAmount * ingPrice;  
                }           
            }  
            //Set the price
            recipeList.get(position).setPrice(total);
        }
    }
    
    //Function to auto fill units in recipe edit screen for the ingredient selected in combo box
    private String IngredientUnitSearch(String ingredient){
            
        String unit = "";
        
        //Find the ingredient in the list and get its unit of measurement
        for (int i=0; i < ingredientList.size();i++){
            if (ingredientList.get(i).getName().equals(ingredient)){
                unit = ingredientList.get(i).getUnitOfM();  
                } 
            }
    
        //Return the unit of measurement
        return unit;
    }
    
    //Function to check every ingredient if it is used or not
    private void IngredientUsedCheck(){
      
        //Start with false
        boolean isUsed= false;
        
        //For every ingredient
            for (int h=0; h <ingredientList.size(); h++){
                String ing = ingredientList.get(h).getName();
        
            //For every recipe
            for (int i =0; i < recipeList.size();i++){
                if(isUsed==false){
                    //For every ingredient in recipe
                    for(int j=0; j < recipeList.get(i).getNumOfIngredients();j++){
                 
                        if(isUsed==false){    
                            //Set isused to true if found
                            if(recipeList.get(i).ingredients.get(j).toLowerCase().equals(ing.toLowerCase())){
                            isUsed=true;
                            }
                        }
                    }
                }
            }
          
            //Set the ingredient used boolean
            ingredientList.get(h).setIsUsed(isUsed);
         
            //Reset boolean to false
            isUsed=false;  
            } 
      
            //refresh the ingredient table to show changes
        RefreshIngredTable();
    }    
  
    //Function to refresh ingredient table
    private void RefreshIngredTable(){
 
        DefaultTableModel ingredTable=(DefaultTableModel) tblIngred.getModel();
        
        //sorts ingredient names A-Z
        Collections.sort(ingredientList, new IngredientNameComparator());   
        
            //Delete every row
            int rowCount = ingredTable.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                ingredTable.removeRow(i);
            }
           
            //Get number of ingredients
            int ingredCount = ingredientList.size();
            
                //Add ingredients to the table
                for (int i = 0; i < ingredCount; i++){        
                String numberAsString = String.format ("%.2f", ingredientList.get(i).getPrice());
            
                
                ingredTable.addRow(new Object[]{ingredientList.get(i).getName(),ingredientList.get(i).getUnitOfM(),numberAsString,ingredientList.get(i).getIsUsed()});
                } 
    }   
  
    //Function to refresh ingredeint selection combo box
    private void RefreshIngredSelection(){
       
        //Sorts ingredients A-Z
        Collections.sort(ingredientList, new IngredientNameComparator());
        
        //Delete everything in combo box
        cbIngSelection.removeAllItems();
        
        //Add a blank entry 
        cbIngSelection.addItem("");
       
        //Add all of the ingredients      
        for (int i = 0; i < ingredientList.size(); i++){
        cbIngSelection.addItem(ingredientList.get(i).getName());
        }
    }
   
    //Function to refresh the recipe names table
    private void RefreshRecipeNames(){
        
        //Allows advanced table editing
        DefaultTableModel recipeNamesTable=(DefaultTableModel) tblRecipeNames.getModel();
        
        //Sorts recipe names A-Z
        Collections.sort(recipeList, new RecipeNameComparator());    
                
        //Remove every row
        int rowCount = recipeNamesTable.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                recipeNamesTable.removeRow(i);           
                }  
              
        // Add all of the recipe names
            for(int i =0; i < recipeList.size();i++ ){
                recipeNamesTable.addRow(new Object[]{recipeList.get(i).getName()});
                }
        }
   
    //Function to refresh the two tables
    private void RefreshRecipeListAndEdit(){
        
        //Allows for advanced table editing
        DefaultTableModel editRecipeTable=(DefaultTableModel) tblEditRecipe.getModel();
        DefaultTableModel RecipeNamesTable=(DefaultTableModel) tblRecipeNames.getModel();
        DefaultListModel listModel = (DefaultListModel) lRecipeList.getModel();
        
       
        //Set the text fields of the recipenames to the selected
        tfEditRecipeName.setText(RecipeNamesTable.getValueAt(tblRecipeNames.getSelectedRow(),0).toString());
        tfListRecipeName.setText(RecipeNamesTable.getValueAt(tblRecipeNames.getSelectedRow(),0).toString());
       
        //Clear both tables
        ClearRecipeEditList();
        ClearRecipeList();
      
        //Set position to 0
        int position=0;
      
        //Find the recipe in the list
        for(int i =0; i < recipeList.size(); i++){  
            if (recipeList.get(i).getName().toLowerCase().equals(RecipeNamesTable.getValueAt(tblRecipeNames.getSelectedRow(),0).toString().toLowerCase())){
               
                //Set position to its location
                position=i;
                }     
        }
      

        //For every ingredient populate the view and edit tables with the ingredients
        for (int i=0; i < recipeList.get(position).ingredients.size(); i++){ 

            //Convert quantity to friendly looking number
            String number= ConvertAmountToFriendly(recipeList.get(position).getQuantityAt(i));
  
            //Add the data to the two recipe tables
            editRecipeTable.addRow(new Object[]{number,recipeList.get(position).unitOfM.get(i),recipeList.get(position).getIngAt(i)});
            listModel.addElement(number+ " " + recipeList.get(position).unitOfM.get(i) + " " + recipeList.get(position).getIngAt(i));    
        }
      
        //Display price as $XX.XX
        String numberAsString = String.format ("%.2f", recipeList.get(position).getPrice());
        tfRecipePrice.setText("$ " + numberAsString);
    }
    
    //Function to clear the recipe edit list
    private void ClearRecipeEditList(){
    
        //Allows advanced table editing   
        DefaultTableModel editRecipeTable=(DefaultTableModel) tblEditRecipe.getModel();
       
        //Get row count
        int rowCount = editRecipeTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
      
            //Remove every row
            editRecipeTable.removeRow(i);
                  
        }    
    }
    
    //Function to clear the recipe show list
    private void ClearRecipeList(){
       
        //Allows for advance table editing 
        DefaultListModel listModel = (DefaultListModel) lRecipeList.getModel();
        
        //delete everything
        listModel.removeAllElements();   
    }  
       
    private void tblRecipeNamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecipeNamesMouseClicked
   
        //Refresh tables to show selected data
        RefreshRecipeListAndEdit();
        
        //Clear warnings
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        tfIngAmount.setText("");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");
        tfRecipeNameWarning.setText("");
    
    }//GEN-LAST:event_tblRecipeNamesMouseClicked

    private void bUpdateIngInRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateIngInRecipeActionPerformed
      
        //Clear warnings
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        tfRecipeNameWarning.setText("");
      
        //Allows for advanced table editing
        DefaultTableModel editRecipeTable=(DefaultTableModel) tblEditRecipe.getModel();
     
        //Get row cound of the table
        int rowCount = editRecipeTable.getRowCount();
        
        boolean isAnIngredientNotSelected = tblEditRecipe.getSelectionModel().isSelectionEmpty();
             
        //Set amountEmpty to false
        boolean amountEmpty=false;
        
        //Check if the ingredient amount box is empty
        if(tfIngAmount.getText().equals("")){
            tfRecipeIngredientWarning.setForeground(Color.red);
            tfRecipeIngredientWarning.setText("Please enter an amount for the ingredient.");
            amountEmpty=true;
        }
        
        boolean amountValid=true;
      
        if(isAnIngredientNotSelected==true){
            tfRecipeIngredientWarning.setForeground(Color.red);
            tfRecipeIngredientWarning.setText("Please select an ingredient to edit.");
        }
        
        //Check if it has a valid entry
        if(amountEmpty == false){
            try {
                Double.parseDouble(tfIngAmount.getText());
            }
            catch (NumberFormatException e) {
                tfRecipeIngredientWarning.setForeground(Color.red);
                tfRecipeIngredientWarning.setText("Ingredient amount can only be a number.");
                amountValid=false;
            }
        }
        
        
        //Find the ingredient in the list and update it
        if(amountEmpty==false && amountValid == true && isAnIngredientNotSelected==false){
            
            //Convert the amount to a friendly looking number
            String number= ConvertAmountToFriendly(Double.parseDouble(tfIngAmount.getText()));
        
            for(int i=0; i < rowCount; i++){
                if(editRecipeTable.getValueAt(i,2).toString().equals(cbIngSelection.getSelectedItem().toString()))
                    {
                    editRecipeTable.setValueAt(cbIngSelection.getSelectedItem().toString(), i, 2);
                    editRecipeTable.setValueAt(number, i, 0);
                    editRecipeTable.setValueAt(tfIngUnit.getText(), i, 1);
                    }
            }
            
        //Set position to 0
        int position=0;
      
        //Find that recipe in the list
        for(int i =0; i < recipeList.size(); i++){  
            if (recipeList.get(i).getName().toLowerCase().equals(tfEditRecipeName.getText().toLowerCase())){
                //Set position to its location
                position=i;
                } 
        }
        
        for (int j=0;j<recipeList.get(position).getNumOfIngredients();j++){
            
            if(recipeList.get(position).getIngAt(j).equals(cbIngSelection.getSelectedItem().toString())){
            recipeList.get(position).updateIngAmount(j,Double.parseDouble(tfIngAmount.getText()));
            }
        }  
        CalculateOneRecipePrice(tfEditRecipeName.getText());
        RefreshRecipeListAndEdit();
        tfIngAmount.setText("");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");  
            
        tfRecipeIngredientWarning.setForeground(Color.black);
        tfRecipeIngredientWarning.setText("Ingredient updated.");
        CheckRecipeName();
        }     
    }//GEN-LAST:event_bUpdateIngInRecipeActionPerformed

    private void bRemoveIngredFromRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveIngredFromRActionPerformed
       
        //Clear warnings
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        tfRecipeNameWarning.setText("");
      
        //Allows for advanced table editing
        DefaultTableModel editRecipeTable=(DefaultTableModel) tblEditRecipe.getModel();
      
        boolean isAnIngredientSelected = tblEditRecipe.getSelectionModel().isSelectionEmpty();
        
        if(isAnIngredientSelected == false){
        //Get the selected row in the table
        int row =tblEditRecipe.getSelectedRow();
     
        int position = 0;
        for(int i = 0; i < recipeList.size(); i++){
        if(recipeList.get(i).getName().equals(tfEditRecipeName.getText())){
        position = i;
        }
        }
        
        //remove the ingredient in the recipe
        recipeList.get(position).removeIngredient(cbIngSelection.getSelectedItem().toString());
        
        //Remove the row
        editRecipeTable.removeRow(row);
        
        //Clear the fields show message run checks and updates 
        tfIngAmount.setText("");   
        tfRecipeIngredientWarning.setForeground(Color.black);
        tfRecipeIngredientWarning.setText("Ingredient has been deleted.");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");
        CalculateOneRecipePrice(tfEditRecipeName.getText());
        RefreshRecipeListAndEdit();
        tfIngAmount.setText("");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");
        IngredientUsedCheck();
        
        }
        
        else{
        tfRecipeIngredientWarning.setForeground(Color.red);
        tfRecipeIngredientWarning.setText("Please select an ingredient to delete.");
        }
        
        CheckRecipeName();
    }//GEN-LAST:event_bRemoveIngredFromRActionPerformed

    private void bAddIngredToRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddIngredToRActionPerformed
     
      //Allows for advanced table editing
        DefaultTableModel editRecipeTable=(DefaultTableModel) tblEditRecipe.getModel();
       
        //Clear warnings
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        tfRecipeNameWarning.setText("");
      
        //Get number of rows in the recipe edit table
        int rowCount = editRecipeTable.getRowCount();
     
        //Set inlist to false
        boolean inList=false;
        
        boolean isBlank=false;
        
        if (cbIngSelection.getSelectedItem().toString().equals("")){
            isBlank=true;  
        }
        
        //Check if it is in the table 
        for(int i=0; i < rowCount; i++){
      
            //If it is in the table set inlist to true and print warning
            if(editRecipeTable.getValueAt(i,2).toString().equals(cbIngSelection.getSelectedItem().toString()))
            {
            inList=true;
            tfRecipeIngredientWarning.setForeground(Color.red);
            tfRecipeIngredientWarning.setText("That ingredient is already in the recipe.");
            }
        }
        //Set amountEmpty to false
        boolean amountEmpty=false;
        
        //Check if the ingredient amount box is empty
        if(tfIngAmount.getText().equals("")){
            tfRecipeIngredientWarning.setForeground(Color.red);
            tfRecipeIngredientWarning.setText("Please enter an amount for the ingredient.");
            amountEmpty=true;
        }
        
        boolean amountValid=true;
        
        //Check if the amount box has a valid entry
        if(amountEmpty == false){
            try {
                Double.parseDouble(tfIngAmount.getText());
            }
            catch (NumberFormatException e) {
                tfRecipeIngredientWarning.setForeground(Color.red);
                tfRecipeIngredientWarning.setText("Ingredient amount can only be a number.");
                amountValid=false;
            }
        }
        
        if (isBlank==true){
        
        tfRecipeIngredientWarning.setForeground(Color.red);
        tfRecipeIngredientWarning.setText("Please select an ingredient to add.");
        }
        

        //If it is not already in the table and fields are valid add it
        if(inList==false && amountEmpty==false && amountValid == true && isBlank==false){
        //Convert amount to a friendly number
        String number= ConvertAmountToFriendly(Double.parseDouble(tfIngAmount.getText()));
        editRecipeTable.addRow(new Object[]{number,tfIngUnit.getText(),cbIngSelection.getSelectedItem().toString()});
        
        int position = 0;
        for(int i = 0; i < recipeList.size(); i++){
        if(recipeList.get(i).getName().equals(tfEditRecipeName.getText())){
        position = i;
        }
        
        }
        
        recipeList.get(position).addIngredient(cbIngSelection.getSelectedItem().toString(),Double.parseDouble(tfIngAmount.getText()),tfIngUnit.getText());
        
        tfIngAmount.setText("");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");
        tfRecipeIngredientWarning.setForeground(Color.black);
        tfRecipeIngredientWarning.setText("Ingredient added.");
        CalculateOneRecipePrice(tfEditRecipeName.getText());
        RefreshRecipeListAndEdit();
        IngredientUsedCheck();

        }       
        CheckRecipeName();
    }//GEN-LAST:event_bAddIngredToRActionPerformed

    private void tblEditRecipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEditRecipeMouseClicked
        
        //allows advanced table editing
        DefaultTableModel editRecipeTable=(DefaultTableModel) tblEditRecipe.getModel();
        
        //Clear warnings
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        
        //Copy table data to appropriate forms
        cbIngSelection.setSelectedItem(editRecipeTable.getValueAt(tblEditRecipe.getSelectedRow(),2).toString());
        tfIngAmount.setText(editRecipeTable.getValueAt(tblEditRecipe.getSelectedRow(), 0).toString());
        tfIngUnit.setText(editRecipeTable.getValueAt(tblEditRecipe.getSelectedRow(),1).toString());
        CheckRecipeName();
        
    }//GEN-LAST:event_tblEditRecipeMouseClicked

    private void bDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteRecipeActionPerformed
      /*  //Allows advanced table editing
        DefaultTableModel recipeNamesTable=(DefaultTableModel) tblRecipeNames.getModel();
        
        //Set position to 0
        int position=0;
        
        //Clear Warnings
        tfRecipeWarning.setText("");
        tfRecipeIngredientWarning.setText("");
        
        //Check if a recipe is selected
        boolean isARecipeSelected = tblRecipeNames.getSelectionModel().isSelectionEmpty();
        
        
        if(isARecipeSelected == false){
        //Get the recipe name in the selected row
        String recipeToDelete= tblRecipeNames.getValueAt(tblRecipeNames.getSelectedRow(),0).toString().toLowerCase();
        
        //Find it in the list
        for(int i =0; i < recipeList.size(); i++)
        {
            //Delete that recipe and clear data on the screen
            if (recipeList.get(i).getName().toLowerCase().equals(recipeToDelete)){
            position=i;
            recipeList.remove(position);
            RefreshRecipeNames();
            ClearRecipeEditList();
            ClearRecipeList();
            IngredientUsedCheck();
            tfEditRecipeName.setText("");
            tfListRecipeName.setText("");
            tfIngAmount.setText("");
            tfRecipeWarning.setForeground(Color.black);
            tfRecipeWarning.setText("Recipe deleted.");
            
            
            
            
            
            if(tblRecipeNames.getRowCount() == 0){
            tfEditRecipeName.setEnabled(false);
            tfIngAmount.setEnabled(false);
            cbIngSelection.setEnabled(false);
            bAddIngredToR.setEnabled(false);
            bUpdateIngInRecipe.setEnabled(false);
            bRemoveIngredFromR.setEnabled(false);
            tblEditRecipe.setEnabled(false);
            }
            
            
            else{
            tblRecipeNames.changeSelection(0,0, false,false);
            RefreshRecipeListAndEdit();
            }
            
            
            
            
            
            
            
            
            
            
            }  
        }
        }
        else{
        //if not selected then print a warning
        tfRecipeWarning.setForeground(Color.red);
        tfRecipeWarning.setText("Please select a recipe to delete.");
        }   
     */   
    }//GEN-LAST:event_bDeleteRecipeActionPerformed

    private void bNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewRecipeActionPerformed
       
        //Set boolean to false
        boolean alreadyABlankRecipe = false;
        tfRecipeWarning.setText("");
        tfRecipeNameWarning.setText("");
        tfRecipeIngredientWarning.setText("");
        //Is there already a recipe named new recipe
        for(int i=0; i<recipeList.size();i++){
            if(recipeList.get(i).getName().equals("(New Recipe)")){
                alreadyABlankRecipe =true;
            }
                
        }
        
        
        
        //If not create one
        if(alreadyABlankRecipe==false){
            recipeList.add(new Recipe("(New Recipe)"));
            RefreshRecipeNames();
            
            int position=0;
            //Find the new recipe position
            for(int i =0; i < recipeList.size(); i++)
            {
                if (recipeList.get(i).getName().equals("(New Recipe)")){
                    position=i;
                }         
            }  
            //Select the newly created blank recipe in the list and enable edit screen
            tblRecipeNames.changeSelection(position,0, false,false);
            tfEditRecipeName.setEnabled(true);
            tfIngAmount.setEnabled(true);
            cbIngSelection.setEnabled(true);
            bAddIngredToR.setEnabled(true);
            bUpdateIngInRecipe.setEnabled(true);
            bRemoveIngredFromR.setEnabled(true);
            tblEditRecipe.setEnabled(true);
            tfRecipeWarning.setText("A new recipe has been created.");
            
            //Refresh the tables to show changes
            RefreshRecipeListAndEdit();    
        }
        else{
            
            boolean addedYet =false;
            int iteration = 1;
            String name = "(New Recipe)_";
            int position =0;
           
            boolean newRecipeOne =false;
            
            
            for(int i=0; i<recipeList.size();i++){
            if(recipeList.get(i).getName().equals(name+iteration)){
                newRecipeOne =true;             
            }

              
            
        }
             
            while(addedYet==false){
               boolean goOn=false;
                for (int i =0; i<recipeList.size();i++){
                    if (recipeList.get(i).getName().equals(name+iteration)){
                        i=0;
                        iteration++;
                        goOn=true;
                    } 
                    }
                    if(goOn==false){
                     addedYet=true; 
                    recipeList.add(new Recipe(name+iteration));
                    }
                            
          
          
            
            }
         
            //if it does exist show warning
           // tfRecipeWarning.setForeground(Color.red);
          //  tfRecipeWarning.setText("A new recipe already exists.");

            //Select the newly created blank recipe in the list and enable edit screen
            RefreshRecipeNames();
            
            
                        for(int i =0; i < recipeList.size(); i++)
            {
                if (recipeList.get(i).getName().equals(name+iteration)){
                    position=i;
                }         
            }  
            
            tblRecipeNames.changeSelection(position,0, false,false);
          RefreshRecipeListAndEdit();
        }
        
        
        
    }//GEN-LAST:event_bNewRecipeActionPerformed

    private void tblIngredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngredMouseClicked
        
        //Allows advanced table editing
        DefaultTableModel ingTable=(DefaultTableModel) tblIngred.getModel();
       
        //Fill in the text boxes with the selected rows
        tfIngredName.setText(ingTable.getValueAt(tblIngred.getSelectedRow(),0).toString());
        cbIngredUnit.setSelectedItem(ingTable.getValueAt(tblIngred.getSelectedRow(), 1).toString());
        tfIngredPrice.setText(ingTable.getValueAt(tblIngred.getSelectedRow(),2).toString());
        tfIngredWarning.setText("");
        
    }//GEN-LAST:event_tblIngredMouseClicked

    private void bDeleteIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteIngActionPerformed
  //Remember the Ingredient needs to be deleted from the recipe as well.
   
        
      if(tfIngredName.getText().equals("")){
            tfIngredWarning.setForeground(Color.red);
            tfIngredWarning.setText("Please select an ingredient to delete.");
                    
            
          }
  
   else if(tfIngredPrice.getText().equals("")){
                 tfIngredWarning.setText("Please enter a price per unit.");
                 tfIngredWarning.setForeground(Color.red);
    }
            
                 
  else{
        
       tfIngredWarning.setText("Ingredient removed!");
       tfIngredWarning.setForeground(Color.black);
       
       
   {
        ingredientList.remove(tblIngred.getSelectedRow()); 
         RefreshIngredTable();
   }
     
    
       for (int v=1; v< recipeList.size();v++){
           
           for(int i=0; i < recipeList.get(v).getNumOfIngredients();i++){
               if(recipeList.get(v).getIngAt(i).equals(tfIngredName.getText()))
               {
                  
                   recipeList.get(v).removeIngredient(tfIngredName.getText());
                   
               }
           
           tfIngredWarning.setText("Ingredient Deleted!");
             tfIngredWarning.setForeground(Color.black);
           }  
           
        
       }
         

    
      tfIngredName.setText("");
       tfIngredPrice.setText("");
      cbIngredUnit.setSelectedItem(" ");
                  
               
   CalculateRecipePrices();
   
       RefreshRecipeListAndEdit();
               
       RefreshIngredSelection();
   
 
      
    
      
     
                   
       
   }
    
                       
    
           }//GEN-LAST:event_bDeleteIngActionPerformed

    private void bCreateIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateIngActionPerformed
   
      
      boolean doesNameAlreadyExist=false;
      boolean isIngPriceValid=true;
      
      try {
           Double.parseDouble(tfIngredPrice.getText());
            }
            catch (NumberFormatException e) {
                
               isIngPriceValid=false; 
            }
      for (int i =0; i < ingredientList.size();i++)
          if(ingredientList.get(i).getName().toLowerCase().equals(tfIngredName.getText().toLowerCase())){
          doesNameAlreadyExist=true;
          }
        
        
      if(tfIngredName.getText().equals("")){
            tfIngredWarning.setForeground(Color.red);
            tfIngredWarning.setText("Please enter a name for the ingredient.");
            
          }
      
      else if(doesNameAlreadyExist==true){
            tfIngredWarning.setForeground(Color.red);
            tfIngredWarning.setText("That ingredient already exists.");     
      }
  
   else if(tfIngredPrice.getText().equals("")){
                  tfIngredWarning.setForeground(Color.red);
                 tfIngredWarning.setText("Please enter a price per unit.");
    }
   else if(cbIngredUnit.getSelectedItem().equals(" ")){ 
                 tfIngredWarning.setForeground(Color.red);
                 tfIngredWarning.setText("Please select a unit of measurement.");
   }
            
    else if(isIngPriceValid==false){ 
                 tfIngredWarning.setForeground(Color.red);
                 tfIngredWarning.setText("Ingredient price can only be a number.");
   }
                
  else{
       

       tfIngredWarning.setForeground(Color.black);
       tfIngredWarning.setText("Ingredient Created!");
 
       String UppercasedName = tfIngredName.getText().substring(0, 1).toUpperCase() + tfIngredName.getText().substring(1);
       ingredientList.add(new Ingredient(UppercasedName, (String) cbIngredUnit.getSelectedItem(),Double.parseDouble(tfIngredPrice.getText())));
       
        tfIngredName.setText("");
        cbIngredUnit.setSelectedItem(" ");
        tfIngredPrice.setText("");
 
    
  
   
    RefreshIngredTable();
     
    RefreshIngredSelection();
     
  
        }     
    }//GEN-LAST:event_bCreateIngActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        
       //Allows for advanced table editing
      
     
      int i = tblIngred.getSelectedRow();
DefaultTableModel model = (DefaultTableModel)tblIngred.getModel();
if(i >= 0)
{

model.setValueAt(tfIngredName.getText(), i, 0);
model.setValueAt(cbIngredUnit.getSelectedItem(), i, 1);
model.setValueAt(tfIngredPrice.getText(), i, 2);




}
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bClearIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearIngActionPerformed
               //Fill in the text boxes with the selected rows
        tfIngredName.setText("");
        cbIngredUnit.setSelectedItem(" ");
        tfIngredPrice.setText("");
        tfIngredWarning.setText("");
    }//GEN-LAST:event_bClearIngActionPerformed

    private void cbIngSelectionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbIngSelectionPopupMenuWillBecomeInvisible
        //Fill text boxes with corresponding data
        tfIngUnit.setText(IngredientUnitSearch(cbIngSelection.getSelectedItem().toString()));
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        CheckRecipeName();
    }//GEN-LAST:event_cbIngSelectionPopupMenuWillBecomeInvisible

    private void cbIngSelectionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbIngSelectionKeyReleased
        //Fill text boxes with corresponding data
        tfIngUnit.setText(IngredientUnitSearch(cbIngSelection.getSelectedItem().toString()));
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        CheckRecipeName();
    }//GEN-LAST:event_cbIngSelectionKeyReleased

    private void tblRecipeNamesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRecipeNamesKeyReleased
        //Refresh tables to show selected data
        RefreshRecipeListAndEdit();
        
        
        //Clear warnings
        tfRecipeIngredientWarning.setText("");
        tfRecipeWarning.setText("");
        tfIngAmount.setText("");
        cbIngSelection.setSelectedItem("");
        tfIngUnit.setText("");
        
    }//GEN-LAST:event_tblRecipeNamesKeyReleased

    private void tfEditRecipeNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEditRecipeNameKeyReleased
        RefreshRecipeListAndEdit();

  
        
    }//GEN-LAST:event_tfEditRecipeNameKeyReleased

    private void tfEditRecipeNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEditRecipeNameKeyTyped
       tfRecipeNameWarning.setText("");
    }//GEN-LAST:event_tfEditRecipeNameKeyTyped

    private void tfEditRecipeNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEditRecipeNameMouseExited
        CheckRecipeName();
    }//GEN-LAST:event_tfEditRecipeNameMouseExited

    private void tblIngredKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblIngredKeyReleased
              //Allows advanced table editing
        DefaultTableModel ingTable=(DefaultTableModel) tblIngred.getModel();
       
        //Fill in the text boxes with the selected rows
        tfIngredName.setText(ingTable.getValueAt(tblIngred.getSelectedRow(),0).toString());
        cbIngredUnit.setSelectedItem(ingTable.getValueAt(tblIngred.getSelectedRow(), 1).toString());
        tfIngredPrice.setText(ingTable.getValueAt(tblIngred.getSelectedRow(),2).toString());
        tfIngredWarning.setText("");
        
    }//GEN-LAST:event_tblIngredKeyReleased

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
     CheckRecipeName();
    }//GEN-LAST:event_jPanel3MouseExited

   private void tfIngredPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIngredPriceActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_tfIngredPriceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        

    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI2().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTabbedPane System;
   private javax.swing.JButton bAddIngredToR;
   private javax.swing.JButton bClearIng;
   private javax.swing.JButton bCreateIng;
   private javax.swing.JButton bDeleteIng;
   private javax.swing.JButton bDeleteRecipe;
   private javax.swing.JButton bNewRecipe;
   private javax.swing.JButton bRemoveIngredFromR;
   private javax.swing.JButton bUpdate;
   private javax.swing.JButton bUpdateIngInRecipe;
   private javax.swing.JComboBox<String> cbIngSelection;
   private javax.swing.JComboBox<String> cbIngredUnit;
   private javax.swing.JPanel ingredients;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel11;
   private javax.swing.JLabel jLabel12;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JTabbedPane jTabbedPane2;
   private javax.swing.JList<String> lRecipeList;
   private javax.swing.JPanel recipes;
   private javax.swing.JTable tblEditRecipe;
   private javax.swing.JTable tblIngred;
   private javax.swing.JTable tblRecipeNames;
   private javax.swing.JTextField tfEditRecipeName;
   private javax.swing.JTextField tfIngAmount;
   private javax.swing.JTextField tfIngUnit;
   private javax.swing.JTextField tfIngredName;
   private javax.swing.JTextField tfIngredPrice;
   private javax.swing.JTextField tfIngredWarning;
   private javax.swing.JTextField tfListRecipeName;
   private javax.swing.JTextField tfRecipeIngredientWarning;
   private javax.swing.JTextField tfRecipeNameWarning;
   private javax.swing.JTextField tfRecipePrice;
   private javax.swing.JTextField tfRecipeWarning;
   // End of variables declaration//GEN-END:variables
}


    
