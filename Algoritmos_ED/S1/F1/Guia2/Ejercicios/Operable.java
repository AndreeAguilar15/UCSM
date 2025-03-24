package ClasesGenericas;

public interface Operable<N extends Number>{
	public N suma(N operando1, N operando2);
	public N resta(N operando1, N operando2);
	public N producto(N operando1, N operando2);
	public N division(N operando1, N operando2);
	public N potencia(N operando1, N potencia);
	public N raizcuadrada(N operando1);
	public N raizcubica(N operando1);
}
