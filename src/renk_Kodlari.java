public class renk_Kodlari {
    public static void main(String[] args) {
        String c_BLACK  = "\u001B[30m";
        String c_RED    = "\u001B[31m";
        String c_GREEN  = "\u001B[32m";
        String c_YELLOW = "\u001B[33m";
        String c_BLUE   = "\u001B[34m";
        String c_PURPLE = "\u001B[35m";
        String c_CYAN   = "\u001B[36m";
        String c_WHITE  = "\u001B[37m";
        String c_RESET  = "\u001B[0m";
        String BOLD     = "\033[0;1m";
        String ITALIC   = "\033[3m";
        String nITALIC   = "\033[0m";
        System.out.println("Bu Renk testi ");
        System.out.println(c_BLUE+"Bu Renk testi ");
        System.out.println(BOLD+"Bu Renk testi ");
        System.out.println(ITALIC+"Bu Renk testi ");
        System.out.println(c_RESET+"Bu Renk testi ");
        System.out.println(c_RED+"Bu Renk testi ");
        System.out.println(c_YELLOW+"Bu Renk testi ");
        System.out.println(nITALIC+"Bu Renk testi ");
        System.out.println(c_CYAN+"Bu Renk testi ");
        System.out.println(c_BLACK+ITALIC+"Bu Renk testi ");
        System.out.println(BOLD+ITALIC+c_RED+"Galata"+c_YELLOW+" Saray");





    }

}
