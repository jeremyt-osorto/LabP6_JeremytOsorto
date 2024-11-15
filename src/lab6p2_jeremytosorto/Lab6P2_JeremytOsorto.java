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
                case 2:
                case 3:
                    
                default:
                    
            }
        }
        while(opc<4);
    }
    
}
