package OA;

public class test {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int val = 999999998;
        int ans = ((val % MOD) * (val % MOD)) * MOD;
        System.out.println(ans );
    }
}
