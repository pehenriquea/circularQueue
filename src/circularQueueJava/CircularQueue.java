package circularQueueJava;

import java.util.Scanner;

public class CircularQueue {
    
    public static void main (String [] args) throws Exception{

        Scanner sc = new Scanner (System.in);
        int tamanho, ultimo=0, auxUltimo=0, primeiro=0;
        double array[], numero, numeroBusca, numeroPos;
        char resp1, resp2, resp3;

        System.out.print("Digite o tamanho da fila: ");
        tamanho = sc.nextInt();
        System.out.println();

        array = new double [tamanho + 1];

        for (int i = 0; i < tamanho; i++){
        
            System.out.printf("Digite o %dº elemento da fila: ", i+1);
            numero = sc.nextDouble();
            array[i] = numero;
            listaCircular(numero, array, ultimo-1, primeiro);
            ultimo++;
            auxUltimo=ultimo;

        }
        
        if (vazio(array)==true) {
        	throw new Exception ("Array Vazio!!!");
        }

        System.out.println();
        System.out.print("Deseja adicionar algum elemento? Digite S para sim e N para não: ");
        resp1 = sc.next().charAt(0);
        
        if (resp1 == 's' || resp1 == 'S') {
        	
        	while (resp1 == 's' || resp1 == 'S') {
        		System.out.print("Digite o número a ser adicionado: ");
        		numero = sc.nextDouble();
        		array[array.length-1]=remover(array, ultimo, primeiro);
        		listaCircular(numero, array, auxUltimo-2, primeiro);
        		
        		ultimo++;
        		
        		System.out.print("\nDeseja continuar adicionando? Digite S para sim e N para não: ");
        		resp1 = sc.next().charAt(0);
        		
        	}
        	
        }
        
        System.out.println();
        System.out.print("Array: ");
        mostrarArray(array, tamanho=0);
        
        System.out.print("\n\nDeseja buscar algum elemento? Digite S para sim e N para não: ");
        resp2 = sc.next().charAt(0);
        
        if (resp2 == 's' || resp2 == 'S') {
        	
        	System.out.print("Digite o elemento a ser buscado: ");
        	numeroBusca=sc.nextDouble();
        	
        	if (busca(array, numeroBusca)==true) {
        		System.out.println("Elemento encontrado!");
        	} else {
        		System.out.println("Elemento não encontrado!");
        	}
        }
        
        System.out.print("\nDeseja buscar por posição? Digite S para sim e N para não: ");
        resp3 = sc.next().charAt(0);
        
        if (resp3 == 's' || resp3 == 'S') {
        	
        	System.out.print("Digite a posição do elemento: ");
        	numeroPos=sc.nextDouble();
        	
        	System.out.println("Elemento da posição "+(int)numeroPos+": "+retorna(array, numeroPos-1));
        	
        }
        
        sc.close();

    }

    public static void listaCircular (double x, double vetor[], int u, int p) throws Exception {
    	
    	u = (u+1) % vetor.length;
    	vetor[u] = x;
    	
    }
    
    public static void mostrarArray(double vet[], int tam) {
    	
    	if (tam<=vet.length-2) {
    		System.out.print(+vet[(int) tam]+" | ");    
    		mostrarArray(vet, tam+1);
    	}

    }
    
    public static boolean vazio(double vtr[]) {
    	
    	if ((vtr.length-1)==0) {
    		
    		return true;	
    		
    	}
    	else {
    		
    		return false;
    		
    	}
    }

    public static double remover(double vetor[], int u, int p) throws Exception{
    	
    	if (p == u) {
    		throw new Exception("Erro no remover!");
    	}
    	
    	for (int i = 0; i < vetor.length-1; i++){
    	      vetor[i] = vetor[i+1];
    	   }
    	
    	p = (p + 1) % vetor.length;
    	return 0;
    	
    }

    public static boolean busca(double vetor[], double elemento) {
    	
    	for (int i = 0; i < vetor.length; i++) {
    		
    		if (vetor[i] == elemento) {
    			return true;
    		}
    		
    	}	
		return false;
    }
    
    public static double retorna(double vetor[], double pos) {
    	
    	double elemento;
  
    	elemento = vetor [(int) pos];
    	
    	return elemento;
    	
    }
}