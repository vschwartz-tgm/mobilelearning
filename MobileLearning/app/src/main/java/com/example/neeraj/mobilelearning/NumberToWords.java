package com.example.neeraj.mobilelearning;

import java.text.DecimalFormat;

/**
 * Die Klasse dient dazu die Zahlen in Wörter umzuwandeln.
 */
public class NumberToWords {

    private static final String[] zehnerNamen = { "", "zehn", "zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig",
            "siebzig", "achtzig", "neunzig" };

    private static final String[] numNamen = { "", "ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht",
            "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn",
            "neunzehn" };

    /**
     * In dieser Methode werden alle Zahlen, die <1000 sind, konvertiert.
     * @param number die Zahl, welche ungewandelt wird.
     * @return Zahl als Wort wird zurück gegeben.
     */
    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNamen[number % 100];
            number /= 100;
        } else if (number % 10 == 0) {
            soFar = numNamen[number % 10];
            number /= 10;

            soFar += zehnerNamen[number % 10];
            number /= 10;
        } else {
            soFar = numNamen[number % 10];
            number /= 10;

            soFar += "und" + zehnerNamen[number % 10];
            number /= 10;
        }

        if (number == 0)
            return soFar;

        String aa = "";
        if (number == 1) {
            aa += "hundert" + soFar;
        } else {
            aa += numNamen[number] + "hundert" + soFar;
        }
        return aa;
    }

    /***
     * Hier werden die restlichen Zahlen konvertiert.
     * @param number die umzuwandelne Zahl
     * @return Ergebinss als Wort
     */
    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "null";
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions) + "billion";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions) + "billion";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions) + "million";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions) + "million";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "eintausend";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands) + "tausend";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    /**
     * Einfache Test Methode und den Fortschritt zu messen.
     * testing
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("*** " + NumberToWords.convert(1));
    }
}