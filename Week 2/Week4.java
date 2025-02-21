public class Week4 {
    public static int max2Int(int a, int b) {
	// Tim gia tri lon nhat cua hai so nguyen
        return a > b ? a : b;
    }

    public static int minArray (int[] array) {
	// Tim gia tri nho nhat cua 1 mang so nguyen
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > min) {
                min = array[i];
            }
        }
        return min;
    }

    public static String calculateBMI(double weight, double height){
	// Tinh BMI
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            return "Thiếu cân";
        } else if (bmi >= 18.5 && bmi < 23) {
            return "Bình thường";
        } else if (bmi >= 23 && bmi < 24.99) {
            return "Thừa cân";
        } else {
            return "Béo phì";
        }
    }
}
 