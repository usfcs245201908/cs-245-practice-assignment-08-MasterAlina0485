import java.util.*;
/**
 * Write a description of class BST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BST<T extends Comparable<T>>
{
    // instance variables - replace the example below with your own
    private Node<T> root;

    /**
     * Constructor for objects of class BST
     */
    public BST()
    {
        // initialise instance variables
        root = null; 
    }

    public void insert (T data)
    {
        root = insert(root, data);

    }
    public Node insert(Node<T> start, T data) // Recursive call to find the right position for new node
    {  
        if (start == null) // base case
            start = new Node<T>(data);

        if (data.compareTo(start.getData())<0)
            start.left = insert(start.left, data);
        
        else if (data.compareTo(start.getData())>0)
            start.right = insert(start.right, data);
        else {}
            //start.count++;
        
            return start;
    }

    
    public boolean find (T data)
    {
        return find(root, data);
    }
    public boolean find (Node<T> start, T data)
    {        
        if (start == null) // base case
            return false;
        if (start.getData().equals(data)) // base case
            return true;

        if (data.compareTo(start.getData())<0)
            return find(start.left, data);
        else 
            return find(start.right, data);
    }
   
   
    public void delete (T data)
    {
        root = delete(root, data);
    }
    public Node delete (Node<T> start, T data)
    {  
        if (start == null) // base case
            return null;
        
            //finding right node
        if (data.compareTo(start.getData())<0)
            start.left = delete(start.left, data);
        else if(data.compareTo(start.getData())>0)
            start.right = delete(start.right, data);
        else //node to delete == start
        {

            //System.out.println("Count:"+start.count);
            /*if (start.count > 1) //multiples
            {
                System.out.println("Multiple exists.");
                start.count--; 
                return start;
            }*/
            
            if (start.left == null) //0 or 1 child
                return start.right;
            else if (start.right == null)
                return start.left;
            else{
                System.out.println("2 kids");
                Node<T> smallest = findMinParent(start.right); // Find smallest child node and promote
                smallest.left.right = start.right;
                smallest.left.left = start.left;
                smallest.left = null;
                start = smallest.left;
                return start;
            }
        }
        return start;
    }
    
    public Node findMinParent(Node<T> start)
    {
        while(start.left.left != null)
        {   
            start = start.left;
        }
        return start;
    }
    
    
    public void print()
    {
        print(root);
        System.out.println("");
    }
    
    public void print(Node<T> start)
    {
        if (start.left != null) //visit all left nodes
            print(start.left);
        System.out.println(start); //print self
        if (start.right != null) //visit all right nodes
            print(start.right);
    }

}
