/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viegrid-04
 */
public class Content_Object {

    private String content = "";
    private List<Integer> year = null;
    private List<Integer> appearCount = null;
    private List<Integer> bookCount = null;

    public Content_Object() {
        year = new ArrayList<>();
        appearCount = new ArrayList<>();
        bookCount = new ArrayList<>();
    }

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

    @Override
    public String toString() {

        double freq = 0;//appearance times per book
        int appearTotal = 0;
        int bookTotal = 0;
        for (int i = 0; i < getBookCount().size(); i++) {
            bookTotal += getBookCount().get(i);
            appearTotal += getAppearCount().get(i);
        }
        freq = appearTotal / bookTotal;

        return content + "=" + freq;
    }

}
