package catering;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.event.ServiceInfo;
import catering.businesslogic.kitchenTask.KitchenTaskException;
import catering.businesslogic.kitchenTask.SummarySheet;

// Test per l'estensione 1b.1) deleteSummarySheet
public class TestCatERing1b {
    public static void main(String[] args) {
        try {
            // Simulazione del login di un utente di nome "Lidia"
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            ServiceInfo ser = ServiceInfo.loadAllServiceInfo(6);
            SummarySheet sumSh = CatERing.getInstance().getKitchenTaskManager().createSummarySheet(ser);
            sumSh.printSumSh();
            System.out.println();
            System.out.println("AGGIUNTO SUMMARY SHEET CON ID: " + sumSh.getId());

            // 1b.1) deleteSummarySheet
            System.out.println("\nTEST DELETE SUMMARY SHEET");
            SummarySheet sumShDel = CatERing.getInstance().getKitchenTaskManager().deleteSummarySheet(sumSh);
            sumShDel.printSumSh();
            System.out.println();
            System.out.println("ELIMINATO SUMMARY SHEET CON ID: " + sumShDel.getId());

        } catch (UseCaseLogicException | KitchenTaskException e) {
            System.out.println("Errore di logica nello use case");
        }
    }
}
