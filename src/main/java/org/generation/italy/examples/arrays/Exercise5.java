package org.generation.italy.examples.arrays;

public class Exercise5 {
    /*Dato un array di 11 String di cui 10 vuote e 1 di valore “U” 
    (inizialmente all’indice 5), simulare il problema del cammino dell’ubriaco:
    A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso destra
    di 1 posizione nell’array. L’ubriaco continua a spostarsi finché non esce dall’array.
    Ad ogni passo, stampare la visualizzazione grafica di tutto l’array per mostrare la posizione
    attuale dell’ubriaco.Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
    Alla fine dell’esecuzione, stampare il numero di passi che l’ubriaco ha compiuto prima di uscire.
    */
    static void main() {
        String[] path=new String[11];
        for (int i = 0; i < path.length; i++) {
            path[i]= (i==5)? "U" : "";
        }
        int steps= walk(path,5);
        System.out.println("\nL'ubriaco ha compiuto "+(steps-1)+"passi prima di uscire");
    }
    public static int walk(String[] path,int position){
        int steps=0;
        do{
            printPath(path);
            if(Math.random()<0.5) position= moveLeft(path,position);
            else position=moveRight(path,position);
            steps++;
        }while(position>-1 && position<path.length);
        return steps;
    }

    public static void printPath(String[] path) {
        IO.println();
        for(String cell:path){
            if(cell.equals("U")) System.out.print("U");
            else System.out.print("_");
        }
    }

    public static int moveRight(String[] path, int position) {
        for (int i = 0; i < path.length; i++) {
            if(path[i].equals("U")&&i+1<path.length){
                path[i+1]="U";
                path[i]="";
                position=i+1;
                break;
            } else if (path[i].equals("U")&&i+1==path.length) {
                position=i+1;
                break;
            }
        }
        return position;
    }

        public static int moveLeft(String[] path, int position) {
            for (int i = 0; i < path.length; i++) {
                if (path[i].equals("U")&&i>0) {
                    path[i - 1] = "U";
                    path[i] = "";
                    position = i - 1;
                    break;
                }else if (path[i].equals("U")&&i==0) {
                    position=i-1;
                    break;
                }


            }
            return position;
        }
}
