import java.util.Stack;

public class ValidParanthesis 
{
    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c=='('||c=='{'||c=='[')
            {
                stack.push(c);
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    char top = stack.pop();
                    if(c==')' && top != '(')
                    {
                        return false;
                    }
                    else if(c=='}' && top != '{')
                    {
                        return false;
                    }
                    else if(c==']' && top != '[')
                    {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) 
    {
        String s = "({})";
        System.out.println(isValid(s));
    }
}
