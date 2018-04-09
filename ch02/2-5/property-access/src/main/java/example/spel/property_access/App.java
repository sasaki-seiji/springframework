package example.spel.property_access;

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
    	Expression expression = parser.parseExpression("joinedYear");

    	Staff staff = new Staff();
    	expression.setValue(staff, "2000");
    	Integer joinedYear = staff.getJoinedYear();
        System.out.println( "joinedYear: " + joinedYear );
    }
}
