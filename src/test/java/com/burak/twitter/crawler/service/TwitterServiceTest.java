package com.burak.twitter.crawler.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceTest {

    @InjectMocks
    private TwitterService twitterService;

    @Mock
    private Twitter twitter;

    @Before
    public void setup() {

    }

    @Test
    public void should_return_wanted_tweet_correctly() {
        String username = "username";
        String searchKey = "searchKey";

    }

    @Test(expected = TwitterException.class)
    public void should_throw_proper_exception_when_get_wanted_tweet_exception_occured() {

    }

    @Test
    public void should_return_user_followers_list_correctly() {

    }

    @Test
    public void should_return_user_friends_list_correctly() {

    }

    private List<Status> getWantedTweetList() {
        List<Status> tweetList = new ArrayList<>();

        return tweetList;
    }
}