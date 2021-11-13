public class CalculatorExample {


    //This is an example of the Chain Of Responsibility design pattern
    public static void main(String[] args) {
        String form = "2 * 2";
        System.out.println(CalcAdd(form));

        System.out.println(CalcAdd("3 + 5"));
        System.out.println(CalcAdd("8 - 3"));
        System.out.println(CalcAdd("6 / 2"));

        System.out.println(CalcAdd("9 % 2"));
    }

    private static double CalcAdd(String input)
    {
        //First step is addition
        if(input.contains("+"))
        {
            //If this method can resolve the problem, then the chain stops
            int output = (Integer.parseInt(input.substring(0,1)) + Integer.parseInt(input.substring(4)));
            return output;
        }
        else        //If this method cannot resolve the problem, it moves up the chain
            return CalcSubt(input);
    }
    private static double CalcSubt(String input)
    {
        //Next step is Subtraction
        if(input.contains("-"))
        {
            int output = (Integer.parseInt(input.substring(0,1)) - Integer.parseInt(input.substring(4)));
            return output;
        }
        else
            return CalcMult(input);
    }
    private static double CalcMult(String input)
    {
        //Next step is multiplication
        if(input.contains("*"))
        {
            int output = (Integer.parseInt(input.substring(0,1)) * Integer.parseInt(input.substring(4)));
            return output;
        }
        else
            return CalcDiv(input);
    }
    private static double CalcDiv(String input)
    {
        //Next step is division
        if(input.contains("/"))
        {
            int output = (Integer.parseInt(input.substring(0,1)) / Integer.parseInt(input.substring(4)));
            return output;
        }
        else
        {
            //If it cannot resolve the problem, it will end the chain with an error (As there is no next step in the chain)
            System.out.println("Error: Scope beyond this calculator");
            System.exit(1);
        }
        return 0;
    }
}
