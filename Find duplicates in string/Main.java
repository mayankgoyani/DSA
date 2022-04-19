class Main {

    public static void printDups(String s){
        int[] counts = new int[256];
        int max = 0;

        for(int i=0; i < s.length(); i++){
            counts[s.charAt(i)]++;
        }

        for(int i=0; i < counts.length; i++){
            if(counts[i]> 1){
                System.out.println("Character: " + (char)i + " : " + counts[i]);
            }

            if(max < counts[i]){
                max = i;
            }

        }
        System.out.println("maximum repeating character: " + (char)max);
    }

    public static void main(String[] args) {
        printDups("geeksforgeeks");
    }
}