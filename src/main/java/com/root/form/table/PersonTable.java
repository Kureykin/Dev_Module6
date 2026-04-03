package com.root.form.table;

public abstract class PersonTable extends Table {
   protected String name;

   public String getName(){
       return name;
   }

    @Override
    public String toString() {
        return getId() + " " + getName();
    }
}
