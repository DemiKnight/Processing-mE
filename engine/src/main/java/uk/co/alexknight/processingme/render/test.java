package uk.co.alexknight.processingme.render;

enum direction
{
    up(0),
    down(1),
    left(2),
    right(3);

    private final int value;

    direction(final int newValue)
    {
        if(newValue >= values().length - 1)
        {
            value = 0;
        }
        else
        {
            value = newValue;
        }

    }

    public direction add()
    {
        int newValue = values().length + 1;

        if(newValue >= values().length - 1)
        {
            return values()[0];
        }
        else
        {
            return values()[ordinal() + 1];
        }
    }

    public int getValue() { return value; }
}