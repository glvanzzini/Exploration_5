import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * warshall.java
 * Exploration 5
 * November 14, 2016
 *
 * Performs Warshall's algorithm from an input file from a
 * console command and prints out the transitive closure
 *
 */

public class warshall {

    public static void main(String[] args) throws FileNotFoundException {

        // get the number row (and col) count from the input file
        Scanner in = new Scanner(new File(args[0]));
        String[] n = in.nextLine().split(" ");
        int count = n.length;
        in.close();

        // start building the matrix from the input file
        in = new Scanner(new File(args[0]));
        int[][] AdjacencyMatrix = new int[count][count];
        for(int i = 0; i < count; i ++){
            for(int j = 0; j < count; j++){
                AdjacencyMatrix[i][j] = in.nextInt();
            }
            if(in.hasNextLine())
            in.nextLine();
        }

        // print out the input adjacency matrix
        System.out.println("Adjacency Matrix: ");
        for(int i = 0; i < count; i ++){
            for(int j = 0; j < count; j++){
                System.out.print(AdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // start the timer as soon as Warshall's Algorithm is being run
        // and stop it when it's done calculating
        long startTime = System.nanoTime();
        int[][] TransitiveClosure = Warshalls(AdjacencyMatrix, count);
        long totalTime = System.nanoTime() - startTime;


        // printout the output transitive closure
        System.out.println("Transitive Closure: " );
        for(int i = 0; i < count; i ++){
            for(int j = 0; j < count; j++){
                System.out.print(TransitiveClosure[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // printout the total runtime saved from ealier
        System.out.println("Warshall's run time: " + totalTime + " nanoseconds.");
    }

    // Warshalls - performs Warshall's algorithm on the matrix
    // Input - adjacency matrix as a double array, and the count of places
    // Output - returns the modified matrix as a transitive closure
    private static int[][] Warshalls(int[][] adjacencyMatrix, int count) {
        for(int k = 0; k < count; k++)
            for (int i = 0; i < count; i++)
                for (int j = 0; j < count; j++)
                    if (adjacencyMatrix[i][j] != 1) {
                        if (adjacencyMatrix[i][k] == 1 && adjacencyMatrix[k][j] == 1)
                            adjacencyMatrix[i][j] = 1;

                    }

        return adjacencyMatrix;
    }
}
