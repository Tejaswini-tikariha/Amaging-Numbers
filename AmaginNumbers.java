package Numbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AmaginNumbers {
    static boolean running = true;
    static long num, consecutive_Num, sum;
    static boolean[] isPropNum;
    static String[] Properties = { "EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD", "-EVEN", "-ODD", "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-SQUARE", "-SUNNY", "-JUMPING", "-HAPPY", "-SAD" };

    enum Num_Properties {
        ODD, EVEN, DUCK, BUZZ, GAPFUL, PALINDROMIC, SPY, SUNNY, SQUARE, JUMPING, HAPPY, SAD;
        
        public static void isMutuallyExclusive(String ...requested_Prop) {
            for (int i = 0; i < requested_Prop.length; i++) {
                requested_Prop[i] = requested_Prop[i].toUpperCase();
            }
            if (Arrays.asList(requested_Prop).contains("ODD") && Arrays.asList(requested_Prop).contains("EVEN")) {
                wrongProp.append("ODD EVEN ");
            }
            if (Arrays.asList(requested_Prop).contains("DUCK") && Arrays.asList(requested_Prop).contains("SPY")) {
                wrongProp.append("DUCK SPY ");
            } 
            if (Arrays.asList(requested_Prop).contains("SUNNY") && Arrays.asList(requested_Prop).contains("SQUARE")) {
                wrongProp.append( "SUNNY SQUARE ");
            } 
            if (Arrays.asList(requested_Prop).contains("HAPPY") && Arrays.asList(requested_Prop).contains("SAD")) {
                wrongProp.append( "HAPPY SAD ");
            } 
            if (Arrays.asList(requested_Prop).contains("ODD") && Arrays.asList(requested_Prop).contains("-ODD")) {
                wrongProp.append("ODD -ODD ");
            } 
            if (Arrays.asList(requested_Prop).contains("EVEN") && Arrays.asList(requested_Prop).contains("-EVEN")) {
                wrongProp.append("EVEN -EVEN ");
            } 
            if (Arrays.asList(requested_Prop).contains("HAPPY") && Arrays.asList(requested_Prop).contains("-HAPPY")) {
                wrongProp.append("HAPPY -HAPPY ");
            } 
            if (Arrays.asList(requested_Prop).contains("SAD") && Arrays.asList(requested_Prop).contains("-SAD")) {
                wrongProp.append("SAD -SAD ");
            }
            if (Arrays.asList(requested_Prop).contains("-ODD") && Arrays.asList(requested_Prop).contains("-EVEN")) {
                wrongProp.append("-ODD -EVEN ");
            }
            if (Arrays.asList(requested_Prop).contains("-HAPPY") && Arrays.asList(requested_Prop).contains("-SAD")) {
                wrongProp.append("-HAPPY -SAD ");
            }
            if (Arrays.asList(requested_Prop).contains("DUCK") && Arrays.asList(requested_Prop).contains("-DUCK")) {
                wrongProp.append("DUCK -DUCK ");
            }
            if (Arrays.asList(requested_Prop).contains("BUZZ") && Arrays.asList(requested_Prop).contains("-BUZZ")) {
                wrongProp.append("BUZZ -BUZZ ");
            }
            if (Arrays.asList(requested_Prop).contains("GAPFUL") && Arrays.asList(requested_Prop).contains("-GAPFUL")) {
                wrongProp.append("GAPFUL -GAPFUL ");
            }
            if (Arrays.asList(requested_Prop).contains("PALINDROMIC") && Arrays.asList(requested_Prop).contains("-PALINDROMIC")) {
                wrongProp.append("PALINDROMIC -PALINDROMIC ");
            }
            if (Arrays.asList(requested_Prop).contains("SPY") && Arrays.asList(requested_Prop).contains("-SPY")) {
                wrongProp.append("SPY -SPY ");
            }
            if (Arrays.asList(requested_Prop).contains("SUNNY") && Arrays.asList(requested_Prop).contains("-SUNNY")) {
                wrongProp.append("SUNNY -SUNNY ");
            }
            if (Arrays.asList(requested_Prop).contains("SQUARE") && Arrays.asList(requested_Prop).contains("-SQUARE")) {
                wrongProp.append("SQUARE -SQUARE ");
            }
        }

        public static boolean[] checkPropertyOf(long num, String... requested_Prop) {
            if (requested_Prop.length == 0) {
                requested_Prop = new String[12];
                for (int i = 0; i < requested_Prop.length; i++) {
                    requested_Prop[i] = Num_Properties.values()[i].toString();
                }
            }

            isPropNum = new boolean[requested_Prop.length];
            for (int i = 0; i < isPropNum.length; i++) {
                switch ((requested_Prop[i].toUpperCase())) {
                    case "ODD":
                        isPropNum[i] = isOddNum(num);
                        break;
                    case "EVEN":
                        isPropNum[i] = isEvenNum(num);
                        break;
                    case "DUCK":
                        isPropNum[i] = isDuckNum(String.valueOf(num));
                        break;
                    case "BUZZ":
                        isPropNum[i] = isBuzzNum(num);
                        break;
                    case "GAPFUL":
                        isPropNum[i] = isGapfulNum(num);
                        break;
                    case "PALINDROMIC":
                        isPropNum[i] = isPalindromicNum(String.valueOf(num));
                        break;
                    case "SPY":
                        isPropNum[i] = isSpyNum(num);
                        break;
                    case "SUNNY":
                        isPropNum[i] = isSunnyNum(num);
                        break;
                    case "SQUARE":
                        isPropNum[i] = isSquareNum(num);
                        break;
                    case "JUMPING":
                        isPropNum[i] = isJumpingNum(num);
                        break;
                    case "HAPPY":
                        isPropNum[i] = isHappySadNum(num);
                        break;
                    case "SAD":
                        isPropNum[i] = !isHappySadNum(num);
                        break;
                    case "-ODD":
                        isPropNum[i] = !isOddNum(num);
                        break;
                    case "-EVEN":
                        isPropNum[i] = !isEvenNum(num);
                        break;
                    case "-DUCK":
                        isPropNum[i] = !isDuckNum(String.valueOf(num));
                        break;
                    case "-BUZZ":
                        isPropNum[i] = !isBuzzNum(num);
                        break;
                    case "-GAPFUL":
                        isPropNum[i] = !isGapfulNum(num);
                        break;
                    case "-PALINDROMIC":
                        isPropNum[i] = !isPalindromicNum(String.valueOf(num));
                        break;
                    case "-SPY":
                        isPropNum[i] = !isSpyNum(num);
                        break;
                    case "-SUNNY":
                        isPropNum[i] = !isSunnyNum(num);
                        break;
                    case "-SQUARE":
                        isPropNum[i] = !isSquareNum(num);
                        break;
                    case "-JUMPING":
                        isPropNum[i] = !isJumpingNum(num);
                        break;
                    case "-HAPPY":
                        isPropNum[i] = !isHappySadNum(num);
                        break;
                    case "-SAD":
                        isPropNum[i] = isHappySadNum(num);
                        break;
                }
            }
            return isPropNum;
        }

        public static boolean isTrueForAllProperty(boolean[] isPropNum) {
            for (boolean b : isPropNum) { if(b == false) return false; }
            return true;
        }
    }

    public static void PropertyValues(long num) {
        String isOddEven = isEvenNum(num) ? "even" : "odd";
        String isBuzz = isBuzzNum(num) ? ", buzz" : "";
        String isDuck = isDuckNum(String.valueOf(num)) ? ", duck" : "";
        String isPal = isPalindromicNum(String.valueOf(num)) ? ", palindromic" : "";
        String isGap = isGapfulNum(num) ? ", gapful" : "";
        String isSpy = isSpyNum(num) ? ", spy" : "";
        String isSunny = isSunnyNum(num) ? ", sunny" : "";
        String isSquare = isSquareNum(num) ? ", square" : "";
        String isJumping = isJumpingNum(num) ? ", jumping" : "";
        String isHappySad = isHappySadNum(num) ? ", happy" : " sad";

        System.out.println("\t\t" + num + " is " + isOddEven + isBuzz + isDuck + isPal + isGap + isSpy + isSunny + isSquare + isJumping + isHappySad);
    }

    public static void Process_SingleRequest(long num) {
        System.out.println("\tProperties of " + num);
        Num_Properties[] prop = Num_Properties.values();
        for (int i = 0; i < prop.length; i++) {
            System.out.printf("\t%11s : %b\n", prop[i], isPropNum[i]);
        }
    }

    public static void recursion(long num) {
        sum = 0L;
        while (num > 0) {
            long numm = num / 10;
            sum += (long) Math.pow(num % 10, 2);
            num = numm;
        }
        if (sum == 4) {
            // nothing
        } else if (sum != 1 && sum != 0) {
            recursion(sum);
        }
    }

    public static boolean isHappySadNum(long num) {
        recursion(num);
        if (sum == 4) {
            return false;
        }
        return true;
    }

    public static boolean isJumpingNum(long num) {
        String[] split = String.valueOf(num).split("");
        for (int i = 0; i < split.length - 1; i++) {
            long n = Long.parseLong(split[i]);
            long nn = Long.parseLong(split[i + 1]);
            if (Math.abs(n - nn) != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSquareNum(long num) {
        double sqrt = Math.sqrt(num);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }

    public static boolean isSunnyNum(long num) {
        return isSquareNum(num + 1);
    }

    public static boolean isSpyNum(long num) {
        String txt = String.valueOf(num);
        long sum = 0;
        long prod = 1;
        for (int i = 0; i < txt.length(); i++) {
            sum += Character.getNumericValue(txt.charAt(i));
            prod *= Character.getNumericValue(txt.charAt(i));
        }
        return (sum == prod);
    }

    public static boolean isGapfulNum(long n1) {
        String transNum, edge;
        long end;
        transNum = String.valueOf(n1);
        end = transNum.length() - 1;
        if (transNum.length() >= 3) {
            edge = "" + transNum.charAt(0) + "" + transNum.charAt((int) (end));
            return n1 % Long.valueOf(edge) == 0;
        }
        return false;
    }

    public static boolean isPalindromicNum(String val) {
        StringBuilder sb = new StringBuilder(val).reverse();
        return (sb.toString().equals(val));
    }

    public static boolean isDuckNum(String val) {
        return (val.contains("0") && val.charAt(0) != '0');
    }

    public static boolean isBuzzNum(long num) {
        return (num % 7 == 0 || num % 10 == 7);
    }

    public static boolean isEvenNum(long num) {
        return (num % 2 == 0);
    }
    
    public static boolean isOddNum(long num) {
        return (num % 2 == 1);
    }
    
    static StringBuilder wrongProp = new StringBuilder();
    public static void isValidReqProperty(String ...requested_Properties) {
        for (String reqProp : requested_Properties) {
            if (!Arrays.asList(Properties).contains(reqProp.toUpperCase())) {
                wrongProp.append(reqProp + " ");
            }
        }       
    }
    
    public static void readRequest(String... list_of_req) {
        if (list_of_req.length == 1) {
            if (Pattern.compile("[0-9]+").matcher(list_of_req[0]).matches()) {
                num = Long.parseLong(list_of_req[0]);
                if (num == 0) {
                    System.out.println("\nGoodbye...");
                    running = false;
                } else {
                    Num_Properties.checkPropertyOf(num);
                    Process_SingleRequest(num);
                }
            } else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        } else if (list_of_req.length >= 2) {
            if (!Pattern.compile("[0-9]+").matcher(list_of_req[0]).matches()) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (!Pattern.compile("[0-9]+").matcher(list_of_req[1]).matches()) {
                System.out.println("The second parameter should be a natural number.");
            } else {
                num = Long.parseLong(list_of_req[0]);
                consecutive_Num = Long.parseLong(list_of_req[1]);
                if (list_of_req.length == 2) {
                    while (consecutive_Num > 0) {
                        PropertyValues(num);
                        consecutive_Num--;
                        num++;
                    }
                } else {
                    //Process Multiple requested properties
                    String[] requested_Properties = new String[list_of_req.length - 2];
                    for (int i = 0; i < requested_Properties.length; i++) {
                        requested_Properties[i] = list_of_req[i + 2];
                    }
                    wrongProp.setLength(0);
                    isValidReqProperty(requested_Properties);
                    if (wrongProp.length() == 0) {
                        Num_Properties.isMutuallyExclusive(requested_Properties);
                        if (wrongProp.length() == 0) {
                            while (consecutive_Num > 0) {
                                if (Num_Properties.isTrueForAllProperty(
                                        Num_Properties.checkPropertyOf(num, requested_Properties))) {
                                    PropertyValues(num);
                                    consecutive_Num--;
                                }
                                num++;
                            }
                        } else {
                            System.out.println("The request contains mutually exclusive properties: " + Arrays.toString(wrongProp.toString().split(" ")) + "\nThere are no numbers with these properties.");
                        }
                    } else {
                        if (wrongProp.toString().split(" ").length == 1)
                            System.out.println("The property " + Arrays.toString(wrongProp.toString().split(" ")) + " is wrong.\nAvailable properties: " + Arrays.toString(Num_Properties.values()));
                        else 
                           System.out.println("The properties " + Arrays.toString(wrongProp.toString().split(" ")) + " are wrong.\nAvailable properties: " + Arrays.toString(Num_Properties.values()));
                    }                                                    
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        StringBuilder greetings = new StringBuilder();
        greetings.append("Welcome to Amazing Numbers!\n\n").append("Supported requests:\n")
                .append("- enter a natural number to know its properties;\n")
                .append("- enter two natural numbers to obtain the properties of the list:\n")
                .append("  * the first parameter represents a starting number;\n")
                .append("  * the second parameter shows how many consecutive numbers are to be printed;\n")
                .append("- two natural numbers and a property to search for;\n")
                .append("- two natural numbers and properties to search for;\n")
                .append("- a property preceded by minus must not be present in numbers;")
                .append("- separate the parameters with one space\n").append("- enter 0 to exit.");
        System.out.println(greetings);
        while (running) {
            System.out.print("\nEnter a request: ");
            String request = sr.nextLine();
            String[] list_of_req = request.split(" ");
            System.out.println();
            readRequest(list_of_req);
        }
        sr.close();
    }
}
