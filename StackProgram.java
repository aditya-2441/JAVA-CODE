interface StackADT<T> {
void push(T element) throws StackOverflowException;
T pop() throws StackUnderflowException;
T peek() throws StackUnderflowException;
boolean isEmpty();
boolean isFull();
}
// Implementation using Array
class ArrayStack<T> implements StackADT<T> {
private T[] stack;
private int top;
private int capacity;
@SuppressWarnings("unchecked")
public ArrayStack(int capacity) {
this.capacity = capacity;
stack = (T[]) new Object[capacity];
top = -1;
}
@Override
public void push(T element) throws StackOverflowException {
if (isFull()) {
throw new StackOverflowException("Stack Overflow: Cannot push " + element);
}
stack[++top] = element;
}
@Override
public T pop() throws StackUnderflowException {
if (isEmpty()) {
throw new StackUnderflowException("Stack Underflow: Cannot pop from empty stack");
}
return stack[top--];
}
@Override
public T peek() throws StackUnderflowException {
if (isEmpty()) {
throw new StackUnderflowException("Stack Underflow: Cannot peek from empty stack");
}
return stack[top];
}
@Override
public boolean isEmpty() {
return top == -1;
}
@Override
public boolean isFull() {
return top == capacity - 1;
}
}
// Driver class
public class StackProgram {
public static void main(String[] args) {
try {
StackADT<Integer> stack = new ArrayStack<>(3);
stack.push(10);
stack.push(20);
stack.push(30);
System.out.println("Top element: " + stack.peek());
// Trying overflow
try {
stack.push(40);
} catch (StackOverflowException e) {
System.out.println(e.getMessage());
}
System.out.println("Popped: " + stack.pop());
System.out.println("Popped: " + stack.pop());
System.out.println("Popped: " + stack.pop());
// Trying underflow
try {
stack.pop();
} catch (StackUnderflowException e) {
System.out.println(e.getMessage());
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
// Custom Exception for Stack Overflow
class StackOverflowException extends Exception {
public StackOverflowException(String message) {
super(message);
}
}
// Custom Exception for Stack Underflow
class StackUnderflowException extends Exception {
public StackUnderflowException(String message) {
super(message);
}
}