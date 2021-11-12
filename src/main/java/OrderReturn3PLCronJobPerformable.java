public class OrderReturn3PLCronJobPerformable {
    public static void main(String[] args) {
        ExportReturnOrderClient exportReturnOrderClient = new ExportReturnOrderClient();
        try {
            if (exportReturnOrderClient.methodOne(-8)) {
                System.out.println("success");
            } else {
                System.out.println("failed");
            }
        } catch (Exception e) {
            System.out.println("вылетело эксепшен");
        }

    }

}
