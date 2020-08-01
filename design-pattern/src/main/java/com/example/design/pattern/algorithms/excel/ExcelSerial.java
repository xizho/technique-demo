package com.example.design.pattern.algorithms.excel;

/**
 * excel列名和列数间的转化
 */
public class ExcelSerial {
    public static void main(String[] args) {
        String colName = "aaa";
        int colSerial = getSerial(colName);
        System.out.printf("列名%s对应的列数是%s\n", colName, colSerial);
        System.out.println("/**********************************/");

        colName = getColumnName(colSerial);
        System.out.printf("列数%s对应的列名是%s\n", colSerial, colName);
    }


    /**
     * TODO 未完成
     * 根据列数得到列名
     */
    static String getColumnName(int num) {
        return getColumnName(num, new StringBuilder());
    }

    static String getColumnName(int num, StringBuilder sb) {
        if (num < 1) return null;

        int len = ALPHABET.length();
        if (num <= len) {
            return ALPHABET.charAt(num - 1) + "";
        } else {
            while (num > 0) {
                int res = num % 26;

                if (res == 0) {
                    // TODO 这部分逻辑有问题
                    res = 26;
                    sb.append(ALPHABET.charAt(res - 1));
                    num = num / 26;
                    if (num > 1 && num <= 26) {
                        sb.append(ALPHABET.charAt(num - 2));
                        break;
                    } else {
                        getColumnName(num, sb);
                    }
                } else {
                    sb.append(ALPHABET.charAt(res - 1));
                    num = num / 26;
                }
            }

            return sb.reverse().toString();
        }
    }

    /**
     * 根据列名得到列数
     */
    static int getSerial(String colName) {
        if (colName == null || "".equals(colName)) return -1;

        colName = colName.toUpperCase();

        for (int i = 0, length = colName.length(); i < length; i++)
            if (ALPHABET.indexOf(colName.charAt(i)) < 0)
                return -1;

        // TODO 26进制算法，参考2/8/10/16进制转化编写
        // 举例说明：A~Z，对应的是1~26，AA代表27，其算法是，A*26^1+A*26^0
        int length = colName.length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            int colNum = ALPHABET.indexOf(colName.charAt(i)) + 1;
            int power = length - 1 - i;
            result += colNum * Math.pow(26, Double.parseDouble(String.valueOf(power)));
        }

        return result;
    }

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

}
