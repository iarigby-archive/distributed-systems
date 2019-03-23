class Main {
    public static void main(String[] args) {
            new Thread(() -> {
                try {
                    Server.main(null);
                } catch (Exception e) {}
            }).start();
            new Thread(() -> {
                try {
                    Client.main(null);
                } catch (Exception e) {}
            }).start();

            new Thread(() -> {
                try {
                    Client.main(null);
                } catch (Exception e) {}
            }).start();
    }}