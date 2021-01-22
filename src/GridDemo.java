import java.util.Scanner;

import grid.Grid;

/**
 * An interactive demo of the grid class
 * 
 * @author Berkan Şahin
 * @see grid.Grid
 */
public class GridDemo {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Grid grid;

        System.out.print("Enter the width of grid: ");
        int width = scan.nextInt();

        System.out.print("Enter the height of grid: ");
        int height = scan.nextInt();

        grid = new Grid(width, height);
        
        while (true) {
            System.out.println();
            System.out.println(grid);
            System.out.println("***[Options]**");
            System.out.println("E[x]it the program");
            System.out.println("[A]dd star");
            System.out.println("[C]lear the grid");

            System.out.print(">");

            char option = scan.next().toLowerCase().charAt(0);

            switch (option) {
                case 'x':
                    System.out.println("Bye!");
                    scan.close();
                    System.exit(0);
                    break;
                case 'a':
                    System.out.print("Enter the coordinates [x y]: ");
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    grid.addStar(x, y);
                    break;
                case 'c':
                    grid.clear();
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        }
    }
}
