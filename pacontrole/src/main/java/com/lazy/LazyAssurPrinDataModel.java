package com.lazy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.entities.AssuPrinc;

public class LazyAssurPrinDataModel extends LazyDataModel<AssuPrinc>{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<AssuPrinc> datasource;
	     
	    public LazyAssurPrinDataModel(List<AssuPrinc> datasource) {
	        this.datasource = datasource;
	    }
	     
	    @Override
	    public AssuPrinc getRowData(String rowKey) {
	        for(AssuPrinc ass : datasource) {
	            if(ass.getDateDeclare().equals(rowKey))
	                return ass;
	        }
	 
	        return null;
	    }
	 
	    @Override
	    public Object getRowKey(AssuPrinc ass) {
	        return ass.getDateDeclare();
	    }
	 
	    @Override
	    public List<AssuPrinc> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<AssuPrinc> data = new ArrayList<AssuPrinc>();
	 
	        //filter
	        for(AssuPrinc ass : datasource) {
	            boolean match = true;
	 
	            if (filters != null) {
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    try {
	                        String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = String.valueOf(ass.getClass().getField(filterProperty).get(ass));
	 
	                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
	                            match = true;
	                    }
	                    else {
	                            match = false;
	                            break;
	                        }
	                    } catch(Exception e) {
	                        match = false;
	                    }
	                }
	            }
	 
	            if(match) {
	                data.add(ass);
	            }
	        }
	 
	        //sort
	        if(sortField != null) {
	            Collections.sort(data, new LazySorter(sortField, sortOrder));
	        }
	 
	        //rowCount
	        int dataSize = data.size();
	        this.setRowCount(dataSize);
	 
	        //paginate
	        if(dataSize > pageSize) {
	            try {
	                return data.subList(first, first + pageSize);
	            }
	            catch(IndexOutOfBoundsException e) {
	                return data.subList(first, first + (dataSize % pageSize));
	            }
	        }
	        else {
	            return data;
	        }
	    }
	}
