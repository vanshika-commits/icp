//1Evaluate Reverse Polish Notation
import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                switch (t) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                }
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
//2 stock spam
import java.util.*;

class StockSpanner {
    Stack<int[]> st; // pair: [price, span]

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1];
        }
        st.push(new int[]{price, span});
        return span;
    }
}
//3 Simplify Path
import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for (String dir : path.split("/")) {
            if (dir.equals("") || dir.equals(".")) continue;
            else if (dir.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(dir);
            }
        }
        return "/" + String.join("/", st);
    }
}

