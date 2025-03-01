import static org.example.Week4.calculateBMI;
import static org.example.Week4.max2Int;
import static org.example.Week4.minArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Week4Test {

  @Test
  public void testMax2Int1() {
    Assertions.assertEquals(4, max2Int(3, 4));
  }

  @Test
  public void testMax2Int2() {
    Assertions.assertEquals(5, max2Int(3, 5));
  }

  @Test
  public void testMax2Int3() {
    Assertions.assertEquals(6, max2Int(3, 6));
  }

  @Test
  public void testMax2Int4() {
    Assertions.assertEquals(7, max2Int(3, 7));
  }

  @Test
  public void testMax2Int5() {
    Assertions.assertEquals(8, max2Int(3, 8));
  }

  @Test
  public void testMinArray1() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Assertions.assertEquals(1, minArray(arr));
  }

  @Test
  public void testMinArray2() {
    int[] arr = {2, 3, 4, 5, 6, 7, 8, 9};
    Assertions.assertEquals(2, minArray(arr));
  }

  @Test
  public void testMinArray3() {
    int[] arr = {3, 4, 5, 6, 7, 8, 9};
    Assertions.assertEquals(3, minArray(arr));
  }

  @Test
  public void testMinArray4() {
    int[] arr = {4, 5, 6, 7, 8, 9};
    Assertions.assertEquals(4, minArray(arr));
  }

  @Test
  public void testMinArray5() {
    int[] arr = {5, 6, 7, 8, 9};
    Assertions.assertEquals(5, minArray(arr));
  }

  @Test
  public void testCalculateBMI1() {
    Assertions.assertEquals("Béo phì", calculateBMI(50, 1.3));
  }

  @Test
  public void testCalculateBMI2() {
    Assertions.assertEquals("Béo phì", calculateBMI(48, 1.3));
  }

  @Test
  public void testCalculateBMI3() {
    Assertions.assertEquals("Béo phì", calculateBMI(48, 1.3));
  }

  @Test
  public void testCalculateBMI4() {
    Assertions.assertEquals("Béo phì", calculateBMI(48, 1.3));
  }

  @Test
  public void testCalculateBMI5() {
    Assertions.assertEquals("Béo phì", calculateBMI(48, 1.3));
  }
}
