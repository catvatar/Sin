import java.io.*;
import java.util.ArrayList;

class Vernam {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File input = new File("YOUR FILE FOR INPUT");
        File output = new File("YOUR FILE FOR OUTPUT");
        BufferedReader br1 = new BufferedReader(new FileReader(input));
        BufferedWriter or = new BufferedWriter(new FileWriter(output));
        System.out.println("Select 1 for Encryption, select 2 for Decryption: ");
        int choice = Integer.parseInt(br.readLine());

        if (choice == 1) {
            String str = br1.readLine();

            String key = keyString(str.length());
            System.out.println("Random Key generated is: " + key);
            ArrayList<String> pt = strToBinary(str);
            ArrayList<String> keyList = strToBinary(key);

            String ct = "", temp = "";
            StringBuffer sb = new StringBuffer(ct);
            for (int i = 0; i < pt.size(); i++) {
                temp = xoring(pt.get(i), keyList.get(i), pt.get(i).length());
                int decimal = Integer.parseInt(temp, 2);
                System.out.print(decimal + " ");
                sb.append((char) decimal);

            }
            System.out.println();
            or.write(sb.toString());
        } else {
            String str = br1.readLine();
            String key = br.readLine();

            ArrayList<String> pt = strToBinary(str);
            ArrayList<String> keyList = strToBinary(key);

            String ct = "", temp = "";
            StringBuffer sb = new StringBuffer(ct);
            for (int i = 0; i < pt.size(); i++) {
                temp = xoring(pt.get(i), keyList.get(i), pt.get(i).length());
                int decimal = Integer.parseInt(temp, 2);
                System.out.print(decimal + " ");
                sb.append((char) decimal);

            }
            System.out.println();
            or.write(sb.toString());
        }
        or.close();
    }

    static String keyString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    static ArrayList<String> strToBinary(String s) {
        int n = s.length();
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = Integer.valueOf(s.charAt(i));

            String bin = "";
            while (val > 0) {
                if (val % 2 == 1) {
                    bin += '1';
                } else
                    bin += '0';
                val /= 2;
            }
            bin = reverse(bin);
            al.add((bin));
            System.out.print(bin + " ");
        }
        System.out.println();
        return al;
    }

    static String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r = 0;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }

    static String xoring(String a, String b, int n) {
        String ans = "";

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    }
}
