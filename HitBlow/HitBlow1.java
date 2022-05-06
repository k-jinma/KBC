package kazuhiro.jinma;

public class HitBlow1 {

	/**
	 * HitBlow
	 * CPUとPCそれぞれの数値は固定で、HIT数とBLOW数のみ計算するプログラム
	 * @param args
	 */
	public static void main(String[] args) {
		//データの準備 ４桁の数値は扱いづらいため配列で各桁を管理する
		//int cpu = 1289;	//解答
		//int pc = 1295;	//プレイヤーの入力
		
		int[] cpu = new int[4];
		cpu[0] = 1;
		cpu[1] = 2;
		cpu[2] = 8;
		cpu[3] = 9;

		int[] pc = new int[4];
		pc[0] = 1;
		pc[1] = 2;
		pc[2] = 9;
		pc[3] = 5;

		//HITチェック
		int hit = 0;	//なぜ初期化しないといけないか
		for( int i = 0; i < pc.length; i++ ) {
			if( cpu[i] == pc[i] ) {
				hit++;
			}
		}
		System.out.print( hit +"HIT" );

		//BLOWチェック
		int blow = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i != j && cpu[i] == pc[j]) {
					blow++;
				}
			}
		}
		System.out.println(" " + blow + "BLOW");


	}

}
