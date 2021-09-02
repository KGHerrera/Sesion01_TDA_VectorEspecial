import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 Operaciones: 
	
		[HECHO] 1) Crear
		[HECHO] 2) Llenar
		3) Obtener posición inicio
		4) Obtener posición fin
		5) Obtener cantidad elementos	
		[HECHO] 6) Mostrar todo los elementos
		7) Mostrar elemento del inicio
		8) Mostrar elemento del fin
		9) Aumentar tamaño del arreglo
		10) Disminuir tamaño del arreglo	
		11) Insertar elemento en posición especifica
		12) Eliminar elemento de posición especifica
		13) Invertir el vector
 
 */

class VectorEspecial{
	
	private int vector[];
	Scanner entrada = new Scanner(System.in);
	
	
	
	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public VectorEspecial(int tamaño) {
		vector = new int[tamaño];
	}
	
	public void llenarVectorAutomatizado() {
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Random().nextInt(99)+1;
		}
	}
	
	public void mostrarVetor() {
		System.out.println(Arrays.toString(vector));
	}
	
	public void obtenerPosicionInicio(){
		System.out.println("Posicion de inicio: " + 0);
	}
	
	public void obtenerPosicionFinal() {
		System.out.println("Pisicion Final: " + (vector.length - 1));
	}
	
	public void obtenerCantidadElementos() {
		System.out.println("Cantidad de elementos: " + vector.length);
	}
	
	public void obtenerElementoInicio(){
		System.out.println("Elemento de inicio: " + vector[0]);
	}
	
	public void obtenerElementoFinal() {
		System.out.println("Elemento Final: " + vector[vector.length-1]);
	}
	
	public int[] aumentarTamañoVector(int nuevoTamaño) {
		int vectorNuevo[] = new int[nuevoTamaño];
		
		for (int i = 0; i < vector.length; i++) {
			vectorNuevo[i] = vector[i];
		}
		
		return vectorNuevo;
	}
	
	public int[] disminuirTamañoVector(int nuevoTamaño) {
		int vectorNuevo[] = new int[nuevoTamaño];
		
		for (int i = 0; i < vectorNuevo.length; i++) {
			vectorNuevo[i] = vector[i];
		}
		
		return vectorNuevo;
	}
	
	public int[] insertarElementoPocicionEspecifica(int posicion, int elemento) {
		vector[posicion] = elemento;
		return vector;
	}
	
	public int[] eliminarElementoPocicionEspecifica(int posicion) {
		
		if (vector.length > 1){
			int[] nuevoVector = new int[vector.length-1];
			int cont = 0;
			
			for (int i = 0; i < vector.length; i++) {
				if (i != posicion) {
					nuevoVector[cont] = vector[i];
					cont++;
				}else {
					
				}
			}
			return nuevoVector;
		} else {
			System.out.println("> El vector es de tamaño 1 no se puede eliminar");
			return vector;
		}
		
		
	}
	
	public int[] invertirVector() {
		int nuevoVector[] = new int[vector.length];
		int cont = 0;
		for (int i = vector.length-1; i >= 0; i--) {
			nuevoVector[cont] = vector[i];
			cont++;
		}
		
		return nuevoVector;
	}
	
	
	public VectorEspecial llenarVectorTeclado(VectorEspecial v1) {
		
		
		for (int i = 0; i < v1.vector.length; i++) {
			System.out.println("Introduce elemento " + (i+1) + ": " );
			v1.vector[i] = entrada.nextInt();
		}
		
		return v1;
		
	}
	
}

public class PruevaVectorEspecial {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce Tamaño del vector: ");
		int tamaño = 0;
		do {
			tamaño = entrada.nextInt();
			if (tamaño <= 0) {
				System.out.println("El tamaño debe ser mayor a 0 introduce otro: ");
			}
		} while(tamaño <= 0);
		
		VectorEspecial v1 = new VectorEspecial(tamaño);
		v1.llenarVectorAutomatizado();
		
		//v1.llenarVectorTeclado(v1);
		
		// aumentar tamaño de vector
		int nuevoTamaño = 0;
		int posicion = 0;
	
