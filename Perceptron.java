/**
* Created by CimZzz on 12/2/17.
*
*/
public class Perceptron {
/**
* 學習率
*/
private final float learnRate;
/**
* 學習次數
*/
private final int studyCount;
/**
* 閾值
*/
private float e;
/**
* 權值
* 因為判斷整數正負只需要一條輸入，所以這裡只有一個權值，多條輸入可以設定為陣列
*/
private float w;
/**
* 每次學習的正確率
*/
private float[] correctRate;
//
/**
* 建構函式初始化學習率，學習次數，權值、閾值初始化為0
* @param learnRate 學習率（取值範圍 0 < learnRate < 1）
* @param studyCount 學習次數
*/
public Perceptron(float learnRate, int studyCount) {
this.learnRate = learnRate;
this.studyCount = studyCount;
this.e = 0;
this.w = 0;
this.correctRate = new float[studyCount];
}
/**
* 學習函式，samples 是一個包含輸入資料和分類結果的二維陣列，
* samples[][0] 表示輸入資料
* samples[][1] 表示正確的分類結果
* @param samples 訓練資料
*/
public void fit(int[][] samples) {
int sampleLength = samples.length;
for(int i = 0 ; i < studyCount ; i   ) {
int errorCount = 0;
for (int[] sample : samples) {
float update = learnRate * (sample[1]-predict(sample[0]));
//更新權值、閾值
w  = update * sample[0];
e  = update;
//計算錯誤次數
if (update != 0)
errorCount  ;
}
//計算此次學習的正確率
correctRate[i] = 1 - errorCount * 1.0f / sampleLength;
}
}
/**
* 求和函式，模擬求和結點操作 輸入資料 * 權值
* @param num 輸入資料
* @return 求和結果 z
*/
private float sum(int num) {
return num * w   e;
}
/**
* 啟用函式，通過求和結果 z 和閾值 e 進行判斷
* @param num 輸入資料
* @return 分類結果
*/
public int predict(int num) {
return sum(num) >= 0 ? 1 : -1;
}
/**
* 列印正確率
*/
public void printCorrectRate() {
for (int i = 0 ; i < studyCount ; i   )
System.out.printf("第%d次學習的正確率 -> %.2f%%\n",i   1,correctRate[i] * 100);
}
}

/**
* 生成訓練資料
* @return 訓練資料
*/
private static int[][] genStudyData() {
//這裡我們取 -100 ~ 100 之間的整數，大於0的設為模式 y = 1，反之為 y = -1
int[][] data = new int[201][2];
for(int i = -100 , j = 0; i <= 100 ; i    , j   ) {
data[j][0] = i;
data[j][1] = i >= 0 ? 1 : -1;
}
return data;
}
/**
* 生成訓練資料
* @return 訓練資料
*/
private static int[][] genStudyData2() {
//這裡我們取 1~250 之間的整數，大於125的設為模式 y = 1，反之為 y = -1
int[][] data = new int[250][2];
for(int i = 1 , j = 0; i <= 250 ; i    , j   ) {
data[j][0] = i;
data[j][1] = i >= 125 ? 1 : -1;
}
return data;
}
public static void main(String[] args) {
//這裡的學習率和訓練次數可以根據情況人為調整
Perceptron perceptron = new Perceptron(0.4f,500);
perceptron.fit(genStudyData());
perceptron.printCorrectRate();
System.out.println(perceptron.predict(-1));
System.out.println(perceptron.predict(126));
}
