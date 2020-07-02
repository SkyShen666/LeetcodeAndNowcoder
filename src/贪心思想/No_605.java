package 贪心思想;

public class No_605 {
    public static void main(String[] args) {
        int[] flowerbed = {0,0,1,0,0};
        System.out.println(canPlaceFlowers(flowerbed,1));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i-1];
            int post = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
            //1、i是唯一一个元素，并且为0，即[0]
            //2、i前一个元素为0，后一个元素也为0，并且i本身为0，即[...,0,0,0,...]
            if (pre == 0 && post == 0){
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }



/*
    public static boolean canPlaceFlowers(int[] flowerbed,int n){
        int count = 0;
        if ( flowerbed.length == 0 || flowerbed == null){
            return false;
        }


        if ( flowerbed.length == 1 ){
            if(flowerbed[0] == 0){
                count = 1;
            }else {
                count = 0;
            }
            return judgement(count,n);
        }

        for(int i = 0; i < flowerbed.length; i++){
            if (i == 0){
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }else if (i == flowerbed.length-1){
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }else {
                if (flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return judgement(count,n);
    }

    public static boolean judgement(int count,int n){
        if (count >= n){
            return true;
        }else {
            return false;
        }
    }
*/

}
