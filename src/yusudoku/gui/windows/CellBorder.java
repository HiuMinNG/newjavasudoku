
package yusudoku.gui.windows;

/**
 *
 * @author nathan
 */
public class CellBorder {
    private static final int B = 3; //group borderwidth
    
    private static final int[] HAVERBORDER = new int[] {1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1,
                                                        1,1,B,1,1,B,1,1,1 };
    
    private static final int[] HAVELBORDER = new int[] {1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1,
                                                        1,1,1,B,1,1,B,1,1 };
    
    private static final int[] HAVETBORDER = new int[] {1,1,1,1,1,1,1,1,1,
                                                        1,1,1,1,1,1,1,1,1, 
                                                        1,1,1,1,1,1,1,1,1, 
                                                        B,B,B,B,B,B,B,B,B,
                                                        1,1,1,1,1,1,1,1,1, 
                                                        1,1,1,1,1,1,1,1,1, 
                                                        B,B,B,B,B,B,B,B,B,
                                                        1,1,1,1,1,1,1,1,1, 
                                                        1,1,1,1,1,1,1,1,1 };
    
    private static final int[] HAVEBBORDER = new int[] {1,1,1,1,1,1,1,1,1,
                                                        1,1,1,1,1,1,1,1,1,
                                                        B,B,B,B,B,B,B,B,B,
                                                        1,1,1,1,1,1,1,1,1,
                                                        1,1,1,1,1,1,1,1,1,
                                                        B,B,B,B,B,B,B,B,B,
                                                        1,1,1,1,1,1,1,1,1, 
                                                        1,1,1,1,1,1,1,1,1,
                                                        1,1,1,1,1,1,1,1,1 };
    
    public static int Right(int i){
        return HAVERBORDER[i];
    }
    
    public static  int Left(int i){
        return HAVELBORDER[i];
    }
    
    public static int Top(int i){
        return HAVETBORDER[i];
    }
    
    public static int Bottom(int i){
        return HAVEBBORDER[i];
    }
}
