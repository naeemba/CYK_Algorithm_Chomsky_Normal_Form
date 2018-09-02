import java.util.List;

public class Main {

  /* You can change this part, but it should contains a list of strings with this template
     X=>YZ or X=>Y
     and you can also add statements as you want */
  private static List<String> statements = List.of(
      "S=>AB",
      "S=>BD",
      "S=>BE",
      "D=>AB",
      "A=>BA",
      "A=>a",
      "B=>aa",
      "B=>ED",
      "B=>DE",
      "B=>DD",
      "B=>b",
      "E=>a"
  );

  public static void main(String[] args) {
    CFG cfg = new CFG().addStatements(statements);
    /* You can change the word here */
    String word = "bbabaab";

    /* This part will return the result if it is true one or not */
    System.out.println("\n\n\n\n");
    System.out.println(CYKAlgorithm.run(cfg, word)? "Result is TRUE" : "Result is FALSE");
    System.out.println("\n\n\n\n");
  }
}
