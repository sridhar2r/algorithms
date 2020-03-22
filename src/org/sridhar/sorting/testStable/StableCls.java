package org.sridhar.sorting.testStable;

/**
 * Created by sridharrajagopal on 3/23/20.
 */
public class StableCls {
    private int nbr;
    private char name;

    public StableCls() {
    }

    public StableCls(int nbr, char name) {
        this.nbr = nbr;
        this.name = name;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StableCls{" +
                "nbr=" + nbr +
                ", name=" + name +
                '}';
    }
}
