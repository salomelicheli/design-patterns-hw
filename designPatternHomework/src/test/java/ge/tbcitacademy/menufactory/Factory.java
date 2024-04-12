package ge.tbcitacademy.menufactory;

import ge.tbcitacademy.swoop.MenuFactory;
import ge.tbcitacademy.swoop.MenuFactory;

import static ge.tbcitacademy.data.Constants.*;

public class Factory {
    @org.testng.annotations.Factory
    public Object[] factoryExecutor(){
        return new Object[]{
                new MenuFactory(CINEMA),
                new MenuFactory(AESTHETICS),
                new MenuFactory(HOLIDAY),
                new MenuFactory(RESTO),
                new MenuFactory(KIDS),
                new MenuFactory(ENTERTAINMENT),
                new MenuFactory(SPORTS)
        };
    }
}
