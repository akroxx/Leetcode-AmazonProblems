class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                //Forming operand, since it could be more than one digit
                operand = 10*operand + (int) (c - '0');
            }
            else if(c == '+'){
                //Evaluate expression to the left
                //with result, sign, operand
                result += sign*operand;

                //save recently encountered '+' sign
                sign = 1;

                //reset operand
                operand = 0;
            }
            else if(c == '-'){
                
                result += sign*operand;
                
                sign = -1;

                operand = 0;
            }
            else if(c == '('){
                //Push the result and sign on to the stack, for later
                //We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                //Reset operand and result, as if new evaluation begins for the () sub-expression
                sign = 1;
                result = 0;
            }
            else if(c == ')'){

                //Evaluate the expression to the left
                //with result, sign and operand
                result += sign * operand;

                //')' marks end of expression within set of ()
                //It's result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the ()

                result *= stack.pop();

                //Then add to the next operand on top of stack
                //as stack.pop() is the result calc before this ()
                // (operand on stack) + (sign on stack * (result from paranthesis()))
                result += stack.pop();

                operand = 0;
            }
        }

        return result + (sign*operand);
    }
}