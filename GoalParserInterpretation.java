public class GoalParserInterpretation {

    public String interpret(String command) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == '(') {
                if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
                    str.append('o');
                    i += 2;
                } else {
                    i += 1;
                    while (i < command.length() && command.charAt(i) != ')') {
                        str.append(command.charAt(i));
                        i += 1;
                    }
                    i += 1;
                }
            } else {
                str.append(command.charAt(i));
                i += 1;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        GoalParserInterpretation obj = new GoalParserInterpretation();
        String command = "G()(al)";
        System.out.println(obj.interpret(command));
    }

}
