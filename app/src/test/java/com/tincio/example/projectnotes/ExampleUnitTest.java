package com.tincio.example.projectnotes;

import com.tincio.example.projectnotes.data.repository.ListNoteRepository;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        ListNoteRepository repository = new ListNoteRepository();
        assertEquals(2, repository.getNotes().size());
    }
}