package java_examples;


public class StringsExample {
    public static void main(String[] args) {
        String testString = new String("Это моя новая строка");
        System.out.println("testString = " + testString);

        System.out.println("\ntestString[4] вызовет ошибку!");
        System.out.println("\nСимвол строки по номеру символа можно получить так: <строка>.charAt(<номер>).\nНапример, четвертый символ testString: testString.charAt(4) // = " + testString.charAt(4));

        System.out.println("\n--------------------------------------------\n");

        System.out.println("Длину строки можно получить так: <строка>.length().\nНапример, длина строки testString: testString.length() // = " + testString.length());

        System.out.println("\n--------------------------------------------\n");

        System.out.println("Если мы будем сравнивать строки таким образом: testString == \"Это моя новая строка\", то результат будет: " + (testString == "Это моя новая строка"));
        System.out.println("Правильно сравнивать строки нужно с помощью <строка>.equals(): testString.equals(\"Это моя новая строка\"), результат: " + testString.equals("Это моя новая строка"));

        System.out.println("\n--------------------------------------------\n");

        System.out.println("Для того, чтобы прибавить к строке другую строку можно использовать <строка_1>.concat(<строка_2>)");
        System.out.println("Результат такого сложения обязательно нужно присвоить какой-нибудь переменной, например: <строка_1> = <строка_1>.concat(<строка_2>)");
        System.out.println("Пример: testString = testString.concat(\" с новыми символами\") // = " + testString.concat(" с новыми символами"));
        System.out.println("Это аналогично записи testString += \" с новыми символами\"");

        System.out.println("\n--------------------------------------------\n");

        System.out.println("Найти индекс символа 'о' с начала строки: testString.indexOf('о') = " + testString.indexOf('о'));
        System.out.println("Индекс символа 'о' с конца строки: testString.lastIndexOf('о') = " + testString.lastIndexOf('о'));
        System.out.println("Индекс несуществующего символа 's': testString.indexOf('s') = " + testString.indexOf('s'));

        System.out.println("\n--------------------------------------------\n");

        System.out.println("Для замены в строке одного символа на другой используйте testString.replace(<символ_который_заменяем>, <символ_которым_заменяем>)");
        System.out.println("Пример: заменим в строке testString пробел на перевод каретки");
        System.out.println("testString.replace(\" \", \"\\n\") \nРезультат:\n" + testString.replace(" ", "\n"));

    }
}