		int opcion = 0;
		
		do {
			nuevoTamaño = 0;
			posicion = 0;
			System.out.println("\nElije una de las siguientes opciones");
			System.out.println("1) Obtener pocicion de inicio");
			System.out.println("2) Obtener pocicion final ");
			System.out.println("3) Obtener cantidad de elementos");
			System.out.println("4) Mostrar todos los elementos");
			System.out.println("5) Mostrar elemento de inicio");
			System.out.println("6) Mostrar elemento de fin");
			System.out.println("7) Aumentar tamaño del arreglo");
			System.out.println("8) disminuir tamaño del arreglo");
			System.out.println("9) Insertar elemento en posicion especifica");
			System.out.println("10) Eliminar elemento de posicion especifica");
			System.out.println("11) Invertir vector");
			System.out.println("Introduce opcion: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				v1.obtenerPosicionInicio();
				break;
				
			case 2:
				v1.obtenerPosicionFinal();
				break;
				
			case 3:
				v1.obtenerCantidadElementos();
				break;
				
			case 4:
				v1.mostrarVetor();
				break;
				
			case 5:
				v1.obtenerElementoInicio();
				break;
				
			case 6:
				v1.obtenerElementoFinal();
				break;
				
			case 7:
				System.out.println("\nIntroduce nuevo tamaño de vector (mayor): ");
				do {
					do {
						nuevoTamaño = entrada.nextInt();
						if (nuevoTamaño <= 0) {
							System.out.println("El tamaño debe ser mayor a 0 introduce otro: ");
						}
					} while(nuevoTamaño <= 0);
					
					if (nuevoTamaño <= (v1.getVector().length)) {
						System.out.println("El tamaño es menor introduce otro: ");
					}
				} while (nuevoTamaño <= (v1.getVector().length));
				v1.setVector(v1.aumentarTamañoVector(nuevoTamaño));
				System.out.println(">> Tamaño aumentado");
				break;
				
			case 8:
				System.out.println("\nIntroduce nuevo tamaño de vector (menor): ");
				do {
					do {
						nuevoTamaño = entrada.nextInt();
						if (nuevoTamaño <= 0) {
							System.out.println("El tamaño debe ser mayor a 0 introduce otro: ");
						}
					} while(nuevoTamaño <= 0);
					
					if (nuevoTamaño >= (v1.getVector().length)) {
						System.out.println("El tamaño es mayor introduce otro: ");
					}
				} while (nuevoTamaño >= (v1.getVector().length));
				v1.setVector(v1.disminuirTamañoVector(nuevoTamaño));
				System.out.println(">> Tamaño disminuido");
				break;
				
			case 9:
				System.out.println("\nIntroduce posicion del elemento a insertar: ");
				do {
					posicion = entrada.nextInt();
					if (!(posicion >= 0 && posicion <= v1.getVector().length)){
						System.out.println("La posicion no esta dentro del rango, introduce otro: ");
					}	
				} while(!(posicion >= 0 && posicion <= v1.getVector().length));
				
				System.out.println("introduce elemento: ");
				int elemento = entrada.nextInt();
				v1.setVector(v1.insertarElementoPocicionEspecifica(posicion-1, elemento));
				System.out.println(">> Elemento insetado");
				break;
				
			case 10:
				System.out.println("\nIntroduce posicion del elemento a eliminar: ");
				do {
					posicion = entrada.nextInt();
					if (!(posicion >= 0 && posicion <= v1.getVector().length)){
						System.out.println("La posicion no esta dentro del rango, introduce otro: ");
					}
				} while(!(posicion >= 0 && posicion <= v1.getVector().length));
				v1.setVector(v1.eliminarElementoPocicionEspecifica(posicion-1));
				System.out.println(">> Elemento eliminado");
				break;
				
			case 11:
				System.out.println("\nVector invertido: ");
				v1.setVector(v1.invertirVector());
				System.out.println(">> Vector invertido");
				break;
				
			case 12:
				System.out.println("Saliendo . . .");

			default:
				System.out.println("\n>> Opcion incorrecta\n");
				break;
			}
			
		} while(opcion != 12);
		
	}
}
