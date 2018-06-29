
import java.util.regex.Pattern;

public class ValidadorEmail {

    /**
     * https://en.wikipedia.org/wiki/Email_address
     * https://www.regular-expressions.info/optional.html
     * */

    // ? == {0, 1}
    // (?:) case insentitive

    private static final String regex = "[a-zA-Z0-9._!#$%&'*+-/=?^`{|}~\"]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]+[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9]+)?";
    private static final Pattern pattern = Pattern.compile(regex);

    private static boolean validacao (String email) {
        return pattern.matcher(email).find();
    }

    public static void main(String[] args) {
        String [] emails = {
            "Johon.Smith@example-teste.com"
            ,"Johon_Smith@example.com"
            ,"Johon_Smith@example.br"
            ,"Johon_Smith@example.test"
            ,"Johon_Smith@example"
            ,"Johon_Smithexample"
            ,"\"()<>[]:,;@\\\\\\\"!#$%&'-/=?^_`{}| ~.a\"@example.org" // valido
            ,"example@s.example"
            ,"\"very.(),:;<>[]\\\".VERY.\\\"very@\\\\ \\\"very\\\".unusual\"@strange.example.com" // valido
            ,"example-indeed@strange-example.com"
            ,"test@teste"
            ,"#!$%&'*+-/=?^_`{}|~@example.org" // valido
        };
        for (String email : emails){
            System.out.printf("Email %s: Validacao: %s\n"
                    , email, validacao(email));
        }

    }

}
