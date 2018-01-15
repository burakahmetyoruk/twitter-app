package com.burak.twitter.crawler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SearchParameters {

    @NotNull
    private String username;

    @JsonProperty(value = "max-id")
    private long maxId;

    @JsonProperty(value = "since-id")
    private long sinceId;

    @NotNull
    @JsonProperty(value = "search-key")
    private String searchKey;
}
