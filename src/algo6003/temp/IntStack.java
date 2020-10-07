package algo6003.temp;

public class IntStack {
    int [] stack;
    int top = 0;

    public IntStack(){
        stack = new int [4];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void push(int i){
        if(top == stack.length){
            resize(stack.length*2);
        }
        stack[top] = i;
        top++;
    }

    public int pop(){
        int item = stack[top - 1];
        stack[top - 1] = 0;
        top--;

        return item;
    }

    private void resize(int newCapacity){
        int [] temp = new int [newCapacity];

        System.arraycopy(stack, 0, temp, 0, stack.length);

//        for (int i = 0; i < stack.length; i++){
//            temp[i] = stack[i];
//        }

        stack = temp;
    }

    public static void main(String[] args) {
        IntStack is = new IntStack();

        is.push(10);
        is.push(20);
        is.push(30);
        is.push(40);

        System.out.println(is.pop());
        System.out.println(is.pop());

        is.push(50);
        is.push(60);

        while(!is.isEmpty()){
            System.out.println(is.pop());
        }


    }
}