package Behavioural.Template;

public class ExcelExportReporter extends AbstractReportExporter{

    @Override
    protected void step2(){
        System.out.println("Exporting Report - Step 2: Saving Excel File");
    }

    @Override
    protected void step4(){
        System.out.println("Exporting Report - Step 4: Converting Data to Excel Format");
    }
}
