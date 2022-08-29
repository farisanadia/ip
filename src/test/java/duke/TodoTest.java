package duke;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TodoTest {
    @Test
    public void addTest(){
        ToDos todo = new ToDos("eat");
        assertEquals("[T][ ] eat", todo.stringDesc());
    }

    @Test
    public void markTest(){
        ToDos todo = new ToDos("eat");
        todo.markAsDone();
        assertEquals("[T][X] eat", todo.stringDesc());
    }

    @Test
    public void unmarkTest() {
        ToDos todo = new ToDos("eat");
        todo.markAsDone();
        todo.markAsUndone();
        assertEquals("[T][ ] eat", todo.stringDesc());
    }
}
