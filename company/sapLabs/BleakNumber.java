import java.util.*;

class BleakNumber {
	public static boolean isBleak(int n) {
		if (n < 0) return false;
		for (int off = 1; off <= 32 && n - off > 1; off++) {
			if (Integer.bitCount(n - off) + n - off == n) return false;
		}
		return true;
	}
}
