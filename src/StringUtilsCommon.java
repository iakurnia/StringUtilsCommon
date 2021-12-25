import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class StringUtilsCommon {

    // #1. check hasValue parameter String
    public static boolean hasValue(String param1) {
        return param1 != null && !ConstansValue.EMPTY_STRING.equals(param1.trim());
    }

    // #2. check hasValue parameter Object
    public static boolean hasValue(Object param1) {
        return param1 != null && hasValue(param1.toString());
    }

    // #3. If value is null will convert to Empty String
    public static String convertNullToString(String param1) {
        return param1 == null ? ConstansValue.EMPTY_STRING : param1;
    }

    // #4.
    public static String upperCaseFirstCharacter(String param1) {
        return hasValue(param1) ? param1.substring(0, 1).toUpperCase() + param1.substring(1) : param1;
    }

    public static String lowerCaseFirstCharacter(String param1) {
        return hasValue(param1) ? param1.substring(0, 1).toLowerCase() + param1.substring(1) : param1;
    }

    public static String prePad(String param1, char param2, int param3) {
        if (param3 < param1.length()) {
            return param1;
        } else {
            int var1 = param3 - param1.length();
            StringBuilder var2 = new StringBuilder();

            for (int var3 = 0; var3 < var1; ++var3) {
                var2.append(param2);
            }

            var2.append(param1);
            return var2.toString();
        }
    }

    public static String postPad(String param1, char param2, int param3) {
        if (param3 < param1.length()) {
            return param1;
        } else {
            int var1 = param3 - param1.length();
            StringBuilder var2 = new StringBuilder();
            var2.append(param1);
            for (int var3 = 0; var3 < var1; ++var3) {
                var2.append(param2);
            }
            return var2.toString();
        }
    }

    public static List<String> chopString(String param1) {
        ArrayList var1 = null;
        if (hasValue(param1)) {
            var1 = new ArrayList();
            int var2;
            for (var2 = 0; param1.length() - var2 > ConstansValue.SIZE_CHOP; var2 += ConstansValue.SIZE_CHOP) {
                String var3 = param1.substring(var2, var2 + ConstansValue.SIZE_CHOP);
                var1.add(var3);
            }
            var1.add(param1.substring(var2));
        }
        return var1;
    }

    public static List<String> chopByte(byte[] param1) {
        ArrayList var1 = null;
        if (hasValue(param1) && param1.length > 0) {
            var1 = new ArrayList();
            byte[] var2;
            int var3;
            for (var3 = 0; param1.length - var3 > ConstansValue.SIZE_CHOP; var3 += ConstansValue.SIZE_CHOP) {
                var2 = new byte[ConstansValue.SIZE_CHOP];
                System.arraycopy(param1, var3, var2, ConstansValue.ZERO, ConstansValue.SIZE_CHOP);
                var1.add(var2);
            }
            var2 = new byte[param1.length - var3];
            System.arraycopy(param1, var3, var2, ConstansValue.ZERO, param1.length - var3);
            var1.add(var2);
        }
        return var1;
    }

    public static String glueString(List<String> param0) {
        StringBuilder var1 = new StringBuilder();
        if (hasValue(param0)) {
            Iterator var2 = param0.iterator();

            while (var2.hasNext()) {
                String var3 = (String) var2.next();
                var1.append(var3);
            }
        }
        return var1.toString();
    }

    public static byte[] glueByte(List<byte[]> param0) {
        byte[] var1 = null;
        if (hasValue(param0)) {
            Iterator var4 = param0.iterator();

            while (var4.hasNext()) {
                byte[] var5 = (byte[]) var4.next();
                if (var1 == null) {
                    var1 = var5;
                } else {
                    byte[] var3 = var1;
                    var1 = new byte[var1.length + var5.length];
                    System.arraycopy(var3, 0, var1, 0, var3.length);
                    System.arraycopy(var5, 0, var1, var3.length, var5.length);
                }
            }
        }
        return var1;
    }

    public static String generate() {
        // generate random
        return UUID.randomUUID().toString();
    }

    public static String appendWildcard(Object var0) {
        // Usualy User Query parameter
        return hasValue(var0) ? ConstansValue.WILDCARD + var0.toString() + ConstansValue.WILDCARD : ConstansValue.WILDCARD;
    }

    public static String escapeUnderscore(String var0) {
        return hasValue(var0) ? var0.replace("_", "!_") : "";
    }

    public static String formatDecimal(BigDecimal param0) {
        DecimalFormat var1 = new DecimalFormat("###,###,##0.00");
        return var1.format(param0);
    }

}
