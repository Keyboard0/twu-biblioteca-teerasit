package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BooksTest {

    @Test /* test 1.3 view a list all books */
    public void shouldReturnPredefinedBooks(){
        Book book1 = new Book("Title1","Arthor1",1991, false);
        Book book2 = new Book("Title2","Arthor2",1992, false);
        Book book3 = new Book("Title3","Arthor3",1993, false);
        Books actual = new Books();
        ArrayList<Book> expected = new ArrayList<Book>(Arrays.asList(book1,book2,book3));

        assertThat(actual.getListBook().size(), is(expected.size()));
        for(int i=0; i<actual.getListBook().size(); i++){
            assertThat(actual.getListBook().get(i).getBookInfo(), is(expected.get(i).getBookInfo()));
        }


    }
}
