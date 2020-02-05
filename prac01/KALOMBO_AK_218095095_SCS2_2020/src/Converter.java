import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Converter {
    public Converter() {
    };// constructor

    public String Encode(String message) {// function to encode the message
        clearMessage = message.toUpperCase(); // Make the message upper case
        // Begin encoding message
        for (int i = 0; i < message.length(); i++) {
            int index = -1; // Stores the index of the character in the text array to be correlated to the
                            // secret array
            char temp = clearMessage.charAt(i); // Get the character out of the string
            // Search the text array for the index of the character
            for (int j = 0; j < 37; j++) {
                if (text[j].charAt(0) == temp) { // Compare every character in text to the temp character
                    index = j;
                }
            }
            if (index != -1) { // Make sure we have a valid character
                secretMessage += scram[index]; // Convert the character to secret characters
                // Note: Any characters that are not in the arrays in the header file (eg. !, @,
                // #, $, %, etc.) cannot be used
            }
        }
        return secretMessage;
    };

    public String Decode(String secret) {// function to decode the message
        this.secretMessage = secret.toUpperCase();// making the message upper case
        // begin encoding message
        for (int i = 0; i < secret.length(); i++) {
            int index = -1;// get the charactor in the text array oto be oorrelated to the secret array
            char temp = this.secretMessage.charAt(i); // Get the character out of the string
            // Search the text array for the index of the character
            for (int j = 0; j < 37; j++) {
                if (scram[j].charAt(0) == temp) { // Compare every character in text to the temp character
                    index = j;
                }
            }
            if (index != -1) { // Make sure we have a valid character
                this.clearMessage += text[index]; // Convert the character to normal characters
            }
        }
        return clearMessage;
    };

    // accessors and mutators
    public String getClearMassage() {
        return this.clearMessage;
    };

    public String getSecretMessage() {
        return this.secretMessage;
    };

    public void setClearMessage(String msg) {
        this.clearMessage = msg; //
    };

    public void setSecretMessage(String sec) {
        this.secretMessage = sec;
    };

    // inner state for the message
    private String clearMessage = "";
    // inner state for the secret message
    private String secretMessage = "";
    // an array representing all of the alpha numeric charactors that can be
    // converted to secret charactors
    private String[] text = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " " };
    // Letters relating to the array above (will be used as a substitute cyper)
    private String[] scram = { "D", "U", "P", "1", "Q", "C", "I", "O", "5", "7", "Z", "6", "V", "8", "W", "H", "T", "L",
            "E", "0", "M", "J", "B", "4", "G", "9", "X", "N", "3", " ", "2", "R", "Y", "K", "S", "F", "A" };

    // the main function
    public static void main(String[] args) throws IOException
    {
        String message= "";     //Stores the crisis message to be encoded/decoded
        String result = "";     //Stores the result of encoding/decoding
        String encode = "";     //Stores the options asked to the user
        Converter converter;
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        InputStream is = null; //new input stream
        is = new FileInputStream(".");

        System.out.println("Would you like to Encode a Crisis Message (E) or Decode a scrambled Crisis Message (D)?");
        encode = br.readLine();

        if(encode.compareTo("E") < 0){
            //Encode the inputted crisis message
            System.out.println("Please enter the Crisis Message to encode:");
            is.skip(1); //Clears the new line character out of input buffer so we can enter a whole line
            message = br.readLine();
            //Encode
            result = converter.Encode(message); //Encode the crisis message using the Converter
            System.out.println("Entered Clear-text Crisis Message: ");
            System.out.println("Encoded Crisis Message: \n" + result +
                                "_________________________________");
        }
        else{
            //Decode a scrambled Crisis message into Clear-Text
            System.out.print( "Please enter Encoded Crisis Message to Decode:");
            is.skip(1); //Clears the new line character out of input buffer so we can enter a whole line
            // getline(std::cin, message);
            //Decode
            result = converter.Decode(message); //Decode the Crisis Message using Converter
            System.out.println("Entered Encoded Crisis Message: " + message);
            System.out.println("Decoded Crisis Message:\n" +
                                "_________________________________\n"
                                + result + '\n' + 
                                "_________________________________");
        }
        is.close();

    }
}