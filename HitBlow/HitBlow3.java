package kazuhiro.jinma;

import java.util.Scanner;

public class HitBlow3 {

	/**
	 * HitBlow
	 * 宿題
	 * @param args
	 */
	public static void main(String[] args) {

		int[] cpu = new int[4];
		cpu[0] = 1;
		cpu[1] = 2;
		cpu[2] = 8;
		cpu[3] = 9;

		//ユーザーはキーボードから入力させて、正解するまでループする
		int[] pc = new int[4];
		int hit;
		int blow;
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			//キーボードから数値を入力する
			num = sc.nextInt();

			//入力した数値を桁ごとに配列に分割する
			for (int i = 3; i >= 0; i--) {
				pc[i] = num % 10;
				num = num / 10;
			}

			/*
			 * １～９以外の数値が入力されたら再入力させる（数値以外の入力はないものとする）
			 */

			//HITチェック
			hit = 0; //なぜ初期化しないといけないか
			for (int i = 0; i < pc.length; i++) {
				if (cpu[i] == pc[i]) {
					hit++;
				}
			}
			System.out.print(hit + "HIT");
			//BLOWチェック
			blow = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i != j && cpu[i] == pc[j]) {
						blow++;
					}
				}
			}
			System.out.println(" " + blow + "BLOW");
		} while (hit != 4);

		/*
		 * 何回で正解したか回数も表示する
		 */

		System.out.println("正解!");
		sc.close();

	}

}
