package adtstack;

/**
 *
 * @author czoeller
 */
public abstract class ADTStack<T> {
    protected int size;
    protected T[] stack;
    
    /**
     * Initialises the stack.
     * Precondition: Stack is in any state.
     * Postcondition: Stack is empty.
     */    
    abstract void init();
    /** Returns true if empty */
    abstract boolean isEmpty();
    /** Returns true if full */
    abstract boolean isFull();
    /** 
     * Adds an atom to the top.
     * Precondition: Stack is not full.
     * Postcondition: Atom was added to the Stack.
     */
    abstract void push( T a ) throws FullStackException;
    /** 
     * Deletes the top atom. 
     * Precondition: Stack is not empty.
     * Postcondition: First atom was removed from the Stack. 
     */
    abstract void pop() throws EmptyStackException;
    /** 
     * Returns the top atom. 
     * Precondition: Stack is not empty.
     * Postcondition: Stack is untouched. 
     */
    abstract T top() throws EmptyStackException;
}