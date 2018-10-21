package com.lazy;


import java.util.Comparator;
import org.primefaces.model.SortOrder;

import com.entities.AssuPrinc;
 
public class LazySorter  implements Comparator<AssuPrinc> {
	    private String sortField;
	     
	    private SortOrder sortOrder;
	     
	    public LazySorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }
	 
	    public int compare(AssuPrinc car1, AssuPrinc car2) {
	        try {
	            Object value1 = AssuPrinc.class.getField(this.sortField).get(car1);
	            Object value2 = AssuPrinc.class.getField(this.sortField).get(car2);
	 
	            int value = ((Comparable)value1).compareTo(value2);
	             
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch(Exception e) {
	            throw new RuntimeException();
	        }
	    }

}
