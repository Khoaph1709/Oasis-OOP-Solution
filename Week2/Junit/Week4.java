public class Week4 {

    public static int max2Int(int a, int b) {
      return Math.max(a, b);
    }
  
    public static int minArray(int[] array) {
      int min = array[0];
      for (int num : array) {
        if (num < min) {
          min = num;
        }
      }
      return min;
    }
  
    public static String calculateBMI(double weight, double height) {
      double bmi = weight / (height * height);
      bmi = Math.round(bmi * 10.0) / 10.0;
      if (bmi < 18.5) {
        return "Thiếu cân";
      } else if (bmi <= 22.9) {
        return "Bình thường";
      } else if (bmi <= 24.9) {
        return "Thừa cân";
      } else {
        return "Béo phì";
      }
    }
  }