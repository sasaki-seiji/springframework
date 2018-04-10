package example.spel.generate_object;

import java.util.List;
import java.util.Map;

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

    	Expression exprList = parser.parseExpression("{1,2,3}");
    	List<?> list = exprList.getValue(List.class);
 		System.out.println( "list: " + list );

 		Expression exprMap = parser.parseExpression("{name:'Sprng 太郎', joinedYear:2000}");
 		Map<?,?> map = exprMap.getValue(Map.class);
 		System.out.println( "map: " + map );
 		
 		Expression exprIntArray = parser.parseExpression("new int[]{1,2,3}");
 		int [] intArray = (int[])exprIntArray.getValue();
 		System.out.println( "intArray[0]: " + intArray[0] 
 							+ ", intArray[1]: " + intArray[1]
 							+ ", intArray[2]: " + intArray[2]);
    }
}
