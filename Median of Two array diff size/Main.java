import java.util.ArrayList;

class Main{
    
    public static void main(String[] args) {
     
    }
}


















// double result = 0;
//         int m1 = -1, m2 = -1;
//         int total = nums1.length + nums2.length;
//         if( total %2 ==0 ){
//             int i = 0;
//             int j = 0;
            
//             for(int c = 0; c < total/2 +1; c++){
//                 if(i< nums1.length && nums1[i] <= nums2[j]){
//                     m1 = m2; 
//                     m2 = nums1[i];
//                     i++;
//                 } else if(j < nums2.length){
//                     m1 = m2;
//                     m2 = nums2[j];
//                     j++;
                    
//                 } else if( i >= nums1.length){
//                     m1 = m2;
//                     m2 = nums2[j];
//                     j++;
//                 } else{
//                     m1 = m2;
//                     m2 = nums1[i];
//                     i++;
//                 }
                
//                 // System.out.println(m1 + " " + m2);
//             }
//             result = m1+m2;
//         } else{
//             int i = 0;
//             int j = 0;
//             for(int c = 0; c < (total +1)/2 ; c++){
//                 if(i < nums1.length && nums1[i] <= nums2[j]){
//                     m2 = nums1[i];
//                     i++;
//                 } else if(j < nums2.length){
//                     m2 = nums2[j];
//                     j++;
                    
//                 } else if( i >= nums1.length){
//                     m2 = nums2[j];
//                     j++;
//                 } else{
//                     m2 = nums1[i];
//                     i++;
//                 }
//                 // System.out.println(m1 + " " + m2);
                
//             }
//             result = 2*m2;
//         }
        
//         return result/2;