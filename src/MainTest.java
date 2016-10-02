import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

  @Test
  public void withEmptyNote_shouldReturnFalse() throws Exception {
    boolean canBuildRandomNote = Main.canBuildRandomNote(new String[] {"hello"}, new String[] {""});
    assertFalse(canBuildRandomNote);
  }

  @Test
  public void withOneWordNote_shouldReturnTrue() throws Exception {
    boolean canBuildRandomNote = Main.canBuildRandomNote(new String[] {"hello"}, new String[] {"hello"});
    assertTrue(canBuildRandomNote);
  }

  @Test
  public void withOneWordMissingNote_shouldReturnFalse() throws Exception {
    boolean canBuildRandomNote = Main.canBuildRandomNote(new String[] {"hello", "world", "hi"}, new String[] {"hello", "world", "world"});
    assertFalse(canBuildRandomNote);
  }

  @Test
  public void withWordsFromMagazine_shouldReturnTrue() throws Exception {
    boolean canBuildRandomNote = Main.canBuildRandomNote(new String[] {"hello", "world", "world", "hi"}, new String[] {"hello", "world", "world"});
    assertTrue(canBuildRandomNote);
  }
}