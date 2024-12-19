package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class TCP_ByteStream {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String code = "B21DCCN554;AiO2KONK";
        os.write(code.getBytes());
        os.flush();

        byte[] buffer = new byte[1024];
        int byteRead = is.read(buffer);
        String response = new String(buffer, 0, byteRead);
        System.out.println(response);

        String[] arr = response.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for(String str: arr) {
            list.add(Integer.parseInt(str));
        }

        int n = list.size();
        int[] dp = new int[n];
        int[] previous = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(previous, -1);

        int maxLength = 1;
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    previous[i] = j;
                }
            }

            // Cập nhật thông tin dãy con dài nhất
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = lastIndex; i != -1; i = previous[i]) {
            lis.add(0, list.get(i));
        }

        String ans = "";
        for(int i = 0; i < lis.size(); i++) {
            if (i != lis.size() - 1) {
                ans += lis.get(i) + ",";
            } else {
                ans += lis.get(i) + ";";
            }
        }
        ans += lis.size();
        System.out.println(ans);
        os.write(ans.getBytes());
        os.flush();
    }
}
