package brace;

public class BraceChecker {
    private final String text;
    private final Stack<Brace> stack;

    public BraceChecker(String text) {
        this.text = text;
        this.stack = new Stack<>(Brace.class, 10);
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '(', '[', '{' -> stack.push(new Brace(c, i));
                case ')', ']', '}' -> {
                    if (stack.isEmpty()) {
                        System.out.println("Error: closed " + c + " at " + i + " but nothing was opened.");
                    } else {
                        Brace open = stack.pop();
                        if (!bracesMatch(open.getBrace(), c)) {
                            System.out.println("Error: opened " + open.getBrace() + " at " + open.getIndex() +
                                    " but closed " + c + " at " + i);
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            Brace unclosed = stack.pop();
            System.out.println("Error: opened " + unclosed.getBrace() + " at " + unclosed.getBrace() + " but not closed.");
        }
    }

    private boolean bracesMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}