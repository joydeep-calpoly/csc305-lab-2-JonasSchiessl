package org.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

record Dignitary(
        @JsonProperty("name") String name,
        @JsonProperty("knownFor") List<String> knownFor,
        @JsonProperty("awards") List<Award> awards
) {
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
