package com.burak.twitter.crawler.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import twitter4j.Status;

import java.util.List;

@Data
@AllArgsConstructor
public class Tweets {

    @JsonProperty(value = "tweet-list")
    private List<Status> tweetList;

}
