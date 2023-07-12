public class MatrizSimetrica {
    public static void main(String[] args) {
        int[][] matriz = {
                {1,2,3,4},
                {2,1,0,5},
                {3,0,1,6},
                {4,5,6,7}
        };

        boolean simetrica = true;
        bucle: for(int i=0;i<matriz.length;i++){
            for(int j=0;j<i;j++){
                if(matriz[i][j] != matriz[j][i]){
                    simetrica = false;
                    break bucle;
                }
            }
        }
        if(simetrica){
            System.out.println("La matriz es simetrica");
        }else{
            System.out.println("No es simetrica");
        }
    }
}
