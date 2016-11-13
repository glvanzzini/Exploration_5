import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Giampiero Vanzzini on 11/13/2016.
 *
 */
public class warshall {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File(args[0]));
        String[] n = in.nextLine().split(" ");
        int count = n.length;
        in.close();
        in = new Scanner(new File(args[0]));
        int[][] AdjacencyMatrix = new int[count][count];
        //in.nextLine();
        for(int i = 0; i < count; i ++){
            for(int j = 0; j < count; j++){
                AdjacencyMatrix[i][j] = in.nextInt();
            }
            if(in.hasNextLine())
            in.nextLine();
        }
        System.out.println("Adjacency Matrix: ");
        for(int i = 0; i < count; i ++){
            for(int j = 0; j < count; j++){
                System.out.print(AdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        long startTime = System.nanoTime();
        int[][] TransitiveClosure = Warshalls(AdjacencyMatrix, count);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Transitive Closure: " );
        for(int i = 0; i < count; i ++){
            for(int j = 0; j < count; j++){
                System.out.print(TransitiveClosure[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Warshall's run time: " + totalTime + " nanoseconds.");

    }

    private static int[][] Warshalls(int[][] adjacencyMatrix, int count) {
        for(int k = 0; k < count; k++){
            for(int i = 0; i < count; i++){
                for(int j = 0; j < count; j++){
                    if(adjacencyMatrix[i][k] == 1 && adjacencyMatrix[k][j] == 1){
                        adjacencyMatrix[i][j] = 1;
                    }
                }
            }
        }
        return adjacencyMatrix;
    }
}
