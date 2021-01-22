package grid;

/**
 * A class that stores a two-dimensional rectanguar grid with origin at bottom left
 * 
 * @author Berkan Şahin
 * @version 1.0
 */
public class Grid {
   
    String grid;
    int width;
    int height;

    /**
     * Create a new rectangular grid containing no stars
     * @param width     Width of the grid (x)
     * @param height    Height of the grid (y)
     */
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        clear();
    }

    /**
     * Create a new square grid
     * @param x Width and length of the grid
     */
    public Grid(int x) {
        this.width = x;
        this.height = x;
        clear();
    }

    /**
     * Copy the contents of one grid into another
     * @param grid Grid to copy
     */
    public Grid(Grid grid) {
        width = grid.width;
        height = grid.height;
        this.grid = grid.grid;
    }

    /**
     * Redraw the grid with no stars 
     * @return The redrawn grid
     */
    public String clear() {
        grid = "";
        for (int i = 0; i < height; i++) {
            grid += "|";
            for (int j = 0; j < width; j++) {
                grid += "_|";
            }
            grid += "\n";
        }
        return grid;
    }

    /**
     * A representation of the grid that can be printed
     * @return A multiline string containing the grid
     */
    public String toString() {
        return this.grid;
    }

    /**
     * Add a star to the specified coordinate
     * @param x x-coordinate of the star, starting at 0 
     * @param y y-coordinate of the star, starting at 0
     * @return the new grid
     */
    public String addStar(int x, int y) {
        return putSymbol('*', x, y);
    }

    /**
     * Put a character to the specified coordinate
     * @param sym The character to insert
     * @param x x-coordinate of the star, starting at 0
     * @param y y-coordinate of the star, starting at 0
     * @return the new grid
     */
    public String putSymbol(char sym, int x, int y) {
        char[] newGrid = grid.toCharArray();
        
        int index = flattenCoordinate(x, y);
        newGrid[index] = sym;

        grid = new String(newGrid);

        return this.grid;
    }

    /**
     * Calculate the index of the specified coordinate on the grid string
     * @param x x-coordinate, starting at 0
     * @param y y-coordinate, starting at 0
     * @return the index of the coordinate
     */
    private int flattenCoordinate(int x, int y) {
        // Move origin to top left
        y = height - y - 1;
        x++;

        return (2 * width + 2) * y + (2 * x - 1);
    }
}
