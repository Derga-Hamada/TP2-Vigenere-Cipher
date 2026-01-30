import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server { // تأكد أن اسم الكلاس Server
    private static final int PORT = 5000;
    private static final String KEY = "MASTERKEY"; 

    // هذه هي الدالة التي يخبرك الخطأ أنها مفقودة
    public static void main(String[] args) {
        System.out.println(">>> Le serveur est en cours d'exécution...");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println(">>> Le serveur attend une connexion sur le port" + PORT);

            Socket socket = serverSocket.accept(); 
            System.out.println(">>> Le client a été contacté !");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner console = new Scanner(System.in);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("\n[Récepteur crypté]: " + inputLine);
                
                String original = VigenereLogic.decrypt(inputLine, KEY);
                System.out.println("[Après décryptage]: " + original);

                System.out.print("Saisissez votre réponse (Server): ");
                String reply = console.nextLine();
                
                String encryptedReply = VigenereLogic.encrypt(reply, KEY);
                out.println(encryptedReply);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}