import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    private static final String KEY = "MASTERKEY"; // يجب أن يطابق مفتاح الخادم

    public static void main(String[] args) {
        System.out.println(">>> Connexion au serveur...");

        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println(">>> Connexion réussie !");

            // أدوات القراءة والكتابة
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);

            while (true) {
                // قراءة الرسالة من المستخدم
                System.out.print("\nSaisissez votre message (Client): ");
                String msg = console.nextLine();

                if (msg.equalsIgnoreCase("exit")) break;

                // التشفير (سيطابق الشروط تلقائياً: حذف رموز، توحيد حالة)
                String encryptedMsg = VigenereLogic.encrypt(msg, KEY);
                System.out.println("[Envoi de messages chiffrés]: " + encryptedMsg);
                
                // الإرسال للخادم
                out.println(encryptedMsg);

                // انتظار الرد
                String response = in.readLine();
                if (response == null) break;
                
                System.out.println("[Récepteur chiffré du serveur]: " + response);
                String decryptedResponse = VigenereLogic.decrypt(response, KEY);
                System.out.println("[Après décryptage]: " + decryptedResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}