public class VigenereLogic {

    // دالة لتجهيز النص: حذف الرموز وتوحيد الأحرف للكبيرة
    public static String prepareText(String text) {
        if (text == null) return "";
        // Regex: [^a-zA-Z] تعني أي شيء ليس حرفاً
        // نقوم بحذف الرموز ثم التحويل لأحرف كبيرة
        return text.replaceAll("[^a-zA-Z]", "").toUpperCase();
    }

    // دالة التشفير
    public static String encrypt(String message, String key) {
        String cleanMsg = prepareText(message);
        String cleanKey = prepareText(key);
        
        if (cleanMsg.isEmpty()) return "";

        StringBuilder encrypted = new StringBuilder();
        
        // تطبيق التشفير مع تكرار المفتاح دورياً
        for (int i = 0, j = 0; i < cleanMsg.length(); i++) {
            char p = cleanMsg.charAt(i); // الحرف الأصلي
            char k = cleanKey.charAt(j % cleanKey.length()); // حرف المفتاح (يتكرر)

            // المعادلة: C = (P + K) % 26
            // نطرح 'A' لنحول الحروف لأرقام من 0-25
            int val = ( (p - 'A') + (k - 'A') ) % 26;
            char c = (char)(val + 'A');
            
            encrypted.append(c);
            j++; // ننتقل لحرف المفتاح التالي
        }
        return encrypted.toString();
    }

    // دالة فك التشفير
    public static String decrypt(String encryptedMsg, String key) {
        // النص المشفر يأتي نظيفاً عادة، لكن نضمن ذلك
        String cleanMsg = prepareText(encryptedMsg);
        String cleanKey = prepareText(key);

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0, j = 0; i < cleanMsg.length(); i++) {
            char c = cleanMsg.charAt(i);
            char k = cleanKey.charAt(j % cleanKey.length());

            // المعادلة: P = (C - K + 26) % 26
            // نضيف 26 لضمان أن الناتج موجب قبل المودولو
            int val = ( (c - 'A') - (k - 'A') + 26 ) % 26;
            char p = (char)(val + 'A');

            decrypted.append(p);
            j++;
        }
        return decrypted.toString();
    }
}