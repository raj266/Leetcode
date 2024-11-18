class Solution {
    public int[] decrypt(int[] code, int k) {
  int n = code.length;
  int[] decryptedCode = new int[n];

  if (k == 0) {
    for (int i = 0; i < n; i++) {
      decryptedCode[i] = 0;
    }
    return decryptedCode;
  }

  if (k > 0) {
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 1; j <= k; j++) {
        sum += code[(i + j) % n];
      }
      decryptedCode[i] = sum;
    }
  } else {
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 1; j <= -k; j++) {
        sum += code[(i - j + n) % n];
      }
      decryptedCode[i] = sum;
    }
  }

  return decryptedCode;
}

public static void main(String[] args) {

  Solution sol = new Solution();
  int[] code = {
    5,
    7,
    1,
    4
  };
  int k = 3;
  int[] decryptedCode = sol.decrypt(code, k);
  for (int i = 0; i < decryptedCode.length; i++) {
    System.out.print(decryptedCode[i] + " ");
  }
}

}