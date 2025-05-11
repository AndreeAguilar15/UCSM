package Ejercicio4;
import Actividad1.ExceptionIsEmpty;
import Ejercicio1.StackLink;

public class Applicacion {

    public static boolean symbolBalancing(String S) {
        StackLink<Character> stack = new StackLink<>();

        //Recorrer cada carácter de la cadena
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            //Si es un corchete de apertura, lo agregamos a la pila
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            //Si es un corchete de cierre, verificamos si coincide con el último abierto
            else if (c == ')' || c == ']' || c == '}') {
                //Si la pila está vacía o el corchete no coincide, la secuencia no está balanceada
                if (stack.isEmpty()) {
                    return false;
                }
                try {
                    char top = stack.pop();
                    if (!isMatchingPair(top, c)) {
                        return false;
                    }
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '[' && close == ']') || 
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println(symbolBalancing("()()()[()]()")); // true
        System.out.println(symbolBalancing("((()))[]"));     // true
        System.out.println(symbolBalancing("([])[]("));      // false
        System.out.println(symbolBalancing("([{)]}"));       // false
        System.out.println(symbolBalancing("["));           // false
        System.out.println(symbolBalancing("[][][]{{{}}}")); // true
    }
}
