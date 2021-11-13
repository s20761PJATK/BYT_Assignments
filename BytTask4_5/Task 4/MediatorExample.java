public class MediatorExample {

    //This is an example of the Mediator design pattern (Also using a calculator as the basis)
    public static void main(String[] args) {
        String form = "2 * 2";
        System.out.println(Mediator(form));

        System.out.println(Mediator("3 + 5"));
        System.out.println(Mediator("8 - 3"));
        System.out.println(Mediator("6 / 2"));

        System.out.println(Mediator("9 % 2"));
    }


    private static double Mediator(String input)
    {
        //Mediator is called first, and then it chooses which method must be called
        if(input.contains("+"))
            return CalcAdd(input);
        else if(input.contains("-"))
            return CalcSubt(input);
        else if(input.contains("*"))
            return CalcMult(input);
        else if(input.contains("/"))
            return CalcDiv(input);
        else
        {
            System.out.println("Error: Incorrect input");
            System.exit(1);
        }
        return 0;
    }


    //The modular methods, which can be only called through the mediator
    private static double CalcAdd(String input)
    {
        int output = (Integer.parseInt(input.substring(0,1)) + Integer.parseInt(input.substring(4)));
        return output;
    }
    private static double CalcSubt(String input)
    {
        int output = (Integer.parseInt(input.substring(0,1)) - Integer.parseInt(input.substring(4)));
        return output;
    }
    private static double CalcMult(String input)
    {
        int output = (Integer.parseInt(input.substring(0,1)) * Integer.parseInt(input.substring(4)));
        return output;
    }
    private static double CalcDiv(String input)
    {
        int output = (Integer.parseInt(input.substring(0,1)) / Integer.parseInt(input.substring(4)));
        return output;
    }
}
