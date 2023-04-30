import java.util.Random;

public class Payment {

    public static void main(String[] args) {
        double[][][] payments = new double[20][10][2];
        for (int i = 0; i < payments.length; i++) {
            payments[i][0][0] = 400000 + (350000 / 19 * i);
            for (int j = 0; j < payments[i].length; j++) {

                payments[i][j][1] = netIncome(190000, .28, .03, payments[i][j][0], 30);
                double payment = ((12 * monthly(payments[i][0][0], .03, 30) - intrest(.03, payments[i][j][0])));
                double dummy = payments[i][j][0];
                payments[i][j][0] = dummy - payment;
                if (j != 9) {
                    payments[i][j + 1][0] = payments[i][j][0];
                }
            }

        }

        double[] total = totalIncome(payments);
        for (int i = 0; i < payments.length; i++) {
            double profit = .95 * appreciation(10, 100) * payments[i][0][0] - payments[i][9][0];
            System.out.println(
                    "Loan: " + (400000 + (350000 / 19 * i)) + " Profit: " + profit + " Total Net Income: " + total[i]
                            + " Total: " + (profit + total[i]));
        }

    }

    public static double netIncome(double salary, double tax, double rate, double loan, double years) {
        double monthly = monthly(loan, rate, years);
        double intrest = intrest(rate, loan);
        return salary - ((salary - intrest) * tax) - (monthly * 12);
    }

    public static double netIncome2(double salary, double tax, double rate, double loan, double years) {
        double intrest = 0;
        double monthly = monthly(loan, rate, years);
        return salary - ((salary - intrest) * tax) - (monthly * 12);
    }

    public static double intrest(double rate, double principal) {
        return rate * principal;
    }

    public static double monthly(double loan, double rate, double years) {
        return (loan * (rate / 12) * Math.pow(1 + (rate / 12), years * 12))
                / (Math.pow(1 + (rate / 12), years * 12) - 1);
    }

    public static double appreciation(double years, int time) {
        double prec = 1;
        Random rand = new Random();
        double total = 0;
        for (int j = 0; j < time; j++) {
            prec = 1;
            for (int i = 0; i < years; i++) {
                prec *= 1 + (rand.nextGaussian() * 5 + 2) * .01;
            }
            total = total + prec;

        }
        return total / time;
    }

    public static double[] totalIncome(double[][][] payments) {
        double[] total = new double[payments.length];
        for (int i = 0; i < payments.length; i++) {
            for (int j = 0; j < payments[i].length; j++) {
                total[i] += payments[i][j][1];
            }
        }
        return total;
    }
}