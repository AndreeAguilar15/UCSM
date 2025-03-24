package ClasesGenericas;
import java.util.Scanner;

public class Prueba {
	public static void main(String[] args) {
		Scanner escaner= new Scanner(System.in);
		int op;
		
		OperacionesMatInteger operacionesMatInteger = new OperacionesMatInteger();
		System.out.println(operacionesMatInteger.suma(1, 15));
		OperacionesMatDouble operacionesMatDouble= new OperacionesMatDouble();
		System.out.println("Eliga la operación:");
		System.out.print("1.Suma\n2.Resta\n3.Multiplicación\n4.Division\n5.Potencia\n6.Raiz cuadrada\n7.Raiz cubica\n8.Salir");
		op=escaner.nextInt();
		while(op<8) {
		if(op<5) {
		System.out.println("Ingrese el primer número:");
		if (escaner.hasNextInt()) {
            int num1 = escaner.nextInt();
            System.out.println("Ingrese el segundo número:");
            if (escaner.hasNextInt()) {
                int num2 = escaner.nextInt();
                realizarOperacion(op, num1, num2, operacionesMatInteger);
            } else if (escaner.hasNextDouble()) {
                double num2 = escaner.nextDouble();
                realizarOperacion(op, num1, num2, operacionesMatDouble);
            } else {
                System.out.println("Entrada no válida.");
            }
        } else if (escaner.hasNextDouble()) {
            double num1 = escaner.nextDouble();
            System.out.println("Ingrese el segundo número:");
            if (escaner.hasNextInt()) {
                int num2 = escaner.nextInt();
                realizarOperacion(op, num1, num2, operacionesMatDouble);
            } else if (escaner.hasNextDouble()) {
                double num2 = escaner.nextDouble();
                realizarOperacion(op, num1, num2, operacionesMatDouble);
            } else {
                System.out.println("Entrada no válida.");
            }
        } else {
            System.out.println("Entrada no válida.");
        }
		}
		else if(op==5) {
			System.out.println("Ingrese el primer número:");
			if (escaner.hasNextInt()) {
	            int num1 = escaner.nextInt();
	            System.out.println("Ingrese la potencia:");
	    		int num2 = escaner.nextInt();
	    		realizarOperacion(op, num1, num2, operacionesMatInteger);
			} else if (escaner.hasNextDouble()) {
	            double num1 = escaner.nextDouble();
	            System.out.println("Ingrese la potencia:");
	    		int num2 = escaner.nextInt();
	    		realizarOperacion(op, num1, num2, operacionesMatDouble);
			}}
		else if(op>5&op<8) {
			System.out.println("Ingrese el número:");
			if (escaner.hasNextInt()) {
	            int num1 = escaner.nextInt();
	            int num2=0;
	            realizarOperacion(op, num1, num2, operacionesMatInteger);
			} else if (escaner.hasNextDouble()) {
	            double num1 = escaner.nextDouble();
	            double num2=0;
	            realizarOperacion(op, num1, num2, operacionesMatDouble);
			}
		}
		System.out.println("Eliga la operación:");
		System.out.print("1.Suma\n2.Resta\n3.Multiplicación\n4.Division\n5.Potencia\n6.Raiz cuadrada\n7.Raiz cubica\n8.Salir");
		op=escaner.nextInt();
		}
		System.out.println("Adios");

    }
 
    private static void realizarOperacion(int op, int num1, int num2, OperacionesMatInteger operaciones) {
        switch (op) {
            case 1:
                System.out.println("Resultado: "+operaciones.suma(num1,num2)+"\n");
                break;
            case 2:
                System.out.println("Resultado: "+operaciones.resta(num1,num2)+"\n");
                break;
            case 3:
                System.out.println("Resultado: "+operaciones.producto(num1,num2)+"\n");
                break;
            case 4:
            	if(num2==0) {
            		System.out.println("No es posible dividir entre 0");
            		break;
            	}
            	else{
            		System.out.println("Resultado: "+operaciones.division(num1,num2)+"\n");
            	}
                break;
            case 5:
            	System.out.println("Resultado: "+operaciones.potencia(num1,num2)+"\n");
            	break;
            case 6:
            	System.out.println("Resultado: "+operaciones.raizcuadrada(num1)+"\n");
            	break;
            case 7:
            	System.out.println("Resultado: "+operaciones.raizcubica(num1)+"\n");
            	break;
            default:
                System.out.println("Operación no válida.");
        }
    }

    private static void realizarOperacion(int op, double num1, double num2, OperacionesMatDouble operaciones) {
        switch (op) {
            case 1:
                System.out.println("Resultado: "+operaciones.suma(num1,num2)+"\n");
                break;
            case 2:
                System.out.println("Resultado: " + operaciones.resta(num1,num2)+"\n");
                break;
            case 3:
                System.out.println("Resultado: " + operaciones.producto(num1,num2)+"\n");
                break;
            case 4:
            	if(num2==0) {
            		System.out.println("No es posible dividir entre 0");
            		break;
            	}
            	else{
            		System.out.println("Resultado: "+operaciones.division(num1,num2)+"\n");
            	}
            	break;
            case 5:
            	System.out.println("Resultado: "+operaciones.potencia(num1,num2)+"\n");
            	break;
            case 6:
            	System.out.println("Resultado: "+operaciones.raizcuadrada(num1)+"\n");
            	break;
            case 7:
            	System.out.println("Resultado: "+operaciones.raizcubica(num1)+"\n");
            	break;
            default:
                System.out.println("Operación no válida.");
        }
    }
}