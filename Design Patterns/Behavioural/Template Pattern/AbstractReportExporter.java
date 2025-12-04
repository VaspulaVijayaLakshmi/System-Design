package Behavioural.Template;

public abstract class AbstractReportExporter {

    protected void exportReport(){
        step1();
        step2();
        step3();
        step4();
    }

    protected void step1(){
        System.out.println("Exporting Report - Step 1: Gathering Data");
    }

    protected abstract void step2();

    protected  void step3(){
        System.out.println("Exporting Report - Step 3: Formatting Report");
    }

    protected abstract void step4();


}


