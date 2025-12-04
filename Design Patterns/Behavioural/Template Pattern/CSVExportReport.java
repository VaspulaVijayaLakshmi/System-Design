package Behavioural.Template;

public class CSVExportReport extends AbstractReportExporter{

    @Override
    protected void step2() {
        System.out.println("Exporting Report - Step 2: Converting Data to CSV Format");
    }

    @Override
    protected void step4() {
        System.out.println("Exporting Report - Step 4: Saving CSV File");
    }
}
