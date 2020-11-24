package model;

import java.util.Arrays;

public class SandwichCondiments {
    private String name;
    private String[] condiments;

    public SandwichCondiments() {
    }

    public SandwichCondiments(String name, String[] condiments) {
        this.name = name;
        this.condiments = condiments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondiments() {
        return Arrays.toString(condiments);
    }

    public void setCondiments(String[] condiments) {
        this.condiments = condiments;
    }
}
