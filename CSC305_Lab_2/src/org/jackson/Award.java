package org.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

record Award(
        @JsonProperty("name") String name,
        @JsonProperty("year") int year
) {}
