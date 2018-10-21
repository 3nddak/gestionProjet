package com.bean;
import org.omnifaces.cdi.ViewScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by rmpestano on 18/01/17.
 */
@Named
@ViewScoped
public class DatatableMB implements Serializable {

    private List teams;
    private List cars;
    private Car selectedCar;

    private List filteredCars;

    @Inject
    private CarService carService;



    @PostConstruct
    public void init() {
        teams = new ArrayList();
        Team lakers = new Team("Los Angeles Lakers");
        lakers.getStats().add(new Stats("2005-2006", 50, 32));
        lakers.getStats().add(new Stats("2006-2007", 44, 38));
        lakers.getStats().add(new Stats("2007-2008", 40, 42));
        lakers.getStats().add(new Stats("2008-2009", 45, 37));
        lakers.getStats().add(new Stats("2009-2010", 48, 34));
        lakers.getStats().add(new Stats("2010-2011", 42, 42));
        teams.add(lakers);

        Team celtics = new Team("Boston Celtics");
        celtics.getStats().add(new Stats("2005-2006", 46, 36));
        celtics.getStats().add(new Stats("2006-2007", 50, 32));
        celtics.getStats().add(new Stats("2007-2008", 41, 41));
        celtics.getStats().add(new Stats("2008-2009", 45, 37));
        celtics.getStats().add(new Stats("2009-2010", 38, 44));
        celtics.getStats().add(new Stats("2010-2011", 35, 47));
        teams.add(celtics);

        cars = carService.createCars(30);
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }


    public List getTeams() {
        return teams;
    }

    public List getBrands() {
        return carService.getBrands();
    }

    public List getColors() {
        return carService.getColors();
    }

    public List getCars() {
        return cars;
    }

    public List getCarsCarousel() {
        return cars.subList(0,8);
    }

    public List getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List filteredCars) {
        this.filteredCars = filteredCars;
    }


    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}