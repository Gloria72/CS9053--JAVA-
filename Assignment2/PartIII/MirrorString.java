
public class MirrorString {

	public static String mirrorString(String input) {
        if (input == null) return null;
        String r = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            r += input.charAt(i); // 学生常用：直接 +=
        }
        return input + r;
	}
	public static void main(String[] args) {
		String input = "hello";
		System.out.println("mirror string of hello is " + mirrorString(input));

	}

}
