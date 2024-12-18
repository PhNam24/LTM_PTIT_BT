package WS;

import WS.vn.medianews.*;

import java.util.ArrayList;

public class WS_DataService {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();

        double input = Double.parseDouble(String.format("%.2f", port.getDataDouble("B21DCCN554", "J78JDbtS")));
        System.out.println(input);

        int tu = (int) (input * 100);
        int mau = 100;
        int ucln = gcd(tu, mau);
        tu /= ucln;
        mau /= ucln;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(tu);
        ans.add(mau);
        System.out.println(ans);

        port.submitDataIntArray("B21DCCN554", "J78JDbtS", ans);
    }
}
