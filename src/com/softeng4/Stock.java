package com.softeng4;

public class Stock {

    private String name;
    private String value;
    private String[] lastChanges = new String[5];

    public void setName(String name)
    {
        this.name = name;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public void setNextChange(String nextChange)
    {
        for (int i = 0; i < 5; i++)
        {
            this.lastChanges[i] = this.lastChanges[i+1];
        }
        this.lastChanges[5] = nextChange;
    }

    public String getName(){
        return this.name;
    }

    public String getValue(){
        return this.value;
    }

    public String[] getChanges(){
        return this.lastChanges;
    }
}
