package StringVersusStringBuilder;

public class StringBuilderExample {

	public static void main(String[] args) {

		System.out.println("start genWithString");
		long timeStart = System.currentTimeMillis();
		String s1 = genWithString();
		long timeSpend = (System.currentTimeMillis() - timeStart);
		System.out.println("end genWithString. Time:" + timeSpend+" Milliseconds");

		System.out.println("start genWithStringBuilder");
		timeStart = System.currentTimeMillis();
		String s2 = genWithStringBuilder();
		timeSpend = (System.currentTimeMillis() - timeStart);
		System.out.println("end genWithStringBuilder. Time:" + timeSpend+" Milliseconds");
		
		System.out.println("s1.equals(s2)="+s1.equals(s2));
	}

	private static String genWithStringBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sb.append("x");
		}
		return sb.toString();
	}

	private static String genWithString() {
		String s = "";
		for (int i = 0; i < 100000; i++) {
			s = s + "x";
		}
		return s;
	}
}
