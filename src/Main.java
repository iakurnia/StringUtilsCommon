import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("====== Testing Various Utils Common ======");

        // #1. check hasValue parameter String
        System.out.println(StringUtilsCommon.hasValue("NotEmpty Ia Kurnia"));

        // #2. check hasValue parameter Object
        Object obj = null;
        System.out.println(StringUtilsCommon.hasValue(obj));

        // #3 If value is null will convert to Empty String
        System.out.println(StringUtilsCommon.convertNullToString(null));

        // #4. Value Firt Character be Upper Case
        System.out.println(StringUtilsCommon.upperCaseFirstCharacter("iakurnia"));

        // #5. Value Firt Character be Lower Case
        System.out.println(StringUtilsCommon.lowerCaseFirstCharacter("IAKURNIA"));

        // #6. Pre Pad Value Customize value with parameter character
        System.out.println(StringUtilsCommon.prePad("123456", '0', 12));

        // #7. post Pad Value Customize value with parameter character
        System.out.println(StringUtilsCommon.postPad("123456", '0', 12));

        // #8. chop String value in list in according with what yout want in parameter type String
        String param = "A developer is the key individual behind all software applications. Generally, developers are well versed in at least one programming language and proficient in the art of structuring and developing software code for software or a program. Depending on job role and type of software developed, a developer may be classified as a software developer, application developer, mobile developer, Web developer, etc.Although the primary job role is writing code, a developer also may gather requirements for software, design or overall software architecture, software documentation and other related software development processes.";
        System.out.println(StringUtilsCommon.chopString(param));

        // #9. chop String value in list in according with what yout want in parameter type Byte
        byte[] paramByte = param.getBytes();
        System.out.println(StringUtilsCommon.chopByte(paramByte));

        // #10. glue String in parameter type list
        List<String> array = new ArrayList();
        array.add("My");
        array.add("Name");
        array.add("Ia");
        array.add("Kurnia");
        array.add("I'am");
        array.add("Software");
        array.add("Enginer");
        System.out.println(StringUtilsCommon.glueString(array));

        // #11. glue String in parameter type byte
        List<byte[]> arrayB = new ArrayList();
        arrayB.add("My".getBytes());
        arrayB.add("Name".getBytes());
        arrayB.add("Ia".getBytes());
        arrayB.add("Kurnia".getBytes());
        arrayB.add("I'am".getBytes());
        arrayB.add("Software".getBytes());
        arrayB.add("Enginer".getBytes());
        System.out.println(StringUtilsCommon.glueByte(arrayB));

        // #12. generate random String
        System.out.println(StringUtilsCommon.generate());

        // #13. If hasvalue, that value append Wildcard
        System.out.println(StringUtilsCommon.appendWildcard("Ia Kurnia"));

        // #14. If value contain underscore, that value relapce with !_
        System.out.println(StringUtilsCommon.escapeUnderscore("ia_kurnia"));

        // #15. Format Decimal Standarization__
        System.out.println(StringUtilsCommon.formatDecimal(new BigDecimal(123456789)));
    }
}
