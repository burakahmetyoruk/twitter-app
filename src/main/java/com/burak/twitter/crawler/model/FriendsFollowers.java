package com.burak.twitter.crawler.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import twitter4j.User;

import java.util.List;

@Data
@AllArgsConstructor
public class FriendsFollowers {

    @JsonProperty(value = "user-list")
    private List<User> userList;
}
