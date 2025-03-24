package ClasesGenericas;

public class OperacionesMatInteger implements Operable<Integer>{
	public Integer suma(Integer operando1, Integer operando2) {
		return operando1+operando2;
	}
	public Integer resta(Integer operando1, Integer operando2) {
		return operando1-operando2;
	}
	public Integer producto(Integer operando1, Integer operando2) {
		return operando1*operando2;
	}
	public Integer division(Integer operando1, Integer operando2) {
		return operando1/operando2;
	}
	public Integer potencia(Integer operando1, Integer potencia) {
		return (int) Math.pow(operando1,potencia);
	}
	public Integer raizcuadrada(Integer operando1) {
		return (int) Math.sqrt(operando1);
	}
	public Integer raizcubica(Integer operando1) {
		return (int) Math.cbrt(operando1);
	}
}

