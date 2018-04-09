package example.spel.calculation;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ExpressionParser parser = new SpelExpressionParser();
    	Expression expression = parser.parseExpression("1 * 10 + 1");
    	Integer calculationResult = expression.getValue(Integer.class);
 		System.out.println( "result: " + calculationResult );
    }
}
