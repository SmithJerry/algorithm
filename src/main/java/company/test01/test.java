package company.test01;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Liang
 * @date 2023/8/18 - 14:27
 */
public class test {
//    public static void main(String[] args) {
////        int i = Integer.parseInt("1A");
////        System.out.println(i);
//
//        String str = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
//        String[] split = str.substring(0, str.length() - 2).split(";");
//        System.out.println(split);
////        str.isEmpty();
//        int[] nums = {1, 2, 3, 3};
//
//        System.out.println(nums.length);
//
//    }
    public static class SharedWalletInfo{
        private String wallet_type;

        public SharedWalletInfo(String wallet_type){
            this.wallet_type = wallet_type;
        }

        public String getWallet_type(){
            return this.wallet_type;
        }

    }
    public static void main(String[] args) {

        Set mainWalletIds1 = new HashSet<>();
        Map<Long, SharedWalletInfo> walletId2SharedWallet = new HashMap<>();
        walletId2SharedWallet.put(1L, new SharedWalletInfo("18"));
        walletId2SharedWallet.put(2L, new SharedWalletInfo("17"));
        walletId2SharedWallet.put(3L, new SharedWalletInfo("16"));
        walletId2SharedWallet.put(4L, new SharedWalletInfo("18"));
        for (Map.Entry<Long, SharedWalletInfo> entry : walletId2SharedWallet.entrySet()) {
            if (entry.getValue().getWallet_type().equals("18")) {
                mainWalletIds1.add(entry.getKey());
            }
        }

        System.out.println("-------------------");
        Set<Long> mainWalletIds = walletId2SharedWallet.entrySet().stream().filter(e -> e.getValue().getWallet_type().equals("18")).map(Map.Entry::getKey).collect(Collectors.toSet());

        System.out.println("312412414---");
        //    Scanner in = new Scanner(System.in);
    //    // 注意 hasNext 和 hasNextLine 的区别
    //    while (in.hasNextLine()) { // 注意 while 处理多个 case
    //        int n = Integer.parseInt(in.nextLine());
    //
    //        String[] strs = new String[n];
    //        for(int i = 0; i < n; i++){
    //            String str = in.nextLine();
    //            if(!isTrue(str)){
    //                continue;
    //            }
    //            strs[i] = str;
    //        }
    //
    //        for(int i = 0; i < strs.length; i++){
    //            System.out.println(strs[i]);
    //        }
//            String[] strs = new String[]{"124", "412312", "1412s"};
//            List<String> list =  new ArrayList<>();
//
//            for(int i = 0; i < strs.length; i++) {
//                list.add(strs[i]);
//            }
//            System.out.println(list.toString());
//
//            List<String> list2 = Arrays.asList(strs);
//
//            System.out.println(list2.toString());

    //    System.out.println(true || (true && false));


    }

    private static boolean isTrue(String str) {
        Pattern p = Pattern.compile("[^0-9MGT]");
        if(p.matcher(str).find()){
            System.out.println(str+": "+"xxxxx");
            return false;
        }
        if(str.startsWith("M")||str.startsWith("G")||str.startsWith("T")){
            System.out.println(str+": "+"xxxxx1");
            return false;
        }
        if(!str.endsWith("M")&&!str.endsWith("G")&&!str.endsWith("T")){
            System.out.println(str+": "+"xxxxx2");
            return false;
        }
        if(str.endsWith("0")||str.endsWith("1")||str.endsWith("2")){
            System.out.println(str+": "+"xxxxx3");
            return false;
        }
        return true;


//        Thread t = new Thread();
//        t.join();
    }


}
