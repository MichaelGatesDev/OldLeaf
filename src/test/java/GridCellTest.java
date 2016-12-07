import com.michaelgatesdev.OldLeaf.gui.components.grid.Cell;
import com.michaelgatesdev.OldLeaf.gui.components.grid.ImageCell;
import com.michaelgatesdev.OldLeaf.gui.components.grid.PaintableCell;
import org.junit.Assert;
import org.junit.Test;

public class GridCellTest
{
    @Test
    public void testCellSizes()
    {
        Cell cellA = new PaintableCell(null, 0, 0, 5, 5);
        Assert.assertEquals(cellA.getSize(), 25, 0.0);
        
        Cell cellB = new ImageCell(null, 15, 15, 25, 25);
        Assert.assertEquals(cellB.getSize(), 100, 0.0);
    }
}
