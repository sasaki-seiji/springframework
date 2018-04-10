package example.spel.template;

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
    	Staff staff = new Staff();
    	staff.setName("sasaki");
    	staff.setJoinedYear(1985);
    	
    	ExpressionParser parser = new SpelExpressionParser();
    	Expression expression 
    		= parser.parseExpression("'Staff Name: #{name}, joined year: #{joinedYear}'");

    	String statement = expression.getValue(staff, String.class);
        System.out.println( statement );
    }
}
