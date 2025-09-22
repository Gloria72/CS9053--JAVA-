
public class Acronym {

	public String createAcronym(String input) {
        if (input == null || input.isEmpty()) return "";
        String[] words = input.trim().split("\\s+"); // 比 " " 更鲁棒
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) sb.append(Character.toUpperCase(w.charAt(0)));
        }
        return sb.toString();
	}
	public static void main(String[] args) {
		String s1 = "as soon as possible";
		String s2 = "The quick brown fox jumps over the lazy dog";
        Acronym a = new Acronym();
        System.out.println("s1 -> "+ a.createAcronym(s1));
        System.out.println("s2 -> "+ a.createAcronym(s2));
	}

}
