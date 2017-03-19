/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author Viegrid-04
 */
public class Content_Object {
    private  String content = "";
    private  List<Integer> year = null;
    private  List<Integer> appearCount = null;
    private  List<Integer> bookCount = null;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

    public List<Integer> getAppearCount() {
        return appearCount;
    }

    public void setAppearCount(List<Integer> appearCount) {
        this.appearCount = appearCount;
    }

    public List<Integer> getBookCount() {
        return bookCount;
    }

    public void setBookCount(List<Integer> bookCount) {
        this.bookCount = bookCount;
    }

    
    
}
