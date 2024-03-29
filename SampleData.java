package handwriting_recognition_system;

/* -------------------------------------------------
 *
 * This class holds character samples for character recogintion.
 *
 * -------------------------------------------------
 */

public class SampleData {

    protected boolean grid[][];	//The downsampled data as a grid of booleans.
    protected char letter;	//The letter.

    /*
   * The constructor
   * letter=What letter this is
   * width=The width
   * height=The height
     */
    public SampleData(char letter, int width, int height) {
        grid = new boolean[width][height];
        this.letter = letter;
    }

    /*
   * Set one pixel of sample data.
   * x=The x coordinate
   * y=The y coordinate
   * v=The value to set
     */
    public void setData(int x, int y, boolean v) {
        grid[x][y] = v;

    }

    /* Get a pixel from the sample.
   * x=The x coordinate
   * y=The y coordinate
   * return The requested pixel
     */
    public boolean getData(int x, int y) {
        return grid[x][y];
    }

    public void clear() //Clear the downsampled image
    {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y] = false;
            }
        }
    }

    /*
   * Get the height of the down sampled image.
   * return The height of the downsampled image.
     */
    public int getHeight() {
        return grid[0].length;
    }

    /* Get the width of the downsampled image.
   * @return The width of the downsampled image
     */
    public int getWidth() {
        return grid.length;
    }

    /* Get the letter that this sample represents.
   * return The letter that this sample represents.
     */
    public char getLetter() {
        return letter;
    }

    /* Set the letter that this sample represents.
   * letter=The letter that this sample represents.
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /* Compare this sample to another, used for sorting.
   * o=The object being compared against.
   * return Same as String.compareTo
     */
    public int compareTo(Object o) {
        SampleData obj = (SampleData) o;
        if (this.getLetter() == obj.getLetter()) {
            return 0;
        } else if (this.getLetter() > obj.getLetter()) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean equals(Object o) {
        return (compareTo(o) == 0);
    }

    /* Convert this sample to a string.
   * return Just returns the letter that this sample is assigned to.
     */
    public String toString() {
        return "" + letter;
    }

    /* Create a copy of this sample
   * return A copy of this sample
     */
    public Object clone() {
        SampleData obj = new SampleData(letter, getWidth(), getHeight());
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                obj.setData(x, y, getData(x, y));
            }
        }
        return obj;
    }

}
