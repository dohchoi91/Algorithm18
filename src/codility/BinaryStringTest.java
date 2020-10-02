package codility;

public class BinaryStringTest {
	
    public int solution(int N) {
        String str = Integer.toBinaryString(N);
        char[] toChars = str.toCharArray();
        
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < toChars.length; i++) {
			if (toChars[i] == '0') {
				count++;
			} else {
				if (max < count ) {
					max = count;
				}
				count = 0;
			}
		}
		return  max;
    }
	public static void main(String[] args) {
        String str = Integer.toBinaryString(9);
        char[] toChars = str.toCharArray();
        
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < toChars.length; i++) {
			if (toChars[i] == '0') {
				count++;
			} else {
				if (max < count ) {
					max = count;
				}
				count = 0;
			}
		}
        
	}

}
