package collection.demo7;

import java.util.List;

/**
 * @Author: melody
 * @Date: 2020-05-14
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(
            10,5000,100,500,100,5000,10000
    );
    protected C initialize(int size){
        return container;
    }
    protected C container;
    private String headline = "";
    private List<Test<C>> tests;
    private static String stringField(){
        return "%" + fieldWidth + "s";
    }
    private static String numberField(){
        return "%" + fieldWidth + "d";
    }
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramsList = defaultParams;
    public Tester(C container,List<Test<C>> tests){
        this.container = container;
        this.tests = tests;
        if (container != null){
            headline = container.getClass().getSimpleName();
        }
    }
    public Tester(C container,List<Test<C>> tests,TestParam[] paramsList){
        this(container,tests);
        this.paramsList = paramsList;
    }
    public void setHeadline(String newHeadline){
        headline = newHeadline;
    }
    public static <C> void run(C cntnr,List<Test<C>> tests){
        new Tester<C>(cntnr,tests).timedTest();
    }
    public static <C> void run(C cntnr,List<Test<C>> tests,TestParam[] paramsList){
        new Tester<C>(cntnr,tests,paramsList).timedTest();
    }
    private void displayHeader(){
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);

        System.out.format(sizeField,"size");
        for (Test<C> test : tests) {
            System.out.format(stringField(),test.name);
        }
        System.out.println();
    }
    private void timedTest() {
        displayHeader();
        for (TestParam param : paramsList) {
            System.out.format(sizeField,param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                // call the override method
                int reps = test.test(kontainer,param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(),timePerRep);
            }
            System.out.println();
        }
    }
}
