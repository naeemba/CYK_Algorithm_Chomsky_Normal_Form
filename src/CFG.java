import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class CFG {
  private List<CFGPart> parts;

  CFG() {
    this.parts = new ArrayList<>();
  }

  CFG addStatements(List<String> statements) {
    this.parts.addAll(statements.stream().map(each -> {
      String[] parts = each.split("=>");
      return new CFGPart(parts[0], parts[1]);
    }).collect(Collectors.toList()));

    return this;
  }

  Set<String> findParts(String requestedItem) {
    Set<String> strings = new HashSet<>();
    for(CFGPart part: parts) {
      if (part.getTo().equals(requestedItem))
        strings.add(part.getFrom());
    }
    return strings;
  }
}