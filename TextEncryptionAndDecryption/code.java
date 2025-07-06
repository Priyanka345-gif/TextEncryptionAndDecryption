package TextEncryptionAndDecryption;

import java.util.Scanner;

public class code {

    // Encryption method
    public static String encrypt(String text, int key1) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char c = (char)(((int)ch + key1 - 65) % 26 + 65);
                result.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char)(((int)ch + key1 - 97) % 26 + 97);
                result.append(c);
            } else {
                result.append(ch); // Keep space, punctuation etc.
            }
        }

        return result.toString();
    }

    // Decryption method
    public static String decrypt(String text, int key2) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char c = (char)(((int)ch - key2 - 65 + 26) % 26 + 65);
                result.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char)(((int)ch - key2 - 97 + 26) % 26 + 97);
                result.append(c);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String input = sc.nextLine();

        System.out.print("Enter encryption key: ");
        int encryptKey = sc.nextInt();

        System.out.print("Enter decryption key: ");
        int decryptKey = sc.nextInt();

        String encrypted = encrypt(input, encryptKey);
        String decrypted = decrypt(encrypted, decryptKey);

        System.out.println("\nEncrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}
