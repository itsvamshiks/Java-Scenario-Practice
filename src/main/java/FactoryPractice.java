import org.junit.runners.Parameterized;

public class FactoryPractice {

    public static void main(String[] args) {
        String input = "DomesticPlan";
        PlanFactory planFactory = new PlanFactory();

        Plan plan = planFactory.getPlan(input);
        plan.getRate();
        plan.calculateBill(100);
    }
}

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan{
    public void getRate(){
        rate = 7.5;
    }
}

class CommercialPlan extends Plan{
    public void getRate(){
        rate = 8.5;
    }
}

class PlanFactory{
    public Plan getPlan(String type){
        if(type==null)
            return null;

        if(type.equalsIgnoreCase("DomesticPlan"))
            return new DomesticPlan();
        else if(type.equalsIgnoreCase("Commercial Plan"))
            return new CommercialPlan();

        return null;
    }
}