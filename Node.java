import java.util.*;
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node<T extends Comparable<T>>
{
    // instance variables - replace the example below with your own

    private T data;
    public Node<T> left = null;
    public Node<T> right = null; 
    
    //public int count;
    
    /**
     * Constructor for objects of class Node
     */
    public Node(T d)
    {
        // initialise instance variables
        data = d;
        //count = 1;
    }

    /**
     * Constructor for objects of class Node
     */
    public Node(T d, Node L, Node R)
    {
        // initialise instance variables
        data = d;
        left = L;
        right = R;
    }
    
    public T getData()
    {
        return data;
    }
    
    public String toString()
    {
        return data.toString();
    }
}
