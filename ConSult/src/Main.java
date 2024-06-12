public class Main {
    public static void main(String[] args) throws ParseException {
        AgendaExameController a = new AgendaExameController();
        List<Exame> exames = a.readExame();
        System.out.println(exames);
    }
}