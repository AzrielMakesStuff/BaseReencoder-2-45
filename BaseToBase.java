import java.util.*; //Import Scanner And Arraylist
public class BaseToBase { //Create Class
    public static void main(String[] args) //Create Main Method
    {
        byte maxBase = 45;
        Scanner input = new Scanner(System.in); //Import Scanner
        char[] baseValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'}; //Index Aplhanumericals
        System.out.println("Welcome To My Base Converter, All Output Values Will End With A \';\' To Show Space Characters After Base 37. These Aren't Counted As Alphanumerical Values.");
        while (true) //Loop
        {
            ArrayList<Byte> reverseBase = new ArrayList<Byte>(); //Create Arraylist Object for reversed base values
            try
            {
                System.out.print("Please Enter Your Value Or # To End: "); //Request From User
                String value = input.nextLine(); //Get alphnumeric value from user
                if (value.equals("#")) //If it is a #
                {
                    break; //Break the loop and end
                }
                System.out.print("Please Enter The Current Base: "); //Request from user
                byte currentBase = Byte.parseByte(input.nextLine()); //Recieve current base
                if (currentBase > 1 && currentBase <= maxBase) //if the current base is in range
                {
                    boolean error = false; //define error for input testing
                    int numberDebug = 0; //define numberDebug for input testing
                    char[] characters = value.toCharArray(); //Convert value inputted to character array
                    byte[] characterValues = new byte[characters.length]; //create a byte array to move values to
                    for (int i = 0; i < characters.length; i++) //loop through character array
                    {
                        for (byte v = 0; v < currentBase; v++) //loop through all possible current base values
                        {
                            if (Character.toUpperCase(characters[i]) == baseValues[v]) //if the recieved value matches a base
                            {
                                characterValues[i] = v; //add index value to byte array
                                numberDebug++; //add to number debug for input testing
                            }
                        }
                    }
                    int decimalValue = 0; //define decimalValue for the decimal value of the input
                    int v = 0; //define v as int for indexing
                    for (int i = characterValues.length - 1; i >= 0; i--) //loop backwards through the character values using i for the reverse base index
                    {
                        decimalValue += Math.pow(currentBase, i) * characterValues[v]; //convert the character values to their decimal counterpart and add to decimalValue
                        v++; //add to v index for characterValues
                    }
                    if (characters.length != numberDebug) //input testing ensure all recieved values are base
                    {
                        error = true; //set error to true
                    }
                    if (!error) //if not error
                    {
                        System.out.print("Please Enter The Base To Convert To: "); //request from user
                        byte newBase = Byte.parseByte(input.nextLine()); //recieve base to convert to
                        if (newBase > 1 && newBase <= maxBase) //ensure base is in range
                        {
                            int Quotient = decimalValue; //set quotient to the decimal value
                            while(Quotient != 0) //while the quotient isnt 0
                            {
                                reverseBase.add((byte)(Quotient - Math.floor(Quotient / newBase) * newBase)); //get remainder and add it to reverseBase ArrayList
                                Quotient = (int)Math.floor(Quotient / newBase); //set quotient to remaining values
                            }
                            for (int i = reverseBase.size() - 1; i >= 0; i--) //Loop backwards through reverseBase
                            {
                                System.out.print(baseValues[reverseBase.get(i)]); //Print baseValues indexed by reverseBase values
                            }
                            System.out.println(";"); //Create new line
                        }
                        else //If not in range
                        {
                            System.out.printf("Please Enter A Base Between 2 & %d.", maxBase); //Report to user
                        }
                    }
                    else //If Values arent base
                    {
                        System.out.println("Please Ensure Values Are Correct"); //Report to user
                    }
                }
                else //If not in range
                {
                    System.out.printf("Please Enter A Base Between 2 & %d.", maxBase); //Report to user
                }
            }
            catch (NumberFormatException error) //If Failed Parsing
            {
                System.out.println("Bad Syntax"); //Report To User
                System.out.println(error);
            }
        }
        input.close(); //Close Scanner to prevent memory leak
    }
}
//(C) Azriel D.