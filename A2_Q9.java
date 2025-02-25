import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;

interface Exploration {

    // ABSTRACT METHOD.
    void explore();
}

abstract class Explorer {
    String name;

    Explorer(String name) {
        this.name = name;
    }

    // ABSTRACT METHOD
    abstract void exploreRoutine();

    // CONCRETE METHOD.
    void getInfo() {
        System.out.println("Explorer name: " + name);
    }
}

class MarsExplorer extends Explorer implements Exploration {
    MarsExplorer(String name) {
        super(name);
    }

    @Override
    void exploreRoutine() {
        System.out.println("EXPLORATION SCHEDULED FOR MARS.");
    }

    @Override
    public void explore() {
        System.out.println("MARS WILL BE EXPLORE ON THE BASIS OF: ");
        System.out.println("it's soil.");
        System.out.println("probability of getting any instance of life.");
        System.out.println("probability of getting instance of water.");
    }
}

class VenusExplorer extends Explorer implements Exploration {
    VenusExplorer(String name) {
        super(name);
    }

    @Override
    void exploreRoutine() {
        System.out.println("EXPLORATION SCHEDULED FOR VENUS.");
    }

    @Override
    public void explore() {
        System.out.println("VENUS WILL BE EXPLORE ON THE BASIS OF: ");
        System.out.println("it's soil.");
        System.out.println("probability of getting any instance of life.");
        System.out.println("probability of getting instance of water.");
    }
}

class SaturnExplorer extends Explorer implements Exploration {
    SaturnExplorer(String name) {
        super(name);
    }

    @Override
    void exploreRoutine() {
        System.out.println("EXPLORATION SCHEDULED FOR SATURN.");
    }

    @Override
    public void explore() {
        System.out.println("SATURN WILL BE EXPLORE ON THE BASIS OF: ");
        System.out.println("it's soil.");
        System.out.println("probability of getting any instance of life.");
        System.out.println("probability of getting instance of water.");
    }
}

public class A2_Q9 {

    public static void main(String[] args) {
        MarsExplorer mars = new MarsExplorer("sapceXmars2000");
        VenusExplorer venus = new VenusExplorer("spaceXvenus2001");
        SaturnExplorer saturn = new SaturnExplorer("spaceXsaturn2002");

        // ACTIVITY OF MARS EXPLORER.
        mars.getInfo();
        mars.exploreRoutine();
        mars.explore();

        System.out.println();
        System.out.println();

        // ACTIVITY OF VENUS EXPLORER.
        venus.getInfo();
        venus.exploreRoutine();
        venus.explore();

        System.out.println();
        System.out.println();

        // ACTIVITY OF SATURN EXPLORER.
        saturn.getInfo();
        saturn.exploreRoutine();
        saturn.explore();
    }

}