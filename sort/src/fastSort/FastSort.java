package fastSort;

public class FastSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortArr = {23,45,66,34,12,11,5,90,67};
		
		int[] array = fastSort(sortArr);
		
		for(int i = 0; i < array.length; i ++){
			System.out.println(array[i] + ",");
		}

	}
	
	//排序函数
	public static int[] fastSort(int[] array){
		
		if(array.length == 2 && (array[0] > array[1])){
			array[0] += array[1];
			array[1] = array[0] - array[1];
			array[0] = array[0] - array[1];
		}else if(array.length > 2){
			int[] greatArray; 			//大于基准的数组
			int[] lowArray;				//小于基准的数组
			int greatNumber = 0;
			for(int i = 1; i < array.length; i ++){
				if(array[i] >= array[0]){
					greatNumber ++;
				}
			}
			//初始化两个数组
			greatArray = new int[greatNumber + 1];
			lowArray = new int[array.length - greatNumber - 1];
			
			//为数组赋值
			for(int i = 0; i < greatArray.length; i ++){		//大数
				for(int j = i; j < array.length ; j ++){
					if(array[j] >= array[0]){
						greatArray[i] = array[j];
					}
					break;
				}
				
				
			}
			
			for(int i = 0; i < lowArray.length; i ++){			//小数
				for(int j = 0; j < array.length ; i ++){
					if(array[j] < array[0]){
						lowArray[i] = array[j];
					}
				}
				
			}
			
			//递归
			greatArray = fastSort(greatArray);
			lowArray = fastSort(lowArray);
			
			for(int i = 0; i < greatArray.length ; i ++){
				array[i] = greatArray[i];
			}
			
			for(int i = 0; i < lowArray.length ; i ++){
				array[greatArray.length + i] = lowArray[i];
			}
		}
		
		return array;
	}

}
