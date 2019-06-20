package com.example.nytimesapp.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {
    @Test
    public void setUrl() {
        Result result=new Result();
        result.setUrl("test");
        assertTrue(result.getUrl()=="test");
    }


    @Test
    public void setAdxKeywords() {
        Result result=new Result();
        result.setAdxKeywords("test");
        assertTrue(result.getAdxKeywords()=="test");
    }
    @Test
    public void setColumn() {
        Result result=new Result();
        result.setColumn("test");
        assertTrue(result.getColumn()=="test");
    }
    @Test
    public void setSection() {
        Result result=new Result();
        result.setSection("test");
        assertTrue(result.getSection()=="test");
    }

    @Test
    public void setAssetId() {
        Result result=new Result();
        result.setAssetId(100L);
        assertTrue(result.getAssetId()==100L);
    }

    @Test
    public void setAbstract() {
        Result result=new Result();
        result.setAbstract("test");
        assertTrue(result.getAbstract()=="test");
    }

    @Test
    public void setPublishedDate() {
        Result result=new Result();
        result.setPublishedDate("test");
        assertTrue(result.getPublishedDate()=="test");
    }

    @Test
    public void setSource() {
        Result result=new Result();
        result.setSource("test");
        assertTrue(result.getSource()=="test");
    }

    @Test
    public void setId() {
        Result result=new Result();
        result.setId(10L);
        assertTrue(result.getId()==10L);
    }


    @Test
    public void getByline() {
        Result result=new Result();
        result.setByline("test");
        assertTrue(result.getByline()=="test");
    }


}