package CarTycoonCalc;

public class calculatorCarTycoon {

    //Процентная разница = (V2 - V1) / V1 × 100, где V1 — это старое (исходное) значение, V2 — новое (конечное) значение.
//    static double persent(double v2, double v1){
//        double percent = (v2 - v1) / v1 * 100;
//        System.out.println(percent);
//        return percent;
//    }
    public static void main(String[] args) {
//        double v1 = 13.8;
//        double v2 = 14.8;
//        double persent = persent(v2, v1);

        double startValue = 12d;
        int stepsTool = 39;

        double maxValueToCar = 10000d;
        double oneStepToCar = 24d;
        int allStepsToCar = 0;

        double persent = 7.24;

        double sumTool = 0;
        double sumCar = 0;

        for (int i = 0; i < stepsTool; i++) {
            sumTool += startValue + (startValue * persent / 100);
        }


        while (sumCar <= maxValueToCar) {
            allStepsToCar++;
            sumCar += oneStepToCar;
        }

        sumCar = sumTool / oneStepToCar;

        System.out.printf("\nДля прокачки станка потребуется примерно %.1f единиц" +
                " и %.1f входов через 2 часа\n", sumTool, sumCar);
        System.out.printf("\nДля накопления потребуется примерно %d входов через 2 часа", allStepsToCar);


    }
}
