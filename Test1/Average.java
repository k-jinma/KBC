import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("数学・国語・英語の点数を計算します");

		System.out.print("数学の点数　　：");
		int math = sc.nextInt();
		if( math > 100 || math < 0 ) {
			System.out.println("0～100の点数を入力してください");
			System.exit(1);
		}
		System.out.print("国語の点数　　：");
		int jap = sc.nextInt();
		if( jap > 100 || jap < 0 ) {
			System.out.println("0～100の点数を入力してください");
			System.exit(1);
		}
		System.out.print("英語の点数　　：");
		int eng = sc.nextInt();
		if( eng > 100 || eng < 0 ) {
			System.out.println("0～100の点数を入力してください");
			System.exit(1);
		}

		double avg =  (math + jap + eng) / 3;
		System.out.println("3教科の平均点：" + avg );

		sc.close();
	}

}
