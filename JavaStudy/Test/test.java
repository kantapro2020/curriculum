
public class Test{
  public static void main(final String[] args) {
    int[] data = { 3, 1, 53, 7, 5, 32, 4 };
      /*
      * 問2
      * 以下のfor文を完成させなさい
      */
      for (int i = 0; i < data.length; i++) {
        for (int j = data.length; i > j; j--){
          if (data[j-1] > data[j]){
            int box = data[j-1];
            data[j-1] = data[j];
            data[j] = box
          })
        }
      }
  }
}