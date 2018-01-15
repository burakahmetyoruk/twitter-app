package com.burak.twitter.crawler.controller;

import com.burak.twitter.crawler.model.FriendsFollowers;
import com.burak.twitter.crawler.model.SearchParameters;
import com.burak.twitter.crawler.model.Tweets;
import com.burak.twitter.crawler.service.TwitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crawler")
@RequiredArgsConstructor
public class TwitterController {

    private final TwitterService twitterService;

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Tweets> searchUserTweets(@Valid @RequestBody final SearchParameters searchParameters) throws TwitterException {
        List<Status> tweetList = twitterService.getUserTweets(searchParameters);

        return new ResponseEntity<>(new Tweets(tweetList), HttpStatus.OK);
    }

    @GetMapping(value = "/friends/{username}/{page}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FriendsFollowers> searchUsersFriends(@PathVariable final String username, @PathVariable final int page) throws TwitterException {

        Assert.hasText(username, "username must not be null or empty");

        List<User> friendsList = twitterService.getUserFriends(username, page);

        return new ResponseEntity<>(new FriendsFollowers(friendsList), HttpStatus.OK);
    }

    @GetMapping(value = "/followers/{username}/{page}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FriendsFollowers> searchUsersFollowers(@PathVariable final String username, @PathVariable final int page) throws TwitterException {

        Assert.hasText(username, "username must not be null or empty");

        List<User> followersList = twitterService.getUserFollowers(username, page);

        return new ResponseEntity<>(new FriendsFollowers(followersList), HttpStatus.OK);
    }
}
