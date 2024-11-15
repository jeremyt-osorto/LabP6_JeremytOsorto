/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p2_jeremytosorto;
import java.util.Random;
import java.util.Scanner;

public class Lab6P2_JeremytOsorto {
    
    public static boolean[][] generar(int cant){
        Random ran= new Random();
        
        boolean[][] x=new boolean[cant][2];
        
        for (int i=0; i<cant;i++){
            for (int j=0; j<2; j++){
                int ra= ran.nextInt(0,2);
                
                if (ra==0){
                    x[i][j]=true;
                }
                else if (ra==1){
                    x[i][j]=false;
                }
            }
        }
        
        System.out.println(" P  Q");
        
        for (int i=0; i<cant;i++){
            for (int j=0; j<2; j++){
                
                if (x[i][j]==true){
                    System.out.print("["+1+"]");
                }
                else{
                    System.out.print("["+0+"]");
                }
            }
            System.out.println("");
        }
        
        return x;
    }
    
    public static boolean[][] operar(boolean[][] x, String car, int cant){
        boolean[][] v=new boolean[cant][3];
        
        for (int i=0;i<cant;i++){
            for(int j=0; j<2;j++){
                v[i][j]=x[i][j];
            }
        }
        
        char c=car.charAt(1);
        
        if((c=='^' || c=='v')&& car.length()==3){
            if(c=='^'){
                for (int i=0;i<cant;i++){
                    if (v[i][0]==true&&v[i][1]==true){
                        v[i][2]=true;
                    }
                    else{
                        v[i][2]=false;
                    }
                }
            }
            else{
                for (int i=0;i<cant;i++){
                    if (v[i][0]==true||v[i][1]==true){
                        v[i][2]=true;
                    }
                    else{
                        v[i][2]=false;
                    }
                }
            }
        }
        else{
            System.out.println("Ingrese una operación valida");
        }
        
        for (int i=0;i<cant;i++){
            for(int j=0; j<3;j++){
                if (v[i][j]==true){
                    System.out.print("["+1+"]");
                }
                else{
                    System.out.print("["+0+"]");
                }
            }
            System.out.println("");
        }
        
        return v;
    }
    
    public static int[][] gene(int tam){
        int[][]v= new int[(tam*2)+1][tam];
        int n = tam;
        int[][] pascal = new int[n][n];
        for (int i = 0; i < n; i++) {
            pascal[i][0] = 1; 
            pascal[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("[ ]");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("[" + pascal[i][j] + "]");
                if (pascal[i][j]!=' '){
                    System.out.print("[ ]");
                }
            }
            for (int j = i + 1; j < n; j++) {
                System.out.print("[ ]");
            }
            System.out.println();
        }
        
        return v;
    }
    
    public static int[][] generar1(int[][]y){
        Random ran= new Random();
        
        for (int i=0; i<y.length; i++){
            for(int j=0; j<y.length; j++){
                y[i][j]=ran.nextInt(0,10);
            }
        }
        
        for (int i=0; i<y.length; i++){
            for(int j=0; j<y.length; j++){
                System.out.print("["+y[i][j]+"]");
            }
            System.out.println("");
        }
        
        return y;
    }
    
    public static int[][] rota(int[][]y, String rot){
        String a,b,c,d;
        int f, co, f1, co1;
        a=rot.substring(0,2);
        b=rot.substring(3,5);
        
        if ((a.charAt(0)=='f' || a.charAt(0)=='c')||(b.charAt(0)=='f'||b.charAt(0)=='c')){
            if (a.charAt(0)=='f'){
                c=a.substring(1,2);
                f=Integer.parseInt(c);
                co=0;
            }
            else if(a.charAt(0)=='c'){
                c=a.substring(1,2);
                f=0;
                co=Integer.parseInt(c);
            }
            
            if (b.charAt(0)=='f'){
                d=b.substring(1,2);
                f1=Integer.parseInt(d);
                co1=0;
            }
            else if(b.charAt(0)=='c'){
                d=b.substring(1,2);
                f1=0;
                co1=Integer.parseInt(d);
            }
            
            
        }
        else{
            System.out.println("Ingrese un valor correct");
        }
        
        System.out.println(a+" "+b);
        
        return y;
    }
    
    public static void main(String[] args) {
        Scanner lee= new Scanner(System.in);
        Scanner lec= new Scanner(System.in);
        int opc;
        do{
            System.out.println("1-Tablas de verdad\n2-Triangulo de patron\n3-Intercambio de filas y columnas\n4-Salir\nIngrese opción: ");
            opc=lee.nextInt();
            
            switch (opc){
                case 1:
                    System.out.println("Ingrese la cantidad de filas: ");
                    int cant=lee.nextInt();
                    boolean[][]x=generar(cant);
                    System.out.println("Ingrese una opeción lógica[pvq o p^q]");
                    String car=lec.next();
                    operar(x,car, cant);
                    break;
                case 2:
                    System.out.println("Ingrese el tamaño de la piramide: ");
                    int tam=lee.nextInt();
                    
                    int[][]z=gene(tam);
                    
                    break;
                case 3:
                    System.out.println("Ingrese el tamaño de su matriz cuadrada");
                    int tama=lee.nextInt();
                    
                    int[][]y=new int[tama][tama];
                    generar1(y);
                    
                    System.out.print("Ingrese comando de rotacion: ");
                    String rot=lec.next();
                    rota(y, rot);
                    
                    break;
                    
                default:
                    System.out.println("Gracias por usar mi programa :)");
                    break;
                    
            }
        }
        while(opc<4);
    }
    
}
