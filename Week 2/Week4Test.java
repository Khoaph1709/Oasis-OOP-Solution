import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Week4Test {
    @Test
    public void testMax2Int1(){
        assertEquals(5, Week4.max2Int(5, 3));
    }

    @Test
    public void testMax2Int2(){
        assertEquals(5, Week4.max2Int(5, 5));

    }

    @Test
    public void testMax2Int3(){
        assertEquals(0, Week4.max2Int(0, 0));

    }

    @Test
    public void testMax2Int4(){
        assertEquals(0, Week4.max2Int(0, -1));
    }

    @Test
    public void testMax2Int5(){
        assertEquals(0, Week4.max2Int(-1, 0));
    }

    @Test
    public void testMinArray1(){
        assertEquals(1, Week4.minArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMinArray2(){
        assertEquals(1, Week4.minArray(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testMinArray3(){
        assertEquals(1, Week4.minArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMinArray4(){
        assertEquals(1, Week4.minArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMinArray5(){
        assertEquals(1, Week4.minArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testCalculateBMI1(){
        assertEquals("Thiếu cân", Week4.calculateBMI(40, 1.6));
    }

    @Test
    public void testCalculateBMI2(){
        assertEquals("Bình thường", Week4.calculateBMI(60, 1.7));
    }

    @Test
    public void testCalculateBMI3(){
        assertEquals("Thừa cân", Week4.calculateBMI(70, 1.7));
    }

    @Test
    public void testCalculateBMI4(){
        assertEquals("Béo phì", Week4.calculateBMI(100, 1.7));
    }

    @Test
    public void testCalculateBMI5(){
        assertEquals("Béo phì", Week4.calculateBMI(100, 1.5));
    }
}