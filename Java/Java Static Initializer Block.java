//https://www.hackerrank.com/challenges/java-static-initializer-block/problem



//Write your code here
static Scanner scan = new Scanner(System.in);
static int B, H;
static boolean flag = true;

static { 
    B = scan.nextInt(); 
    H = scan.nextInt(); 
    try {
        if (B<=0 || H<= 0){
            flag = false;
            throw new Exception("Breadth and height must be positive");
        }
    }catch (Exception e){
        System.out.println(e);
    }
    
}

 
