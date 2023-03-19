package fr.istic.vv;


import java.util.Comparator;
import java.util.Objects;

// Ne fonctionne pas passé une profondeur de 1
// Si l'arbre est 2(g=0,d=3) et qu'on push 1, il ira à gauche de 0 mais il faudrait qu'ils inversent leurs places
class BinaryHeap<T>
{
    private T value;
    private final Comparator<T> comparator;
    private BinaryHeap<T> left;
    private BinaryHeap<T> right;

    public BinaryHeap<T> getLeft()
    {
        return left;
    }

    public BinaryHeap<T> getRight()
    {
        return right;
    }

    public BinaryHeap(Comparator<T> comparator)
    {
        Objects.requireNonNull(comparator);
        this.comparator = comparator;
    }

    public T pop()
    {
        T v = value;
        if (right != null)
        {
            value = right.pop();
        } else
        {
            if (left != null)
            {
                value = left.pop();
            } else
            {
                value = null;
            }
        }
        return v;
    }

    public T peek()
    {
        return value;
    }

    public void push(T element)
    {
        Objects.requireNonNull(element);
        if (value == null)
        {
            value = element;
        }
        else if (comparator.compare(value, element) >= 0)
        {
            //will go to left side
            if (left != null)
            {
                left.push(element);
            } else
            {
                left = new BinaryHeap<>(comparator);
                left.push(element);
            }
        } else
        {
            if (right != null)
            {
                right.push(element);
            } else
            {
                right = new BinaryHeap<>(comparator);
                right.push(element);
            }
        }
    }

    public int count()
    {
        int v = (value == null) ? 0 : 1;
        if (left != null)
        {
            v += left.count();
        }
        if (right != null)
        {
            v += right.count();
        }
        return v;
    }
}