import org.junit.*;
import static org.junit.Assert.*;

public class PlacesTest {

  @Test
  public void Places_instantiatesCorrectly_true() {
    Places myPlace = new Places("Portlant, OR");
    assertEquals(true, myPlace instanceof Places);
  }
  @Test
  public void Places_instantiatesWithDescription_String() {
    Places myPlace = new Places("Portland, OR");
    assertEquals("Portland, OR", myPlace.getDescription());
  }

}
