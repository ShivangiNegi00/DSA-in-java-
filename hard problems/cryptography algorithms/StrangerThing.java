import java.util.ArrayList;
import java.util.Base64;

public class StrangerThing {
    
    // Define the custom alphabet
    private static final char[] ALPHABET = {
        'I', 'c', 'x', 'N', '1', 'S', 'P', 'R', 'p', 'w', 'j', 'D', 'k', '2', 'O', 'b',
        '{', 'i', 'U', 'C', 'z', 't', 'H', 'm', 'G', 'J', 'B', 'V', 'e', 'M', 'A', 'E',
        'f', 'n', 'u', 'o', 'v', '9', 'g', '}', 'Z', 'F', 'T', 'X', 'r', '7', '4', 'd',
        's', 'y', '6', 'l', 'Y', 'q', 'a', 'L', 'K', 'Q', '5', 'W', '8', 'h', '3', '0'
    };

    // Map characters back to their index in the alphabet
    private static int indexOfChar(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                return i;
            }
        }
        throw new IllegalArgumentException("Character not in alphabet: " + c);
    }

    // Decrypt the string
    public static String decrypt(String encodedString) {
        // Step 1: Decode the Base64 string
        byte[] base64Decoded = Base64.getDecoder().decode(encodedString);
        StringBuilder binaryString = new StringBuilder();

        // Step 2: Convert bytes to binary and concatenate
        for (byte b : base64Decoded) {
            String binary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            binaryString.append(binary);
        }

        // Step 3: Break binary string into 5-bit chunks
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < binaryString.length(); i += 5) {
            int end = Math.min(i + 5, binaryString.length());
            String chunk = binaryString.substring(i, end);
            int index = Integer.parseInt(chunk, 2); // Convert 5-bit binary to decimal
            indices.add(index);
        }

        // Step 4: Map decimal indices to characters in the custom alphabet
        StringBuilder decodedString = new StringBuilder();
        for (int index : indices) {
            if (index >= ALPHABET.length) {
                throw new IllegalArgumentException("Index out of bounds for alphabet: " + index);
            }
            decodedString.append(ALPHABET[index]);
        }

        // Validate if the output matches expected format
        String result = decodedString.toString();
        if (!result.startsWith("HQ9FLAG{") || !result.endsWith("}")) {
            throw new IllegalArgumentException("Decrypted string does not match expected format: HQ9FLAG{...}");
        }

        return result;
    }

    public static void main(String[] args) {
        // Example encoded string (ensure this decodes to HQ9FLAG{...})
        String encodedString = "Cw4MFQABGw8dHBsFEhsdGhsNAgkMAB8OEhgGGgsAFxMcFw0AGQsJHBocFxgGCAIPFwEGGhsH";

        // Decrypt and print the result
        try {
            String result = decrypt(encodedString);
            System.out.println("Decrypted string: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
