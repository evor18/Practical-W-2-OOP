package org.example;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class Article implements ReadJson{
    List<String> titles;
    List<Integer> pageids;
    public void readJson(String json){
        this.titles = JsonPath.read(json, "$.."+"title");
        this.pageids = JsonPath.read(json, "$.."+"pageid");
    }
    public void showTitles(){
        for(int i = 0; i<titles.toArray().length;i++)
            System.out.print( (i+1) +"." + ' ' +   titles.get(i) + '\n');
    }
}
