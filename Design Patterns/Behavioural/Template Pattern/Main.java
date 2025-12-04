package Behavioural.Template;

public class Main {

    public static void main(String[] args) {


        AbstractReportExporter csvExporter = new CSVExportReport();
        csvExporter.exportReport();

        System.out.println();

        AbstractReportExporter excelExporter = new ExcelExportReporter();
        excelExporter.exportReport();
    }
}
