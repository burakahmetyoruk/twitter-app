package com.burak.twitter.crawler.service;

import com.burak.twitter.crawler.model.SearchParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TwitterService {

    @Value("${crawler.page.size:20}")
    private int pageSize;
    private final Twitter twitter;

    public List<Status> getUserTweets(SearchParameters searchParameters) throws TwitterException {
        Query query = new Query();
        query.setQuery(getQueryText(searchParameters.getSearchKey(), searchParameters.getUsername()));
        query.setCount(pageSize);
        query.setSinceId(searchParameters.getSinceId());
        query.setMaxId(searchParameters.getMaxId() - 1);

        return twitter.search()
                .search(query)
                .getTweets()
                .parallelStream()
                .collect(Collectors.toList());
    }

    public List<User> getUserFriends(final String username, final int page) throws TwitterException {
        return  twitter.friendsFollowers()
                .getFriendsList(username,page, pageSize)
                .parallelStream()
                .collect(Collectors.toList());
    }

    public List<User> getUserFollowers(final String username, final int page) throws TwitterException {
        return  twitter.friendsFollowers()
                .getFollowersList(username,page, pageSize)
                .parallelStream()
                .collect(Collectors.toList());
    }

    private Paging getPaging(final int page) {
        Paging paging = new Paging();
        paging.setPage(page);
        paging.setCount(pageSize);

        return paging;
    }

    private String getQueryText(String searchKey, String username) {
        return  "from:" + username + " " + searchKey;
    }
}
