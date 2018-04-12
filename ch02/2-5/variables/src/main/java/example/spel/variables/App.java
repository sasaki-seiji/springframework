package example.spel.variables;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ExpressionParser parser = new SpelExpressionParser();

    	Staff staff = new Staff("sasaki", 1985);
    	StandardEvaluationContext context = new StandardEvaluationContext(staff);
    	context.setVariable("newName", "seiji");
    	
   		parser.parseExpression("name = #newName").getValue(context);
        System.out.println( "staff.name: " + staff.getName() );
    }
}
