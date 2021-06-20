package Adventurer;

import Adventurer.Items.Item;

import java.util.Arrays;

public class Backpack
{
    private final int spaceLimit;
    public Item[] itemsList;
    public int maxItems;
    private final String color;
    private int weight;

    public Backpack(int spaceLimit, String color, int maxItems)
    {
        this.spaceLimit = spaceLimit;
        this.color = color;
        itemsList = new Item[maxItems];
        this.maxItems = maxItems;
    }

    // This methods adds a specific item in backpack

    public void addItem(Item item)
    {
        if(item == null) return;

        if(numItems() + 1 > maxItems)
        {
            System.out.println("Backpack is already full.");
            return;
        }

        for(int i = 0; i < itemsList.length; i++)
        {
            if(itemsList[i] == null)
            {
                itemsList[i] = item;
                break;
            }
        }
    }

    // This method removes a specific item from backpack

    public void removeItem(Item item)
    {
        if(item == null) return;

        for(int i = 0; i < itemsList.length; i++)
        {
            if(itemsList[i].getCoord()[0] == item.getCoord()[0] && itemsList[i].getCoord()[1] == item.getCoord()[1])
            {
                itemsList[i] = null;
                return;
            }
        }
    }

    // This method returns the amount of items in backpack

    public int numItems()
    {
        int amount = 0;

        for (Item item : itemsList)
        {
            if (item != null) amount++;
        }

        return amount;
    }

    public int getSpaceLimit()
    {
        return spaceLimit;
    }

    public String getColor()
    {
        return color;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "spaceLimit=" + spaceLimit +
                ", itemsList=" + Arrays.toString(itemsList) +
                ", color='" + color + '\'' +
                '}';
    }
}
