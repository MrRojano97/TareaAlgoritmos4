
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elias & yarixa
 */
public class Prim {

    
    public static class Node {
        int id;
        int x; //Coordenada X
        int y; //Coordenada Y
        List<Node> vecinos = new ArrayList<Node>();

        public Node(int nombre, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
        
        public double distance(Node nodeTest) {
            double cateto1 = x-nodeTest.x; //Cateto 1 a para utilizar en el cálculo de distnacia
            double cateto2 = y-nodeTest.y; //Cateto 2 a para utilizar en el cálculo de distancia

            return Math.sqrt((cateto1*cateto1)+(cateto2*cateto2)); //Distancia (Hipotenusa)
        }

    }
    
    public static class PRIM {
        double[][] distancias;
        
        List<Node> nodos = new ArrayList<Node>();
        
        public void iniciaMatriz(int n){
            distancias=new double[n+1][n+1];
        }
        
        public void insert(int id, int x, int y) {
            nodos.add(new Node(id,x,y));
        }
        
        public void distance(int nodeA, int nodeB){
            distancias[nodeA][nodeB]=nodos.get(nodeA).distance(nodos.get(nodeB));
        }
        
        public void imprimeMatriz(){
            for (int x=0; x < distancias.length; x++) {
                System.out.print("");
                for (int y=0; y < distancias[x].length; y++) {
                    System.out.print (distancias[x][y]);
                    if (y!=distancias[x].length-1) System.out.print("\t");
                }
            System.out.println("");
            }
        }   
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        PRIM prim = new PRIM();
        
        FileReader construction = new FileReader(args[0]);
        
        try (Scanner input = new Scanner(construction)) {
            int x=1;
            int n=Integer.parseInt(input.next());
            prim.iniciaMatriz(n);
            prim.insert(0, 0, 0); //Se añade nodo 0 para que los demás comienzen desde 1.
            while(x<=n) {
                prim.insert(Integer.parseInt(input.next()), Integer.parseInt(input.next()), Integer.parseInt(input.next()));
                x++;
            }
            while(input.hasNext()) {
                prim.distance(Integer.parseInt(input.next()), Integer.parseInt(input.next()));
            }
            
            prim.imprimeMatriz();
        }
    }   
}
