import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class amazonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=2){
			System.out.println("Incorrect number of arguments");
			return;
		}
		
		int depth;
		try {
			depth=Integer.parseInt(args[1]);
	    } catch (NumberFormatException e) {
	        System.err.println("Second argument must be an integer");
	        return;
	    }
		if(depth<0){
			System.out.println("Depth can not be negative");
			return;
		}
		
		ArrayList<String> data=new ArrayList();
		String[] item;
		String root=null;
		
		try{
			BufferedReader input = new BufferedReader(new FileReader(args[0]));
			String s;
			s = input.readLine();
			while((s = input.readLine())!=null){ 

				data.add(s);
				item=s.split(",");
				if(item[0].equals("NULL")){
					root=new String(item[1]);
				}
			}
			if(root==null){
				System.out.println("No root node found in the file");
				input.close();
				return;
			}
//			System.out.println(root);	
			input.close();
		
		}catch (Exception e) {
			System.out.println(e);
			return;			
		}
		
		ArrayList<String> output=new ArrayList();
		output.add(root);
		
		int i,j,m;

		for(i=0;i<depth;i++){	
			
			int length=output.size();
			
			for(j=0;j<length;j++){
				
				for(m=0;m<data.size();m++){
					item=data.get(m).split(",");
					if(item[0].equals(output.get(0))){
						output.add(item[1]);
					}
				}
				output.remove(0);
			}
			if(output.size()==0){
				System.out.println("The depth can not be bigger than "+(i)+", the max depth of the tree");
				return;
			}

		}
		Collections.sort(output);
		for(i=0;i<output.size();i++){
			System.out.println(output.get(i));
		}

	}

}
