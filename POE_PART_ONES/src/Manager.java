
    public class Manager {

        private static int size = 100;

        private static String[] messageIds = new String[size];
        private static String[] recipients = new String[size];
        private static String[] messages = new String[size];
        private static String[] hashes = new String[size];

        private static int messageCount = 0;

        // Add a message
        public static void addMessage(String id, String recipient,
                                      String message, String hash) {

            if (messageCount < size) {
                messageIds[messageCount] = id;
                recipients[messageCount] = recipient;
                messages[messageCount] = message;
                hashes[messageCount] = hash;
                messageCount++;
            } else {
                System.out.println("Message storage is full.");
            }
        }

        // Display recipients
        public static void displayRecipients() {
            System.out.println("Recipients:");

            for (int i = 0; i < messageCount; i++) {
                System.out.println("Recipient: " + recipients[i]);
            }
        }

        // Display longest message
        public static void displayLongestMessage() {

            if (messageCount == 0) {
                System.out.println("No messages available.");
                return;
            }

            int maxIndex = 0;

            for (int i = 1; i < messageCount; i++) {
                if (messages[i].length() > messages[maxIndex].length()) {
                    maxIndex = i;
                }
            }

            System.out.println("Longest Message:");
            System.out.println(messages[maxIndex]);
        }

        // Search by message ID
        public static void searchByMessageId(String id) {

            for (int i = 0; i < messageCount; i++) {

                if (messageIds[i].equals(id)) {

                    System.out.println("Recipient: " + recipients[i]);
                    System.out.println("Message: " + messages[i]);
                    return;
                }
            }

            System.out.println("Message ID not found.");
        }

        // Search by recipient
        public static void searchMessagesByRecipient(String recipient) {

            boolean found = false;

            for (int i = 0; i < messageCount; i++) {

                if (recipients[i].equals(recipient)) {

                    System.out.println("Message: " + messages[i]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No messages found for recipient: " + recipient);
            }
        }

        // Delete message by hash
        public static void deleteMessageByHash(String hash) {

            for (int i = 0; i < messageCount; i++) {

                if (hashes[i].equals(hash)) {

                    System.out.println("Deleting message:");
                    System.out.println(messages[i]);

                    for (int j = i; j < messageCount - 1; j++) {
                        messageIds[j] = messageIds[j + 1];
                        recipients[j] = recipients[j + 1];
                        messages[j] = messages[j + 1];
                        hashes[j] = hashes[j + 1];
                    }

                    messageCount--;
                    return;
                }
            }

            System.out.println("Hash not found.");
        }

        // Full report
        public static void displayFullReport() {

            if (messageCount == 0) {
                System.out.println("No messages available.");
                return;
            }

            System.out.println(" Full message report.");

            for (int i = 0; i < messageCount; i++) {

                System.out.println("Message ID: " + messageIds[i]);
                System.out.println("Recipient: " + recipients[i]);
                System.out.println("Message: " + messages[i]);
                System.out.println("Hash: " + hashes[i]);

            }
        }
    }

