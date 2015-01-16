package adtstack;

/**
 *
 * @author czoeller
 */
public class Main {
    
    public static void main(String[] args) {
        IntStack is = new IntStack(5);
        is.init();
        System.out.println( "Is empty?: " + is.isEmpty() );
        is.push(5);
        System.out.println( "Is empty?: " + is.isEmpty() );
        System.out.println( "Oberstes Element: " + is.top() );
        System.out.println( "Is empty?: " + is.isEmpty() );
    }
 
}
