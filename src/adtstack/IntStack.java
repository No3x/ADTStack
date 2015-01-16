package adtstack;

import java.util.Arrays;

/**
 *
 * @author czoeller
 */
class IntStack extends ADTStack<Integer> {
    
    public int stack[];
    public int head;

    public IntStack(int size) {
        this.size = size;
        this.init();
    }
    
    @Override
    void init() {
        this.stack = new int[this.size];
        this.head = -1;
    }

    @Override
    boolean isEmpty() {
        return this.head == -1;
    }

    @Override
    boolean isFull() {
        return this.head == this.size-1;
    }

    @Override
    void push(Integer a) throws FullStackException {
        if( this.isFull() )
            throw new FullStackException("Stack is full.");
        this.head++;
        this.stack[this.head] = a;
    }

    @Override
    void pop() throws EmptyStackException {
        if( this.isEmpty() )
            throw new EmptyStackException("Stack is empty.");
        this.stack[this.head] = 0;
        this.head--;
    }

    @Override
    Integer top() throws EmptyStackException {
        if( this.isEmpty() ) 
            throw new EmptyStackException("Stack is empty.");
        return this.stack[head];
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(this == o)
            return true;
        if(this.getClass() != o.getClass())
            return false;
        if(this.hashCode() == o.hashCode())
            return true;
        // any other case
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Arrays.hashCode(this.stack);
        hash = 11 * hash + this.head;
        return hash;
    }
}
