package org.json;

import java.util.List;

public record Dignitary(String name, List<String> knownFor, List<Award> awards) {
    public void display() {
        System.out.println(name);
        System.out.println("Known For:");
        for (String item : knownFor) {
            System.out.println(item);
        }
        System.out.println("Awards:");
        for (Award award : awards) {
            System.out.println(award.name() + ", " + award.year());
        }
    }
}