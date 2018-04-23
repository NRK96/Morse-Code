/*Name: Nicholas Keen
 *Course: Computer Science II - CIS 203
 *Assignment: 10
 *Due: May 8 2015
*/


public class MorseCode {
    private static TreeNode<Character> codeTree = MorseCode.buildTree();

    //Returns: a char - The letter that has been decoded
    //Parameter: s - A string that is coded
    public static char getLetter(String s){
        //A variable used in the helper method
        int i = 0;
        return getLetter(codeTree, s, i);
    }
    
    //A private helper method for getLetter 
    private static char getLetter(TreeNode<Character> root, String s, int i){
        //Checks to see if we are at the end of the string
        if(i == s.length()){
            //Returns the appropriate letter
            return root.data;
        //If its a '-' we go to the right of the tree
        }else if(s.charAt(i) == '-'){
            i++;
            return getLetter(root.right, s, i);
        //If its a '.' we go to the left of the tree
        }else if(s.charAt(i) == '.'){
            i++;
            return getLetter(root.left, s, i);
        }
        //Dummy value to satisfy the return requirement
        return root.data;
    }


    // Returns: a binary tree that represents the Morse code for the Roman
    //          alphabet
    private static TreeNode<Character> buildTree () {
        // build left half
        TreeNode<Character> s =  new TreeNode<Character>('S', 
                                 new TreeNode<Character>('H'),
                                 new TreeNode<Character>('V'));

        TreeNode<Character> u =  new TreeNode<Character>('U', 
                                 new TreeNode<Character>('F'),
                                 null);
                                 
        TreeNode<Character> i =  new TreeNode<Character>('I', s, u);

        TreeNode<Character> r =  new TreeNode<Character>('R', 
                                 new TreeNode<Character>('L'), 
                                 null);

        TreeNode<Character> w =  new TreeNode<Character>('W', 
                                 new TreeNode<Character>('P'),
                                 new TreeNode<Character>('J'));

        TreeNode<Character> a =  new TreeNode<Character>('A', r, w);

        TreeNode<Character> e =  new TreeNode<Character>('E', i, a);

        // build right half
        TreeNode<Character> d =  new TreeNode<Character>('D', 
                                 new TreeNode<Character>('B'),
                                 new TreeNode<Character>('X'));

        TreeNode<Character> k =  new TreeNode<Character>('K', 
                                 new TreeNode<Character>('C'),
                                 new TreeNode<Character>('Y'));

        TreeNode<Character> n =  new TreeNode<Character>('N', d, k);


        TreeNode<Character> g =  new TreeNode<Character>('G', 
                                 new TreeNode<Character>('Z'),
                                 new TreeNode<Character>('Q'));

        TreeNode<Character> o =  new TreeNode<Character>('O');

        TreeNode<Character> m =  new TreeNode<Character>('M', g, o);

        TreeNode<Character> t =  new TreeNode<Character>('T', n, m);

        // build the root
        TreeNode<Character> root =  new TreeNode<Character>(null, e, t);
        return root;
    }
}