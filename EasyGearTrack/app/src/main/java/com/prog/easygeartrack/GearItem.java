package com.prog.easygeartrack;

import java.io.Serializable;

public class GearItem implements Serializable {
    private String name;
    private String category;
    private String condition;

    public GearItem(String name, String category, String condition) {
        this.name = name;
        this.category = category;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCondition() {
        return condition;
    }
}
