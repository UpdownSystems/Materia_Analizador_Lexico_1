package codigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java_cup.runtime.Symbol;

/**
 *
 * @author Dani Cuevas
 */
public class CLI {
    public static void analisisLexico(String s) {
            int cont = 1;
        
        Lexer lexer = new Lexer(new StringReader(s));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token;
            try {
                token = lexer.yylex();
                if (token == null) {
                    System.out.println(resultado);
                    return;
                }
                switch (token) {
                    case et:
                        cont++;
                        resultado += "LINEA " + cont + "\n";
                        break;
                    case ST:
                        resultado += "<ST>\t" + lexer.lexeme + "\n";
                        break;
                    case CL: resultado += "<CL>\t" + lexer.lexeme + "\n"; break;
                    case AL: resultado += "<AL>\t" + lexer.lexeme + "\n"; break;
                    case CH: resultado += "<CH>\t" + lexer.lexeme + "\n"; break;
                    case CPH: resultado += "<CPH>\t" + lexer.lexeme + "\n"; break;
                    case NW: resultado += "<NW>\t" + lexer.lexeme + "\n"; break;
                    case WP: resultado += "<WP>\t" + lexer.lexeme + "\n"; break;
                    case FT: resultado += "<FT>\t" + lexer.lexeme + "\n"; break;
                    case EN: resultado += "<EN>\t" + lexer.lexeme + "\n"; break;
                    case ep: resultado += "<ep>\t" + lexer.lexeme + "\n"; break;
                    case at: resultado += "<at>\t" + lexer.lexeme + "\n"; break;
                    case ms: resultado += "<ms>\t" + lexer.lexeme + "\n"; break;
                    case ptc: resultado += "<ptc>\t" + lexer.lexeme + "\n"; break;
                    case ig: resultado += "<ig>\t" + lexer.lexeme + "\n"; break;
                    case cm: resultado += "<cm>\t" + lexer.lexeme + "\n"; break;
                    case pj: resultado += "<pj>\t" + lexer.lexeme + "\n"; break;
                    case mai: resultado += "<mai>\t" + lexer.lexeme + "\n"; break;
                    case mei: resultado += "<mei>\t" + lexer.lexeme + "\n"; break;
                    case df: resultado += "<df>\t" + lexer.lexeme + "\n"; break;
                    case sw: resultado += "<sw>\t" + lexer.lexeme + "\n"; break;
                    case vl: resultado += "<vl>\t" + lexer.lexeme + "\n"; break;
                    case h: resultado += "<h>\t" + lexer.lexeme + "\n"; break;
                    case ph: resultado += "<ph>\t" + lexer.lexeme + "\n"; break;
                    case If: resultado += "<If>\t" + lexer.lexeme + "\n"; break;
                    case Else: resultado += "<Else>\t" + lexer.lexeme + "\n"; break;
                    case or: resultado += "<or>\t" + lexer.lexeme + "\n"; break;
                    case pa: resultado += "<pa>\t" + lexer.lexeme + "\n"; break;
                    case pc: resultado += "<pc>\t" + lexer.lexeme + "\n"; break;
                    case and: resultado += "<and>\t" + lexer.lexeme + "\n"; break;
                    case num: resultado += "<num>\t" + lexer.lexeme + "\n"; break;
                    case bi: resultado += "<bi>\t" + lexer.lexeme + "\n"; break;
                    case ERROR:
                        resultado += "  <Simbolo no definido>"+lexer.lexeme+"\n";
                        break;
                    default:
                        resultado += "  < " + lexer.lexeme + " >\n";
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void analisisSintactico(String s) {
        Sintax stx = new Sintax(new codigo.LexerCup(new StringReader(s)));
        try {
            stx.parse();
            System.out.println("Analisis realizado correctamente");
        } catch (Exception ex) {
            Symbol sym = stx.getS();
            System.out.println("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
        }
    }
    public static void main(String[] args) {
        //Lectura desde la consola                
        System.out.println("Introduzca codigo a validar: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String s = "";
        try {
            while ((line = br.readLine()) != null) {
                s += line + "\n";
                if ("END *ifsw=bi;".equals(line)) {
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        analisisLexico(s);
        analisisSintactico(s);
    }
}
