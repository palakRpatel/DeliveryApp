package com.example.nytimesapp.data;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NYListResponseTest {

    @Test
    public void setStatus() {
        NYListResponse result = new NYListResponse();
        result.setStatus("test");
        assertTrue(result.getStatus() == "test");
    }

    @Test
    public void setCopyright() {
        NYListResponse result = new NYListResponse();
        result.setCopyright("test");
        assertTrue(result.getCopyright() == "test");
    }

    @Test
    public void setNumResults() {
        NYListResponse result = new NYListResponse();
        result.setNumResults(10);
        assertTrue(result.getNumResults() == 10);
    }

    @Test
    public void setResults() {
        NYListResponse result = new NYListResponse();
        List<Result> resultList = new ArrayList<>();
        result.setResults(resultList);
        assertTrue(result.getResults() == resultList);
    }
}