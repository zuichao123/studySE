
		 
		 var arr = [66, 85, 95, 555, 16]
		 
		 function getMax(arr){

		 	var max = 0;
		 	
		 	for(var x = 1; x<arr.length; x++){
		 		if(arr[x]>arr[max])
		 			max = x;
		 	}
		 	
		 	return arr[max];

		 }

		 
		 
		 var maxValue = getMax(arr);
		
		/*  alert(maxValue); */
		
		//排序
		function sortArray(arr){
			for(var x=0; x<arr.length-1; x++){
				for(var y=0+1; y<arr.length; y++){
					if(arr[x]>arr[y]){
						swap(arr, x, y);
					}
				}
			}
		}
		//数组中的元素位置置换
		function swap(arr, x, y){
			temp = arr[x];
			arr[x]=arr[y];
			arr[y]=temp;
		}
		//封装输出方法
		function println(val){
			document.write(val+"<br/>");
		}
		
		//document.write("排序前："+arr+"<br/>");
		println("排序前："+arr);
		//sortArray(arr);
		println("排序后："+arr);
		//document.write("排序后："+arr);
		


		
		//对数组查找。
		function searchElement(arr, key){
			for(var x =0; x<arr.length; x++){
				if(arr[x]==key){
					return x;
				}
			}
			return -1;
		}
		
		//折半
		function binarySearch(arr, key){
			
			var max, min, mid;
			min = 0;
			max = arr.length-1;
			
			while(min<=max){
				mid = (max+min)>>1;
				
				if(key>arr[mid]){
					min = mid+1;
				}else if(key<arr[mid])
					max = mid - 1;
				else 
					return mid;
			}
			return -1;
			
		}

		//对数组的反转
		function reverseArray(arr){
			for(var start=0,end=arr.length-1;start<end;start++,end--){
				swap(arr, start, end);
			}
		}
		
		reverseArray(arr);
		println("反转后："+arr);