package com.ucad.chat.util;

import org.omnifaces.util.Messages;

import com.ucad.chat.model.Car;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import java.io.Serializable;
import java.util.*;

/**
 * Created by rmpestano on 07/02/17.
 */
@ApplicationScoped
public class Utils implements Serializable {

    private List<Car> cars;


    @PostConstruct
    public void init() {
        cars = new ArrayList<>();
       
    }

    private static Car create(int i) {
        return new Car(i).model("model " + i).name("name" + i).price(Double.valueOf(i));
    }

     public static void addDetailMessage(String message){
       addDetailMessage(message, null);
    }

    public static void addDetailMessage(String message, FacesMessage.Severity severity){

        FacesMessage facesMessage = Messages.create("").detail(message).get();
        if(severity != null && severity != FacesMessage.SEVERITY_INFO) {
            facesMessage.setSeverity(severity);
        } else{
            Messages.add(null,facesMessage);
        }
    }

    @Produces
    public List<Car> getCars() {
        return cars;
    }

}
