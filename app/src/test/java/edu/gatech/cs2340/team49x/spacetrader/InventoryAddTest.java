package edu.gatech.cs2340.team49x.spacetrader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class InventoryAddTest {

    private Inventory inventory;
    private final Tradable item1 = (Tradable) () -> "Item 1";
    private final Tradable item2 = (Tradable) () -> "Item 2";

    @Before
    public void setup() {
        inventory = new Inventory();
        inventory.add(item1, 7);
    }

    @Test
    public void testInitialAdd() {
        Assert.assertEquals("Wrong value of count after adding item1",
                7, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                7, inventory.getQuantity(item1));
        Assert.assertEquals("No item 2 should be added yet.",
                0, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        expectedKeySet.add(item1);
        Assert.assertEquals("Wrong key set after adding item1",
                expectedKeySet, inventory.getItemSet());
    }

    @Test
    public void add12MoreItem1() {
        inventory.add(item1, 12);

        Assert.assertEquals("Wrong value of count after adding more item1",
                19, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                19, inventory.getQuantity(item1));
        Assert.assertEquals("No item 2 should be added yet.",
                0, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        expectedKeySet.add(item1);
        Assert.assertEquals("Wrong key set after adding item1",
                expectedKeySet, inventory.getItemSet());
    }

    @Test
    public void add8Item2() {
        inventory.add(item2, 8);

        Assert.assertEquals("Wrong value of count after adding item2",
                15, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                7, inventory.getQuantity(item1));
        Assert.assertEquals("Wrong number of item 2",
                8, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        expectedKeySet.add(item1);
        expectedKeySet.add(item2);
        Assert.assertEquals("Wrong key set after adding item1",
                expectedKeySet, inventory.getItemSet());
    }

    @Test
    public void add0MoreItem1() {
        inventory.add(item1, 0);

        Assert.assertEquals("Wrong value of count after adding 0 item1",
                7, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                7, inventory.getQuantity(item1));
        Assert.assertEquals("No item 2 should be added yet.",
                0, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        expectedKeySet.add(item1);
        Assert.assertEquals("Wrong key set after adding 0 item1",
                expectedKeySet, inventory.getItemSet());
    }

    @Test
    public void add0Item2() {
        inventory.add(item2, 0);

        Assert.assertEquals("Wrong value of count after adding 0 item2",
                7, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                7, inventory.getQuantity(item1));
        Assert.assertEquals("Wrong number of item 2",
                0, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        expectedKeySet.add(item1);
        Assert.assertEquals("Wrong key set after adding 0 item2",
                expectedKeySet, inventory.getItemSet());
    }

    @Test
    public void remove6Item1() {
        inventory.add(item1, -6);

        Assert.assertEquals("Wrong value of count after removing 6 item1",
                1, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                1, inventory.getQuantity(item1));
        Assert.assertEquals("Wrong number of item 2",
                0, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        expectedKeySet.add(item1);
        Assert.assertEquals("Wrong key set after removing 6 item1",
                expectedKeySet, inventory.getItemSet());
    }

    @Test
    public void removeAllItem1() {
        inventory.add(item1, -7);

        Assert.assertEquals("Wrong value of count after removing all item1",
                0, inventory.getCount());
        Assert.assertEquals("Wrong number of item 1.",
                0, inventory.getQuantity(item1));
        Assert.assertEquals("Wrong number of item 2",
                0, inventory.getQuantity(item2));

        Set<Tradable> expectedKeySet = new HashSet<>();
        Assert.assertEquals("Wrong key set after removing all item1",
                expectedKeySet, inventory.getItemSet());
    }
}