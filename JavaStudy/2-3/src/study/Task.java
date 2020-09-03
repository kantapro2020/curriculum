package study;
// ① TaskクラスにCalculatorクラスを継承させなさい。
    /**
     * タスクの実行
     */
	public class Task extends Calculator {
    public void doTask() {
        // ② Calculator.javaのすべてのオーバーロードメソッド「plus」に適当な引数を与え、下記画像のよう出力されるようコーディングしなさい。
        // 尚、「どのクラスから呼び出しているか」を明確にするため、plus()には呼び出し元のキーワードを付与すること。
    	int a = plus(10);
    	System.out.println("plusメソッドの引数が一つの場合：" + a);
    	int b = plus(10, 20);
    	System.out.println("plusメソッドの引数が一つの場合：" + b);
    	int c = plus(10, 20, 30);
    	System.out.println("plusメソッドの引数が一つの場合：" + c);
    }
}