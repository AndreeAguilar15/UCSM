package ClasesGenericas;

public class OperacionesMatDouble implements Operable<Double>{
	public Double suma(Double operando1, Double operando2) {
		return operando1+operando2;
	}
	
	public Double resta(Double operando1, Double operando2) {
		return operando1-operando2;
	}

	public Double producto(Double operando1, Double operando2) {
		return operando1*operando2;
	}

	public Double division(Double operando1, Double operando2) {
		return (double) operando1/operando2;
	}
	public Double potencia(Double operando1, Double potencia) {
		return (double) Math.pow(operando1,potencia);
	}
	public Double raizcuadrada(Double operando1) {
		return (double) Math.sqrt(operando1);
	}
	public Double raizcubica(Double operando1) {
		return (double) Math.cbrt(operando1);
	}
}
